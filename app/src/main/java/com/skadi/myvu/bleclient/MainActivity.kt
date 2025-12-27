package com.skadi.myvu.bleclient

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.skadi.myvu.bleclient.ble.BleLogger
import com.skadi.myvu.bleclient.ble.BleManager
import com.skadi.myvu.bleclient.ble.BleState
import com.skadi.myvu.bleclient.databinding.ActivityMainBinding
import com.skadi.myvu.bleclient.util.BluetoothUtils
import com.skadi.myvu.bleclient.util.PermissionUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val logger = BleLogger()
    private lateinit var bleManager: BleManager

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { updatePermissionState() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bleManager = BleManager(this, logger)

        setupObservers()
        setupButtons()
        updatePermissionState()
    }

    private fun setupButtons() {
        binding.buttonScan.setOnClickListener {
            if (!PermissionUtils.hasPermissions(this)) {
                PermissionUtils.ensureBlePermissions(this, permissionLauncher)
                return@setOnClickListener
            }
            if (!BluetoothUtils.isBluetoothEnabled(this)) {
                Toast.makeText(this, "Enable Bluetooth first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            bleManager.startScanAndConnect()
        }
        binding.buttonDisconnect.setOnClickListener { bleManager.disconnect() }
        binding.buttonSend.setOnClickListener { bleManager.sendTestCommand() }
    }

    private fun setupObservers() {
        bleManager.state.observe(this, Observer { state ->
            binding.textState.text = "State: ${state.label}" + if (state is BleState.Error) " (${state.reason})" else ""
        })
        bleManager.device.observe(this, Observer { device ->
            binding.textDevice.text = "Device: ${device?.name ?: "--"} ${device?.address ?: ""}".trim()
        })
        logger.logs.observe(this, Observer { logs ->
            binding.textLogs.text = logs.joinToString("\n")
            binding.scrollLogs.post { binding.scrollLogs.fullScroll(android.view.View.FOCUS_DOWN) }
        })
    }

    private fun updatePermissionState() {
        val granted = PermissionUtils.hasPermissions(this)
        binding.textPermission.text = if (granted) {
            "Permissions: granted"
        } else {
            "Permissions: missing (tap Scan & Connect to request)"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bleManager.disconnect()
    }
}
