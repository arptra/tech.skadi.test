package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDeviceManager;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.listener.ReplayListenerAggregator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreDeviceBondStateListener$1", "Lcom/upuphone/xr/interconnect/listener/ReplayListenerAggregator;", "Lcom/upuphone/xr/interconnect/listener/DeviceBondStateListener;", "Lcom/upuphone/xr/interconnect/common/IDeviceManager;", "createParentListener", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$coreDeviceBondStateListener$1 extends ReplayListenerAggregator<DeviceBondStateListener, IDeviceManager> {
    public DeviceOperatorImpl$coreDeviceBondStateListener$1(String str, DeviceOperatorImpl$coreDeviceBondStateListener$2 deviceOperatorImpl$coreDeviceBondStateListener$2, Function1<? super Function1<? super IDeviceManager, Unit>, Unit> function1, DeviceOperatorImpl$coreDeviceBondStateListener$4 deviceOperatorImpl$coreDeviceBondStateListener$4, DeviceOperatorImpl$coreDeviceBondStateListener$5 deviceOperatorImpl$coreDeviceBondStateListener$5) {
        super("device bond state", str, deviceOperatorImpl$coreDeviceBondStateListener$2, function1, deviceOperatorImpl$coreDeviceBondStateListener$4, deviceOperatorImpl$coreDeviceBondStateListener$5);
    }

    @NotNull
    public DeviceBondStateListener createParentListener() {
        return new DeviceOperatorImpl$coreDeviceBondStateListener$1$createParentListener$1(this);
    }
}
