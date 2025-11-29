package com.xjsd.ai.assistant.phone;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import com.xjsd.ai.assistant.log.ILog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NetworkMonitor extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8520a;
    public final ConnectivityManager b;
    public List c = new DeDuplicateCopyOnWriteArrayList();
    public Set d = new HashSet();

    public interface OnNetworkStateChangeListener {
        void onStateChanged(boolean z);
    }

    public NetworkMonitor(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f8520a = applicationContext;
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        this.b = connectivityManager;
        a();
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build(), this);
    }

    public void a() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
            if (networkCapabilities.hasTransport(1)) {
                ILog.j("NetworkMonitor", "wifi网络已连接");
            } else {
                ILog.j("NetworkMonitor", "wifi网络不可用");
            }
            if (networkCapabilities.hasTransport(0)) {
                ILog.j("NetworkMonitor", "移动网络已连接");
            } else {
                ILog.j("NetworkMonitor", "移动网络不可用");
            }
        }
    }

    public final void b() {
        for (OnNetworkStateChangeListener onStateChanged : this.c) {
            onStateChanged.onStateChanged(this.d.size() > 0);
        }
    }

    public void c(OnNetworkStateChangeListener onNetworkStateChangeListener) {
        this.c.add(onNetworkStateChangeListener);
        onNetworkStateChangeListener.onStateChanged(this.d.size() > 0);
    }

    public void onAvailable(Network network) {
        ILog.j("NetworkMonitor", "网络连接了->" + network);
        this.d.add(network.toString());
        b();
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        ILog.j("NetworkMonitor", "onCapabilitiesChanged->" + networkCapabilities.toString());
        if (networkCapabilities.hasCapability(16)) {
            if (networkCapabilities.hasTransport(1)) {
                ILog.j("NetworkMonitor", "wifi网络已连接");
            } else {
                ILog.j("NetworkMonitor", "wifi网络不可用");
            }
            if (networkCapabilities.hasTransport(0)) {
                ILog.j("NetworkMonitor", "移动网络已连接");
            } else {
                ILog.j("NetworkMonitor", "移动网络不可用");
            }
        }
    }

    public void onLost(Network network) {
        ILog.j("NetworkMonitor", "网络断开了->" + network);
        this.d.remove(network.toString());
        b();
    }
}
