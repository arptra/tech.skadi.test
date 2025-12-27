package com.skadi.myvu.bleclient.ble

/** Explicit BLE connection states. */
sealed class BleState(val label: String) {
    object Idle : BleState("IDLE")
    object Scanning : BleState("SCANNING")
    object DeviceFound : BleState("DEVICE_FOUND")
    object Bonding : BleState("BONDING")
    object Connecting : BleState("CONNECTING")
    object Connected : BleState("CONNECTED")
    object DiscoveringServices : BleState("DISCOVERING_SERVICES")
    object ServicesDiscovered : BleState("SERVICES_DISCOVERED")
    object NegotiatingMtu : BleState("NEGOTIATING_MTU")
    object MtuReady : BleState("MTU_READY")
    object EnablingNotifications : BleState("ENABLING_NOTIFICATIONS")
    object NotificationsEnabled : BleState("NOTIFICATIONS_ENABLED")
    object Ready : BleState("READY")
    object Disconnecting : BleState("DISCONNECTING")
    object Disconnected : BleState("DISCONNECTED")
    data class Error(val reason: String) : BleState("ERROR")
}
