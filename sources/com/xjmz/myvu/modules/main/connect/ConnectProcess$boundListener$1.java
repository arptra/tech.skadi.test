package com.xjmz.myvu.modules.main.connect;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/xjmz/myvu/modules/main/connect/ConnectProcess$boundListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceBondStateListener;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "", "code", "", "onDeviceBondStateChange", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ConnectProcess$boundListener$1 extends DeviceBondStateListener {
    public void onDeviceBondStateChange(@Nullable StarryNetDevice starryNetDevice, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ConnectProcess", "onDeviceBondStateChange() called with: device = " + starryNetDevice + ", code = " + i);
    }
}
