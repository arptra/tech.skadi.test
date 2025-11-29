package com.upuphone.starrynetsdk.ability.relay;

import com.upuphone.starrynetsdk.ability.relay.RelayListenerManager;
import java.util.Set;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6546a;
    public final /* synthetic */ Set b;

    public /* synthetic */ b(String str, Set set) {
        this.f6546a = str;
        this.b = set;
    }

    public final void accept(Object obj) {
        RelayListenerManager.Callback.lambda$getRelayList$1(this.f6546a, this.b, (ListenerBean) obj);
    }
}
