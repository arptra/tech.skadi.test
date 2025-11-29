package com.honey.account.ac;

import java.util.concurrent.Callable;
import org.apache.commons.lang3.concurrent.Memoizer;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Memoizer f7119a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Memoizer memoizer, Object obj) {
        this.f7119a = memoizer;
        this.b = obj;
    }

    public final Object call() {
        return this.f7119a.lambda$compute$0(this.b);
    }
}
