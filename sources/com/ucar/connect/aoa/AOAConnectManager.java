package com.ucar.connect.aoa;

import android.content.Context;
import android.util.SparseArray;
import com.easy.logger.EasyLog;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.util.ByteConvert;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class AOAConnectManager {
    public static final AOAConnectManager m = new AOAConnectManager();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f9620a = new SparseArray();
    public volatile boolean b = false;
    public volatile boolean c = false;
    public volatile boolean d = true;
    public final AtomicBoolean e = new AtomicBoolean(true);
    public Context f = null;
    public AOAConnectThread g = null;
    public AOAReadThread h = null;
    public AOAConnectListener i = null;
    public Timer j;
    public TimerTask k;
    public AOAAccessoryReceiver l;

    public interface AOAConnectListener {
        void a(String str, String str2);

        void b();

        void c();

        void d();
    }

    public static class AOAConnectThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9622a = true;

        public AOAConnectThread() {
            EasyLog.a("AOAConnectManager", "AOAConnectThread Created");
            setName("AOAConnectThread");
        }

        public void a() {
            this.f9622a = false;
        }

        public void run() {
            EasyLog.a("AOAConnectManager", "Begin to connect UCar by AOA");
            AOAHostSetup.m().s();
            while (this.f9622a) {
                try {
                    if (AOAHostSetup.m().E()) {
                        EasyLog.c("AOAConnectManager", "UCar connect exit");
                        return;
                    }
                    Thread.sleep(500);
                } catch (Exception e) {
                    EasyLog.d("AOAConnectManager", "Exception when connect UCar by AOA", e);
                    return;
                }
            }
            EasyLog.c("AOAConnectManager", "UCar Connect Cancelled");
        }
    }

    public class AOAReadThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9623a = true;
        public byte[] b = new byte[8];
        public final byte[] c = new byte[8];

        public AOAReadThread() {
            EasyLog.a("AOAConnectManager", "AOAReadThread Created");
            setName("AOAReadThread");
        }

        public void a() {
            this.f9623a = false;
        }

        public void run() {
            EasyLog.a("AOAConnectManager", "Begin to read data by AOA");
            while (this.f9623a) {
                try {
                    int b2 = AOAHostSetup.m().b(this.c, 8);
                    if (b2 < 0) {
                        EasyLog.c("AOAConnectManager", "head bulkTransferIn fail");
                        return;
                    } else if (b2 != 0) {
                        int a2 = ByteConvert.a(this.c, 0);
                        int a3 = ByteConvert.a(this.c, 4);
                        if (a2 >= 1 && a2 <= 240 && a3 >= 0) {
                            if (a3 <= 67108864) {
                                int max = Math.max(a3, 8);
                                if (this.b.length < max) {
                                    this.b = new byte[max];
                                }
                                if (AOAHostSetup.m().b(this.b, max) < 0) {
                                    EasyLog.c("AOAConnectManager", "body bulkTransferIn fail");
                                    return;
                                } else if (a2 == 1) {
                                    AOAConnectManager.this.j(this.b, a3);
                                } else {
                                    SocketReadThread c2 = AOAConnectManager.this.i(a2);
                                    if (c2 != null) {
                                        c2.v(this.b, 0, a3);
                                    } else {
                                        EasyLog.i("AOAConnectManager", "AOAReadThread channelId " + a2 + " not found read thread");
                                    }
                                }
                            }
                        }
                        EasyLog.c("AOAConnectManager", "channelId or lenMsg is error");
                        return;
                    }
                } catch (Exception e) {
                    EasyLog.d("AOAConnectManager", "Exception when read data by AOA", e);
                    return;
                }
            }
        }
    }

    public static AOAConnectManager h() {
        return m;
    }

    public final void A(int i2, String str, int i3, int i4) {
        try {
            LocalClientSocketReadThread localClientSocketReadThread = new LocalClientSocketReadThread(i2, str, i3, i4);
            localClientSocketReadThread.start();
            localClientSocketReadThread.t();
            this.f9620a.append(i2, localClientSocketReadThread);
        } catch (Exception e2) {
            EasyLog.d("AOAConnectManager", "Start ClientSocketRead Thread Fail", e2);
        }
    }

    public final void B(int i2, String str, int i3) {
        try {
            LocalServerSocketReadThread localServerSocketReadThread = new LocalServerSocketReadThread(i2, str, i3);
            localServerSocketReadThread.start();
            localServerSocketReadThread.t();
            this.f9620a.append(i2, localServerSocketReadThread);
        } catch (Exception e2) {
            EasyLog.d("AOAConnectManager", "Start ServerSocketRead Thread Fail", e2);
        }
    }

    public void C() {
        AOAAccessoryReceiver aOAAccessoryReceiver = this.l;
        if (aOAAccessoryReceiver != null) {
            aOAAccessoryReceiver.a();
        }
        x();
    }

    public void D() {
        EasyLog.a("AOAConnectManager", "stopAOAConnectThread");
        try {
            AOAConnectThread aOAConnectThread = this.g;
            if (aOAConnectThread != null) {
                aOAConnectThread.a();
                this.g = null;
            }
        } catch (Exception e2) {
            EasyLog.d("AOAConnectManager", "Stop AOAConnectThread Fail", e2);
        }
    }

    public void E() {
        try {
            AOAReadThread aOAReadThread = this.h;
            if (aOAReadThread != null) {
                aOAReadThread.a();
                this.h = null;
            }
        } catch (Exception e2) {
            EasyLog.d("AOAConnectManager", "Stop AOAReadThread Fail", e2);
        }
    }

    public synchronized void F() {
        try {
            this.b = false;
            for (int i2 = 0; i2 < this.f9620a.size(); i2++) {
                SocketReadThread socketReadThread = (SocketReadThread) this.f9620a.valueAt(i2);
                if (socketReadThread != null) {
                    socketReadThread.b();
                }
            }
            this.f9620a.clear();
        } catch (Exception e2) {
            EasyLog.d("AOAConnectManager", "Stop SocketRead Thread Fail", e2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void G() {
        AOAAccessoryReceiver aOAAccessoryReceiver = this.l;
        if (aOAAccessoryReceiver != null) {
            aOAAccessoryReceiver.b();
        }
        D();
    }

    public void d() {
        if (this.j != null) {
            EasyLog.a("AOAConnectManager", "cancel connect timer");
            this.j.cancel();
            this.k = null;
            this.j = null;
        }
    }

    public final void e() {
        if (!this.b) {
            for (int i2 = 0; i2 < this.f9620a.size(); i2++) {
                if (((SocketReadThread) this.f9620a.valueAt(i2)) == null) {
                    EasyLog.a("AOAConnectManager", "null read thread port at " + this.f9620a.keyAt(i2));
                    return;
                }
            }
            EasyLog.a("AOAConnectManager", "all needed default socket ready ");
            z();
            h().o();
            this.b = true;
        }
    }

    public void f() {
        EasyLog.a("AOAConnectManager", "deInit");
        D();
        E();
        F();
        AOAHostSetup.m().k();
    }

    public final String g(int i2) {
        return ChannelType.fromPort(i2).name();
    }

    public final synchronized SocketReadThread i(int i2) {
        for (int i3 = 0; i3 < this.f9620a.size(); i3++) {
            SocketReadThread socketReadThread = (SocketReadThread) this.f9620a.valueAt(i3);
            if (socketReadThread != null && socketReadThread.d() == i2) {
                return socketReadThread;
            }
        }
        return null;
    }

    public final synchronized void j(byte[] bArr, int i2) {
        if (i2 == 10) {
            try {
                int a2 = ByteConvert.a(bArr, 0);
                int a3 = ByteConvert.a(bArr, 4);
                int b2 = ByteConvert.b(bArr, 8);
                int b3 = ByteConvert.b(bArr, 9);
                EasyLog.a("AOAConnectManager", "received create socket msg, port " + a2 + " channelId" + a3 + " socketType" + b2 + " channelMsgType" + b3);
                if (b2 == 1) {
                    if (a3 != -1) {
                        EasyLog.i("AOAConnectManager", "Expect received sever socket channel id is -1, but received " + a3);
                    }
                    if (this.f9620a.get(a2) == null) {
                        B(a2, g(a2), b3);
                    }
                    e();
                } else if (b2 == 2) {
                    A(a2, g(a2), a3, b3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Context context2 = context;
        EasyLog.a("AOAConnectManager", "init");
        if (this.f == null) {
            this.f = context2;
            AOAHostSetup.m().r(this.f, str, str2, str3, str4, str5, str6);
            this.l = new AOAAccessoryReceiver(context);
        }
    }

    public final void l() {
        this.k = new TimerTask() {
            public void run() {
                EasyLog.a("AOAConnectManager", "connect time out, no device attached");
                AOAConnectManager.this.n();
            }
        };
        this.j = new Timer();
    }

    public void m() {
        EasyLog.a("AOAConnectManager", "notify connect error");
        this.c = false;
        AOAHostSetup.m().A();
        if (this.d) {
            n();
        }
    }

    public final void n() {
        EasyLog.a("AOAConnectManager", "notify disconnected, is connect right: " + this.c);
        if (!this.c && this.e.compareAndSet(false, true)) {
            f();
            AOAConnectListener aOAConnectListener = this.i;
            if (aOAConnectListener != null) {
                aOAConnectListener.c();
            }
        }
    }

    public void o() {
        this.c = true;
        AOAConnectListener aOAConnectListener = this.i;
        if (aOAConnectListener != null) {
            aOAConnectListener.d();
        }
    }

    public void p(int i2, int i3, int i4, int i5) {
        EasyLog.a("AOAConnectManager", "send create socket msg, port " + i2 + " channelId " + i3 + " socketType " + i4 + " channelMsgType " + i5);
        byte[] bArr = new byte[8];
        byte[] bArr2 = new byte[10];
        System.arraycopy(ByteConvert.d(1), 0, bArr, 0, 4);
        System.arraycopy(ByteConvert.d(10), 0, bArr, 4, 4);
        System.arraycopy(ByteConvert.d(i2), 0, bArr2, 0, 4);
        System.arraycopy(ByteConvert.d(i3), 0, bArr2, 4, 4);
        System.arraycopy(ByteConvert.e(i4), 0, bArr2, 8, 1);
        System.arraycopy(ByteConvert.e(i5), 0, bArr2, 9, 1);
        if (AOAHostSetup.m().e(bArr, 8, bArr2, 10) < 0) {
            EasyLog.c("AOAConnectManager", "bulkTransferOut create socket msg failed");
        }
    }

    public void q() {
        this.d = false;
        this.e.set(false);
        y();
        AOAConnectListener aOAConnectListener = this.i;
        if (aOAConnectListener != null) {
            aOAConnectListener.b();
        }
        D();
    }

    public void r() {
        this.d = true;
        n();
    }

    public void s(String str, String str2) {
        AOAConnectListener aOAConnectListener = this.i;
        if (aOAConnectListener != null) {
            aOAConnectListener.a(str, str2);
        }
    }

    public final void t() {
        F();
        synchronized (this) {
            this.f9620a.put(ChannelType.RTSP.getPort(), (Object) null);
            this.f9620a.put(ChannelType.UIBC.getPort(), (Object) null);
        }
    }

    public void u(int i2, boolean z) {
        p(i2, -1, 1, z ? 1 : 2);
    }

    public void v() {
        l();
        if (this.j != null) {
            EasyLog.a("AOAConnectManager", "schedule cancel connect timer");
            this.j.schedule(this.k, AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    public void w(AOAConnectListener aOAConnectListener) {
        this.i = aOAConnectListener;
    }

    public void x() {
        EasyLog.a("AOAConnectManager", "startAOAConnectThread, mAOAConnectThread:" + this.g);
        try {
            AOAConnectThread aOAConnectThread = this.g;
            if (aOAConnectThread != null) {
                if (aOAConnectThread.isAlive()) {
                    EasyLog.a("AOAConnectManager", "mAOAConnectThread is alive, not need recreate. ");
                    return;
                }
            }
            AOAConnectThread aOAConnectThread2 = new AOAConnectThread();
            this.g = aOAConnectThread2;
            aOAConnectThread2.start();
        } catch (Exception e2) {
            EasyLog.d("AOAConnectManager", "Start AOAConnectThread Fail", e2);
        }
    }

    public void y() {
        try {
            t();
            AOAReadThread aOAReadThread = new AOAReadThread();
            this.h = aOAReadThread;
            aOAReadThread.start();
        } catch (Exception e2) {
            EasyLog.d("AOAConnectManager", "Start AOAReadThread Fail", e2);
        }
    }

    public void z() {
        p(ChannelType.RTP.getPort(), -1, 1, 2);
    }
}
