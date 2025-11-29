package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4163a;
    public final /* synthetic */ BluetoothGatt b;
    public final /* synthetic */ int c;

    public /* synthetic */ d(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt, int i) {
        this.f4163a = bleClientGattCallback;
        this.b = bluetoothGatt;
        this.c = i;
    }

    public final void run() {
        this.f4163a.lambda$onServicesDiscovered$1(this.b, this.c);
    }
}
