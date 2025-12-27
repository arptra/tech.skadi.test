package com.example.myvuserver.ble

import android.bluetooth.BluetoothDevice

/**
 * WHY: GATT callbacks are stateless. We keep track of the single remote
 * glasses device that connected so we can show diagnostics (MTU, CCC state)
 * and decide whether we are allowed to push notifications.
 */
data class DeviceSession(
    val device: BluetoothDevice,
    var connectedAt: Long = System.currentTimeMillis(),
    var lastSeen: Long = System.currentTimeMillis(),
    var mtu: Int = 23,
    var notifyEnabled: Boolean = false
)
