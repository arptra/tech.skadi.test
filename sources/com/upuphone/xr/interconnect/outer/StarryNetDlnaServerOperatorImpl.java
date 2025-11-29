package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.api.StarryNetDlnaServerOperator;
import com.upuphone.xr.interconnect.common.IDlnaServer;
import com.upuphone.xr.interconnect.entity.StarryDlnaMediaInfo;
import com.upuphone.xr.interconnect.listener.DlnaEventListener;

public class StarryNetDlnaServerOperatorImpl implements StarryNetDlnaServerOperator, SuperServiceStateListener {
    private SuperServiceProvider mProvider;

    public void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo) {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.getDlnaInfo(starryDlnaMediaInfo);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceConnected() {
    }

    public void onServiceDied() {
    }

    public void registerDlnaEvent(DlnaEventListener dlnaEventListener) {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.registerDlnaEvent(dlnaEventListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerStartPlayerAction(String str) {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.registerStartPlayerAction(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNotifyConfig(int i, int i2) {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.setNotifyConfig(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public void startDlnaService(String str) {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.startDlnaService(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopDlnaService() {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.stopDlnaService();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopPlay() {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.stopPlay();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncLocalPause() {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.syncLocalPause();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncLocalPlay() {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.syncLocalPlay();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void syncRemoteSetVolume() {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.syncRemoteSetVolume();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void unregisterDlnaEvent() {
        IDlnaServer iDlnaServer = this.mProvider.getIDlnaServer();
        if (iDlnaServer != null) {
            try {
                iDlnaServer.unregisterDlnaEvent();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
