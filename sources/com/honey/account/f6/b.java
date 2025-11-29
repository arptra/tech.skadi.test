package com.honey.account.f6;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.lib.RelayPort;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4414a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(int i, String str) {
        this.f4414a = i;
        this.b = str;
    }

    public final void accept(Object obj) {
        RelayPort.lambda$appStateChanged$1(this.f4414a, this.b, (StarryDevice) obj);
    }
}
