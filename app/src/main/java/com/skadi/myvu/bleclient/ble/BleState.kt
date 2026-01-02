package com.skadi.myvu.bleclient.ble

/**
 * Explicit BLE + bonding state machine dedicated to the MYVU glasses flow.
 */
sealed class BleState(val label: String) {
    object Idle : BleState("IDLE")
    object Scanning : BleState("SCANNING")
    object DeviceFound : BleState("DEVICE_FOUND")
    object BleConnecting : BleState("BLE_CONNECTING")
    object BleConnected : BleState("BLE_CONNECTED")
    object ServicesDiscovering : BleState("SERVICES_DISCOVERING")
    object HandshakeWriting : BleState("HANDSHAKE_WRITING")
    object HandshakeDone : BleState("HANDSHAKE_DONE")
    object WaitingForSystemPairing : BleState("WAITING_FOR_SYSTEM_PAIRING")
    object Bonded : BleState("BONDED")
    object ApplicationInit : BleState("APPLICATION_INIT")
    object ApplicationReady : BleState("APPLICATION_READY")
    object Disconnected : BleState("DISCONNECTED")
    data class Error(val reason: BleErrorReason) : BleState("ERROR: ${reason.name}")
}

enum class BleErrorReason {
    SCAN_TIMEOUT,
    NO_MATCHING_ADVERTISING,
    GATT_CONNECT_FAILED,
    SERVICE_DISCOVERY_FAILED,
    HANDSHAKE_WRITE_FAILED,
    BONDING_FAILED,
    BONDING_TIMEOUT
}
