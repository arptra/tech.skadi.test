import argparse
import asyncio
import json
from pathlib import Path
from typing import Dict, List, Tuple

from bleak import BleakScanner

APPLE_MANUFACTURER_ID = 0x004C


def format_manufacturer_data(data: dict) -> str:
    parts: List[str] = []
    for m_id, payload in data.items():
        payload_hex = payload.hex() if isinstance(payload, (bytes, bytearray)) else str(payload)
        parts.append(f"0x{m_id:04X}:{payload_hex}")
    return ", ".join(parts)


async def scan_once(timeout: float = 10.0) -> List[Tuple[str, str, int, List[str], dict]]:
    devices = await BleakScanner.discover(timeout=timeout)
    results = []
    for dev in devices:
        results.append(
            (
                dev.address,
                dev.name or "",
                dev.rssi or 0,
                getattr(dev, "metadata", {}).get("uuids", []) or [],
                getattr(dev, "metadata", {}).get("manufacturer_data", {}) or {},
            )
        )
    return results


def print_results(results: List[Tuple[str, str, int, List[str], dict]]) -> None:
    for address, name, rssi, uuids, manufacturer_data in results:
        print(f"{address} | {name} | RSSI {rssi}")
        if uuids:
            print(f"  service_uuids: {', '.join(uuids)}")
        if manufacturer_data:
            print(f"  manufacturer_data: {format_manufacturer_data(manufacturer_data)}")
        print()


def save_manufacturer_payloads(results: List[Tuple[str, str, int, List[str], dict]], output: Path) -> None:
    payloads: List[Dict[str, object]] = []
    for address, name, rssi, uuids, manufacturer_data in results:
        if not manufacturer_data:
            continue
        for m_id, payload in manufacturer_data.items():
            entry: Dict[str, object] = {
                "address": address,
                "name": name,
                "rssi": rssi,
                "manufacturer_id": m_id,
                "payload_hex": payload.hex() if isinstance(payload, (bytes, bytearray)) else str(payload),
                "service_uuids": uuids,
            }
            payloads.append(entry)
    output.write_text(json.dumps(payloads, indent=2), encoding="utf-8")
    print(f"Saved {len(payloads)} manufacturer payloads to {output}")


def main() -> None:
    parser = argparse.ArgumentParser(description="Scan for BLE devices and capture advertising")
    parser.add_argument("--timeout", type=float, default=10.0, help="Scan duration in seconds")
    parser.add_argument("--save-manufacturer", type=Path, help="Optional path to save manufacturer payloads as JSON")
    args = parser.parse_args()
    results = asyncio.run(scan_once(timeout=args.timeout))
    print_results(results)
    if args.save_manufacturer:
        save_manufacturer_payloads(results, args.save_manufacturer)


if __name__ == "__main__":
    main()
