package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.glass.StarryNetDlna;
import com.upuphone.xr.interconnect.common.IDlnaEvent;
import com.upuphone.xr.interconnect.common.IDlnaServer;
import com.upuphone.xr.interconnect.entity.StarryDlnaMediaInfo;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;

public class DlnaServerImpl extends IDlnaServer.Stub {
    private final StarryNetDlna dlna;

    public DlnaServerImpl() {
        StarryNetDlna starryNetDlna = InterconnectManager.getInstance().getStarryNetDlna();
        this.dlna = starryNetDlna;
        IpcClientManager.INSTANCE.addListener(starryNetDlna);
    }

    public void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo) throws RemoteException {
        this.dlna.getDlnaInfo(starryDlnaMediaInfo);
    }

    public void registerDlnaEvent(IDlnaEvent iDlnaEvent) throws RemoteException {
        this.dlna.registerDlnaEvent(iDlnaEvent);
    }

    public void registerStartPlayerAction(String str) throws RemoteException {
        this.dlna.registerStartPlayerAction(str);
    }

    public void setNotifyConfig(int i, int i2) throws RemoteException {
        this.dlna.setNotifyConfig(i, i2);
    }

    public void startDlnaService(String str) throws RemoteException {
        this.dlna.startDlnaService(str);
    }

    public void stopDlnaService() throws RemoteException {
        this.dlna.stopDlnaService();
    }

    public void stopPlay() throws RemoteException {
        this.dlna.stopPlay();
    }

    public void syncLocalPause() throws RemoteException {
        this.dlna.syncLocalPause();
    }

    public void syncLocalPlay() throws RemoteException {
        this.dlna.syncLocalPlay();
    }

    public void syncRemoteSetVolume() throws RemoteException {
        this.dlna.syncRemoteSetVolume();
    }

    public void unregisterDlnaEvent() throws RemoteException {
        this.dlna.unregisterDlnaEvent();
    }
}
