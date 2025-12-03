from dataclasses import dataclass, field
from typing import List, Optional


@dataclass
class ConnectionConfig:
    """Configuration for scanning and connecting to the glasses.

    The Android client initializes the StarryNet stack once and then triggers
    periodic discovery when the app is foregrounded, only proceeding when a
    device is bonded and network state/login are satisfied.
    """

    device_name_prefixes: List[str] = field(
        default_factory=lambda: ["Air", "AirPro", "Star", "MyVu", "XR"]
    )
    ble_service_uuid: Optional[str] = "00002000-0000-1000-8000-00805F9B34FB"
    ble_tx_characteristic: Optional[str] = "00002002-0000-1000-8000-00805F9B34FB"
    ble_rx_characteristic: Optional[str] = "00002001-0000-1000-8000-00805F9B34FB"
    ble_notify_characteristics: List[str] = field(
        default_factory=lambda: [
            "00002001-0000-1000-8000-00805F9B34FB",
            "00002002-0000-1000-8000-00805F9B34FB",
        ]
    )
    ble_scan_timeout: float = 8.0
    reconnect: bool = True
    max_reconnect_attempts: int = 3
    usb_baudrate: int = 115200
    usb_vendor_ids: Optional[List[int]] = None
    usb_product_ids: Optional[List[int]] = None
    preferred_address: Optional[str] = None


DEFAULT_CONFIG = ConnectionConfig()
