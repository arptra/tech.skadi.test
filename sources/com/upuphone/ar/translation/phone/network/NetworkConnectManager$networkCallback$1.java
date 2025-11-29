package com.upuphone.ar.translation.phone.network;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.starrynet.common.StarryNetConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016¨\u0006\u0014"}, d2 = {"com/upuphone/ar/translation/phone/network/NetworkConnectManager$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onBlockedStatusChanged", "blocked", "", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLinkPropertiesChanged", "linkProperties", "Landroid/net/LinkProperties;", "onLosing", "maxMsToLive", "", "onLost", "onUnavailable", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkConnectManager$networkCallback$1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NetworkConnectManager f6318a;

    public NetworkConnectManager$networkCallback$1(NetworkConnectManager networkConnectManager) {
        this.f6318a = networkConnectManager;
    }

    public void onAvailable(Network network) {
        Unit unit;
        Intrinsics.checkNotNullParameter(network, "network");
        String i = this.f6318a.r(network);
        NetworkCapabilities networkCapabilities = this.f6318a.q().getNetworkCapabilities(network);
        if (networkCapabilities != null) {
            NetworkConnectManager networkConnectManager = this.f6318a;
            networkConnectManager.u(networkCapabilities, new NetworkConnectManager$networkCallback$1$onAvailable$1$1(network, i, networkConnectManager));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            LogExt.j("onAvailable networkCapabilities is null", "NetworkConnectManager");
        }
    }

    public void onBlockedStatusChanged(Network network, boolean z) {
        Intrinsics.checkNotNullParameter(network, "network");
        LogExt.j("onBlockedStatusChanged network = " + network + ", blocked = " + z, "NetworkConnectManager");
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        LogExt.j("onCapabilitiesChanged networkCapabilities=" + networkCapabilities, "NetworkConnectManager");
        String j = this.f6318a.s(networkCapabilities);
        String a2 = this.f6318a.p();
        LogExt.j("onCapabilitiesChanged [network=" + network + ", networkType=" + j + ", activeNetworkType=" + a2 + "]", "NetworkConnectManager");
        if (Intrinsics.areEqual((Object) j, (Object) StarryNetConstant.DEVICE_NAME_UNKNOWN) || Intrinsics.areEqual((Object) a2, (Object) StarryNetConstant.DEVICE_NAME_UNKNOWN)) {
            LogExt.j("onCapabilitiesChanged 非网络状态，无需处理", "NetworkConnectManager");
        } else if (!Intrinsics.areEqual((Object) j, (Object) a2)) {
            LogExt.j("onCapabilitiesChanged 非当前默认使用网络状态改变，无需处理", "NetworkConnectManager");
        } else {
            NetworkConnectManager networkConnectManager = this.f6318a;
            networkConnectManager.u(networkCapabilities, new NetworkConnectManager$networkCallback$1$onCapabilitiesChanged$1(networkConnectManager));
        }
    }

    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(linkProperties, "linkProperties");
        LogExt.j("onLinkPropertiesChanged network = " + network + ", link = " + linkProperties, "NetworkConnectManager");
    }

    public void onLosing(Network network, int i) {
        Intrinsics.checkNotNullParameter(network, "network");
        LogExt.j("onLosing network = " + network + ", maxMsToLive = " + i, "NetworkConnectManager");
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        String i = this.f6318a.r(network);
        LogExt.j("onLost [network=" + network + ", networkType=" + i + "]", "NetworkConnectManager");
        INetworkConnectListener h = this.f6318a.b;
        if (h != null) {
            h.c();
        }
        this.f6318a.d = false;
        this.f6318a.e = false;
        this.f6318a.f = false;
    }

    public void onUnavailable() {
        LogExt.j("onUnavailable", "NetworkConnectManager");
    }
}
