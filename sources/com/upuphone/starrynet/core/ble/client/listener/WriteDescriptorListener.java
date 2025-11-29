package com.upuphone.starrynet.core.ble.client.listener;

import android.bluetooth.BluetoothGattDescriptor;

public interface WriteDescriptorListener extends GattResponseListener {
    void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i);
}
