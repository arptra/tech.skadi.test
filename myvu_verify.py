import argparse
import asyncio
import json
from pathlib import Path
from typing import Any, Dict

from myvu_ble_scan import scan_once


def load_protocol(protocol_path: Path) -> Dict[str, Any]:
    with protocol_path.open("r", encoding="utf-8") as f:
        return json.load(f)


async def verify(protocol: Dict[str, Any], timeout: float = 20.0) -> bool:
    expected_service = protocol.get("expected_ble_service")
    results = await scan_once(timeout=timeout)
    found = False
    for address, name, rssi, uuids, manufacturer_data in results:
        uuids_lower = {u.lower() for u in uuids}
        if expected_service and expected_service.lower() in uuids_lower:
            print(f"Found expected service on {address} ({name}), RSSI {rssi}")
            found = True
    if not found:
        print("No devices advertising expected service UUID during verify window.")
    return found


def main() -> None:
    parser = argparse.ArgumentParser(description="Verify Myvu BLE services appear")
    parser.add_argument("--protocol", default="myvu_enable_ble_protocol.json", help="Path to protocol JSON")
    parser.add_argument("--timeout", type=float, default=20.0, help="Scan duration")
    args = parser.parse_args()

    protocol = load_protocol(Path(args.protocol))
    success = asyncio.run(verify(protocol, timeout=args.timeout))
    if not success:
        raise SystemExit(1)


if __name__ == "__main__":
    main()
