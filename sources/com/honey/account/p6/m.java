package com.honey.account.p6;

import android.os.Bundle;
import com.upuphone.runasone.uupcast.api.ISinkListenerAdapter;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ISinkListenerAdapter f5099a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ m(ISinkListenerAdapter iSinkListenerAdapter, int i, Bundle bundle) {
        this.f5099a = iSinkListenerAdapter;
        this.b = i;
        this.c = bundle;
    }

    public final void run() {
        this.f5099a.lambda$adapt$4(this.b, this.c);
    }
}
