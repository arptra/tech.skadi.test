package com.upuphone.starrynet.core.bredr.listener;

import android.bluetooth.BluetoothDevice;

public interface IBrEdrConnectStateCallback {
    void onBrEdrBondStateChanged(BluetoothDevice bluetoothDevice, int i, int i2);

    void onBrEdrProfileConnectStateChanged(BluetoothDevice bluetoothDevice, int i, int i2);

    void onBrEdrServiceReady();
}
