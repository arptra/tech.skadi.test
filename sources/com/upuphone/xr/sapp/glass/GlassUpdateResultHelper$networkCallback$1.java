package com.upuphone.xr.sapp.glass;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/glass/GlassUpdateResultHelper$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateResultHelper$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        GlassUpdateResultHelper glassUpdateResultHelper = GlassUpdateResultHelper.b;
        glassUpdateResultHelper.x("NetworkCallback-onAvailable: " + network);
        glassUpdateResultHelper.F(1000);
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        GlassUpdateResultHelper glassUpdateResultHelper = GlassUpdateResultHelper.b;
        glassUpdateResultHelper.x("NetworkCallback-onLost: " + network);
    }
}
