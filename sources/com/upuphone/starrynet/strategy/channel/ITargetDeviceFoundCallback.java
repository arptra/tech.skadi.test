package com.upuphone.starrynet.strategy.channel;

import android.bluetooth.BluetoothDevice;

public interface ITargetDeviceFoundCallback {
    void onTargetDeviceFound(BluetoothDevice bluetoothDevice, String str);
}
