package com.upuphone.starrynet.core.ble.server;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;

public class BluetoothGattServerResponse extends BluetoothGattServerCallback {
    private IBleGattServerResponse mResponse;

    public BluetoothGattServerResponse(IBleGattServerResponse iBleGattServerResponse) {
        this.mResponse = iBleGattServerResponse;
    }

    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicReadRequest(bluetoothDevice, i, i2, bluetoothGattCharacteristic);
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onCharacteristicReadRequest(bluetoothDevice, i, i2, bluetoothGattCharacteristic);
        }
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        super.onCharacteristicWriteRequest(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr);
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onCharacteristicWriteRequest(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr);
        }
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
        super.onConnectionStateChange(bluetoothDevice, i, i2);
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onConnectionStateChange(bluetoothDevice, i, i2);
        }
    }

    public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
        super.onDescriptorWriteRequest(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr);
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onDescriptorWriteRequest(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr);
        }
    }

    public void onMtuChanged(BluetoothDevice bluetoothDevice, int i) {
        super.onMtuChanged(bluetoothDevice, i);
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onMtuChanged(bluetoothDevice, i);
        }
    }

    public void onNotificationSent(BluetoothDevice bluetoothDevice, int i) {
        super.onNotificationSent(bluetoothDevice, i);
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onNotificationSent(bluetoothDevice, i);
        }
    }

    public void onPhyRead(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onReadPhy(bluetoothDevice, i, i2, i3);
        }
    }

    public void onPhyUpdate(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onPhyUpdate(bluetoothDevice, i, i2, i3);
        }
    }

    public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
        super.onServiceAdded(i, bluetoothGattService);
        IBleGattServerResponse iBleGattServerResponse = this.mResponse;
        if (iBleGattServerResponse != null) {
            iBleGattServerResponse.onServiceAdded(i, bluetoothGattService);
        }
    }
}
