package com.upuphone.xr.sapp.contract;

import android.net.ConnectivityManager;
import android.net.Network;
import com.honey.account.e8.k;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.ActivityProtocolBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/contract/ProtocolActivity$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ProtocolActivity$networkCallback$1 extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProtocolActivity f6699a;

    public ProtocolActivity$networkCallback$1(ProtocolActivity protocolActivity) {
        this.f6699a = protocolActivity;
    }

    public static final void b(ProtocolActivity protocolActivity) {
        Intrinsics.checkNotNullParameter(protocolActivity, "this$0");
        protocolActivity.U0();
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ULog.Delegate delegate = ULog.f6446a;
        boolean F0 = this.f6699a.k;
        delegate.a("ProtocolActivity", "NetworkCallback-onAvailable: " + network + ", needRefresh: " + F0);
        if (this.f6699a.k) {
            this.f6699a.k = false;
            ActivityProtocolBinding B0 = this.f6699a.b;
            if (B0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                B0 = null;
            }
            B0.e.post(new k(this.f6699a));
        }
    }
}
