package com.example.myvuserver.ble

import java.util.Locale
import java.util.UUID

/**
 * WHY: StarryNet relies on 16-bit Bluetooth UUIDs expanded into the 128-bit
 * base form. Keeping this helper avoids typos when we need to mirror the
 * exact short IDs observed in the decompiled app.
 */
object Uuid16 {
    fun from16(shortUuid: Int): UUID {
        val normalized = shortUuid and 0xFFFF
        val uuid = String.format(
            Locale.US,
            "0000%04x-0000-1000-8000-00805f9b34fb",
            normalized
        )
        return UUID.fromString(uuid)
    }

    val SERVICE_0BD1: UUID = from16(0x0BD1)
    val CHAR_INTERNAL_NOTIFY: UUID = from16(0x03E8)
    val CHAR_VERSION_NOTIFY: UUID = from16(0x03E9)
    val CHAR_WRITE: UUID = from16(0x07D0)
    val CCC: UUID = from16(0x2902)
}
