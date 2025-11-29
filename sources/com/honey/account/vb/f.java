package com.honey.account.vb;

import org.apache.commons.io.input.ReadAheadInputStream;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReadAheadInputStream f7641a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ f(ReadAheadInputStream readAheadInputStream, byte[] bArr) {
        this.f7641a = readAheadInputStream;
        this.b = bArr;
    }

    public final void run() {
        this.f7641a.lambda$readAsync$1(this.b);
    }
}
