package com.honey.account.mc;

import java.util.concurrent.Callable;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.PipesClient;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PipesClient f3220a;
    public final /* synthetic */ FetchEmitTuple b;
    public final /* synthetic */ long c;

    public /* synthetic */ a(PipesClient pipesClient, FetchEmitTuple fetchEmitTuple, long j) {
        this.f3220a = pipesClient;
        this.b = fetchEmitTuple;
        this.c = j;
    }

    public final Object call() {
        return this.f3220a.n(this.b, this.c);
    }
}
