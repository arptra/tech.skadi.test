import logging
from dataclasses import dataclass
from typing import Optional

import serial
import serial.tools.list_ports

from .config import ConnectionConfig, DEFAULT_CONFIG

logger = logging.getLogger(__name__)


@dataclass
class UsbEndpoint:
    device: str
    description: str


class GlassUsbClient:
    def __init__(self, config: ConnectionConfig = DEFAULT_CONFIG):
        self.config = config
        self.serial: Optional[serial.Serial] = None

    def discover(self) -> Optional[UsbEndpoint]:
        for port in serial.tools.list_ports.comports():
            if self._match_vid_pid(port):
                logger.info("Found USB candidate: %s (%s)", port.device, port.description)
                return UsbEndpoint(device=port.device, description=port.description)
        return None

    def connect(self, endpoint: UsbEndpoint) -> None:
        logger.info("Opening serial link to %s", endpoint.device)
        self.serial = serial.Serial(endpoint.device, baudrate=self.config.usb_baudrate, timeout=1)

    def disconnect(self) -> None:
        if self.serial is not None and self.serial.is_open:
            self.serial.close()
            logger.info("USB link closed")
        self.serial = None

    def send(self, payload: bytes) -> None:
        if self.serial is None or not self.serial.is_open:
            raise RuntimeError("Serial link is not open")
        self.serial.write(payload)
        self.serial.flush()

    def receive(self, size: int = 1024) -> bytes:
        if self.serial is None or not self.serial.is_open:
            raise RuntimeError("Serial link is not open")
        return self.serial.read(size)

    def _match_vid_pid(self, port: serial.tools.list_ports_common.ListPortInfo) -> bool:
        if self.config.usb_vendor_ids is None or self.config.usb_product_ids is None:
            return True
        return port.vid in self.config.usb_vendor_ids and port.pid in self.config.usb_product_ids
