package com.honey.account.p6;

import android.os.Bundle;
import com.upuphone.runasone.uupcast.api.IVirtualDeviceEventListenerAdapter;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IVirtualDeviceEventListenerAdapter f5101a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ o(IVirtualDeviceEventListenerAdapter iVirtualDeviceEventListenerAdapter, int i, Bundle bundle) {
        this.f5101a = iVirtualDeviceEventListenerAdapter;
        this.b = i;
        this.c = bundle;
    }

    public final void run() {
        this.f5101a.lambda$adapt$0(this.b, this.c);
    }
}
