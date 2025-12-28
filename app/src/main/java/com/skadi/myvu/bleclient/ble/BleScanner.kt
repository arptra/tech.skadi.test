package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.os.Handler
import android.os.Looper

class BleScanner(
    private val context: Context,
    private val logger: BleLogger,
    private val onDeviceFound: (ScanResult) -> Unit,
    private val onTimeout: () -> Unit
) {
    private val handler = Handler(Looper.getMainLooper())
    private var scanner: BluetoothLeScanner? = null
    private var callback: ScanCallback? = null

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
        callback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                val record = result.scanRecord ?: return
                logger.logInfo(
                    TAG,
                    "ScanResult: ${result.device.address} rssi=${result.rssi} hasManufacturer=${record.manufacturerSpecificData.size() > 0}"
                )
                if (isMyvuAdvert(record.manufacturerSpecificData)) {
                    logger.logInfo(TAG, "MYVU manufacturer payload detected; selecting device ${result.device.address}")
                    stopScan()
                    onDeviceFound(result)
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
            onTimeout()
        }, durationMs)
    }

    fun stopScan() {
        handler.removeCallbacksAndMessages(null)
        callback?.let { scanner?.stopScan(it) }
        callback = null
    }

    private fun isMyvuAdvert(manufacturerData: android.util.SparseArray<ByteArray>): Boolean {
        if (manufacturerData.size() == 0) return false
        for (index in 0 until manufacturerData.size()) {
            val id = manufacturerData.keyAt(index)
            val payload = manufacturerData.valueAt(index) ?: continue
            if (id == HUBEI_MANUFACTURER_ID && isHubeiPayload(payload)) {
                return true
            }
        }
        return false
    }

    /**
     * Simple validation of the Hubei manufacturer payload: first byte encodes payload length.
     * Adjust validation if the proprietary frame format changes.
     */
    private fun isHubeiPayload(payload: ByteArray): Boolean {
        if (payload.isEmpty()) return false
        val declaredLength = payload[0].toInt() and 0xFF
        return declaredLength == payload.size - 1 && payload.size >= 3
    }

    companion object {
        private const val TAG = "BleScanner"
        private const val HUBEI_MANUFACTURER_ID = 0x02E1 // Assigned to Hubei vendor
    }
}
