package com.honey.account.wb;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.output.ProxyWriter;

public final /* synthetic */ class c implements IOConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProxyWriter f7655a;

    public /* synthetic */ c(ProxyWriter proxyWriter) {
        this.f7655a = proxyWriter;
    }

    public final void accept(Object obj) {
        this.f7655a.handleIOException((IOException) obj);
    }
}
