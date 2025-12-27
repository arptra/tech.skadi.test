package com.example.myvuserver.ble

import java.util.UUID

/**
 * WHY: Mirrors the BluetoothConstants from the decompiled StarryNet app so we
 * can faithfully present the same advertising and GATT surface to the XR glasses.
 */
object StarryNetUuids {
    const val MANUFACTURER_ID = 0x0BD1

    val SERVICE: UUID = Uuid16.SERVICE_0BD1
    val WRITE_UUID: UUID = Uuid16.CHAR_2000
    val MULTI_WRITE_UUID: UUID = Uuid16.CHAR_2001
    val WRITE_MESSAGE_UUID: UUID = Uuid16.CHAR_2002
    val AIR_INTERNAL_MESSAGE_UUID: UUID = Uuid16.CHAR_2020
    val AIR_EXTERNAL_MESSAGE_UUID: UUID = Uuid16.CHAR_2021
    val AIR_URGENT_EXTERNAL_MESSAGE_UUID: UUID = Uuid16.CHAR_2022
    val GLASS_WRITE_UUID: UUID = Uuid16.CHAR_2023

    val XR_NOTIFY_UUIDS: Set<UUID> = setOf(
        MULTI_WRITE_UUID,
        WRITE_MESSAGE_UUID
    )
}
