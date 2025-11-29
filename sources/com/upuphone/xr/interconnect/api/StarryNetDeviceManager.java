package com.upuphone.xr.interconnect.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.common.IP2pStateListener;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.main.DiscoveryState;
import java.util.List;

public interface StarryNetDeviceManager {
    void acquireBalanceConnection(String str, String str2, @Nullable IRequestCallback iRequestCallback);

    void acquireEnhanceConnection(String str, String str2, @Nullable IRequestCallback iRequestCallback);

    void activeQueryConnectedDevice();

    boolean bondDevice(String str);

    int connectDevice(String str);

    boolean disconnectDevice(String str);

    StarryNetDevice getBondedDevice();

    List<StarryNetDevice> getBondedDevices();

    StarryNetDevice getBondedGlassStarryNetDevice();

    StarryNetDevice getBondedRingStarryNetDevice();

    List<StarryNetDevice> getBondedStarryNetDeviceList();

    StarryDevice getConnectedDevice();

    StarryNetDevice getConnectedDevice(int i);

    String getConnectedDeviceType();

    String getConnectedDeviceType(String str);

    StarryNetDevice getConnectedDeviceWrapper();

    StarryNetDevice getConnectedGlassStarryNetDevice();

    StarryNetDevice getConnectedRingStarryNetDevice();

    List<StarryNetDevice> getConnectedStarryNetDeviceList();

    long getDefaultAdvertiseTimeout();

    @DeviceBondState
    int getDeviceBondState(String str);

    String getDeviceInfo(String str, int i);

    @Deprecated
    @DiscoveryState
    int getDiscoveryState();

    List<StarryNetDevice> getFoundDevices();

    @P2pConnectState
    int getP2pState();

    StarryNetDevice getSelfDevice();

    String[] getWifiInfo();

    void init();

    void interceptConnectProcess(boolean z);

    boolean isAir();

    boolean isAirPro();

    boolean isIntlAir();

    boolean isIntlAirPro();

    boolean isPhoneDevice(@NonNull StarryNetDevice starryNetDevice) {
        return starryNetDevice.getTerminalType() == 1 || starryNetDevice.getTerminalType() == 4 || starryNetDevice.getTerminalType() == 6;
    }

    boolean isPhoneDevice2(@NonNull StarryDevice starryDevice) {
        StDevice starryDevice2 = starryDevice.getStarryDevice();
        return starryDevice2.getTerminalType() == 1 || starryDevice2.getTerminalType() == 4 || starryDevice2.getTerminalType() == 6;
    }

    void registerConnectionListener(ConnectionListener connectionListener, boolean z);

    void registerDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener);

    void registerDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener);

    void registerDeviceConnectionPriorityListener(IDeviceConnectionListener iDeviceConnectionListener);

    void registerDeviceDiscoverListener(StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener);

    void registerDeviceStateChangeListener(StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener);

    void registerP2pStateListener(IP2pStateListener iP2pStateListener);

    void releaseBalanceConnection(String str, String str2);

    void releaseEnhanceConnection(String str, String str2);

    void setAllDeviceDisConnectionStatus();

    void setMainDeviceConnectListener(IDeviceConnectionListener iDeviceConnectionListener);

    void startAdvertise();

    void startAdvertiseWithTimeout(long j);

    void startDiscovery();

    void startDiscovery(DiscoveryFilter discoveryFilter, StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener);

    void stopAdvertise();

    void stopDiscovery();

    void tryAcquireP2p(String str, IP2pAcquireCallback iP2pAcquireCallback);

    void tryReleaseP2p(String str);

    boolean unBondDevice(String str);

    void unregisterConnectionListener(ConnectionListener connectionListener);

    void unregisterDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener);

    void unregisterDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener);

    void unregisterDeviceConnectionPriorityListener(IDeviceConnectionListener iDeviceConnectionListener);

    void unregisterDeviceDiscoverListener(StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener);

    void unregisterDeviceStateChangeListener(StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener);

    void unregisterP2pSateListener(IP2pStateListener iP2pStateListener);
}
