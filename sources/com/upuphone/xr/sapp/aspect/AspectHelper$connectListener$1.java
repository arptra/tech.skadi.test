package com.upuphone.xr.sapp.aspect;

import com.upuphone.ar.translation.interconnect.entity.InterConnectDeviceExtKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/aspect/AspectHelper$connectListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AspectHelper$connectListener$1 extends DeviceConnectionListener {
    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(AspectHelper.TAG, "onDeviceConnected " + starryNetDevice);
        if (starryNetDevice != null && InterConnectDeviceExtKt.isXRDevice(starryNetDevice)) {
            AspectHelper.INSTANCE.setDeviceConnect(true);
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(AspectHelper.TAG, "onDeviceDisconnected " + starryNetDevice);
        if (starryNetDevice != null && InterConnectDeviceExtKt.isXRDevice(starryNetDevice)) {
            AspectHelper.INSTANCE.setDeviceConnect(false);
        }
    }
}
