package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.SystemClock
import com.skadi.myvu.bleclient.util.BluetoothUtils
import java.lang.reflect.Method
import java.util.UUID
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class ClassicConnectionManager(private val context: Context, private val logger: BleLogger) {
    private val executor = Executors.newSingleThreadExecutor { r ->
        Thread(r, "classic-connector").apply { isDaemon = true }
    }
    private var socket: BluetoothSocket? = null
    private var cancelled = false

    fun startConnection(
        mac: String,
        onConnected: () -> Unit,
        onFailed: (Throwable?) -> Unit
    ) {
        cancel()
        cancelled = false
        val adapter = BluetoothUtils.getAdapter(context)
        if (adapter == null) {
            logger.logError(TAG, "Bluetooth adapter unavailable for classic handover")
            onFailed(IllegalStateException("bluetooth adapter unavailable"))
            return
        }
        val device = runCatching { adapter.getRemoteDevice(mac) }
            .getOrElse {
                logger.logError(TAG, "Failed to resolve device for classic handover mac=$mac", it)
                onFailed(it)
                return
            }
        logger.logInfo(TAG, "Starting Classic RFCOMM connection attempts to $mac")
        executor.execute {
            val startMs = SystemClock.elapsedRealtime()
            var lastError: Throwable? = null
            var attempt = 1
            while (attempt <= MAX_ATTEMPTS && !cancelled) {
                BluetoothUtils.getAdapter(context)?.cancelDiscovery()
                val createStart = SystemClock.elapsedRealtime()
                val socketChoice = try {
                    createSocket(device, attempt)
                } catch (t: Throwable) {
                    lastError = t
                    logger.logError(TAG, "Attempt $attempt failed to create socket", t)
                    null
                }

                if (socketChoice == null) {
                    if (attempt < MAX_ATTEMPTS) {
                        sleepWithCancelCheck(attempt)
                    }
                    attempt++
                    continue
                }

                val candidateSocket = socketChoice.socket
                socket = candidateSocket
                val connectStart = SystemClock.elapsedRealtime()
                logger.logInfo(
                    TAG,
                    "Attempt $attempt connecting to $mac via ${socketChoice.label} createdAt=${connectStart - createStart}ms since create"
                )
                try {
                    candidateSocket.connect()
                    val delta = SystemClock.elapsedRealtime() - startMs
                    logger.logInfo(TAG, "Classic RFCOMM connected to $mac on attempt $attempt deltaMs=$delta")
                    onConnected()
                    return@execute
                } catch (t: Throwable) {
                    lastError = t
                    logger.logError(TAG, "Classic RFCOMM attempt $attempt failed for $mac", t)
                    runCatching { candidateSocket.close() }
                }

                if (attempt < MAX_ATTEMPTS) {
                    sleepWithCancelCheck(attempt)
                }
                attempt++
            }

            if (!cancelled) {
                val elapsed = SystemClock.elapsedRealtime() - startMs
                logger.logError(TAG, "Classic RFCOMM connection exhausted attempts after ${elapsed}ms", lastError)
                onFailed(lastError ?: TimeoutException("classic handover timeout"))
            }
        }
    }

    fun cancel() {
        cancelled = true
        executor.execute { closeSocket() }
    }

    private fun sleepWithCancelCheck(attempt: Int) {
        try {
            TimeUnit.MILLISECONDS.sleep(RETRY_BACKOFF_MS * attempt)
        } catch (_: InterruptedException) {
            cancelled = true
        }
    }

    private fun createSocket(device: BluetoothDevice, attempt: Int): SocketChoice {
        return when (attempt) {
            1 -> SocketChoice(device.createRfcommSocketToServiceRecord(SPP_UUID), "secure SPP uuid=${SPP_UUID}")
            2 -> SocketChoice(device.createInsecureRfcommSocketToServiceRecord(SPP_UUID), "insecure SPP uuid=${SPP_UUID}")
            3 -> SocketChoice(createChannelSocket(device, 1, insecure = false), "secure channel 1 reflection")
            4 -> SocketChoice(createChannelSocket(device, 1, insecure = true), "insecure channel 1 reflection")
            else -> SocketChoice(device.createInsecureRfcommSocketToServiceRecord(SPP_UUID), "insecure SPP uuid=${SPP_UUID}")
        }
    }

    private fun createChannelSocket(device: BluetoothDevice, channel: Int, insecure: Boolean): BluetoothSocket {
        val methodName = if (insecure) "createInsecureRfcommSocket" else "createRfcommSocket"
        val method: Method = device.javaClass.getMethod(methodName, Int::class.javaPrimitiveType)
        @Suppress("UNCHECKED_CAST")
        val socket = method.invoke(device, channel) as BluetoothSocket
        logger.logInfo(TAG, "Created ${if (insecure) "insecure" else "secure"} channel socket via reflection ch=$channel")
        return socket
    }

    private data class SocketChoice(val socket: BluetoothSocket, val label: String)

    private fun closeSocket() {
        runCatching { socket?.close() }
        socket = null
    }

    companion object {
        private const val TAG = "ClassicConnectionManager"
        private val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
        private const val MAX_ATTEMPTS = 4
        private const val RETRY_BACKOFF_MS = 150L
    }
}
