package com.honey.account.dc;

import java.util.concurrent.Callable;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableCallable;

public final /* synthetic */ class j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableCallable f7250a;

    public /* synthetic */ j(FailableCallable failableCallable) {
        this.f7250a = failableCallable;
    }

    public final Object call() {
        return Failable.call(this.f7250a);
    }
}
