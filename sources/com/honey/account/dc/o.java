package com.honey.account.dc;

import java.util.function.BiConsumer;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiConsumer;

public final /* synthetic */ class o implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableBiConsumer f7261a;

    public /* synthetic */ o(FailableBiConsumer failableBiConsumer) {
        this.f7261a = failableBiConsumer;
    }

    public final void accept(Object obj, Object obj2) {
        Failable.accept(this.f7261a, obj, obj2);
    }
}
