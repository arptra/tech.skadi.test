package com.ucar.vehiclesdk.connect;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.easy.logger.EasyLog;
import com.meizu.common.widget.MzContactsContract;
import com.share.connect.IShareLinkManager;
import com.share.connect.ShareLinkObserver;
import com.share.connect.utils.RandomCodeGenerator;
import com.ucar.vehiclesdk.MDevice;
import com.ucar.vehiclesdk.UCarCommon;
import java.util.Timer;
import java.util.TimerTask;

public class UCarConnectProxy {

    /* renamed from: a  reason: collision with root package name */
    public Context f5421a;
    public boolean b;
    public IShareLinkManager c;
    public IConnectCallback d;
    public String e;
    public String f;
    public MDevice g;
    public Timer h;
    public volatile boolean i;
    public ShareLinkObserver.Stub j;

    /* renamed from: com.ucar.vehiclesdk.connect.UCarConnectProxy$1  reason: invalid class name */
    public class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UCarConnectProxy f5422a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            EasyLog.a("UCarConnectProxy", "share link service connected.");
            IShareLinkManager unused = this.f5422a.c = IShareLinkManager.Stub.asInterface(iBinder);
            try {
                if (!this.f5422a.b) {
                    this.f5422a.c.registerLinkObserver(this.f5422a.j);
                    boolean unused2 = this.f5422a.b = true;
                }
                if (this.f5422a.d != null) {
                    EasyLog.a("UCarConnectProxy", "notify share link service connected");
                    this.f5422a.d.d();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            EasyLog.i("UCarConnectProxy", "share link service disconnected.");
            boolean unused = this.f5422a.b = false;
            if (this.f5422a.c != null) {
                if (this.f5422a.d != null) {
                    EasyLog.a("UCarConnectProxy", "notify share link service disconnected");
                    this.f5422a.d.b();
                }
                try {
                    this.f5422a.c.unregisterLinkObserver(this.f5422a.j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.ucar.vehiclesdk.connect.UCarConnectProxy$3  reason: invalid class name */
    class AnonymousClass3 extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UCarConnectProxy f5423a;

        public void run() {
            String unused = this.f5423a.e = RandomCodeGenerator.a(6);
            try {
                this.f5423a.c.updatePinCode(this.f5423a.e);
                if (this.f5423a.d != null && this.f5423a.f != null) {
                    EasyLog.e("UCarConnectProxy", "notify pin code to car app");
                    this.f5423a.d.a(this.f5423a.e, this.f5423a.f);
                }
            } catch (RemoteException e) {
                this.f5423a.t(7);
                EasyLog.d("UCarConnectProxy", "updatePinCode failed", e);
            }
        }
    }

    public void A(int i2) {
        IShareLinkManager iShareLinkManager = this.c;
        if (iShareLinkManager != null) {
            try {
                iShareLinkManager.updateDayOrNightMode(i2);
            } catch (RemoteException e2) {
                EasyLog.d("UCarConnectProxy", "updateDayOrNightMode RemoteException", e2);
            }
        }
    }

    public void q() {
        IShareLinkManager iShareLinkManager = this.c;
        if (iShareLinkManager != null) {
            try {
                iShareLinkManager.close();
            } catch (RemoteException e2) {
                EasyLog.d("UCarConnectProxy", "close RemoteException", e2);
            }
        }
    }

    public void r() {
        IShareLinkManager iShareLinkManager = this.c;
        if (iShareLinkManager != null) {
            try {
                iShareLinkManager.disconnect();
            } catch (RemoteException e2) {
                EasyLog.d("UCarConnectProxy", "disconnect Exception", e2);
            }
        }
    }

    public MDevice s(String str) {
        EasyLog.a("UCarConnectProxy", "getMDevice, mMDevice: " + this.g);
        return this.g;
    }

    public final void t(int i2) {
        EasyLog.e("UCarConnectProxy", "handleConnectFailed, reason: " + i2);
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 8:
                u(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_UNKNOW);
                return;
            case 5:
                u(10004);
                return;
            case 6:
            case 7:
                u(10008);
                return;
            default:
                return;
        }
    }

    public final void u(int i2) {
        IConnectCallback iConnectCallback = this.d;
        if (iConnectCallback != null) {
            iConnectCallback.g(this.g.getId(), i2);
        }
    }

    public final void v(int i2) {
        IConnectCallback iConnectCallback = this.d;
        if (iConnectCallback != null) {
            iConnectCallback.f(this.g.getId(), i2);
        }
    }

    public final int w(int i2) {
        IConnectCallback iConnectCallback = this.d;
        return iConnectCallback != null ? iConnectCallback.onSelectWorkMode(i2) : UCarCommon.WorkMode.c.k();
    }

    public final void x(boolean z) {
        IConnectCallback iConnectCallback = this.d;
        if (iConnectCallback != null) {
            iConnectCallback.onUserInterventionNeeded(z);
        }
    }

    public boolean y() {
        if (this.c == null) {
            EasyLog.c("UCarConnectProxy", "stopAdvertise failed, mShareLinkManager is null");
            return false;
        }
        EasyLog.a("UCarConnectProxy", "stopAdvertise");
        z();
        try {
            this.c.stopAdvertise();
            this.i = true;
            return true;
        } catch (RemoteException e2) {
            EasyLog.d("UCarConnectProxy", "stopAdvertise failed", e2);
            return false;
        }
    }

    public final void z() {
        Timer timer = this.h;
        if (timer != null) {
            timer.cancel();
            this.h = null;
        }
    }
}
