import argparse
import asyncio
import json
from pathlib import Path
from typing import Any, Dict, Iterable, List, Optional, Set, Tuple

from bleak import BleakClient

from myvu_ble_scan import APPLE_MANUFACTURER_ID, print_results, scan_once


def load_protocol(protocol_path: Path) -> Dict[str, Any]:
    with protocol_path.open("r", encoding="utf-8") as f:
        return json.load(f)


def _to_hex(payload: object) -> str:
    if isinstance(payload, (bytes, bytearray)):
        return payload.hex()
    return str(payload)


def _matches_device_filter(entry: Tuple[str, str, int, List[str], dict], device_filter: Dict[str, Any]) -> bool:
    address, name, rssi, uuids, manufacturer_data = entry
    avoid_ids = set(device_filter.get("avoid_manufacturer_ids", []))
    if avoid_ids and any(m in avoid_ids for m in manufacturer_data):
        return False

    manufacturer_ids = device_filter.get("manufacturer_ids") or []
    if manufacturer_ids and not any(m in manufacturer_ids for m in manufacturer_data):
        return False

    prefix_list: Iterable[str] = device_filter.get("manufacturer_prefix_hex") or []
    if prefix_list:
        matched_prefix = False
        for payload in manufacturer_data.values():
            payload_hex = _to_hex(payload)
            for prefix in prefix_list:
                if payload_hex.lower().startswith(prefix.lower()):
                    matched_prefix = True
                    break
            if matched_prefix:
                break
        if not matched_prefix:
            return False

    name_prefixes: Iterable[str] = device_filter.get("name_prefixes") or []
    if name_prefixes and not any(name.lower().startswith(p.lower()) for p in name_prefixes):
        return False

    service_uuids: Iterable[str] = device_filter.get("service_uuids") or []
    if service_uuids:
        uuids_lower = {u.lower() for u in uuids}
        if not any(s.lower() in uuids_lower for s in service_uuids):
            return False

    min_rssi = device_filter.get("min_rssi")
    if min_rssi is not None and rssi < min_rssi:
        return False
    return True


async def select_device_for_protocol(
    protocol: Dict[str, Any],
    timeout: float,
    override_address: Optional[str] = None,
    allow_unfiltered: bool = False,
) -> Optional[Tuple[str, str, int, List[str], dict]]:
    device_filter = protocol.get("device_filter", {})
    results = await scan_once(timeout=timeout, min_rssi=device_filter.get("min_rssi"))
    if override_address:
        for entry in results:
            if entry[0].lower() == override_address.lower():
                if APPLE_MANUFACTURER_ID in entry[4]:
                    print("Apple manufacturer id detected on requested address; skipping.")
                    return None
                print("Selected device by address override:")
                print_results([entry])
                return entry
        print(f"Address {override_address} not found during scan.")
        return None

    candidates = [entry for entry in results if _matches_device_filter(entry, device_filter)]
    candidates = [c for c in candidates if APPLE_MANUFACTURER_ID not in c[4]]
    if not candidates and allow_unfiltered:
        candidates = [c for c in results if APPLE_MANUFACTURER_ID not in c[4]]
    if not candidates:
        print("No matching devices found. Scan results:")
        print_results(results)
        return None

    chosen = max(candidates, key=lambda e: e[2] if e[2] is not None else -999)
    print("Selected device:")
    print_results([chosen])
    return chosen


async def discover_services(client: BleakClient):
    if hasattr(client, "get_services") and callable(getattr(client, "get_services")):
        return await client.get_services()
    return getattr(client, "services", None)


def evaluate_success(protocol: Dict[str, Any], services) -> bool:
    success_condition = protocol.get("success_condition", {})
    expected_services: Set[str] = {s.lower() for s in success_condition.get("expected_services_after_handshake", [])}
    expected_characteristics: Set[str] = {
        c.lower() for c in success_condition.get("expected_characteristics_after_handshake", [])
    }

    discovered_services: Set[str] = set()
    discovered_characteristics: Set[str] = set()
    if services:
        for svc in services:
            discovered_services.add(getattr(svc, "uuid", "").lower())
            for ch in getattr(svc, "characteristics", []) or []:
                discovered_characteristics.add(getattr(ch, "uuid", "").lower())

    missing_services = expected_services - discovered_services
    missing_characteristics = expected_characteristics - discovered_characteristics

    print("Service discovery summary:")
    print(f"  expected services: {sorted(expected_services)}")
    print(f"  discovered services: {sorted(discovered_services)}")
    print(f"  missing services: {sorted(missing_services)}")
    print(f"  expected characteristics: {sorted(expected_characteristics)}")
    print(f"  discovered characteristics: {sorted(discovered_characteristics)}")
    print(f"  missing characteristics: {sorted(missing_characteristics)}")

    if success_condition.get("require_service_discovery_after_handshake", False):
        return not missing_services and not missing_characteristics
    return True


async def verify_advertising(protocol: Dict[str, Any], timeout: float, override_address: Optional[str]) -> bool:
    expected_service = protocol.get("success_condition", {}).get("expected_ble_service")
    results = await scan_once(timeout=timeout)
    found = False
    for address, name, rssi, uuids, manufacturer_data in results:
        if override_address and address.lower() != override_address.lower():
            continue
        uuids_lower = {u.lower() for u in uuids}
        if expected_service and expected_service.lower() in uuids_lower:
            if APPLE_MANUFACTURER_ID in manufacturer_data:
                continue
            print(f"Found expected service on {address} ({name}), RSSI {rssi}")
            found = True
    if not found:
        print("No devices advertising expected service UUID during verify window.")
    return found


async def verify_connect(protocol: Dict[str, Any], timeout: float, override_address: Optional[str]) -> bool:
    device = await select_device_for_protocol(protocol, timeout=timeout, override_address=override_address, allow_unfiltered=True)
    if not device:
        return False

    address = device[0]
    try:
        async with BleakClient(address) as client:
            services = await discover_services(client)
            if services is None:
                print("No services discovered during connect verify.")
                return False
            return evaluate_success(protocol, services)
    except Exception as exc:
        print(f"Failed to connect or discover services: {exc}")
        return False


async def verify(protocol: Dict[str, Any], timeout: float = 20.0, connect_verify: bool = False, address: Optional[str] = None) -> bool:
    adv_ok = await verify_advertising(protocol, timeout=timeout, override_address=address)
    if connect_verify:
        connect_ok = await verify_connect(protocol, timeout=timeout, override_address=address)
        return adv_ok and connect_ok
    return adv_ok


def main() -> None:
    parser = argparse.ArgumentParser(description="Verify Myvu BLE services appear")
    parser.add_argument("--protocol", default="myvu_enable_ble_protocol.json", help="Path to protocol JSON")
    parser.add_argument("--timeout", type=float, default=20.0, help="Scan duration")
    parser.add_argument("--address", help="Target address override")
    parser.add_argument("--connect-verify", action="store_true", help="Connect and run service discovery")
    args = parser.parse_args()

    protocol = load_protocol(Path(args.protocol))
    success = asyncio.run(verify(protocol, timeout=args.timeout, connect_verify=args.connect_verify, address=args.address))
    if not success:
        raise SystemExit(1)


if __name__ == "__main__":
    main()
