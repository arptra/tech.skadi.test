"""Send a MYVU WAKE packet to the smart glasses over BLE using bleak.

This module scans for the MYVU device, constructs a wake packet with the
required header/opcode/version/payload/CRC16 (Modbus), and writes it to the
specified characteristic without requiring a response.
"""
import asyncio
import logging
import random
import struct
import time
from typing import Iterable, List, Optional, Tuple

from bleak import BleakClient, BleakScanner
from bleak.backends.device import BLEDevice
from bleak.backends.scanner import AdvertisementData

SERVICE_UUID = "0000fee0-0000-1000-8000-00805f9b34fb"
CHARACTERISTIC_UUID = "0000fee1-0000-1000-8000-00805f9b34fb"
MANUFACTURER_ID = 0x0A1C
MAGIC_PREFIX = bytes([0x01, 0x00, 0x55, 0xAA])
HEADER = 0x01
OPCODE_WAKE = 0x0C
VERSION = 0x02
PAYLOAD_LENGTH = 0x08
SCAN_TIMEOUT_SECONDS = 8.0


def crc16_ibm(data: bytes) -> int:
    """Compute CRC16-IBM (MODBUS) with polynomial 0xA001 and initial 0xFFFF."""
    crc = 0xFFFF
    for byte in data:
        crc ^= byte
        for _ in range(8):
            if crc & 0x0001:
                crc = (crc >> 1) ^ 0xA001
            else:
                crc >>= 1
    return crc & 0xFFFF


def build_wake_packet() -> bytes:
    timestamp_ms = int(time.time() * 1000) & 0xFFFFFFFF
    nonce = random.getrandbits(32)

    packet = bytearray()
    packet.append(HEADER)
    packet.append(OPCODE_WAKE)
    packet.append(VERSION)
    packet.extend(struct.pack("<H", PAYLOAD_LENGTH))
    packet.extend(struct.pack("<I", timestamp_ms))
    packet.extend(struct.pack("<I", nonce))

    crc = crc16_ibm(packet)
    packet.extend(struct.pack("<H", crc))
    return bytes(packet)


def _has_service(advertisement: AdvertisementData) -> bool:
    return any(uuid.lower() == SERVICE_UUID for uuid in (advertisement.service_uuids or []))


def _has_magic_prefix(advertisement: AdvertisementData) -> bool:
    data = (advertisement.manufacturer_data or {}).get(MANUFACTURER_ID)
    return bool(data and data.startswith(MAGIC_PREFIX))


def _is_unknown(device: BLEDevice, advertisement: AdvertisementData) -> bool:
    name = device.name or advertisement.local_name
    return not name or name.lower() == "(unknown)" or name.lower() == "unknown"


def select_best_device(entries: Iterable[Tuple[BLEDevice, AdvertisementData]]) -> Optional[Tuple[BLEDevice, AdvertisementData]]:
    def score(item: Tuple[BLEDevice, AdvertisementData]) -> Tuple[int, int, int]:
        device, advertisement = item
        service_match = int(_has_service(advertisement))
        magic_match = int(_has_magic_prefix(advertisement))
        unknown = int(_is_unknown(device, advertisement))
        rssi = advertisement.rssi or -200
        return (service_match * 100 + magic_match * 10 + unknown * 5 + rssi, rssi, magic_match)

    entries_list: List[Tuple[BLEDevice, AdvertisementData]] = list(entries)
    if not entries_list:
        return None

    service_candidates = [e for e in entries_list if _has_service(e[1])]
    if service_candidates:
        return max(service_candidates, key=score)

    unknown_candidates = [e for e in entries_list if _is_unknown(e[0], e[1])]
    if unknown_candidates:
        return max(unknown_candidates, key=score)

    return max(entries_list, key=score)


async def scan_for_devices(timeout: float = SCAN_TIMEOUT_SECONDS) -> List[Tuple[BLEDevice, AdvertisementData]]:
    found: List[Tuple[BLEDevice, AdvertisementData]] = []

    def handle_detection(device: BLEDevice, advertisement: AdvertisementData) -> None:
        logging.debug("Detected %s (%s) RSSI=%s", device.name, device.address, advertisement.rssi)
        found.append((device, advertisement))

    async with BleakScanner(detection_callback=handle_detection) as scanner:
        await asyncio.sleep(timeout)
        # Ensure we collect devices discovered by scanner.devices as well.
        for device in scanner.discovered_devices:
            if not any(device.address == existing[0].address for existing in found):
                found.append((device, AdvertisementData(local_name=device.name, manufacturer_data={}, service_uuids=[], rssi=device.rssi)))
    return found


async def send_wake_packet() -> None:
    logging.info("Scanning for MYVU devices (service %s)...", SERVICE_UUID)
    entries = await scan_for_devices()
    logging.info("Discovered %d device(s).", len(entries))

    choice = select_best_device(entries)
    if not choice:
        logging.error("No BLE devices found. Ensure the glasses are powered on and in range.")
        return

    device, advertisement = choice
    logging.info(
        "Selected device: name=%s address=%s rssi=%s service_uuids=%s manufacturer_data=%s",
        device.name or "(unknown)",
        device.address,
        advertisement.rssi,
        advertisement.service_uuids,
        {k: v.hex() for k, v in (advertisement.manufacturer_data or {}).items()},
    )

    packet = build_wake_packet()
    logging.info("WAKE packet (%d bytes): %s", len(packet), packet.hex())

    async with BleakClient(device) as client:
        await client.write_gatt_char(CHARACTERISTIC_UUID, packet, response=False)
        logging.info("WAKE packet sent to %s", CHARACTERISTIC_UUID)


async def _main() -> None:
    logging.basicConfig(level=logging.INFO, format="%(levelname)s:%(message)s")
    await send_wake_packet()


if __name__ == "__main__":
    asyncio.run(_main())
