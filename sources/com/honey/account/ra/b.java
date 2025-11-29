package com.honey.account.ra;

import dev.fluttercommunity.plus.connectivity.ConnectivityBroadcastReceiver;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectivityBroadcastReceiver f7607a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(ConnectivityBroadcastReceiver connectivityBroadcastReceiver, String str) {
        this.f7607a = connectivityBroadcastReceiver;
        this.b = str;
    }

    public final void run() {
        this.f7607a.f(this.b);
    }
}
