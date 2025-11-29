package com.honey.account.kb;

import io.reactivex.rxjava3.disposables.Disposable;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Disposable f3676a;

    public /* synthetic */ a(Disposable disposable) {
        this.f3676a = disposable;
    }

    public final void run() {
        this.f3676a.dispose();
    }
}
