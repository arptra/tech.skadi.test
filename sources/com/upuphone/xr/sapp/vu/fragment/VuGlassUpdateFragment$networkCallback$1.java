package com.upuphone.xr.sapp.vu.fragment;

import android.net.ConnectivityManager;
import android.net.Network;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/vu/fragment/VuGlassUpdateFragment$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuGlassUpdateFragment$networkCallback$1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassUpdateFragment f8067a;

    public VuGlassUpdateFragment$networkCallback$1(VuGlassUpdateFragment vuGlassUpdateFragment) {
        this.f8067a = vuGlassUpdateFragment;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ULog.Delegate delegate = ULog.f6446a;
        boolean G0 = this.f8067a.l;
        delegate.a("VuGlassUpdateFragment", "NetworkCallback-onAvailable: " + network + ", needCheckUpdate: " + G0);
        if (this.f8067a.l) {
            this.f8067a.l = false;
            DeviceInfo c = VuGlassesDeviceInfoModel.f8112a.c();
            if (c != null) {
                VuGlassesOtaModel.f8117a.u(c);
            }
        }
    }
}
