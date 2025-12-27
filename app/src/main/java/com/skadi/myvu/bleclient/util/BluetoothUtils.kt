package com.skadi.myvu.bleclient.util

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothManager
import android.content.Context
import java.lang.reflect.Method

/** Helper utilities for Bluetooth specifics. */
object BluetoothUtils {
    fun isBluetoothEnabled(context: Context): Boolean {
        val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        return manager.adapter?.isEnabled == true
    }

    fun refreshGattCache(gatt: BluetoothGatt): Boolean {
        return try {
            val refresh: Method = gatt.javaClass.getMethod("refresh")
            val success = refresh.invoke(gatt) as Boolean
            success
        } catch (e: Exception) {
            false
        }
    }

    fun adapter(context: Context): BluetoothAdapter? {
        val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        return manager.adapter
    }
}
