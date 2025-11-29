package com.honey.account.o5;

import android.bluetooth.BluetoothGatt;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f5006a;

    public /* synthetic */ m(BluetoothGatt bluetoothGatt) {
        this.f5006a = bluetoothGatt;
    }

    public final void run() {
        this.f5006a.discoverServices();
    }
}
