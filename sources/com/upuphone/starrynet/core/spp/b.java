package com.upuphone.starrynet.core.spp;

import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6533a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(String str, byte[] bArr, int i) {
        this.f6533a = str;
        this.b = bArr;
        this.c = i;
    }

    public final void accept(Object obj) {
        ((IConnectionEventListener) obj).onMessageDispatched(this.f6533a, this.b, this.c);
    }
}
