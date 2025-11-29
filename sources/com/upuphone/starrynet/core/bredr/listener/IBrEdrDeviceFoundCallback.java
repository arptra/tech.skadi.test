package com.upuphone.starrynet.core.bredr.listener;

import android.bluetooth.BluetoothDevice;

public interface IBrEdrDeviceFoundCallback {
    void onDeviceFound(BluetoothDevice bluetoothDevice, String str);
}
