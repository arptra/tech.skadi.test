package com.skadi.myvu.bleclient.ble

import android.bluetooth.*
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

class BleManager(private val context: Context, private val logger: BleLogger) {
    interface Listener {
        fun onStateChanged(state: BleState)
        fun onDeviceUpdated(name: String?, address: String?)
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    private val operationQueue: LinkedList<Operation> = LinkedList()
    private var operationInProgress = false

    private var listener: Listener? = null
    private var scanner: BleScanner? = null
    private var device: BluetoothDevice? = null
    private var gatt: BluetoothGatt? = null
    private var gattModel: GattModel? = null
    private var protocol: BleProtocol = BleProtocol(this, logger)
    private var state: BleState = BleState.Idle
    private var connectRetries = 0

    private var bondReceiverRegistered = false

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun removeListener() {
        this.listener = null
    }

    fun currentState(): BleState = state

    fun startScanAndConnect() {
        logger.logInfo(TAG, "Starting scan flow")
        reset()
        setState(BleState.Scanning)
        scanner = BleScanner(context, logger, onDeviceFound = { result ->
            device = result.device
            listener?.onDeviceUpdated(result.device.name, result.device.address)
            setState(BleState.DeviceFound)
            handleBondingOrConnect(result.device)
        }, onTimeout = {
            if (state is BleState.Scanning) {
                setState(BleState.Error("Scan timeout"))
            }
        })
        scanner?.startScan()
    }

    fun disconnect() {
        logger.logInfo(TAG, "Disconnect requested")
        mainHandler.removeCallbacksAndMessages(null)
        if (state !is BleState.Disconnected && state !is BleState.Idle) {
            setState(BleState.Disconnecting)
        }
        scanner?.stopScan()
        unregisterBondReceiver()
        clearQueue()
        gatt?.disconnect()
        gatt?.close()
        gatt = null
        protocol.clear()
        stopTimeouts()
        setState(BleState.Disconnected)
    }

    fun destroy() {
        disconnect()
        removeListener()
    }

    private fun handleBondingOrConnect(device: BluetoothDevice) {
        if (device.bondState != BluetoothDevice.BOND_BONDED) {
            logger.logInfo(TAG, "Initiating bond")
            registerBondReceiver()
            setState(BleState.Bonding)
            device.createBond()
        } else {
            connect(device)
        }
    }

    private fun connect(device: BluetoothDevice) {
        setState(BleState.Connecting)
        startTimeout(TIMEOUT_CONNECT, CONNECT_TIMEOUT_MS)
        gatt = device.connectGatt(context, false, BleGattCallback(this, logger), BluetoothDevice.TRANSPORT_LE)
    }

    fun handleConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
        stopTimeout(TIMEOUT_CONNECT)
        if (status == 133) {
            logger.logError(TAG, "GATT 133 encountered; retrying")
            if (connectRetries < MAX_RETRIES) {
                connectRetries++
                retryConnection(gatt.device)
                return
            } else {
                setState(BleState.Error("GATT 133 persistent"))
                disconnect()
                return
            }
        }
        if (newState == BluetoothProfile.STATE_CONNECTED && status == BluetoothGatt.GATT_SUCCESS) {
            connectRetries = 0
            setState(BleState.Connected)
            setState(BleState.DiscoveringServices)
            startTimeout(TIMEOUT_DISCOVERY, DISCOVERY_TIMEOUT_MS)
            gatt.discoverServices()
        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            logger.logInfo(TAG, "Disconnected status=$status")
            cleanupAfterDisconnect()
        }
    }

    private fun retryConnection(device: BluetoothDevice) {
        logger.logInfo(TAG, "Retrying connection attempt $connectRetries")
        this.gatt?.close()
        BluetoothUtils.refreshGattCache(this.gatt)
        mainHandler.postDelayed({ connect(device) }, RETRY_DELAY_MS)
    }

    fun handleServicesDiscovered(gatt: BluetoothGatt, status: Int) {
        stopTimeout(TIMEOUT_DISCOVERY)
        if (status != BluetoothGatt.GATT_SUCCESS) {
            setState(BleState.Error("Service discovery failed ($status)"))
            disconnect()
            return
        }
        val services = gatt.services
        val descriptors = services.flatMap { it.characteristics }.flatMap { it.descriptors }
        val notifyChar = services.firstNotNullOfOrNull { service ->
            service.characteristics.firstOrNull { it.properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0 }
        }
        val writeChar = services.firstNotNullOfOrNull { service ->
            service.characteristics.firstOrNull {
                it.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0
            }
        } ?: services.firstNotNullOfOrNull { service ->
            service.characteristics.firstOrNull { it.properties and BluetoothGattCharacteristic.PROPERTY_WRITE != 0 }
        }
        gattModel = GattModel(services, notifyChar, writeChar, descriptors)
        protocol.gatt = gatt
        protocol.notifyCharacteristic = notifyChar
        protocol.writeCharacteristic = writeChar

        logGattDump(services)
        setState(BleState.ServicesDiscovered)

        setState(BleState.NegotiatingMtu)
        val mtuRequested = if (!gatt.requestMtu(517)) {
            gatt.requestMtu(247)
        } else true
        if (!mtuRequested) {
            logger.logError(TAG, "MTU request failed to enqueue")
        }
    }

    fun handleMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
        setState(BleState.MtuReady)
        enableNotifications(gatt)
    }

    private fun enableNotifications(gatt: BluetoothGatt) {
        val notifyChar = protocol.notifyCharacteristic
        if (notifyChar == null) {
            setState(BleState.Error("No NOTIFY characteristic"))
            disconnect()
            return
        }
        setState(BleState.EnablingNotifications)
        val cccd = notifyChar.descriptors.firstOrNull { it.uuid == UUID.fromString(CCCD_UUID) }
        if (cccd == null) {
            setState(BleState.Error("Missing CCCD"))
            disconnect()
            return
        }
        gatt.setCharacteristicNotification(notifyChar, true)
        cccd.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
        enqueueDescriptorWrite(gatt, cccd)
        startTimeout(TIMEOUT_CCCD, CCCD_TIMEOUT_MS)
    }

    fun handleDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
        stopTimeout(TIMEOUT_CCCD)
        if (descriptor.uuid == UUID.fromString(CCCD_UUID)) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                setState(BleState.NotificationsEnabled)
                setState(BleState.Ready)
            } else {
                setState(BleState.Error("CCCD write failed ($status)"))
                disconnect()
            }
        }
        onOperationComplete()
    }

    fun handleCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
        if (status != BluetoothGatt.GATT_SUCCESS) {
            logger.logError(TAG, "Characteristic write failed ($status)")
        }
        onOperationComplete()
    }

    fun handleCharacteristicChanged(characteristic: BluetoothGattCharacteristic) {
        val payload = characteristic.value
        logger.logInfo(TAG, "RX (${characteristic.uuid} len=${payload?.size ?: 0}): ${HexUtils.toHex(payload)}")
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
        withResponse: Boolean
    ): Boolean {
        val type = if (!withResponse && characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0) {
            BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
        } else {
            BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
        }
        operationQueue.add(Operation.CharacteristicWrite(gatt, characteristic, payload, type))
        processNextOperation()
        return true
    }

    fun send(payload: ByteArray, withResponse: Boolean = false): Boolean {
        return protocol.send(payload, withResponse)
    }

    private fun processNextOperation() {
        if (operationInProgress) return
        val op = operationQueue.poll() ?: return
        operationInProgress = true
        when (op) {
            is Operation.DescriptorWrite -> {
                op.descriptor.value = op.descriptor.value
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
                if (!started) {
                    logger.logError(TAG, "Failed to start characteristic write")
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

    private fun registerBondReceiver() {
        if (bondReceiverRegistered) return
        val filter = IntentFilter().apply {
            addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED)
            addAction(BluetoothDevice.ACTION_PAIRING_REQUEST)
        }
        context.registerReceiver(bondReceiver, filter)
        bondReceiverRegistered = true
    }

    private fun unregisterBondReceiver() {
        if (bondReceiverRegistered) {
            try {
                context.unregisterReceiver(bondReceiver)
            } catch (_: Exception) {
            }
            bondReceiverRegistered = false
        }
    }

    private val bondReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action ?: return
            val device = intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE) ?: return
            if (device.address != this@BleManager.device?.address) return
            when (action) {
                BluetoothDevice.ACTION_PAIRING_REQUEST -> {
                    logger.logInfo(TAG, "Pairing requested")
                }
                BluetoothDevice.ACTION_BOND_STATE_CHANGED -> {
                    val bondState = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.ERROR)
                    val prev = intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.ERROR)
                    logger.logInfo(TAG, "Bond state changed $prev -> $bondState")
                    when (bondState) {
                        BluetoothDevice.BOND_BONDED -> {
                            unregisterBondReceiver()
                            connect(device)
                        }
                        BluetoothDevice.BOND_NONE -> {
                            setState(BleState.Error("Bond failed"))
                            disconnect()
                        }
                    }
                }
            }
        }
    }

    private fun cleanupAfterDisconnect() {
        unregisterBondReceiver()
        clearQueue()
        stopTimeouts()
        gatt?.close()
        gatt = null
        protocol.clear()
        setState(BleState.Disconnected)
    }

    private fun reset() {
        stopTimeouts()
        clearQueue()
        scanner?.stopScan()
        unregisterBondReceiver()
        gatt?.close()
        gatt = null
        protocol.clear()
        connectRetries = 0
        setState(BleState.Idle)
    }

    private fun clearQueue() {
        operationQueue.clear()
        operationInProgress = false
    }

    private fun setState(newState: BleState) {
        if (state::class == newState::class && state !is BleState.Error) return
        logger.logState(state.label, newState.label)
        state = newState
        listener?.onStateChanged(newState)
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

    private fun startTimeout(key: String, durationMs: Long) {
        stopTimeout(key)
        val runnable = Runnable {
            logger.logError(TAG, "Timeout: $key")
            when (key) {
                TIMEOUT_DISCOVERY -> setState(BleState.Error("Service discovery timeout"))
                TIMEOUT_CCCD -> setState(BleState.Error("CCCD write timeout"))
                TIMEOUT_CONNECT -> setState(BleState.Error("Connect timeout"))
            }
            disconnect()
        }
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

    private val timeouts = mutableMapOf<String, Runnable>()

    companion object {
        private const val TAG = "BleManager"
        private const val CCCD_UUID = "00002902-0000-1000-8000-00805f9b34fb"
        private const val CONNECT_TIMEOUT_MS = 10_000L
        private const val DISCOVERY_TIMEOUT_MS = 10_000L
        private const val CCCD_TIMEOUT_MS = 8_000L
        private const val RETRY_DELAY_MS = 800L
        private const val MAX_RETRIES = 3
        private const val TIMEOUT_DISCOVERY = "timeout_discovery"
        private const val TIMEOUT_CCCD = "timeout_cccd"
        private const val TIMEOUT_CONNECT = "timeout_connect"
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
}
