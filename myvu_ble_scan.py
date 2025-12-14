import argparse
import asyncio
import json
from pathlib import Path
from typing import Dict, List, Optional, Tuple

from bleak import BleakScanner

APPLE_MANUFACTURER_ID = 0x004C


def _to_hex(payload: object) -> str:
    if isinstance(payload, (bytes, bytearray)):
        return payload.hex()
    return str(payload)


def format_manufacturer_data(data: dict) -> str:
    parts: List[str] = []
    for m_id, payload in sorted(data.items(), key=lambda kv: kv[0]):
        payload_hex = _to_hex(payload)
        parts.append(f"0x{m_id:04X}:{payload_hex}")
    return ", ".join(parts)


def _extract_fields(device, adv_data=None):
    """Normalize Bleak discovery outputs.

    On macOS with ``return_adv=True`` Bleak may return ``(address, AdvertisementData)``
    where the first element is already a string address (e.g. Swift.__StringStorage).
    This helper accepts both the legacy Device object and the string form.
    """

    address = getattr(device, "address", None)
    if address is None and isinstance(device, str):
        address = device

    metadata = getattr(device, "metadata", {}) or {}
    uuids = metadata.get("uuids", []) or []
    manufacturer_data = metadata.get("manufacturer_data", {}) or {}
    rssi = getattr(device, "rssi", None)
    name = getattr(device, "name", None)

    if adv_data is not None:
        uuids = adv_data.service_uuids or uuids
        manufacturer_data = adv_data.manufacturer_data or manufacturer_data
        adv_rssi = getattr(adv_data, "rssi", None)
        rssi = adv_rssi if adv_rssi is not None else rssi
        name = getattr(adv_data, "local_name", None) or name

    return (
        address or "",
        name or "",
        rssi if rssi is not None else 0,
        uuids,
        manufacturer_data,
    )


def _passes_filters(
    entry: Tuple[str, str, int, List[str], dict],
    service_filter: Optional[str],
    name_prefix: Optional[str],
    manufacturer_id: Optional[int],
    manufacturer_prefix_hex: Optional[str],
    min_rssi: Optional[int],
) -> bool:
    _, name, rssi, uuids, manufacturer_data = entry
    if service_filter:
        uuids_lower = {u.lower() for u in uuids}
        if service_filter.lower() not in uuids_lower:
            return False
    if name_prefix and not name.lower().startswith(name_prefix.lower()):
        return False
    if min_rssi is not None and rssi < min_rssi:
        return False
    if manufacturer_id is not None and manufacturer_id not in manufacturer_data:
        return False
    if manufacturer_prefix_hex:
        prefix = manufacturer_prefix_hex.lower()
        found_prefix = False
        for payload in manufacturer_data.values():
            if _to_hex(payload).lower().startswith(prefix):
                found_prefix = True
                break
        if not found_prefix:
            return False
    return True


async def scan_once(
    timeout: float = 10.0,
    service_filter: Optional[str] = None,
    name_prefix: Optional[str] = None,
    manufacturer_id: Optional[int] = None,
    manufacturer_prefix_hex: Optional[str] = None,
    min_rssi: Optional[int] = None,
) -> List[Tuple[str, str, int, List[str], dict]]:
    try:
        devices = await BleakScanner.discover(timeout=timeout, return_adv=True)
    except TypeError:
        devices = await BleakScanner.discover(timeout=timeout)
    results: List[Tuple[str, str, int, List[str], dict]] = []
    for dev in devices:
        if isinstance(dev, tuple) and len(dev) == 2:
            device, adv = dev
            entry = _extract_fields(device, adv)
        else:
            entry = _extract_fields(dev)
        if _passes_filters(entry, service_filter, name_prefix, manufacturer_id, manufacturer_prefix_hex, min_rssi):
            results.append(entry)
    results.sort(key=lambda d: d[2] if d[2] is not None else -999, reverse=True)
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
                "payload_hex": _to_hex(payload),
                "service_uuids": uuids,
            }
            payloads.append(entry)
    output.write_text(json.dumps(payloads, indent=2), encoding="utf-8")
    print(f"Saved {len(payloads)} manufacturer payloads to {output}")


def main() -> None:
    parser = argparse.ArgumentParser(description="Scan for BLE devices and capture advertising")
    parser.add_argument("--timeout", type=float, default=10.0, help="Scan duration in seconds")
    parser.add_argument("--service", help="Filter by service UUID")
    parser.add_argument("--name-prefix", help="Filter by device name prefix")
    parser.add_argument("--manufacturer-id", type=lambda x: int(x, 0), help="Filter by manufacturer id")
    parser.add_argument(
        "--manufacturer-prefix-hex",
        help="Filter by manufacturer payload prefix (hex string)",
    )
    parser.add_argument("--min-rssi", type=int, help="Minimum RSSI to include")
    parser.add_argument("--save-manufacturer", type=Path, help="Optional path to save manufacturer payloads as JSON")
    args = parser.parse_args()

    results = asyncio.run(
        scan_once(
            timeout=args.timeout,
            service_filter=args.service,
            name_prefix=args.name_prefix,
            manufacturer_id=args.manufacturer_id,
            manufacturer_prefix_hex=args.manufacturer_prefix_hex,
            min_rssi=args.min_rssi,
        )
    )
    print_results(results)
    if args.save_manufacturer:
        save_manufacturer_payloads(results, args.save_manufacturer)


if __name__ == "__main__":
    main()
