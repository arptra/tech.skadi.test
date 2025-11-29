package com.honey.account.o5;

import android.bluetooth.BluetoothGatt;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f5017a;

    public /* synthetic */ x(BluetoothGatt bluetoothGatt) {
        this.f5017a = bluetoothGatt;
    }

    public final void run() {
        this.f5017a.discoverServices();
    }
}
