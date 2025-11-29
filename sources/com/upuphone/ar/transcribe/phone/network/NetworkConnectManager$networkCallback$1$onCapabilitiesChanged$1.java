package com.upuphone.ar.transcribe.phone.network;

import com.upuphone.ar.transcribe.eventtrack.EventTrackingHelper;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAccessible", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NetworkConnectManager$networkCallback$1$onCapabilitiesChanged$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ NetworkConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectManager$networkCallback$1$onCapabilitiesChanged$1(NetworkConnectManager networkConnectManager) {
        super(1);
        this.this$0 = networkConnectManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogExt.g("onCapabilitiesChanged isAccessible=" + z, "NetworkConnectManager");
        if (!z) {
            this.this$0.d = false;
        } else if (!this.this$0.d) {
            INetworkConnectListener h = this.this$0.b;
            if (h != null) {
                h.a();
            }
            this.this$0.d = true;
            EventTrackingHelper.f6058a.f(2, 0);
        }
    }
}
