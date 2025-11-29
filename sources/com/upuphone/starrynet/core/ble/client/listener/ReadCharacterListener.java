package com.upuphone.starrynet.core.ble.client.listener;

import android.bluetooth.BluetoothGattCharacteristic;

public interface ReadCharacterListener extends GattResponseListener {
    void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr);
}
