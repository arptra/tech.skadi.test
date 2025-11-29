package com.upuphone.xr.sapp.unicron;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nUnicronUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$networkCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,760:1\n1855#2,2:761\n*S KotlinDebug\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$networkCallback$1\n*L\n119#1:761,2\n*E\n"})
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/unicron/UnicronUpdateHelper$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnicronUpdateHelper$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        int size = UnicronUpdateHelper.k.size();
        unicronUpdateHelper.L("NetworkCallback-onAvailable: " + network + ", networkPendingTasks: " + size);
        for (Runnable run : UnicronUpdateHelper.k) {
            run.run();
        }
        UnicronUpdateHelper.k.clear();
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        boolean j = NetworkUtils.f7898a.j(networkCapabilities);
        unicronUpdateHelper.L("NetworkCallback-onCapabilitiesChanged, isAvailable: " + j);
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        boolean g = NetworkUtils.f7898a.g();
        unicronUpdateHelper.L("NetworkCallback-onLost: " + network + ", hasNetwork: " + g);
    }
}
