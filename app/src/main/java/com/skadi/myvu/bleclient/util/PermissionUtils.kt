package com.skadi.myvu.bleclient.util

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat

/** Handles Bluetooth runtime permission checks and requests. */
object PermissionUtils {
    val requiredPermissions: Array<String>
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            arrayOf(
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_CONNECT
            )
        } else {
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        }

    fun hasPermissions(activity: Activity): Boolean {
        return requiredPermissions.all {
            ActivityCompat.checkSelfPermission(activity, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun ensureBlePermissions(activity: Activity, launcher: ActivityResultLauncher<Array<String>>) {
        if (!hasPermissions(activity)) {
            launcher.launch(requiredPermissions)
        }
    }
}
