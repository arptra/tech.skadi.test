import argparse
import asyncio
import logging
from typing import Optional

from .ble import GlassBleClient
from .config import ConnectionConfig, DEFAULT_CONFIG
from .usb import GlassUsbClient

logger = logging.getLogger(__name__)


class ConnectionManager:
    def __init__(self, config: ConnectionConfig = DEFAULT_CONFIG):
        self.config = config
        self.ble_client = GlassBleClient(config)
        self.usb_client = GlassUsbClient(config)

    async def connect_ble(self) -> GlassBleClient:
        candidates = await self.ble_client.discover()
        if not candidates:
            raise RuntimeError("No BLE glasses found. Make sure the device is in pairing mode.")
        await self.ble_client.connect(candidates[0].address)
        return self.ble_client

    def connect_usb(self) -> GlassUsbClient:
        endpoint = self.usb_client.discover()
        if endpoint is None:
            raise RuntimeError("No USB glasses detected. Connect the cable and try again.")
        self.usb_client.connect(endpoint)
        return self.usb_client


def _build_config(args: argparse.Namespace) -> ConnectionConfig:
    return ConnectionConfig(
        device_name_prefixes=args.prefix,
        ble_service_uuid=args.service,
        ble_tx_characteristic=args.tx,
        ble_rx_characteristic=args.rx,
        ble_notify_characteristics=args.notify,
        ble_scan_timeout=args.scan_timeout,
        reconnect=not args.no_reconnect,
        max_reconnect_attempts=args.retries,
        usb_baudrate=args.usb_baudrate,
    )


def main(argv: Optional[list] = None) -> None:
    parser = argparse.ArgumentParser(description="Connect to the glasses over BLE or USB")
    parser.add_argument("--mode", choices=["ble", "usb"], default="ble", help="Transport to use")
    parser.add_argument("--prefix", nargs="+", default=DEFAULT_CONFIG.device_name_prefixes, help="Name prefixes to match during BLE scan")
    parser.add_argument("--service", help="BLE service UUID for data channel")
    parser.add_argument("--tx", help="BLE TX characteristic UUID")
    parser.add_argument("--rx", help="BLE RX characteristic UUID")
    parser.add_argument(
        "--notify",
        nargs="+",
        default=DEFAULT_CONFIG.ble_notify_characteristics,
        help="Notification characteristic UUIDs to subscribe to",
    )
    parser.add_argument("--scan-timeout", type=float, default=DEFAULT_CONFIG.ble_scan_timeout, help="BLE discovery window (seconds)")
    parser.add_argument("--no-reconnect", action="store_true", help="Disable BLE reconnect attempts")
    parser.add_argument("--retries", type=int, default=DEFAULT_CONFIG.max_reconnect_attempts, help="Maximum BLE reconnect attempts")
    parser.add_argument("--usb-baudrate", type=int, default=DEFAULT_CONFIG.usb_baudrate, help="Serial baudrate for USB fallback")
    parser.add_argument("--send", help="Optional payload to send once connected")

    args = parser.parse_args(argv)
    config = _build_config(args)
    manager = ConnectionManager(config)

    logging.basicConfig(level=logging.INFO)

    if args.mode == "ble":
        asyncio.run(_run_ble(manager, args.send))
    else:
        _run_usb(manager, args.send)


async def _run_ble(manager: ConnectionManager, payload: Optional[str]) -> None:
    client = await manager.connect_ble()
    if payload is not None:
        await client.send(payload.encode())
        logger.info("Sent payload over BLE")


def _run_usb(manager: ConnectionManager, payload: Optional[str]) -> None:
    client = manager.connect_usb()
    if payload is not None:
        client.send(payload.encode())
        logger.info("Sent payload over USB")


if __name__ == "__main__":
    main()
