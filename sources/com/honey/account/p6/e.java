package com.honey.account.p6;

import android.os.Bundle;
import com.upuphone.runasone.uupcast.api.IDisplayListenerAdapter;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IDisplayListenerAdapter f5091a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ e(IDisplayListenerAdapter iDisplayListenerAdapter, int i, Bundle bundle) {
        this.f5091a = iDisplayListenerAdapter;
        this.b = i;
        this.c = bundle;
    }

    public final void run() {
        this.f5091a.lambda$adapt$4(this.b, this.c);
    }
}
