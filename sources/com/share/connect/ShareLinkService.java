package com.share.connect;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.google.common.io.BaseEncoding;
import com.honey.account.z2.a;
import com.honey.account.z2.b;
import com.honey.account.z2.c;
import com.share.connect.IShareLinkManager;
import com.share.connect.ble.BluetoothLeObserver;
import com.share.connect.ble.BluetoothLeService;
import com.share.connect.ble.IBluetoothLe;
import com.share.connect.security.UCarAuthService;
import com.share.connect.utils.Locker;
import com.share.connect.utils.WorkThread;
import com.share.connect.wifiap.IWifiAp;
import com.share.connect.wifiap.WifiApObserver;
import com.share.connect.wifiap.WifiApService;
import com.share.connect.wifip2p.IWifiP2p;
import com.share.connect.wifip2p.WifiP2pObserver;
import com.share.connect.wifip2p.WifiP2pService;
import com.share.connect.wifip2p.WifiUtils;
import com.ucar.connect.aoa.AOAConnectManager;
import com.ucar.protocol.channel.socket.FutureRequestManager;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.util.StringUtil;

public class ShareLinkService extends Service {
    public int A;
    public String B;
    public String C;
    public String D;
    public String E;
    public final ConnectSession F = new ConnectSession();
    public final ConnectState G = ConnectState.b();
    public final CountDownLatch H = new CountDownLatch(3);
    public final ShareObservers I = new ShareObservers();
    public final ShareLinkStub J = new ShareLinkStub();
    public final Handler K = new Handler(Looper.getMainLooper());
    public final Runnable L = new a(this);
    public final Runnable M = new b(this);
    public final Runnable N = new c(this);
    public final ServiceConnection O = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            EasyLog.e("ShareLink", "Bluetooth service connected");
            IBluetoothLe unused = ShareLinkService.this.k = IBluetoothLe.Stub.asInterface(iBinder);
            ShareLinkService.this.H.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            EasyLog.c("ShareLink", "Bluetooth service disconnected");
            IBluetoothLe unused = ShareLinkService.this.k = null;
        }
    };
    public final ServiceConnection P = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            EasyLog.e("ShareLink", "WifiP2p service connected");
            IWifiP2p unused = ShareLinkService.this.l = IWifiP2p.Stub.asInterface(iBinder);
            ShareLinkService.this.H.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            EasyLog.c("ShareLink", "WifiP2p service disconnected");
            IWifiP2p unused = ShareLinkService.this.l = null;
        }
    };
    public final ServiceConnection Q = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            EasyLog.e("ShareLink", "WifiAp service connected");
            IWifiAp unused = ShareLinkService.this.m = IWifiAp.Stub.asInterface(iBinder);
            ShareLinkService.this.H.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            EasyLog.c("ShareLink", "WifiAp service disconnected");
            IWifiAp unused = ShareLinkService.this.m = null;
        }
    };
    public BluetoothLeObserver R = new BluetoothLeObserver.Stub() {
        private static final String TAG = "ShareLink-BleObserver";

        private void handleBleConnectFailed() {
            if (ConnectState.b().i()) {
                ShareLinkService.this.y0();
                ShareLinkService.this.I.i(4);
            }
        }

        public void onClientInfoReceived(String str, String str2, String str3, int i, String str4, int i2, String str5, int i3) {
            boolean z = false;
            ShareLinkService.this.C0(false);
            if (!ShareLinkService.this.G.c() || (ShareLinkService.this.F.c().equals(str) && !ShareLinkService.this.G.f())) {
                ShareLinkService.this.F.e();
                ShareLinkService.this.F.h(str).i(str2).f(i).j(str4);
                ShareLinkService.this.z0(true);
                ShareLinkService.this.x0();
                ShareLinkService.this.B0(false);
                ShareLinkService.this.G.j("wifi_connecting");
                boolean unused = ShareLinkService.this.p = false;
                ShareLinkService shareLinkService = ShareLinkService.this;
                if (str3.startsWith("OPPO ") && str5 == null) {
                    z = true;
                }
                boolean unused2 = shareLinkService.w = z;
                int unused3 = ShareLinkService.this.z = i3;
                if (str3.startsWith("OPPO ") && str5 == null) {
                    str5 = MDevice.MANUFACTURERS_OPPO;
                } else if (str5 != null) {
                    str5 = str5.toLowerCase(Locale.CHINA);
                }
                ShareLinkService.this.I.h(str, str3, str5);
                ShareLinkService.this.I.p(1);
                ShareLinkService.this.v0(i2);
                ShareLinkService.this.I.f(1002 == ShareLinkService.this.F.b() ? "wifi_ap" : "wifi_p2p");
                return;
            }
            EasyLog.a(TAG, "new other client info received, need skip, because current state is " + ShareLinkService.this.G.a());
        }

        public void onDeviceLost(Device device) {
            ShareLinkService.this.I.k(device);
        }

        public void onDeviceMatch(Device device) {
            ShareLinkService.this.I.l(device);
        }

        public void onFailure(int i, int i2) {
            EasyLog.a(TAG, "onFailure: " + i + ", " + i2);
            if (i == 1) {
                ShareLinkService.this.t0();
                ShareLinkService.this.A0(false);
                ShareLinkService.this.I.o(false);
            } else if (i == 2) {
                ShareLinkService.this.S0();
            } else if (i == 3 || i == 5 || i == 6) {
                if (i2 != 6) {
                    handleBleConnectFailed();
                }
            } else if (i == 4) {
                handleBleConnectFailed();
            }
        }

        public void onPinAvailable(String str) {
        }

        public void onReceivedClientBleMac(String str) {
            ShareLinkService.this.I.e(str);
        }

        public void onServerAddressSent() {
            ShareLinkService.this.I.p(4);
        }

        public void onServerInfoReceived(String str, String str2, String str3, int i) {
            try {
                EasyLog.a(TAG, "onServerInfoReceived");
                ShareLinkService.this.l.connectGroupOwner(str, str2, str3, i);
            } catch (RemoteException e) {
                EasyLog.d(TAG, "Connect group owner failed.", e);
                ShareLinkService.this.I.i(7);
            }
        }

        public void onSuccess(int i) {
            EasyLog.a(TAG, "onSuccess: " + i);
            if (i == 1) {
                ShareLinkService.this.A0(false);
                ShareLinkService.this.I.o(true);
            }
            boolean unused = ShareLinkService.this.r = true;
        }
    };
    public WifiP2pObserver S = new WifiP2pObserver.Stub() {
        private static final String TAG = "ShareLink-P2pObserver";

        public void onAcceptFailed() {
            EasyLog.i(TAG, "wifi onAcceptFailed, state=" + ShareLinkService.this.G.a());
            ShareLinkService.this.D0(3);
        }

        public void onConnectFailed() {
            EasyLog.i(TAG, "wifi onConnectFailed, state=" + ShareLinkService.this.G.a());
            ShareLinkService.this.D0(3);
        }

        public void onConnected() throws RemoteException {
            ShareLinkService.this.I0();
        }

        public void onCreateGroupFailed() {
            EasyLog.i(TAG, "wifi onCreateGroupFailed, state=" + ShareLinkService.this.G.a());
            ShareLinkService.this.D0(2);
        }

        public void onDeviceChanged(String str) throws RemoteException {
            EasyLog.a(TAG, "onDeviceChanged: " + str);
            ShareLinkService.this.k.setP2pDeviceMac(str);
        }

        public void onDisconnected(boolean z) {
            ShareLinkService.this.J0(z);
        }

        public void onGroupCreated(WifiP2pGroup wifiP2pGroup, int i) {
            EasyLog.a(TAG, "onGroupCreated: Group owner mac: " + wifiP2pGroup.getOwner().deviceAddress + ", frequency: " + i);
            if ((ShareLinkService.this.getApplicationInfo().flags & 2) != 0) {
                EasyLog.e(TAG, "ssid:" + wifiP2pGroup.getNetworkName() + ", pw:" + wifiP2pGroup.getPassphrase());
            }
            if (ShareLinkService.this.G.i() && !ShareLinkService.this.p) {
                boolean unused = ShareLinkService.this.p = true;
                try {
                    EasyLog.a(TAG, "start UCarAuthService...");
                    ShareLinkService.this.I.p(2);
                    String str = StringUtil.ALL_INTERFACES;
                    NetworkInterface byName = NetworkInterface.getByName(wifiP2pGroup.getInterface());
                    if (byName != null) {
                        Iterator<T> it = Collections.list(byName.getInetAddresses()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            InetAddress inetAddress = (InetAddress) it.next();
                            if (inetAddress instanceof Inet4Address) {
                                str = inetAddress.getHostAddress();
                                break;
                            }
                        }
                    }
                    ShareLinkService.this.N0(str);
                } catch (Exception e) {
                    EasyLog.d(TAG, "start auth service error: ", e);
                }
                try {
                    boolean v = ShareLinkService.this.s;
                    String str2 = BleUtil.DEFAULT_ADDRESS;
                    String str3 = v ? wifiP2pGroup.getOwner().deviceAddress : str2;
                    if (ShareLinkService.this.v) {
                        WifiOwnerConfig unused2 = ShareLinkService.this.n = new WifiOwnerConfig();
                        ShareLinkService.this.n.setSsid(wifiP2pGroup.getNetworkName());
                        ShareLinkService.this.n.setPassphrase(wifiP2pGroup.getPassphrase());
                        WifiOwnerConfig f0 = ShareLinkService.this.n;
                        if (ShareLinkService.this.s) {
                            str2 = wifiP2pGroup.getOwner().deviceAddress;
                        }
                        f0.setMac(str2);
                        ShareLinkService.this.n.setFrequency(i);
                        ShareLinkService.this.n.setType(1001);
                        ShareLinkService.this.n.setIpAddress((String) null);
                        ShareLinkService.this.I.q(ShareLinkService.this.n);
                        ShareLinkService.this.k.notifyServerInfo(ShareLinkService.this.n.getSsid(), ShareLinkService.this.n.getPassphrase(), ShareLinkService.this.n.getMac(), ShareLinkService.this.n.getFrequency(), ShareLinkService.this.n.getType(), ShareLinkService.this.n.getIpAddress());
                        return;
                    }
                    ShareLinkService.this.k.notifyServerInfo(wifiP2pGroup.getNetworkName(), wifiP2pGroup.getPassphrase(), str3, i, 1001, (String) null);
                } catch (RemoteException e2) {
                    EasyLog.d(TAG, "notifyServerInfo failed.", e2);
                    ShareLinkService.this.I.i(7);
                }
            }
        }

        public void onOpenFailed() {
            EasyLog.a(TAG, "onOpenFailed");
            ShareLinkService.this.t0();
            ShareLinkService.this.A0(false);
            ShareLinkService.this.I.o(false);
        }

        public void onOpenSuccess() throws RemoteException {
            EasyLog.a(TAG, "onOpenSuccess");
            if (ShareLinkService.this.l != null && ConnectState.b().i() && ShareLinkService.this.F.b() == 1001) {
                ShareLinkService.this.l.createGroupForClient(ShareLinkService.this.F.a(), ShareLinkService.this.F.d(), ShareLinkService.this.z);
            }
            int unused = ShareLinkService.this.y = 1001;
            if (ShareLinkService.this.k != null && !ShareLinkService.this.r) {
                ShareLinkService.this.k.registerBluetoothLeObserver(ShareLinkService.this.R);
                ShareLinkService.this.k.open(ShareLinkService.this.f9872a, ShareLinkService.this.b, ShareLinkService.this.e, ShareLinkService.this.f, ShareLinkService.this.g, ShareLinkService.this.h, ShareLinkService.this.q, ShareLinkService.this.i, ShareLinkService.this.E);
            }
        }
    };
    public WifiApObserver T = new WifiApObserver.Stub() {
        private static final String TAG = "ShareLink-ApObserver";

        public void onAcceptFailed() {
            EasyLog.i(TAG, "wifi onAcceptFailed, state=" + ShareLinkService.this.G.a());
            ShareLinkService.this.D0(3);
        }

        public void onApCreateFailed() {
            EasyLog.i(TAG, "softAp is created failed, state=" + ShareLinkService.this.G.a());
            ShareLinkService.this.D0(8);
        }

        public void onApCreated(String str, String str2, String str3, String str4, int i) {
            if (!ShareLinkService.this.G.i() || ShareLinkService.this.p) {
                EasyLog.a(TAG, "soft ap is created, but the ble is not coming");
                return;
            }
            EasyLog.a(TAG, "onApCreated start, ssid:" + str2 + " password:" + str3 + " macAddress:" + str4 + " frequency:" + i + " localAddress:" + str);
            boolean unused = ShareLinkService.this.p = true;
            ShareLinkService.this.I.p(2);
            ShareLinkService.this.N0(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = BleUtil.DEFAULT_ADDRESS;
            }
            try {
                String str5 = ShareLinkService.this.s ? str4 : BleUtil.DEFAULT_ADDRESS;
                if (ShareLinkService.this.v) {
                    WifiOwnerConfig unused2 = ShareLinkService.this.n = new WifiOwnerConfig();
                    ShareLinkService.this.n.setSsid(str2);
                    ShareLinkService.this.n.setPassphrase(str3);
                    ShareLinkService.this.n.setMac(str5);
                    ShareLinkService.this.n.setFrequency(i);
                    ShareLinkService.this.n.setType(1002);
                    ShareLinkService.this.n.setIpAddress(str);
                    ShareLinkService.this.I.q(ShareLinkService.this.n);
                    ShareLinkService.this.k.notifyServerInfo(ShareLinkService.this.n.getSsid(), ShareLinkService.this.n.getPassphrase(), ShareLinkService.this.n.getMac(), ShareLinkService.this.n.getFrequency(), ShareLinkService.this.n.getType(), ShareLinkService.this.n.getIpAddress());
                    return;
                }
                ShareLinkService.this.k.notifyServerInfo(str2, str3, str5, i, 1002, str);
            } catch (Exception e) {
                EasyLog.d(TAG, "notifyServerInfo failed.", e);
                ShareLinkService.this.I.i(7);
            }
        }

        public void onConnected() throws RemoteException {
            ShareLinkService.this.I0();
        }

        public void onDisconnected(boolean z) {
            ShareLinkService.this.J0(z);
        }

        public void onOpenFailed() {
            EasyLog.a(TAG, "onOpenFailed");
            ShareLinkService.this.t0();
            ShareLinkService.this.A0(false);
            ShareLinkService.this.I.o(false);
        }

        public void onOpenSuccess() throws RemoteException {
            EasyLog.a(TAG, "WifiApService onOpenSuccess");
            if (ShareLinkService.this.m != null && ConnectState.b().i() && ShareLinkService.this.F.b() == 1002) {
                ShareLinkService.this.m.createSoftAp(ShareLinkService.this.z, ShareLinkService.this.B, ShareLinkService.this.C, ShareLinkService.this.u, ShareLinkService.this.w, ShareLinkService.this.v);
            }
            int unused = ShareLinkService.this.y = 1002;
            if (ShareLinkService.this.k != null && !ShareLinkService.this.r) {
                ShareLinkService.this.k.registerBluetoothLeObserver(ShareLinkService.this.R);
                ShareLinkService.this.k.open(ShareLinkService.this.f9872a, ShareLinkService.this.b, ShareLinkService.this.e, ShareLinkService.this.f, ShareLinkService.this.g, ShareLinkService.this.h, ShareLinkService.this.q, ShareLinkService.this.i, ShareLinkService.this.E);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f9872a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public IBluetoothLe k;
    public IWifiP2p l;
    public IWifiAp m;
    public WifiOwnerConfig n;
    public UCarAuthService o;
    public boolean p;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public int x;
    public int y;
    public int z;

    public class ShareLinkStub extends IShareLinkManager.Stub {
        private ShareLinkStub() {
        }

        public void close() {
            ShareLinkService.this.t0();
        }

        public void connect(String str) {
            EasyLog.i("ShareLink", "unSupport method call");
        }

        public void disconnect() {
            ShareLinkService.this.w0();
        }

        public void disconnectBle() throws RemoteException {
            ShareLinkService.this.k.disconnectWithoutState();
        }

        public void enableUsbDeviceScanning(boolean z) throws RemoteException {
            boolean unused = ShareLinkService.this.t = z;
            ShareLinkService.this.B0(z);
        }

        public Map getDevicesSignal(int i, int i2) throws RemoteException {
            if (ShareLinkService.this.k != null) {
                return ShareLinkService.this.k.getDevicesSignal(i, i2);
            }
            EasyLog.i("ShareLink", "getDevicesSignal when bluetooth haven't initialized");
            return Collections.emptyMap();
        }

        public boolean isDeviceInMatch(String str) throws RemoteException {
            if (ShareLinkService.this.k != null) {
                return ShareLinkService.this.k.isDeviceInMatch(str);
            }
            EasyLog.i("ShareLink", "Bluetooth not initialize");
            return false;
        }

        public void open(boolean z, int i, int[] iArr, boolean z2, String str, String str2, boolean z3, boolean z4, String str3) {
            boolean unused = ShareLinkService.this.q = z;
            boolean unused2 = ShareLinkService.this.s = z2;
            boolean unused3 = ShareLinkService.this.u = z3;
            boolean unused4 = ShareLinkService.this.v = z4;
            String unused5 = ShareLinkService.this.E = str3;
            WifiUtils.e(iArr);
            ShareLinkService.this.K0(i, str, str2);
        }

        public void registerLinkObserver(ShareLinkObserver shareLinkObserver) {
            ShareLinkService.this.I.a(shareLinkObserver);
        }

        public void startScan() {
            ShareLinkService.this.P0();
        }

        public void stopAdvertise() throws RemoteException {
            ShareLinkService.this.A0(false);
            ShareLinkService.this.u0();
            if (ShareLinkService.this.G.i()) {
                ShareLinkService.this.G.j("idle");
                if (ShareLinkService.this.K.hasCallbacks(ShareLinkService.this.M)) {
                    ShareLinkService.this.I.i(6);
                }
                ShareLinkService.this.z0(false);
            }
        }

        public void stopScan() {
            ShareLinkService.this.S0();
        }

        public void unregisterLinkObserver(ShareLinkObserver shareLinkObserver) {
            ShareLinkService.this.I.s(shareLinkObserver);
        }

        public void updateDayOrNightMode(int i) {
            int unused = ShareLinkService.this.j = i;
        }

        public void updatePinCode(String str) {
            String unused = ShareLinkService.this.c = str;
        }
    }

    public final void A0(boolean z2) {
        EasyLog.e("ShareLink", "enableOpenTimeout: " + z2);
        this.K.removeCallbacks(this.L);
        if (z2) {
            this.K.postDelayed(this.L, 10000);
        }
    }

    public final void B0(boolean z2) {
        EasyLog.a("ShareLink", "set usb device scanning: " + z2);
        if (!z2) {
            AOAConnectManager.h().G();
        } else if (this.G.e()) {
            AOAConnectManager.h().C();
        } else {
            EasyLog.e("ShareLink", "Can't enable usb device scanning, current state is " + ConnectState.b().a());
        }
    }

    public final void C0(boolean z2) {
        EasyLog.e("ShareLink", "enableUserConfirmTimeout: " + z2);
        this.K.removeCallbacks(this.N);
        if (z2) {
            this.K.postDelayed(this.N, 15000);
        }
    }

    public final void D0(int i2) {
        if (this.G.i() || this.G.h()) {
            y0();
            this.I.i(i2);
            return;
        }
        EasyLog.a("ShareLink", "ignored wifi connect event");
    }

    public final boolean E0() {
        try {
            IWifiP2p iWifiP2p = this.l;
            if (iWifiP2p != null && this.y == 1001) {
                return iWifiP2p.isUserClose();
            }
            IWifiAp iWifiAp = this.m;
            if (iWifiAp == null || this.y != 1002) {
                return false;
            }
            return iWifiAp.isUserClose();
        } catch (Exception e2) {
            EasyLog.j("ShareLink", "isUserClose failed.", e2);
            return false;
        }
    }

    public final /* synthetic */ void F0() {
        EasyLog.i("ShareLink", "No response in 10000current state:" + this.G.a());
        if (this.G.e()) {
            EasyLog.i("ShareLink", "take this as open failure.");
            t0();
            this.I.o(false);
        }
    }

    public final /* synthetic */ void G0() {
        EasyLog.i("ShareLink", "key negotiation not finished in 20000");
        L0();
        this.I.i(6);
    }

    public final /* synthetic */ void H0() {
        EasyLog.i("ShareLink", "user confirm not finished in 15000");
        this.I.n(true);
        if ("usb_prepare_connecting".equals(this.G.a())) {
            this.G.j("idle");
        }
    }

    public final void I0() {
        EasyLog.i("ShareLink", "wifi onConnected, state = " + this.G.a());
        Locker.a(this);
        if (this.G.i()) {
            this.I.j();
            this.I.p(5);
            this.G.j("wifi_connected");
            return;
        }
        EasyLog.a("ShareLink", "ignored wifi event");
    }

    public final void J0(boolean z2) {
        EasyLog.i("ShareLink", "wifi onDisconnected, state=" + this.G.a());
        if (this.G.i() || this.G.h()) {
            Locker.b();
            z0(false);
            y0();
            if (this.o != null) {
                EasyLog.i("ShareLink", "key negotiation ongoing");
                this.o.g();
                this.I.i(6);
            } else {
                this.I.m(z2);
            }
            this.G.j("idle");
            return;
        }
        EasyLog.a("ShareLink", "ignored wifi event");
    }

    public void K0(int i2, String str, String str2) {
        this.x = i2;
        this.B = str;
        this.C = str2;
        this.r = false;
        if (i2 == 1001 || i2 == 1002 || i2 == 1003) {
            this.G.j("idle");
            WorkThread.a(new Runnable() {
                public void run() {
                    try {
                        EasyLog.e("ShareLink", "Open: Waiting for services bound, start at: " + SystemClock.elapsedRealtime());
                        ShareLinkService.this.H.await(10, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        EasyLog.d("ShareLink", "READY.await() failed", e);
                    }
                    EasyLog.e("ShareLink", "Open: services bound at: " + SystemClock.elapsedRealtime());
                    try {
                        if (ShareLinkService.this.x == 1001 && ShareLinkService.this.l != null) {
                            ShareLinkService.this.A0(true);
                            ShareLinkService.this.F.g(1001);
                            ShareLinkService.this.l.registerWifiP2pObserver(ShareLinkService.this.S);
                            ShareLinkService.this.l.open();
                        } else if (ShareLinkService.this.x == 1002 && ShareLinkService.this.m != null) {
                            ShareLinkService.this.A0(true);
                            ShareLinkService.this.F.g(1002);
                            ShareLinkService.this.m.registerWifiApObserver(ShareLinkService.this.T);
                            ShareLinkService.this.m.open();
                        } else if (ShareLinkService.this.x != 1003 || ShareLinkService.this.m == null || ShareLinkService.this.l == null) {
                            EasyLog.c("ShareLink", "Open failed: wifi Services binds failed");
                            ShareLinkService.this.A0(false);
                            ShareLinkService.this.I.o(false);
                        } else {
                            ShareLinkService.this.A0(true);
                            ShareLinkService.this.F.g(1001);
                            ShareLinkService.this.l.registerWifiP2pObserver(ShareLinkService.this.S);
                            ShareLinkService.this.l.open();
                        }
                    } catch (Exception e2) {
                        EasyLog.d("ShareLink", "Open failed.", e2);
                        ShareLinkService.this.A0(false);
                        ShareLinkService.this.I.o(false);
                    }
                }
            }, "Open() waiting services");
            return;
        }
        EasyLog.c("ShareLink", "wifi connectType error !!!");
    }

    public final void L0() {
        y0();
        x0();
        this.G.j("idle");
        this.F.e();
    }

    public final void M0() {
        if (this.f9872a != null) {
            this.d = BaseEncoding.base64().encode(Arrays.copyOfRange(BaseEncoding.base16().lowerCase().decode(this.f9872a.toLowerCase()), 0, 6));
        }
        AOAConnectManager.h().k(getApplicationContext(), this.b, this.f9872a, this.f, this.d, this.g, this.h);
        AOAConnectManager.h().w(new AOAConnectManager.AOAConnectListener() {
            public void a(String str, String str2) {
                EasyLog.a("ShareLink", "usbPlugged: ");
                ShareLinkService.this.G.j("usb_connecting");
                ShareLinkService.this.I.h("-1", str, str2);
                ShareLinkService.this.I.f("usb");
            }

            public void b() {
                EasyLog.a("ShareLink", "usbConnected: ");
                ShareLinkService.this.G.j("usb_prepare_connecting");
                ShareLinkService.this.I.p(3);
                ShareLinkService.this.C0(true);
            }

            public void c() {
                EasyLog.a("ShareLink", "aoa disconnected: ");
                ShareLinkService.this.C0(false);
                if (ShareLinkService.this.G.f()) {
                    ShareLinkService.this.s0();
                    ShareLinkService.this.z0(false);
                    ShareLinkService.this.G.j("usb_disconnect");
                    ShareLinkService.this.I.m(false);
                    ShareLinkService.this.G.j("idle");
                } else if (ShareLinkService.this.G.g()) {
                    ShareLinkService.this.I.i(5);
                    ShareLinkService.this.G.j("idle");
                }
            }

            public void d() {
                EasyLog.a("ShareLink", "aoa NetworkReady: ");
                ShareLinkService.this.G.j("usb_connected");
                ShareLinkService.this.C0(false);
                ShareLinkService.this.z0(true);
                ShareLinkService.this.I.j();
                ShareLinkService.this.I.p(6);
                ShareLinkService.this.N0("127.0.0.1");
            }
        });
    }

    public final void N0(String str) {
        if (this.o != null) {
            EasyLog.a("ShareLink", "stop existing auth service");
            this.o.g();
        }
        UCarAuthService uCarAuthService = new UCarAuthService(this, new UCarAuthService.UCarAuthObserver() {

            /* renamed from: a  reason: collision with root package name */
            public String f9876a = "idle";

            public void a(String str, int i) {
                ShareLinkService.this.o.g();
                UCarAuthService unused = ShareLinkService.this.o = null;
                ShareLinkService.this.z0(false);
                ShareLinkService.this.G.j(this.f9876a);
                ShareLinkService.this.I.p(9);
                ShareLinkService.this.I.d(str, i);
            }

            public void b(String str, String str2, String str3, int i) {
                if (ShareLinkService.this.G.f()) {
                    ShareLinkService.this.I.g(str, str2, "usb", str3, i);
                    ShareLinkService.this.o.e(ShareLinkService.this.d);
                } else {
                    int b2 = ShareLinkService.this.F.b();
                    EasyLog.a("ShareLink", "onClientKeyNegotiationReceived connectType = " + b2);
                    ShareLinkService.this.I.g(str, str2, 1002 == b2 ? "wifi_ap" : "wifi_p2p", str3, i);
                    ShareLinkService.this.o.e(ShareLinkService.this.c);
                }
                ShareLinkService.this.z0(true);
                ShareLinkService.this.I.p(7);
                String a2 = ShareLinkService.this.G.a();
                if (a2.contains("wifi")) {
                    ShareLinkService.this.G.j("wifi_connected");
                } else if (a2.contains("usb")) {
                    ShareLinkService.this.G.j("usb_connected");
                }
                this.f9876a = ShareLinkService.this.G.a();
            }

            public void c() {
                ShareLinkService.this.I.c();
                ShareLinkService.this.I.p(8);
            }

            public void d() {
                ShareLinkService.this.z0(false);
                ShareLinkService.this.I.n(false);
                if (this.f9876a.contains("wifi")) {
                    ShareLinkService.this.G.j("idle");
                    if (ShareLinkService.this.k != null) {
                        try {
                            ShareLinkService.this.k.allowProcessNewConnection();
                        } catch (RemoteException e) {
                            EasyLog.d("ShareLink", "call failed.", e);
                        }
                    }
                    ShareLinkService shareLinkService = ShareLinkService.this;
                    shareLinkService.B0(shareLinkService.t);
                }
            }

            public int onSelectWorkMode(int i) {
                return ShareLinkService.this.I.r(i);
            }
        }, this.A, this.j, this.D, this.E != null);
        this.o = uCarAuthService;
        uCarAuthService.f(str);
    }

    public final void O0() {
        EasyLog.e("ShareLink", "start BluetoothLe service");
        Intent intent = new Intent();
        intent.setClass(this, BluetoothLeService.class);
        bindService(intent, this.O, 1);
    }

    public void P0() {
        IBluetoothLe iBluetoothLe = this.k;
        if (iBluetoothLe != null) {
            try {
                iBluetoothLe.startScan();
            } catch (Exception e2) {
                EasyLog.d("ShareLink", "Scan devices failed.", e2);
            }
        }
    }

    public final void Q0() {
        O0();
        R0();
        M0();
    }

    public final void R0() {
        EasyLog.e("ShareLink", "start Wifi service");
        bindService(new Intent().setClass(this, WifiP2pService.class), this.P, 1);
        bindService(new Intent().setClass(this, WifiApService.class), this.Q, 1);
    }

    public void S0() {
        IBluetoothLe iBluetoothLe = this.k;
        if (iBluetoothLe != null) {
            try {
                iBluetoothLe.stopScan();
            } catch (Exception e2) {
                EasyLog.d("ShareLink", "Stop scan failed.", e2);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        Q0();
        return this.J;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r1 = this;
            super.onDestroy()
            r1.t0()
            com.share.connect.ShareObservers r0 = r1.I
            r0.b()
            android.content.ServiceConnection r0 = r1.O     // Catch:{ Exception -> 0x0010 }
            r1.unbindService(r0)     // Catch:{ Exception -> 0x0010 }
        L_0x0010:
            android.content.ServiceConnection r0 = r1.P     // Catch:{ Exception -> 0x0015 }
            r1.unbindService(r0)     // Catch:{ Exception -> 0x0015 }
        L_0x0015:
            android.content.ServiceConnection r0 = r1.Q     // Catch:{ Exception -> 0x001a }
            r1.unbindService(r0)     // Catch:{ Exception -> 0x001a }
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.share.connect.ShareLinkService.onDestroy():void");
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null && TextUtils.equals(intent.getAction(), "")) {
            this.f9872a = intent.getStringExtra("car_id");
            this.b = intent.getStringExtra("mod_id");
            this.e = intent.getStringExtra("car_name");
            this.f = intent.getStringExtra("car_short_name");
            this.g = intent.getStringExtra("protocol_version");
            this.h = intent.getStringExtra("car_vendor_custom_data");
            this.i = intent.getIntExtra("ble_rssi_threshold", -60);
            this.A = intent.getIntExtra("support_work_modes", 1);
            this.D = intent.getStringExtra("screen_info");
            EasyLog.a("ShareLink", "carId: " + this.f9872a + ",modelId: " + this.b + ",carName: " + this.e + ",carShortName: " + this.f + ",protocolVersion: " + this.g + ",vendorData: " + this.h + ",bleRSSIThreshold: " + this.i + ",supportWorkModes: " + this.A + ",screenInfo: " + this.D);
        }
        return super.onStartCommand(intent, i2, i3);
    }

    public final void s0() {
        FutureRequestManager.e().c();
    }

    public void t0() {
        EasyLog.e("ShareLink", "Closing...");
        Locker.b();
        try {
            this.t = false;
            IWifiP2p iWifiP2p = this.l;
            if (iWifiP2p != null && this.y == 1001) {
                iWifiP2p.unregisterWifiP2pObserver(this.S);
                this.l.close();
            }
            IWifiAp iWifiAp = this.m;
            if (iWifiAp != null && this.y == 1002) {
                iWifiAp.unregisterWifiApObserver(this.T);
                this.m.close();
            }
            u0();
            UCarAuthService uCarAuthService = this.o;
            if (uCarAuthService != null) {
                uCarAuthService.g();
            }
            AOAConnectManager.h().f();
            this.G.j("idle");
            this.F.e();
        } catch (Exception e2) {
            EasyLog.d("ShareLink", "close failed", e2);
        }
    }

    public final void u0() {
        try {
            IBluetoothLe iBluetoothLe = this.k;
            if (iBluetoothLe != null) {
                iBluetoothLe.unregisterBluetoothLeObserver(this.R);
                this.k.close();
            }
        } catch (Exception e2) {
            EasyLog.d("ShareLink", "closeBluetooth failed", e2);
        }
    }

    public final void v0(int i2) {
        try {
            EasyLog.e("ShareLink", "expectConnectType = " + i2);
            if (i2 == 1002) {
                int i3 = this.x;
                if (i3 == 1001 && this.l != null) {
                    EasyLog.e("ShareLink", "phone expect ap connection, but car only supports p2p connection,use p2p instead, createGroupForClient.");
                    this.F.g(1001);
                    this.l.createGroupForClient(this.F.a(), this.F.d(), this.z);
                } else if (i3 == 1002 && this.m != null) {
                    EasyLog.e("ShareLink", "phone expect ap connection, car only supports ap connection,direct createSoftAp.");
                    this.F.g(1002);
                    this.m.createSoftAp(this.z, this.B, this.C, this.u, this.w, this.v);
                } else if (i3 == 1003 && this.m != null) {
                    EasyLog.e("ShareLink", "phone expect ap connection, car supports ap&P2P connection, need close possible p2p connection and open ap");
                    this.F.g(1002);
                    IWifiP2p iWifiP2p = this.l;
                    if (iWifiP2p != null) {
                        iWifiP2p.unregisterWifiP2pObserver(this.S);
                        this.l.close();
                    }
                    IWifiAp iWifiAp = this.m;
                    if (iWifiAp != null) {
                        iWifiAp.registerWifiApObserver(this.T);
                        this.m.open();
                    }
                }
            } else {
                int i4 = this.x;
                if (i4 == 1001 && this.l != null) {
                    EasyLog.a("ShareLink", "phone expect p2p connection, car only supports p2p connection, direct createGroupForClient.");
                    this.F.g(1001);
                    this.l.createGroupForClient(this.F.a(), this.F.d(), this.z);
                } else if (i4 == 1003) {
                    EasyLog.e("ShareLink", "phone expect p2p connection, car supports ap&P2P connection,need close possible ap connection and open p2p");
                    this.F.g(1001);
                    IWifiAp iWifiAp2 = this.m;
                    if (iWifiAp2 != null) {
                        iWifiAp2.unregisterWifiApObserver(this.T);
                        this.m.close();
                    }
                    IWifiP2p iWifiP2p2 = this.l;
                    if (iWifiP2p2 != null) {
                        iWifiP2p2.registerWifiP2pObserver(this.S);
                        this.l.open();
                    }
                } else {
                    EasyLog.e("ShareLink", "the phone don't support wireless connection. please plugin USB to connect");
                    y0();
                    this.I.i(3);
                }
            }
        } catch (Exception e2) {
            EasyLog.c("ShareLink", "create wifi connection failed." + e2.toString());
            y0();
        }
    }

    public void w0() {
        EasyLog.a("ShareLink", "Disconnect.");
        boolean E0 = E0();
        s0();
        A0(false);
        z0(false);
        L0();
        this.I.m(E0);
    }

    public final void x0() {
        AOAConnectManager.h().f();
    }

    public final void y0() {
        try {
            IBluetoothLe iBluetoothLe = this.k;
            if (iBluetoothLe != null) {
                iBluetoothLe.close();
            }
            IWifiP2p iWifiP2p = this.l;
            if (iWifiP2p != null && this.y == 1001) {
                iWifiP2p.cancelConnect();
            }
            IWifiAp iWifiAp = this.m;
            if (iWifiAp != null && this.y == 1002) {
                iWifiAp.cancelConnect();
            }
        } catch (Exception e2) {
            EasyLog.j("ShareLink", "Disconnect failed.", e2);
        }
    }

    public final void z0(boolean z2) {
        EasyLog.e("ShareLink", "enableAuthTimeout: " + z2);
        this.K.removeCallbacks(this.M);
        if (z2) {
            this.K.postDelayed(this.M, 20000);
        }
    }
}
