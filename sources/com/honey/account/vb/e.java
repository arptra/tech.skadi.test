package com.honey.account.vb;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.input.ProxyInputStream;

public final /* synthetic */ class e implements IOConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProxyInputStream f7640a;

    public /* synthetic */ e(ProxyInputStream proxyInputStream) {
        this.f7640a = proxyInputStream;
    }

    public final void accept(Object obj) {
        this.f7640a.handleIOException((IOException) obj);
    }
}
