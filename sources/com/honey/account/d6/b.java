package com.honey.account.d6;

import com.upuphone.runasone.lifecycle.manager.LifecycleManager;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleManager f4334a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(LifecycleManager lifecycleManager, String str) {
        this.f4334a = lifecycleManager;
        this.b = str;
    }

    public final void run() {
        this.f4334a.lambda$onAppRegistered$0(this.b);
    }
}
