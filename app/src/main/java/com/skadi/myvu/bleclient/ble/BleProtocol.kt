package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.os.Handler
import android.os.Looper
import com.skadi.myvu.bleclient.util.HexUtils
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.UUID
import org.json.JSONObject
import kotlin.text.Charsets

class BleProtocol(
    private val bleManager: BleManager,
    private val logger: BleLogger
) {
    var gatt: BluetoothGatt? = null
    var notifyCharacteristic: BluetoothGattCharacteristic? = null
    var writeCharacteristic: BluetoothGattCharacteristic? = null

    private data class FragmentBuffer(
        val data: ByteArrayOutputStream = ByteArrayOutputStream(),
        var flushRunnable: Runnable? = null
    )

    private val handler = Handler(Looper.getMainLooper())
    private val buffers: MutableMap<UUID, FragmentBuffer> = mutableMapOf()

    fun clear() {
        gatt = null
        notifyCharacteristic = null
        writeCharacteristic = null
        buffers.values.forEach { buffer ->
            buffer.flushRunnable?.let { handler.removeCallbacks(it) }
        }
        buffers.clear()
    }

    fun send(payload: ByteArray, withResponse: Boolean = false): Boolean {
        val char = writeCharacteristic ?: return false.also {
            logger.logError(TAG, "No write characteristic available")
        }
        val gattInstance = gatt ?: return false.also {
            logger.logError(TAG, "No active GATT session")
        }
        val maxChunk = bleManager.maxWritePayload()
        var fragmentIndex = 0
        var offset = 0
        if (payload.isEmpty()) {
            val framed = framePayload(byteArrayOf(), fragmentIndex)
            return bleManager.enqueueCharacteristicWrite(gattInstance, char, framed, withResponse)
        }
        while (offset < payload.size) {
            val end = (offset + maxChunk).coerceAtMost(payload.size)
            val chunk = payload.copyOfRange(offset, end)
            val framed = framePayload(chunk, fragmentIndex)
            val enqueued = bleManager.enqueueCharacteristicWrite(gattInstance, char, framed, withResponse)
            if (!enqueued) return false
            offset = end
            fragmentIndex++
        }
        return true
    }

    fun onRx(payload: ByteArray, uuid: UUID) {
        if (payload.size < 2) {
            logger.logError(TAG, "Received payload too small for framing from $uuid: ${HexUtils.toHex(payload)}")
            return
        }
        val fragmentIndex = ByteBuffer.wrap(payload, 0, 2).order(ByteOrder.LITTLE_ENDIAN).short.toInt() and 0xFFFF
        val chunk = payload.copyOfRange(2, payload.size)
        val buffer = buffers.getOrPut(uuid) { FragmentBuffer() }
        if (fragmentIndex == 0 && buffer.data.size() > 0) {
            finalizeBuffer(uuid, buffer)
        }
        buffer.data.write(chunk)
        scheduleFlush(uuid, buffer)
    }

    private fun finalizeBuffer(uuid: UUID, buffer: FragmentBuffer) {
        val message = buffer.data.toByteArray()
        buffer.data.reset()
        buffer.flushRunnable?.let { handler.removeCallbacks(it) }
        buffer.flushRunnable = null
        if (message.isEmpty()) return
        logger.logInfo(
            TAG,
            "Assembled message from $uuid len=${message.size} preview=${HexUtils.toHex(message.take(16).toByteArray())}"
        )
        bleManager.onFramedPayload(message, uuid)
        val jsonText = runCatching { String(message, Charsets.UTF_8) }.getOrNull()
        jsonText?.takeIf { it.trim().startsWith("{") }?.let { text ->
            runCatching { JSONObject(text) }
                .onSuccess { json -> bleManager.onProtocolMessage(json, uuid) }
                .onFailure { logger.logError(TAG, "Failed to parse JSON from $uuid: $text error=$it") }
        }
    }

    private fun scheduleFlush(uuid: UUID, buffer: FragmentBuffer) {
        buffer.flushRunnable?.let { handler.removeCallbacks(it) }
        val runnable = Runnable { finalizeBuffer(uuid, buffer) }
        buffer.flushRunnable = runnable
        handler.postDelayed(runnable, FLUSH_DELAY_MS)
    }

    private fun framePayload(payload: ByteArray, fragmentIndex: Int): ByteArray {
        val buffer = ByteBuffer.allocate(2 + payload.size).order(ByteOrder.LITTLE_ENDIAN)
        buffer.putShort(fragmentIndex.toShort())
        buffer.put(payload)
        return buffer.array()
    }

    companion object {
        private const val TAG = "BleProtocol"
        private const val FLUSH_DELAY_MS = 100L
    }
}
