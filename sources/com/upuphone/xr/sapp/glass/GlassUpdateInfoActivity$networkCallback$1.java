package com.upuphone.xr.sapp.glass;

import android.net.ConnectivityManager;
import android.net.Network;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/glass/GlassUpdateInfoActivity$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateInfoActivity$networkCallback$1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassUpdateInfoActivity f7065a;

    public GlassUpdateInfoActivity$networkCallback$1(GlassUpdateInfoActivity glassUpdateInfoActivity) {
        this.f7065a = glassUpdateInfoActivity;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ULog.Delegate delegate = ULog.f6446a;
        boolean D0 = this.f7065a.h;
        delegate.a("GlassUpdateInfoActivity", "NetworkCallback-onAvailable: " + network + ", needCheckUpdate: " + D0);
        if (this.f7065a.h) {
            this.f7065a.h = false;
            GlassUpdateHelper.b.h0(500, true);
        }
    }
}
