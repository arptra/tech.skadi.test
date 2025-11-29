package com.upuphone.starrynet.strategy.pair;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IPairMsgCallback {
    void onResponse(StDevice stDevice, byte[] bArr, int i);
}
