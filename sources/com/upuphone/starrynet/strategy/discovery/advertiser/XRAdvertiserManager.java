package com.upuphone.starrynet.strategy.discovery.advertiser;

import android.annotation.SuppressLint;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackManager;

@SuppressLint({"MissingPermission"})
public class XRAdvertiserManager extends AdvertiserManager {
    private static final String TAG = "XRAdvertiserManager";

    public synchronized void startPassiveAdv(int i, byte[] bArr, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startARPassiveAdv point_ble_adv_set");
            try {
                this.mAdvertiser.startAdvertising(getConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(21, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(21), getPassiveAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startARPassiveAdv", (Throwable) e);
            }
        }
        return;
    }
}
