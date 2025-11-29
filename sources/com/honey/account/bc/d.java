package com.honey.account.bc;

import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StampedLock f7157a;

    public /* synthetic */ d(StampedLock stampedLock) {
        this.f7157a = stampedLock;
    }

    public final Object get() {
        return this.f7157a.asWriteLock();
    }
}
