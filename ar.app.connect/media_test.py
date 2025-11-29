import argparse
import asyncio
import logging
from pathlib import Path
from typing import Optional
import time

from .config import ConnectionConfig, DEFAULT_CONFIG
from .connect_manager import ConnectionManager, _build_config

logger = logging.getLogger(__name__)


class GlassMediaTester:
    """Push a local image/video payload to the glasses for quick validation.

    The Android `com.upuphone.starrycommon` package drives frames through an EGL
    pipeline; this helper mirrors the idea for laptops by chunking a binary
    payload (image frame, encoded video segment, or demo banner) over the
    configured BLE/USB channel. Use a modest chunk size to avoid overrunning the
    GATT MTU and insert small pauses between writes to match the streaming
    cadence expected by the glasses firmware.
    """

    def __init__(self, manager: ConnectionManager, chunk_size: int = 180, pause: float = 0.02):
        self.manager = manager
        self.chunk_size = max(1, chunk_size)
        self.pause = max(0.0, pause)

    async def play_ble(self, file_path: str, repeat: int = 1) -> None:
        payload = Path(file_path).read_bytes()
        client = await self.manager.connect_ble()
        await self._stream_ble(client.send, payload, repeat)
        logger.info("Finished BLE media push (%d repeats)", repeat)

    def play_usb(self, file_path: str, repeat: int = 1) -> None:
        payload = Path(file_path).read_bytes()
        client = self.manager.connect_usb()
        self._stream_usb(client.send, payload, repeat)
        logger.info("Finished USB media push (%d repeats)", repeat)

    async def _stream_ble(self, sender, payload: bytes, repeat: int) -> None:
        for _ in range(max(1, repeat)):
            for chunk in self._chunk_payload(payload):
                await sender(chunk)
                if self.pause:
                    await asyncio.sleep(self.pause)

    def _stream_usb(self, sender, payload: bytes, repeat: int) -> None:
        for _ in range(max(1, repeat)):
            for chunk in self._chunk_payload(payload):
                sender(chunk)
                if self.pause:
                    time.sleep(self.pause)

    def _chunk_payload(self, payload: bytes):
        for offset in range(0, len(payload), self.chunk_size):
            yield payload[offset : offset + self.chunk_size]


def main(argv: Optional[list] = None) -> None:
    parser = argparse.ArgumentParser(description="Send an image/video payload to the glasses for testing")
    parser.add_argument("--file", required=True, help="Path to the image or encoded video segment to send")
    parser.add_argument("--mode", choices=["ble", "usb"], default="ble", help="Transport to use")
    parser.add_argument("--chunk-size", type=int, default=180, help="Bytes per write (keep under MTU)")
    parser.add_argument("--pause", type=float, default=0.02, help="Delay between writes (seconds)")
    parser.add_argument("--repeat", type=int, default=1, help="Number of times to resend the payload")

    parser.add_argument("--prefix", nargs="+", default=DEFAULT_CONFIG.device_name_prefixes, help="Name prefixes to match during BLE scan")
    parser.add_argument("--service", help="BLE service UUID for data channel")
    parser.add_argument("--tx", help="BLE TX characteristic UUID")
    parser.add_argument("--rx", help="BLE RX characteristic UUID")
    parser.add_argument("--notify", nargs="+", default=DEFAULT_CONFIG.ble_notify_characteristics, help="Notification characteristic UUIDs")
    parser.add_argument("--scan-timeout", type=float, default=DEFAULT_CONFIG.ble_scan_timeout, help="BLE discovery window (seconds)")
    parser.add_argument("--no-reconnect", action="store_true", help="Disable BLE reconnect attempts")
    parser.add_argument("--retries", type=int, default=DEFAULT_CONFIG.max_reconnect_attempts, help="Maximum BLE reconnect attempts")
    parser.add_argument("--usb-baudrate", type=int, default=DEFAULT_CONFIG.usb_baudrate, help="Serial baudrate for USB fallback")

    args = parser.parse_args(argv)
    logging.basicConfig(level=logging.INFO)

    config: ConnectionConfig = _build_config(args)
    manager = ConnectionManager(config)
    tester = GlassMediaTester(manager, chunk_size=args.chunk_size, pause=args.pause)

    if args.mode == "ble":
        asyncio.run(tester.play_ble(args.file, repeat=args.repeat))
    else:
        tester.play_usb(args.file, repeat=args.repeat)


if __name__ == "__main__":
    main()
