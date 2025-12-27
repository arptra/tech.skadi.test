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

        // Mandatory write entry point for glasses → phone messages.
        addWrite(StarryNetUuids.WRITE_UUID)

        // Notify channels that mark the connection as XR-valid once CCC is enabled.
        addNotify(StarryNetUuids.MULTI_WRITE_UUID)
        addNotify(StarryNetUuids.WRITE_MESSAGE_UUID)

        // Internal/External message pipes. Properties are inferred from StarryNet
        // behavior (notify downstream), but protocol specifics can be filled later.
        addNotify(StarryNetUuids.AIR_INTERNAL_MESSAGE_UUID)
        addNotify(StarryNetUuids.AIR_EXTERNAL_MESSAGE_UUID)
        addNotify(StarryNetUuids.AIR_URGENT_EXTERNAL_MESSAGE_UUID)

        // Glasses → phone write pipe.
        addWrite(StarryNetUuids.GLASS_WRITE_UUID)

        return Profile(service, characteristics)
    }
}
