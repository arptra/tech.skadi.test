package com.upuphone.starrynet.core.ble.server;

import android.bluetooth.BluetoothDevice;
import java.util.UUID;

public interface IGattServerReceiveListener {
    void onMtuChanged(BluetoothDevice bluetoothDevice, int i);

    void onReceive(BluetoothDevice bluetoothDevice, boolean z, UUID uuid, byte[] bArr);
}
