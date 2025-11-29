package com.honey.account.a7;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import com.upuphone.starrynet.strategy.channel.iccoa.BleClientGattCallback;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientGattCallback f4161a;
    public final /* synthetic */ BluetoothGatt b;
    public final /* synthetic */ BluetoothGattDescriptor c;
    public final /* synthetic */ int d;

    public /* synthetic */ b(BleClientGattCallback bleClientGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.f4161a = bleClientGattCallback;
        this.b = bluetoothGatt;
        this.c = bluetoothGattDescriptor;
        this.d = i;
    }

    public final void run() {
        this.f4161a.lambda$onDescriptorWrite$3(this.b, this.c, this.d);
    }
}
