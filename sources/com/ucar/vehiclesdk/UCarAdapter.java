package com.ucar.vehiclesdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.honey.account.h3.a;
import com.honey.account.h3.b;
import com.honey.account.h3.c;
import com.honey.account.h3.d;
import com.honey.account.h3.e;
import com.honey.account.h3.f;
import com.honey.account.h3.g;
import com.honey.account.h3.h;
import com.honey.account.h3.i;
import com.honey.account.h3.j;
import com.honey.account.h3.k;
import com.honey.account.h3.l;
import com.honey.account.h3.m;
import com.honey.account.h3.n;
import com.honey.account.h3.o;
import com.honey.account.h3.p;
import com.honey.account.h3.q;
import com.honey.account.h3.r;
import com.honey.account.h3.u;
import com.honey.account.h3.v;
import com.honey.account.h3.w;
import com.share.connect.WifiOwnerConfig;
import com.share.connect.ble.CarBluetoothMacRecord;
import com.share.connect.security.ServerKeyNegotiator;
import com.share.connect.utils.ShaUtil;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.SourceDevice;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.log.AndroidProtocolLogger;
import com.ucar.vehiclesdk.TimerManager;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.audio.UCarAudioManager;
import com.ucar.vehiclesdk.camera.CameraManager;
import com.ucar.vehiclesdk.cast.CastListener;
import com.ucar.vehiclesdk.cast.CastManager;
import com.ucar.vehiclesdk.common.UCarNotification;
import com.ucar.vehiclesdk.connect.IConnectCallback;
import com.ucar.vehiclesdk.connect.UCarConnectProxy;
import com.ucar.vehiclesdk.control.ControlManager;
import com.ucar.vehiclesdk.control.UibcManager;
import com.ucar.vehiclesdk.datacenter.CarCertManager;
import com.ucar.vehiclesdk.datacenter.SensorManager;
import com.ucar.vehiclesdk.test.TestClickActionThread;
import com.ucar.vehiclesdk.test.TestUtil;
import com.ucar.vehiclesdk.test.UCarApiTestThread;
import com.ucar.vehiclesdk.util.AudioTrackUtil;
import com.ucar.vehiclesdk.util.BitmapUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class UCarAdapter {
    public static final Map d0 = new HashMap() {
        {
            put(0, 0);
            put(1, 10);
            put(2, 20);
            put(3, 20);
            put(4, 30);
            put(5, 40);
            put(6, 40);
            put(7, 50);
            put(8, 60);
            put(9, 70);
            put(10, 80);
            put(11, 90);
            put(12, 100);
        }
    };
    public static volatile UCarAdapter e0;
    public final byte[] A = new byte[6];
    public boolean B;
    public boolean C;
    public int D = 0;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public AtomicBoolean H = new AtomicBoolean(false);
    public String I;
    public TimerManager J;
    public Handler K;
    public TestClickActionThread L;
    public UCarApiTestThread M;
    public CountDownLatch N = new CountDownLatch(1);
    public CountDownLatch O;
    public int P = 0;
    public int Q;
    public int R;
    public int S;
    public int T;
    public UCarCommon.VisibleRegion U;
    public String V;
    public String W;
    public int X = 0;
    public int Y = 0;
    public final Set Z = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public UCarConfig f5361a;
    public final CopyOnWriteArraySet a0 = new CopyOnWriteArraySet();
    public final ReentrantLock b = new ReentrantLock();
    public final AtomicBoolean b0 = new AtomicBoolean(true);
    public String c = "-1";
    public final Runnable c0 = new Runnable() {
        public void run() {
            EasyLog.i("UCarAdapter", "we need pause cast when app lifecycle event is not received with 3S after invoked app");
            if (UCarAdapter.this.o != null) {
                UCarAdapter.this.o.a();
            }
            UCarAdapter.this.Y1();
        }
    };
    public Handler d;
    public Handler e;
    public boolean f = false;
    public volatile boolean g = true;
    public boolean h;
    public Context i;
    public final List j = new CopyOnWriteArrayList();
    public final List k = new CopyOnWriteArrayList();
    public final List l = new CopyOnWriteArrayList();
    public ICarInitCallback m = null;
    public UCarConnectProxy n;
    public CastManager o;
    public ControlManager p;
    public UCarAudioManager q;
    public UibcManager r;
    public SensorManager s;
    public CarCertManager t;
    public CameraManager u;
    public int v;
    public int w;
    public int x;
    public int y;
    public final byte[] z = new byte[2];

    /* renamed from: com.ucar.vehiclesdk.UCarAdapter$3  reason: invalid class name */
    class AnonymousClass3 implements TimerManager.ITimeOutListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UCarAdapter f5363a;

        public void a() {
            EasyLog.a("UCarAdapter", "onHeartBeatTimeout");
            this.f5363a.e.post(new b(this));
        }

        public void b() {
            EasyLog.a("UCarAdapter", "onConnectTimeout");
            this.f5363a.e.post(new a(this));
        }

        public final /* synthetic */ void e() {
            UCarAdapter uCarAdapter = this.f5363a;
            uCarAdapter.W0(uCarAdapter.c, 10006);
            if (this.f5363a.n != null) {
                EasyLog.a("UCarAdapter", "connect time out, try stop advertise");
                this.f5363a.n.y();
                this.f5363a.n.q();
                this.f5363a.b.lock();
                UCarAdapter uCarAdapter2 = this.f5363a;
                MDevice C0 = uCarAdapter2.Q0(uCarAdapter2.c);
                if (C0.isWireless()) {
                    if (this.f5363a.D >= 20) {
                        EasyLog.a("UCarAdapter", "connect time out in cast phase (wireless), try disconnect link");
                        this.f5363a.n.r();
                    }
                } else if (C0.isWired() && this.f5363a.D >= 50) {
                    EasyLog.a("UCarAdapter", "connect time out in cast phase (usb), try disconnect link");
                    this.f5363a.n.r();
                }
                this.f5363a.b.unlock();
            }
        }

        public final /* synthetic */ void f() {
            if (this.f5363a.n != null) {
                EasyLog.a("UCarAdapter", "heart beat time out, try disconnect link");
                this.f5363a.n.r();
            }
        }
    }

    /* renamed from: com.ucar.vehiclesdk.UCarAdapter$5  reason: invalid class name */
    class AnonymousClass5 implements CastListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UCarAdapter f5365a;

        public void a(int i, int i2) {
            this.f5365a.E2(false, i, i2);
        }
    }

    /* renamed from: com.ucar.vehiclesdk.UCarAdapter$6  reason: invalid class name */
    class AnonymousClass6 implements IConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UCarAdapter f5366a;

        public void a(String str, String str2) {
            this.f5366a.d.post(new j(this, str, str2));
        }

        public void b() {
            EasyLog.a("UCarAdapter", "onShareLinkServiceDisconnected");
            this.f5366a.b.lock();
            CountDownLatch unused = this.f5366a.N = new CountDownLatch(1);
            this.f5366a.b.unlock();
            this.f5366a.e.post(new f(this));
        }

        public void c(String str, boolean z) {
            EasyLog.a("UCarAdapter", "onDisconnected, deviceId: " + str);
            if (this.f5366a.m != null) {
                this.f5366a.e.post(new i(this, z));
            } else {
                EasyLog.e("UCarAdapter", "mCarInitCallback is null, deInit method has called");
            }
        }

        public void d() {
            EasyLog.a("UCarAdapter", "onShareLinkServiceConnected");
            this.f5366a.N.countDown();
        }

        public void e(String str, String str2) {
            EasyLog.a("UCarAdapter", "onReceivedClientAddress, deviceId: " + str + ", ip: " + str2);
            boolean unused = this.f5366a.g = false;
            if (this.f5366a.o != null) {
                this.f5366a.e.post(new g(this, str2, str));
            }
        }

        public void f(String str, int i) {
            this.f5366a.D2(i);
        }

        public void g(String str, int i) {
            EasyLog.i("UCarAdapter", "onConnectFailed, errorCode: " + i);
            this.f5366a.e.post(new e(this, str, i));
        }

        public void h(String str) {
            String unused = this.f5366a.c = str;
        }

        public void i(String str) {
            this.f5366a.K.post(new h(this));
        }

        public void onConnected() {
            EasyLog.a("UCarAdapter", "onConnected");
            this.f5366a.b.lock();
            int unused = this.f5366a.P = 0;
            UCarCommon.VisibleRegion unused2 = this.f5366a.U = null;
            this.f5366a.b.unlock();
        }

        public void onReceivedClientBleMac(String str) {
            EasyLog.a("UCarAdapter", "onReceivedClientBleAddr: " + str);
            String unused = this.f5366a.W = ShaUtil.b(str);
        }

        public void onReconfigureWifi(final WifiOwnerConfig wifiOwnerConfig) {
            Future<?> submit = Executors.newSingleThreadExecutor().submit(new Runnable() {
                public void run() {
                    for (ICarConnectListener iCarConnectListener : AnonymousClass6.this.f5366a.j) {
                        if (iCarConnectListener != null) {
                            iCarConnectListener.c(wifiOwnerConfig);
                            return;
                        }
                    }
                }
            });
            try {
                submit.get(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                EasyLog.a("UCarAdapter", "onReconfigureWifi process timeout");
                submit.cancel(true);
            }
        }

        public int onSelectWorkMode(int i) {
            UCarAdapter uCarAdapter = this.f5366a;
            int k = uCarAdapter.P1(uCarAdapter.c, UCarCommon.WorkMode.a(i)).k();
            this.f5366a.q.d(UCarCommon.WorkMode.a(k).i());
            return k;
        }

        public void onUserInterventionNeeded(boolean z) {
            if (z) {
                UCarAdapter uCarAdapter = this.f5366a;
                uCarAdapter.H1(uCarAdapter.c, 3, 10007);
                return;
            }
            this.f5366a.q2(0);
        }

        public final /* synthetic */ void q() {
            this.f5366a.J.b();
            this.f5366a.J.f();
        }

        public final /* synthetic */ void r() {
            this.f5366a.J.b();
        }

        public final /* synthetic */ void s(String str, int i) {
            this.f5366a.K.post(new k(this));
            if (!this.f5366a.Z0()) {
                this.f5366a.W0(str, i);
            }
        }

        public final /* synthetic */ void t(boolean z) {
            this.f5366a.X0(z);
        }

        public final /* synthetic */ void u(String str, String str2) {
            for (ICarConnectListener iCarConnectListener : this.f5366a.j) {
                if (iCarConnectListener != null) {
                    iCarConnectListener.a(str, str2);
                }
            }
        }

        public final /* synthetic */ void v(String str, String str2) {
            int x0;
            int w0;
            this.f5366a.r2(true);
            this.f5366a.w2(str);
            this.f5366a.C2();
            if (!this.f5366a.d1(str2)) {
                this.f5366a.o.d(this.f5366a.Q0(str2));
                boolean z = false;
                int i = Settings.Global.getInt(this.f5366a.i.getContentResolver(), "dump_video_codectime_framerate", 0);
                EasyLog.a("UCarAdapter", "iFlagWfdPerf=" + i);
                CastManager x = this.f5366a.o;
                if (1 == i) {
                    z = true;
                }
                x.e(z);
                UCarAdapter uCarAdapter = this.f5366a;
                if (!uCarAdapter.c1(uCarAdapter.c) || this.f5366a.w >= this.f5366a.v) {
                    x0 = this.f5366a.v;
                    w0 = this.f5366a.w;
                } else {
                    x0 = this.f5366a.w;
                    w0 = this.f5366a.v;
                }
                int i2 = x0;
                int i3 = w0;
                CastManager x2 = this.f5366a.o;
                int y0 = this.f5366a.x;
                int z0 = this.f5366a.y;
                boolean A0 = this.f5366a.B;
                UCarAdapter uCarAdapter2 = this.f5366a;
                x2.f(i2, i3, y0, z0, A0, uCarAdapter2.e1(uCarAdapter2.c), this.f5366a.C);
                this.f5366a.t2(true);
            }
            this.f5366a.V0();
            this.f5366a.x2();
        }

        public final /* synthetic */ void w() {
            this.f5366a.X0(false);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayRotation {
    }

    static {
        EasyLog.g("UCar_");
        ProtocolConfig.g(new AndroidProtocolLogger());
        ProtocolConfig.h(SourceDevice.CAR);
    }

    public static void N0(Context context, String str) {
        EasyLog.a("UCarAdapter", "deletePhoneById, deviceId: " + str);
        new CarBluetoothMacRecord(context).c(str);
        ServerKeyNegotiator.z(context, str);
    }

    public static UCarAdapter R0() {
        if (e0 == null) {
            synchronized (UCarAdapter.class) {
                try {
                    if (e0 == null) {
                        e0 = new UCarAdapter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e0;
    }

    public final /* synthetic */ void A1() {
        this.J.c();
        this.J.b();
    }

    public final void A2() {
        this.b.lock();
        if (!d1(this.c) ? this.D >= 90 : this.D >= 80) {
            D2(12);
            H1(this.c, 2, -1);
            CameraManager cameraManager = this.u;
            if (cameraManager != null) {
                cameraManager.f(2);
            }
            this.J.b();
            String e2 = CarBluetoothMacRecord.e(this.c, this.i);
            if (!TextUtils.isEmpty(e2)) {
                this.W = e2;
            }
            String f2 = CarBluetoothMacRecord.f(this.c, this.i);
            if (f2 != null) {
                this.V = f2;
                X1(true);
            }
            if (TestUtil.b()) {
                u2();
            }
            if (TestUtil.c()) {
                v2();
            }
        }
        this.b.unlock();
    }

    public final /* synthetic */ void B1(CountDownLatch countDownLatch) {
        this.o.h();
        countDownLatch.countDown();
    }

    public void B2(ISurfaceEventListener iSurfaceEventListener) {
        this.l.remove(iSurfaceEventListener);
    }

    public final void C1(String str, List list, UCarCommon.AppListState appListState) {
        this.d.post(new e(this, str, list, appListState));
    }

    public final void C2() {
        int i2;
        int P0 = P0(this.c);
        UCarAudioManager.AudioPlayerControl audioPlayerControl = new UCarAudioManager.AudioPlayerControl();
        audioPlayerControl.f(UCarCommon.AudioType.STREAM_CAST_MUSIC);
        if (P0 == 2) {
            audioPlayerControl.g(100);
            audioPlayerControl.h(10);
        } else {
            audioPlayerControl.g(300);
            audioPlayerControl.h(100);
        }
        this.q.i(audioPlayerControl);
        if (this.o != null) {
            if (this.f5361a.getAudioLatency() > 0) {
                i2 = this.f5361a.getAudioLatency();
                EasyLog.a("UCarAdapter", "use custom latency: " + i2);
            } else {
                i2 = AudioTrackUtil.a(this.i);
                EasyLog.a("UCarAdapter", "use system latency: " + i2);
            }
            this.o.b(i2 + audioPlayerControl.b());
        }
    }

    public final void D1(String str, int i2, boolean z2, int i3, UCarCommon.AppState appState, long j2, UCarCommon.VisibleRegion visibleRegion) {
        UCarCommon.DisplayMode displayMode;
        int i4;
        int i5;
        int i6 = i3;
        UCarCommon.AppState appState2 = appState;
        UCarCommon.VisibleRegion visibleRegion2 = visibleRegion;
        this.b.lock();
        int i7 = this.S;
        int i8 = this.T;
        boolean c1 = c1(str);
        if (z2) {
            this.U = visibleRegion2;
            if (i6 != -1 && c1) {
                this.P = i6;
            }
        }
        UCarCommon.AppState appState3 = UCarCommon.AppState.RESUMED;
        if (appState2 == appState3) {
            this.a0.add(Integer.valueOf(i2));
        } else {
            this.a0.remove(Integer.valueOf(i2));
        }
        if (appState2 == UCarCommon.AppState.STARTED || appState2 == appState3) {
            this.K.removeCallbacks(this.c0);
            this.o.i(j2);
        }
        boolean b1 = b1();
        if (!z2) {
            displayMode = UCarCommon.DisplayMode.LANDSCAPE_FULLSCREEN;
            i5 = 0;
            i4 = 0;
        } else if (visibleRegion2 == null || !visibleRegion.d()) {
            i5 = b1 ? i7 : i8;
            if (b1) {
                i7 = i8;
            }
            i4 = i7;
            displayMode = c1 ? i5 > i7 ? UCarCommon.DisplayMode.LANDSCAPE_FULLSCREEN : UCarCommon.DisplayMode.PORTRAIT_WINDOW : UCarCommon.DisplayMode.LANDSCAPE_FULLSCREEN;
        } else {
            displayMode = visibleRegion2.g;
            i5 = b1 ? visibleRegion.h() : visibleRegion.c();
            i4 = b1 ? visibleRegion.c() : visibleRegion.h();
        }
        this.X = i5;
        this.Y = i4;
        this.b.unlock();
        this.d.post(new j(this, str, i2, z2, i3, appState, i5, i4, visibleRegion, displayMode));
    }

    public final void D2(int i2) {
        Integer num = (Integer) d0.get(Integer.valueOf(i2));
        if (num != null) {
            q2(num.intValue());
        }
    }

    public final void E1(String str, UCarCommon.CallInfo callInfo) {
        this.d.post(new i(this, str, callInfo));
    }

    public final void E2(boolean z2, int i2, int i3) {
        this.b.lock();
        if (z2) {
            this.Q = i2;
            this.R = i3;
        }
        this.S = i2;
        this.T = i3;
        this.r.f(i2);
        this.r.e(i3);
        this.b.unlock();
    }

    public void F1(String str, UCarCommon.CameraState cameraState) {
        ControlManager controlManager = this.p;
        if (controlManager != null) {
            controlManager.M(str, cameraState);
        }
    }

    public final void G1(String str, int i2) {
        EasyLog.i("UCarAdapter", "notifyConnectFailed, deviceId: " + str + ", errorCode: " + i2);
        H1(str, 3, i2);
    }

    public final void H1(String str, int i2, int i3) {
        this.d.post(new l(this, str, i2, i3));
    }

    public final void I1(String str, int i2) {
        this.d.post(new a(this, str, i2));
    }

    public void J0(UCarCommon.CameraInfo cameraInfo) {
        ControlManager controlManager = this.p;
        if (controlManager != null && this.u != null) {
            controlManager.L(CameraManager.b(cameraInfo));
        }
    }

    public final void J1(String str, boolean z2) {
        EasyLog.i("UCarAdapter", "notifyDisconnected, deviceId: " + str + ", byUser: " + z2);
        this.e.post(new w(this, str, z2));
    }

    public boolean K0(byte[] bArr, UCarCommon.AudioFormat audioFormat, String str) {
        ControlManager controlManager = this.p;
        if (controlManager != null) {
            return controlManager.S(bArr, audioFormat, str);
        }
        return false;
    }

    public boolean K1() {
        ControlManager controlManager = this.p;
        if (controlManager != null) {
            return controlManager.T();
        }
        return false;
    }

    public final void L0() {
        TestClickActionThread testClickActionThread = this.L;
        if (testClickActionThread != null) {
            testClickActionThread.interrupt();
            this.L = null;
        }
        UCarApiTestThread uCarApiTestThread = this.M;
        if (uCarApiTestThread != null) {
            uCarApiTestThread.c();
            this.M = null;
        }
    }

    public final void L1(String str, UCarProto.AddNotification addNotification) {
        this.d.post(new m(this, str, M0(addNotification)));
    }

    public final UCarNotification M0(UCarProto.AddNotification addNotification) {
        UCarNotification.Builder u2 = new UCarNotification.Builder().A(addNotification.getId()).B(addNotification.getIsOngoing()).y(addNotification.getContentTitle()).x(addNotification.getContentText()).C(addNotification.getPackageName()).q(addNotification.getActionFirstTitle()).s(addNotification.getActionSecondTitle()).u(addNotification.getActionThirdTitle());
        if (!addNotification.getIcon().isEmpty()) {
            u2.z(BitmapUtil.a(addNotification.getIcon().toByteArray()));
        }
        if (!addNotification.getContentBigIcon().isEmpty()) {
            u2.v(BitmapUtil.a(addNotification.getContentBigIcon().toByteArray()));
        }
        if (addNotification.getContentIntentId() != 0) {
            u2.w(T0(addNotification.getId(), addNotification.getContentIntentId(), addNotification.getPackageName()));
        }
        if (addNotification.getActionFirstPendingIntentId() != 0) {
            u2.p(T0(addNotification.getId(), addNotification.getActionFirstPendingIntentId(), addNotification.getPackageName()));
        }
        if (addNotification.getActionSecondPendingIntentId() != 0) {
            u2.r(T0(addNotification.getId(), addNotification.getActionSecondPendingIntentId(), addNotification.getPackageName()));
        }
        if (addNotification.getActionThirdPendingIntentId() != 0) {
            u2.t(T0(addNotification.getId(), addNotification.getActionThirdPendingIntentId(), addNotification.getPackageName()));
        }
        return u2.o();
    }

    public boolean M1(int i2, int i3) {
        EasyLog.a("UCarAdapter", "notifyNotificationClick notificationId: " + i2 + ", clickPendingIntentId: " + i3);
        ControlManager controlManager = this.p;
        if (controlManager != null) {
            return controlManager.Z(i2, i3);
        }
        return false;
    }

    public final void N1(String str, List list) {
        this.d.post(new n(this, str, list));
    }

    public boolean O0() {
        boolean z2;
        boolean z3 = false;
        if (this.p != null) {
            this.g = true;
            z2 = this.p.U();
        } else {
            z2 = false;
        }
        if (z2) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.O = countDownLatch;
            try {
                if (countDownLatch.await(200, TimeUnit.MILLISECONDS)) {
                    EasyLog.a("UCarAdapter", "disconnect tasks have been done.");
                    z3 = z2;
                } else {
                    EasyLog.c("UCarAdapter", "disconnect not be fully executed.");
                }
                z2 = z3;
            } catch (InterruptedException e2) {
                EasyLog.d("UCarAdapter", "catch InterruptedException", e2);
            }
            this.O = null;
        }
        EasyLog.a("UCarAdapter", "disconnect, result: " + z2);
        return z2;
    }

    public final void O1(String str, UCarCommon.POIAddress pOIAddress) {
        this.d.post(new d(this, str, pOIAddress));
    }

    public int P0(String str) {
        MDevice s2;
        UCarConnectProxy uCarConnectProxy = this.n;
        if (uCarConnectProxy == null || (s2 = uCarConnectProxy.s(str)) == null) {
            return 1;
        }
        return s2.getConnectType();
    }

    public final UCarCommon.WorkMode P1(String str, UCarCommon.WorkMode workMode) {
        UCarCommon.WorkMode b2;
        UCarCommon.WorkMode workMode2 = UCarCommon.WorkMode.c;
        for (ICarConnectListener iCarConnectListener : this.j) {
            if (!(iCarConnectListener == null || (b2 = iCarConnectListener.b(str, workMode)) == null || !UCarCommon.WorkMode.j(b2))) {
                workMode2 = b2;
            }
        }
        EasyLog.a("UCarAdapter", "notifySelectWorkMode, deviceId: " + str + ", selectedWorkMode: " + workMode2);
        return workMode2;
    }

    public final MDevice Q0(String str) {
        UCarConnectProxy uCarConnectProxy = this.n;
        return uCarConnectProxy != null ? uCarConnectProxy.s(str) : new MDevice();
    }

    public boolean Q1(UCarCommon.DayNightMode dayNightMode) {
        EasyLog.a("UCarAdapter", "notifySwitchDayOrNight: " + dayNightMode);
        UCarConnectProxy uCarConnectProxy = this.n;
        if (uCarConnectProxy != null) {
            uCarConnectProxy.A(dayNightMode.getValue());
        }
        ControlManager controlManager = this.p;
        if (controlManager != null) {
            return controlManager.a0(dayNightMode);
        }
        return false;
    }

    public final void R1(String str, UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat, UCarAudioManager.PlayerState playerState) {
        this.e.post(new g(this, playerState, audioType, audioFormat));
    }

    public final Intent S0(int i2, int i3, String str) {
        return new Intent().setAction("ucar.intent.action.NOTIFICATION_MOCK_ACTION").setClass(this.i, MockActionReceiver.class).putExtra("mockPendingIntentId", (i2 << 16) | i3).putExtra("notificationPackageName", str);
    }

    public final void S1(String str, UCarCommon.CameraAction cameraAction, UCarCommon.CameraActionArgs cameraActionArgs) {
        CameraManager cameraManager = this.u;
        if (cameraManager != null) {
            cameraManager.e(str, cameraAction, cameraActionArgs);
        }
    }

    public final PendingIntent T0(int i2, int i3, String str) {
        return PendingIntent.getBroadcast(this.i, (i2 << 16) | i3, S0(i2, i3, str), 335544320);
    }

    public final void T1(String str, UCarCommon.AudioFormat audioFormat, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.e.post(new h(this, z2, z3, z4, z5, audioFormat));
    }

    public final void U0(UCarCommon.BluetoothMacInfo bluetoothMacInfo) {
        CarBluetoothMacRecord carBluetoothMacRecord = new CarBluetoothMacRecord(this.i);
        if (bluetoothMacInfo.b() == UCarCommon.OPType.OP_ADD) {
            this.V = bluetoothMacInfo.a();
            X1(true);
            EasyLog.a("UCarAdapter", "add mCurrentConnectBtMac: " + this.V + ", mCurrentConnectBleMacHash: " + this.W);
            carBluetoothMacRecord.a(this.c, bluetoothMacInfo.a());
            if (!TextUtils.isEmpty(this.W)) {
                carBluetoothMacRecord.b(this.c, this.W);
            }
        } else if (bluetoothMacInfo.b() == UCarCommon.OPType.OP_DELETE) {
            carBluetoothMacRecord.c(this.c);
        }
    }

    public final void U1(String str, UCarCommon.MusicInfo musicInfo) {
        this.e.post(new o(this, str, musicInfo));
    }

    public final void V0() {
        D2(10);
        this.K.post(new q(this));
        ControlManager controlManager = this.p;
        if (controlManager != null) {
            controlManager.e0(new r(this));
        }
    }

    public final void V1(String str, UCarCommon.NavigationInfo navigationInfo) {
        if (navigationInfo != null) {
            this.e.post(new c(this, str, navigationInfo));
        }
    }

    public final void W0(String str, int i2) {
        this.b.lock();
        this.W = null;
        this.X = 0;
        this.Y = 0;
        this.b.unlock();
        z2();
        if (this.D > 0) {
            D2(0);
        }
        G1(str, i2);
        L0();
    }

    public final void W1(String str, UCarCommon.PhoneStateInfo phoneStateInfo) {
        this.e.post(new k(this, str, phoneStateInfo));
    }

    public final void X0(boolean z2) {
        EasyLog.a("UCarAdapter", "handleDisconnectRequest, isConnected: " + Z0());
        boolean z3 = false;
        if (this.D > 0) {
            D2(0);
        }
        this.b.lock();
        this.P = 0;
        this.U = null;
        this.W = null;
        this.X = 0;
        this.Y = 0;
        this.b.unlock();
        if (Z0()) {
            CountDownLatch countDownLatch = this.O;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            String str = this.c;
            if (this.g || z2) {
                z3 = true;
            }
            J1(str, z3);
            z2();
        }
        L0();
    }

    public void X1(boolean z2) {
        if (this.b0.getAndSet(false)) {
            this.e.post(new u(this, z2));
        }
    }

    public final void Y0(UCarAudioManager.AudioPlayerControl audioPlayerControl) {
        this.e.post(new f(this, audioPlayerControl));
    }

    public boolean Y1() {
        return Z1(true);
    }

    public final boolean Z0() {
        return this.h;
    }

    public boolean Z1(boolean z2) {
        EasyLog.a("UCarAdapter", "pauseCast, gotoBackground: " + z2);
        if (this.e == null || !this.f) {
            EasyLog.c("UCarAdapter", "pause cast must be called after successful initialization");
            return false;
        }
        this.K.removeCallbacks(this.c0);
        this.o.c();
        if (!z2) {
            return true;
        }
        this.a0.clear();
        return this.e.post(new p(this));
    }

    public final boolean a1() {
        return this.D == 100;
    }

    public void a2(ISurfaceEventListener iSurfaceEventListener) {
        if (!this.l.contains(iSurfaceEventListener)) {
            this.l.add(iSurfaceEventListener);
        }
    }

    public final boolean b1() {
        int i2 = this.P;
        return i2 == 0 || i2 == 2;
    }

    public void b2(String[] strArr) {
        ControlManager controlManager = this.p;
        if (controlManager != null && this.u != null) {
            controlManager.N(CameraManager.c(strArr));
        }
    }

    public final boolean c1(String str) {
        return Q0(str).getSelectedWorkMode() == UCarCommon.WorkMode.f.k();
    }

    public boolean c2(UCarCommon.AccelerationInfo accelerationInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendAccelerationInfo");
        return this.s.b(accelerationInfo);
    }

    public final boolean d1(String str) {
        return Q0(str).getSelectedWorkMode() == UCarCommon.WorkMode.d.k();
    }

    public boolean d2(UCarCommon.BatteryInfo batteryInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendBatteryInfo");
        return this.s.c(batteryInfo);
    }

    public final boolean e1(String str) {
        int selectedWorkMode = Q0(str).getSelectedWorkMode();
        return selectedWorkMode == UCarCommon.WorkMode.e.k() || selectedWorkMode == UCarCommon.WorkMode.f.k();
    }

    public void e2(UCarCommon.VideoType videoType, ByteBuffer byteBuffer, short s2) {
        CameraManager cameraManager = this.u;
        if (cameraManager != null) {
            cameraManager.g(videoType, byteBuffer, s2);
        }
    }

    public final /* synthetic */ void f1() {
        this.J.c();
        this.J.g();
    }

    public boolean f2(UCarCommon.GPSInfo gPSInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendGPSInfo");
        return this.s.e(gPSInfo);
    }

    public final /* synthetic */ void g1() {
        if (this.n != null) {
            EasyLog.e("UCarAdapter", "send heart beat error, try disconnect link");
            this.n.r();
        }
    }

    public boolean g2(UCarCommon.GearStateInfo gearStateInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendGearStateInfo");
        return this.s.d(gearStateInfo);
    }

    public final /* synthetic */ void h1() {
        EasyLog.c("UCarAdapter", "onSendHeartBeatError");
        Handler handler = this.e;
        if (handler != null) {
            handler.post(new b(this));
        }
    }

    public boolean h2(UCarCommon.GyroscopeInfo gyroscopeInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendGyroscopeInfo");
        return this.s.f(gyroscopeInfo);
    }

    public final /* synthetic */ void i1(UCarAudioManager.AudioPlayerControl audioPlayerControl) {
        this.q.i(audioPlayerControl);
    }

    public boolean i2(UCarCommon.KeyEventActionType keyEventActionType, UCarCommon.KeyCodeType keyCodeType, int i2) {
        if (keyCodeType == null || this.p == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendKeyEvent, action: " + keyEventActionType + ", keycode: " + keyCodeType + ", metaState: " + i2);
        return this.p.Y(keyEventActionType, keyCodeType, i2);
    }

    public final /* synthetic */ void j1(String str, List list, UCarCommon.AppListState appListState) {
        EasyLog.a("UCarAdapter", "notifyAppListChanged, deviceId: " + str + ", appIds: " + list + ", appState: " + appListState);
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.e(str, list, appListState);
            }
        }
    }

    public boolean j2(UCarCommon.LightSensorInfo lightSensorInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendLightSensorInfo");
        return this.s.g(lightSensorInfo);
    }

    public final /* synthetic */ void k1(String str, int i2, boolean z2, int i3, UCarCommon.AppState appState, int i4, int i5, UCarCommon.VisibleRegion visibleRegion, UCarCommon.DisplayMode displayMode) {
        boolean z3 = z2;
        EasyLog.a("UCarAdapter", "notifyAppStateChanged, deviceId: " + str + ", appId: " + i2 + ", isNeedShow: " + z3 + ", displayRotation: " + i3 + ", appState: " + appState + ", expectDisplayWidth: " + i4 + ", expectDisplayHeight: " + i5 + ", region: " + visibleRegion + ", displayMode: " + displayMode);
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.i(str, i2, z2, i4, i5, appState, displayMode);
            }
        }
        if (!c1(str) || !z3) {
            this.r.g(0, (UCarCommon.VisibleRegion) null);
            return;
        }
        this.r.g(this.P, this.U);
        for (ISurfaceEventListener iSurfaceEventListener : this.l) {
            if (iSurfaceEventListener != null) {
                iSurfaceEventListener.a(this.P, this.U);
            }
        }
    }

    public boolean k2(UCarCommon.LightsInfo lightsInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendLightsInfo");
        return this.s.h(lightsInfo);
    }

    public final /* synthetic */ void l1(String str, UCarCommon.CallInfo callInfo) {
        EasyLog.a("UCarAdapter", "notifyCallInfoReceived, deviceId: " + str + ", callInfo: " + callInfo);
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.c(str, callInfo);
            }
        }
    }

    public boolean l2(int i2, short[] sArr, long j2) {
        UCarAudioManager uCarAudioManager = this.q;
        if (uCarAudioManager != null) {
            return uCarAudioManager.m(i2, sArr, j2);
        }
        return false;
    }

    public final /* synthetic */ void m1(String str, int i2, int i3) {
        for (ICarConnectListener iCarConnectListener : this.j) {
            if (iCarConnectListener != null) {
                iCarConnectListener.d(str, i2, i3);
            }
        }
    }

    public boolean m2(UCarCommon.OilInfo oilInfo) {
        if (this.s == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendOilInfo");
        return this.s.i(oilInfo);
    }

    public final /* synthetic */ void n1(String str, int i2) {
        for (ICarConnectListener iCarConnectListener : this.j) {
            if (iCarConnectListener != null) {
                iCarConnectListener.f(str, i2);
            }
        }
    }

    public boolean n2(int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3) {
        UibcManager uibcManager = this.r;
        if (uibcManager != null) {
            return uibcManager.d(i2, i3, iArr, iArr2, iArr3);
        }
        return false;
    }

    public final /* synthetic */ void o1(String str, boolean z2) {
        this.Z.clear();
        if (this.D >= 90) {
            this.n.q();
        }
        H1(str, 1, z2 ? 11 : -1);
        CameraManager cameraManager = this.u;
        if (cameraManager != null) {
            cameraManager.f(1);
        }
    }

    public boolean o2(UCarCommon.VRCmdType vRCmdType, String str) {
        if (this.p == null) {
            return false;
        }
        EasyLog.e("UCarAdapter", "sendVRCMD, type: " + vRCmdType + ", source: " + str);
        return this.p.b0(vRCmdType, str);
    }

    public final /* synthetic */ void p1(String str, UCarNotification uCarNotification) {
        EasyLog.a("UCarAdapter", "notifyNotificationAdded, deviceId: " + str + ", notification: " + uCarNotification);
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.g(str, uCarNotification);
            }
        }
    }

    public final void p2(boolean z2) {
        this.b.lock();
        this.E = z2;
        this.b.unlock();
    }

    public final /* synthetic */ void q1(String str, List list) {
        EasyLog.a("UCarAdapter", "notifyNotificationRemoved, deviceId: " + str + ", notification: " + list);
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.d(str, list);
            }
        }
    }

    public final void q2(int i2) {
        EasyLog.a("UCarAdapter", "setConnectPhase, phase: " + i2);
        this.b.lock();
        this.D = i2;
        this.b.unlock();
        I1(this.c, i2);
    }

    public final /* synthetic */ void r1(String str, UCarCommon.POIAddress pOIAddress) {
        EasyLog.a("UCarAdapter", "notifyPOIAddressReceived, deviceId: " + str + ", poiAddress: " + pOIAddress);
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.a(str, pOIAddress);
            }
        }
    }

    public final void r2(boolean z2) {
        EasyLog.a("UCarAdapter", "setConnectState, state: " + z2);
        this.b.lock();
        this.h = z2;
        this.b.unlock();
    }

    public final /* synthetic */ void s1(UCarAudioManager.PlayerState playerState, UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat) {
        UCarCommon.AudioAttributes b2;
        UCarCommon.AudioAttributes audioAttributes = null;
        if (playerState == UCarAudioManager.PlayerState.START_PLAYER) {
            for (IPhoneDataListener iPhoneDataListener : this.k) {
                if (!(iPhoneDataListener == null || (b2 = iPhoneDataListener.b(audioType)) == null)) {
                    audioAttributes = b2;
                }
            }
        }
        this.q.g(audioType, audioFormat, playerState, audioAttributes, P0(this.c) == 2);
    }

    public final void s2(boolean z2) {
        this.b.lock();
        this.G = z2;
        this.b.unlock();
    }

    public final /* synthetic */ void t1(boolean z2, boolean z3, boolean z4, boolean z5, UCarCommon.AudioFormat audioFormat) {
        UCarCommon.AudioAttributes b2;
        UCarCommon.AudioAttributes audioAttributes = null;
        if (z2 && (z3 || z4 || z5)) {
            UCarCommon.AudioType audioType = z4 ? UCarCommon.AudioType.STREAM_MODEM_CALL : z3 ? UCarCommon.AudioType.STREAM_IP_CALL : UCarCommon.AudioType.STREAM_AI_ASSISTANT;
            for (IPhoneDataListener iPhoneDataListener : this.k) {
                if (!(iPhoneDataListener == null || (b2 = iPhoneDataListener.b(audioType)) == null)) {
                    audioAttributes = b2;
                }
            }
        }
        this.q.h(audioFormat, z2, z3 || z4, this.f5361a.isUseCustomAudioRecord(), z5, audioAttributes);
    }

    public final void t2(boolean z2) {
        this.b.lock();
        this.F = z2;
        this.b.unlock();
    }

    public final /* synthetic */ void u1(String str, UCarCommon.MusicInfo musicInfo) {
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.h(str, musicInfo);
            }
        }
    }

    public final void u2() {
        EasyLog.a("UCarAdapter", "Test : start send touch event.");
        if (this.L == null) {
            this.L = new TestClickActionThread(this.v, this.w);
        }
        this.L.start();
    }

    public final /* synthetic */ void v1(String str, UCarCommon.NavigationInfo navigationInfo) {
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.j(str, navigationInfo);
            }
        }
    }

    public final void v2() {
        EasyLog.a("UCarAdapter", "start UCarAdapter api Test");
        if (this.M == null) {
            this.M = new UCarApiTestThread(this.i);
        }
        if (!this.M.isAlive()) {
            try {
                this.M.start();
            } catch (Exception e2) {
                EasyLog.d("UCarAdapter", "startApiTestThread exception", e2);
            }
        }
    }

    public final /* synthetic */ void w1(String str, UCarCommon.PhoneStateInfo phoneStateInfo) {
        for (IPhoneDataListener iPhoneDataListener : this.k) {
            if (iPhoneDataListener != null) {
                iPhoneDataListener.f(str, phoneStateInfo);
            }
        }
    }

    public final void w2(String str) {
        EasyLog.e("UCarAdapter", "startUCarChannel, peerAddress: " + str);
        this.I = str;
        if (this.p == null) {
            ControlManager controlManager = new ControlManager();
            this.p = controlManager;
            controlManager.Q(new ControlManager.IPhoneCmdListener() {
                public void a(UCarAudioManager.AudioPlayerControl audioPlayerControl) {
                    UCarAdapter.this.Y0(audioPlayerControl);
                }

                public void b() {
                    boolean unused = UCarAdapter.this.g = true;
                    UCarAdapter.this.e.post(new c(this));
                }

                public void c(UCarCommon.CameraAction cameraAction, UCarCommon.CameraActionArgs cameraActionArgs) {
                    if (UCarAdapter.this.u != null && !UCarAdapter.this.u.d() && cameraAction == UCarCommon.CameraAction.CAMERA_OPEN) {
                        EasyLog.a("UCarAdapter", "CameraManager.start with address:" + UCarAdapter.this.I);
                        UCarAdapter.this.u.i(UCarAdapter.this.I);
                        UCarAdapter.this.H.set(true);
                    }
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.S1(uCarAdapter.c, cameraAction, cameraActionArgs);
                }

                public void d(List list, UCarCommon.AppListState appListState) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.C1(uCarAdapter.c, list, appListState);
                }

                public void e(UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat, UCarAudioManager.PlayerState playerState) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.R1(uCarAdapter.c, audioType, audioFormat, playerState);
                }

                public void f(UCarCommon.POIAddress pOIAddress) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.O1(uCarAdapter.c, pOIAddress);
                }

                public void g(UCarCommon.CallInfo callInfo) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.E1(uCarAdapter.c, callInfo);
                }

                public void h(List list) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.N1(uCarAdapter.c, list);
                }

                public void i(UCarCommon.PhoneStateInfo phoneStateInfo) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.W1(uCarAdapter.c, phoneStateInfo);
                }

                public void j(boolean z, UCarCommon.AudioFormat audioFormat, boolean z2, boolean z3, boolean z4) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.T1(uCarAdapter.c, audioFormat, z, z2, z3, z4);
                }

                public void k(UCarProto.AddNotification addNotification) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.L1(uCarAdapter.c, addNotification);
                }

                public void l(UCarCommon.MusicInfo musicInfo) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.U1(uCarAdapter.c, musicInfo);
                }

                public void m() {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.H1(uCarAdapter.c, 6, -1);
                }

                public void n(UCarCommon.BluetoothMacInfo bluetoothMacInfo) {
                    UCarAdapter.this.U0(bluetoothMacInfo);
                }

                public void o() {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.H1(uCarAdapter.c, 7, -1);
                }

                public void p(int i, boolean z, int i2, UCarCommon.AppState appState, long j, UCarCommon.VisibleRegion visibleRegion) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.D1(uCarAdapter.c, i, z, i2, appState, j, visibleRegion);
                }

                public void q(UCarMessage uCarMessage) {
                    ControlManager N = UCarAdapter.this.p;
                    UCarConfig M = UCarAdapter.this.f5361a;
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    N.V(M, uCarAdapter.Q0(uCarAdapter.c), uCarMessage);
                }

                public void r(long j) {
                    EasyLog.a("UCarAdapter", "onHeartbeat, timeStamp: " + j);
                    UCarAdapter.this.K.post(new d(this));
                }

                public void s(UCarCommon.NavigationInfo navigationInfo) {
                    UCarAdapter uCarAdapter = UCarAdapter.this;
                    uCarAdapter.V1(uCarAdapter.c, navigationInfo);
                }

                public void t() {
                    EasyLog.a("UCarAdapter", "stop mirror, not used yet.");
                }

                public final /* synthetic */ void w() {
                    UCarAdapter.this.n.r();
                }

                public final /* synthetic */ void x() {
                    if (!UCarAdapter.this.a1()) {
                        UCarAdapter.this.A2();
                    }
                    UCarAdapter.this.J.c();
                    if (UCarAdapter.this.Z0()) {
                        UCarAdapter.this.J.g();
                    }
                }
            });
        }
        ControlManager controlManager2 = this.p;
        if (controlManager2 != null) {
            controlManager2.c0(Q0(this.c).getProtocolVersion());
            this.p.d0(str);
        }
        SensorManager sensorManager = this.s;
        if (sensorManager != null) {
            sensorManager.j(str);
            s2(true);
        }
        CarCertManager carCertManager = this.t;
        if (carCertManager != null) {
            carCertManager.c(str);
        }
        UCarAudioManager uCarAudioManager = this.q;
        if (uCarAudioManager != null) {
            uCarAudioManager.n(str);
            p2(true);
        }
    }

    public final /* synthetic */ void x1(boolean z2) {
        for (ICarConnectListener iCarConnectListener : this.j) {
            if (iCarConnectListener != null) {
                iCarConnectListener.e(z2);
            }
        }
    }

    public boolean x2() {
        Handler handler;
        if (this.n == null || (handler = this.e) == null) {
            return false;
        }
        return handler.post(new v(this));
    }

    public final /* synthetic */ void y1() {
        ControlManager controlManager = this.p;
        if (controlManager != null) {
            controlManager.W();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y2() {
        /*
            r7 = this;
            java.lang.String r0 = "stopMiracastAndUCarChannel"
            java.lang.String r1 = "UCarAdapter"
            com.easy.logger.EasyLog.e(r1, r0)
            android.os.Handler r0 = r7.K
            com.honey.account.h3.s r2 = new com.honey.account.h3.s
            r2.<init>(r7)
            r0.post(r2)
            java.util.concurrent.locks.ReentrantLock r0 = r7.b
            r0.lock()
            r0 = 0
            com.ucar.vehiclesdk.audio.UCarAudioManager r2 = r7.q     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x002c
            boolean r3 = r7.E     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x002c
            r7.E = r0     // Catch:{ Exception -> 0x0028 }
            r2.p()     // Catch:{ Exception -> 0x0028 }
            goto L_0x002c
        L_0x0025:
            r0 = move-exception
            goto L_0x00bd
        L_0x0028:
            r2 = move-exception
            r3 = r0
            goto L_0x00a7
        L_0x002c:
            com.ucar.vehiclesdk.camera.CameraManager r2 = r7.u     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x0042
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.H     // Catch:{ Exception -> 0x0028 }
            boolean r2 = r2.get()     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x0042
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.H     // Catch:{ Exception -> 0x0028 }
            r2.set(r0)     // Catch:{ Exception -> 0x0028 }
            com.ucar.vehiclesdk.camera.CameraManager r2 = r7.u     // Catch:{ Exception -> 0x0028 }
            r2.j()     // Catch:{ Exception -> 0x0028 }
        L_0x0042:
            com.ucar.vehiclesdk.datacenter.SensorManager r2 = r7.s     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x004f
            boolean r3 = r7.G     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x004f
            r7.G = r0     // Catch:{ Exception -> 0x0028 }
            r2.k()     // Catch:{ Exception -> 0x0028 }
        L_0x004f:
            com.ucar.vehiclesdk.control.ControlManager r2 = r7.p     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x0059
            r3 = 0
            r7.V = r3     // Catch:{ Exception -> 0x0028 }
            r2.f0()     // Catch:{ Exception -> 0x0028 }
        L_0x0059:
            com.ucar.vehiclesdk.datacenter.CarCertManager r2 = r7.t     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x0060
            r2.d()     // Catch:{ Exception -> 0x0028 }
        L_0x0060:
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x0028 }
            r3 = 1
            r2.<init>(r3)     // Catch:{ Exception -> 0x0028 }
            com.ucar.vehiclesdk.cast.CastManager r4 = r7.o     // Catch:{ Exception -> 0x0028 }
            if (r4 == 0) goto L_0x009a
            boolean r4 = r7.F     // Catch:{ Exception -> 0x0028 }
            if (r4 == 0) goto L_0x009a
            r7.F = r0     // Catch:{ Exception -> 0x0028 }
            java.lang.Thread r4 = new java.lang.Thread     // Catch:{ Exception -> 0x0028 }
            com.honey.account.h3.t r5 = new com.honey.account.h3.t     // Catch:{ Exception -> 0x0028 }
            r5.<init>(r7, r2)     // Catch:{ Exception -> 0x0028 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0028 }
            r4.start()     // Catch:{ Exception -> 0x0028 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x008d }
            r5 = 500(0x1f4, double:2.47E-321)
            boolean r2 = r2.await(r5, r4)     // Catch:{ InterruptedException -> 0x008d }
            if (r2 == 0) goto L_0x008f
            java.lang.String r2 = "stop sink tasks have been done."
            com.easy.logger.EasyLog.a(r1, r2)     // Catch:{ InterruptedException -> 0x008d }
            goto L_0x009a
        L_0x008d:
            r2 = move-exception
            goto L_0x0095
        L_0x008f:
            java.lang.String r2 = "stop sink not be fully executed, we need exit process."
            com.easy.logger.EasyLog.c(r1, r2)     // Catch:{ InterruptedException -> 0x008d }
            goto L_0x009b
        L_0x0095:
            java.lang.String r3 = "catch InterruptedException"
            com.easy.logger.EasyLog.d(r1, r3, r2)     // Catch:{ Exception -> 0x0028 }
        L_0x009a:
            r3 = r0
        L_0x009b:
            java.util.concurrent.CopyOnWriteArraySet r2 = r7.a0     // Catch:{ Exception -> 0x00a6 }
            r2.clear()     // Catch:{ Exception -> 0x00a6 }
        L_0x00a0:
            java.util.concurrent.locks.ReentrantLock r7 = r7.b
            r7.unlock()
            goto L_0x00ad
        L_0x00a6:
            r2 = move-exception
        L_0x00a7:
            java.lang.String r4 = "stopMiracastAndUCarChannel Exception"
            com.easy.logger.EasyLog.d(r1, r4, r2)     // Catch:{ all -> 0x0025 }
            goto L_0x00a0
        L_0x00ad:
            java.lang.String r7 = "stopMiracastAndUCarChannel done~"
            com.easy.logger.EasyLog.a(r1, r7)
            if (r3 == 0) goto L_0x00bc
            java.lang.String r7 = "exit process while stop the sink failed"
            com.easy.logger.EasyLog.c(r1, r7)
            java.lang.System.exit(r0)
        L_0x00bc:
            return
        L_0x00bd:
            java.util.concurrent.locks.ReentrantLock r7 = r7.b
            r7.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.UCarAdapter.y2():void");
    }

    public final /* synthetic */ void z1() {
        this.n.y();
    }

    public final void z2() {
        if (Z0()) {
            r2(false);
            y2();
            X1(false);
        }
    }
}
