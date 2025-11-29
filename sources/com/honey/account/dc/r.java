package com.honey.account.dc;

import java.util.function.Consumer;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableConsumer f7267a;

    public /* synthetic */ r(FailableConsumer failableConsumer) {
        this.f7267a = failableConsumer;
    }

    public final void accept(Object obj) {
        Failable.accept(this.f7267a, obj);
    }
}
