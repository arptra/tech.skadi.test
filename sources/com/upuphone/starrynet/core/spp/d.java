package com.upuphone.starrynet.core.spp;

import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import java.util.function.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6535a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(String str, int i) {
        this.f6535a = str;
        this.b = i;
    }

    public final void accept(Object obj) {
        ((IConnectionEventListener) obj).onConnectionStateChanged(this.f6535a, this.b);
    }
}
