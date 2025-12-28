package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattService

/**
 * Snapshot of services/characteristics and the selected endpoints used by the protocol layer.
 */
data class GattModel(
    val services: List<BluetoothGattService>,
    val notifyCharacteristic: BluetoothGattCharacteristic?,
    val writeCharacteristic: BluetoothGattCharacteristic?,
    val descriptors: List<BluetoothGattDescriptor>
)
