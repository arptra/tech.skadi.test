package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoManager;
import com.upuphone.xr.interconnect.common.IDeviceInfoCallback;
import com.upuphone.xr.interconnect.common.IDeviceInfoManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetDeviceInfo;
import java.util.List;

public class DeviceInfoManagerImpl extends IDeviceInfoManager.Stub {
    public StarryNetDevice getBondedDevice() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getBondedDevice();
    }

    public StarryNetDevice getBondedGlassStarryNetDevice() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getBondedGlassStarryNetDevice();
    }

    public StarryNetDevice getBondedRingStarryNetDevice() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getBondedRingStarryNetDevice();
    }

    public List<StarryNetDevice> getBondedStarryNetDeviceList() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getBondedStarryNetDeviceList();
    }

    public String getConnectedDeviceType() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getConnectedDeviceType();
    }

    public StarryNetDevice getConnectedGlassStarryNetDevice() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getConnectedGlassStarryNetDevice();
    }

    public StarryNetDevice getConnectedRingStarryNetDevice() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getConnectedRingStarryNetDevice();
    }

    public List<StarryNetDevice> getConnectedStarryNetDeviceList() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getConnectedStarryNetDeviceList();
    }

    public void getDeviceInfo(final IDeviceInfoCallback iDeviceInfoCallback) throws RemoteException {
        InterconnectManager.getInstance().getStarryNetDeviceInfoManager().getDeviceInfo(new StarryNetDeviceInfoManager.DeviceInfoCallback() {
            public void onReceiveDeviceInfo(StarryNetDeviceInfo starryNetDeviceInfo) {
                try {
                    iDeviceInfoCallback.onRecieveDeviceInfo(starryNetDeviceInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean isAir() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().isAir();
    }

    public boolean isAirPro() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceInfoManager().isAirPro();
    }
}
