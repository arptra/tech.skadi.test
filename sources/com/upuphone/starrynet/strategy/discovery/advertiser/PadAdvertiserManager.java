package com.upuphone.starrynet.strategy.discovery.advertiser;

import android.annotation.SuppressLint;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackManager;

@SuppressLint({"MissingPermission"})
public class PadAdvertiserManager extends AdvertiserManager {
    private static final String TAG = "PadAdvertiserManager";

    public synchronized void startPassiveAdv(int i, byte[] bArr, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startPadPassiveAdv");
            try {
                this.mAdvertiser.startAdvertising(getUnConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(24, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(24, bArr), getPassiveAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startPadPassiveAdv", (Throwable) e);
            }
        }
        return;
    }
}
