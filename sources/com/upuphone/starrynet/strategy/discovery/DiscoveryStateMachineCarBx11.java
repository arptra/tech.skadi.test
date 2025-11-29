package com.upuphone.starrynet.strategy.discovery;

import android.content.Context;
import android.os.Looper;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.discovery.advertiser.AdvertiserManager;

public class DiscoveryStateMachineCarBx11 extends DiscoveryStateMachine {
    private static final String TAG = "DiscoveryStateMachineCarBx11";

    public DiscoveryStateMachineCarBx11(Context context, Looper looper, AdvertiserManager advertiserManager) {
        super(context, looper, advertiserManager);
    }

    public void resetScanRecord() {
        StLog.d(TAG, "resetScanRecord");
        this.recordScanMode = -1;
    }
}
