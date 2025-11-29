package com.honey.account.ha;

import com.xjsd.ai.assistant.phone.Commander;
import com.xjsd.ai.assistant.phone.NetworkMonitor;

public final /* synthetic */ class e implements NetworkMonitor.OnNetworkStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Commander f7335a;

    public /* synthetic */ e(Commander commander) {
        this.f7335a = commander;
    }

    public final void onStateChanged(boolean z) {
        this.f7335a.lambda$onComponentInitOver$2(z);
    }
}
