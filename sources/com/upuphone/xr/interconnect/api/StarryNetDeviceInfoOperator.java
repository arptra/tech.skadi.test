package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceInfoCallback;
import java.util.List;

public interface StarryNetDeviceInfoOperator {
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
