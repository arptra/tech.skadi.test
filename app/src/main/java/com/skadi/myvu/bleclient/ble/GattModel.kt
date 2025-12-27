package com.skadi.myvu.bleclient.ble

import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattService

/** Representation of discovered GATT structure for logging. */
data class GattModel(
    val services: List<Service>
) {
    data class Service(
        val uuid: String,
        val characteristics: List<Characteristic>
    )

    data class Characteristic(
        val uuid: String,
        val properties: String,
        val descriptors: List<Descriptor>
    )

    data class Descriptor(
        val uuid: String
    )

    companion object {
        fun fromServices(services: List<BluetoothGattService>): GattModel {
            val mapped = services.map { service ->
                val chars = service.characteristics.map { ch ->
                    val props = propertiesToString(ch.properties)
                    val descs = ch.descriptors.map { Descriptor(it.uuid.toString()) }
                    Characteristic(ch.uuid.toString(), props, descs)
                }
                Service(service.uuid.toString(), chars)
            }
            return GattModel(mapped)
        }

        private fun propertiesToString(properties: Int): String {
            val flags = mutableListOf<String>()
            if (properties and BluetoothGattCharacteristic.PROPERTY_READ != 0) flags += "READ"
            if (properties and BluetoothGattCharacteristic.PROPERTY_WRITE != 0) flags += "WRITE"
            if (properties and BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE != 0) flags += "WRITE_NR"
            if (properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0) flags += "NOTIFY"
            if (properties and BluetoothGattCharacteristic.PROPERTY_INDICATE != 0) flags += "INDICATE"
            return flags.joinToString(",")
        }
    }
}
