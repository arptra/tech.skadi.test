package com.skadi.myvu.bleclient

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.skadi.myvu.bleclient.ble.BleErrorReason
import com.skadi.myvu.bleclient.ble.BleLogger
import com.skadi.myvu.bleclient.ble.BleManager
import com.skadi.myvu.bleclient.ble.BleState
import com.skadi.myvu.bleclient.util.BluetoothUtils
import com.skadi.myvu.bleclient.util.PermissionUtils

class MainActivity : AppCompatActivity(), BleManager.Listener {
    private lateinit var logger: BleLogger
    private lateinit var bleManager: BleManager

    private lateinit var scanButton: Button
    private lateinit var connectButton: Button
    private lateinit var bondButton: Button
    private lateinit var disconnectButton: Button
    private lateinit var stateValue: TextView
    private lateinit var deviceValue: TextView
    private lateinit var rssiValue: TextView
    private lateinit var logsView: TextView
    private lateinit var logScroll: ScrollView

    private val logListener: (List<String>) -> Unit = { lines ->
        runOnUiThread {
            logsView.text = lines.joinToString("\n")
            logScroll.post { logScroll.fullScroll(View.FOCUS_DOWN) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logger = BleLogger()
        bleManager = BleManager(this, logger)
        bleManager.setListener(this)

        scanButton = findViewById(R.id.scanButton)
        connectButton = findViewById(R.id.connectButton)
        bondButton = findViewById(R.id.bondButton)
        disconnectButton = findViewById(R.id.disconnectButton)
        stateValue = findViewById(R.id.stateValue)
        deviceValue = findViewById(R.id.deviceValue)
        rssiValue = findViewById(R.id.rssiValue)
        logsView = findViewById(R.id.logsView)
        logScroll = findViewById(R.id.logScroll)

        logger.addListener(logListener)

        scanButton.setOnClickListener {
            PermissionUtils.ensureBlePermissions(this) { granted ->
                if (granted) {
                    if (!BluetoothUtils.supportsLe(this)) {
                        logger.logError(TAG, "Device does not support BLE")
                        return@ensureBlePermissions
                    }
                    if (!BluetoothUtils.isBluetoothEnabled(this)) {
                        logger.logError(TAG, "Bluetooth is disabled")
                        return@ensureBlePermissions
                    }
                    if (!BluetoothUtils.isLocationEnabled(this)) {
                        logger.logError(TAG, "Включите геолокацию: некоторые прошивки скрывают скан без нее")
                        return@ensureBlePermissions
                    }
                    bleManager.startScan()
                } else {
                    logger.logError(TAG, "Permissions not granted")
                }
            }
        }

        connectButton.setOnClickListener { bleManager.connectToTarget() }
        bondButton.setOnClickListener { bleManager.requestBond() }
        disconnectButton.setOnClickListener { bleManager.disconnect() }

        onStateChanged(bleManager.currentState())
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionUtils.onRequestPermissionsResult(requestCode, grantResults)
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.removeListener(logListener)
        bleManager.destroy()
    }

    override fun onStateChanged(state: BleState) {
        runOnUiThread {
            stateValue.text = state.label
            connectButton.isEnabled = state is BleState.DeviceFound
            bondButton.isEnabled = state is BleState.HandshakeDone || state is BleState.WaitingForSystemPairing || state is BleState.Bonded
            disconnectButton.isEnabled = state is BleState.BleConnected || state is BleState.ServicesDiscovering || state is BleState.HandshakeWriting || state is BleState.HandshakeDone || state is BleState.WaitingForSystemPairing || state is BleState.Bonded || state is BleState.Connected
            if (state is BleState.Error && state.reason == BleErrorReason.NO_MATCHING_ADVERTISING) {
                connectButton.isEnabled = false
            }
        }
    }

    override fun onTargetUpdated(address: String?, rssi: Int?, reason: String?) {
        runOnUiThread {
            deviceValue.text = address ?: "-"
            rssiValue.text = rssi?.toString() ?: "-"
            reason?.let { logger.logInfo(TAG, "Selected target $address reason=$it rssi=$rssi") }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
