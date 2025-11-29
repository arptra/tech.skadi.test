package com.upuphone.starrynet.strategy.channel.uup;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;

public interface IUupShareCallback {
    GoInfo getGoInfo();

    void onBleMasterConnected(StDevice stDevice);

    void onBleSlaveConnected(UupShareInfo uupShareInfo, String str);
}
