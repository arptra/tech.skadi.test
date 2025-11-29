package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4164a;
    public final /* synthetic */ BluetoothGatt b;
    public final /* synthetic */ BluetoothGattCharacteristic c;
    public final /* synthetic */ int d;

    public /* synthetic */ e(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f4164a = bleClientGattCallback;
        this.b = bluetoothGatt;
        this.c = bluetoothGattCharacteristic;
        this.d = i;
    }

    public final void run() {
        this.f4164a.lambda$onCharacteristicWrite$2(this.b, this.c, this.d);
    }
}
