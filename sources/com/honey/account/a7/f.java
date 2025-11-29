package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4165a;
    public final /* synthetic */ BluetoothGatt b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ f(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f4165a = bleClientGattCallback;
        this.b = bluetoothGatt;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f4165a.lambda$onMtuChanged$6(this.b, this.c, this.d);
    }
}
