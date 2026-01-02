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
    private val enableCccdQueue: LinkedList<BluetoothGattDescriptor> = LinkedList()

    private var listener: Listener? = null
    private var scanner: BleScanner? = null
    private var targetDevice: BluetoothDevice? = null
    private var targetRssi: Int? = null
    private var targetReason: String? = null
    private var gatt: BluetoothGatt? = null
    private var protocol: BleProtocol = BleProtocol(this, logger)
    private var state: BleState = BleState.Idle
    private var connectRetries = 0
    private var pendingCccdWrites = 0
    private var handshakeCommandSent = false
    private var awaitingFirstNotify = false
    private var firstNotifyAttempts = 0
    private var applicationInitPending = false
    private var applicationInitSent = false
    private var operationInProgress = false
    private var bondReceiverRegistered = false
    private var bondTimeoutArmed = false
    private var totalNotifyCharacteristics = 0

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
                setState(BleState.DeviceFound)
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
        registerBondReceiver()
        setState(BleState.BleConnecting)
        startTimeout(TIMEOUT_CONNECT, CONNECT_TIMEOUT_MS) {
            setState(BleState.Error(BleErrorReason.GATT_CONNECT_FAILED))
            disconnect()
        }
        gatt = device.connectGatt(context, false, gattCallback, BluetoothDevice.TRANSPORT_LE)
    }

    fun requestBond() {
        val device = targetDevice ?: return logger.logError(TAG, "No target to bond")
        if (device.bondState == BluetoothDevice.BOND_BONDED) {
            logger.logInfo(TAG, "Already bonded")
            stopTimeout(TIMEOUT_FIRST_NOTIFY)
            setState(BleState.Bonded)
            return
        }
        val started = device.createBond()
        logger.logInfo(TAG, "User-initiated bonding started=$started")
        if (started) {
            startBondTimeout()
        }
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
        connectRetries = 0
        bondTimeoutArmed = false
        setState(BleState.Disconnected)
        unregisterBondReceiver()
    }

    fun destroy() {
        disconnect()
        unregisterBondReceiver()
        removeListener()
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
            logger.logInfo(TAG, "RX (${characteristic.uuid} len=${value.size}): ${HexUtils.toHex(value)} utf8=$utf8")
            protocol.onRx(value, characteristic.uuid)
        }

        override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
            val payload = characteristic.value ?: byteArrayOf()
            onCharacteristicChanged(gatt, characteristic, payload)
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
            setState(BleState.BleConnected)
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
        val bondState = targetDevice?.bondState
        logger.logInfo(TAG, "Bond state at discovery=${bondStateString(bondState)}")
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
        logGattDump(gatt.services)

        handshakeCommandSent = false
        awaitingFirstNotify = false
        firstNotifyAttempts = 0
        enableCccdQueue.clear()
        pendingCccdWrites = 0

        val notifyCharacteristics = service.characteristics.filter {
            it.properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0
        }
        totalNotifyCharacteristics = notifyCharacteristics.size
        logger.logInfo(
            TAG,
            "Notify-capable chars (${notifyCharacteristics.size}): ${notifyCharacteristics.joinToString { it.uuid.toString() }}"
        )

        notifyCharacteristics.forEach { characteristic ->
            buildCccdDescriptor(gatt, characteristic, "notify_${characteristic.uuid}")?.let { enqueueCccd(it) }
        }

        pendingCccdWrites = enableCccdQueue.size
        if (pendingCccdWrites == 0) {
            setState(BleState.Error(BleErrorReason.CCCD_ENABLE_FAILED))
            disconnect()
            return
        }
        logger.logInfo(TAG, "Total CCCD writes queued=$pendingCccdWrites")
        setState(BleState.HandshakeWriting)
        processNextCccdWrite(gatt)
    }

    private fun buildCccdDescriptor(
        gatt: BluetoothGatt,
        characteristic: BluetoothGattCharacteristic?,
        label: String
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
        return cccd
    }

    private fun enqueueCccd(descriptor: BluetoothGattDescriptor) {
        logger.logInfo(TAG, "Queueing CCCD enable for char=${descriptor.characteristic.uuid} desc=${descriptor.uuid}")
        descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
        enableCccdQueue.add(descriptor)
    }

    private fun processNextCccdWrite(gatt: BluetoothGatt) {
        val descriptor = enableCccdQueue.peekFirst()
        if (descriptor == null) {
            onAllCccdsEnabled(gatt)
            return
        }
        logger.logInfo(TAG, "Writing CCCD for char=${descriptor.characteristic.uuid} desc=${descriptor.uuid}")
        enqueueDescriptorWrite(gatt, descriptor)
    }

    private fun onAllCccdsEnabled(gatt: BluetoothGatt) {
        logger.logInfo(TAG, "All notifications enabled ($totalNotifyCharacteristics chars)")
        if (!handshakeCommandSent) {
            sendStartCommand(gatt, reason = "cccd_complete")
        }
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
     * присылают JSON-уведомления. Мы повторяем попытку один раз, чтобы вывести их из pairing экрана
     * без перезапуска всего соединения.
     */
    private fun sendStartCommand(gatt: BluetoothGatt, reason: String) {
        val controlChar = protocol.writeCharacteristic
        if (controlChar == null) {
            logger.logError(TAG, "No control characteristic to send start command")
            setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED))
            return
        }
        val writeType = selectWriteType(controlChar, withResponse = false)
        firstNotifyAttempts++
        val attempt = firstNotifyAttempts
        logger.logInfo(
            TAG,
            "Sending start command attempt=$attempt reason=$reason to ${controlChar.uuid} props=${propString(controlChar.properties)} " +
                "writeType=$writeType payload=${HexUtils.toHex(START_COMMAND)}"
        )
        handshakeCommandSent = true
        awaitingFirstNotify = true
        enqueueCharacteristicWrite(gatt, controlChar, START_COMMAND, withResponse = false, forcedWriteType = writeType)
        startTimeout(TIMEOUT_FIRST_NOTIFY, FIRST_NOTIFY_TIMEOUT_MS) {
            awaitingFirstNotify = false
            if (firstNotifyAttempts < MAX_FIRST_NOTIFY_ATTEMPTS) {
                logger.logInfo(TAG, "First notify timeout; retrying start command attempt=${firstNotifyAttempts + 1}")
                sendStartCommand(gatt, reason = "first_notify_retry")
            } else {
                setState(BleState.Error(BleErrorReason.FIRST_NOTIFY_TIMEOUT))
            }
        }
    }

    private fun handleCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
        if (handshakeCommandSent && characteristic.uuid == protocol.writeCharacteristic?.uuid) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                logger.logInfo(TAG, "Handshake write acknowledged status=$status")
            } else {
                stopTimeout(TIMEOUT_FIRST_NOTIFY)
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

    private fun cleanupAfterDisconnect() {
        clearQueue()
        stopTimeouts()
        gatt?.close()
        gatt = null
        protocol.clear()
        pendingCccdWrites = 0
        handshakeCommandSent = false
        awaitingFirstNotify = false
        applicationInitPending = false
        applicationInitSent = false
        firstNotifyAttempts = 0
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
        awaitingFirstNotify = false
        applicationInitPending = false
        applicationInitSent = false
        bondTimeoutArmed = false
        firstNotifyAttempts = 0
        enableCccdQueue.clear()
        totalNotifyCharacteristics = 0
        setState(BleState.Idle)
        unregisterBondReceiver()
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

    private fun registerBondReceiver() {
        if (bondReceiverRegistered) return
        context.registerReceiver(bondReceiver, IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED))
        bondReceiverRegistered = true
    }

    private fun unregisterBondReceiver() {
        if (!bondReceiverRegistered) return
        try {
            context.unregisterReceiver(bondReceiver)
        } catch (_: Exception) {
        }
        bondReceiverRegistered = false
    }

    private fun startApplicationInit(reason: String) {
        if (applicationInitSent) {
            logger.logInfo(TAG, "Application init already sent; skipping reason=$reason")
            return
        }
        setState(BleState.ApplicationInit)
        val payload = APPLICATION_INIT_COMMAND.toByteArray(Charsets.UTF_8)
        logger.logInfo(TAG, "Entering APPLICATION_INIT reason=$reason payload=${HexUtils.toHex(payload)}")
        val sent = protocol.send(payload, withResponse = false)
        applicationInitSent = sent
        applicationInitPending = sent
        if (!sent) {
            logger.logError(TAG, "Failed to send application-init command")
            setState(BleState.Error(BleErrorReason.HANDSHAKE_WRITE_FAILED))
        } else {
            logger.logInfo(TAG, "Sending get_air_glass_info sent=$sent")
            startTimeout(TIMEOUT_APP_INIT, APP_INIT_TIMEOUT_MS) {
                applicationInitPending = false
                setState(BleState.Error(BleErrorReason.APP_INIT_TIMEOUT))
            }
        }
    }

    /**
     * Протокол опускается сюда, чтобы не потерять ответ нотификации: так мы выводим очки из pairing
     * и переводим их в рабочее меню сразу после первого JSON.
     */
    fun onProtocolMessage(json: JSONObject, source: UUID) {
        logger.logInfo(TAG, "Protocol message from $source: $json")
        if (awaitingFirstNotify) {
            awaitingFirstNotify = false
            stopTimeout(TIMEOUT_FIRST_NOTIFY)
            logger.logInfo(TAG, "First notify received from $source; finishing handshake")
            setState(BleState.HandshakeDone)
            val bondState = targetDevice?.bondState
            if (bondState == BluetoothDevice.BOND_BONDING) {
                setState(BleState.WaitingForSystemPairing)
            }
            startApplicationInit("first_notify_received_${source}")
        }
        if (applicationInitPending) {
            applicationInitPending = false
            stopTimeout(TIMEOUT_APP_INIT)
            setState(BleState.ApplicationReady)
        }
    }

    private val bondReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action != BluetoothDevice.ACTION_BOND_STATE_CHANGED) return
            val device: BluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE) ?: return
            if (targetDevice == null || device.address != targetDevice?.address) return
            val stateExtra = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.BOND_NONE)
            val prevExtra = intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.BOND_NONE)
            logger.logInfo(TAG, "Bond change $prevExtra -> $stateExtra")
            when (stateExtra) {
                BluetoothDevice.BOND_BONDING -> {
                    setState(BleState.WaitingForSystemPairing)
                    startBondTimeout()
                }
                BluetoothDevice.BOND_BONDED -> {
                    stopTimeout(TIMEOUT_BOND)
                    stopTimeout(TIMEOUT_FIRST_NOTIFY)
                    bondTimeoutArmed = false
                    setState(BleState.Bonded)
                }
                BluetoothDevice.BOND_NONE -> {
                    if (prevExtra == BluetoothDevice.BOND_BONDING) {
                        setState(BleState.Error(BleErrorReason.BONDING_FAILED))
                        disconnect()
                    }
                }
            }
        }
    }

    private fun startBondTimeout() {
        if (bondTimeoutArmed) return
        bondTimeoutArmed = true
        startTimeout(TIMEOUT_BOND, BOND_TIMEOUT_MS) {
            setState(BleState.Error(BleErrorReason.BONDING_TIMEOUT))
            disconnect()
        }
    }

    private fun bondStateString(state: Int?): String {
        return when (state) {
            BluetoothDevice.BOND_NONE -> "BOND_NONE"
            BluetoothDevice.BOND_BONDING -> "BOND_BONDING"
            BluetoothDevice.BOND_BONDED -> "BOND_BONDED"
            else -> "UNKNOWN"
        }
    }

    companion object {
        private const val TAG = "BleManager"
        private const val SERVICE_UUID = "00000bd1-0000-1000-8000-00805f9b34fb"
        private const val NOTIFY_UUID = "00002021-0000-1000-8000-00805f9b34fb"
        private const val CONTROL_UUID = "00002020-0000-1000-8000-00805f9b34fb"
        private const val SYSTEM_NOTIFY_UUID = "00001001-0000-1000-8000-00805f9b34fb"
        private const val CCCD_UUID = "00002902-0000-1000-8000-00805f9b34fb"
        private const val SCAN_TIMEOUT_MS = 25_000L
        private const val CONNECT_TIMEOUT_MS = 12_000L
        private const val DISCOVERY_TIMEOUT_MS = 10_000L
        private const val FIRST_NOTIFY_TIMEOUT_MS = 10_000L
        private const val APP_INIT_TIMEOUT_MS = 10_000L
        private const val BOND_TIMEOUT_MS = 60_000L
        private const val RETRY_DELAY_MS = 800L
        private const val MAX_RETRIES = 3
        private const val MAX_FIRST_NOTIFY_ATTEMPTS = 2
        private const val TIMEOUT_SCAN = "timeout_scan"
        private const val TIMEOUT_CONNECT = "timeout_connect"
        private const val TIMEOUT_DISCOVERY = "timeout_discovery"
        private const val TIMEOUT_FIRST_NOTIFY = "timeout_first_notify"
        private const val TIMEOUT_APP_INIT = "timeout_app_init"
        private const val TIMEOUT_BOND = "timeout_bond"
        private val START_COMMAND = byteArrayOf(0x00, 0x00, 0x06, 0x11, 0x01, 0x00)
        private const val APPLICATION_INIT_COMMAND = "{\"action\":\"air_ota\",\"data\":{\"action\":\"get_air_glass_info\",\"value\":\"\"}}"
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
