package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.os.Handler
import android.os.Looper
import java.util.Locale

class BleScanner(
    private val context: Context,
    private val logger: BleLogger,
    private val onDeviceFound: (ScanResult) -> Unit,
    private val onTimeout: () -> Unit
) {
    private val handler = Handler(Looper.getMainLooper())
    private var scanner: BluetoothLeScanner? = null
    private var callback: ScanCallback? = null
    private var fallbackResult: ScanResult? = null

    fun startScan(durationMs: Long = 10_000L) {
        stopScan()
        val adapter = BluetoothAdapter.getDefaultAdapter()
        if (adapter == null || !adapter.isEnabled) {
            logger.logError(TAG, "Bluetooth adapter not available or disabled")
            return
        }
        scanner = adapter.bluetoothLeScanner
        val settings = ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
            .build()
        fallbackResult = null
        callback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                val name = result.device.name ?: "(unknown)"
                logger.logInfo(TAG, "ScanResult: $name ${result.device.address} rssi=${result.rssi}")
                if (isPreferred(name)) {
                    logger.logInfo(TAG, "Preferred device found: $name")
                    stopScan()
                    onDeviceFound(result)
                } else if (fallbackResult == null) {
                    fallbackResult = result
                }
            }

            override fun onScanFailed(errorCode: Int) {
                logger.logError(TAG, "Scan failed code=$errorCode")
                stopScan()
            }
        }
        scanner?.startScan(null, settings, callback)
        logger.logInfo(TAG, "Scan started")
        handler.postDelayed({
            logger.logInfo(TAG, "Scan timeout")
            stopScan()
            fallbackResult?.let { onDeviceFound(it) } ?: onTimeout()
        }, durationMs)
    }

    fun stopScan() {
        handler.removeCallbacksAndMessages(null)
        callback?.let { scanner?.stopScan(it) }
        callback = null
    }

    private fun isPreferred(name: String?): Boolean {
        if (name == null) return false
        val upper = name.uppercase(Locale.US)
        return upper.contains("MYVU") || upper.contains("DCB1")
    }

    companion object {
        private const val TAG = "BleScanner"
    }
}
