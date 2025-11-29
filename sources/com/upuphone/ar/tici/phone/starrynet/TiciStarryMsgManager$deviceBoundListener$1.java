package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$deviceBoundListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceBondStateListener;", "onDeviceBondStateChange", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "state", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciStarryMsgManager$deviceBoundListener$1 extends DeviceBondStateListener {
    public void onDeviceBondStateChange(@Nullable StarryNetDevice starryNetDevice, int i) {
        CommonExtKt.e("onDeviceBondStateChange, state: " + i + ", device: " + starryNetDevice, "TiciStarryMsgManager");
        if (i == 0 && starryNetDevice != null && StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            SpUtilKt.n(0);
        }
    }
}
