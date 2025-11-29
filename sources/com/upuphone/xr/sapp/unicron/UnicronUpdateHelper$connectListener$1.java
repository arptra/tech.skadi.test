package com.upuphone.xr.sapp.unicron;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.glass.DeviceConnectListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/unicron/UnicronUpdateHelper$connectListener$1", "Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnicronUpdateHelper$connectListener$1 implements DeviceConnectListener {
    public void onDeviceConnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("onDeviceConnected: " + starryNetDevice);
        if (UnicronUpdateHelper.d) {
            UnicronUpdateHelper.d = false;
            UnicronUpdateHelper.B(unicronUpdateHelper, 0, false, 3, (Object) null);
        }
        unicronUpdateHelper.I();
    }

    public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("onDeviceDisconnected: " + starryNetDevice);
    }
}
