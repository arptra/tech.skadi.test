package com.here.odnp.util;

import android.net.TrafficStats;
import android.os.Process;

public class TrafficMonitor {
    public static final int UNSUPPORTED = -1;
    private long mRxBase;
    private long mTxBase;

    public TrafficMonitor() {
        reset();
    }

    public long getRxBytes() {
        if (-1 == this.mRxBase) {
            return -1;
        }
        return TrafficStats.getUidRxBytes(Process.myUid()) - this.mRxBase;
    }

    public long getTxBytes() {
        if (-1 == this.mTxBase) {
            return -1;
        }
        return TrafficStats.getUidTxBytes(Process.myUid()) - this.mTxBase;
    }

    public void reset() {
        this.mRxBase = TrafficStats.getUidRxBytes(Process.myUid());
        this.mTxBase = TrafficStats.getUidTxBytes(Process.myUid());
    }
}
