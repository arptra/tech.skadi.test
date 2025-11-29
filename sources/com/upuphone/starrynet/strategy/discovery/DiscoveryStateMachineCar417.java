package com.upuphone.starrynet.strategy.discovery;

import android.content.Context;
import android.os.Looper;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.discovery.advertiser.AdvertiserManager;

public class DiscoveryStateMachineCar417 extends DiscoveryStateMachine {
    private static final String TAG = "DiscoveryStateMachineCar417";

    public DiscoveryStateMachineCar417(Context context, Looper looper, AdvertiserManager advertiserManager) {
        super(context, looper, advertiserManager);
    }

    private void reStartScanAfterAdv() {
        sendMessage(9);
    }

    private void stopScanBeforeAdv() {
        this.mNeedScan = false;
        if (this.mIsScanning) {
            stopHighScan();
        }
        if (this.mIsLowPowerScanning) {
            stopLowScan();
        }
    }

    public void startAdv(int i, byte[] bArr) {
        StLog.d(TAG, "startAdv");
        stopScanBeforeAdv();
        super.startAdv(i, bArr);
        reStartScanAfterAdv();
    }
}
