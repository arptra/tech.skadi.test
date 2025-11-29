package com.honey.account.l0;

import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f3068a;

    public /* synthetic */ b(DelayMetCommandHandler delayMetCommandHandler) {
        this.f3068a = delayMetCommandHandler;
    }

    public final void run() {
        this.f3068a.h();
    }
}
