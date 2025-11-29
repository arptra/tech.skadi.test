package com.honey.account.lb;

import io.reactivex.rxjava3.disposables.Disposable;

public final /* synthetic */ class a implements AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Disposable f3677a;

    public /* synthetic */ a(Disposable disposable) {
        this.f3677a = disposable;
    }

    public final void close() {
        this.f3677a.dispose();
    }
}
