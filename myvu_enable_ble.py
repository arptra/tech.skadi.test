import argparse
import asyncio
import json
import time
from pathlib import Path
from typing import Any, Dict, Iterable, List, Optional, Tuple

from bleak import BleakClient

from myvu_ble_scan import APPLE_MANUFACTURER_ID, print_results, save_manufacturer_payloads, scan_once
from myvu_probe import run_probe
from myvu_verify import (
    discover_services,
    evaluate_success,
    load_protocol as load_protocol_file,
    select_device_for_protocol,
    verify,
)


def load_protocol(protocol_path: Path) -> Dict[str, Any]:
    return load_protocol_file(protocol_path)


def _hex_to_bytes(value: str) -> bytes:
    return bytes.fromhex(value.replace(" ", ""))


def _log_buffered_notifications(queue: asyncio.Queue) -> None:
    buffered = []
    while not queue.empty():
        try:
            ts, data = queue.get_nowait()
            buffered.append((ts, data))
        except asyncio.QueueEmpty:
            break
    if buffered:
        print("Buffered notifications:")
        for ts, data in buffered:
            print(f"  {ts:.3f}: {data.hex()}")


def _device_summary(entry: Tuple[str, str, int, List[str], dict]) -> str:
    address, name, rssi, uuids, manufacturer_data = entry
    return f"{address} ({name}) RSSI {rssi} manufacturers {list(manufacturer_data.keys())}"


async def _wait_for_notification(queue: asyncio.Queue, expect_exact: Optional[str], expect_prefix: Optional[str], timeout_ms: int) -> bool:
    timeout_s = timeout_ms / 1000.0
    deadline = time.time() + timeout_s
    while True:
        remaining = deadline - time.time()
        if remaining <= 0:
            return False
        try:
            ts, data = await asyncio.wait_for(queue.get(), timeout=remaining)
        except asyncio.TimeoutError:
            return False
        payload_hex = data.hex()
        if expect_exact and payload_hex.lower() == expect_exact.lower():
            print(f"[notify match] {payload_hex} at {ts}")
            return True
        if expect_prefix and payload_hex.lower().startswith(expect_prefix.lower()):
            print(f"[notify prefix match] {payload_hex} at {ts}")
            return True
        print(f"[notify ignore] {payload_hex}")


def _validate_protocol(protocol: Dict[str, Any]) -> Optional[str]:
    ble_cfg = protocol.get("ble", {}) or {}
    steps = ble_cfg.get("steps") or []
    if not steps:
        return "Protocol contains no handshake steps. Populate ble.steps before running --enable."
    if not ble_cfg.get("write_char_uuid"):
        return "Protocol missing ble.write_char_uuid."
    return None


async def _perform_handshake(protocol: Dict[str, Any], device: Tuple[str, str, int, List[str], dict]) -> bool:
    validation_error = _validate_protocol(protocol)
    if validation_error:
        print(validation_error)
        return False

    ble_cfg = protocol.get("ble", {})
    default_write = ble_cfg.get("write_char_uuid")
    notify_uuid = ble_cfg.get("notify_char_uuid")
    steps = ble_cfg.get("steps", [])

    address = device[0]
    queue: asyncio.Queue = asyncio.Queue()

    async with BleakClient(address) as client:
        if notify_uuid:
            async def _cb(_: int, data: bytearray) -> None:
                queue.put_nowait((time.time(), bytes(data)))

            await client.start_notify(notify_uuid, _cb)
            print(f"Subscribed to notifications on {notify_uuid}")

        for idx, step in enumerate(steps):
            send_hex = step.get("send_hex")
            if not send_hex:
                print(f"[step {idx}] missing send_hex; aborting")
                return False
            write_uuid = step.get("write_char_uuid") or default_write
            payload = _hex_to_bytes(send_hex)
            print(f"[step {idx}] write {write_uuid} <= {payload.hex()}")
            await client.write_gatt_char(write_uuid, payload, response=True)

            expect_exact = step.get("expect_notify_hex")
            expect_prefix = step.get("expect_notify_prefix_hex")
            timeout_ms = step.get("timeout_ms", 5000)
            if expect_exact or expect_prefix:
                matched = await _wait_for_notification(queue, expect_exact, expect_prefix, timeout_ms)
                if not matched:
                    print(f"[step {idx}] notification expectation failed within {timeout_ms}ms")
                    return False
            if step.get("sleep_ms_after_write"):
                await asyncio.sleep(step["sleep_ms_after_write"] / 1000.0)

        services = await discover_services(client)
        if services is None:
            print("Service discovery unavailable after handshake.")
            _log_buffered_notifications(queue)
            return False

    _log_buffered_notifications(queue)
    return evaluate_success(protocol, services)


async def scan_raw_advertising(scan_timeout: float) -> None:
    results = await scan_once(timeout=scan_timeout)
    print_results(results)


async def log_manufacturer(scan_timeout: float, output: Path) -> None:
    results = await scan_once(timeout=scan_timeout)
    save_manufacturer_payloads(results, output)


async def run_enable(protocol: Dict[str, Any], scan_timeout: float, override_address: Optional[str]) -> bool:
    device = await select_device_for_protocol(protocol, timeout=scan_timeout, override_address=override_address, allow_unfiltered=False)
    if not device:
        return False
    if APPLE_MANUFACTURER_ID in device[4]:
        print("Aborting: device appears to be Apple (manufacturer 0x004C).")
        return False
    print(f"Running handshake on {_device_summary(device)}")
    return await _perform_handshake(protocol, device)


def main() -> None:
    parser = argparse.ArgumentParser(description="Diagnose Myvu BLE wake/enable sequences")
    parser.add_argument("--protocol", default="myvu_enable_ble_protocol.json", help="Path to protocol JSON")
    parser.add_argument("--scan-raw", action="store_true", help="Passive scan and dump advertising")
    parser.add_argument("--log-manufacturer", type=Path, help="Capture manufacturer payloads to JSON")
    parser.add_argument("--wake-probe", action="store_true", help="Replay captured advertising payloads")
    parser.add_argument("--probe-payloads", type=str, help="Payload JSON to replay (for wake-probe)")
    parser.add_argument("--probe-mutate", action="store_true", help="Mutate payloads during replay")
    parser.add_argument("--probe-interval", type=float, default=2.0, help="Seconds to advertise each payload")
    parser.add_argument("--probe-manufacturer", type=lambda x: int(x, 0), help="Override manufacturer id for replay")
    parser.add_argument("--verify", action="store_true", help="Re-scan and verify hidden services")
    parser.add_argument("--enable", action="store_true", help="Connect and run handshake steps from protocol")
    parser.add_argument("--address", help="Explicit target address (otherwise auto-selection)")
    parser.add_argument("--scan-timeout", type=float, default=10.0, help="Scan duration")
    args = parser.parse_args()

    protocol = load_protocol(Path(args.protocol))

    if args.scan_raw:
        asyncio.run(scan_raw_advertising(args.scan_timeout))
        return

    if args.log_manufacturer:
        asyncio.run(log_manufacturer(args.scan_timeout, args.log_manufacturer))
        return

    if args.wake_probe:
        probe_args = argparse.Namespace(
            capture=not args.probe_payloads,
            capture_timeout=args.scan_timeout,
            payloads=args.probe_payloads,
            mutate=args.probe_mutate,
            interval=args.probe_interval,
            manufacturer_id=args.probe_manufacturer,
        )
        asyncio.run(run_probe(probe_args))
        return

    if args.verify:
        success = asyncio.run(verify(protocol, timeout=args.scan_timeout))
        if not success:
            raise SystemExit(1)
        return

    if args.enable:
        ok = asyncio.run(run_enable(protocol, scan_timeout=args.scan_timeout, override_address=args.address))
        if not ok:
            raise SystemExit(1)
        return

    parser.print_help()


if __name__ == "__main__":
    main()
