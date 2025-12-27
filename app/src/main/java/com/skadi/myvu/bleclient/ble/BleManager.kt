package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothProfile
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.Looper
import com.skadi.myvu.bleclient.util.BluetoothUtils
import com.skadi.myvu.bleclient.util.HexUtils
import java.util.ArrayDeque
import java.util.UUID
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BleManager(private val context: Context, private val logger: BleLogger) {
    private val handler = Handler(Looper.getMainLooper())
    private val stateData = MutableLiveData<BleState>(BleState.Idle)
    val state: LiveData<BleState> = stateData
    private val deviceData = MutableLiveData<BluetoothDevice?>()
    val device: LiveData<BluetoothDevice?> = deviceData
    val logs = logger.logs

    private var currentGatt: BluetoothGatt? = null
    private var notifyCharacteristic: BluetoothGattCharacteristic? = null
    private var writeCharacteristic: BluetoothGattCharacteristic? = null
    private val protocol = BleProtocol(this, logger)
    private var scanner: BleScanner? = null

    private var bondReceiverRegistered = false
    private var retries133 = 0
    private val max133Retries = 3

    private var connectTimeout: Runnable? = null
    private var serviceTimeout: Runnable? = null
    private var cccdTimeout: Runnable? = null

    private val operationQueue: ArrayDeque<BleOperation> = ArrayDeque()
    private var operationInProgress = false

    private val cccdUuid = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")

    fun startScanAndConnect() {
        cleanup(resetState = true)
        transition(BleState.Scanning, "User requested")
        scanner = BleScanner(
            context,
            logger,
            onDeviceFound = { device ->
                transition(BleState.DeviceFound, "Chose ${device.address}")
                deviceData.postValue(device)
                handleBondingOrConnect(device)
            },
            onTimeout = {
                transition(BleState.Error("Scan timeout"), "No device found")
            },
            onError = { error ->
                transition(BleState.Error(error), error)
            }
        ).also { it.startScan() }
    }

    fun disconnect() {
        val gatt = currentGatt
        transition(BleState.Disconnecting, "User requested")
        scanner?.stopScan()
        cancelTimeouts()
        operationQueue.clear()
        operationInProgress = false
        if (gatt != null) {
            try { gatt.disconnect() } catch (_: Exception) {}
            try { gatt.close() } catch (_: Exception) {}
        }
        currentGatt = null
        notifyCharacteristic = null
        writeCharacteristic = null
        protocol.configure(null, null, null)
        unregisterBondReceiver()
        transition(BleState.Disconnected, "Clean disconnect")
    }

    fun sendTestCommand() {
        val payload = byteArrayOf(0x01, 0x00)
        protocol.send(payload, withResponse = false)
    }

    fun enqueueWrite(
        gatt: BluetoothGatt,
        characteristic: BluetoothGattCharacteristic,
        data: ByteArray,
        withResponse: Boolean
    ): Boolean {
        characteristic.writeType = if (!withResponse && characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0) {
            BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
        } else {
            BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
        }
        characteristic.value = data
        val op = BleOperation("Write ${characteristic.uuid}") { gatt.writeCharacteristic(characteristic) }
        enqueue(op)
        return true
    }

    private fun enqueue(operation: BleOperation) {
        operationQueue.add(operation)
        processQueue()
    }

    private fun processQueue() {
        if (operationInProgress) return
        val gatt = currentGatt ?: return
        val op = operationQueue.poll() ?: return
        operationInProgress = true
        val started = op.execute(gatt)
        if (!started) {
            operationInProgress = false
            processQueue()
        }
    }

    private fun operationCompleted() {
        operationInProgress = false
        processQueue()
    }

    private fun handleBondingOrConnect(device: BluetoothDevice) {
        scanner?.stopScan()
        if (device.bondState != BluetoothDevice.BOND_BONDED) {
            transition(BleState.Bonding, "Bond required")
            registerBondReceiver(device)
            device.createBond()
        } else {
            connectGatt(device)
        }
    }

    private fun connectGatt(device: BluetoothDevice) {
        transition(BleState.Connecting, "Connecting to ${device.address}")
        retries133 = 0
        val callback = BleGattCallback(this)
        currentGatt = device.connectGatt(context, false, callback, BluetoothDevice.TRANSPORT_LE)
        scheduleConnectTimeout(device)
    }

    private fun retryConnect(device: BluetoothDevice) {
        if (retries133 >= max133Retries) {
            transition(BleState.Error("133 after retries"), "Exceeded retries")
            return
        }
        retries133++
        handler.postDelayed({
            logger.logInfo("BleManager", "Retrying connect attempt $retries133")
            currentGatt?.close()
            currentGatt = device.connectGatt(context, false, BleGattCallback(this), BluetoothDevice.TRANSPORT_LE)
            scheduleConnectTimeout(device)
        }, 800)
    }

    private fun scheduleConnectTimeout(device: BluetoothDevice) {
        connectTimeout?.let { handler.removeCallbacks(it) }
        connectTimeout = Runnable {
            transition(BleState.Error("Connect timeout"), "Did not connect in time")
            retryConnect(device)
        }.also { handler.postDelayed(it, 10_000) }
    }

    fun onConnectionStateChanged(gatt: BluetoothGatt, status: Int, newState: Int) {
        logger.logInfo("BleManager", "onConnectionStateChange status=$status newState=$newState")
        if (status == 133) {
            transition(BleState.Error("GATT 133"), "Retrying connect")
            BluetoothUtils.refreshGattCache(gatt)
            gatt.close()
            deviceData.value?.let { retryConnect(it) }
            return
        }
        if (newState == BluetoothProfile.STATE_CONNECTED) {
            connectTimeout?.let { handler.removeCallbacks(it) }
            transition(BleState.Connected, "Connected, discovering services")
            transition(BleState.DiscoveringServices, "Start discovery")
            gatt.discoverServices()
            serviceTimeout?.let { handler.removeCallbacks(it) }
            serviceTimeout = Runnable {
                transition(BleState.Error("Service discovery timeout"), "No services result")
                disconnect()
            }.also { handler.postDelayed(it, 10_000) }
        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            transition(BleState.Disconnected, "Remote disconnected")
            cleanup()
        }
    }

    fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
        serviceTimeout?.let { handler.removeCallbacks(it) }
        if (status != BluetoothGatt.GATT_SUCCESS) {
            transition(BleState.Error("Service discovery failed"), "status=$status")
            disconnect()
            return
        }
        val gattModel = GattModel.fromServices(gatt.services)
        gattModel.services.forEach { service ->
            logger.logInfo("Gatt", "Service ${service.uuid}")
            service.characteristics.forEach { ch ->
                logger.logInfo("Gatt", "  Char ${ch.uuid} props=${ch.properties}")
                ch.descriptors.forEach { desc -> logger.logInfo("Gatt", "    Desc ${desc.uuid}") }
            }
        }
        val notify = gatt.services.flatMap { it.characteristics }
            .firstOrNull { it.properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0 }
        val writeNr = gatt.services.flatMap { it.characteristics }
            .firstOrNull { it.properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0 }
        val write = writeNr ?: gatt.services.flatMap { it.characteristics }
            .firstOrNull { it.properties and BluetoothGattCharacteristic.PROPERTY_WRITE != 0 }

        notifyCharacteristic = notify
        writeCharacteristic = write
        protocol.configure(gatt, write, notify)

        transition(BleState.ServicesDiscovered, "Notify=${notify?.uuid} Write=${write?.uuid}")
        transition(BleState.NegotiatingMtu, "Request 517")
        val mtuRequested = gatt.requestMtu(517)
        if (!mtuRequested) {
            logger.logError("BleManager", "MTU request failed to start, fallback 247")
            gatt.requestMtu(247)
        }
    }

    fun onMtuChanged(gatt: BluetoothGatt, mtu: Int, status: Int) {
        logger.logInfo("BleManager", "MTU changed to $mtu status=$status")
        transition(BleState.MtuReady, "MTU callback")
        enableNotifications()
    }

    private fun enableNotifications() {
        val gatt = currentGatt ?: return
        val notifyChar = notifyCharacteristic
            ?: return transition(BleState.Error("No notify characteristic"), "Cannot enable notifications")
        transition(BleState.EnablingNotifications, "Enable notify ${notifyChar.uuid}")
        val descriptor = notifyChar.descriptors.firstOrNull { it.uuid == cccdUuid }
            ?: return transition(BleState.Error("CCCD missing"), "Notify char lacks descriptor")
        gatt.setCharacteristicNotification(notifyChar, true)
        descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
        enqueue(BleOperation("Write CCCD ${descriptor.uuid}") { gatt.writeDescriptor(descriptor) })
        cccdTimeout?.let { handler.removeCallbacks(it) }
        cccdTimeout = Runnable {
            transition(BleState.Error("CCCD write timeout"), "No descriptor callback")
            disconnect()
        }.also { handler.postDelayed(it, 8_000) }
    }

    fun onDescriptorWrite(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int) {
        cccdTimeout?.let { handler.removeCallbacks(it) }
        logger.logInfo("BleManager", "Descriptor write ${descriptor.uuid} status=$status")
        operationCompleted()
        if (status != BluetoothGatt.GATT_SUCCESS) {
            transition(BleState.Error("Descriptor write failed"), "status=$status")
            disconnect()
            return
        }
        if (descriptor.uuid == cccdUuid) {
            transition(BleState.NotificationsEnabled, "CCCD enabled")
            transition(BleState.Ready, "Ready for protocol")
        }
    }

    fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
        logger.logInfo("BleManager", "Characteristic write ${characteristic.uuid} status=$status")
        operationCompleted()
        if (status != BluetoothGatt.GATT_SUCCESS) {
            transition(BleState.Error("Write failed"), "status=$status")
        }
    }

    fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
        val value = characteristic.value ?: byteArrayOf()
        onCharacteristicChanged(gatt, characteristic, value)
    }

    fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray) {
        logger.logInfo(
            "BleManager",
            "RX uuid=${characteristic.uuid} len=${value.size} data=${HexUtils.toHex(value)}"
        )
    }

    private fun transition(newState: BleState, reason: String?) {
        val old = stateData.value ?: BleState.Idle
        logger.logState(old, newState, reason)
        stateData.postValue(newState)
    }

    private fun cleanup(resetState: Boolean = false) {
        scanner?.stopScan()
        cancelTimeouts()
        unregisterBondReceiver()
        operationQueue.clear()
        operationInProgress = false
        try {
            currentGatt?.disconnect()
            currentGatt?.close()
        } catch (_: Exception) {}
        currentGatt = null
        notifyCharacteristic = null
        writeCharacteristic = null
        protocol.configure(null, null, null)
        if (resetState) {
            transition(BleState.Idle, "Reset")
        }
    }

    private fun cancelTimeouts() {
        connectTimeout?.let { handler.removeCallbacks(it) }
        serviceTimeout?.let { handler.removeCallbacks(it) }
        cccdTimeout?.let { handler.removeCallbacks(it) }
    }

    private fun registerBondReceiver(target: BluetoothDevice) {
        if (bondReceiverRegistered) return
        val filter = IntentFilter().apply {
            addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED)
            addAction(BluetoothDevice.ACTION_PAIRING_REQUEST)
        }
        context.registerReceiver(bondReceiver, filter)
        bondReceiverRegistered = true
        deviceData.postValue(target)
    }

    private fun unregisterBondReceiver() {
        if (bondReceiverRegistered) {
            try { context.unregisterReceiver(bondReceiver) } catch (_: Exception) {}
            bondReceiverRegistered = false
        }
    }

    private val bondReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action ?: return
            val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
            when (action) {
                BluetoothDevice.ACTION_PAIRING_REQUEST -> {
                    logger.logInfo("BleManager", "Pairing request for ${device?.address}")
                }
                BluetoothDevice.ACTION_BOND_STATE_CHANGED -> {
                    val state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.ERROR)
                    logger.logInfo("BleManager", "Bond state changed: $state")
                    if (state == BluetoothDevice.BOND_BONDED && device != null) {
                        unregisterBondReceiver()
                        connectGatt(device)
                    } else if (state == BluetoothDevice.BOND_NONE) {
                        transition(BleState.Error("Bond failed"), "Bond none")
                    }
                }
            }
        }
    }

    private data class BleOperation(val description: String, val execute: (BluetoothGatt) -> Boolean)
}
