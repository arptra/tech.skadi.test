import asyncio
import logging
from dataclasses import dataclass
from typing import Awaitable, Callable, List, Optional

from bleak import BleakClient, BleakError, BleakScanner

from .config import ConnectionConfig, DEFAULT_CONFIG

logger = logging.getLogger(__name__)


@dataclass
class DiscoveredDevice:
    address: str
    name: str


class GlassBleClient:
    """BLE helper that mirrors the discovery/connection flow from the Android SDK."""

    def __init__(self, config: ConnectionConfig = DEFAULT_CONFIG, loop: Optional[asyncio.AbstractEventLoop] = None):
        self.config = config
        self.loop = loop or asyncio.get_event_loop()
        self.client: Optional[BleakClient] = None

    async def discover(self) -> List[DiscoveredDevice]:
        devices = await BleakScanner.discover(
            timeout=self.config.ble_scan_timeout,
            service_uuids=[self.config.ble_service_uuid]
            if self.config.ble_service_uuid
            else None,
        )
        filtered: List[DiscoveredDevice] = []
        for device in devices:
            name = device.name or ""
            if any(name.startswith(prefix) for prefix in self.config.device_name_prefixes):
                filtered.append(DiscoveredDevice(address=device.address, name=name))
        logger.info("Found %d candidate devices", len(filtered))
        return filtered

    async def connect(self, address: str, notify_handler: Optional[Callable[[bytearray], Awaitable[None]]] = None) -> None:
        attempts = 0
        while True:
            attempts += 1
            logger.info("Connecting to %s (attempt %d)", address, attempts)
            try:
                self.client = BleakClient(address, loop=self.loop)
                await self.client.connect()
                logger.info("Connected to %s", address)
                await self._ensure_notifications(notify_handler)
                return
            except BleakError as exc:
                logger.warning("BLE connection failed: %s", exc)
                if not self.config.reconnect or attempts >= self.config.max_reconnect_attempts:
                    raise
                await asyncio.sleep(1.0)

    async def disconnect(self) -> None:
        if self.client is not None and self.client.is_connected:
            await self.client.disconnect()
            logger.info("Disconnected")
        self.client = None

    async def send(self, payload: bytes) -> None:
        if self.client is None or not self.client.is_connected:
            raise RuntimeError("Client is not connected")
        if self.config.ble_tx_characteristic is None:
            raise RuntimeError("No TX characteristic configured")
        await self.client.write_gatt_char(self.config.ble_tx_characteristic, payload, response=True)

    async def _ensure_notifications(self, notify_handler: Optional[Callable[[bytearray], Awaitable[None]]]) -> None:
        if notify_handler is None:
            return

        # Always include the legacy single RX characteristic for compatibility.
        characteristics = set(self.config.ble_notify_characteristics or [])
        if self.config.ble_rx_characteristic:
            characteristics.add(self.config.ble_rx_characteristic)

        for char_uuid in characteristics:
            await self.client.start_notify(char_uuid, lambda _, data: self.loop.create_task(notify_handler(data)))


async def demo_connect(config: ConnectionConfig = DEFAULT_CONFIG) -> None:
    client = GlassBleClient(config)
    candidates = await client.discover()
    if not candidates:
        raise RuntimeError("No glasses found during BLE scan")
    await client.connect(candidates[0].address)
    logger.info("Ready to exchange data with %s", candidates[0].name)


if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)
    asyncio.run(demo_connect())
