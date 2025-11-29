package com.honey.account.xb;

import org.apache.commons.lang3.function.FailableBiConsumer;

public final /* synthetic */ class v implements FailableBiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f7710a;

    public /* synthetic */ v(Object obj) {
        this.f7710a = obj;
    }

    public final void accept(Object obj, Object obj2) {
        this.f7710a.wait(((Long) obj).longValue(), ((Integer) obj2).intValue());
    }
}
