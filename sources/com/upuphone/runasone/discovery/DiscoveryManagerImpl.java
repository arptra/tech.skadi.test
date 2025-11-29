package com.upuphone.runasone.discovery;

import android.os.Binder;
import android.os.Bundle;
import com.upuphone.runasone.core.api.discovery.IDiscoveryCallback;
import com.upuphone.runasone.core.api.discovery.IDiscoveryManager;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiscoveryManagerImpl implements IDiscoveryManager {
    private final String SUPER_APP_PKG = "com.upuphone.star.launcher";
    private HashMap<String, IDiscoveryCallbackImpl> callbackHashMap = new HashMap<>();
    /* access modifiers changed from: private */
    public final Map<String, StarryDevice> devicesFound = new HashMap();
    private final StarrynetApiImpl starryService = StarrynetApiImpl.getInstance();

    public class IDiscoveryCallbackImpl implements IStarryDiscoveryCallback {
        private IDiscoveryCallback callback;
        private String discoveryID;

        public IDiscoveryCallbackImpl(IDiscoveryCallback iDiscoveryCallback) {
            this.callback = iDiscoveryCallback;
        }

        public String getDiscoveryID() {
            return this.discoveryID;
        }

        public void onDeviceConnectRequest(StDevice stDevice, byte[] bArr) {
            LogUtil.d(stDevice);
            StarryDevice convert = Utils.convert(stDevice);
            DiscoveryManagerImpl.this.devicesFound.put(convert.getId(), convert);
            this.callback.onDeviceConnectRequest(convert, bArr);
        }

        public void onDeviceFound(StDevice stDevice, byte[] bArr, Bundle bundle, DiscoveryFilter discoveryFilter) {
            StarryDevice convert = Utils.convert(stDevice);
            DiscoveryManagerImpl.this.devicesFound.put(convert.getId(), convert);
            this.callback.onDeviceFound(convert, bArr, bundle, discoveryFilter);
        }

        public void onDeviceLose(StDevice stDevice) {
            DiscoveryManagerImpl.this.devicesFound.remove(Utils.bytes2HexString(stDevice.getIdentifier()));
            this.callback.onDeviceLose(Utils.convert(stDevice));
        }

        public void onDiscoveryError(int i) {
            LogUtil.e("errorCode : " + i);
            this.callback.onDiscoveryError(i);
        }

        public void onDiscoveryRegistered(String str) {
            this.discoveryID = str;
        }

        public void onDiscoveryTimeout() {
            this.callback.onDiscoveryTimeout();
        }

        public void onFastFound(StDevice stDevice, int i, int i2) {
            LogUtil.d(stDevice);
            StarryDevice convert = Utils.convert(stDevice);
            DiscoveryManagerImpl.this.devicesFound.put(convert.getId(), convert);
            this.callback.onFastFound(convert, i, i2);
        }
    }

    public int cancelAuth(String str) {
        return this.starryService.cancelAuth(Utils.hexString2Bytes(str));
    }

    public void createBond(String str) {
        this.starryService.createBond(Utils.hexString2Bytes(str));
    }

    public void disableFastConnect() {
        this.starryService.disableFastConnect();
    }

    public void enableFastConnect() {
        this.starryService.enableFastConnect();
    }

    public int enableFastConnectWithTimeOut(long j) {
        return StarrynetApiImpl.getInstance().enableFastConnectWithTimeOut(j);
    }

    public StarryDevice getFoundDeviceById(String str) {
        return this.devicesFound.get(str);
    }

    public void removeBond(String str) {
        this.starryService.removeBond(Utils.hexString2Bytes(str));
    }

    public void requestAuth(String str, byte[] bArr) {
        this.starryService.requestAuth(Utils.hexString2Bytes(str), bArr);
    }

    public int requestConnect(byte[] bArr) {
        return this.starryService.requestConnect(bArr);
    }

    public int requestConnectWithTime(byte[] bArr, long j) {
        return this.starryService.requestConnectWithTime(bArr, j);
    }

    public int setAdvertiseEnableMode(int i) {
        return StarrynetApiImpl.getInstance().setAdvertiseEnableMode(i);
    }

    public void setDiscoveryFilter(DiscoveryFilter discoveryFilter) {
        this.starryService.setDiscoveryFilter(discoveryFilter);
    }

    public int setFastConnectProcess(int i) {
        Binder.getCallingPid();
        return StarrynetApiImpl.getInstance().setFastConnectProcess(i);
    }

    public int setReconnectEnable(boolean z) {
        return StarrynetApiImpl.getInstance().setReconnectEnable(z);
    }

    public void startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IDiscoveryCallback iDiscoveryCallback) {
        int callingPid = Binder.getCallingPid();
        String pkgName = Utils.getPkgName(callingPid);
        if (this.callbackHashMap.containsKey(String.valueOf(callingPid))) {
            this.starryService.stopDiscovery(this.callbackHashMap.remove(String.valueOf(callingPid)).getDiscoveryID());
        }
        IDiscoveryCallbackImpl iDiscoveryCallbackImpl = new IDiscoveryCallbackImpl(iDiscoveryCallback);
        if ("com.upuphone.star.launcher".equals(pkgName)) {
            setFastConnectProcess(10);
        }
        this.starryService.startDiscovery(discoveryFilter, discoverySettings, iDiscoveryCallbackImpl);
        this.callbackHashMap.put(String.valueOf(callingPid), iDiscoveryCallbackImpl);
    }

    public int startMultiDeviceFound() {
        return this.starryService.startMultiDeviceFound();
    }

    public void stopDiscovery() {
        stopDiscovery(String.valueOf(Binder.getCallingPid()));
    }

    public int stopMultiDeviceFound(boolean z) {
        return this.starryService.stopMultiDeviceFound(z);
    }

    public int updateAdvParams(byte[] bArr) {
        return this.starryService.updateAdvParams(bArr);
    }

    public void stopDiscovery(String str) {
        IDiscoveryCallbackImpl remove = this.callbackHashMap.remove(str);
        Set<String> keySet = this.callbackHashMap.keySet();
        LogUtil.d("keyPids :  " + keySet);
        if (remove != null) {
            this.starryService.stopDiscovery(remove.getDiscoveryID());
        }
    }
}
