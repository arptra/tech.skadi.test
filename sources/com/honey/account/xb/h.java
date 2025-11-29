package com.honey.account.xb;

import java.util.function.Consumer;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableConsumer f7694a;

    public /* synthetic */ h(Functions.FailableConsumer failableConsumer) {
        this.f7694a = failableConsumer;
    }

    public final void accept(Object obj) {
        Functions.accept(this.f7694a, obj);
    }
}
