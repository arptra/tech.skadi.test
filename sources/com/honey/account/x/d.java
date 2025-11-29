package com.honey.account.x;

import androidx.lifecycle.ProcessLifecycleOwner;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessLifecycleOwner f3137a;

    public /* synthetic */ d(ProcessLifecycleOwner processLifecycleOwner) {
        this.f3137a = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.h(this.f3137a);
    }
}
