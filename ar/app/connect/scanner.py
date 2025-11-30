import asyncio
import logging
from dataclasses import dataclass
from typing import List, Optional

from bleak import BleakError, BleakScanner

from .config import ConnectionConfig, DEFAULT_CONFIG

logger = logging.getLogger(__name__)


@dataclass
class ScannedDevice:
    address: str
    name: str
    advertised_services: List[str]
    is_glasses: bool


class BleDeviceScanner:
    """Scan for nearby BLE devices and highlight the glasses candidates."""

    def __init__(
        self, config: ConnectionConfig = DEFAULT_CONFIG, loop: Optional[asyncio.AbstractEventLoop] = None
    ) -> None:
        self.config = config
        self.loop = loop or asyncio.get_event_loop()

    async def scan_and_print(self) -> List[ScannedDevice]:
        try:
            devices = await BleakScanner.discover(timeout=self.config.ble_scan_timeout)
        except BleakError as exc:
            logger.error(
                "BLE scan failed: %s. Ensure Bluetooth is powered on and available, then retry.",
                exc,
            )
            return []
        results: List[ScannedDevice] = []
        if not devices:
            logger.info("No BLE devices found")
            return results

        for device in devices:
            name = device.name or "(unknown)"
            advertised_services = [uuid.lower() for uuid in (device.metadata.get("uuids") or [])]
            is_name_match = any(name.startswith(prefix) for prefix in self.config.device_name_prefixes)
            is_service_match = (
                self.config.ble_service_uuid is not None
                and self.config.ble_service_uuid.lower() in advertised_services
            )
            is_glasses = is_name_match or is_service_match

            results.append(
                ScannedDevice(
                    address=device.address,
                    name=name,
                    advertised_services=advertised_services,
                    is_glasses=is_glasses,
                )
            )

            marker = "🌟 GLASSES" if is_glasses else "•"
            logger.info("%s %s [%s] services=%s", marker, name, device.address, advertised_services or "[]")

        return results


async def _main() -> None:
    logging.basicConfig(level=logging.INFO)
    scanner = BleDeviceScanner()
    await scanner.scan_and_print()


if __name__ == "__main__":
    asyncio.run(_main())
