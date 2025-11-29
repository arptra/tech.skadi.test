package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4162a;
    public final /* synthetic */ BluetoothGatt b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ c(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f4162a = bleClientGattCallback;
        this.b = bluetoothGatt;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f4162a.lambda$onConnectionStateChange$0(this.b, this.c, this.d);
    }
}
