package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.common.IDeviceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class DeviceOperatorImpl$coreDeviceBondStateListener$4 extends FunctionReferenceImpl implements Function2<IDeviceManager, IDeviceBondStateListener, Unit> {
    public static final DeviceOperatorImpl$coreDeviceBondStateListener$4 INSTANCE = new DeviceOperatorImpl$coreDeviceBondStateListener$4();

    public DeviceOperatorImpl$coreDeviceBondStateListener$4() {
        super(2, IDeviceManager.class, "registerDeviceBondStateListener", "registerDeviceBondStateListener(Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IDeviceManager) obj, (IDeviceBondStateListener) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IDeviceManager iDeviceManager, IDeviceBondStateListener iDeviceBondStateListener) {
        Intrinsics.checkNotNullParameter(iDeviceManager, "p0");
        iDeviceManager.registerDeviceBondStateListener(iDeviceBondStateListener);
    }
}
