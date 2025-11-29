package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import android.util.Log;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoOperator;
import com.upuphone.xr.interconnect.common.IDeviceInfoManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetDeviceInfo;
import com.upuphone.xr.interconnect.listener.DeviceInfoCallback;
import java.util.List;

public class StarryNetDeviceInfoOperatorImpl implements StarryNetDeviceInfoOperator, SuperServiceStateListener {
    private String TAG = "StarryNetDeviceInfoOperatorImpl";
    private SuperServiceProvider mProvider;

    public StarryNetDevice getBondedDevice() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getBondedDevice();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getBondedDevice error = " + e.getMessage());
            }
        }
        return null;
    }

    public StarryNetDevice getBondedGlassStarryNetDevice() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getBondedGlassStarryNetDevice();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getBondedGlassStarryNetDevice error = " + e.getMessage());
            }
        }
        return null;
    }

    public StarryNetDevice getBondedRingStarryNetDevice() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getBondedRingStarryNetDevice();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getBondedRingStarryNetDevice error = " + e.getMessage());
            }
        }
        return null;
    }

    public List<StarryNetDevice> getBondedStarryNetDeviceList() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getBondedStarryNetDeviceList();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getBondedStarryNetDeviceList error = " + e.getMessage());
            }
        }
        return null;
    }

    public String getConnectedDeviceType() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getConnectedDeviceType();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getConnectedDeviceType error = " + e.getMessage());
            }
        }
        return null;
    }

    public StarryNetDevice getConnectedGlassStarryNetDevice() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getConnectedGlassStarryNetDevice();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getConnectedGlassStarryNetDevice error = " + e.getMessage());
            }
        }
        return null;
    }

    public StarryNetDevice getConnectedRingStarryNetDevice() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getConnectedRingStarryNetDevice();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getConnectedRingStarryNetDevice error = " + e.getMessage());
            }
        }
        return null;
    }

    public List<StarryNetDevice> getConnectedStarryNetDeviceList() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.getConnectedStarryNetDeviceList();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "getConnectedStarryNetDeviceList error = " + e.getMessage());
            }
        }
        return null;
    }

    public void getDeviceInfo(DeviceInfoCallback deviceInfoCallback) {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                deviceInfoManager.getDeviceInfo(deviceInfoCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
                try {
                    deviceInfoCallback.onRecieveDeviceInfo((StarryNetDeviceInfo) null);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean isAir() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.isAir();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "isAir error = " + e.getMessage());
            }
        }
        return false;
    }

    public boolean isAirPro() {
        IDeviceInfoManager deviceInfoManager = this.mProvider.getDeviceInfoManager();
        if (deviceInfoManager != null) {
            try {
                return deviceInfoManager.isAirPro();
            } catch (RemoteException e) {
                String str = this.TAG;
                Log.d(str, "isAirPro error = " + e.getMessage());
            }
        }
        return false;
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }
}
