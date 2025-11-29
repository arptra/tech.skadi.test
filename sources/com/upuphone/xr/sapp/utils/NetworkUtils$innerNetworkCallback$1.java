package com.upuphone.xr.sapp.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"com/upuphone/xr/sapp/utils/NetworkUtils$innerNetworkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLosing", "maxMsToLive", "", "onLost", "onUnavailable", "lib_common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkUtils$innerNetworkCallback$1 extends ConnectivityManager.NetworkCallback {
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        NetworkUtils.f7898a.d(new NetworkUtils$innerNetworkCallback$1$onAvailable$1(network));
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        NetworkUtils.f7898a.d(new NetworkUtils$innerNetworkCallback$1$onCapabilitiesChanged$1(network, networkCapabilities));
    }

    public void onLosing(Network network, int i) {
        Intrinsics.checkNotNullParameter(network, "network");
        NetworkUtils.f7898a.d(new NetworkUtils$innerNetworkCallback$1$onLosing$1(network, i));
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        NetworkUtils.f7898a.d(new NetworkUtils$innerNetworkCallback$1$onLost$1(network));
    }

    public void onUnavailable() {
        NetworkUtils.f7898a.d(NetworkUtils$innerNetworkCallback$1$onUnavailable$1.INSTANCE);
    }
}
