package com.honey.account.h6;

import com.upuphone.runasone.relay.lib.device.RelayDeviceManager;
import java.util.List;
import java.util.function.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayDeviceManager f4530a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ c(RelayDeviceManager relayDeviceManager, String str, List list) {
        this.f4530a = relayDeviceManager;
        this.b = str;
        this.c = list;
    }

    public final void accept(Object obj) {
        this.f4530a.lambda$getRelayListener$0(this.b, this.c, (String) obj);
    }
}
