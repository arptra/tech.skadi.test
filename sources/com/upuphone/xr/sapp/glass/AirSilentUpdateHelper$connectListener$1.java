package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.air.AirHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/glass/AirSilentUpdateHelper$connectListener$1", "Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AirSilentUpdateHelper$connectListener$1 implements DeviceConnectListener {
    public void onDeviceConnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            AirSilentUpdateHelper airSilentUpdateHelper = AirSilentUpdateHelper.b;
            airSilentUpdateHelper.t("onDeviceConnected: " + starryNetDevice);
            if (!AirHelper.b.I(starryNetDevice)) {
                AirSilentUpdateHelper.c = false;
            } else {
                airSilentUpdateHelper.q();
            }
        }
    }

    public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            AirSilentUpdateHelper airSilentUpdateHelper = AirSilentUpdateHelper.b;
            airSilentUpdateHelper.t("onDeviceDisconnected: " + starryNetDevice);
            AirSilentUpdateHelper.c = false;
        }
    }
}
