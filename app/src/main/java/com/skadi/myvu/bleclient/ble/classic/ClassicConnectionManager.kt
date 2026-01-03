package com.skadi.myvu.bleclient.ble.classic

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.os.SystemClock
import com.skadi.myvu.bleclient.ble.BleLogger
import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean

class ClassicConnectionManager(private val logger: BleLogger) {
    private var socket: BluetoothSocket? = null
    private var connectThread: Thread? = null
    private val handoverInProgress = AtomicBoolean(false)

    fun start(device: BluetoothDevice, trigger: String) {
        close()
        if (!handoverInProgress.compareAndSet(false, true)) {
            return
        }
        val thread = Thread({
            val startedAt = SystemClock.elapsedRealtime()
            logger.logInfo(TAG, ">>> CLASSIC HANDOVER START trigger=$trigger device=${device.address}")
            runCatching { BluetoothAdapter.getDefaultAdapter()?.cancelDiscovery() }
                .onFailure { err -> logger.logError(TAG, "Failed to cancel discovery", err) }

            val primary = runCatching { device.createRfcommSocketToServiceRecord(SPP_UUID) }
                .onFailure { logger.logError(TAG, "Primary RFCOMM socket create failed", it) }
                .getOrNull()

            val connected = connectSocket(primary, "secure", startedAt)
            if (connected) {
                return@Thread
            }

            val fallback = runCatching { device.createInsecureRfcommSocketToServiceRecord(SPP_UUID) }
                .onFailure { logger.logError(TAG, "Insecure RFCOMM socket create failed", it) }
                .getOrNull()

            connectSocket(fallback, "insecure", startedAt)
        }, "classic-conn")
        connectThread = thread
        thread.start()
    }

    private fun connectSocket(candidate: BluetoothSocket?, label: String, startedAt: Long): Boolean {
        if (candidate == null) return false
        logger.logInfo(TAG, ">>> RFCOMM CONNECT ATTEMPT type=$label uuid=$SPP_UUID")
        return try {
            candidate.connect()
            socket = candidate
            val elapsed = SystemClock.elapsedRealtime() - startedAt
            logger.logInfo(TAG, ">>> RFCOMM CONNECTED type=$label elapsedMs=$elapsed")
            true
        } catch (t: Throwable) {
            logger.logError(TAG, ">>> RFCOMM CONNECT FAILED type=$label", t)
            runCatching { candidate.close() }.onFailure { err ->
                logger.logError(TAG, "Failed to close RFCOMM socket after $label failure", err)
            }
            false
        }
    }

    fun close() {
        handoverInProgress.set(false)
        connectThread?.interrupt()
        connectThread = null
        socket?.let {
            runCatching { it.close() }.onFailure { err ->
                logger.logError(TAG, "Failed to close RFCOMM socket", err)
            }
        }
        socket = null
    }

    companion object {
        private const val TAG = "ClassicConnectionMgr"
        private val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
    }
}
