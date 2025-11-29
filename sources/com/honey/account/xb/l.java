package com.honey.account.xb;

import java.util.concurrent.Callable;
import org.apache.commons.lang3.Functions;

public final /* synthetic */ class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Functions.FailableCallable f7701a;

    public /* synthetic */ l(Functions.FailableCallable failableCallable) {
        this.f7701a = failableCallable;
    }

    public final Object call() {
        return Functions.call(this.f7701a);
    }
}
