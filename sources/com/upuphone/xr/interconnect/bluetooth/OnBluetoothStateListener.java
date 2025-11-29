package com.upuphone.xr.interconnect.bluetooth;

import android.bluetooth.BluetoothDevice;

public class OnBluetoothStateListener {
    public void onBondStateChanged(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public void onNameChanged(String str) {
    }

    public boolean onReceivePairRequest(BluetoothDevice bluetoothDevice, int i, int i2) {
        return false;
    }

    public void onStateChanged(boolean z) {
    }
}
