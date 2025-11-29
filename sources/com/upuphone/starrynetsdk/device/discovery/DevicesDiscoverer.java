package com.upuphone.starrynetsdk.device.discovery;

import android.os.Bundle;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.core.api.discovery.IDiscoveryCallback;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import com.upuphone.starrynetsdk.device.DeviceAbility;
import java.util.Arrays;

public final class DevicesDiscoverer extends DeviceAbility {
    private static final String TAG = "DevicesDiscoverer";

    public int disableMultiMode(boolean z) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,disableMultiMode failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.stopMultiDeviceFound(z);
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "disableMultiMode failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "disableMultiMode failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int enableMultiMode() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,enableMultiMode failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            return this.api.startMultiDeviceFound();
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "enableMultiMode failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "enableMultiMode failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int interceptConnectProcess(boolean z) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,intercept failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.setFastConnectProcess(z ? 1 : 0);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "intercept failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "intercept failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int requestConnect(byte[] bArr) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,requestConnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            int requestConnect = this.api.requestConnect(bArr);
            SNSLog.d(TAG, "requestConnect result: " + requestConnect);
            return requestConnect;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "requestConnect failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "requestConnect failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int setAdvertiseEnableMode(int i) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,requestConnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            int advertiseEnableMode = this.api.setAdvertiseEnableMode(i);
            SNSLog.d(TAG, "setAdvertiseEnableMode result: " + advertiseEnableMode);
            return advertiseEnableMode;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setAdvertiseEnableMode failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setAdvertiseEnableMode failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int setAdvertiseInfo(byte[] bArr) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,setAdvertiseInfo failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            int updateAdvParams = this.api.updateAdvParams(bArr);
            SNSLog.d(TAG, "setAdvertiseInfo result: " + updateAdvParams);
            return updateAdvParams;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setAdvertiseInfo failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setAdvertiseInfo failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int setReconnectEnable(boolean z) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,requestConnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            int reconnectEnable = this.api.setReconnectEnable(z);
            SNSLog.d(TAG, "setReconnectEnable result: " + reconnectEnable);
            return reconnectEnable;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "setReconnectEnable failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "setReconnectEnable failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int startAdvertise() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,startAdvertise failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.enableFastConnect();
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "startAdvertise failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "startAdvertise failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverListener discoverListener) {
        return startDiscovery(discoveryFilter, new DiscoverySettings.Builder().setScanMode(0).build(), discoverListener);
    }

    public int stopAdvertise() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,stopAdvertise failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.disableFastConnect();
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "stopAdvertise failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "stopAdvertise failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int stopDiscover() {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,stopDiscover failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.stopDiscovery();
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "stopDiscover failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "stopDiscover failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, final DiscoverListener discoverListener) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,startDiscovery failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.startDiscovery(discoveryFilter, discoverySettings, new IDiscoveryCallback() {
                public void onDeviceConnectRequest(StarryDevice starryDevice, byte[] bArr) {
                    if (starryDevice == null) {
                        SNSLog.d(DevicesDiscoverer.TAG, "onDeviceConnectRequest: starryDevice is null");
                        return;
                    }
                    SNSLog.d(DevicesDiscoverer.TAG, "onDeviceConnectRequest: " + starryDevice + " >>> " + Arrays.toString(bArr));
                    discoverListener.onDeviceRequestConnect(starryDevice, bArr);
                }

                public void onDeviceFound(StarryDevice starryDevice, byte[] bArr, @Parcelable Bundle bundle, DiscoveryFilter discoveryFilter) {
                    if (starryDevice == null) {
                        SNSLog.d(DevicesDiscoverer.TAG, "onDeviceFound: starryDevice is null");
                        return;
                    }
                    SNSLog.v(DevicesDiscoverer.TAG, "onDeviceFound: " + starryDevice + " >>> " + bundle);
                    discoverListener.onDeviceFound(starryDevice, bArr);
                    discoverListener.onDeviceFound(starryDevice, bundle);
                }

                public void onDeviceLose(StarryDevice starryDevice) {
                    if (starryDevice == null) {
                        SNSLog.d(DevicesDiscoverer.TAG, "onDeviceLose: starryDevice is null");
                        return;
                    }
                    SNSLog.d(DevicesDiscoverer.TAG, "onDeviceLose: " + starryDevice);
                    discoverListener.onDeviceLose(starryDevice);
                }

                public void onDiscoveryError(int i) {
                    discoverListener.onError(i);
                }

                public void onDiscoveryTimeout() {
                    SNSLog.d(DevicesDiscoverer.TAG, "onDiscoveryTimeout");
                    discoverListener.onTimeout();
                }

                public void onFastFound(StarryDevice starryDevice, int i, int i2) {
                    if (starryDevice == null) {
                        SNSLog.d(DevicesDiscoverer.TAG, "onFastFound: starryDevice is null");
                        return;
                    }
                    SNSLog.d(DevicesDiscoverer.TAG, "onFastFound: " + starryDevice + " >>> " + i);
                    discoverListener.onFastFound(starryDevice, i);
                    discoverListener.onFastFound(starryDevice, i, i2);
                }
            });
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "startDiscovery failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "startDiscovery failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int startAdvertise(long j) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,startAdvertise failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.enableFastConnectWithTimeOut(j);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "startAdvertise failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "startAdvertise failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public int requestConnect(byte[] bArr, long j) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,requestConnect failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            int requestConnectWithTime = this.api.requestConnectWithTime(bArr, j);
            SNSLog.d(TAG, "requestConnect result: " + requestConnectWithTime);
            return requestConnectWithTime;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "requestConnect failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "requestConnect failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }
}
