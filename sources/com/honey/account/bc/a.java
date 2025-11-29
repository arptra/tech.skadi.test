package com.honey.account.bc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.function.Supplier;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReadWriteLock f7154a;

    public /* synthetic */ a(ReadWriteLock readWriteLock) {
        this.f7154a = readWriteLock;
    }

    public final Object get() {
        return this.f7154a.readLock();
    }
}
