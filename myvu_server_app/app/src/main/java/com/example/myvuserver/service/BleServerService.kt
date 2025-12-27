package com.example.myvuserver.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myvuserver.ble.BleGattServerController
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
        controller.start()
        createChannel()
        startForeground(NOTIFICATION_ID, buildNotification("Idle"))
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
        val session = controller.currentSession()
        diagLive.postValue(
            ServerDiagnostics(
                bluetoothOn = adapter?.isEnabled == true,
                advertising = controller.isAdvertising(),
                serverOpen = controller.serverOpen,
                lastDevice = session?.device?.address,
                lastDeviceName = session?.device?.name,
                mtu = session?.mtu,
                notifyEnabled = session?.notifyEnabled == true,
                lastSeen = session?.lastSeen
            )
        )
    }

    inner class LocalBinder : Binder() {
        fun getService(): BleServerService = this@BleServerService
    }

    fun logger(): PacketLogger = logger

    fun diagnostics(): LiveData<ServerDiagnostics> = diagLive

    fun startServer(serviceUuid: UUID, charUuid: UUID) {
        controller.updateUuids(serviceUuid, charUuid)
        controller.start()
        pushDiagnostics()
        startForeground(NOTIFICATION_ID, buildNotification("Running"))
    }

    fun stopServer() {
        controller.stop()
        pushDiagnostics()
        startForeground(NOTIFICATION_ID, buildNotification("Stopped"))
    }

    fun startAdvertising() {
        controller.startAdvertising()
        pushDiagnostics()
    }

    fun stopAdvertising() {
        controller.stopAdvertising()
        pushDiagnostics()
    }

    fun sendNotify(payload: ByteArray) {
        controller.sendNotify(payload)
    }

    data class ServerDiagnostics(
        val bluetoothOn: Boolean,
        val advertising: Boolean,
        val serverOpen: Boolean,
        val lastDevice: String?,
        val lastDeviceName: String?,
        val mtu: Int?,
        val notifyEnabled: Boolean,
        val lastSeen: Long?
    )

    companion object {
        const val CHANNEL_ID = "myvu_server_channel"
        const val NOTIFICATION_ID = 101
    }
}
