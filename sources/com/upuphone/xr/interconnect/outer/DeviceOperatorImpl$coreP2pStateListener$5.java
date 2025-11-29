package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceManager;
import com.upuphone.xr.interconnect.common.IP2pStateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class DeviceOperatorImpl$coreP2pStateListener$5 extends FunctionReferenceImpl implements Function2<IDeviceManager, IP2pStateListener, Unit> {
    public static final DeviceOperatorImpl$coreP2pStateListener$5 INSTANCE = new DeviceOperatorImpl$coreP2pStateListener$5();

    public DeviceOperatorImpl$coreP2pStateListener$5() {
        super(2, IDeviceManager.class, "unregisterP2pStateListener", "unregisterP2pStateListener(Lcom/upuphone/xr/interconnect/common/IP2pStateListener;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IDeviceManager) obj, (IP2pStateListener) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IDeviceManager iDeviceManager, IP2pStateListener iP2pStateListener) {
        Intrinsics.checkNotNullParameter(iDeviceManager, "p0");
        iDeviceManager.unregisterP2pStateListener(iP2pStateListener);
    }
}
