package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class DeviceOperatorImpl$coreP2pStateListener$3 extends AdaptedFunctionReference implements Function1<Function1<? super IDeviceManager, ? extends Unit>, Unit> {
    public DeviceOperatorImpl$coreP2pStateListener$3(Object obj) {
        super(1, obj, DeviceOperatorImpl.class, "safeRemoteProxyCall", "safeRemoteProxyCall(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", 8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function1<? super IDeviceManager, Unit>) (Function1) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Function1<? super IDeviceManager, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "p0");
        ((DeviceOperatorImpl) this.receiver).safeRemoteProxyCall(function1);
    }
}
