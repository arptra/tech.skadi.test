package com.upuphone.starrynet.strategy.discovery.fastpair;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class FastPairRecord {
    private static final String TAG = "FastPairRecord";
    private List<String> mActiveDisconnectPad;
    private boolean mIsNotify;
    private final HashMap<String, Integer> mPairRecords;

    public static final class Holder {
        /* access modifiers changed from: private */
        public static final FastPairRecord INSTANCE = new FastPairRecord();

        private Holder() {
        }
    }

    public static FastPairRecord getInstance() {
        return Holder.INSTANCE;
    }

    public void addPairRecord(byte[] bArr, int i) {
        this.mPairRecords.put(Utils.bytesToHexString(bArr), Integer.valueOf(i));
    }

    public void clearPairRecord() {
        this.mPairRecords.clear();
    }

    public boolean getNotifyLabel() {
        return this.mIsNotify;
    }

    public int getPairRecord(byte[] bArr) {
        Integer num = this.mPairRecords.get(Utils.bytesToHexString(bArr));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public boolean isActiveDisconnectPad(String str) {
        if (str == null) {
            return false;
        }
        return this.mActiveDisconnectPad.contains(str);
    }

    public void removeActiveDisconnectPad(String str) {
        if (str != null) {
            this.mActiveDisconnectPad.remove(str);
        }
    }

    public void removeAllActiveDisconnectPad() {
        this.mActiveDisconnectPad.clear();
    }

    public void removePairRecord(byte[] bArr) {
        this.mPairRecords.remove(Utils.bytesToHexString(bArr));
    }

    public void setActiveDisconnectPad(String str) {
        if (str != null && !this.mActiveDisconnectPad.contains(str)) {
            StLog.d(TAG, "setActiveDisconnectPad, deviceId = " + str);
            this.mActiveDisconnectPad.add(str);
        }
    }

    public void setNotifyLabel(boolean z) {
        this.mIsNotify = z;
    }

    private FastPairRecord() {
        this.mPairRecords = new HashMap<>();
        this.mActiveDisconnectPad = new ArrayList();
        this.mIsNotify = false;
    }
}
