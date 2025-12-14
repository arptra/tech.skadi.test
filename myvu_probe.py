import argparse
import asyncio
import json
import random
from pathlib import Path
from typing import Dict, Iterable, List, Optional

from myvu_ble_scan import scan_once

try:
    # pyobjc is available on macOS by default, but we guard imports for portability
    import objc  # type: ignore
    from Foundation import NSData, NSDictionary
    from CoreBluetooth import CBAdvertisementDataManufacturerDataKey, CBMutableService, CBPeripheralManager  # type: ignore

    HAS_COREBLUETOOTH = True
except Exception:
    HAS_COREBLUETOOTH = False


DEFAULT_MANUFACTURER_ID = 0x0BD1  # 3025 decimal, seen in StarryNet BleUtil


async def capture_manufacturer(timeout: float) -> List[Dict[str, object]]:
    results = await scan_once(timeout=timeout)
    captured: List[Dict[str, object]] = []
    for address, name, rssi, uuids, manufacturer_data in results:
        for m_id, payload in manufacturer_data.items():
            captured.append(
                {
                    "address": address,
                    "name": name,
                    "rssi": rssi,
                    "manufacturer_id": m_id,
                    "payload_hex": payload.hex() if isinstance(payload, (bytes, bytearray)) else str(payload),
                    "service_uuids": uuids,
                }
            )
    return captured


def mutate_payload_hex(payload_hex: str) -> str:
    raw = bytearray.fromhex(payload_hex)
    if not raw:
        return payload_hex
    idx = random.randrange(0, len(raw))
    raw[idx] ^= 0x01
    return raw.hex()


def _build_adv_payload(manufacturer_id: int, payload_hex: str) -> Optional[NSDictionary]:
    if not HAS_COREBLUETOOTH:
        return None
    payload_bytes = bytes.fromhex(payload_hex)
    # prepend the manufacturer id as little endian 16-bit
    full = manufacturer_id.to_bytes(2, byteorder="little") + payload_bytes
    data = NSData.dataWithBytes_length_(full, len(full))
    return NSDictionary.dictionaryWithObject_forKey_(data, CBAdvertisementDataManufacturerDataKey)


class _PeripheralDelegate:
    def __init__(self, manager: CBPeripheralManager):
        self.manager = manager
        self.ready = False

    def peripheralManagerDidUpdateState_(self, manager):
        # 5 == CBManagerStatePoweredOn
        self.ready = getattr(manager, "state", None) == 5


async def replay_payloads(
    payloads: Iterable[Dict[str, object]],
    mutate: bool,
    interval: float,
    manufacturer_id: Optional[int] = None,
) -> None:
    if not HAS_COREBLUETOOTH:
        print("CoreBluetooth peripheral mode not available; cannot replay advertising payloads on this platform.")
        return

    manager = CBPeripheralManager.alloc().init()
    delegate = _PeripheralDelegate(manager)
    manager.setDelegate_(delegate)

    # wait for peripheral manager ready
    for _ in range(50):
        if delegate.ready:
            break
        await asyncio.sleep(0.1)
    if not delegate.ready:
        print("Peripheral manager not ready; cannot advertise")
        return

    for payload in payloads:
        payload_hex = str(payload.get("payload_hex", ""))
        if mutate:
            payload_hex = mutate_payload_hex(payload_hex)
        m_id = manufacturer_id or int(payload.get("manufacturer_id", DEFAULT_MANUFACTURER_ID))
        advert_data = _build_adv_payload(m_id, payload_hex)
        if advert_data is None:
            print("Failed to build advertisement payload")
            continue
        manager.stopAdvertising()
        manager.startAdvertising_(advert_data)
        print(f"Advertising manufacturer {hex(m_id)} payload {payload_hex}")
        await asyncio.sleep(interval)
    manager.stopAdvertising()


async def run_probe(args: argparse.Namespace) -> None:
    payloads: List[Dict[str, object]] = []
    if args.capture:
        payloads = await capture_manufacturer(timeout=args.capture_timeout)
        print(json.dumps(payloads, indent=2))
    if args.payloads and Path(args.payloads).exists():
        payloads = json.loads(Path(args.payloads).read_text(encoding="utf-8"))
    if not payloads:
        print("No payloads to replay; capture first with --capture")
        return
    await replay_payloads(payloads, mutate=args.mutate, interval=args.interval, manufacturer_id=args.manufacturer_id)


def main() -> None:
    parser = argparse.ArgumentParser(description="Capture and replay BLE advertising payloads")
    parser.add_argument("--capture", action="store_true", help="Capture advertising before replay")
    parser.add_argument("--capture-timeout", type=float, default=10.0, help="Capture duration")
    parser.add_argument("--payloads", type=str, help="Path to JSON payload list to replay")
    parser.add_argument("--mutate", action="store_true", help="Mutate one bit in each payload before replaying")
    parser.add_argument("--interval", type=float, default=2.0, help="Seconds to advertise each payload")
    parser.add_argument("--manufacturer-id", type=lambda x: int(x, 0), help="Override manufacturer id for replay")
    args = parser.parse_args()
    asyncio.run(run_probe(args))


if __name__ == "__main__":
    main()
