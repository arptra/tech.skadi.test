package com.honey.account.xb;

import org.apache.commons.lang3.Functions;

public final /* synthetic */ class p implements Functions.FailableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableConsumer f7705a;
    public final /* synthetic */ Object b;

    public /* synthetic */ p(Functions.FailableConsumer failableConsumer, Object obj) {
        this.f7705a = failableConsumer;
        this.b = obj;
    }

    public final void run() {
        this.f7705a.accept(this.b);
    }
}
