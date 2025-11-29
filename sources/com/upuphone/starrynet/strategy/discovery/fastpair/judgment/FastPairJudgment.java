package com.upuphone.starrynet.strategy.discovery.fastpair.judgment;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FastPairJudgment {
    public static final int JUDGMENT_STATUS_DEFAULT = 0;
    public static final int JUDGMENT_STATUS_NO_JUDGMENT = 2;
    public static final int JUDGMENT_STATUS_PAIRING = 1;
    static final int MSG_DELAY_JUDGMENT = 101;
    static final int MSG_FAST_PAIR_JUDGMENT = 100;
    private static final String TAG = "FastPairJudgment";
    private final IJudgmentCallback mCallback;
    private final Handler mHandler;
    private final BaseJudgment mJudgment;
    private final Map<String, BaseJudgment> mJudgmentMap;
    private final Map<String, Integer> mPairRecords = new ConcurrentHashMap();

    public FastPairJudgment(IJudgmentCallback iJudgmentCallback) {
        HandlerThread handlerThread = new HandlerThread("fast judgment");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            public boolean handleMessage(@NonNull Message message) {
                FastPairJudgment.this.dealMsg(message);
                return false;
            }
        });
        this.mCallback = iJudgmentCallback;
        HashMap hashMap = new HashMap();
        this.mJudgmentMap = hashMap;
        String modelID = StarryNetData.getInstance().getOwnDevice().getModelID();
        this.mJudgment = new BaseJudgment(this, modelID);
        StarJudgment starJudgment = new StarJudgment(this, modelID);
        hashMap.put("1001", starJudgment);
        hashMap.put("1002", starJudgment);
        AirJudgement airJudgement = new AirJudgement(this, modelID);
        hashMap.put("1003", airJudgement);
        hashMap.put("5001", airJudgement);
        AirProJudgement airProJudgement = new AirProJudgement(this, modelID);
        hashMap.put("1004", airProJudgement);
        hashMap.put("5002", airProJudgement);
    }

    private void dealDelayJudgment(StDiscoveryDevice stDiscoveryDevice, int i, int i2) {
        if (stDiscoveryDevice != null) {
            getJudgment(stDiscoveryDevice.getModelID()).dealDelayJudgment(stDiscoveryDevice, i, i2);
        }
    }

    private void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice != null) {
            getJudgment(stDiscoveryDevice.getModelID()).dealFastPairJudgment(stDiscoveryDevice);
        }
    }

    /* access modifiers changed from: private */
    public void dealMsg(Message message) {
        StDiscoveryDevice stDiscoveryDevice = (StDiscoveryDevice) message.obj;
        if (stDiscoveryDevice != null) {
            int i = message.what;
            if (i == 100) {
                dealFastPairJudgment(stDiscoveryDevice);
            } else if (i == 101) {
                dealDelayJudgment(stDiscoveryDevice, message.arg1, message.arg2);
            } else if (i < 0) {
                StLog.v(TAG, "device status is error, " + message.what);
            } else {
                this.mCallback.onFastJudgment(stDiscoveryDevice, i);
            }
        }
    }

    private BaseJudgment getJudgment(String str) {
        Map<String, BaseJudgment> map = this.mJudgmentMap;
        if (map == null) {
            return this.mJudgment;
        }
        BaseJudgment baseJudgment = map.get(str);
        return baseJudgment == null ? this.mJudgment : baseJudgment;
    }

    public void addPairRecord(StDiscoveryDevice stDiscoveryDevice) {
        byte beaconId = stDiscoveryDevice.getBeaconId();
        String identifier2String = stDiscoveryDevice.getIdentifier2String();
        this.mPairRecords.put(identifier2String, Integer.valueOf(beaconId));
        StLog.d(TAG, "addPairRecord id = " + beaconId + " device id = " + identifier2String);
    }

    public void clearPairRecord() {
        this.mPairRecords.clear();
    }

    public int getFastPairStatus(StDiscoveryDevice stDiscoveryDevice) {
        IJudgmentCallback iJudgmentCallback = this.mCallback;
        if (iJudgmentCallback == null) {
            return -1;
        }
        return iJudgmentCallback.fastPairStatus(stDiscoveryDevice);
    }

    @NonNull
    public Handler getHandler() {
        return this.mHandler;
    }

    public int getPairRecord(String str) {
        Integer num = this.mPairRecords.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public boolean handleNotify(StDiscoveryDevice stDiscoveryDevice) {
        byte beaconId = stDiscoveryDevice.getBeaconId();
        if (beaconId == FastPairRecord.getInstance().getPairRecord(stDiscoveryDevice.getIdentifier())) {
            StLog.d(TAG, " handleNotify beaconId repeat, beaconId = " + beaconId);
            return true;
        }
        StLog.d(TAG, "start handleNotifyAdv, beaconID =" + beaconId);
        FastPairRecord.getInstance().addPairRecord(stDiscoveryDevice.getIdentifier(), beaconId);
        if (stDiscoveryDevice.getDeviceDetail() != null) {
            byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) -1);
            if (bArr == null || bArr.length < 1) {
                StLog.e(TAG, "handleNotify ,customData is empty");
            } else if (bArr[0] != 1) {
                StLog.d(TAG, "ADV_MODE_NOTIFY_STARRY error cmd:" + bArr[0]);
            } else if (bArr.length <= 6) {
                StLog.d(TAG, "handleNotify customData length " + bArr.length + " is wrong");
            } else if (stDiscoveryDevice.getTerminalType() != 1) {
                return false;
            } else {
                IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
                if (discoveryManager == null) {
                    StLog.d(TAG, "handleNotify carDiscover is null");
                    return false;
                } else if (!ByteUtils.equals(Arrays.copyOfRange(bArr, 1, 7), StarryNetData.getInstance().getOwnDevice().getIdentifier())) {
                    StLog.d(TAG, "handleNotify peerMac not equal own deviceIdentifier");
                    return false;
                } else {
                    discoveryManager.requestConnect(stDiscoveryDevice.getIdentifier(), 0);
                }
            }
        }
        return false;
    }

    public boolean isJudged(StDiscoveryDevice stDiscoveryDevice) {
        return getPairRecord(stDiscoveryDevice.getIdentifier2String()) == stDiscoveryDevice.getBeaconId();
    }

    public void removePairRecord(String str) {
        this.mPairRecords.remove(str);
    }

    public void sendResult(StDiscoveryDevice stDiscoveryDevice, int i) {
        Message.obtain(this.mHandler, i, stDiscoveryDevice).sendToTarget();
    }

    public boolean startAppFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice == null) {
            return false;
        }
        return getJudgment(stDiscoveryDevice.getModelID()).needOfflineRemoveBond(stDiscoveryDevice);
    }

    public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice == null) {
            return false;
        }
        return getJudgment(stDiscoveryDevice.getModelID()).startFastPair(stDiscoveryDevice);
    }

    public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice == null) {
            return false;
        }
        return getJudgment(stDiscoveryDevice.getModelID()).startLocalFastPair(stDiscoveryDevice);
    }

    public boolean startRequestConnect(StDiscoveryDevice stDiscoveryDevice) {
        return false;
    }
}
