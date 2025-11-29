package com.honey.account.h6;

import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.lib.device.RelayDeviceManager;
import java.util.function.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayDeviceManager f4528a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(RelayDeviceManager relayDeviceManager, String str) {
        this.f4528a = relayDeviceManager;
        this.b = str;
    }

    public final void accept(Object obj) {
        this.f4528a.lambda$onDeviceListChanged$2(this.b, (RelayCallback) obj);
    }
}
