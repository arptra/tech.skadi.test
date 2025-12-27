package com.skadi.myvu.bleclient.ble

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** Unified logger that pushes messages to Logcat and the UI. */
class BleLogger {
    private val sdf = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)
    private val _logs = MutableLiveData<List<String>>(emptyList())
    val logs: LiveData<List<String>> = _logs
    private val maxLines = 300

    private fun append(prefix: String, tag: String, message: String, throwable: Throwable? = null) {
        val ts = sdf.format(Date())
        val text = "$ts [$tag] $prefix$message" + (throwable?.let { " | ${it.message}" } ?: "")
        when (prefix) {
            "E: " -> Log.e(tag, message, throwable)
            else -> Log.i(tag, message, throwable)
        }
        val updated = (_logs.value ?: emptyList()) + text
        _logs.postValue(updated.takeLast(maxLines))
    }

    fun logInfo(tag: String, message: String) {
        append("I: ", tag, message, null)
    }

    fun logError(tag: String, message: String, throwable: Throwable? = null) {
        append("E: ", tag, message, throwable)
    }

    fun logState(from: BleState, to: BleState, reason: String?) {
        append("S: ", "State", "${from.label} -> ${to.label}${reason?.let { " ($it)" } ?: ""}")
    }
}
