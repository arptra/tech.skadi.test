#!/usr/bin/env python3
import argparse
import json
from pathlib import Path
from typing import Iterable, List


def load_packets(path: Path) -> List[dict]:
    with path.open('r', encoding='utf-8') as f:
        return json.load(f)


def direction_label(entry: dict) -> str:
    h4_dir = entry.get('hci_h4', {}).get('hci_h4.direction')
    if h4_dir == '0x00':
        return 'host->ctrl'
    if h4_dir == '0x01':
        return 'ctrl->host'
    frame_dir = entry.get('frame', {}).get('frame.p2p_dir')
    if frame_dir == '0':
        return 'out'
    if frame_dir == '1':
        return 'in'
    return '?'


def format_entry(entry: dict) -> str:
    layers = entry['_source']['layers']
    frame = layers.get('frame', {})
    btatt = layers.get('btatt')
    btl2 = layers.get('btl2cap')
    opcode = ''
    handle = ''
    value = ''
    if btatt:
        opcode = btatt.get('btatt.opcode', '')
        handle = btatt.get('btatt.handle', btatt.get('btatt.starting_handle', ''))
        value = btatt.get('btatt.value', btatt.get('btatt.value_handle', ''))
    if not value and btl2 and 'btl2cap.data' in btl2:
        value = btl2['btl2cap.data']
    return "{num:>6} {time} {dir} opcode={opc} handle={hdl} value={val}".format(
        num=frame.get('frame.number', '?'),
        time=frame.get('frame.time_relative', '?'),
        dir=direction_label(layers),
        opc=opcode,
        hdl=handle,
        val=value,
    )


def iter_matches(packets: List[dict], *, payload_hex: str = None, opcode: str = None) -> Iterable[int]:
    payload_hex = payload_hex.lower() if payload_hex else None
    for idx, entry in enumerate(packets):
        layers = entry['_source']['layers']
        btatt = layers.get('btatt') or {}
        if opcode and btatt.get('btatt.opcode') != opcode:
            continue
        val = btatt.get('btatt.value') or ''
        val = val.replace(':', '').lower()
        if payload_hex and payload_hex not in val:
            continue
        yield idx


def main():
    parser = argparse.ArgumentParser(description="Filter BLE HCI/ATT logs exported from Wireshark JSON")
    parser.add_argument('log', type=Path, help='Path to full_log.json')
    parser.add_argument('--payload-substr', help='Hex substring (no spaces) to search for in btatt.value')
    parser.add_argument('--opcode', help='Filter by btatt.opcode (e.g., 0x52)')
    parser.add_argument('--window', type=int, default=0, help='Number of packets of context before/after each match')
    args = parser.parse_args()

    packets = load_packets(args.log)
    indices = list(iter_matches(packets, payload_hex=args.payload_substr, opcode=args.opcode))
    if not indices:
        print('No matches found')
        return

    printed = set()
    for idx in indices:
        start = max(0, idx - args.window)
        end = min(len(packets), idx + args.window + 1)
        for i in range(start, end):
            if i in printed:
                continue
            printed.add(i)
            print(format_entry(packets[i]))
        if args.window:
            print('-' * 80)


if __name__ == '__main__':
    main()
