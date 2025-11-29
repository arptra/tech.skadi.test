package com.honey.account.wb;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.output.ProxyOutputStream;

public final /* synthetic */ class b implements IOConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProxyOutputStream f7654a;

    public /* synthetic */ b(ProxyOutputStream proxyOutputStream) {
        this.f7654a = proxyOutputStream;
    }

    public final void accept(Object obj) {
        this.f7654a.handleIOException((IOException) obj);
    }
}
