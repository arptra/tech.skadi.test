package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/interconnect/outer/DeviceOperatorImpl$coreDeviceBondStateListener$1$createParentListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceBondStateListener;", "onDeviceBondStateChange", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "newState", "", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceOperatorImpl$coreDeviceBondStateListener$1$createParentListener$1 extends DeviceBondStateListener {
    final /* synthetic */ DeviceOperatorImpl$coreDeviceBondStateListener$1 this$0;

    public DeviceOperatorImpl$coreDeviceBondStateListener$1$createParentListener$1(DeviceOperatorImpl$coreDeviceBondStateListener$1 deviceOperatorImpl$coreDeviceBondStateListener$1) {
        this.this$0 = deviceOperatorImpl$coreDeviceBondStateListener$1;
    }

    public void onDeviceBondStateChange(@Nullable StarryNetDevice starryNetDevice, int i) {
        DeviceOperatorImpl$coreDeviceBondStateListener$1 deviceOperatorImpl$coreDeviceBondStateListener$1 = this.this$0;
        StringBuilder sb = new StringBuilder();
        sb.append("new bond state of ");
        sb.append(starryNetDevice != null ? PrettyPrintExtKt.stringify(starryNetDevice) : null);
        sb.append(": ");
        sb.append(i);
        deviceOperatorImpl$coreDeviceBondStateListener$1.callEachListener(sb.toString(), new DeviceOperatorImpl$coreDeviceBondStateListener$1$createParentListener$1$onDeviceBondStateChange$1(starryNetDevice, i));
    }
}
