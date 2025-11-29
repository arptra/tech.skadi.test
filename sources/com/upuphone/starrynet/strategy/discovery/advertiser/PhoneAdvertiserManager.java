package com.upuphone.starrynet.strategy.discovery.advertiser;

import android.annotation.SuppressLint;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackManager;

@SuppressLint({"MissingPermission"})
public class PhoneAdvertiserManager extends AdvertiserManager {
    private static final String TAG = "PhoneAdvertiserManager";

    public synchronized void startActiveAdv(int i, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startPhoneActiveAdv");
            try {
                this.mAdvertiser.startAdvertising(getUnConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(12, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(12), getActiveAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startPhoneActiveAdv", (Throwable) e);
            }
        }
        return;
    }

    public synchronized void startPassiveAdv(int i, byte[] bArr, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startPhonePassiveAdv");
            try {
                this.mAdvertiser.startAdvertising(getUnConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(24, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(24, bArr), getPassiveAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startPhonePassiveAdv", (Throwable) e);
            }
        }
        return;
    }
}
