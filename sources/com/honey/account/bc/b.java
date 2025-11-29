package com.honey.account.bc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.function.Supplier;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReadWriteLock f7155a;

    public /* synthetic */ b(ReadWriteLock readWriteLock) {
        this.f7155a = readWriteLock;
    }

    public final Object get() {
        return this.f7155a.writeLock();
    }
}
