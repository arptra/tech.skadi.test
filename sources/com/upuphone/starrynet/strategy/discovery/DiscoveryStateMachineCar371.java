package com.upuphone.starrynet.strategy.discovery;

import android.content.Context;
import android.os.Looper;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.discovery.advertiser.AdvertiserManager;

public class DiscoveryStateMachineCar371 extends DiscoveryStateMachine {
    private static final String TAG = "DiscoveryStateMachineCar371";

    public DiscoveryStateMachineCar371(Context context, Looper looper, AdvertiserManager advertiserManager) {
        super(context, looper, advertiserManager);
    }

    public void startAdv(int i, byte[] bArr) {
        StLog.d(TAG, "startAdv");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.startAdv(i, bArr);
    }
}
