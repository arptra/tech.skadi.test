package com.upuphone.starrynet.core.spp;

import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import java.util.function.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6534a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ c(String str, byte[] bArr) {
        this.f6534a = str;
        this.b = bArr;
    }

    public final void accept(Object obj) {
        ((IConnectionEventListener) obj).onMessageReceived(this.f6534a, this.b);
    }
}
