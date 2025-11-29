package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

public final /* synthetic */ class t implements FailableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiConsumer f7271a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t(FailableBiConsumer failableBiConsumer, Object obj, Object obj2) {
        this.f7271a = failableBiConsumer;
        this.b = obj;
        this.c = obj2;
    }

    public final void run() {
        this.f7271a.accept(this.b, this.c);
    }
}
