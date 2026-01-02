package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import com.skadi.myvu.bleclient.util.HexUtils
import java.util.UUID
import org.json.JSONObject

/**
 * Minimal framing/parsing layer for the vendor JSON protocol. We only assemble plain JSON objects
 * (no encryption) because that is what shows up in the capture. Keeping it simple makes it easier
 * to reverse-engineer the rest of the stream later.
 */
class BleProtocol(
    private val bleManager: BleManager,
    private val logger: BleLogger
) {
    var gatt: BluetoothGatt? = null
    var notifyCharacteristic: BluetoothGattCharacteristic? = null
    var writeCharacteristic: BluetoothGattCharacteristic? = null

    private val buffers: MutableMap<UUID, StringBuilder> = mutableMapOf()

    fun clear() {
        gatt = null
        notifyCharacteristic = null
        writeCharacteristic = null
        buffers.clear()
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

    fun onRx(payload: ByteArray, uuid: UUID) {
        val utf8 = runCatching { String(payload, Charsets.UTF_8) }.getOrNull()
        logger.logInfo(TAG, "RX (${uuid} len=${payload.size}): ${HexUtils.toHex(payload)} utf8=$utf8")
        val buffer = buffers.getOrPut(uuid) { StringBuilder() }
        utf8?.let { buffer.append(it) }
        parseJsonFromBuffer(buffer, uuid)
    }

    private fun parseJsonFromBuffer(buffer: StringBuilder, uuid: UUID) {
        var depth = 0
        var startIndex = -1
        var index = 0
        while (index < buffer.length) {
            when (buffer[index]) {
                '{' -> {
                    if (depth == 0) startIndex = index
                    depth++
                }
                '}' -> {
                    depth = (depth - 1).coerceAtLeast(0)
                    if (depth == 0 && startIndex >= 0) {
                        val jsonString = buffer.substring(startIndex, index + 1)
                        handleJson(jsonString, uuid)
                        buffer.delete(0, index + 1)
                        index = -1
                        startIndex = -1
                    }
                }
            }
            index++
        }
        if (buffer.length > MAX_BUFFER_LEN) {
            buffer.clear()
        }
    }

    private fun handleJson(jsonString: String, uuid: UUID) {
        runCatching { JSONObject(jsonString) }
            .onFailure { logger.logError(TAG, "Failed to parse JSON from $uuid: $jsonString error=$it") }
            .onSuccess { json ->
                logger.logInfo(TAG, "Parsed JSON from $uuid: $json")
                bleManager.onProtocolMessage(json, uuid)
            }
    }

    companion object {
        private const val TAG = "BleProtocol"
        private const val MAX_BUFFER_LEN = 4096
    }
}
