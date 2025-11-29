package com.honey.account.h6;

import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.lib.device.RelayDeviceManager;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelayDeviceManager f4529a;
    public final /* synthetic */ StarryTag b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(RelayDeviceManager relayDeviceManager, StarryTag starryTag, int i) {
        this.f4529a = relayDeviceManager;
        this.b = starryTag;
        this.c = i;
    }

    public final void accept(Object obj) {
        this.f4529a.lambda$callRelayCallbackOnRemove$1(this.b, this.c, (RelayCallback) obj);
    }
}
