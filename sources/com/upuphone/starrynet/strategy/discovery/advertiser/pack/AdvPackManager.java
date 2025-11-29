package com.upuphone.starrynet.strategy.discovery.advertiser.pack;

import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.base.IAdvPackHelper;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.v3.AdvertisePackHelperV3;

public class AdvPackManager {
    private static AdvertisePackHelperV3 mAdvertisePackHelperV3 = null;
    private static int mVersion = -1;

    public static IAdvPackHelper getPackHelper() {
        if (mVersion == -1) {
            mVersion = StarryNetData.getInstance().getVersionCode();
        }
        if (mVersion != 3) {
            return null;
        }
        if (mAdvertisePackHelperV3 == null) {
            mAdvertisePackHelperV3 = new AdvertisePackHelperV3();
        }
        return mAdvertisePackHelperV3;
    }
}
