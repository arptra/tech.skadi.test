package com.upuphone.starrynet.strategy.discovery.fastpair.judgment;

class AirJudgement extends StarJudgment {
    private static final int RSSI_FAST_PAIR_MIN = -50;
    private static final int RSSI_FAST_PAIR_MIN_3004 = -50;
    private static final int RSSI_UN_BOND_MIN = -41;
    private static final int RSSI_UN_BOND_MIN_3004 = -41;
    protected static final String TAG = "AirJudgement";

    public AirJudgement(FastPairJudgment fastPairJudgment, String str) {
        super(fastPairJudgment, str);
    }

    public int getRssiFastPairMin() {
        "3004".equals(this.mModelId);
        return -50;
    }

    public int getRssiUnBondMin() {
        "3004".equals(this.mModelId);
        return -41;
    }
}
