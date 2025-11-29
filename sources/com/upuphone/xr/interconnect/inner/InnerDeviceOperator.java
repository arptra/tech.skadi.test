package com.upuphone.xr.interconnect.inner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.P2pAcquireCallback;
import com.upuphone.xr.interconnect.listener.P2pStateListener;
import com.upuphone.xr.interconnect.listener.RequestCallback;
import java.util.List;

class InnerDeviceOperator implements StarryNetDeviceOperator {
    private String mPkgName;

    public InnerDeviceOperator(String str) {
        this.mPkgName = str;
    }

    public void acquireEnhanceConnection(@NonNull String str, @Nullable RequestCallback requestCallback) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().acquireEnhanceConnection(this.mPkgName, str, requestCallback);
    }

    public List<StarryNetDevice> getBondedDevices() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedDevices();
    }

    public StarryNetDevice getConnectedDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceWrapper();
    }

    public int getDeviceBondState(String str) {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getDeviceBondState(str);
    }

    public int getP2pState() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getP2pState();
    }

    public StarryNetDevice getSelfDevice() {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getSelfDevice();
    }

    public void registerDeviceBondStateListener(DeviceBondStateListener deviceBondStateListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceBondStateListener(deviceBondStateListener);
    }

    public void registerDeviceConnectionListener(DeviceConnectionListener deviceConnectionListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceConnectionListener(deviceConnectionListener);
    }

    public void registerP2pStateListener(P2pStateListener p2pStateListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerP2pStateListener(p2pStateListener);
    }

    public void releaseEnhanceConnection(@NonNull String str) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().releaseEnhanceConnection(this.mPkgName, str);
    }

    public void tryAcquireP2p(P2pAcquireCallback p2pAcquireCallback) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().tryAcquireP2p(this.mPkgName, p2pAcquireCallback);
    }

    public void tryReleaseP2p() {
        InterconnectManager.getInstance().getStarryNetDeviceManager().tryReleaseP2p(this.mPkgName);
    }

    public boolean unBondDevice(String str) {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().unBondDevice(str);
    }

    public void unregisterDeviceBondStateListener(DeviceBondStateListener deviceBondStateListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceBondStateListener(deviceBondStateListener);
    }

    public void unregisterDeviceConnectionListener(DeviceConnectionListener deviceConnectionListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceConnectionListener(deviceConnectionListener);
    }

    public void unregisterP2pSateListener(P2pStateListener p2pStateListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterP2pSateListener(p2pStateListener);
    }
}
