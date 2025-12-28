package com.skadi.myvu.bleclient.ble

sealed class BleEvent {
    data class DeviceDiscovered(val name: String?, val address: String, val rssi: Int) : BleEvent()
    data class BondStateChanged(val state: Int, val previous: Int) : BleEvent()
    data class ConnectionStateChanged(val newState: Int, val status: Int) : BleEvent()
    data class ServicesChanged(val status: Int) : BleEvent()
    data class MtuChanged(val mtu: Int, val status: Int) : BleEvent()
    data class NotificationReceived(val uuid: String, val payload: String) : BleEvent()
    data class OperationFailed(val reason: String) : BleEvent()
}
