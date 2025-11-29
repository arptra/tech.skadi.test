package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.common.IDeviceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class DeviceOperatorImpl$coreDeviceConnectionListener$4 extends FunctionReferenceImpl implements Function2<IDeviceManager, IDeviceConnectionListener, Unit> {
    public static final DeviceOperatorImpl$coreDeviceConnectionListener$4 INSTANCE = new DeviceOperatorImpl$coreDeviceConnectionListener$4();

    public DeviceOperatorImpl$coreDeviceConnectionListener$4() {
        super(2, IDeviceManager.class, "registerDeviceConnectionListener", "registerDeviceConnectionListener(Lcom/upuphone/xr/interconnect/common/IDeviceConnectionListener;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IDeviceManager) obj, (IDeviceConnectionListener) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IDeviceManager iDeviceManager, IDeviceConnectionListener iDeviceConnectionListener) {
        Intrinsics.checkNotNullParameter(iDeviceManager, "p0");
        iDeviceManager.registerDeviceConnectionListener(iDeviceConnectionListener);
    }
}
