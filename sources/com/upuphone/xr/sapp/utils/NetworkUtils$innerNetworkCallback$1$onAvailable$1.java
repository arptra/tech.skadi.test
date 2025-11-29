package com.upuphone.xr.sapp.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/net/ConnectivityManager$NetworkCallback;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NetworkUtils$innerNetworkCallback$1$onAvailable$1 extends Lambda implements Function1<ConnectivityManager.NetworkCallback, Unit> {
    final /* synthetic */ Network $network;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkUtils$innerNetworkCallback$1$onAvailable$1(Network network) {
        super(1);
        this.$network = network;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConnectivityManager.NetworkCallback) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ConnectivityManager.NetworkCallback networkCallback) {
        Intrinsics.checkNotNullParameter(networkCallback, "$this$dispatchNetworkCallback");
        networkCallback.onAvailable(this.$network);
    }
}
