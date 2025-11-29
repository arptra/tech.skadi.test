package com.honey.account.p6;

import com.upuphone.runasone.uupcast.SourceDisplayConfig;
import com.upuphone.runasone.uupcast.api.ISinkListenerAdapter;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ISinkListenerAdapter f5100a;
    public final /* synthetic */ SourceDisplayConfig b;

    public /* synthetic */ n(ISinkListenerAdapter iSinkListenerAdapter, SourceDisplayConfig sourceDisplayConfig) {
        this.f5100a = iSinkListenerAdapter;
        this.b = sourceDisplayConfig;
    }

    public final void run() {
        this.f5100a.lambda$adapt$5(this.b);
    }
}
