package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import com.skadi.myvu.bleclient.util.HexUtils

/**
 * Protocol layer placeholder. Later we can inject vendor specific UUIDs and command shapes.
 */
class BleProtocol(private val manager: BleManager, private val logger: BleLogger) {
    var gatt: BluetoothGatt? = null
        private set
    var writeCharacteristic: BluetoothGattCharacteristic? = null
        private set
    var notifyCharacteristic: BluetoothGattCharacteristic? = null
        private set

    fun configure(
        gatt: BluetoothGatt?,
        writeCharacteristic: BluetoothGattCharacteristic?,
        notifyCharacteristic: BluetoothGattCharacteristic?
    ) {
        this.gatt = gatt
        this.writeCharacteristic = writeCharacteristic
        this.notifyCharacteristic = notifyCharacteristic
    }

    fun send(bytes: ByteArray, withResponse: Boolean = false): Boolean {
        val g = gatt ?: return false.also { logger.logError("BleProtocol", "Gatt is null, cannot send") }
        val ch = writeCharacteristic
            ?: return false.also { logger.logError("BleProtocol", "Write characteristic not selected") }
        logger.logInfo("BleProtocol", "TX ${HexUtils.toHex(bytes)} to ${ch.uuid}")
        return manager.enqueueWrite(g, ch, bytes, withResponse)
    }
}
