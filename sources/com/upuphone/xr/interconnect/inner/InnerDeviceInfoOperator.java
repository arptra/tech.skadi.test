package com.upuphone.xr.interconnect.inner;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoOperator;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetDeviceInfo;
import com.upuphone.xr.interconnect.listener.DeviceInfoCallback;
import java.util.List;

public class InnerDeviceInfoOperator implements StarryNetDeviceInfoOperator {
    public StarryNetDevice getBondedDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedDevice();
    }

    public StarryNetDevice getBondedGlassStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedGlassStarryNetDevice();
    }

    public StarryNetDevice getBondedRingStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedRingStarryNetDevice();
    }

    public List<StarryNetDevice> getBondedStarryNetDeviceList() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedStarryNetDeviceList();
    }

    public String getConnectedDeviceType() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceType();
    }

    public StarryNetDevice getConnectedGlassStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedGlassStarryNetDevice();
    }

    public StarryNetDevice getConnectedRingStarryNetDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedRingStarryNetDevice();
    }

    public List<StarryNetDevice> getConnectedStarryNetDeviceList() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedStarryNetDeviceList();
    }

    public void getDeviceInfo(final DeviceInfoCallback deviceInfoCallback) {
        InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getDeviceInfo(new StarryNetDeviceInfoManager.DeviceInfoCallback() {
            public void onReceiveDeviceInfo(StarryNetDeviceInfo starryNetDeviceInfo) {
                try {
                    deviceInfoCallback.onRecieveDeviceInfo(starryNetDeviceInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean isAir() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAir();
    }

    public boolean isAirPro() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro();
    }
}
