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
import java.security.SecureRandom
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

    private var currentServiceUuid: UUID = StarryNetUuids.SERVICE
    private var gattProfile: StarryNetGattProfile.Profile = StarryNetGattProfile.build()

    private val sessionLock = Any()
    private val sessions: MutableMap<String, DeviceSession> = mutableMapOf()
    private val advertising = AtomicBoolean(false)

    @Volatile
    var serverOpen: Boolean = false
        private set

    fun start() {
        if (!handlerThread.isAlive) {
            handlerThread.start()
        }
        handler = Handler(handlerThread.looper)
        handler.post { openGattServer() }
    }

    fun stop() {
        handler.post {
            stopAdvertisingInternal()
            gattServer?.close()
            gattServer = null
            serverOpen = false
            sessions.clear()
            logger.log("GATT server closed")
        }
    }

    fun updateServiceUuid(serviceUuid: UUID) {
        handler.post {
            this.currentServiceUuid = serviceUuid
            logger.log("Service UUID updated to $serviceUuid; rebuilding GATT profile")
            rebuildServer()
        }
    }

    fun startAdvertising(includeManufacturerData: Boolean) {
        handler.post {
            if (advertising.get()) return@post
            ensureAdvertiser()
            val settings = AdvertiseSettings.Builder()
                .setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY)
                .setTxPowerLevel(AdvertiseSettings.ADVERTISE_TX_POWER_HIGH)
                .setConnectable(true)
                .build()
            val dataBuilder = AdvertiseData.Builder()
                .setIncludeDeviceName(true)
                .addServiceUuid(ParcelUuid(currentServiceUuid))
            if (includeManufacturerData) {
                val payload = ByteArray(4)
                SecureRandom().nextBytes(payload)
                dataBuilder.addManufacturerData(StarryNetUuids.MANUFACTURER_ID, payload)
                logger.log("Advertising manufacturer data id=0x${StarryNetUuids.MANUFACTURER_ID.toString(16)} payload=${hooks.toHex(payload)}")
            }
            val data = dataBuilder.build()
            advertiseCallback = object : AdvertiseCallback() {
                override fun onStartSuccess(settingsInEffect: AdvertiseSettings) {
                    advertising.set(true)
                    logger.log("Advertising STARTED with service $currentServiceUuid includeMfg=$includeManufacturerData")
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

    fun isAdvertising(): Boolean = advertising.get()

    fun sendNotify(payload: ByteArray, preferredNotifyUuid: UUID? = StarryNetUuids.WRITE_MESSAGE_UUID) {
        handler.post {
            if (gattServer == null) {
                logger.log("Cannot send notify: GATT server is null")
                return@post
            }
            val sessionsSnapshot = synchronized(sessionLock) { sessions.values.toList() }
            if (sessionsSnapshot.isEmpty()) {
                logger.log("Cannot send notify: no sessions")
                return@post
            }
            sessionsSnapshot.forEach { session ->
                val target = pickNotifyTarget(session, preferredNotifyUuid)
                if (target == null) {
                    logger.log("Notify not enabled for ${session.device.address}; prefer=${preferredNotifyUuid}")
                } else {
                    notifyDevice(session.device, target, payload)
                }
            }
        }
    }

    fun currentSessions(): List<DeviceSession> = synchronized(sessionLock) { sessions.values.toList() }

    @SuppressLint("MissingPermission")
    private fun ensureAdvertiser() {
        if (advertiser == null) {
            advertiser = adapter?.bluetoothLeAdvertiser
            if (advertiser == null) {
                logger.log("No advertiser available (maybe BT off or hardware missing)")
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun openGattServer() {
        if (gattServer != null) return
        gattServer = bluetoothManager.openGattServer(context, callback)
        serverOpen = gattServer != null
        if (gattServer == null) {
            logger.log("Failed to open GATT server")
            return
        }
        logger.log("GATT server opened")
        rebuildServer()
    }

    @SuppressLint("MissingPermission")
    private fun rebuildServer() {
        gattServer?.clearServices()
        gattProfile = StarryNetGattProfile.build(currentServiceUuid)
        val added = gattServer?.addService(gattProfile.service)
        logger.log("Rebuilt GATT profile with service=$currentServiceUuid result=$added")
    }

    @SuppressLint("MissingPermission")
    private fun stopAdvertisingInternal() {
        if (advertiseCallback != null) {
            advertiser?.stopAdvertising(advertiseCallback)
            logger.log("Advertising STOPPED")
            advertising.set(false)
            advertiseCallback = null
        }
    }

    private fun pickNotifyTarget(session: DeviceSession, preferred: UUID?): BluetoothGattCharacteristic? {
        val enabled = session.enabledNotifies
        val preferredChar = preferred?.let { gattProfile.characteristics[it] }
        if (preferredChar != null && enabled.contains(preferredChar.uuid)) return preferredChar
        // fallback to the other XR notify channel
        StarryNetUuids.XR_NOTIFY_UUIDS.forEach { uuid ->
            if (enabled.contains(uuid)) {
                val c = gattProfile.characteristics[uuid]
                if (c != null) return c
            }
        }
        return null
    }

    @SuppressLint("MissingPermission")
    private fun notifyDevice(device: BluetoothDevice, characteristic: BluetoothGattCharacteristic, payload: ByteArray) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val status = gattServer?.notifyCharacteristicChanged(device, characteristic, false, payload)
            logger.log("Notify(${characteristic.uuid}) -> ${device.address} status=$status bytes=${hooks.toHex(payload)}")
        } else {
            characteristic.value = payload
            val ok = gattServer?.notifyCharacteristicChanged(device, characteristic, false) ?: false
            logger.log("Notify(${characteristic.uuid}) -> ${device.address} status=$ok bytes=${hooks.toHex(payload)}")
        }
    }

    private val callback = object : BluetoothGattServerCallback() {
        override fun onConnectionStateChange(device: BluetoothDevice, status: Int, newState: Int) {
            handler.post {
                synchronized(sessionLock) {
                    if (newState == BluetoothProfile.STATE_CONNECTED) {
                        val session = DeviceSession(device = device)
                        sessions[device.address] = session
                        logger.log("CONNECTED ${device.address} name=${device.name} bond=${device.bondState}")
                    } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                        sessions.remove(device.address)
                        logger.log("DISCONNECTED ${device.address}")
                    }
                }
            }
        }

        override fun onMtuChanged(device: BluetoothDevice, mtu: Int) {
            handler.post {
                synchronized(sessionLock) {
                    sessions[device.address]?.let {
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
                val charUuid = descriptor.characteristic.uuid
                val enable = value.contentEquals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) ||
                        value.contentEquals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)
                synchronized(sessionLock) {
                    val session = sessions[device.address]
                    if (session != null && descriptor.uuid == Uuid16.CCC) {
                        if (enable) {
                            session.enabledNotifies.add(charUuid)
                        } else {
                            session.enabledNotifies.remove(charUuid)
                        }
                        session.lastSeen = System.currentTimeMillis()
                        val wasValid = session.validConnected
                        session.validConnected = StarryNetUuids.XR_NOTIFY_UUIDS.any { session.enabledNotifies.contains(it) }
                        if (!wasValid && session.validConnected) {
                            logger.log("VALID_XR_CONNECTED after CCC enable on $charUuid from ${device.address}")
                        } else if (wasValid && !session.validConnected) {
                            logger.log("XR validity revoked (CCC disabled) from ${device.address}")
                        } else {
                            logger.log("CCC change char=$charUuid enable=$enable from ${device.address}")
                        }
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
                val hex = hooks.toHex(value)
                logger.log("WRITE ${characteristic.uuid} from ${device.address} len=${value.size} offset=$offset prepared=$preparedWrite payload=$hex")
                synchronized(sessionLock) { sessions[device.address]?.lastSeen = System.currentTimeMillis() }
                handleProtocolWrite(device, characteristic.uuid, value)
                if (responseNeeded) {
                    gattServer?.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, value)
                }
            }
        }

        override fun onNotificationSent(device: BluetoothDevice, status: Int) {
            handler.post { logger.log("Notification sent status=$status to ${device.address}") }
        }
    }

    private fun handleProtocolWrite(device: BluetoothDevice, uuid: UUID, payload: ByteArray) {
        // Only echo on the expected write pipes.
        if (uuid != StarryNetUuids.WRITE_UUID && uuid != StarryNetUuids.GLASS_WRITE_UUID) return
        val header = byteArrayOf(0xAA.toByte(), 0x55.toByte())
        val length = payload.size
        val lenBytes = byteArrayOf((length and 0xFF).toByte(), ((length ushr 8) and 0xFF).toByte())
        val response = header + lenBytes + payload
        // TODO: add CRC16 if we learn the exact polynomial used by the glasses
        val session = synchronized(sessionLock) { sessions[device.address] }
        val target = session?.let { pickNotifyTarget(it, StarryNetUuids.WRITE_MESSAGE_UUID) }
            ?: session?.let { pickNotifyTarget(it, StarryNetUuids.MULTI_WRITE_UUID) }
        if (target == null) {
            logger.log("Notify not enabled for ${device.address}; cannot echo write")
            return
        }
        notifyDevice(device, target, response)
    }
}
