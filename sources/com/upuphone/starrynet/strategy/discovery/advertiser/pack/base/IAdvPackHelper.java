package com.upuphone.starrynet.strategy.discovery.advertiser.pack.base;

import android.bluetooth.le.AdvertiseData;

public interface IAdvPackHelper {
    AdvertiseData getAdvertiseData(int i, int i2);

    AdvertiseData getRspAdvertiseData(int i);

    AdvertiseData getRspAdvertiseData(int i, byte[] bArr);

    boolean initUserId(byte[] bArr);

    void setAbility(short s);
}
