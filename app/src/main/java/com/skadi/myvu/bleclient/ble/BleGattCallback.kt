package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor

/**
 * Simple wrapper routing callbacks back into [BleManager].
 */
class BleGattCallback(private val manager: BleManager, private val logger: BleLogger) : BluetoothGattCallback() {
    override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
        logger.logInfo(TAG, "onConnectionStateChange status=$status newState=$newState")
        manager.handleConnectionStateChange(gatt, status, newState)
    }

    override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
        logger.logInfo(TAG, "onServicesDiscovered status=$status")
        manager.handleServicesDiscovered(gatt, status)
    }

    override fun onMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
        logger.logInfo(TAG, "onMtuChanged mtu=$mtu status=$status")
        manager.handleMtuChanged(gatt, mtu, status)
    }

    override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
        logger.logInfo(TAG, "onDescriptorWrite ${descriptor.uuid} status=$status")
        manager.handleDescriptorWrite(gatt, descriptor, status)
    }

    override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
        manager.handleCharacteristicChanged(characteristic)
    }

    override fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
        logger.logInfo(TAG, "onCharacteristicWrite ${characteristic.uuid} status=$status")
        manager.handleCharacteristicWrite(gatt, characteristic, status)
    }

    private companion object {
        private const val TAG = "BleGattCallback"
    }
}
