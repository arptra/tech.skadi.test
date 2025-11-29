package com.honey.account.xb;

import org.apache.commons.lang3.function.FailableBiConsumer;

public final /* synthetic */ class d0 implements FailableBiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Thread f7687a;

    public /* synthetic */ d0(Thread thread) {
        this.f7687a = thread;
    }

    public final void accept(Object obj, Object obj2) {
        this.f7687a.join(((Long) obj).longValue(), ((Integer) obj2).intValue());
    }
}
