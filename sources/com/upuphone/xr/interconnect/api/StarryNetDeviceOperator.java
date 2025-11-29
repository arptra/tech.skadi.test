package com.upuphone.xr.interconnect.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.P2pAcquireCallback;
import com.upuphone.xr.interconnect.listener.P2pStateListener;
import com.upuphone.xr.interconnect.listener.RequestCallback;
import java.util.List;

public interface StarryNetDeviceOperator {
    void acquireEnhanceConnection(@NonNull String str, @Nullable RequestCallback requestCallback);

    List<StarryNetDevice> getBondedDevices();

    StarryNetDevice getConnectedDevice();

    @DeviceBondState
    int getDeviceBondState(@NonNull String str);

    @P2pConnectState
    int getP2pState();

    StarryNetDevice getSelfDevice();

    void registerDeviceBondStateListener(@NonNull DeviceBondStateListener deviceBondStateListener);

    void registerDeviceConnectionListener(@NonNull DeviceConnectionListener deviceConnectionListener);

    void registerP2pStateListener(@NonNull P2pStateListener p2pStateListener);

    void releaseEnhanceConnection(@NonNull String str);

    void tryAcquireP2p(@Nullable P2pAcquireCallback p2pAcquireCallback);

    void tryReleaseP2p();

    boolean unBondDevice(@NonNull String str);

    void unregisterDeviceBondStateListener(@NonNull DeviceBondStateListener deviceBondStateListener);

    void unregisterDeviceConnectionListener(@NonNull DeviceConnectionListener deviceConnectionListener);

    void unregisterP2pSateListener(@NonNull P2pStateListener p2pStateListener);
}
