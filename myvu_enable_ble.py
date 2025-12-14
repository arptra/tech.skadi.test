import argparse
import asyncio
import json
from pathlib import Path
from typing import Any, Dict

from myvu_ble_scan import print_results, save_manufacturer_payloads, scan_once
from myvu_probe import run_probe
from myvu_verify import verify


def load_protocol(protocol_path: Path) -> Dict[str, Any]:
    with protocol_path.open("r", encoding="utf-8") as f:
        return json.load(f)


async def scan_raw_advertising(scan_timeout: float) -> None:
    results = await scan_once(timeout=scan_timeout)
    print_results(results)


async def log_manufacturer(scan_timeout: float, output: Path) -> None:
    results = await scan_once(timeout=scan_timeout)
    save_manufacturer_payloads(results, output)


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

    parser.print_help()


if __name__ == "__main__":
    main()
