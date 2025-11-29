package com.upuphone.starrynet.strategy.discovery.advertiser;

import android.annotation.SuppressLint;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackManager;

@SuppressLint({"MissingPermission"})
public class CarAdvertiserManager extends AdvertiserManager {
    public static final String TAG = "CarAdvertiserManager";

    public synchronized void startActiveAdv(int i, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startCarActiveAdv");
            try {
                this.mAdvertiser.startAdvertising(getConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(11, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(11), getActiveAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startCarActiveAdv", (Throwable) e);
            }
        }
        return;
    }

    public synchronized void startPassiveAdv(int i, byte[] bArr, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startCarPassiveAdv");
            try {
                this.mAdvertiser.startAdvertising(getConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(23, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(23, bArr), getPassiveAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startCarPassiveAdv", (Throwable) e);
            }
        }
        return;
    }
}
