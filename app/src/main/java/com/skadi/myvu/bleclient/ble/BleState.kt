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
    object ProtocolSessionInit : BleState("PROTOCOL_SESSION_INIT")
    object ConnectedReady : BleState("CONNECTED_READY")
    object ReadyForCommands : BleState("READY_FOR_COMMANDS")
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
