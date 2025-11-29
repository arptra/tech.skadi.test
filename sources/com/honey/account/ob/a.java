package com.honey.account.ob;

import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.rx3.RxSchedulerKt;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f3681a;

    public /* synthetic */ a(Ref.ObjectRef objectRef) {
        this.f3681a = objectRef;
    }

    public final void run() {
        RxSchedulerKt.f(this.f3681a);
    }
}
