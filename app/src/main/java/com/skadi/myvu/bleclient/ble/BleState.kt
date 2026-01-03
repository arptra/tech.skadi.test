package com.skadi.myvu.bleclient.ble

/**
 * Explicit BLE + bonding state machine dedicated to the MYVU glasses flow.
 */
sealed class BleState(val label: String) {
    object Idle : BleState("IDLE")
    object Scanning : BleState("SCANNING")
    object Connecting : BleState("CONNECTING")
    object MtuNegotiation : BleState("MTU_NEGOTIATION")
    object ServicesDiscovering : BleState("SERVICES_DISCOVERING")
    object EnablingNotifications : BleState("ENABLING_NOTIFICATIONS")
    object NotificationsEnabled : BleState("NOTIFICATIONS_ENABLED")
    object HelloSent : BleState("HELLO_SENT")
    object HandshakeInProgress : BleState("HANDSHAKE_IN_PROGRESS")
    object ConnectedReady : BleState("READY")
    object Disconnected : BleState("DISCONNECTED")
    data class Error(val reason: BleErrorReason) : BleState("ERROR: ${reason.name}")
}

enum class BleErrorReason {
    SCAN_TIMEOUT,
    NO_MATCHING_ADVERTISING,
    GATT_CONNECT_FAILED,
    SERVICE_DISCOVERY_FAILED,
    HANDSHAKE_WRITE_FAILED,
    CCCD_ENABLE_FAILED
}
