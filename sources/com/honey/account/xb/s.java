package com.honey.account.xb;

import org.apache.commons.lang3.Functions;

public final /* synthetic */ class s implements Functions.FailableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableBiConsumer f7707a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ s(Functions.FailableBiConsumer failableBiConsumer, Object obj, Object obj2) {
        this.f7707a = failableBiConsumer;
        this.b = obj;
        this.c = obj2;
    }

    public final void run() {
        this.f7707a.accept(this.b, this.c);
    }
}
