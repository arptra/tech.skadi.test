package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetDeviceInfo;
import java.util.List;

public interface StarryNetDeviceInfoManager {

    public interface DeviceInfoCallback {
        void onReceiveDeviceInfo(StarryNetDeviceInfo starryNetDeviceInfo);
    }

    StarryNetDevice getBondedDevice();

    StarryNetDevice getBondedGlassStarryNetDevice();

    StarryNetDevice getBondedRingStarryNetDevice();

    List<StarryNetDevice> getBondedStarryNetDeviceList();

    String getConnectedDeviceType();

    StarryNetDevice getConnectedGlassStarryNetDevice();

    StarryNetDevice getConnectedRingStarryNetDevice();

    List<StarryNetDevice> getConnectedStarryNetDeviceList();

    void getDeviceInfo(DeviceInfoCallback deviceInfoCallback);

    boolean isAir();

    boolean isAirPro();
}
