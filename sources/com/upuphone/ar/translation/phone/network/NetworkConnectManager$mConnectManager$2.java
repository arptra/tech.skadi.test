package com.upuphone.ar.translation.phone.network;

import android.net.ConnectivityManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/net/ConnectivityManager;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NetworkConnectManager$mConnectManager$2 extends Lambda implements Function0<ConnectivityManager> {
    final /* synthetic */ NetworkConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectManager$mConnectManager$2(NetworkConnectManager networkConnectManager) {
        super(0);
        this.this$0 = networkConnectManager;
    }

    @NotNull
    public final ConnectivityManager invoke() {
        Object systemService = this.this$0.f6317a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }
}
