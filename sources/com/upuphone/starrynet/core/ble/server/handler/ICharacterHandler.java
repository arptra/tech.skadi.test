package com.upuphone.starrynet.core.ble.server.handler;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import java.util.UUID;

public interface ICharacterHandler {
    void onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i);

    void onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID uuid, int i, byte[] bArr);
}
