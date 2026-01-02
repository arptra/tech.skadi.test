package com.skadi.myvu.bleclient.debug

import android.content.Context
import com.skadi.myvu.bleclient.ble.BleLogger
import com.skadi.myvu.bleclient.ble.BleManager

object BleSessionHolder {
    var logger: BleLogger? = null
    var bleManager: BleManager? = null

    fun ensure(context: Context): Pair<BleManager, BleLogger> {
        val activeLogger = logger ?: BleLogger().also { logger = it }
        val activeManager = bleManager ?: BleManager(context, activeLogger).also { bleManager = it }
        return activeManager to activeLogger
    }
}
