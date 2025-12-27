package com.example.myvuserver.ble

import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattService

/**
 * WHY: StarryNet exposes one primary service (0x0BD1) with multiple
 * characteristics under it. Building the profile in one place avoids
 * inconsistencies across GATT server restarts.
 */
object StarryNetGattProfile {
    data class Profile(
        val service: BluetoothGattService,
        val characteristics: Map<java.util.UUID, BluetoothGattCharacteristic>
    )

    fun build(serviceUuid: java.util.UUID = StarryNetUuids.SERVICE): Profile {
        val service = BluetoothGattService(serviceUuid, BluetoothGattService.SERVICE_TYPE_PRIMARY)

        val characteristics = mutableMapOf<java.util.UUID, BluetoothGattCharacteristic>()

        fun addWrite(uuid: java.util.UUID): BluetoothGattCharacteristic {
            val c = BluetoothGattCharacteristic(
                uuid,
                BluetoothGattCharacteristic.PROPERTY_WRITE or BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE,
                BluetoothGattCharacteristic.PERMISSION_WRITE
            )
            service.addCharacteristic(c)
            characteristics[uuid] = c
            return c
        }

        fun addNotify(uuid: java.util.UUID): BluetoothGattCharacteristic {
            val c = BluetoothGattCharacteristic(
                uuid,
                BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                BluetoothGattCharacteristic.PERMISSION_READ
            )
            val ccc = BluetoothGattDescriptor(
                Uuid16.CCC,
                BluetoothGattDescriptor.PERMISSION_READ or BluetoothGattDescriptor.PERMISSION_WRITE
            )
            c.addDescriptor(ccc)
            service.addCharacteristic(c)
            characteristics[uuid] = c
            return c
        }

        addNotify(StarryNetUuids.CHAR_INTERNAL_NOTIFY)
        addNotify(StarryNetUuids.CHAR_VERSION_NOTIFY)
        addWrite(StarryNetUuids.CHAR_WRITE)

        return Profile(service, characteristics)
    }
}
