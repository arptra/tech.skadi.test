package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.DeviceCallback;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleAbility f4994a;
    public final /* synthetic */ String b;
    public final /* synthetic */ DeviceCallback c;

    public /* synthetic */ c(BleAbility bleAbility, String str, DeviceCallback deviceCallback) {
        this.f4994a = bleAbility;
        this.b = str;
        this.c = deviceCallback;
    }

    public final void run() {
        this.f4994a.lambda$registerDeviceCallback$0(this.b, this.c);
    }
}
