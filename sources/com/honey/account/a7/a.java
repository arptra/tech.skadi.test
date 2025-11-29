package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4160a;
    public final /* synthetic */ BluetoothGatt b;

    public /* synthetic */ a(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt) {
        this.f4160a = bleClientGattCallback;
        this.b = bluetoothGatt;
    }

    public final void run() {
        this.f4160a.lambda$onServiceChanged$7(this.b);
    }
}
