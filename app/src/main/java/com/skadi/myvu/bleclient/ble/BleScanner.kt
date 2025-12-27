package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.skadi.myvu.bleclient.util.BluetoothUtils
import java.util.Locale

class BleScanner(
    private val context: Context,
    private val logger: BleLogger,
    private val onDeviceFound: (BluetoothDevice) -> Unit,
    private val onTimeout: () -> Unit,
    private val onError: (String) -> Unit
) {
    private val handler = Handler(Looper.getMainLooper())
    private var scanning = false
    private var bestDevice: BluetoothDevice? = null
    private var scanner: BluetoothLeScanner? = null

    private val callback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            super.onScanResult(callbackType, result)
            handleResult(result)
        }

        override fun onBatchScanResults(results: MutableList<ScanResult>) {
            super.onBatchScanResults(results)
            results.forEach { handleResult(it) }
        }

        override fun onScanFailed(errorCode: Int) {
            super.onScanFailed(errorCode)
            stopScan()
            onError("Scan failed: $errorCode")
        }
    }

    fun startScan(timeoutMs: Long = 10_000L) {
        if (scanning) return
        val adapter: BluetoothAdapter = BluetoothUtils.adapter(context)
            ?: return onError("Bluetooth adapter unavailable")
        scanner = adapter.bluetoothLeScanner
        if (scanner == null) {
            onError("BluetoothLeScanner null")
            return
        }
        scanning = true
        bestDevice = null
        logger.logInfo("BleScanner", "Starting scan for MYVU/DCB1 targets")
        handler.postDelayed({
            if (scanning) {
                logger.logInfo("BleScanner", "Scan timeout")
                stopScan()
                onTimeout()
            }
        }, timeoutMs)
        val settings = ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
            .build()
        scanner?.startScan(null, settings, callback)
    }

    fun stopScan() {
        if (!scanning) return
        scanning = false
        try {
            scanner?.stopScan(callback)
        } catch (_: Exception) {
        }
    }

    private fun handleResult(result: ScanResult) {
        val device = result.device ?: return
        val name = device.name
        val address = device.address
        val preferred = name?.let {
            it.lowercase(Locale.US).contains("myvu") || it.lowercase(Locale.US).contains("dcb1")
        } ?: false
        logger.logInfo("BleScanner", "Found ${name ?: "<unknown>"} $address RSSI ${result.rssi}")
        if (preferred && scanning) {
            bestDevice = device
            stopScan()
            onDeviceFound(device)
        } else if (bestDevice == null) {
            bestDevice = device
            stopScan()
            onDeviceFound(device)
        }
    }
}
