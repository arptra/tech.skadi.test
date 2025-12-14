import argparse
import asyncio
from typing import List, Tuple

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


def main() -> None:
    parser = argparse.ArgumentParser(description="Scan for Myvu BLE devices")
    parser.add_argument("--timeout", type=float, default=10.0, help="Scan duration in seconds")
    args = parser.parse_args()
    results = asyncio.run(scan_once(timeout=args.timeout))
    print_results(results)


if __name__ == "__main__":
    main()
