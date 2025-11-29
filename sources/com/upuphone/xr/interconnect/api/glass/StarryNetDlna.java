package com.upuphone.xr.interconnect.api.glass;

import android.content.Context;
import com.upuphone.xr.interconnect.common.IDlnaEvent;
import com.upuphone.xr.interconnect.entity.StarryDlnaMediaInfo;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;

public interface StarryNetDlna extends BinderClientDiedCallback {
    void attachDlnaBridge(Context context);

    void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo);

    void registerDlnaEvent(IDlnaEvent iDlnaEvent);

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
