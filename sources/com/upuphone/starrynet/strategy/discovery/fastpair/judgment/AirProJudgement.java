package com.upuphone.starrynet.strategy.discovery.fastpair.judgment;

import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;

public class AirProJudgement extends StarJudgment {
    private static final int RSSI_FAST_PAIR_MIN = -70;
    private static final int RSSI_UN_BOND_MIN = -70;
    protected static final String TAG = "AirProJudgement";

    public AirProJudgement(FastPairJudgment fastPairJudgment, String str) {
        super(fastPairJudgment, str);
    }

    public /* bridge */ /* synthetic */ void dealDelayJudgment(StDiscoveryDevice stDiscoveryDevice, int i, int i2) {
        super.dealDelayJudgment(stDiscoveryDevice, i, i2);
    }

    public /* bridge */ /* synthetic */ void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice) {
        super.dealFastPairJudgment(stDiscoveryDevice);
    }

    public int getRssiFastPairMin() {
        return -70;
    }

    public int getRssiUnBondMin() {
        return -70;
    }

    public /* bridge */ /* synthetic */ boolean needOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice) {
        return super.needOfflineRemoveBond(stDiscoveryDevice);
    }

    public /* bridge */ /* synthetic */ boolean startFastPair(StDiscoveryDevice stDiscoveryDevice) {
        return super.startFastPair(stDiscoveryDevice);
    }

    public /* bridge */ /* synthetic */ boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice) {
        return super.startLocalFastPair(stDiscoveryDevice);
    }
}
