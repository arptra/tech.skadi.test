package com.skadi.myvu.bleclient.ble

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Central logger that fans out to Logcat and keeps a bounded in-memory buffer for UI.
 */
class BleLogger(private val maxLines: Int = 300) {
    private val buffer = ArrayDeque<String>()
    private val listeners = CopyOnWriteArrayList<(List<String>) -> Unit>()
    private val dateFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)

    fun addListener(listener: (List<String>) -> Unit) {
        listeners.add(listener)
        listener.invoke(buffer.toList())
    }

    fun removeListener(listener: (List<String>) -> Unit) {
        listeners.remove(listener)
    }

    fun logInfo(tag: String, message: String) {
        val line = "${timestamp()} [INFO][$tag] $message"
        Log.i(tag, message)
        append(line)
    }

    fun logError(tag: String, message: String, throwable: Throwable? = null) {
        val line = "${timestamp()} [ERROR][$tag] $message ${throwable?.message ?: ""}".trim()
        Log.e(tag, message, throwable)
        append(line)
    }

    fun logState(from: String, to: String, reason: String? = null) {
        val line = "${timestamp()} [STATE] $from -> $to ${reason?.let { "($it)" } ?: ""}".trim()
        Log.i("BleState", line)
        append(line)
    }

    private fun append(line: String) {
        if (buffer.size >= maxLines) {
            buffer.removeFirst()
        }
        buffer.addLast(line)
        listeners.forEach { it.invoke(buffer.toList()) }
    }

    private fun timestamp(): String = dateFormat.format(Date())
}
