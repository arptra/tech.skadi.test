package com.upuphone.starrynet.strategy.discovery.advertiser.pack.base;

import android.bluetooth.le.AdvertiseData;

public class AbsAdvPackHelper implements IAdvPackHelper {
    public AdvertiseData getAdvertiseData(int i, int i2) {
        return new AdvertiseData.Builder().build();
    }

    public AdvertiseData getRspAdvertiseData(int i) {
        return new AdvertiseData.Builder().build();
    }

    public boolean initUserId(byte[] bArr) {
        return false;
    }

    public void setAbility(short s) {
    }

    public AdvertiseData getRspAdvertiseData(int i, byte[] bArr) {
        return new AdvertiseData.Builder().build();
    }
}
