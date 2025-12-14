import argparse
import asyncio
import json
from pathlib import Path
from typing import Any, Dict, Optional

from bleak import BleakClient

from myvu_ble_scan import print_results, scan_once
from myvu_classic_enable import enable_via_classic, should_skip_device


def load_protocol(protocol_path: Path) -> Dict[str, Any]:
    with protocol_path.open("r", encoding="utf-8") as f:
        return json.load(f)


async def enable_ble_mode_ble(address: str, protocol: Dict[str, Any]) -> None:
    ble_cfg = protocol.get("ble") or {}
    write_uuid = ble_cfg.get("write_char_uuid")
    notify_uuid = ble_cfg.get("notify_char_uuid")
    steps = ble_cfg.get("steps") or []

    if not write_uuid:
        raise RuntimeError("BLE transport missing service or write characteristic in protocol file.")

    async with BleakClient(address) as client:
        print(f"Connected to {address}")
        if notify_uuid:
            await client.start_notify(notify_uuid, lambda *_: None)
        if steps:
            for step in steps:
                payload_hex = step.get("send_hex", "")
                if not payload_hex:
                    continue
                data = bytes.fromhex(payload_hex)
                await client.write_gatt_char(write_uuid, data, response=False)
                expect = step.get("expect")
                if expect:
                    print(f"Wrote {payload_hex}, expecting {expect}")
        else:
            print("No BLE enable steps defined in protocol; APK did not reveal configuration writes.")
        services = client.services
        if services:
            print("Discovered services after connect:")
            for s in services:
                print(f"  {s.uuid}")


async def auto_pick_device(timeout: float, expected_service: Optional[str]) -> Optional[str]:
    results = await scan_once(timeout=timeout)
    candidates = []
    for address, name, rssi, uuids, manufacturer_data in results:
        if should_skip_device(manufacturer_data):
            continue
        if expected_service and expected_service.lower() not in {u.lower() for u in uuids}:
            continue
        candidates.append((address, name, rssi))
    print_results(results)
    if not candidates:
        return None
    return candidates[0][0]


def main() -> None:
    parser = argparse.ArgumentParser(description="Trigger Myvu BLE enable sequence")
    parser.add_argument("--scan", action="store_true", help="Scan for BLE devices")
    parser.add_argument("--enable", action="store_true", help="Run enable sequence")
    parser.add_argument("--address", help="Target BLE or BT address")
    parser.add_argument("--auto", action="store_true", help="Auto-pick target based on expected service")
    parser.add_argument("--verify", action="store_true", help="Re-scan and verify services after enabling")
    parser.add_argument("--protocol", default="myvu_enable_ble_protocol.json", help="Path to protocol JSON")
    parser.add_argument("--scan-timeout", type=float, default=10.0, help="Scan duration")
    args = parser.parse_args()

    protocol = load_protocol(Path(args.protocol))

    if args.scan:
        results = asyncio.run(scan_once(timeout=args.scan_timeout))
        print_results(results)
        return

    if args.enable:
        transport = protocol.get("transport")
        target_addr = args.address
        expected_service = (protocol.get("success_condition") or {}).get("expected_service_uuid")
        if args.auto and not target_addr:
            target_addr = asyncio.run(auto_pick_device(args.scan_timeout, expected_service))
            if not target_addr:
                raise SystemExit("No suitable device found during auto scan")
        if not target_addr:
            raise SystemExit("--address or --auto required for enable")
        if transport == "classic_rfcomm":
            enable_via_classic(target_addr, protocol)
        elif transport == "ble_gatt":
            asyncio.run(enable_ble_mode_ble(target_addr, protocol))
        else:
            raise SystemExit(f"Unsupported transport: {transport}")

    if args.verify:
        from myvu_verify import verify

        success = asyncio.run(verify(protocol, timeout=args.scan_timeout))
        if not success:
            raise SystemExit(1)


if __name__ == "__main__":
    main()
