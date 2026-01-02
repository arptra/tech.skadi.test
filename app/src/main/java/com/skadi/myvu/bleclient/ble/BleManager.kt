package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattService
import android.bluetooth.BluetoothProfile
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.Looper
import com.skadi.myvu.bleclient.util.BluetoothUtils
import com.skadi.myvu.bleclient.util.HexUtils
import java.util.LinkedList
import java.util.UUID
import org.json.JSONObject
import kotlin.text.Charsets

class BleManager(private val context: Context, private val logger: BleLogger) {
    interface Listener {
        fun onStateChanged(state: BleState)
        fun onTargetUpdated(address: String?, rssi: Int?, reason: String?)
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    private val operationQueue: LinkedList<Operation> = LinkedList()
    private val timeouts = mutableMapOf<String, Runnable>()
    private val prefs = context.getSharedPreferences("ble_prefs", Context.MODE_PRIVATE)
    private data class CccdRequest(
        val descriptor: BluetoothGattDescriptor,
        val value: ByteArray,
        val label: String
    )

    private val enableCccdQueue: LinkedList<CccdRequest> = LinkedList()

    private var listener: Listener? = null
    private var scanner: BleScanner? = null
    private var targetDevice: BluetoothDevice? = null
    private var targetRssi: Int? = null
    private var targetReason: String? = null
    private var gatt: BluetoothGatt? = null
    private var protocol: BleProtocol = BleProtocol(this, logger)
    private var state: BleState = BleState.Idle
    private var connectRetries = 0
    private var vendorService: BluetoothGattService? = null
    private var notifyCharacteristics: List<BluetoothGattCharacteristic> = emptyList()
    private var indicateCharacteristics: List<BluetoothGattCharacteristic> = emptyList()
    private var pendingCccdWrites = 0
    private var handshakeCommandSent = false
    private var startCommandPending = false
    private var awaitingFirstNotify = false
    private var mtuRequested = false
    private var mtuReady = false
    private var operationInProgress = false
    private var totalNotifyCharacteristics = 0

    fun setListener(listener: Listener) {
        this.listener = listener
        listener.onTargetUpdated(targetDevice?.address ?: prefs.getString(KEY_LAST_TARGET, null), targetRssi, targetReason)
    }

    fun removeListener() {
        this.listener = null
    }

    init {
        registerBondReceiver()
    }

    fun currentState(): BleState = state

    fun startScan() {
        resetConnection()
        targetDevice = null
        targetRssi = null
        targetReason = null
        listener?.onTargetUpdated(null, null, null)
        setState(BleState.Scanning)
        scanner = BleScanner(
            context,
            logger,
            onDeviceChosen = { result, reason ->
                targetDevice = result.device
                targetRssi = result.rssi
                targetReason = reason
                prefs.edit().putString(KEY_LAST_TARGET, result.device.address).apply()
                listener?.onTargetUpdated(result.device.address, result.rssi, reason)
                stopTimeout(TIMEOUT_SCAN)
            },
            onTimeout = {
                if (state is BleState.Scanning) {
                    setState(BleState.Error(BleErrorReason.NO_MATCHING_ADVERTISING))
                }
            }
        )
        scanner?.startScan(SCAN_TIMEOUT_MS)
        startTimeout(TIMEOUT_SCAN, SCAN_TIMEOUT_MS) {
            if (state is BleState.Scanning) {
                setState(BleState.Error(BleErrorReason.SCAN_TIMEOUT))
            }
        }
    }

    fun connectToTarget() {
        val device = targetDevice ?: run {
            logger.logError(TAG, "No target device fixed from scan")
            return
        }
        scanner?.stopScan()
        setState(BleState.Connecting)
        startTimeout(TIMEOUT_CONNECT, CONNECT_TIMEOUT_MS) {
            setState(BleState.Error(BleErrorReason.GATT_CONNECT_FAILED))
            disconnect()
        }
        gatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
    }

    fun requestBond() {
        logger.logInfo(TAG, "Bonding is managed by the device; manual request ignored")
    }

    fun disconnect() {
        logger.logInfo(TAG, "Disconnect requested")
        stopTimeouts()
        scanner?.stopScan()
        clearQueue()
        gatt?.disconnect()
        gatt?.close()
        gatt = null
        protocol.clear()
        pendingCccdWrites = 0
        handshakeCommandSent = false
        startCommandPending = false
        connectRetries = 0
        setState(BleState.Disconnected)
    }

    fun destroy() {
        disconnect()
        removeListener()
        unregisterBondReceiver()
    }

    fun send(payload: ByteArray, withResponse: Boolean = false): Boolean = protocol.send(payload, withResponse)

    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            logger.logInfo(TAG, "onConnectionStateChange status=$status newState=$newState")
            handleConnectionStateChange(gatt, status, newState)
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            logger.logInfo(TAG, "onServicesDiscovered status=$status")
            handleServicesDiscovered(gatt, status)
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            logger.logInfo(TAG, "onDescriptorWrite ${descriptor.uuid} status=$status")
            handleDescriptorWrite(gatt, descriptor, status)
        }

        override fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
            logger.logInfo(TAG, "onCharacteristicWrite ${characteristic.uuid} status=$status")
            handleCharacteristicWrite(gatt, characteristic, status)
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray) {
            val utf8 = runCatching { String(value, Charsets.UTF_8) }.getOrNull()
            val isIndicate = characteristic.properties and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0
            val packetType = if (isIndicate) "INDICATE" else "NOTIFY"
            val timestamp = System.currentTimeMillis()
            logger.logInfo(
                TAG,
                "RX $packetType (${characteristic.uuid} len=${value.size} @${timestamp}): ${HexUtils.toHex(value)} utf8=$utf8"
            )
            handleFirstPacketIfWaiting(characteristic.uuid, packetType)
            protocol.onRx(value, characteristic.uuid)
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            val payload = characteristic.value ?: byteArrayOf()
            onCharacteristicChanged(gatt, characteristic, payload)
        }

        override fun onMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
            logger.logInfo(TAG, "onMtuChanged mtu=$mtu status=$status")
            if (status == BluetoothGatt.GATT_SUCCESS) {
                mtuReady = true
                logger.logInfo(TAG, "MTU negotiated to $mtu")
            }
            if (!handshakeCommandSent) {
                sendStartCommand(gatt, reason = "mtu_changed")
            }
        }
    }

    private val bondReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action != BluetoothDevice.ACTION_BOND_STATE_CHANGED) return
            val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
            val bondState = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.ERROR)
            val prevState = intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.ERROR)
            val deviceAddress = device?.address ?: "unknown"
            logger.logInfo(TAG, "Bond state changed for $deviceAddress prev=$prevState new=$bondState")
            if (device != null && device == gatt?.device) {
                when (bondState) {
                    BluetoothDevice.BOND_BONDING -> logger.logInfo(TAG, "System bonding in progress")
                    BluetoothDevice.BOND_BONDED -> logger.logInfo(TAG, "System bonding completed; keeping session alive")
                    BluetoothDevice.BOND_NONE -> logger.logInfo(TAG, "Bond removed or failed")
                }
            }
        }
    }

    private fun handleConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
        stopTimeout(TIMEOUT_CONNECT)
        if (status == 133) {
            logger.logError(TAG, "GATT 133 encountered; retrying")
            if (connectRetries < MAX_RETRIES) {
                connectRetries++
                retryConnection(gatt.device)
                return
            } else {
                setState(BleState.Error(BleErrorReason.GATT_CONNECT_FAILED))
                disconnect()
                return
            }
        }
        if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
            connectRetries = 0
            setState(BleState.ServicesDiscovering)
            startTimeout(TIMEOUT_DISCOVERY, DISCOVERY_TIMEOUT_MS) {
                setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
                disconnect()
            }
            gatt.discoverServices()
        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            logger.logInfo(TAG, "Disconnected status=$status")
            if (state !is BleState.Disconnected && state !is BleState.Idle) {
                setState(BleState.Error(BleErrorReason.GATT_CONNECT_FAILED))
            }
            cleanupAfterDisconnect()
        }
    }

    private fun retryConnection(device: BluetoothDevice) {
        logger.logInfo(TAG, "Retrying connection attempt $connectRetries")
        this.gatt?.close()
        BluetoothUtils.refreshGattCache(this.gatt)
        mainHandler.postDelayed({ connectToTarget() }, RETRY_DELAY_MS)
    }

    private fun handleServicesDiscovered(gatt: BluetoothGatt, status: Int) {
        stopTimeout(TIMEOUT_DISCOVERY)
        if (status != BluetoothGatt.GATT_SUCCESS) {
            setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
            disconnect()
            return
        }
        val service = gatt.getService(UUID.fromString(SERVICE_UUID))
        val controlChar = service?.getCharacteristic(UUID.fromString(CONTROL_UUID))
        if (service == null || controlChar == null) {
            logger.logError(TAG, "Required service/characteristics missing")
            setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
            disconnect()
            return
        }
        protocol.gatt = gatt
        protocol.notifyCharacteristic = service.getCharacteristic(UUID.fromString(NOTIFY_UUID))
        protocol.writeCharacteristic = controlChar
        vendorService = service
        logGattDump(gatt.services)

        handshakeCommandSent = false
        awaitingFirstNotify = false
        mtuRequested = false
        mtuReady = false
        enableCccdQueue.clear()
        pendingCccdWrites = 0

        notifyCharacteristics = service.characteristics.filter {
            it.properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0
        }
        val indicates = service.characteristics.filter {
            it.properties and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0
        }.toMutableList()
        val gattService = gatt.getService(UUID.fromString(GATT_SERVICE_UUID))
        val serviceChanged = gattService?.getCharacteristic(UUID.fromString(SERVICE_CHANGED_UUID))
        if (serviceChanged != null && serviceChanged.properties and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0) {
            indicates.add(serviceChanged)
        }
        indicateCharacteristics = indicates
        totalNotifyCharacteristics = notifyCharacteristics.size + indicateCharacteristics.size
        logger.logInfo(
            TAG,
            "Notify-capable chars (${notifyCharacteristics.size}): ${notifyCharacteristics.joinToString { it.uuid.toString() }}"
        )
        logger.logInfo(
            TAG,
            "Indicate-capable chars (${indicateCharacteristics.size}): ${indicateCharacteristics.joinToString { it.uuid.toString() }}"
        )

        notifyCharacteristics.forEach { characteristic ->
            buildCccdDescriptor(gatt, characteristic, "notify_${characteristic.uuid}", BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)?.let {
                enqueueCccd(it)
            }
        }

        indicateCharacteristics.forEach { characteristic ->
            buildCccdDescriptor(gatt, characteristic, "indicate_${characteristic.uuid}", BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)?.let {
                enqueueCccd(it)
            }
        }

        pendingCccdWrites = enableCccdQueue.size
        if (pendingCccdWrites == 0) {
            setState(BleState.Error(BleErrorReason.CCCD_ENABLE_FAILED))
            disconnect()
            return
        }
        logger.logInfo(TAG, "Total CCCD writes queued=$pendingCccdWrites")
        setState(BleState.EnablingNotifications)
        processNextCccdWrite(gatt)
    }

    private fun buildCccdDescriptor(
        gatt: BluetoothGatt,
        characteristic: BluetoothGattCharacteristic?,
        label: String,
        value: ByteArray
    ): BluetoothGattDescriptor? {
        characteristic ?: return null.also {
            logger.logError(TAG, "Missing $label characteristic when preparing CCCD")
        }
        val cccd = characteristic.getDescriptor(UUID.fromString(CCCD_UUID))
        if (cccd == null) {
            logger.logError(TAG, "CCCD descriptor missing for $label char=${characteristic.uuid}")
            return null
        }
        val enabled = enableNotifications(gatt, characteristic)
        if (!enabled) {
            logger.logError(TAG, "Failed to enable notifications for $label char=${characteristic.uuid}")
            return null
        }
        return cccd.also {
            it.value = value
        }
    }

    private fun enqueueCccd(descriptor: BluetoothGattDescriptor) {
        logger.logInfo(
            TAG,
            "Queueing CCCD enable for char=${descriptor.characteristic.uuid} desc=${descriptor.uuid} value=${HexUtils.toHex(descriptor.value)}"
        )
        enableCccdQueue.add(CccdRequest(descriptor, descriptor.value, "cccd_${descriptor.characteristic.uuid}"))
    }

    private fun processNextCccdWrite(gatt: BluetoothGatt) {
        val request = enableCccdQueue.peekFirst()
        if (request == null) {
            onAllCccdsEnabled(gatt)
            return
        }
        logger.logInfo(
            TAG,
            "Writing CCCD for char=${request.descriptor.characteristic.uuid} desc=${request.descriptor.uuid} value=${HexUtils.toHex(request.value)}"
        )
        request.descriptor.value = request.value
        enqueueDescriptorWrite(gatt, request.descriptor)
    }

    private fun onAllCccdsEnabled(gatt: BluetoothGatt) {
        logger.logInfo(TAG, "All notifications/indications enabled ($totalNotifyCharacteristics chars)")
        setState(BleState.MtuNegotiation)
        if (!mtuRequested) {
            mtuRequested = true
            val requested = gatt.requestMtu(256)
            logger.logInfo(TAG, "Requesting MTU 256 requested=$requested")
            if (!requested && !handshakeCommandSent) {
                sendStartCommand(gatt, reason = "mtu_request_failed")
            }
        }
    }

    private fun enableNotifications(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic): Boolean {
        val success = gatt.setCharacteristicNotification(characteristic, true)
        if (!success) {
            logger.logError(TAG, "Failed to enable notification for ${characteristic.uuid}")
        } else if (characteristic.uuid.toString().equals(SERVICE_CHANGED_UUID, ignoreCase = true)) {
            logger.logInfo(TAG, "Indication enabled for ${characteristic.uuid}")
        }
        return success
    }

    private fun handleDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
        if (status != BluetoothGatt.GATT_SUCCESS) {
            logger.logError(TAG, "CCCD write failed for ${descriptor.characteristic.uuid} status=$status")
            setState(BleState.Error(BleErrorReason.CCCD_ENABLE_FAILED))
            disconnect()
            return
        }
        if (pendingCccdWrites > 0) {
            pendingCccdWrites--
        }
        if (enableCccdQueue.isNotEmpty()) {
            enableCccdQueue.pollFirst()
        }
        if (enableCccdQueue.isNotEmpty()) {
            processNextCccdWrite(gatt)
        } else if (pendingCccdWrites == 0) {
            onAllCccdsEnabled(gatt)
        }
        onOperationComplete()
    }

    /**
     * Стартовая команда нужна при каждом подключении (даже после bonding), иначе очки молчат и не
     * присылают JSON-уведомления. Отправляем один раз строго после MTU negotiation и включения CCCD.
     */
    private fun sendStartCommand(gatt: BluetoothGatt, reason: String) {
        val controlChar = protocol.writeCharacteristic
        if (controlChar == null) {
            logger.logError(TAG, "No control characteristic to send start command")
            setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED))
            return
        }
        if (handshakeCommandSent || startCommandPending) {
            logger.logInfo(TAG, "Start command already scheduled/sent; skipping duplicate reason=$reason")
            return
        }
        // Write with NO_RESPONSE matches the characteristic capabilities (WRITE_NR only) and avoids
        // GATT_WRITE_NOT_PERMITTED failures observed when forcing a response write type.
        val writeType = selectWriteType(controlChar, withResponse = false)
        logger.logInfo(
            TAG,
            "Sending start command reason=$reason to ${controlChar.uuid} props=${propString(controlChar.properties)} " +
                "writeType=$writeType payload=${HexUtils.toHex(START_COMMAND)}"
        )
        handshakeCommandSent = true
        startCommandPending = true
        setState(BleState.HandshakeSent)
        enqueueCharacteristicWrite(gatt, controlChar, START_COMMAND, withResponse = false, forcedWriteType = writeType)
    }

    private fun handleCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
        if (startCommandPending && characteristic.uuid == protocol.writeCharacteristic?.uuid) {
            startCommandPending = false
            if (status == BluetoothGatt.GATT_SUCCESS) {
                logger.logInfo(TAG, "Handshake write acknowledged status=$status")
                awaitingFirstNotify = true
                setState(BleState.WaitFirstNotify)
                startTimeout(TIMEOUT_FIRST_NOTIFY, FIRST_NOTIFY_TIMEOUT_MS) {
                    awaitingFirstNotify = false
                    setState(BleState.Error(BleErrorReason.FIRST_NOTIFY_TIMEOUT))
                }
            } else {
                stopTimeout(TIMEOUT_FIRST_NOTIFY)
                awaitingFirstNotify = false
                handshakeCommandSent = false
                setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED))
            }
        }
        onOperationComplete()
    }

    fun enqueueDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor): Boolean {
        operationQueue.add(Operation.DescriptorWrite(gatt, descriptor))
        processNextOperation()
        return true
    }

    fun enqueueCharacteristicWrite(
        gatt: BluetoothGatt,
        characteristic: BluetoothGattCharacteristic,
        payload: ByteArray,
        withResponse: Boolean,
        forcedWriteType: Int? = null
    ): Boolean {
        val type = forcedWriteType ?: selectWriteType(characteristic, withResponse)
        operationQueue.add(Operation.CharacteristicWrite(gatt, characteristic, payload, type))
        processNextOperation()
        return true
    }

    private fun processNextOperation() {
        if (operationInProgress) return
        val op = operationQueue.poll() ?: return
        operationInProgress = true
        when (op) {
            is Operation.DescriptorWrite -> {
                val started = op.gatt.writeDescriptor(op.descriptor)
                if (!started) {
                    logger.logError(TAG, "Failed to start descriptor write")
                    operationInProgress = false
                    processNextOperation()
                }
            }
            is Operation.CharacteristicWrite -> {
                op.characteristic.writeType = op.writeType
                op.characteristic.value = op.payload
                val started = op.gatt.writeCharacteristic(op.characteristic)
                if (handshakeCommandSent && op.characteristic.uuid == protocol.writeCharacteristic?.uuid && op.payload.contentEquals(START_COMMAND)) {
                    logger.logInfo(
                        TAG,
                        "Start command write initiated started=$started writeType=${op.writeType}"
                    )
                    if (!started) {
                        logger.logError(TAG, "Failed to start start-command write")
                        stopTimeout(TIMEOUT_FIRST_NOTIFY)
                        setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED))
                        awaitingFirstNotify = false
                        startCommandPending = false
                        handshakeCommandSent = false
                    }
                }
                if (!started) {
                    operationInProgress = false
                    processNextOperation()
                }
            }
        }
    }

    private fun onOperationComplete() {
        operationInProgress = false
        processNextOperation()
    }

    private fun handleFirstPacketIfWaiting(uuid: UUID, packetType: String) {
        if (state is BleState.HandshakeSent || state is BleState.WaitFirstNotify) {
            awaitingFirstNotify = false
            stopTimeout(TIMEOUT_FIRST_NOTIFY)
            logger.logInfo(
                TAG,
                "First packet received via $packetType from UUID=$uuid; marking session READY"
            )
            setState(BleState.Ready)
        }
    }

    private fun cleanupAfterDisconnect() {
        clearQueue()
        stopTimeouts()
        gatt?.close()
        gatt = null
        protocol.clear()
        pendingCccdWrites = 0
        handshakeCommandSent = false
        startCommandPending = false
        awaitingFirstNotify = false
        mtuRequested = false
        mtuReady = false
        enableCccdQueue.clear()
        totalNotifyCharacteristics = 0
    }

    private fun resetConnection() {
        stopTimeouts()
        clearQueue()
        scanner?.stopScan()
        gatt?.close()
        gatt = null
        protocol.clear()
        connectRetries = 0
        pendingCccdWrites = 0
        handshakeCommandSent = false
        startCommandPending = false
        awaitingFirstNotify = false
        mtuRequested = false
        mtuReady = false
        enableCccdQueue.clear()
        totalNotifyCharacteristics = 0
        setState(BleState.Idle)
    }

    private fun registerBondReceiver() {
        runCatching {
            context.registerReceiver(bondReceiver, IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED))
        }.onFailure { logger.logError(TAG, "Failed to register bond receiver: $it") }
    }

    private fun unregisterBondReceiver() {
        runCatching { context.unregisterReceiver(bondReceiver) }
            .onFailure { logger.logError(TAG, "Failed to unregister bond receiver: $it") }
    }

    private fun clearQueue() {
        operationQueue.clear()
        operationInProgress = false
    }

    private fun setState(newState: BleState) {
        logger.logState(state.label, newState.label)
        state = newState
        listener?.onStateChanged(newState)
    }

    private fun startTimeout(key: String, durationMs: Long, onTimeout: () -> Unit) {
        stopTimeout(key)
        val runnable = Runnable { onTimeout() }
        mainHandler.postDelayed(runnable, durationMs)
        timeouts[key] = runnable
    }

    private fun stopTimeout(key: String) {
        timeouts.remove(key)?.let { mainHandler.removeCallbacks(it) }
    }

    private fun stopTimeouts() {
        timeouts.values.forEach { mainHandler.removeCallbacks(it) }
        timeouts.clear()
    }

    private fun logGattDump(services: List<BluetoothGattService>) {
        services.forEach { service ->
            logger.logInfo(TAG, "Service ${service.uuid}")
            service.characteristics.forEach { ch ->
                val props = ch.properties
                val propsString = mutableListOf<String>().apply {
                    if (props and BluetoothGattCharacteristic.PROPERTY_READ != 0) add("READ")
                    if (props and BluetoothGattCharacteristic.PROPERTY_WRITE != 0) add("WRITE")
                    if (props and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0) add("WRITE_NR")
                    if (props and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0) add("NOTIFY")
                    if (props and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0) add("INDICATE")
                }.joinToString(",")
                logger.logInfo(TAG, "  Char ${ch.uuid} [$propsString]")
                ch.descriptors.forEach { desc ->
                    logger.logInfo(TAG, "    Desc ${desc.uuid}")
                }
            }
        }
    }

    /**
     * Parsed JSON packets flow here for logging and a final safety net to stop the first-notify timeout
     * if for some reason we missed the callback-level guard.
     */
    fun onProtocolMessage(json: JSONObject, source: UUID) {
        logger.logInfo(TAG, "Protocol message from $source: $json")
        handleFirstPacketIfWaiting(source, "PARSED_JSON")
    }

    companion object {
        private const val TAG = "BleManager"
        private const val SERVICE_UUID = "00000bd1-0000-1000-8000-00805f9b34fb"
        private const val NOTIFY_UUID = "00002021-0000-1000-8000-00805f9b34fb"
        private const val CONTROL_UUID = "00002020-0000-1000-8000-00805f9b34fb"
        private const val GATT_SERVICE_UUID = "00001801-0000-1000-8000-00805f9b34fb"
        private const val SERVICE_CHANGED_UUID = "00002a05-0000-1000-8000-00805f9b34fb"
        private const val CCCD_UUID = "00002902-0000-1000-8000-00805f9b34fb"
        private const val SCAN_TIMEOUT_MS = 25_000L
        private const val CONNECT_TIMEOUT_MS = 12_000L
        private const val DISCOVERY_TIMEOUT_MS = 10_000L
        // Wider window to account for indication delivery after MTU/CCCD setup.
        private const val FIRST_NOTIFY_TIMEOUT_MS = 30_000L
        private const val RETRY_DELAY_MS = 800L
        private const val MAX_RETRIES = 3
        private const val TIMEOUT_SCAN = "timeout_scan"
        private const val TIMEOUT_CONNECT = "timeout_connect"
        private const val TIMEOUT_DISCOVERY = "timeout_discovery"
        private const val TIMEOUT_FIRST_NOTIFY = "timeout_first_notify"
        private val START_COMMAND = byteArrayOf(0x00, 0x00, 0x06, 0x11, 0x01, 0x00)
        private const val KEY_LAST_TARGET = "last_target_mac"
    }

    private sealed class Operation {
        data class DescriptorWrite(val gatt: BluetoothGatt, val descriptor: BluetoothGattDescriptor) : Operation()
        data class CharacteristicWrite(
            val gatt: BluetoothGatt,
            val characteristic: BluetoothGattCharacteristic,
            val payload: ByteArray,
            val writeType: Int
        ) : Operation()
    }

    private fun selectWriteType(characteristic: BluetoothGattCharacteristic, withResponse: Boolean): Int {
        return if (!withResponse && characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0) {
            BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
        } else {
            BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
        }
    }

    private fun propString(props: Int): String {
        val parts = mutableListOf<String>()
        if (props and BluetoothGattCharacteristic.PROPERTY_READ != 0) parts += "READ"
        if (props and BluetoothGattCharacteristic.PROPERTY_WRITE != 0) parts += "WRITE"
        if (props and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0) parts += "WRITE_NR"
        if (props and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0) parts += "NOTIFY"
        if (props and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0) parts += "INDICATE"
        return parts.joinToString(",")
    }
}
