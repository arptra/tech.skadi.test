package com.upuphone.starrynet.strategy.data;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IAuthCallback {
    void onAuth(StDevice stDevice);

    void onAuthMessage(StDevice stDevice, byte[] bArr);
}
