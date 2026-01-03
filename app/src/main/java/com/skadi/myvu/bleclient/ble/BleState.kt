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
    object ReadingPreHello : BleState("READING_PRE_HELLO")
    object WaitingForServerKey : BleState("WAITING_FOR_SERVER_KEY")
    object ReadyForBond : BleState("READY_FOR_BOND")
    object BondingBrEdr : BleState("BONDING_BR_EDR")
    object Bonded : BleState("BONDED")
    object ReadyForTransport : BleState("READY_FOR_TRANSPORT")
    object Disconnected : BleState("DISCONNECTED")
    data class Error(val reason: BleErrorReason) : BleState("ERROR: ${reason.name}")
}

enum class BleErrorReason {
    SCAN_TIMEOUT,
    NO_MATCHING_ADVERTISING,
    GATT_CONNECT_FAILED,
    SERVICE_DISCOVERY_FAILED,
    HANDSHAKE_WRITE_FAILED,
    CCCD_ENABLE_FAILED,
    BOND_FAILED
}
