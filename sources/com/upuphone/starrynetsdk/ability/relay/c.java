package com.upuphone.starrynetsdk.ability.relay;

import com.upuphone.starrynetsdk.ability.relay.RelayListenerManager;
import java.util.Set;
import java.util.function.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6547a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Set c;

    public /* synthetic */ c(int i, String str, Set set) {
        this.f6547a = i;
        this.b = str;
        this.c = set;
    }

    public final void accept(Object obj) {
        RelayListenerManager.Callback.lambda$getRelayList$2(this.f6547a, this.b, this.c, (ListenerBean) obj);
    }
}
