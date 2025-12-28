package com.skadi.myvu.bleclient.util

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothManager
import android.content.Context
import android.location.LocationManager

object BluetoothUtils {
    fun getAdapter(context: Context): BluetoothAdapter? {
        val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        return manager?.adapter
    }

    fun refreshGattCache(gatt: BluetoothGatt?): Boolean {
        return try {
            val method = gatt?.javaClass?.getMethod("refresh")
            method?.isAccessible = true
            val result = method?.invoke(gatt) as? Boolean
            result == true
        } catch (e: Exception) {
            false
        }
    }

    fun isBluetoothEnabled(context: Context): Boolean {
        val adapter = getAdapter(context)
        return adapter != null && adapter.isEnabled
    }

    fun supportsLe(context: Context): Boolean {
        val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        return manager?.adapter != null && context.packageManager.hasSystemFeature("android.hardware.bluetooth_le")
    }

    fun isLocationEnabled(context: Context): Boolean {
        val lm = context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager ?: return false
        return try {
            lm.isProviderEnabled(LocationManager.GPS_PROVIDER) || lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (e: Exception) {
            false
        }
    }
}
