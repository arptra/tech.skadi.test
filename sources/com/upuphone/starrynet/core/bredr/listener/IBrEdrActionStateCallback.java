package com.upuphone.starrynet.core.bredr.listener;

import android.bluetooth.BluetoothDevice;

public interface IBrEdrActionStateCallback {
    void onActiveDeviceChanged(BluetoothDevice bluetoothDevice, int i);

    void onCallStateChanged(String str, int i);

    void onPullPhoneBookChanged(int i);
}
