package com.honey.account.ub;

import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.function.IOFunction;

public final /* synthetic */ class e implements IOConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7630a;
    public final /* synthetic */ IOConsumer b;

    public /* synthetic */ e(IOFunction iOFunction, IOConsumer iOConsumer) {
        this.f7630a = iOFunction;
        this.b = iOConsumer;
    }

    public final void accept(Object obj) {
        this.f7630a.lambda$andThen$6(this.b, obj);
    }
}
