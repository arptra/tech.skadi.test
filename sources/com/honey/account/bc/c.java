package com.honey.account.bc;

import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StampedLock f7156a;

    public /* synthetic */ c(StampedLock stampedLock) {
        this.f7156a = stampedLock;
    }

    public final Object get() {
        return this.f7156a.asReadLock();
    }
}
