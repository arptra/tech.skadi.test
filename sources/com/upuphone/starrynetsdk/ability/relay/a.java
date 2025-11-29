package com.upuphone.starrynetsdk.ability.relay;

import com.upuphone.starrynetsdk.ability.relay.RelayListenerManager;
import java.util.List;
import java.util.function.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f6545a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(List list, String str) {
        this.f6545a = list;
        this.b = str;
    }

    public final void accept(Object obj) {
        RelayListenerManager.Callback.lambda$onDeviceListChanged$0(this.f6545a, this.b, (ListenerBean) obj);
    }
}
