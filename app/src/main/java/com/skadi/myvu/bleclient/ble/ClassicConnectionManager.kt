package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.skadi.myvu.bleclient.util.BluetoothUtils
import java.util.UUID
import java.util.concurrent.TimeoutException

class ClassicConnectionManager(private val context: Context, private val logger: BleLogger) {
    private val mainHandler = Handler(Looper.getMainLooper())
    private var connectThread: Thread? = null
    private var timeoutRunnable: Runnable? = null
    private var socket: BluetoothSocket? = null

    fun startConnection(
        mac: String,
        onConnected: () -> Unit,
        onFailed: (Throwable?) -> Unit
    ) {
        cancel()
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
        logger.logInfo(TAG, "Starting Classic RFCOMM connection to $mac")
        val socket = runCatching { createSocket(device) }
            .getOrElse {
                logger.logError(TAG, "Failed to create RFCOMM socket for $mac", it)
                onFailed(it)
                return
            }
        this.socket = socket
        val thread = Thread {
            try {
                socket.connect()
                logger.logInfo(TAG, "Classic RFCOMM connected to $mac")
                mainHandler.post { cancelTimeout(); onConnected() }
            } catch (t: Throwable) {
                logger.logError(TAG, "Classic RFCOMM connection failed for $mac", t)
                mainHandler.post { cancelTimeout(); onFailed(t) }
            }
        }
        connectThread = thread
        thread.start()
        startTimeout {
            logger.logError(TAG, "Classic RFCOMM connection timed out for $mac")
            closeSocket()
            onFailed(TimeoutException("classic handover timeout"))
        }
    }

    fun cancel() {
        cancelTimeout()
        connectThread?.interrupt()
        connectThread = null
        closeSocket()
    }

    private fun createSocket(device: BluetoothDevice): BluetoothSocket {
        return device.createRfcommSocketToServiceRecord(SPP_UUID)
    }

    private fun startTimeout(onTimeout: () -> Unit) {
        cancelTimeout()
        val runnable = Runnable { onTimeout() }
        timeoutRunnable = runnable
        mainHandler.postDelayed(runnable, TIMEOUT_MS)
    }

    private fun cancelTimeout() {
        timeoutRunnable?.let { mainHandler.removeCallbacks(it) }
        timeoutRunnable = null
    }

    private fun closeSocket() {
        runCatching { socket?.close() }
        socket = null
    }

    companion object {
        private const val TAG = "ClassicConnectionManager"
        private val SPP_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
        private const val TIMEOUT_MS = 8_000L
    }
}
