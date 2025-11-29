package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreDeviceConnectionListener$1$createParentListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$coreDeviceConnectionListener$1$createParentListener$1 extends DeviceConnectionListener {
    final /* synthetic */ DeviceOperatorImpl$coreDeviceConnectionListener$1 this$0;

    public DeviceOperatorImpl$coreDeviceConnectionListener$1$createParentListener$1(DeviceOperatorImpl$coreDeviceConnectionListener$1 deviceOperatorImpl$coreDeviceConnectionListener$1) {
        this.this$0 = deviceOperatorImpl$coreDeviceConnectionListener$1;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        this.this$0.callEachListener("device connected", new DeviceOperatorImpl$coreDeviceConnectionListener$1$createParentListener$1$onDeviceConnected$1(starryNetDevice));
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        this.this$0.callEachListener("device disconnected", new DeviceOperatorImpl$coreDeviceConnectionListener$1$createParentListener$1$onDeviceDisconnected$1(starryNetDevice));
    }
}
