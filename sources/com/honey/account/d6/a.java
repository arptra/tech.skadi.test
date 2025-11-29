package com.honey.account.d6;

import com.upuphone.runasone.lifecycle.manager.LifecycleManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleManager f4333a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(LifecycleManager lifecycleManager, String str) {
        this.f4333a = lifecycleManager;
        this.b = str;
    }

    public final void run() {
        this.f4333a.lambda$onAppUnregistered$1(this.b);
    }
}
