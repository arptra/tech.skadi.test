package com.honey.account.o5;

import com.upuphone.runasone.ble.BleAbility;
import com.upuphone.runasone.ble.BleInternalDevice;
import com.upuphone.runasone.ble.SessionCallback;

public final /* synthetic */ class k implements SessionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionCallback f5004a;
    public final /* synthetic */ BleInternalDevice b;

    public /* synthetic */ k(SessionCallback sessionCallback, BleInternalDevice bleInternalDevice) {
        this.f5004a = sessionCallback;
        this.b = bleInternalDevice;
    }

    public final void onNotify(String str, byte[] bArr) {
        BleAbility.lambda$registerSessionCallback$2(this.f5004a, this.b, str, bArr);
    }
}
