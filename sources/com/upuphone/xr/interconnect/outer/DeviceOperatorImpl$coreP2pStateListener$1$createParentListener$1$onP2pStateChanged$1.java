package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.listener.P2pStateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/listener/P2pStateListener;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$coreP2pStateListener$1$createParentListener$1$onP2pStateChanged$1 extends Lambda implements Function1<P2pStateListener, Unit> {
    final /* synthetic */ int $newState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceOperatorImpl$coreP2pStateListener$1$createParentListener$1$onP2pStateChanged$1(int i) {
        super(1);
        this.$newState = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((P2pStateListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull P2pStateListener p2pStateListener) {
        Intrinsics.checkNotNullParameter(p2pStateListener, "$this$callEachListener");
        p2pStateListener.onP2pStateChanged(this.$newState);
    }
}
