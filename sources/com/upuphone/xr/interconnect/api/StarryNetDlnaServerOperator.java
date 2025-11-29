package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.StarryDlnaMediaInfo;
import com.upuphone.xr.interconnect.listener.DlnaEventListener;

public interface StarryNetDlnaServerOperator {
    void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo);

    void registerDlnaEvent(DlnaEventListener dlnaEventListener);

    void registerStartPlayerAction(String str);

    void setNotifyConfig(int i, int i2);

    void startDlnaService(String str);

    void stopDlnaService();

    void stopPlay();

    void syncLocalPause();

    void syncLocalPlay();

    void syncRemoteSetVolume();

    void unregisterDlnaEvent();
}
