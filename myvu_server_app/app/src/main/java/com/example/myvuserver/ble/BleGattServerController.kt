package com.example.myvuserver.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattServer
import android.bluetooth.BluetoothGattServerCallback
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.AdvertiseCallback
import android.bluetooth.le.AdvertiseData
import android.bluetooth.le.AdvertiseSettings
import android.bluetooth.le.BluetoothLeAdvertiser
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.HandlerThread
import android.os.ParcelUuid
import com.example.myvuserver.logging.PacketLogger
import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean

class BleGattServerController(
    private val context: Context,
    private val logger: PacketLogger,
    private val hooks: ProtocolHooks
) {
    private val bluetoothManager: BluetoothManager =
        context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    private val adapter: BluetoothAdapter? = bluetoothManager.adapter
    private val handlerThread = HandlerThread("myvu-ble-server")
    private lateinit var handler: Handler

    private var gattServer: BluetoothGattServer? = null
    private var advertiser: BluetoothLeAdvertiser? = null
    private var advertiseCallback: AdvertiseCallback? = null
    private var characteristic: BluetoothGattCharacteristic? = null

    private var currentServiceUuid: UUID = DEFAULT_SERVICE_UUID
    private var currentCharUuid: UUID = DEFAULT_CHAR_UUID
    private val sessionLock = Any()
    private var session: DeviceSession? = null
    private val advertising = AtomicBoolean(false)

    @Volatile
    var serverOpen: Boolean = false
        private set

    fun start() {
        if (!handlerThread.isAlive) {
            handlerThread.start()
        }
        handler = Handler(handlerThread.looper)
        handler.post {
            openGattServer()
        }
    }

    fun stop() {
        handler.post {
            stopAdvertisingInternal()
            gattServer?.close()
            gattServer = null
            serverOpen = false
            logger.log("GATT server closed")
        }
    }

    fun updateUuids(serviceUuid: UUID, charUuid: UUID) {
        handler.post {
            this.currentServiceUuid = serviceUuid
            this.currentCharUuid = charUuid
            logger.log("UUIDs updated to service=$serviceUuid char=$charUuid; rebuilding server")
            rebuildServer()
        }
    }

    fun startAdvertising() {
        handler.post {
            if (advertising.get()) return@post
            ensureAdvertiser()
            val settings = AdvertiseSettings.Builder()
                .setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY)
                .setTxPowerLevel(AdvertiseSettings.ADVERTISE_TX_POWER_HIGH)
                .setConnectable(true)
                .build()
            val data = AdvertiseData.Builder()
                .setIncludeDeviceName(true)
                .addServiceUuid(ParcelUuid(currentServiceUuid))
                .build()
            advertiseCallback = object : AdvertiseCallback() {
                override fun onStartSuccess(settingsInEffect: AdvertiseSettings) {
                    advertising.set(true)
                    logger.log("Advertising STARTED with service ${currentServiceUuid}")
                }

                override fun onStartFailure(errorCode: Int) {
                    advertising.set(false)
                    logger.log("Advertising FAILED code=$errorCode")
                }
            }
            advertiser?.startAdvertising(settings, data, advertiseCallback)
        }
    }

    fun stopAdvertising() {
        handler.post { stopAdvertisingInternal() }
    }

    fun sendNotify(payload: ByteArray) {
        handler.post {
            val currentSession = synchronized(sessionLock) { session }
            val char = characteristic
            if (gattServer == null || char == null || currentSession == null || !currentSession.notifyEnabled) {
                logger.log("Cannot send notify: server=${gattServer != null} char=${char != null} session=${currentSession != null} notify=${currentSession?.notifyEnabled}")
                return@post
            }
            char.value = payload
            val device = currentSession.device
            logger.log("Sending notify to ${device.address} (${payload.size} bytes)")
            val result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                gattServer?.notifyCharacteristicChanged(device, char, false, payload)
            } else {
                val ok = gattServer?.notifyCharacteristicChanged(device, char, false) ?: false
                if (ok) BluetoothGatt.GATT_SUCCESS else BluetoothGatt.GATT_FAILURE
            }
            logger.log("notifyCharacteristicChanged result=$result")
        }
    }

    fun currentSession(): DeviceSession? = synchronized(sessionLock) { session }

    fun isAdvertising(): Boolean = advertising.get()

    @SuppressLint("MissingPermission")
    private fun openGattServer() {
        if (gattServer != null) return
        val adapter = adapter ?: run {
            logger.log("BluetoothAdapter missing; cannot start server")
            return
        }
        if (!adapter.isEnabled) {
            logger.log("Bluetooth is OFF; prompt user to enable")
            return
        }
        gattServer = bluetoothManager.openGattServer(context, callback)
        serverOpen = gattServer != null
        logger.log("GATT server open=${gattServer != null}")
        rebuildServer()
    }

    @SuppressLint("MissingPermission")
    private fun rebuildServer() {
        val server = gattServer ?: return
        server.clearServices()
        val service = BluetoothGattServiceFactory.createPrimary(currentServiceUuid, currentCharUuid)
        characteristic = service.characteristics.first()
        val added = server.addService(service)
        logger.log("Service add requested result=$added for ${currentServiceUuid}")
    }

    private fun stopAdvertisingInternal() {
        advertiseCallback?.let { advertiser?.stopAdvertising(it) }
        advertising.set(false)
        logger.log("Advertising STOPPED")
    }

    @SuppressLint("MissingPermission")
    private fun ensureAdvertiser() {
        if (advertiser == null) {
            advertiser = adapter?.bluetoothLeAdvertiser
            if (advertiser == null) {
                logger.log("No advertiser available (maybe BT off or hardware missing)")
            }
        }
    }

    private val callback = object : BluetoothGattServerCallback() {
        override fun onConnectionStateChange(device: BluetoothDevice, status: Int, newState: Int) {
            handler.post {
                synchronized(sessionLock) {
                    if (newState == BluetoothProfile.STATE_CONNECTED) {
                        session = DeviceSession(device = device)
                        logger.log("CONNECTED ${device.address} name=${device.name} bond=${device.bondState}")
                    } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                        logger.log("DISCONNECTED ${device.address}")
                        session = null
                    }
                }
            }
        }

        override fun onMtuChanged(device: BluetoothDevice, mtu: Int) {
            handler.post {
                synchronized(sessionLock) {
                    session?.let {
                        it.mtu = mtu
                        it.lastSeen = System.currentTimeMillis()
                        logger.log("MTU updated to $mtu for ${device.address}")
                    }
                }
            }
        }

        override fun onDescriptorWriteRequest(
            device: BluetoothDevice,
            requestId: Int,
            descriptor: BluetoothGattDescriptor,
            preparedWrite: Boolean,
            responseNeeded: Boolean,
            offset: Int,
            value: ByteArray
        ) {
            handler.post {
                val enable = value.contentEquals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)
                if (descriptor.uuid == CCC_UUID) {
                    synchronized(sessionLock) {
                        session?.let {
                            it.notifyEnabled = enable
                            it.lastSeen = System.currentTimeMillis()
                        }
                    }
                    if (enable) {
                        logger.log("XR_VALID_CONNECTED: CCC enabled from ${device.address}")
                    } else {
                        logger.log("CCC disabled from ${device.address}")
                    }
                }
                if (responseNeeded) {
                    gattServer?.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, value)
                }
            }
        }

        override fun onCharacteristicWriteRequest(
            device: BluetoothDevice,
            requestId: Int,
            characteristic: BluetoothGattCharacteristic,
            preparedWrite: Boolean,
            responseNeeded: Boolean,
            offset: Int,
            value: ByteArray
        ) {
            handler.post {
                val hex = hooks.onInboundPayload(value)
                logger.log("WRITE from ${device.address} len=${value.size} offset=$offset prepared=$preparedWrite payload=$hex")
                synchronized(sessionLock) { session?.lastSeen = System.currentTimeMillis() }
                if (responseNeeded) {
                    gattServer?.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, value)
                }
            }
        }

        override fun onNotificationSent(device: BluetoothDevice, status: Int) {
            handler.post {
                logger.log("Notification sent status=$status to ${device.address}")
            }
        }
    }

    object BluetoothGattServiceFactory {
        @SuppressLint("MissingPermission")
        fun createPrimary(serviceUuid: UUID, characteristicUuid: UUID): android.bluetooth.BluetoothGattService {
            val service = android.bluetooth.BluetoothGattService(
                serviceUuid,
                android.bluetooth.BluetoothGattService.SERVICE_TYPE_PRIMARY
            )
            val characteristic = BluetoothGattCharacteristic(
                characteristicUuid,
                BluetoothGattCharacteristic.PROPERTY_WRITE or
                        BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE or
                        BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                BluetoothGattCharacteristic.PERMISSION_WRITE
            )
            val ccc = BluetoothGattDescriptor(
                CCC_UUID,
                BluetoothGattDescriptor.PERMISSION_READ or BluetoothGattDescriptor.PERMISSION_WRITE
            )
            characteristic.addDescriptor(ccc)
            service.addCharacteristic(characteristic)
            return service
        }
    }

    companion object {
        val DEFAULT_SERVICE_UUID: UUID = UUID.fromString("0000FEE0-0000-1000-8000-00805F9B34FB")
        val DEFAULT_CHAR_UUID: UUID = UUID.fromString("0000FEE1-0000-1000-8000-00805F9B34FB")
        val CCC_UUID: UUID = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB")
    }
}
