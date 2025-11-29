package com.honey.account.g6;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.lib.air.AirPort;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4465a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(int i, String str) {
        this.f4465a = i;
        this.b = str;
    }

    public final void accept(Object obj) {
        AirPort.m1677appStateChanged$lambda1(this.f4465a, this.b, (StarryDevice) obj);
    }
}
