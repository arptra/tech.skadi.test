package com.honey.account.p6;

import android.os.Bundle;
import com.upuphone.runasone.uupcast.api.IccoaConnectListenerAdapter;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IccoaConnectListenerAdapter f5103a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ q(IccoaConnectListenerAdapter iccoaConnectListenerAdapter, int i, Bundle bundle) {
        this.f5103a = iccoaConnectListenerAdapter;
        this.b = i;
        this.c = bundle;
    }

    public final void run() {
        this.f5103a.lambda$adapt$0(this.b, this.c);
    }
}
