package com.upuphone.ar.translation.phone.network;

import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAccessible", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NetworkConnectManager$startMonitor$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ NetworkConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectManager$startMonitor$1(NetworkConnectManager networkConnectManager) {
        super(1);
        this.this$0 = networkConnectManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        INetworkConnectListener h;
        LogExt.j("startMonitor network accessible=" + z, "NetworkConnectManager");
        this.this$0.q().registerDefaultNetworkCallback(this.this$0.j);
        if (z) {
            INetworkConnectListener h2 = this.this$0.b;
            if (h2 != null) {
                h2.a();
            }
        } else if (!TranslatorConstants.isAirPro() && !TranslatorConstants.isAir() && (h = this.this$0.b) != null) {
            h.c();
        }
        this.this$0.d = z;
        String a2 = this.this$0.p();
        LogExt.j("startMonitor networkType=" + a2, "NetworkConnectManager");
        this.this$0.e = false;
        this.this$0.f = false;
        this.this$0.g = false;
    }
}
