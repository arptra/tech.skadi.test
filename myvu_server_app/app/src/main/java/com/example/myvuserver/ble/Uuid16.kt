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
    val CHAR_2000: UUID = from16(0x2000)
    val CHAR_2001: UUID = from16(0x2001)
    val CHAR_2002: UUID = from16(0x2002)
    val CHAR_2020: UUID = from16(0x2020)
    val CHAR_2021: UUID = from16(0x2021)
    val CHAR_2022: UUID = from16(0x2022)
    val CHAR_2023: UUID = from16(0x2023)
    val CCC: UUID = Uuid16.from16(0x2902)
}
