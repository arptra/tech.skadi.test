package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4166a;
    public final /* synthetic */ BluetoothGatt b;
    public final /* synthetic */ BluetoothGattCharacteristic c;

    public /* synthetic */ g(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f4166a = bleClientGattCallback;
        this.b = bluetoothGatt;
        this.c = bluetoothGattCharacteristic;
    }

    public final void run() {
        this.f4166a.lambda$onCharacteristicChanged$4(this.b, this.c);
    }
}
