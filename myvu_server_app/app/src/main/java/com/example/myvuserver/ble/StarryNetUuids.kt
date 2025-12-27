package com.example.myvuserver.ble

import java.util.UUID

/**
 * WHY: Mirrors the BluetoothConstants from the decompiled StarryNet app so we
 * can faithfully present the same advertising and GATT surface to the XR glasses.
 */
object StarryNetUuids {
    val SERVICE: UUID = Uuid16.SERVICE_0BD1
    val CHAR_INTERNAL_NOTIFY: UUID = Uuid16.CHAR_INTERNAL_NOTIFY
    val CHAR_VERSION_NOTIFY: UUID = Uuid16.CHAR_VERSION_NOTIFY
    val CHAR_WRITE: UUID = Uuid16.CHAR_WRITE

    val XR_NOTIFY_UUIDS: Set<UUID> = setOf(
        CHAR_INTERNAL_NOTIFY,
        CHAR_VERSION_NOTIFY
    )
}
