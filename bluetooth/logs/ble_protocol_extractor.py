#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
BLE Protocol Extractor for tshark -T json dumps (ATT only).
Input: glasses_att.json (output of: tshark ... -Y "... && btatt" -T json)
Output:
  - report.md
  - protocol.yaml (draft)
  - commands.csv (clusters by handle+prefix)
  - pairs.csv (tx->rx best match)
"""

import json
import csv
import sys
import math
from collections import Counter, defaultdict
from dataclasses import dataclass
from typing import Any, Dict, List, Optional, Tuple

# ---- helpers ----

def get_first(x, default=None):
    if x is None:
        return default
    if isinstance(x, list):
        return x[0] if x else default
    return x

def norm_hex_value(v: str) -> str:
    # tshark sometimes uses "aa:bb:cc" and sometimes "aabbcc"
    if not v:
        return ""
    v = v.strip()
    v = v.replace(":", "").replace(" ", "").lower()
    # keep only hex chars
    v = "".join(ch for ch in v if ch in "0123456789abcdef")
    return v

def hex_bytes(v: str) -> List[int]:
    v = norm_hex_value(v)
    return [int(v[i:i+2], 16) for i in range(0, len(v), 2)] if len(v) % 2 == 0 else []

def is_probably_cccd_write(payload_hex: str) -> bool:
    # Common CCCD values: 0100 (notify) or 0200 (indicate) little-endian
    p = norm_hex_value(payload_hex)
    return p in ("0100", "0200", "0000")

def opcode_name(op: str) -> str:
    # ATT opcodes of interest
    m = {
        "0x02": "EXCHANGE_MTU_RESP",
        "0x03": "EXCHANGE_MTU_REQ",
        "0x08": "READ_BY_TYPE_REQ",
        "0x09": "READ_BY_TYPE_RESP",
        "0x0a": "READ_REQ",
        "0x0b": "READ_RESP",
        "0x10": "READ_BY_GROUP_TYPE_REQ",
        "0x11": "READ_BY_GROUP_TYPE_RESP",
        "0x12": "WRITE_REQ",
        "0x13": "WRITE_RESP",
        "0x16": "PREP_WRITE_REQ",
        "0x17": "PREP_WRITE_RESP",
        "0x18": "EXEC_WRITE_REQ",
        "0x19": "EXEC_WRITE_RESP",
        "0x1b": "NOTIFY",
        "0x1d": "INDICATE",
        "0x1e": "CONFIRM",
        "0x52": "WRITE_CMD",
        "0x01": "ERROR_RESP",
    }
    return m.get(op, op)

@dataclass
class Row:
    frame: int
    t: float
    dir_hex: str
    chandle: str
    opcode: str
    att_handle: Optional[str]
    uuid16: Optional[str]
    value_hex: str
    req_in_frame: Optional[int]

def parse_rows(path: str) -> List[Row]:
    with open(path, "r", encoding="utf-8") as f:
        data = json.load(f)

    rows: List[Row] = []
    for pkt in data:
        layers = pkt.get("_source", {}).get("layers", {})
        if "btatt" not in layers:
            continue

        frame = layers.get("frame", {})
        bthci_acl = layers.get("bthci_acl", {})
        btatt = layers.get("btatt", {})

        frame_no = int(get_first(frame.get("frame.number"), "0"))
        t_rel = float(get_first(frame.get("frame.time_relative"), "0"))

        # direction may be in hci_h4.direction (0x00/0x01)
        hci_h4 = layers.get("hci_h4", {})
        dir_hex = get_first(hci_h4.get("hci_h4.direction"), "?")

        chandle = get_first(bthci_acl.get("bthci_acl.chandle"), "")

        opcode = get_first(btatt.get("btatt.opcode"), "")

        att_handle = None
        uuid16 = None
        value = ""

        # Many responses contain btatt.attribute_data with handle+value
        if "btatt.attribute_data" in btatt:
            ad = btatt["btatt.attribute_data"]
            att_handle = get_first(ad.get("btatt.handle"))
            # sometimes uuid16 nested
            htree = ad.get("btatt.handle_tree", {})
            uuid16 = get_first(htree.get("btatt.uuid16")) or get_first(btatt.get("btatt.uuid16"))
            value = get_first(ad.get("btatt.value"), "")
        else:
            # Write requests often have btatt.handle + btatt.value at top level
            att_handle = get_first(btatt.get("btatt.handle"))
            uuid16 = get_first(btatt.get("btatt.uuid16"))
            value = get_first(btatt.get("btatt.value"), "")

        value_hex = norm_hex_value(value)

        req_in = btatt.get("btatt.request_in_frame")
        req_in_frame = int(get_first(req_in)) if req_in is not None else None

        rows.append(Row(
            frame=frame_no,
            t=t_rel,
            dir_hex=dir_hex,
            chandle=chandle,
            opcode=opcode,
            att_handle=att_handle,
            uuid16=uuid16,
            value_hex=value_hex,
            req_in_frame=req_in_frame
        ))

    rows.sort(key=lambda r: r.frame)
    return rows

# ---- analysis ----

def pick_main_chandle(rows: List[Row]) -> str:
    c = Counter(r.chandle for r in rows if r.chandle)
    return c.most_common(1)[0][0] if c else ""

def summarize_handles(rows: List[Row]) -> List[Tuple[str, int, float]]:
    c = Counter(r.att_handle for r in rows if r.att_handle)
    total = sum(c.values()) or 1
    return [(h, cnt, cnt/total) for h, cnt in c.most_common()]

def find_notify_handles(rows: List[Row]) -> List[str]:
    c = Counter(r.att_handle for r in rows if r.att_handle and opcode_name(r.opcode) == "NOTIFY")
    return [h for h, _ in c.most_common()]

def find_write_handles(rows: List[Row]) -> List[str]:
    c = Counter(r.att_handle for r in rows if r.att_handle and opcode_name(r.opcode) in ("WRITE_REQ", "WRITE_CMD", "PREP_WRITE_REQ"))
    return [h for h, _ in c.most_common()]

def guess_message_prefixes(rows: List[Row], handle: str, direction: str, max_prefix=6) -> Dict[int, Counter]:
    # returns Counter of prefix bytes for prefix length 1..max_prefix
    out: Dict[int, Counter] = {}
    for n in range(1, max_prefix+1):
        out[n] = Counter()

    for r in rows:
        if r.att_handle != handle:
            continue
        if r.dir_hex != direction:
            continue
        if not r.value_hex:
            continue
        b = hex_bytes(r.value_hex)
        for n in range(1, max_prefix+1):
            if len(b) >= n:
                out[n][tuple(b[:n])] += 1
    return out

def detect_seq_field(rows: List[Row], handle: str, direction: str, max_pos=6) -> List[Tuple[int, float]]:
    # heuristic: a seq field changes often and is roughly uniform; score by uniqueness ratio
    vals: Dict[int, List[int]] = {i: [] for i in range(max_pos)}
    for r in rows:
        if r.att_handle != handle or r.dir_hex != direction or not r.value_hex:
            continue
        b = hex_bytes(r.value_hex)
        for i in range(min(max_pos, len(b))):
            vals[i].append(b[i])

    scores = []
    for i, arr in vals.items():
        if len(arr) < 20:
            continue
        uniq = len(set(arr))
        ratio = uniq / max(1, len(arr))
        # too low => constant, too high => maybe random payload. Prefer mid-high but not ~1.0
        score = ratio * (1.0 - abs(ratio - 0.25))  # peak near 0.25
        scores.append((i, score))
    scores.sort(key=lambda x: x[1], reverse=True)
    return scores[:3]

def pair_tx_rx(rows: List[Row], tx_handle: str, rx_handles: List[str], max_dt=0.8) -> List[Tuple[Row, Row]]:
    """
    Pair TX writes to the nearest RX notify/indicate after it within max_dt seconds.
    If multiple, pick earliest.
    """
    tx_ops = {"WRITE_REQ", "WRITE_CMD", "PREP_WRITE_REQ"}
    rx_ops = {"NOTIFY", "INDICATE", "READ_RESP", "WRITE_RESP", "ERROR_RESP"}

    tx = [r for r in rows if r.att_handle == tx_handle and opcode_name(r.opcode) in tx_ops and r.value_hex]
    rx = [r for r in rows if r.att_handle in set(rx_handles) and opcode_name(r.opcode) in rx_ops and r.value_hex]

    rx_i = 0
    pairs = []
    for trow in tx:
        # advance rx pointer to just after tx time
        while rx_i < len(rx) and rx[rx_i].t < trow.t:
            rx_i += 1
        best = None
        j = rx_i
        while j < len(rx) and (rx[j].t - trow.t) <= max_dt:
            best = rx[j]
            break
        if best:
            pairs.append((trow, best))
    return pairs

def cluster_by_prefix(rows: List[Row], handle: str, direction: str, prefix_len: int = 2) -> Counter:
    c = Counter()
    for r in rows:
        if r.att_handle != handle or r.dir_hex != direction or not r.value_hex:
            continue
        b = hex_bytes(r.value_hex)
        if len(b) >= prefix_len:
            c[tuple(b[:prefix_len])] += 1
    return c

def write_csv(path: str, header: List[str], lines: List[Dict[str, Any]]):
    with open(path, "w", newline="", encoding="utf-8") as f:
        w = csv.DictWriter(f, fieldnames=header)
        w.writeheader()
        for ln in lines:
            w.writerow(ln)

def main():
    if len(sys.argv) < 2:
        print("Usage: python ble_protocol_extractor.py glasses_att.json")
        sys.exit(2)

    in_path = sys.argv[1]
    rows = parse_rows(in_path)
    if not rows:
        print("No btatt rows found. Did you export with -Y '... && btatt' ?")
        sys.exit(1)

    ch = pick_main_chandle(rows)

    # handle stats
    handle_stats = summarize_handles(rows)
    write_handles = find_write_handles(rows)
    notify_handles = find_notify_handles(rows)

    # pick candidates
    tx_handle = write_handles[0] if write_handles else (handle_stats[0][0] if handle_stats else None)
    rx_handles = notify_handles[:3] if notify_handles else []

    # prefix clustering
    tx_prefixes = cluster_by_prefix(rows, tx_handle, direction="0x00", prefix_len=2) if tx_handle else Counter()
    rx_prefixes = cluster_by_prefix(rows, rx_handles[0], direction="0x01", prefix_len=2) if rx_handles else Counter()

    # seq guess
    seq_guess = detect_seq_field(rows, tx_handle, direction="0x00", max_pos=8) if tx_handle else []

    # pairs
    pairs = pair_tx_rx(rows, tx_handle=tx_handle, rx_handles=rx_handles or [tx_handle], max_dt=0.8) if tx_handle else []

    # CCCD guess: look for writes with payload 0100/0200/0000 on some handle
    cccd_writes = []
    for r in rows:
        if opcode_name(r.opcode) in ("WRITE_REQ", "WRITE_CMD") and r.value_hex and is_probably_cccd_write(r.value_hex):
            cccd_writes.append(r)

    # commands.csv: show top prefixes for TX handle
    cmd_lines = []
    for pref, cnt in tx_prefixes.most_common(50):
        cmd_lines.append({
            "tx_handle": tx_handle,
            "prefix_len": 2,
            "prefix_hex": "".join(f"{b:02x}" for b in pref),
            "count": cnt
        })
    if cmd_lines:
        write_csv("commands.csv", ["tx_handle","prefix_len","prefix_hex","count"], cmd_lines)

    # pairs.csv
    pair_lines = []
    for trow, rrow in pairs[:2000]:
        pair_lines.append({
            "t_frame": trow.frame,
            "t_time": trow.t,
            "t_opcode": opcode_name(trow.opcode),
            "t_handle": trow.att_handle,
            "t_value": trow.value_hex,
            "r_frame": rrow.frame,
            "r_time": rrow.t,
            "r_opcode": opcode_name(rrow.opcode),
            "r_handle": rrow.att_handle,
            "r_value": rrow.value_hex,
            "dt": f"{(rrow.t - trow.t):.6f}"
        })
    if pair_lines:
        write_csv("pairs.csv",
                  ["t_frame","t_time","t_opcode","t_handle","t_value","r_frame","r_time","r_opcode","r_handle","r_value","dt"],
                  pair_lines)

    # report.md
    with open("report.md", "w", encoding="utf-8") as f:
        f.write("# BLE Protocol Reverse Report (draft)\n\n")
        f.write(f"- Rows parsed: **{len(rows)}**\n")
        f.write(f"- Main connection handle: **{ch or 'unknown'}**\n\n")

        f.write("## Top ATT attribute handles by frequency\n")
        f.write("| att_handle | count | share |\n|---:|---:|---:|\n")
        for h, cnt, share in handle_stats[:20]:
            f.write(f"| {h} | {cnt} | {share:.3f} |\n")
        f.write("\n")

        f.write("## Candidate channels\n")
        f.write(f"- TX (writes) candidate handle: **{tx_handle}**\n")
        f.write(f"- RX (notify) candidate handles: **{', '.join(rx_handles) if rx_handles else 'none detected'}**\n\n")

        f.write("## CCCD-like writes (notify/indicate enable)\n")
        if not cccd_writes:
            f.write("- Not detected by simple heuristic (payload 0100/0200/0000). Could be encrypted or different pattern.\n\n")
        else:
            f.write("| frame | time | dir | opcode | handle | value |\n|---:|---:|---:|---:|---:|---|\n")
            for r in cccd_writes[:30]:
                f.write(f"| {r.frame} | {r.t:.6f} | {r.dir_hex} | {opcode_name(r.opcode)} | {r.att_handle} | {r.value_hex} |\n")
            f.write("\n")

        f.write("## TX prefix clusters (first 2 bytes)\n")
        if not tx_prefixes:
            f.write("- No TX prefixes found (no btatt.value on write handle?)\n\n")
        else:
            f.write("| prefix | count |\n|---:|---:|\n")
            for pref, cnt in tx_prefixes.most_common(20):
                f.write(f"| {''.join(f'{b:02x}' for b in pref)} | {cnt} |\n")
            f.write("\n")

        f.write("## Sequence field guess (TX payload positions)\n")
        if not seq_guess:
            f.write("- Not enough data to guess.\n\n")
        else:
            for pos, score in seq_guess:
                f.write(f"- pos **{pos}** score **{score:.3f}**\n")
            f.write("\n")

        f.write("## TX→RX pairing (nearest response within 0.8s)\n")
        f.write(f"- Pairs found: **{len(pairs)}** (saved to `pairs.csv`)\n\n")

    # protocol.yaml draft
    yaml = []
    yaml.append("connection:")
    yaml.append(f"  chandle: {ch or 'unknown'}")
    yaml.append("")
    yaml.append("channels:")
    yaml.append(f"  tx_handle: {tx_handle or 'unknown'}")
    yaml.append(f"  rx_handles: {rx_handles if rx_handles else []}")
    yaml.append("")
    yaml.append("message_hypothesis:")
    yaml.append("  # Based on prefix clustering + seq heuristic. Validate with more samples.")
    yaml.append("  tx_prefix_len: 2")
    yaml.append("  seq_field_candidates:")
    yaml.append("    " + (str([{"pos": p, "score": round(s,3)} for p,s in seq_guess]) if seq_guess else "[]"))
    yaml.append("")
    yaml.append("commands_draft:")
    # list top prefixes as pseudo command ids
    for pref, cnt in tx_prefixes.most_common(15):
        yaml.append(f"  - id_prefix_hex: \"{''.join(f'{b:02x}' for b in pref)}\"")
        yaml.append(f"    seen: {cnt}")
        yaml.append("    name: \"unknown\"")
    yaml.append("")

    with open("protocol.yaml", "w", encoding="utf-8") as f:
        f.write("\n".join(yaml))

    print("Done:")
    print(" - report.md")
    print(" - protocol.yaml (draft)")
    print(" - commands.csv")
    print(" - pairs.csv")

if __name__ == "__main__":
    main()
