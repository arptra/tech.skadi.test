#!/usr/bin/env python3
import json
import csv
from dataclasses import dataclass
from typing import Any, Dict, List, Optional, Tuple

# ---- config (под себя) ----
HANDLES = {"0x0023", "0x0026"}
OPCODES = {"0x52", "0x1b", "0x12"}  # write cmd, notify, write req (CCCD)
# ---------------------------

def deep_get(d: Dict[str, Any], *keys: str) -> Optional[Any]:
    cur: Any = d
    for k in keys:
        if not isinstance(cur, dict):
            return None
        cur = cur.get(k)
    return cur

def hex_to_bytes(v: str) -> bytes:
    # tshark отдаёт "aa:bb:cc", приводим к bytes
    v = v.replace(":", "").strip().lower()
    if not v:
        return b""
    return bytes.fromhex(v)

def try_extract_json(payload: bytes) -> Optional[Any]:
    i = payload.find(b"{")
    if i < 0:
        return None
    tail = payload[i:]
    try:
        s = tail.decode("utf-8", errors="strict")
    except UnicodeDecodeError:
        s = tail.decode("utf-8", errors="ignore")

    # обрезаем до последней }
    j = s.rfind("}")
    if j >= 0:
        s = s[: j + 1]

    try:
        return json.loads(s)
    except Exception:
        # иногда удобно хотя бы строку сохранить
        return {"_raw_json_string": s}

@dataclass
class Packet:
    frame_no: int
    t_rel: float
    direction: str   # "0x00" phone->glasses, "0x01" glasses->phone
    opcode: str
    handle: str
    value_bytes: bytes  # btatt.value

def load_packets(path: str) -> List[Packet]:
    data = json.load(open(path, "r", encoding="utf-8"))
    out: List[Packet] = []

    for obj in data:
        layers = deep_get(obj, "_source", "layers") or {}
        frame_no = int(deep_get(layers, "frame", "frame.number") or 0)
        t_rel = float(deep_get(layers, "frame", "frame.time_relative") or 0.0)
        direction = deep_get(layers, "hci_h4", "hci_h4.direction") or ""
        btatt = layers.get("btatt") or {}
        opcode = btatt.get("btatt.opcode") or ""
        handle = btatt.get("btatt.handle") or ""
        value = btatt.get("btatt.value") or ""

        if opcode not in OPCODES:
            continue
        if handle and handle not in HANDLES:
            # CCCD/служебку можно тоже добавлять при желании
            continue
        if not value:
            # например Write Request на CCCD может быть без btatt.value,
            # но там есть btatt.characteristic_configuration_client — это отдельно можно логировать
            continue

        out.append(
            Packet(
                frame_no=frame_no,
                t_rel=t_rel,
                direction=direction,
                opcode=opcode,
                handle=handle,
                value_bytes=hex_to_bytes(value),
            )
        )

    out.sort(key=lambda p: p.frame_no)
    return out

@dataclass
class Message:
    direction: str
    handle: str
    opcode: str
    start_frame: int
    end_frame: int
    frames: List[int]
    payload: bytes       # склеенный payload БЕЗ 2 байт индекса фрагмента
    json_obj: Optional[Any]

def reassemble_messages(packets: List[Packet]) -> List[Message]:
    msgs: List[Message] = []
    cur: Optional[Tuple[str, str, str, int, List[int], List[bytes]]] = None
    # (direction, handle, opcode, start_frame, frames[], chunks[])

    def flush():
        nonlocal cur
        if not cur:
            return
        direction, handle, opcode, start_frame, frames, chunks = cur
        payload = b"".join(chunks)
        msgs.append(
            Message(
                direction=direction,
                handle=handle,
                opcode=opcode,
                start_frame=start_frame,
                end_frame=frames[-1],
                frames=frames[:],
                payload=payload,
                json_obj=try_extract_json(payload),
            )
        )
        cur = None

    last_idx_by_stream: Dict[Tuple[str, str, str], int] = {}

    for p in packets:
        if len(p.value_bytes) < 2:
            continue

        idx = int.from_bytes(p.value_bytes[:2], "little")
        chunk = p.value_bytes[2:]
        stream = (p.direction, p.handle, p.opcode)

        if idx == 0:
            flush()
            cur = (p.direction, p.handle, p.opcode, p.frame_no, [p.frame_no], [chunk])
            last_idx_by_stream[stream] = 0
            continue

        # продолжение: если нет cur (потеряли начало) — создадим “orphan”
        if cur is None or (cur[0], cur[1], cur[2]) != stream:
            flush()
            cur = (p.direction, p.handle, p.opcode, p.frame_no, [p.frame_no], [chunk])
            last_idx_by_stream[stream] = idx
            continue

        cur[4].append(p.frame_no)
        cur[5].append(chunk)
        last_idx_by_stream[stream] = idx

    flush()
    return msgs

def main():
    import argparse

    ap = argparse.ArgumentParser()
    ap.add_argument("input_json", help="tshark -T json output")
    ap.add_argument("--out-jsonl", default="timeline.jsonl")
    ap.add_argument("--out-csv", default="timeline.csv")
    args = ap.parse_args()

    packets = load_packets(args.input_json)
    msgs = reassemble_messages(packets)

    # write jsonl
    with open(args.out_jsonl, "w", encoding="utf-8") as f:
        for m in msgs:
            rec = {
                "direction": m.direction,
                "handle": m.handle,
                "opcode": m.opcode,
                "start_frame": m.start_frame,
                "end_frame": m.end_frame,
                "frames": m.frames,
                "len": len(m.payload),
                "has_json": m.json_obj is not None,
                "json": m.json_obj,
                "payload_hex_prefix": m.payload[:32].hex(),
            }
            f.write(json.dumps(rec, ensure_ascii=False) + "\n")

    # write csv (короткая сводка)
    with open(args.out_csv, "w", newline="", encoding="utf-8") as f:
        w = csv.writer(f)
        w.writerow(["dir", "handle", "opcode", "start_frame", "end_frame", "len", "action", "subaction"])
        for m in msgs:
            action = ""
            subaction = ""
            if isinstance(m.json_obj, dict):
                action = str(m.json_obj.get("action", ""))
                if action == "system" and isinstance(m.json_obj.get("data"), dict):
                    subaction = str(m.json_obj["data"].get("action", ""))
            w.writerow([m.direction, m.handle, m.opcode, m.start_frame, m.end_frame, len(m.payload), action, subaction])

    # console stats
    actions: Dict[str, int] = {}
    for m in msgs:
        if isinstance(m.json_obj, dict) and "action" in m.json_obj:
            a = str(m.json_obj.get("action"))
            actions[a] = actions.get(a, 0) + 1

    print(f"Packets: {len(packets)}")
    print(f"Messages reassembled: {len(msgs)}")
    print("Top actions:")
    for k, v in sorted(actions.items(), key=lambda kv: kv[1], reverse=True)[:20]:
        print(f"  {k}: {v}")

if __name__ == "__main__":
    main()
