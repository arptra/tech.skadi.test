package com.honey.account.ub;

import org.apache.commons.io.function.IOConsumer;

public final /* synthetic */ class a implements IOConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOConsumer f7627a;
    public final /* synthetic */ IOConsumer b;

    public /* synthetic */ a(IOConsumer iOConsumer, IOConsumer iOConsumer2) {
        this.f7627a = iOConsumer;
        this.b = iOConsumer2;
    }

    public final void accept(Object obj) {
        this.f7627a.lambda$andThen$1(this.b, obj);
    }
}
