package com.honey.account.xb;

import java.util.function.BiConsumer;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class j implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableBiConsumer f7698a;

    public /* synthetic */ j(Functions.FailableBiConsumer failableBiConsumer) {
        this.f7698a = failableBiConsumer;
    }

    public final void accept(Object obj, Object obj2) {
        Functions.accept(this.f7698a, obj, obj2);
    }
}
