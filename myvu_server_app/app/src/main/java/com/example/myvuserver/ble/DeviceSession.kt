package com.example.myvuserver.ble

import android.bluetooth.BluetoothDevice

/**
 * WHY: GATT callbacks are stateless. We keep track of the single remote
 * glasses device that connected so we can show diagnostics (MTU, CCC state)
 * and decide whether we are allowed to push notifications.
 */
data class DeviceSession(
    val device: BluetoothDevice,
    var connected: Boolean = true,
    var connectedAt: Long = System.currentTimeMillis(),
    var lastSeen: Long = System.currentTimeMillis(),
    var mtu: Int = 23,
    var notifyEnabledInternal: Boolean = false,
    var notifyEnabledVersion: Boolean = false,
    var validConnected: Boolean = false
) {
    fun updateValid() {
        validConnected = connected && (notifyEnabledInternal || notifyEnabledVersion)
    }

    fun enabledNotifies(): Set<java.util.UUID> {
        val set = mutableSetOf<java.util.UUID>()
        if (notifyEnabledInternal) set.add(StarryNetUuids.CHAR_INTERNAL_NOTIFY)
        if (notifyEnabledVersion) set.add(StarryNetUuids.CHAR_VERSION_NOTIFY)
        return set
    }
}
