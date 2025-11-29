package com.upuphone.starrynet.core.ble.client;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

public interface IBluetoothGattResponse {
    void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr);

    void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr);

    void onConnectionStateChange(int i, int i2);

    void onConnectionUpdate(int i, int i2);

    void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i);

    void onMtuChanged(int i, int i2);

    void onPhyRead(int i, int i2, int i3);

    void onPhyUpdate(int i, int i2, int i3);

    void onServiceChanged(BluetoothGatt bluetoothGatt);

    void onServicesDiscovered(int i);
}
