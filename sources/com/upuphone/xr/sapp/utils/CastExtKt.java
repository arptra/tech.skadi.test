package com.upuphone.xr.sapp.utils;

import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.RunningTaskDelegate;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.TaskOperator;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "a", "()Ljava/lang/String;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class CastExtKt {
    public static final String a() {
        StarryNetDeviceOperator deviceOperator;
        StarryNetDevice connectedDevice;
        String deviceId;
        ResourceDescription occupiedResource;
        OperatorManager f = StarryMessageHelper.f7799a.f();
        if (f == null || (deviceOperator = f.getDeviceOperator()) == null || (connectedDevice = deviceOperator.getConnectedDevice()) == null || (deviceId = connectedDevice.getDeviceId()) == null) {
            return null;
        }
        Intrinsics.checkNotNull(deviceId);
        TaskOperator taskOperator = f.getTaskOperator();
        Intrinsics.checkNotNullExpressionValue(taskOperator, "getTaskOperator(...)");
        RunningTaskDelegate running$default = TaskOperator.DefaultImpls.getRunning$default(taskOperator, deviceId, "com.upuphone.xr.screencast", (ResourceDescription) null, 4, (Object) null);
        if (running$default == null || (occupiedResource = running$default.getOccupiedResource((byte) 1)) == null) {
            return null;
        }
        return occupiedResource.identifier;
    }
}
