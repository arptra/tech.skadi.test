package com.example.myvuserver

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myvuserver.databinding.ActivityMainBinding
import com.example.myvuserver.logging.PacketLogger
import com.example.myvuserver.service.BleServerService
import java.util.UUID

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val logAdapter = LogAdapter()
    private var bleService: BleServerService? = null
    private var logger: PacketLogger? = null
    private var bound = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BleServerService.LocalBinder
            bleService = binder.getService()
            logger = bleService?.logger()
            hookObservers()
            bound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            bleService = null
            logger = null
            bound = false
        }
    }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { updatePermissionState() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
        startAndBindService()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (bound) {
            unbindService(connection)
        }
    }

    private fun setupUi() {
        binding.logRecycler.layoutManager = LinearLayoutManager(this)
        binding.logRecycler.adapter = logAdapter

        binding.startServer.setOnClickListener {
            if (!ensurePermissions()) return@setOnClickListener
            val serviceUuid = uuidFromInput(binding.serviceUuidInput.text.toString(), BleGattDefaults.SERVICE)
            bleService?.startServer(serviceUuid)
        }

        binding.stopServer.setOnClickListener {
            bleService?.stopAdvertising()
            bleService?.stopServer()
        }

        binding.startAdvertising.setOnClickListener {
            if (!ensurePermissions()) return@setOnClickListener
            bleService?.startAdvertising(binding.includeMfgData.isChecked)
        }

        binding.stopAdvertising.setOnClickListener { bleService?.stopAdvertising() }

        binding.sendNotify.setOnClickListener {
            val hex = binding.notifyPayload.text.toString().trim()
            val payload = hexToBytes(hex)
            val preferred = uuidFromInput(binding.charUuidInput.text.toString(), BleGattDefaults.CHAR)
            bleService?.sendNotify(payload, preferred)
        }

        binding.exportLogs.setOnClickListener {
            logger?.let {
                val file = it.exportToFile()
                shareFile(file)
            }
        }

        binding.openBtSettings.setOnClickListener {
            startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS))
        }

        updatePermissionState()
        refreshBluetoothState()
    }

    private fun startAndBindService() {
        val intent = Intent(this, BleServerService::class.java)
        ContextCompat.startForegroundService(this, intent)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    private fun hookObservers() {
        logger?.logs?.observe(this) { logAdapter.submit(it) }
        bleService?.diagnostics()?.observe(this) { diag ->
            val sb = StringBuilder()
            sb.appendLine("Bluetooth ON: ${diag.bluetoothOn}")
            sb.appendLine("Advertising: ${diag.advertising}")
            sb.appendLine("GATT server open: ${diag.serverOpen}")
            if (diag.sessions.isEmpty()) {
                sb.appendLine("No connected devices")
                binding.connectedDevices.text = "Devices: none"
            } else {
                val statusLines = diag.sessions.joinToString("\n") {
                    "${it.address} (${it.name}) mtu=${it.mtu} valid=${it.validConnected} notifies=${it.enabledNotifies.joinToString()}"
                }
                binding.connectedDevices.text = statusLines
                sb.appendLine("Devices: ${diag.sessions.size}")
                sb.append(statusLines)
            }
            binding.diagnosticsText.text = sb.toString()
        }
    }

    private fun ensurePermissions(): Boolean {
        val missing = requiredPermissions().filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
        return if (missing.isNotEmpty()) {
            permissionLauncher.launch(missing.toTypedArray())
            false
        } else {
            true
        }
    }

    private fun updatePermissionState() {
        val missing = requiredPermissions().filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
        binding.permissionStatus.text = if (missing.isEmpty()) {
            "Permissions OK"
        } else {
            "Missing: ${missing.joinToString()}"
        }
    }

    private fun refreshBluetoothState() {
        val adapter = BluetoothAdapter.getDefaultAdapter()
        binding.bluetoothState.text = if (adapter?.isEnabled == true) {
            "Bluetooth: ON"
        } else {
            "Bluetooth: OFF (enable in settings)"
        }
    }

    private fun requiredPermissions(): List<String> {
        val perms = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            perms += listOf(
                Manifest.permission.BLUETOOTH_CONNECT,
                Manifest.permission.BLUETOOTH_ADVERTISE,
                Manifest.permission.BLUETOOTH_SCAN
            )
        } else {
            perms += listOf(
                Manifest.permission.BLUETOOTH,
                Manifest.permission.BLUETOOTH_ADMIN,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
        return perms
    }

    private fun hexToBytes(hex: String): ByteArray {
        val clean = hex.replace(" ", "").replace("-", "")
        if (clean.isEmpty()) return ByteArray(0)
        val output = ByteArray(clean.length / 2)
        for (i in output.indices) {
            val index = i * 2
            output[i] = clean.substring(index, index + 2).toInt(16).toByte()
        }
        return output
    }

    private fun uuidFromInput(text: String, fallback: UUID): UUID {
        return runCatching { UUID.fromString(text.trim()) }.getOrElse { fallback }
    }

    private fun shareFile(file: java.io.File) {
        val uri = Uri.fromFile(file)
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_SUBJECT, "MyVU server logs")
        }
        startActivity(Intent.createChooser(intent, "Share logs"))
    }

    object BleGattDefaults {
        val SERVICE: UUID = UUID.fromString("00000BD1-0000-1000-8000-00805F9B34FB")
        val CHAR: UUID = UUID.fromString("00002002-0000-1000-8000-00805F9B34FB")
    }
}
