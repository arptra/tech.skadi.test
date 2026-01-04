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
    private var scanner: BleScanner? = null
    private var targetDevice: BluetoothDevice? = null
    private var targetRssi: Int? = null
    private var targetReason: String? = null
    private var gatt: BluetoothGatt? = null
    private var protocol: BleProtocol = BleProtocol(this, logger)
    private var state: BleState = BleState.Idle
    private var connectRetries = 0
    private var vendorService: BluetoothGattService? = null
    private var notifyCharacteristicsStage1: List<BluetoothGattCharacteristic> = emptyList()
    private var indicateCharacteristicsStage1: List<BluetoothGattCharacteristic> = emptyList()
    private var notifyCharacteristicsStage2: List<BluetoothGattCharacteristic> = emptyList()
    private var indicateCharacteristicsStage2: List<BluetoothGattCharacteristic> = emptyList()
    private var pendingCccdWrites = 0
    private var handshakeCommandSent = false
    private var startCommandPending = false
    private var mtuRequested = false
    private var mtuReady = false
    private var operationInProgress = false
    private var totalNotifyCharacteristics = 0
    private var firstNotifyReceived = false
    private var vendorNotifyDuringInit = false
    private var protocolInitHoldElapsed = false
    private var firstVendorPacket: ByteArray? = null
    private var quietHoldActive = false
    private var stageTwoCccdScheduled = false
    private var enablingStageTwo = false
    private var lastTx: PacketLog? = null
    private var lastRx: PacketLog? = null
    private var lastDisconnectRequestedReason: String? = null
    private var lastDisconnectStack: Throwable? = null

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
            requestDisconnect("connect_timeout", forceClose = true)
        }
        gatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
    }

    fun requestBond() {
        logger.logInfo(TAG, "Bonding is managed by the device; manual request ignored")
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
        val bondState = gatt?.device?.bondState
        val lastTxAge = lastTx?.let { now - it.timestamp }?.toString() ?: "n/a"
        val lastRxAge = lastRx?.let { now - it.timestamp }?.toString() ?: "n/a"
        logger.logInfo(
            TAG,
            "requestDisconnect reason=$reason state=${state.label} bond=$bondState lastTx=${lastTx?.payloadPreview} ageMs=$lastTxAge " +
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
        unregisterBondReceiver()
        callbackThread.quitSafely()
    }

    fun send(payload: ByteArray, withResponse: Boolean = false): Boolean = protocol.send(payload, withResponse)

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
                handleVendorPacket(characteristic, value)
                handleProtocolInitProgress(characteristic)
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
                    mtuReady = true
                    logger.logInfo(TAG, "MTU negotiated to $mtu")
                }
                if (!handshakeCommandSent) {
                    sendStartCommand(gatt, reason = "mtu_changed")
                }
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
                    BluetoothDevice.BOND_BONDED -> {
                        logger.logInfo(TAG, "System bonding completed; keeping session alive")
                        if (firstNotifyReceived) {
                            onHandshakeCompleteAndReady()
                        }
                    }
                    BluetoothDevice.BOND_NONE -> logger.logInfo(TAG, "Bond removed or failed")
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
            setState(BleState.ServicesDiscovering)
            startTimeout(TIMEOUT_DISCOVERY, DISCOVERY_TIMEOUT_MS) {
                setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
                requestDisconnect("service_discovery_timeout", forceClose = true)
            }
            gatt.discoverServices()
        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            val lastTxAgeMs = lastTx?.let { now - it.timestamp }
            val lastRxAgeMs = lastRx?.let { now - it.timestamp }
            logger.logInfo(
                TAG,
                "Disconnected status=$status requested=$lastDisconnectRequestedReason lastTxAgeMs=${lastTxAgeMs ?: "n/a"} lastRxAgeMs=${lastRxAgeMs ?: "n/a"}"
            )
            lastDisconnectStack?.let { logger.logError(TAG, "Last disconnect request stack", it) }
            val readyPhase = state is BleState.ConnectedReady ||
                state is BleState.ProtocolSessionInit ||
                state is BleState.ReadyForCommands
            val tolerateLocalClose = (firstNotifyReceived || readyPhase) && status == STATUS_TERMINATE_LOCAL_HOST
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

    private fun handleServicesDiscovered(gatt: BluetoothGatt, status: Int) {
        stopTimeout(TIMEOUT_DISCOVERY)
        if (status != BluetoothGatt.GATT_SUCCESS) {
            setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
            requestDisconnect("service_discovery_failed", forceClose = true)
            return
        }
        val service = gatt.getService(UUID.fromString(SERVICE_UUID))
        val rxChar = service?.getCharacteristic(UUID.fromString(RX_UUID))
        val controlChar = service?.getCharacteristic(UUID.fromString(CONTROL_UUID))
        if (service == null || controlChar == null) {
            logger.logError(TAG, "Required service/characteristics missing")
            setState(BleState.Error(BleErrorReason.SERVICE_DISCOVERY_FAILED))
            requestDisconnect("missing_service_or_control", forceClose = true)
            return
        }
        protocol.gatt = gatt
        protocol.notifyCharacteristic = rxChar ?: service.getCharacteristic(UUID.fromString(NOTIFY_UUID))
        protocol.writeCharacteristic = controlChar
        vendorService = service
        logGattDump(gatt.services)

        handshakeCommandSent = false
        mtuRequested = false
        mtuReady = false
        enableCccdQueue.clear()
        pendingCccdWrites = 0
        stageTwoCccdScheduled = false
        enablingStageTwo = false
        firstVendorPacket = null
        quietHoldActive = false

        val notifyCandidates = listOfNotNull(
            rxChar,
            service.getCharacteristic(UUID.fromString(RX_ALT_UUID)),
            service.getCharacteristic(UUID.fromString(CONTROL_UUID)),
            service.getCharacteristic(UUID.fromString(NOTIFY_UUID)),
            service.getCharacteristic(UUID.fromString(EXTRA_NOTIFY_UUID)),
            service.getCharacteristic(UUID.fromString(SYS_NOTIFY_UUID))
        ).filter { it.properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0 }

        // Документация StarryNet (BluetoothConstants.XR_NOTIFY_UUIDS) указывает пару 0x2001/0x2002
        // как основные notify для XR. Активируем их на первом этапе, чтобы сразу ловить стартовые
        // ответы и сигналы bonding.
        val stageOneTargets = setOf(NOTIFY_UUID, EXTRA_NOTIFY_UUID)
        notifyCharacteristicsStage1 = notifyCandidates.filter { candidate ->
            stageOneTargets.any { target -> candidate.uuid.toString().equals(target, ignoreCase = true) }
        }
        notifyCharacteristicsStage2 = notifyCandidates.filter { char -> notifyCharacteristicsStage1.none { it.uuid == char.uuid } }

        val gattService = gatt.getService(UUID.fromString(GATT_SERVICE_UUID))
        val serviceChanged = gattService?.getCharacteristic(UUID.fromString(SERVICE_CHANGED_UUID))
        indicateCharacteristicsStage1 = listOfNotNull(serviceChanged).filter {
            it.properties and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0
        }
        indicateCharacteristicsStage2 = emptyList()

        totalNotifyCharacteristics = notifyCharacteristicsStage1.size + indicateCharacteristicsStage1.size
        logger.logInfo(
            TAG,
            "Stage1 notify chars (${notifyCharacteristicsStage1.size}): ${notifyCharacteristicsStage1.joinToString { it.uuid.toString() }}"
        )
        logger.logInfo(
            TAG,
            "Stage1 indicate chars (${indicateCharacteristicsStage1.size}): ${indicateCharacteristicsStage1.joinToString { it.uuid.toString() }}"
        )
        enableCccdQueue.clear()
        notifyCharacteristicsStage1.forEach { characteristic ->
            buildCccdDescriptor(
                gatt,
                characteristic,
                "notify_${characteristic.uuid}",
                BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            )?.let { enqueueCccd(it) }
        }
        indicateCharacteristicsStage1.forEach { characteristic ->
            buildCccdDescriptor(
                gatt,
                characteristic,
                "indicate_${characteristic.uuid}",
                BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
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
        logger.logInfo(
            TAG,
            "All notifications/indications enabled ($totalNotifyCharacteristics chars) stage=${if (enablingStageTwo) "stage2" else "stage1"}"
        )
        if (enablingStageTwo) {
            enablingStageTwo = false
            pendingCccdWrites = 0
            return
        }
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

    /**
     * Стартовая команда нужна при каждом подключении (даже после bonding), иначе очки молчат и не
     * присылают JSON-уведомления. Отправляем её на документированный write-канал 0x2000
     * строго после MTU negotiation и включения CCCD на XR notify UUID (0x2001/0x2002).
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
        // 0x2000 поддерживает обычный write, подбираем тип автоматически по свойствам.
        val writeType = selectWriteType(controlChar, withResponse = false)
        logger.logInfo(
            TAG,
            "Sending start command reason=$reason to ${controlChar.uuid} props=${propString(controlChar.properties)} " +
                "writeType=$writeType payload=${HexUtils.toHex(START_COMMAND)}"
        )
        firstNotifyReceived = false
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
                val device = gatt.device
                val bondState = device.bondState
                when (bondState) {
                    BluetoothDevice.BOND_NONE -> {
                        logger.logInfo(TAG, "Requesting system bond after start command ack")
                        val started = device.createBond()
                        logger.logInfo(TAG, "createBond() started=$started currentState=${device.bondState}")
                    }
                    BluetoothDevice.BOND_BONDING -> logger.logInfo(TAG, "Bonding already in progress; waiting for completion")
                    BluetoothDevice.BOND_BONDED -> {
                        logger.logInfo(TAG, "Device already bonded; moving into protocol init hold")
                        beginProtocolSessionInit()
                        if (firstNotifyReceived) onHandshakeCompleteAndReady()
                    }
                    else -> logger.logInfo(TAG, "Unhandled bond state=$bondState after start command")
                }
            } else {
                handshakeCommandSent = false
                setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED))
            }
        }
        onOperationComplete()
    }

    private fun handleVendorPacket(characteristic: BluetoothGattCharacteristic, payload: ByteArray) {
        if (!handshakeCommandSent) return
        if (!isVendorNotifyCharacteristic(characteristic)) return

        if (!firstNotifyReceived) {
            firstNotifyReceived = true
            firstVendorPacket = payload.copyOf()
            vendorNotifyDuringInit = true
            logger.logInfo(
                TAG,
                "First vendor packet after start command (${characteristic.uuid} len=${payload.size}): ${HexUtils.toHex(payload)}"
            )
            onHandshakeCompleteAndReady()
            return
        }

        if (state is BleState.ProtocolSessionInit) {
            vendorNotifyDuringInit = true
            // Any subsequent vendor packet is a readiness signal; do not sit in the quiet hold.
            if (!protocolInitHoldElapsed) {
                logger.logInfo(TAG, "Second+ vendor packet during PROTOCOL_SESSION_INIT; promoting immediately")
                promoteReadyForCommands("vendor_notify_during_hold")
            } else {
                promoteReadyForCommands("vendor_notify_after_hold")
            }
        }
    }

    private fun handleProtocolInitProgress(characteristic: BluetoothGattCharacteristic) {
        if (!firstNotifyReceived) return
        if (state !is BleState.ProtocolSessionInit) return
        if (!isVendorNotifyCharacteristic(characteristic)) return
        vendorNotifyDuringInit = true
        logger.logInfo(TAG, "Vendor packet during PROTOCOL_SESSION_INIT; waiting for quiet-hold to elapse")
        if (protocolInitHoldElapsed) {
            promoteReadyForCommands("vendor_notify_after_hold")
        }
    }

    private fun isVendorNotifyCharacteristic(characteristic: BluetoothGattCharacteristic): Boolean {
        val vendorUuid = vendorService?.uuid
        return vendorUuid != null &&
            characteristic.service?.uuid == vendorUuid &&
            characteristic.properties and
            (BluetoothGattCharacteristic.PROPERTY_NOTIFY or BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0
    }

    private fun onHandshakeCompleteAndReady() {
        if (state !is BleState.ConnectedReady && state !is BleState.ProtocolSessionInit && state !is BleState.ReadyForCommands) {
            setState(BleState.ConnectedReady)
        }
        beginProtocolSessionInit()
    }

    private fun beginProtocolSessionInit() {
        if (state is BleState.ProtocolSessionInit || state is BleState.ReadyForCommands) return
        quietHoldActive = true
        // Если первый пакет уже пришёл, не теряем этот сигнал готовности при входе в стадию init.
        vendorNotifyDuringInit = vendorNotifyDuringInit || firstNotifyReceived
        protocolInitHoldElapsed = false
        setState(BleState.ProtocolSessionInit)
        startTimeout(TIMEOUT_PROTOCOL_INIT, PROTOCOL_INIT_HOLD_MS) {
            protocolInitHoldElapsed = true
            if (state !is BleState.ProtocolSessionInit) return@startTimeout
            if (vendorNotifyDuringInit) {
                logger.logInfo(TAG, "Protocol session hold elapsed; promoting to READY_FOR_COMMANDS reason=hold_elapsed_with_vendor_notify")
                promoteReadyForCommands("hold_elapsed_with_vendor_notify")
            } else {
                logger.logError(TAG, "Protocol init hold elapsed without vendor packets; timing out")
                setState(BleState.Error(BleErrorReason.PROTOCOL_INIT_TIMEOUT))
                requestDisconnect("protocol_init_timeout", forceClose = true)
            }
        }
    }

    private fun promoteReadyForCommands(reason: String) {
        stopTimeout(TIMEOUT_PROTOCOL_INIT)
        if (state is BleState.ReadyForCommands) return
        quietHoldActive = false
        logger.logInfo(TAG, "Protocol session init complete ($reason); channel ready for commands")
        setState(BleState.ReadyForCommands)
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
                if (handshakeCommandSent && op.characteristic.uuid == protocol.writeCharacteristic?.uuid && op.payload.contentEquals(START_COMMAND)) {
                    logger.logInfo(
                        TAG,
                        "Start command write initiated started=$started writeType=${op.writeType}"
                    )
                    if (!started) {
                        logger.logError(TAG, "Failed to start start-command write")
                        setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED))
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

    private fun scheduleStageTwoCccd(gatt: BluetoothGatt?) {
        if (stageTwoCccdScheduled) return
        if (notifyCharacteristicsStage2.isEmpty() && indicateCharacteristicsStage2.isEmpty()) return
        val targetGatt = gatt ?: return
        stageTwoCccdScheduled = true
        startTimeout(TIMEOUT_STAGE2_CCCD, STAGE2_CCCD_DELAY_MS) {
            if (state is BleState.Disconnected) return@startTimeout
            enableStageTwoCccds(targetGatt)
        }
    }

    private fun enableStageTwoCccds(gatt: BluetoothGatt) {
        stopTimeout(TIMEOUT_STAGE2_CCCD)
        if (notifyCharacteristicsStage2.isEmpty() && indicateCharacteristicsStage2.isEmpty()) return
        enablingStageTwo = true
        enableCccdQueue.clear()
        pendingCccdWrites = 0
        totalNotifyCharacteristics = notifyCharacteristicsStage2.size + indicateCharacteristicsStage2.size
        logger.logInfo(
            TAG,
            "Enabling stage2 CCCD notify=${notifyCharacteristicsStage2.map { it.uuid }} indicate=${indicateCharacteristicsStage2.map { it.uuid }}"
        )
        notifyCharacteristicsStage2.forEach { characteristic ->
            buildCccdDescriptor(
                gatt,
                characteristic,
                "notify_stage2_${characteristic.uuid}",
                BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            )?.let { enqueueCccd(it) }
        }
        indicateCharacteristicsStage2.forEach { characteristic ->
            buildCccdDescriptor(
                gatt,
                characteristic,
                "indicate_stage2_${characteristic.uuid}",
                BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
            )?.let { enqueueCccd(it) }
        }
        pendingCccdWrites = enableCccdQueue.size
        if (pendingCccdWrites == 0) {
            enablingStageTwo = false
            return
        }
        processNextCccdWrite(gatt)
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
        handshakeCommandSent = false
        startCommandPending = false
        mtuRequested = false
        mtuReady = false
        stopTimeout(TIMEOUT_PROTOCOL_INIT)
        firstNotifyReceived = false
        vendorNotifyDuringInit = false
        protocolInitHoldElapsed = false
        firstVendorPacket = null
        quietHoldActive = false
        stageTwoCccdScheduled = false
        enablingStageTwo = false
        stopTimeout(TIMEOUT_PROTOCOL_INIT)
        enableCccdQueue.clear()
        totalNotifyCharacteristics = 0
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
        handshakeCommandSent = false
        startCommandPending = false
        mtuRequested = false
        mtuReady = false
        stopTimeout(TIMEOUT_PROTOCOL_INIT)
        firstNotifyReceived = false
        vendorNotifyDuringInit = false
        protocolInitHoldElapsed = false
        firstVendorPacket = null
        quietHoldActive = false
        stageTwoCccdScheduled = false
        enablingStageTwo = false
        stopTimeout(TIMEOUT_PROTOCOL_INIT)
        enableCccdQueue.clear()
        totalNotifyCharacteristics = 0
        lastDisconnectRequestedReason = null
        lastDisconnectStack = null
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

    private fun scheduleGattClose(gatt: BluetoothGatt) {
        logger.logInfo(TAG, "Scheduling gatt.close() for ${gatt.device.address}")
        mainHandler.postDelayed({
            runCatching { gatt.close() }.onFailure {
                logger.logError(TAG, "gatt.close failed", it)
            }
        }, 300)
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

    private fun recordTx(uuid: UUID?, payload: ByteArray, writeType: Int) {
        lastTx = PacketLog(uuid, HexUtils.toHex(payload.take(16).toByteArray()), SystemClock.elapsedRealtime(), writeType)
    }

    private fun recordRx(uuid: UUID?, payload: ByteArray) {
        lastRx = PacketLog(uuid, HexUtils.toHex(payload.take(16).toByteArray()), SystemClock.elapsedRealtime())
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
        private const val RX_UUID = "00002001-0000-1000-8000-00805f9b34fb"
        private const val RX_ALT_UUID = "00002002-0000-1000-8000-00805f9b34fb"
        private const val NOTIFY_UUID = "00002001-0000-1000-8000-00805f9b34fb"
        private const val CONTROL_UUID = "00002000-0000-1000-8000-00805f9b34fb"
        private const val EXTRA_NOTIFY_UUID = "00002002-0000-1000-8000-00805f9b34fb"
        private const val SYS_NOTIFY_UUID = "00001001-0000-1000-8000-00805f9b34fb"
        private const val GATT_SERVICE_UUID = "00001801-0000-1000-8000-00805f9b34fb"
        private const val SERVICE_CHANGED_UUID = "00002a05-0000-1000-8000-00805f9b34fb"
        private const val CCCD_UUID = "00002902-0000-1000-8000-00805f9b34fb"
        private const val SCAN_TIMEOUT_MS = 25_000L
        private const val CONNECT_TIMEOUT_MS = 12_000L
        private const val DISCOVERY_TIMEOUT_MS = 10_000L
        private const val RETRY_DELAY_MS = 800L
        private const val MAX_RETRIES = 3
        private const val TIMEOUT_SCAN = "timeout_scan"
        private const val TIMEOUT_CONNECT = "timeout_connect"
        private const val TIMEOUT_DISCOVERY = "timeout_discovery"
        private const val TIMEOUT_PROTOCOL_INIT = "timeout_protocol_init"
        private const val TIMEOUT_STAGE2_CCCD = "timeout_stage2_cccd"
        private val START_COMMAND = byteArrayOf(0x00, 0x00, 0x06, 0x11, 0x01, 0x00)
        private const val PROTOCOL_INIT_HOLD_MS = 1_000L
        private const val STAGE2_CCCD_DELAY_MS = 500L
        private const val KEY_LAST_TARGET = "last_target_mac"
        private const val STATUS_TERMINATE_LOCAL_HOST = 22
        private const val AUTO_ENABLE_STAGE2_CCCD = false
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
