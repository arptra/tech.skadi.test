package com.upuphone.starrynet.core.ble.client;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.Keep;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;

@Keep
public class BluetoothGattResponse extends BluetoothGattCallback {
    private IBluetoothGattResponse response;

    public BluetoothGattResponse(IBluetoothGattResponse iBluetoothGattResponse) {
        this.response = iBluetoothGattResponse;
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.response.onCharacteristicChanged(bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.response.onCharacteristicRead(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.response.onCharacteristicWrite(bluetoothGattCharacteristic, i, bluetoothGattCharacteristic.getValue());
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.response.onConnectionStateChange(i, i2);
    }

    public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
        BluetoothLog.v("BluetoothResponse", "onConnectionUpdated interval=%d, latency=%d, timeout=%d,status=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.response.onConnectionUpdate(i2, i);
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.response.onDescriptorWrite(bluetoothGattDescriptor, i);
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.response.onMtuChanged(i, i2);
    }

    public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        BluetoothLog.log("BluetoothResponse", "onPhyRead, txPhy=%d, rxPhy=%d,status=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.response.onPhyRead(i, i2, i3);
    }

    public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        BluetoothLog.log("BluetoothResponse", "onPhyUpdate txPhy=%d,rxPhy=%d,status=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.response.onPhyUpdate(i, i2, i3);
    }

    public void onServiceChanged(BluetoothGatt bluetoothGatt) {
        BluetoothLog.log("BluetoothResponse", "onServiceChanged", new Object[0]);
        this.response.onServiceChanged(bluetoothGatt);
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        this.response.onServicesDiscovered(i);
    }
}
