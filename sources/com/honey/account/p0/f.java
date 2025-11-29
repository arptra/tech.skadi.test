package com.honey.account.p0;

import androidx.work.impl.utils.IdGenerator;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f3074a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ f(IdGenerator idGenerator, int i, int i2) {
        this.f3074a = idGenerator;
        this.b = i;
        this.c = i2;
    }

    public final Object call() {
        return IdGenerator.f(this.f3074a, this.b, this.c);
    }
}
