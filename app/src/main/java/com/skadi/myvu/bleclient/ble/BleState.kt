package com.skadi.myvu.bleclient.ble

/**
 * Explicit BLE + bonding state machine dedicated to the MYVU glasses flow.
 */
sealed class BleState(val label: String) {
    object Idle : BleState("IDLE")
    object Scanning : BleState("SCANNING")
    object Connecting : BleState("CONNECTING")
    object ServicesDiscovering : BleState("SERVICES_DISCOVERING")
    object EnablingNotifications : BleState("ENABLING_NOTIFICATIONS")
    object MtuNegotiation : BleState("MTU_NEGOTIATION")
    object HandshakeSent : BleState("HANDSHAKE_SENT")
    object WaitFirstNotify : BleState("WAIT_FIRST_NOTIFY")
    object Ready : BleState("READY")
    object Disconnected : BleState("DISCONNECTED")
    data class Error(val reason: BleErrorReason) : BleState("ERROR: ${reason.name}")
}

enum class BleErrorReason {
    SCAN_TIMEOUT,
    NO_MATCHING_ADVERTISING,
    GATT_CONNECT_FAILED,
    SERVICE_DISCOVERY_FAILED,
    HANDSHAKE_WRITE_FAILED,
    FIRST_NOTIFY_TIMEOUT,
    CCCD_ENABLE_FAILED
}
