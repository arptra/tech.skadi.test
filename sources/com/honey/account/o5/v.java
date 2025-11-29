package com.honey.account.o5;

import android.bluetooth.BluetoothGattCharacteristic;
import com.upuphone.runasone.ble.GattCallback;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GattCallback f5015a;
    public final /* synthetic */ BluetoothGattCharacteristic b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ v(GattCallback gattCallback, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.f5015a = gattCallback;
        this.b = bluetoothGattCharacteristic;
        this.c = bArr;
    }

    public final void run() {
        this.f5015a.lambda$onCharacteristicChanged$3(this.b, this.c);
    }
}
