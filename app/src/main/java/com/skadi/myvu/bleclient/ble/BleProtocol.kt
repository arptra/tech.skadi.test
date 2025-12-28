package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import com.skadi.myvu.bleclient.util.HexUtils

/**
 * Placeholder protocol layer. Owns chosen GATT characteristics and exposes a simple send API.
 */
class BleProtocol(
    private val bleManager: BleManager,
    private val logger: BleLogger
) {
    var gatt: BluetoothGatt? = null
    var notifyCharacteristic: BluetoothGattCharacteristic? = null
    var writeCharacteristic: BluetoothGattCharacteristic? = null

    fun clear() {
        gatt = null
        notifyCharacteristic = null
        writeCharacteristic = null
    }

    fun send(payload: ByteArray, withResponse: Boolean = false): Boolean {
        val char = writeCharacteristic ?: return false.also {
            logger.logError(TAG, "No write characteristic available")
        }
        val gattInstance = gatt ?: return false.also {
            logger.logError(TAG, "No active GATT session")
        }
        logger.logInfo(TAG, "TX (${char.uuid} len=${payload.size}): ${HexUtils.toHex(payload)}")
        return bleManager.enqueueCharacteristicWrite(gattInstance, char, payload, withResponse)
    }

    companion object {
        private const val TAG = "BleProtocol"
    }
}
