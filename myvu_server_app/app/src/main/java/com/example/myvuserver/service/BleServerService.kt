package com.example.myvuserver.service

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ServiceInfo
import android.os.Binder
import android.os.Build
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myvuserver.ble.BleGattServerController
import com.example.myvuserver.ble.DeviceSession
import com.example.myvuserver.ble.ProtocolHooks
import com.example.myvuserver.logging.PacketLogger
import java.util.UUID

class BleServerService : Service() {
    private val binder = LocalBinder()
    private lateinit var controller: BleGattServerController
    private lateinit var logger: PacketLogger
    private val hooks = ProtocolHooks()
    private val diagLive = MutableLiveData<ServerDiagnostics>()
    private val diagThread = HandlerThread("diag-thread")
    private lateinit var diagHandler: Handler

    override fun onCreate() {
        super.onCreate()
        logger = PacketLogger(this)
        controller = BleGattServerController(this, logger, hooks)
        val missing = requiredPermissions().filter { !hasPermission(it) }
        createChannel()
        try {
            startForegroundSafe("Idle")
        } catch (se: SecurityException) {
            logger.log("Failed to enter foreground: ${se.message}")
            stopSelf()
            return
        }
        if (missing.isEmpty()) {
            controller.start()
        } else {
            logger.log("Service missing permissions: ${missing.joinToString()} — GATT server not started")
        }
        diagThread.start()
        diagHandler = Handler(diagThread.looper)
        scheduleDiagnostics()
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onDestroy() {
        controller.stop()
        diagThread.quitSafely()
        super.onDestroy()
    }

    private fun createChannel() {
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "MyVU GATT Server",
                NotificationManager.IMPORTANCE_LOW
            )
            nm.createNotificationChannel(channel)
        }
    }

    private fun buildNotification(state: String): Notification {
        val title = "MyVU BLE server"
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_sys_data_bluetooth)
            .setContentTitle(title)
            .setContentText(state)
            .setOngoing(true)
            .build()
    }

    private fun scheduleDiagnostics() {
        diagHandler.postDelayed(object : Runnable {
            override fun run() {
                pushDiagnostics()
                diagHandler.postDelayed(this, 2000)
            }
        }, 2000)
    }

    private fun pushDiagnostics() {
        val adapter = (getSystemService(Context.BLUETOOTH_SERVICE) as? android.bluetooth.BluetoothManager)?.adapter
        val sessions = controller.currentSessions()
        diagLive.postValue(
            ServerDiagnostics(
                bluetoothOn = adapter?.isEnabled == true,
                advertising = controller.isAdvertising(),
                serverOpen = controller.serverOpen,
                sessions = sessions.map { DeviceSnapshot.from(it) }
            )
        )
    }

    inner class LocalBinder : Binder() {
        fun getService(): BleServerService = this@BleServerService
    }

    private fun requiredPermissions(): List<String> {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            listOf(
                Manifest.permission.BLUETOOTH_CONNECT,
                Manifest.permission.BLUETOOTH_ADVERTISE,
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.FOREGROUND_SERVICE_CONNECTED_DEVICE
            )
        } else {
            listOf(
                Manifest.permission.BLUETOOTH,
                Manifest.permission.BLUETOOTH_ADMIN
            )
        }
    }

    private fun hasPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    fun logger(): PacketLogger = logger

    fun diagnostics(): LiveData<ServerDiagnostics> = diagLive

    fun startServer(serviceUuid: UUID) {
        controller.updateServiceUuid(serviceUuid)
        controller.start()
        pushDiagnostics()
        startForegroundSafe("Running")
    }

    fun stopServer() {
        controller.stop()
        pushDiagnostics()
        startForegroundSafe("Stopped")
    }

    fun startAdvertising() {
        controller.startAdvertising()
        pushDiagnostics()
    }

    fun stopAdvertising() {
        controller.stopAdvertising()
        pushDiagnostics()
    }

    fun sendNotify(payload: ByteArray, preferredUuid: UUID?) {
        controller.sendNotify(payload, preferredUuid)
    }

    private fun startForegroundSafe(state: String) {
        val notification = buildNotification(state)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE
            )
        } else {
            startForeground(NOTIFICATION_ID, notification)
        }
    }

    data class DeviceSnapshot(
        val address: String?,
        val name: String?,
        val mtu: Int?,
        val validConnected: Boolean,
        val enabledNotifies: Set<UUID>,
        val lastSeen: Long?,
        val connectedAt: Long?
    ) {
        companion object {
            fun from(session: DeviceSession): DeviceSnapshot = DeviceSnapshot(
                address = session.device.address,
                name = session.device.name,
                mtu = session.mtu,
                validConnected = session.validConnected,
                enabledNotifies = session.enabledNotifies(),
                lastSeen = session.lastSeen,
                connectedAt = session.connectedAt
            )
        }
    }

    data class ServerDiagnostics(
        val bluetoothOn: Boolean,
        val advertising: Boolean,
        val serverOpen: Boolean,
        val sessions: List<DeviceSnapshot>
    )

    companion object {
        const val CHANNEL_ID = "myvu_server_channel"
        const val NOTIFICATION_ID = 101
    }
}
