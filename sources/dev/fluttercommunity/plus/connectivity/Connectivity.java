package dev.fluttercommunity.plus.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public class Connectivity {

    /* renamed from: a  reason: collision with root package name */
    public final ConnectivityManager f8787a;

    public Connectivity(ConnectivityManager connectivityManager) {
        this.f8787a = connectivityManager;
    }

    public ConnectivityManager a() {
        return this.f8787a;
    }

    public String b() {
        NetworkCapabilities networkCapabilities = this.f8787a.getNetworkCapabilities(this.f8787a.getActiveNetwork());
        return networkCapabilities == null ? "none" : networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(3) ? "ethernet" : networkCapabilities.hasTransport(0) ? "mobile" : networkCapabilities.hasTransport(2) ? "bluetooth" : c();
    }

    public final String c() {
        NetworkInfo activeNetworkInfo = this.f8787a.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "none";
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? type != 1 ? (type == 4 || type == 5) ? "mobile" : type != 6 ? type != 7 ? type != 9 ? "none" : "ethernet" : "bluetooth" : "wifi" : "wifi" : "mobile";
    }
}
