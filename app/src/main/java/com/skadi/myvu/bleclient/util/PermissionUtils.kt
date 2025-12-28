package com.skadi.myvu.bleclient.util

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {
    private const val REQUEST_CODE = 1001

    fun ensureBlePermissions(activity: Activity, onResult: (granted: Boolean) -> Unit) {
        val permissions = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions += listOf(
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_CONNECT
            )
        } else {
            permissions += Manifest.permission.ACCESS_FINE_LOCATION
        }

        val missing = permissions.filter {
            ContextCompat.checkSelfPermission(activity, it) != PackageManager.PERMISSION_GRANTED
        }
        if (missing.isEmpty()) {
            onResult(true)
        } else {
            ActivityCompat.requestPermissions(activity, missing.toTypedArray(), REQUEST_CODE)
            permissionCallback = onResult
        }
    }

    private var permissionCallback: ((Boolean) -> Unit)? = null

    fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE) {
            val granted = grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }
            permissionCallback?.invoke(granted)
            permissionCallback = null
        }
    }
}
