package com.upuphone.ar.tici.phone;

import android.net.ConnectivityManager;
import android.net.Network;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/tici/phone/TiciFileTipsActivity$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciFileTipsActivity$networkCallback$1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciFileTipsActivity f5885a;

    public TiciFileTipsActivity$networkCallback$1(TiciFileTipsActivity ticiFileTipsActivity) {
        this.f5885a = ticiFileTipsActivity;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        CommonExtKt.e("onAvailable, network: " + network, "TiciFileTipsActivity");
        this.f5885a.D0();
    }
}
