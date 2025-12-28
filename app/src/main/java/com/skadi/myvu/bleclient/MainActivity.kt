package com.skadi.myvu.bleclient

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.skadi.myvu.bleclient.ble.BleLogger
import com.skadi.myvu.bleclient.ble.BleManager
import com.skadi.myvu.bleclient.ble.BleState
import com.skadi.myvu.bleclient.util.BluetoothUtils
import com.skadi.myvu.bleclient.util.PermissionUtils

class MainActivity : AppCompatActivity(), BleManager.Listener {
    private lateinit var logger: BleLogger
    private lateinit var bleManager: BleManager

    private lateinit var scanButton: Button
    private lateinit var disconnectButton: Button
    private lateinit var sendButton: Button
    private lateinit var stateValue: TextView
    private lateinit var deviceValue: TextView
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

        scanButton = findViewById(R.id.scanConnectButton)
        disconnectButton = findViewById(R.id.disconnectButton)
        sendButton = findViewById(R.id.sendCommandButton)
        stateValue = findViewById(R.id.stateValue)
        deviceValue = findViewById(R.id.deviceValue)
        logsView = findViewById(R.id.logsView)
        logScroll = findViewById(R.id.logScroll)

        // Attach log listener only after views are ready to avoid lateinit access before init
        logger.addListener(logListener)

        scanButton.setOnClickListener {
            PermissionUtils.ensureBlePermissions(this) { granted ->
                if (granted) {
                    if (!BluetoothUtils.supportsLe(this) || !BluetoothUtils.isBluetoothEnabled(this)) {
                        logger.logError(TAG, "Bluetooth not available or disabled")
                        return@ensureBlePermissions
                    }
                    bleManager.startScanAndConnect()
                } else {
                    logger.logError(TAG, "Permissions not granted")
                }
            }
        }

        disconnectButton.setOnClickListener { bleManager.disconnect() }
        sendButton.setOnClickListener {
            val payload = byteArrayOf(0x01, 0x00)
            val success = bleManager.currentState() is BleState.Ready &&
                bleManager.send(payload, false)
            if (!success) {
                logger.logError(TAG, "Cannot send command; not ready")
            }
        }

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
        }
    }

    override fun onDeviceUpdated(name: String?, address: String?) {
        runOnUiThread {
            deviceValue.text = "${name ?: "(unknown)"} / ${address ?: "-"}"
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
