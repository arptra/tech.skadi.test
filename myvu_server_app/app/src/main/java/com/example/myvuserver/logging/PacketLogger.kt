package com.example.myvuserver.logging

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.CopyOnWriteArrayList

/**
 * WHY: central place to record everything the GATT server sees so that
 * we can debug handshake attempts from the glasses without attaching
 * a debugger. Logcat is noisy, so we also buffer lines for the UI and
 * export to file.
 */
class PacketLogger(private val context: Context) {
    private val dateFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)
    private val entries = CopyOnWriteArrayList<String>()
    private val liveData = MutableLiveData<List<String>>()

    val logs: LiveData<List<String>> = liveData

    fun log(message: String) {
        val line = "${dateFormat.format(Date())} | $message"
        Log.d(TAG, line)
        entries.add(line)
        if (entries.size > 200) {
            // keep memory bounded for UI rendering
            repeat(entries.size - 200) { entries.removeAt(0) }
        }
        liveData.postValue(entries.toList())
    }

    fun clear() {
        entries.clear()
        liveData.postValue(emptyList())
    }

    fun exportToFile(): File {
        val dir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) ?: context.filesDir
        val outFile = File(dir, "myvu_server_log_${System.currentTimeMillis()}.txt")
        outFile.writeText(entries.joinToString(separator = "\n"))
        return outFile
    }

    companion object {
        const val TAG = "MYVU_SERVER"
    }
}
