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
import android.os.HandlerThread
import android.os.Looper
import android.os.SystemClock
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
    private val callbackThread = HandlerThread("ble-callbacks").apply { start() }
    private val callbackHandler = Handler(callbackThread.looper)
    private val operationQueue: LinkedList<Operation> = LinkedList()
    private val timeouts = mutableMapOf<String, Runnable>()
    private val prefs = context.getSharedPreferences("ble_prefs", Context.MODE_PRIVATE)
    private data class CccdRequest(
        val descriptor: BluetoothGattDescriptor,
        val value: ByteArray,
        val label: String
    )

    private data class PacketLog(
        val uuid: UUID?,
        val payloadPreview: String,
        val timestamp: Long,
        val writeType: Int? = null
    )

    private val enableCccdQueue: LinkedList<CccdRequest> = LinkedList()

    private var listener: Listener? = null
    private val appContext = context.applicationContext
    private var scanner: BleScanner? = null
    private var targetDevice: BluetoothDevice? = null
    private var targetRssi: Int? = null
    private var targetReason: String? = null
    private var gatt: BluetoothGatt? = null
    private var protocol: BleProtocol = BleProtocol(this, logger)
    private var state: BleState = BleState.Idle
    private var connectRetries = 0
    private var pendingCccdWrites = 0
    private var mtuRequested = false
    private var operationInProgress = false
    private var lastTx: PacketLog? = null
    private var lastRx: PacketLog? = null
    private var lastDisconnectRequestedReason: String? = null
    private var lastDisconnectStack: Throwable? = null
    private var currentMtu: Int = DEFAULT_MTU
    private var vendorState: Int = VENDOR_STATE_IDLE
    private var isBonded: Boolean = false
    private var cccdEnabled: Boolean = false
    private var allowBleTraffic: Boolean = true
    private var pairingReceiverRegistered = false

    fun setListener(listener: Listener) {
        this.listener = listener
        listener.onTargetUpdated(targetDevice?.address ?: prefs.getString(KEY_LAST_TARGET, null), targetRssi, targetReason)
    }

    fun removeListener() {
        this.listener = null
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
        isBonded = device.bondState == BluetoothDevice.BOND_BONDED
        vendorState = if (isBonded) VENDOR_STATE_BONDED_READY else VENDOR_STATE_IDLE
        allowBleTraffic = !isBonded
        ensurePairingReceiver()
        setState(BleState.Connecting)
        startTimeout(TIMEOUT_CONNECT, CONNECT_TIMEOUT_MS) {
            setState(BleState.Error(BleErrorReason.GATT_CONNECT_FAILED))
            requestDisconnect("connect_timeout", forceClose = true)
        }
        gatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
    }

    fun requestBond() {
        logger.logInfo(TAG, "Manual bond request routed through vendor state: vendorState=$vendorState bonded=$isBonded")
        triggerBrEdrBondIfNeeded()
    }

    fun disconnect() {
        requestDisconnect("manual")
    }

    private fun requestDisconnect(
        reason: String,
        cause: Throwable? = null,
        forceClose: Boolean = false,
        status: Int? = null,
        extra: Map<String, Any?> = emptyMap()
    ) {
        lastDisconnectRequestedReason = reason
        val stack = Throwable("disconnect stack")
        lastDisconnectStack = stack
        val now = SystemClock.elapsedRealtime()
        val lastTxAge = lastTx?.let { now - it.timestamp }?.toString() ?: "n/a"
        val lastRxAge = lastRx?.let { now - it.timestamp }?.toString() ?: "n/a"
        logger.logInfo(
            TAG,
            "requestDisconnect reason=$reason state=${state.label} lastTx=${lastTx?.payloadPreview} ageMs=$lastTxAge " +
                "lastRx=${lastRx?.payloadPreview} ageMs=$lastRxAge forceClose=$forceClose status=$status extra=$extra"
        )
        logger.logError(TAG, "Disconnect stack", stack)
        cause?.let { logger.logError(TAG, "Disconnect cause", it) }

        stopTimeouts()
        scanner?.stopScan()
        clearQueue()
        gatt?.let { gattInstance ->
            if (forceClose) {
                scheduleGattClose(gattInstance)
            } else {
                gattInstance.disconnect()
                mainHandler.postDelayed({ scheduleGattClose(gattInstance) }, 300)
            }
        }
        if (forceClose || gatt == null) {
            cleanupAfterDisconnect()
            setState(BleState.Disconnected)
        }
    }

    fun destroy() {
        disconnect()
        removeListener()
        unregisterPairingReceiver()
        callbackThread.quitSafely()
    }

    fun send(payload: ByteArray, withResponse: Boolean = false, forcedWriteType: Int? = null): Boolean {
        if (!allowBleTraffic) {
            logger.logInfo(TAG, "Blocking BLE write; BR/EDR bonding pending vendorState=$vendorState")
            return false
        }
        return protocol.send(payload, withResponse, forcedWriteType)
    }

    fun maxWritePayload(): Int = (currentMtu - 3 - 2).coerceAtLeast(1)

    fun canStartBrEdrTransport(): Boolean {
        val ready = vendorState == VENDOR_STATE_BONDED_READY && isBonded
        if (!ready) {
            logger.logInfo(TAG, "SPP/RFCOMM blocked until vendorState=4 and bond complete (current=$vendorState bonded=$isBonded)")
        }
        return ready
    }

    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            callbackHandler.post {
                logger.logInfo(TAG, "onConnectionStateChange status=$status newState=$newState")
                handleConnectionStateChange(gatt, status, newState)
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            callbackHandler.post {
                logger.logInfo(TAG, "onServicesDiscovered status=$status")
                handleServicesDiscovered(gatt, status)
            }
        }

        override fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
            callbackHandler.post {
                logger.logInfo(TAG, "onDescriptorWrite ${descriptor.uuid} status=$status")
                handleDescriptorWrite(gatt, descriptor, status)
            }
        }

        override fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
            callbackHandler.post {
                logger.logInfo(TAG, "onCharacteristicWrite ${characteristic.uuid} status=$status")
                handleCharacteristicWrite(gatt, characteristic, status)
            }
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray) {
            callbackHandler.post {
                val utf8 = runCatching { String(value, Charsets.UTF_8) }.getOrNull()
                val isIndicate = characteristic.properties and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0
                val packetType = if (isIndicate) "INDICATE" else "NOTIFY"
                val timestamp = System.currentTimeMillis()
                logger.logInfo(
                    TAG,
                    "RX $packetType (${characteristic.uuid} len=${value.size} @${timestamp}): ${HexUtils.toHex(value)} utf8=$utf8"
                )
                recordRx(characteristic.uuid, value)
                protocol.onRx(value, characteristic.uuid)
            }
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            val payload = characteristic.value ?: byteArrayOf()
            onCharacteristicChanged(gatt, characteristic, payload)
        }

        override fun onMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
            callbackHandler.post {
                logger.logInfo(TAG, "onMtuChanged mtu=$mtu status=$status")
                if (status == BluetoothGatt.GATT_SUCCESS) {
                    currentMtu = mtu
                    logger.logInfo(TAG, "MTU negotiated to $mtu")
                    setState(BleState.ServicesDiscovering)
                    startServiceDiscovery(gatt)
                } else {
                    logger.logError(TAG, "MTU negotiation failed; continuing with discovery")
                    setState(BleState.ServicesDiscovering)
                    startServiceDiscovery(gatt)
                }
            }
        }
    }

    private fun handleConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
        stopTimeout(TIMEOUT_CONNECT)
        val now = SystemClock.elapsedRealtime()
        val lastTxAge = lastTx?.let { now - it.timestamp }
        val lastRxAge = lastRx?.let { now - it.timestamp }
        logger.logInfo(
            TAG,
            "connectionStateChange status=$status newState=$newState current=${state.label} lastReq=$lastDisconnectRequestedReason " +
                "lastTxAgeMs=${lastTxAge ?: "n/a"} lastRxAgeMs=${lastRxAge ?: "n/a"}"
        )
        if (status == 133) {
            logger.logError(TAG, "GATT 133 encountered; retrying")
            if (connectRetries < MAX_RETRIES) {
                connectRetries++
                retryConnection(gatt.device)
                return
            } else {
                setState(BleState.Error(BleErrorReason.GATT_CONNECT_FAILED))
                requestDisconnect("gatt_133_limit", forceClose = true)
                return
            }
        }
        if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
            connectRetries = 0
            setState(BleState.MtuNegotiation)
            if (!mtuRequested) {
                mtuRequested = true
                val requested = gatt.requestMtu(MTU_TARGET)
                logger.logInfo(TAG, "Requesting MTU $MTU_TARGET requested=$requested")
                if (!requested) {
                    logger.logError(TAG, "Failed to request MTU; continuing with discovery")
                    startServiceDiscovery(gatt)
                }
            }
        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            val lastTxAgeMs = lastTx?.let { now - it.timestamp }
            val lastRxAgeMs = lastRx?.let { now - it.timestamp }
            logger.logInfo(
                TAG,
                "Disconnected status=$status requested=$lastDisconnectRequestedReason lastTxAgeMs=${lastTxAgeMs ?: "n/a"} lastRxAgeMs=${lastRxAgeMs ?: "n/a"}"
            )
            lastDisconnectStack?.let { logger.logError(TAG, "Last disconnect request stack", it) }
            val tolerateLocalClose = vendorState == VENDOR_STATE_BONDED_READY && status == STATUS_TERMINATE_LOCAL_HOST
            if (state !is BleState.Disconnected && state !is BleState.Idle && !tolerateLocalClose) {
                setState(BleState.Error(BleErrorReason.GATT_CONNECT_FAILED))
            } else {
                setState(BleState.Disconnected)
            }
            cleanupAfterDisconnect()
        }
    }

    private fun retryConnection(device: BluetoothDevice) {
        logger.logInfo(TAG, "Retrying connection attempt $connectRetries")
        requestDisconnect("retry_connection", forceClose = true)
        BluetoothUtils.refreshGattCache(this.gatt)
        mainHandler.postDelayed({ connectToTarget() }, RETRY_DELAY_MS)
    }

    private fun startServiceDiscovery(gatt: BluetoothGatt) {
        stopTimeout(TIMEOUT_DISCOVERY)
        setState(BleState.ServicesDiscovering)
        startTimeout(TIMEOUT_DISCOVERY, DISCOVERY_TIMEOUT_MS) {
            setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
            requestDisconnect("service_discovery_timeout", forceClose = true)
        }
        gatt.discoverServices()
    }

    private fun handleServicesDiscovered(gatt: BluetoothGatt, status: Int) {
        stopTimeout(TIMEOUT_DISCOVERY)
        if (status != BluetoothGatt.GATT_SUCCESS) {
            setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
            requestDisconnect("service_discovery_failed", forceClose = true)
            return
        }
        val service = gatt.getService(UUID.fromString(SERVICE_UUID))
        val controlChar = service?.getCharacteristic(UUID.fromString(CONTROL_UUID))
        val dataChar = service?.getCharacteristic(UUID.fromString(NOTIFY_UUID))
        if (service == null || controlChar == null || dataChar == null) {
            logger.logError(TAG, "Required service/characteristics missing")
            setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
            requestDisconnect("missing_service_or_control", forceClose = true)
            return
        }
        protocol.gatt = gatt
        protocol.notifyCharacteristic = dataChar
        protocol.writeCharacteristic = controlChar
        logGattDump(gatt.services)

        enableCccdQueue.clear()
        pendingCccdWrites = 0
        vendorState = VENDOR_STATE_IDLE
        allowBleTraffic = true
        cccdEnabled = false

        if (controlChar != null) {
            logger.logInfo(TAG, "Control characteristic ${controlChar.uuid} used for writes only; skipping CCCD")
        }

        val notifyTargets = mutableListOf<BluetoothGattCharacteristic>()
        dataChar?.let { ch ->
            val hasNotify = ch.properties and (BluetoothGattCharacteristic.PROPERTY_NOTIFY or BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0
            if (hasNotify) {
                notifyTargets += ch
            } else {
                logger.logError(TAG, "Data characteristic ${ch.uuid} missing NOTIFY/INDICATE; cannot enable CCCD")
            }
        }

        notifyTargets.forEach { characteristic ->
            buildCccdDescriptor(
                gatt,
                characteristic,
                "notify_${characteristic.uuid}",
                BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            )?.let { enqueueCccd(it) }
        }

        pendingCccdWrites = enableCccdQueue.size
        if (pendingCccdWrites == 0) {
            setState(BleState.Error(BleErrorReason.CCCD_ENABLE_FAILED))
            requestDisconnect("cccd_queue_empty", forceClose = true)
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
        val supportsNotify = characteristic.properties and (BluetoothGattCharacteristic.PROPERTY_NOTIFY or BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0
        if (!supportsNotify) {
            logger.logInfo(TAG, "Skipping CCCD for $label char=${characteristic.uuid} because it is write-only")
            return null
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
        logger.logInfo(TAG, "All required notifications enabled (CCCD enabled)")
        cccdEnabled = true
        setState(BleState.NotificationsEnabled, "CCCD enabled")
        if (vendorState == VENDOR_STATE_IDLE) {
            vendorState = VENDOR_STATE_WAITING_FOR_SERVER_KEY
        }
        setState(BleState.WaitingForServerKey, "Awaiting server key before BR/EDR bond")
    }

    private fun enableNotifications(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic): Boolean {
        val success = gatt.setCharacteristicNotification(characteristic, true)
        if (!success) {
            logger.logError(TAG, "Failed to enable notification for ${characteristic.uuid}")
        }
        return success
    }

    private fun handleDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
        if (status != BluetoothGatt.GATT_SUCCESS) {
            logger.logError(TAG, "CCCD write failed for ${descriptor.characteristic.uuid} status=$status")
            setState(BleState.Error(BleErrorReason.CCCD_ENABLE_FAILED))
            requestDisconnect("cccd_write_failed", forceClose = true)
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

    private fun handleCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
        if (status != BluetoothGatt.GATT_SUCCESS) {
            logger.logError(TAG, "Characteristic write failed for ${characteristic.uuid} status=$status")
            setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED), "Characteristic write failed")
            requestDisconnect("handshake_write_failed", forceClose = true)
        }
        onOperationComplete()
    }

    fun onFramedPayload(payload: ByteArray, source: UUID) {
        logger.logInfo(TAG, "Framed payload complete from $source len=${payload.size}")
        if (vendorState < VENDOR_STATE_READY_FOR_BOND) {
            advanceVendorState(VENDOR_STATE_READY_FOR_BOND, "Server key received from $source")
            setState(BleState.ReadyForBond, "Server key received")
            stopBleTrafficForBonding()
            triggerBrEdrBondIfNeeded()
            return
        }
        logger.logInfo(TAG, "Ignoring additional BLE payloads while BR/EDR bonding is pending")
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
                recordTx(op.characteristic.uuid, op.payload, op.writeType)
                logger.logInfo(
                    TAG,
                    "TX ${op.characteristic.uuid} writeType=${op.writeType} len=${op.payload.size} payload=${HexUtils.toHex(op.payload)}"
                )
                val started = op.gatt.writeCharacteristic(op.characteristic)
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

    private fun cleanupAfterDisconnect() {
        clearQueue()
        stopTimeouts()
        gatt?.let { scheduleGattClose(it) }
        gatt = null
        protocol.clear()
        pendingCccdWrites = 0
        mtuRequested = false
        currentMtu = DEFAULT_MTU
        vendorState = VENDOR_STATE_IDLE
        allowBleTraffic = true
        isBonded = false
        cccdEnabled = false
        enableCccdQueue.clear()
        lastDisconnectRequestedReason = null
        lastDisconnectStack = null
    }

    private fun resetConnection() {
        stopTimeouts()
        clearQueue()
        scanner?.stopScan()
        gatt?.let { scheduleGattClose(it) }
        gatt = null
        protocol.clear()
        connectRetries = 0
        pendingCccdWrites = 0
        mtuRequested = false
        currentMtu = DEFAULT_MTU
        vendorState = VENDOR_STATE_IDLE
        allowBleTraffic = true
        isBonded = false
        cccdEnabled = false
        enableCccdQueue.clear()
        lastDisconnectRequestedReason = null
        lastDisconnectStack = null
        setState(BleState.Idle)
    }

    private fun clearQueue() {
        operationQueue.clear()
        operationInProgress = false
    }

    private fun scheduleGattClose(gatt: BluetoothGatt) {
        logger.logInfo(TAG, "Scheduling gatt.close() for ${gatt.device.address}")
        mainHandler.postDelayed({
            runCatching { gatt.close() }.onFailure {
                logger.logError(TAG, "gatt.close failed", it)
            }
        }, 300)
    }

    private fun setState(newState: BleState, reason: String? = null) {
        val formattedReason = reason?.let { "[PROTO][STATE] ${state.label} -> ${newState.label} ($it)" }
            ?: "[PROTO][STATE] ${state.label} -> ${newState.label}"
        logger.logInfo(TAG, formattedReason)
        logger.logState(state.label, newState.label, reason)
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

    private fun recordTx(uuid: UUID?, payload: ByteArray, writeType: Int) {
        lastTx = PacketLog(uuid, HexUtils.toHex(payload.take(16).toByteArray()), SystemClock.elapsedRealtime(), writeType)
    }

    private fun recordRx(uuid: UUID?, payload: ByteArray) {
        lastRx = PacketLog(uuid, HexUtils.toHex(payload.take(16).toByteArray()), SystemClock.elapsedRealtime())
    }

    private fun ensurePairingReceiver() {
        if (pairingReceiverRegistered) return
        val filter = IntentFilter().apply {
            addAction(BluetoothDevice.ACTION_PAIRING_REQUEST)
            addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED)
        }
        appContext.registerReceiver(pairingReceiver, filter)
        pairingReceiverRegistered = true
    }

    private fun unregisterPairingReceiver() {
        if (!pairingReceiverRegistered) return
        runCatching { appContext.unregisterReceiver(pairingReceiver) }
        pairingReceiverRegistered = false
    }

    private val pairingReceiver = object : BroadcastReceiver() {
        override fun onReceive(ctx: Context?, intent: Intent?) {
            intent ?: return
            val device = intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE) ?: return
            val target = targetDevice ?: return
            if (device.address != target.address) {
                logger.logInfo(TAG, "Ignoring pairing broadcast for non-target ${device.address}")
                return
            }
            when (intent.action) {
                BluetoothDevice.ACTION_PAIRING_REQUEST -> {
                    val variant = intent.getIntExtra(BluetoothDevice.EXTRA_PAIRING_VARIANT, -1)
                    logger.logInfo(TAG, "Pairing request from glasses variant=$variant")
                    // The glasses drive BR/EDR pairing; we simply confirm to avoid disconnects.
                    runCatching { device.setPairingConfirmation(true) }
                        .onFailure { logger.logError(TAG, "Failed to auto-confirm pairing", it) }
                    if (vendorState < VENDOR_STATE_BONDING) {
                        advanceVendorState(VENDOR_STATE_BONDING, "System pairing request received")
                    }
                    setState(BleState.BondingBrEdr, "System pairing request")
                }
                BluetoothDevice.ACTION_BOND_STATE_CHANGED -> {
                    val bondState = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE)
                    val prevState = intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_NONE)
                    logger.logInfo(TAG, "Bond state changed from $prevState to $bondState")
                    when (bondState) {
                        BluetoothDevice.BOND_BONDING -> {
                            advanceVendorState(VENDOR_STATE_BONDING, "Android reports BONDING")
                            setState(BleState.BondingBrEdr, "Android reports BONDING")
                        }
                        BluetoothDevice.BOND_BONDED -> {
                            isBonded = true
                            advanceVendorState(VENDOR_STATE_BONDED_READY, "Android reports BONDED")
                            setState(BleState.Bonded, "Android reports BONDED")
                            setState(BleState.ReadyForTransport, "Vendor state ready + bond complete")
                        }
                        BluetoothDevice.BOND_NONE -> {
                            isBonded = false
                            if (state is BleState.BondingBrEdr || state is BleState.Bonded) {
                                setState(BleState.Error(BleErrorReason.BOND_FAILED))
                                requestDisconnect("bond_lost", forceClose = true)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun triggerBrEdrBondIfNeeded() {
        val device = targetDevice ?: return logger.logError(TAG, "No target device when attempting BR/EDR bond")
        if (vendorState < VENDOR_STATE_READY_FOR_BOND) {
            logger.logInfo(TAG, "Vendor state not ready for bond: $vendorState")
            return
        }
        if (isBonded || device.bondState == BluetoothDevice.BOND_BONDED) {
            advanceVendorState(VENDOR_STATE_BONDED_READY, "Already bonded")
            setState(BleState.Bonded, "Already bonded at trigger time")
            setState(BleState.ReadyForTransport, "Vendor state ready + bond complete")
            return
        }
        stopBleTrafficForBonding()
        advanceVendorState(VENDOR_STATE_BONDING, "Invoking createBond() after server key")
        logger.logInfo(TAG, "Invoking createBond() for BR/EDR after server key")
        val started = runCatching { device.createBond() }.getOrDefault(false)
        if (!started) {
            logger.logError(TAG, "createBond() failed to start; vendor state=$vendorState")
            setState(BleState.Error(BleErrorReason.BOND_FAILED), "createBond start failed")
        } else {
            setState(BleState.BondingBrEdr, "createBond started")
        }
    }

    private fun stopBleTrafficForBonding() {
        allowBleTraffic = false
        clearQueue()
        logger.logInfo(TAG, "Stopping BLE traffic before BR/EDR bonding per observed logs")
    }

    private fun advanceVendorState(newState: Int, reason: String) {
        if (newState <= vendorState) return
        logger.logInfo(TAG, "[PROTO][STATE] vendor $vendorState -> $newState ($reason)")
        vendorState = newState
    }

    /**
     * Parsed JSON packets flow here for logging and a final safety net to stop the first-notify timeout
     * if for some reason we missed the callback-level guard.
     */
    fun onProtocolMessage(json: JSONObject, source: UUID) {
        logger.logInfo(TAG, "Protocol message from $source: $json")
    }

    companion object {
        private const val TAG = "BleManager"
        private const val SERVICE_UUID = "00000bd1-0000-1000-8000-00805f9b34fb"
        private const val NOTIFY_UUID = "00002021-0000-1000-8000-00805f9b34fb"
        private const val CONTROL_UUID = "00002020-0000-1000-8000-00805f9b34fb"
        private const val CCCD_UUID = "00002902-0000-1000-8000-00805f9b34fb"
        private const val SCAN_TIMEOUT_MS = 25_000L
        private const val CONNECT_TIMEOUT_MS = 12_000L
        private const val DISCOVERY_TIMEOUT_MS = 10_000L
        private const val RETRY_DELAY_MS = 800L
        private const val MAX_RETRIES = 3
        private const val TIMEOUT_SCAN = "timeout_scan"
        private const val TIMEOUT_CONNECT = "timeout_connect"
        private const val TIMEOUT_DISCOVERY = "timeout_discovery"
        private const val MTU_TARGET = 512
        private const val DEFAULT_MTU = 23
        private const val KEY_LAST_TARGET = "last_target_mac"
        private const val STATUS_TERMINATE_LOCAL_HOST = 22
        private const val VENDOR_STATE_IDLE = 0
        private const val VENDOR_STATE_WAITING_FOR_SERVER_KEY = 1
        private const val VENDOR_STATE_READY_FOR_BOND = 2
        private const val VENDOR_STATE_BONDING = 3
        private const val VENDOR_STATE_BONDED_READY = 4
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
