package com.honey.account.hb;

import io.flutter.plugins.webviewflutter.InstanceManager;

public final /* synthetic */ class x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstanceManager f7438a;

    public /* synthetic */ x2(InstanceManager instanceManager) {
        this.f7438a = instanceManager;
    }

    public final void run() {
        this.f7438a.releaseAllFinalizedInstances();
    }
}
