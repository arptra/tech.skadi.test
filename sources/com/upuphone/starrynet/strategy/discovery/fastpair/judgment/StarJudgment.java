package com.upuphone.starrynet.strategy.discovery.fastpair.judgment;

import android.os.Handler;
import android.os.Message;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvertisePackUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StarJudgment extends BaseJudgment {
    private static final int DELAY_TIME = 500;
    private static final int RSSI_FAST_PAIR_MIN = -78;
    private static final int RSSI_FAST_PAIR_MIN_3004 = -78;
    private static final int RSSI_UN_BOND_MIN = -75;
    private static final int RSSI_UN_BOND_MIN_3004 = -75;
    protected static final String TAG = "StarJudgment";
    private final List<String> mDeviceBondCache = new ArrayList();
    private final Map<String, StDiscoveryDevice> mDeviceCache = new HashMap();
    private final List<String> mDevicePairCache = new ArrayList();

    public StarJudgment(FastPairJudgment fastPairJudgment, String str) {
        super(fastPairJudgment, str);
    }

    private synchronized void sendDelayMessage(StDiscoveryDevice stDiscoveryDevice) {
        String identifier2String = stDiscoveryDevice.getIdentifier2String();
        if (this.mDeviceCache.containsKey(identifier2String)) {
            this.mDeviceCache.put(identifier2String, stDiscoveryDevice);
            return;
        }
        this.mDeviceCache.put(identifier2String, stDiscoveryDevice);
        Handler handler = getHandler();
        handler.sendMessageDelayed(Message.obtain(handler, 101, stDiscoveryDevice), 500);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (getFastPairStatus(r1) == 2) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        getHandler().removeMessages(101);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        dealFastPairJudgment(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dealDelayJudgment(com.upuphone.starrynet.strategy.bean.StDiscoveryDevice r1, int r2, int r3) {
        /*
            r0 = this;
            java.lang.String r1 = r1.getIdentifier2String()
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.upuphone.starrynet.strategy.bean.StDiscoveryDevice> r2 = r0.mDeviceCache     // Catch:{ all -> 0x0011 }
            java.lang.Object r1 = r2.remove(r1)     // Catch:{ all -> 0x0011 }
            com.upuphone.starrynet.strategy.bean.StDiscoveryDevice r1 = (com.upuphone.starrynet.strategy.bean.StDiscoveryDevice) r1     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r1 = move-exception
            goto L_0x0029
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            int r2 = r0.getFastPairStatus(r1)
            r3 = 2
            if (r2 == r3) goto L_0x0025
            android.os.Handler r0 = r0.getHandler()
            r1 = 101(0x65, float:1.42E-43)
            r0.removeMessages(r1)
            return
        L_0x0025:
            r0.dealFastPairJudgment(r1)
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.discovery.fastpair.judgment.StarJudgment.dealDelayJudgment(com.upuphone.starrynet.strategy.bean.StDiscoveryDevice, int, int):void");
    }

    public void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice) {
        int rssi = stDiscoveryDevice.getRssi();
        int deviceBondInfoResult = getDeviceBondInfoResult(stDiscoveryDevice);
        if (deviceBondInfoResult < 0) {
            StLog.i(TAG, "device is connected, no need pop or connect");
            sendResult(stDiscoveryDevice, deviceBondInfoResult);
            return;
        }
        byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) 15);
        StLog.d(TAG, "dealFastPairJudgment deviceStatus =%d, peerBondState=%d", Integer.valueOf(deviceBondInfoResult), Byte.valueOf(bArr != null ? bArr[0] : -100));
        if (bArr != null && bArr[0] == 4) {
            byte[] peerMac = AdvertisePackUtil.getPeerMac(stDiscoveryDevice);
            StLog.d(TAG, "fastPair peer id = " + Utils.getAddressStringFromByte(peerMac) + " name = " + stDiscoveryDevice.getDeviceName());
            if (ByteUtils.equals(StarryNetData.getInstance().getIdentifier(), peerMac)) {
                sendResult(stDiscoveryDevice, deviceBondInfoResult + 3);
            } else if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 4 && ByteUtils.equals(StarryNetData.getInstance().getIdentifierForNoBtKaiXiangOTA(), peerMac)) {
                StLog.d(TAG, "third phone, check old device id = peer");
                sendResult(stDiscoveryDevice, deviceBondInfoResult + 3);
            } else if (deviceBondInfoResult != 0 || rssi >= getRssiUnBondMin()) {
                sendResult(stDiscoveryDevice, deviceBondInfoResult + 6);
            } else {
                StLog.df(TAG, "startFastPair, bond other, rssi " + rssi);
                this.mDeviceBondCache.add(stDiscoveryDevice.getIdentifier2String());
            }
        } else if (deviceBondInfoResult != 0 || rssi >= getRssiFastPairMin()) {
            sendResult(stDiscoveryDevice, deviceBondInfoResult);
        } else {
            StLog.df(TAG, "startFastPair, un bond, rssi " + rssi);
            this.mDevicePairCache.add(stDiscoveryDevice.getIdentifier2String());
        }
    }

    public int getRssiFastPairMin() {
        "3004".equals(this.mModelId);
        return -78;
    }

    public int getRssiUnBondMin() {
        "3004".equals(this.mModelId);
        return -75;
    }

    public boolean needOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice) {
        return false;
    }

    public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice) {
        String identifier2String = stDiscoveryDevice.getIdentifier2String();
        if (!isJudged(stDiscoveryDevice)) {
            this.mDevicePairCache.remove(identifier2String);
            this.mDeviceBondCache.remove(identifier2String);
            synchronized (this) {
                this.mDeviceCache.remove(identifier2String);
            }
            addPairRecord(stDiscoveryDevice);
            sendResult(stDiscoveryDevice, 100);
            return true;
        } else if (getFastPairStatus(stDiscoveryDevice) == 1) {
            return true;
        } else {
            if (this.mDeviceBondCache.contains(identifier2String)) {
                if (stDiscoveryDevice.getRssi() >= getRssiUnBondMin()) {
                    this.mDeviceBondCache.remove(identifier2String);
                    sendResult(stDiscoveryDevice, 100);
                }
                return true;
            } else if (this.mDevicePairCache.contains(identifier2String)) {
                if (stDiscoveryDevice.getRssi() >= getRssiFastPairMin()) {
                    this.mDevicePairCache.remove(identifier2String);
                    sendResult(stDiscoveryDevice, 100);
                }
                return true;
            } else {
                if (getFastPairStatus(stDiscoveryDevice) == 2) {
                    sendResult(stDiscoveryDevice, 100);
                }
                return true;
            }
        }
    }

    public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice) {
        return startFastPair(stDiscoveryDevice);
    }
}
