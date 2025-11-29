package com.honey.account.ob;

import io.reactivex.rxjava3.disposables.Disposable;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.rx3.SchedulerCoroutineDispatcher;

public final /* synthetic */ class c implements DisposableHandle {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Disposable f3683a;

    public /* synthetic */ c(Disposable disposable) {
        this.f3683a = disposable;
    }

    public final void dispose() {
        SchedulerCoroutineDispatcher.p0(this.f3683a);
    }
}
