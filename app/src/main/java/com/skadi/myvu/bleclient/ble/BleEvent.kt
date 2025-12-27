package com.skadi.myvu.bleclient.ble

sealed class BleEvent {
    object ScanStarted : BleEvent()
    data class DeviceSpotted(val name: String?, val address: String, val rssi: Int) : BleEvent()
    data class DeviceChosen(val name: String?, val address: String) : BleEvent()
    data class BondState(val state: Int) : BleEvent()
    data class ConnectionChanged(val status: Int, val newState: Int) : BleEvent()
    data class Services(val success: Boolean) : BleEvent()
    data class Mtu(val mtu: Int, val status: Int) : BleEvent()
    data class Notification(val uuid: String, val data: ByteArray) : BleEvent()
    data class DescriptorWrite(val uuid: String, val status: Int) : BleEvent()
    data class CharacteristicWrite(val uuid: String, val status: Int) : BleEvent()
    data class Error(val message: String) : BleEvent()
}
