package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDlnaServerOperator;
import com.upuphone.xr.interconnect.api.glass.StarryNetDlna;
import com.upuphone.xr.interconnect.entity.StarryDlnaMediaInfo;
import com.upuphone.xr.interconnect.listener.DlnaEventListener;

class InnerDlnaServerOperator implements StarryNetDlnaServerOperator {
    private StarryNetDlna mStarryNetDlna = InterconnectManager.getInstance().getStarryNetDlna();

    public void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo) {
        this.mStarryNetDlna.getDlnaInfo(starryDlnaMediaInfo);
    }

    public void registerDlnaEvent(DlnaEventListener dlnaEventListener) {
        this.mStarryNetDlna.registerDlnaEvent(dlnaEventListener);
    }

    public void registerStartPlayerAction(String str) {
        this.mStarryNetDlna.registerStartPlayerAction(str);
    }

    public void setNotifyConfig(int i, int i2) {
        this.mStarryNetDlna.setNotifyConfig(i, i2);
    }

    public void startDlnaService(String str) {
        this.mStarryNetDlna.startDlnaService(str);
    }

    public void stopDlnaService() {
        this.mStarryNetDlna.stopDlnaService();
    }

    public void stopPlay() {
        this.mStarryNetDlna.stopPlay();
    }

    public void syncLocalPause() {
        this.mStarryNetDlna.syncLocalPause();
    }

    public void syncLocalPlay() {
        this.mStarryNetDlna.syncLocalPlay();
    }

    public void syncRemoteSetVolume() {
        this.mStarryNetDlna.syncRemoteSetVolume();
    }

    public void unregisterDlnaEvent() {
        this.mStarryNetDlna.unregisterDlnaEvent();
    }
}
