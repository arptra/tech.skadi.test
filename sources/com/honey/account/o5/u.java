package com.honey.account.o5;

import android.bluetooth.BluetoothGattDescriptor;
import com.upuphone.runasone.ble.GattCallback;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GattCallback f5014a;
    public final /* synthetic */ BluetoothGattDescriptor b;
    public final /* synthetic */ int c;

    public /* synthetic */ u(GattCallback gattCallback, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.f5014a = gattCallback;
        this.b = bluetoothGattDescriptor;
        this.c = i;
    }

    public final void run() {
        this.f5014a.lambda$onDescriptorWrite$4(this.b, this.c);
    }
}
