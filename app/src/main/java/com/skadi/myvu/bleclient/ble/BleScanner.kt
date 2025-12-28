package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanRecord
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.SparseArray
import com.skadi.myvu.bleclient.util.HexUtils

class BleScanner(
    private val context: Context,
    private val logger: BleLogger,
    private val onDeviceChosen: (ScanResult, String) -> Unit,
    private val onTimeout: () -> Unit
) {
    private val handler = Handler(Looper.getMainLooper())
    private var scanner: BluetoothLeScanner? = null
    private var callback: ScanCallback? = null
    private var bestCandidate: Pair<ScanResult, String>? = null
    private var selectionScheduled = false

    fun startScan(durationMs: Long = DEFAULT_SCAN_MS) {
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
                handleResult(result)
            }

            override fun onBatchScanResults(results: MutableList<ScanResult>) {
                results.forEach { handleResult(it) }
            }

            override fun onScanFailed(errorCode: Int) {
                logger.logError(TAG, "Scan failed code=$errorCode")
                stopScan()
                onTimeout()
            }
        }
        scanner?.startScan(null, settings, callback)
        logger.logInfo(TAG, "Scan started (no filters)")
        handler.postDelayed({ finalizeSelection(timeout = true) }, durationMs)
    }

    fun stopScan() {
        handler.removeCallbacksAndMessages(null)
        callback?.let { scanner?.stopScan(it) }
        callback = null
    }

    private fun handleResult(result: ScanResult) {
        val record = result.scanRecord ?: return
        val rssi = result.rssi
        if (rssi > LOG_RSSI_THRESHOLD) {
            logAdvertising(result, record)
        }
        val matchReason = isMyvuCandidate(result, record) ?: return
        val isBetter = bestCandidate?.first?.rssi?.let { rssi > it } ?: true
        if (isBetter) {
            bestCandidate = result to matchReason
            logger.logInfo(TAG, "MYVU candidate (${result.device.address}) reason=$matchReason rssi=$rssi")
            if (!selectionScheduled) {
                selectionScheduled = true
                handler.postDelayed({ finalizeSelection(timeout = false) }, SELECTION_DEBOUNCE_MS)
            }
        }
    }

    private fun finalizeSelection(timeout: Boolean) {
        stopScan()
        val candidate = bestCandidate
        if (candidate != null) {
            onDeviceChosen(candidate.first, candidate.second)
        } else if (timeout) {
            onTimeout()
        }
    }

    private fun logAdvertising(result: ScanResult, record: ScanRecord) {
        val manufacturerIds = mutableListOf<String>()
        for (i in 0 until record.manufacturerSpecificData.size()) {
            manufacturerIds += "0x${record.manufacturerSpecificData.keyAt(i).toString(16)}"
        }
        logger.logInfo(
            TAG,
            "Adv ${result.device.address} rssi=${result.rssi} mfgIds=${manufacturerIds.joinToString()} mfgData=${manufacturerDataHex(record.manufacturerSpecificData)} raw=${HexUtils.toHex(record.bytes)}"
        )
    }

    private fun manufacturerDataHex(data: SparseArray<ByteArray>): String {
        val builder = StringBuilder()
        for (i in 0 until data.size()) {
            if (builder.isNotEmpty()) builder.append(" | ")
            val id = data.keyAt(i)
            builder.append("id=0x${id.toString(16)}:")
            builder.append(HexUtils.toHex(data.valueAt(i)))
        }
        return builder.toString()
    }

    private fun isMyvuCandidate(result: ScanResult, record: ScanRecord): String? {
        if (result.device.address.equals(KNOWN_MAC, ignoreCase = true)) {
            return "MAC_OVERRIDE"
        }
        val data = record.manufacturerSpecificData
        if (data.size() == 0) return null
        for (i in 0 until data.size()) {
            val id = data.keyAt(i)
            val payload = data.valueAt(i) ?: continue
            if (id == HUBEI_MANUFACTURER_ID && isHubeiPayload(payload)) {
                return "HUBEI_MANUFACTURER"
            }
        }
        return null
    }

    /**
     * Hubei format validation: first byte == payload length (remaining bytes).
     */
    private fun isHubeiPayload(payload: ByteArray): Boolean {
        if (payload.isEmpty()) return false
        val declared = payload[0].toInt() and 0xFF
        return declared == payload.size - 1 && payload.size >= 3
    }

    companion object {
        private const val TAG = "BleScanner"
        private const val LOG_RSSI_THRESHOLD = -80
        private const val HUBEI_MANUFACTURER_ID = 0x02E1
        private const val DEFAULT_SCAN_MS = 25_000L
        private const val SELECTION_DEBOUNCE_MS = 2_000L
        private const val KNOWN_MAC = "2C:6F:4E:00:DC:B1"
    }
}
