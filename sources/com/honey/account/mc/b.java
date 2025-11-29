package com.honey.account.mc;

import java.util.concurrent.Callable;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.tika.pipes.PipesClient;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PipesClient f3221a;
    public final /* synthetic */ UnsynchronizedByteArrayOutputStream b;

    public /* synthetic */ b(PipesClient pipesClient, UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream) {
        this.f3221a = pipesClient;
        this.b = unsynchronizedByteArrayOutputStream;
    }

    public final Object call() {
        return this.f3221a.o(this.b);
    }
}
