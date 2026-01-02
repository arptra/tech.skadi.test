package com.skadi.myvu.bleclient.debug

import com.skadi.myvu.bleclient.ble.BleLogger
import com.skadi.myvu.bleclient.ble.BleManager
import com.skadi.myvu.bleclient.util.HexUtils

class CommandDispatcher(
    private val bleManager: BleManager,
    private val logger: BleLogger
) {
    fun dispatch(command: Command): CommandResult {
        val payload = HexUtils.fromHex(command.payloadHex)
        if (payload == null) {
            return CommandResult(command, false, "Неверный HEX: ${command.payloadHex}")
        }
        val success = bleManager.send(payload, command.withResponse)
        val message = if (success) {
            "Отправлено ${payload.size} байт"
        } else {
            "Характеристика недоступна или нет соединения"
        }
        if (!success) {
            logger.logError(TAG, message)
        }
        return CommandResult(command, success, message)
    }

    companion object {
        private const val TAG = "CommandDispatcher"
    }
}
