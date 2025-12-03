"""Laptop-side connection helpers for the smart glasses.

This module lazily re-exports the primary classes without eagerly importing all
submodules. Running ``python -m ar.app.connect.scanner`` now avoids the
``runpy`` warning that appeared when the scanner was already imported via the
package ``__init__``.
"""

from importlib import import_module
from typing import TYPE_CHECKING, Any, Dict, List

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

_ATTR_TO_MODULE: Dict[str, str] = {
    "GlassBleClient": "ble",
    "DiscoveredDevice": "ble",
    "GlassUsbClient": "usb",
    "ConnectionManager": "connect_manager",
    "GlassMediaTester": "media_test",
    "BleDeviceScanner": "scanner",
    "ScannedDevice": "scanner",
    "ConnectionConfig": "config",
    "DEFAULT_CONFIG": "config",
}

if TYPE_CHECKING:  # pragma: no cover - import only for static analysis
    from .ble import GlassBleClient, DiscoveredDevice
    from .config import ConnectionConfig, DEFAULT_CONFIG
    from .connect_manager import ConnectionManager
    from .media_test import GlassMediaTester
    from .scanner import BleDeviceScanner, ScannedDevice
    from .usb import GlassUsbClient


def __getattr__(name: str) -> Any:
    module_name = _ATTR_TO_MODULE.get(name)
    if module_name is None:
        raise AttributeError(f"module {__name__!r} has no attribute {name!r}")

    module = import_module(f".{module_name}", __name__)
    attr = getattr(module, name)
    globals()[name] = attr
    return attr


def __dir__() -> List[str]:
    return sorted(__all__)
