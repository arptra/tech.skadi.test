package dev.fluttercommunity.plus.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;
import com.honey.account.ra.a;
import com.honey.account.ra.b;
import io.flutter.plugin.common.EventChannel;

public class ConnectivityBroadcastReceiver extends BroadcastReceiver implements EventChannel.StreamHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8788a;
    public final Connectivity b;
    public EventChannel.EventSink c;
    public final Handler d = new Handler(Looper.getMainLooper());
    public ConnectivityManager.NetworkCallback e;

    public ConnectivityBroadcastReceiver(Context context, Connectivity connectivity) {
        this.f8788a = context;
        this.b = connectivity;
    }

    public final /* synthetic */ void e() {
        this.c.success(this.b.b());
    }

    public final /* synthetic */ void f(String str) {
        this.c.success(str);
    }

    public final void g() {
        this.d.post(new a(this));
    }

    public final void h(String str) {
        this.d.post(new b(this, str));
    }

    public void onCancel(Object obj) {
        if (this.e != null) {
            this.b.a().unregisterNetworkCallback(this.e);
            this.e = null;
        }
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.c = eventSink;
        this.e = new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                ConnectivityBroadcastReceiver.this.g();
            }

            public void onLost(Network network) {
                ConnectivityBroadcastReceiver.this.h("none");
            }
        };
        this.b.a().registerDefaultNetworkCallback(this.e);
    }

    public void onReceive(Context context, Intent intent) {
        EventChannel.EventSink eventSink = this.c;
        if (eventSink != null) {
            eventSink.success(this.b.b());
        }
    }
}
