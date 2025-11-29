package com.honey.account.p0;

import androidx.work.impl.utils.IdGenerator;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f3073a;

    public /* synthetic */ e(IdGenerator idGenerator) {
        this.f3073a = idGenerator;
    }

    public final Object call() {
        return IdGenerator.d(this.f3073a);
    }
}
