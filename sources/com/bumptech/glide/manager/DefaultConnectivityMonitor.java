package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.ConnectivityMonitor;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2674a;
    public final ConnectivityMonitor.ConnectivityListener b;

    public DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f2674a = context.getApplicationContext();
        this.b = connectivityListener;
    }

    public final void b() {
        SingletonConnectivityReceiver.a(this.f2674a).d(this.b);
    }

    public final void f() {
        SingletonConnectivityReceiver.a(this.f2674a).e(this.b);
    }

    public void onDestroy() {
    }

    public void onStart() {
        b();
    }

    public void onStop() {
        f();
    }
}
