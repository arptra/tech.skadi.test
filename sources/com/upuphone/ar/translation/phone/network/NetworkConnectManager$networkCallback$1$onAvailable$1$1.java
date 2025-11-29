package com.upuphone.ar.translation.phone.network;

import android.net.Network;
import com.upuphone.ar.translation.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAccessible", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NetworkConnectManager$networkCallback$1$onAvailable$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Network $network;
    final /* synthetic */ String $networkType;
    final /* synthetic */ NetworkConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectManager$networkCallback$1$onAvailable$1$1(Network network, String str, NetworkConnectManager networkConnectManager) {
        super(1);
        this.$network = network;
        this.$networkType = str;
        this.this$0 = networkConnectManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        INetworkConnectListener h;
        Network network = this.$network;
        String str = this.$networkType;
        LogExt.j("onAvailable [network=" + network + ", networkType=" + str + ", isAccessible=" + z + "]", "NetworkConnectManager");
        if (z && (h = this.this$0.b) != null) {
            h.a();
        }
    }
}
