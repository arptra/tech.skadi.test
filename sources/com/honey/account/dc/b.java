package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableLongConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

public final /* synthetic */ class b implements FailableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableLongConsumer f7234a;
    public final /* synthetic */ long b;

    public /* synthetic */ b(FailableLongConsumer failableLongConsumer, long j) {
        this.f7234a = failableLongConsumer;
        this.b = j;
    }

    public final void run() {
        this.f7234a.accept(this.b);
    }
}
