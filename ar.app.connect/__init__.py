"""Laptop-side connection helpers for the smart glasses."""

from .ble import GlassBleClient, DiscoveredDevice
from .config import ConnectionConfig, DEFAULT_CONFIG
from .connect_manager import ConnectionManager
from .media_test import GlassMediaTester
from .scanner import BleDeviceScanner, ScannedDevice
from .usb import GlassUsbClient

__all__ = [
    "GlassBleClient",
    "DiscoveredDevice",
    "GlassUsbClient",
    "ConnectionManager",
    "GlassMediaTester",
    "BleDeviceScanner",
    "ScannedDevice",
    "ConnectionConfig",
    "DEFAULT_CONFIG",
]
