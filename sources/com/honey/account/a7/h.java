package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4167a;
    public final /* synthetic */ BluetoothGatt b;
    public final /* synthetic */ BluetoothGattCharacteristic c;
    public final /* synthetic */ byte[] d;

    public /* synthetic */ h(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.f4167a = bleClientGattCallback;
        this.b = bluetoothGatt;
        this.c = bluetoothGattCharacteristic;
        this.d = bArr;
    }

    public final void run() {
        this.f4167a.lambda$onCharacteristicChanged$5(this.b, this.c, this.d);
    }
}
