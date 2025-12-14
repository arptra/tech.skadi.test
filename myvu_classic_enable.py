import json
import subprocess
from pathlib import Path
from typing import Any, Dict, List, Optional

APPLE_MANUFACTURER_ID = 0x004C


def load_protocol(protocol_path: Path) -> Dict[str, Any]:
    with protocol_path.open("r", encoding="utf-8") as f:
        return json.load(f)


def enable_via_classic(address: str, protocol: Dict[str, Any]) -> None:
    classic_cfg = protocol.get("classic") or {}
    steps: List[Dict[str, str]] = classic_cfg.get("connect_steps") or []
    uuid: Optional[str] = classic_cfg.get("uuid")
    if not uuid or not steps:
        raise RuntimeError("Classic RFCOMM transport not defined in protocol file.")

    print(f"[classic] Attempting RFCOMM connection to {address} using UUID {uuid}")
    print("macOS does not expose an RFCOMM client in the stdlib; please pair the device first.")
    cmd = [
        "blueutil",
        "--is-connected",
        address,
    ]
    try:
        result = subprocess.run(cmd, capture_output=True, text=True, check=False)
        print(f"blueutil --is-connected exit={result.returncode} stdout={result.stdout.strip()} stderr={result.stderr.strip()}")
    except FileNotFoundError:
        print("blueutil not available; manual RFCOMM connection required.")

    for step in steps:
        print(f"[classic] send_hex={step.get('send_hex')} expect={step.get('expect')}")
    print("No automated classic enable routine implemented; protocol information not present in APK.")


def should_skip_device(manufacturer_data: Dict[int, Any]) -> bool:
    return APPLE_MANUFACTURER_ID in manufacturer_data

