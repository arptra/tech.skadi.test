package com.upuphone.starrynet.strategy.service;

import android.text.TextUtils;
import com.here.odnp.config.OdnpConfigStatic;
import com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.manager.IStarryDiscoveryManager;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;

public class StarryDiscoveryManager implements IStarryDiscoveryManager {
    private static final int REQUEST_CONNECT_TIMEOUT_DEFAULT = 120000;
    private static final int REQUEST_CONNECT_TIMEOUT_MAX = 180000;
    private static final String TAG = "StarryDiscoveryManager";
    private final IStarryNetDiscoverer mDiscoveryManager;

    public StarryDiscoveryManager(IStarryNetDiscoverer iStarryNetDiscoverer) {
        this.mDiscoveryManager = iStarryNetDiscoverer;
        StarryNetData.getInstance().setDiscoveryMgr(iStarryNetDiscoverer);
    }

    public int disableFastConnect() {
        StLog.d(TAG, "disableFastConnect");
        return this.mDiscoveryManager.disableFastConnect();
    }

    public int enableFastConnect() {
        StLog.d(TAG, "enableFastConnect");
        return this.mDiscoveryManager.enableFastConnect();
    }

    public int enableFastConnectWithTimeOut(long j) {
        StLog.d(TAG, "enableFastConnectWithTimeOut");
        return this.mDiscoveryManager.enableFastConnectWithTimeOut(j);
    }

    public int requestConnect(byte[] bArr) {
        return requestConnectWithTime(bArr, OdnpConfigStatic.OEM_MAX_HIGH_POWER_INTERVAL);
    }

    public int requestConnectWithTime(byte[] bArr, long j) {
        return (bArr == null || bArr.length != 7 || j < 0 || j > TiciStarryMsgManager.MAX_TIME_OUT) ? StErrorCode.DISCOVERY_STRATEGY_INVALID_PARAM : this.mDiscoveryManager.requestConnect(bArr, j);
    }

    public int setAdvertiseEnableMode(int i) {
        StLog.i(TAG, "setAdvertiseEnableMode, mode = " + i);
        return (i == 1 || i == 0) ? this.mDiscoveryManager.setAdvertiseEnableMode(i) : StErrorCode.DISCOVERY_STRATEGY_INVALID_PARAM;
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        StLog.i(TAG, "setDeviceConnectable enable=" + z + ",terminalType=" + i + ",modelID=" + str);
        return this.mDiscoveryManager.setDeviceConnectable(z, i, str);
    }

    public void setDiscoveryFilter(DiscoveryFilter discoveryFilter) {
    }

    public int setFastConnectProcess(int i) {
        StLog.d(TAG, "setFastConnectProcess type " + i);
        return this.mDiscoveryManager.setFastConnectProcess(i);
    }

    public int setReconnectEnable(boolean z) {
        StLog.i(TAG, "setReconnectEnable, enable = " + z);
        return this.mDiscoveryManager.setReconnectEnable(z);
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        StLog.d(TAG, "startDiscovery");
        return this.mDiscoveryManager.startDiscovery(discoveryFilter, discoverySettings, iStarryDiscoveryCallback);
    }

    public int startMultiDeviceFound() {
        StLog.d(TAG, "startMultiDeviceFound");
        return this.mDiscoveryManager.startMultiDeviceFound();
    }

    public void startUp(short s) {
        this.mDiscoveryManager.startUp(s);
    }

    public int stopDiscovery(String str) {
        StLog.d(TAG, "stopDiscovery discoveryID " + str);
        return TextUtils.isEmpty(str) ? StErrorCode.DISCOVERY_STRATEGY_INVALID_PARAM : this.mDiscoveryManager.stopDiscovery(str);
    }

    public int stopMultiDeviceFound(boolean z) {
        StLog.d(TAG, "stopMultiDeviceFound");
        return this.mDiscoveryManager.stopMultiDeviceFound(z);
    }

    public int updateAdvParams(byte[] bArr) {
        return this.mDiscoveryManager.upDataAdvParams(bArr);
    }
}
