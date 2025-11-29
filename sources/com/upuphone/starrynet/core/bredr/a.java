package com.upuphone.starrynet.core.bredr;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import com.upuphone.starrynet.core.bredr.BrEdrEventManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BrEdrEventManager.BluetoothBroadcastReceiver f6531a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ Intent d;
    public final /* synthetic */ BluetoothDevice e;

    public /* synthetic */ a(BrEdrEventManager.BluetoothBroadcastReceiver bluetoothBroadcastReceiver, String str, Context context, Intent intent, BluetoothDevice bluetoothDevice) {
        this.f6531a = bluetoothBroadcastReceiver;
        this.b = str;
        this.c = context;
        this.d = intent;
        this.e = bluetoothDevice;
    }

    public final void run() {
        this.f6531a.lambda$onReceive$0(this.b, this.c, this.d, this.e);
    }
}
