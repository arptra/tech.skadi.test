package com.share.connect.wifip2p;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.honey.account.d3.a;
import com.honey.account.d3.b;
import com.honey.account.d3.c;
import com.honey.account.d3.d;
import com.honey.account.d3.e;
import com.share.connect.ConnectState;
import com.share.connect.utils.DebugTools;
import com.share.connect.utils.WorkThread;
import com.share.connect.wifip2p.IWifiP2p;
import com.share.connect.wifip2p.WifiP2pStateReceiver;
import com.share.connect.wifip2p.proxy.GroupInfo;
import com.share.connect.wifip2p.proxy.WifiP2pConfigBuilderProxy;
import com.share.connect.wifip2p.proxy.WifiP2pManagerProxy;
import com.upuphone.starrynet.core.ap.WiFiApManager;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class WifiP2pService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public final WifiP2pStub f9940a = new WifiP2pStub();
    public WifiP2pManager b;
    public WifiP2pManager.Channel c;
    public WifiManager d;
    public Runnable e;
    public Handler f;
    public volatile boolean g = false;
    public boolean h = false;
    public RescanRunner i;
    public Thread j;
    public ReentrantLock k = new ReentrantLock();
    public int l;
    public int m;
    public final AtomicBoolean n = new AtomicBoolean(false);
    public final Runnable o = new b(this);
    public final Runnable p = new c(this);
    public final Runnable q = new d(this);
    public BroadcastReceiver r = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (WiFiApManager.WIFI_AP_STATE_CHANGED_ACTION.equals(intent.getAction()) && 11 == intent.getIntExtra("wifi_state", 4)) {
                EasyLog.e("WifiP2pService", "SoftAp has been disabled, continue create group");
                WifiP2pService.this.y0(false);
                WifiP2pService.this.V();
            }
        }
    };
    public final WifiP2pStateReceiver s = new WifiP2pStateReceiver();
    public BroadcastReceiver t;
    public String u;
    public final List v = new ArrayList();

    public class RescanRunner implements Runnable {
        public RescanRunner() {
        }

        public void run() {
            EasyLog.i("WifiP2pService", "Haven't found p2p device in a single scan duration, rescanning.");
            WifiP2pService.this.W(true);
        }
    }

    public class WifiP2pStub extends IWifiP2p.Stub {
        private WifiP2pStub() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$createGroupForClient$0() {
            WifiP2pService.this.V();
        }

        public void cancelConnect() {
            WifiP2pService.this.z0(false);
            WifiP2pService.this.x0(false);
            WifiP2pService.this.y0(false);
            WifiP2pService.this.v0();
        }

        public void close() {
            WifiP2pService.this.R();
        }

        public void connectGroupOwner(String str, String str2, String str3, int i) {
            WifiP2pService.this.S(str, str2, str3, i);
        }

        public void createGroupForClient(int i, String str, int i2) {
            EasyLog.e("WifiP2pService", "Creating group for client: " + i + ", " + str);
            int unused = WifiP2pService.this.l = i;
            int unused2 = WifiP2pService.this.m = i2;
            WifiP2pService.this.x0(true);
            if (WifiP2pService.this.e != null) {
                EasyLog.e("WifiP2pService", "reuse existing Wifi p2p group");
                WifiP2pService.this.e.run();
            } else if (!WifiP2pService.this.h) {
                boolean unused3 = WifiP2pService.this.h = true;
                new Thread(new c(this)).start();
            } else {
                EasyLog.e("WifiP2pService", "createWifiP2pGroup func has been called, but Don't receive p2p broadcast!");
            }
        }

        public boolean isUserClose() {
            return !WifiP2pService.this.d.isWifiEnabled();
        }

        public void open() {
            WifiP2pService.this.s0();
        }

        public void registerWifiP2pObserver(WifiP2pObserver wifiP2pObserver) {
            WifiP2pService.this.t0(wifiP2pObserver);
        }

        public void unregisterWifiP2pObserver(WifiP2pObserver wifiP2pObserver) {
            WifiP2pService.this.E0(wifiP2pObserver);
        }
    }

    public final void A0() {
        this.s.d(new WifiP2pStateReceiver.OnConnectionChangedListener() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f9946a = false;

            public void a(WifiP2pInfo wifiP2pInfo, WifiP2pGroup wifiP2pGroup, NetworkInfo networkInfo) {
                if (!this.f9946a && wifiP2pInfo != null && wifiP2pInfo.groupFormed && !wifiP2pInfo.isGroupOwner && wifiP2pGroup != null && TextUtils.equals(wifiP2pGroup.getOwner().deviceAddress, WifiP2pService.this.u)) {
                    this.f9946a = true;
                    WifiP2pService.this.C0();
                    WifiP2pService.this.z0(false);
                    WifiP2pService.this.n0(wifiP2pInfo.groupOwnerAddress, wifiP2pGroup.getInterface(), wifiP2pInfo.isGroupOwner);
                }
                if (wifiP2pInfo != null && this.f9946a && !wifiP2pInfo.groupFormed) {
                    this.f9946a = false;
                    WifiP2pService.this.u0();
                    WifiP2pService.this.o0();
                }
                if (networkInfo != null) {
                    String typeName = networkInfo.getTypeName();
                    if (!TextUtils.isEmpty(typeName) && typeName.toUpperCase().contains("P2P") && networkInfo.getState() == NetworkInfo.State.DISCONNECTED && networkInfo.getDetailedState() == NetworkInfo.DetailedState.FAILED) {
                        if (this.f9946a) {
                            this.f9946a = false;
                            WifiP2pService.this.u0();
                            WifiP2pService.this.o0();
                            return;
                        }
                        EasyLog.i("WifiP2pService", "NetworkInfo.getDetailedState(): FAILED");
                        WifiP2pService.this.u0();
                        WifiP2pService.this.l0();
                        return;
                    }
                    return;
                }
                EasyLog.i("WifiP2pService", "NetworkInfo is null FAILED");
                WifiP2pService.this.u0();
                WifiP2pService.this.l0();
            }
        });
    }

    public final void B0(final GroupInfo groupInfo) {
        this.g = false;
        this.s.d(new WifiP2pStateReceiver.OnConnectionChangedListener() {
            public void a(WifiP2pInfo wifiP2pInfo, WifiP2pGroup wifiP2pGroup, NetworkInfo networkInfo) {
                if (wifiP2pInfo != null && wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner && wifiP2pGroup != null) {
                    if (WifiP2pService.this.a0()) {
                        WifiP2pService.this.b.requestGroupInfo(WifiP2pService.this.c, new WifiP2pManager.GroupInfoListener() {
                            public final /* synthetic */ void b(WifiP2pGroup wifiP2pGroup, GroupInfo groupInfo) {
                                WifiP2pService.this.p0(wifiP2pGroup, groupInfo.b());
                            }

                            public void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
                                EasyLog.a("WifiP2pService", "Actually group: " + wifiP2pGroup);
                                if (wifiP2pGroup != null) {
                                    DebugTools.a("P2p-createGroup");
                                    AnonymousClass11 r0 = AnonymousClass11.this;
                                    Runnable unused = WifiP2pService.this.e = new b(this, wifiP2pGroup, groupInfo);
                                    WifiP2pService.this.e.run();
                                    return;
                                }
                                EasyLog.i("WifiP2pService", "Group in broadcast isn't null but request return null.");
                            }
                        });
                    } else {
                        DebugTools.a("P2p-createGroup");
                        Runnable unused = WifiP2pService.this.e = new a(this, wifiP2pGroup, groupInfo);
                        WifiP2pService.this.e.run();
                    }
                    DebugTools.b("P2p-clientJoin");
                    WifiP2pService.this.s.d(new WifiP2pStateReceiver.OnConnectionChangedListener() {
                        public void a(WifiP2pInfo wifiP2pInfo, WifiP2pGroup wifiP2pGroup, NetworkInfo networkInfo) {
                            boolean z;
                            if (wifiP2pGroup != null) {
                                z = WifiP2pService.this.X(wifiP2pGroup.getClientList());
                                EasyLog.a("WifiP2pService", "hasValidClient=" + z + ", clientConnected=" + WifiP2pService.this.g);
                            } else {
                                z = false;
                            }
                            if (z) {
                                WifiP2pService.this.x0(false);
                                if (!WifiP2pService.this.g && wifiP2pInfo != null) {
                                    boolean unused = WifiP2pService.this.g = true;
                                    DebugTools.a("P2p-clientJoin");
                                    WifiP2pService.this.m0();
                                }
                            } else if (WifiP2pService.this.Z()) {
                                EasyLog.a("WifiP2pService", "ignored acceptance timeout");
                            } else if (WifiP2pService.this.g) {
                                boolean unused2 = WifiP2pService.this.g = false;
                                WifiP2pService.this.o0();
                            }
                        }
                    });
                }
            }

            public final /* synthetic */ void c(WifiP2pGroup wifiP2pGroup, GroupInfo groupInfo) {
                WifiP2pService.this.p0(wifiP2pGroup, groupInfo.b());
            }
        });
    }

    public final void C0() {
        D0((WifiP2pManager.ActionListener) null);
    }

    public final void D0(WifiP2pManager.ActionListener actionListener) {
        EasyLog.e("WifiP2pService", "stopPeerDiscovery...");
        this.s.e((WifiP2pStateReceiver.OnPeersChangedListener) null);
        if (this.c != null) {
            if (actionListener == null) {
                actionListener = new LogActionListener("WifiP2pService", "Stop peer discovery");
            }
            this.b.stopPeerDiscovery(this.c, actionListener);
        }
    }

    public void E0(WifiP2pObserver wifiP2pObserver) {
        synchronized (this.v) {
            this.v.remove(wifiP2pObserver);
        }
    }

    public void R() {
        this.s.f((WifiP2pStateReceiver.OnThisDeviceChangedListener) null);
        this.s.c(this, false);
        u0();
    }

    public void S(String str, String str2, String str3, int i2) {
        EasyLog.e("WifiP2pService", "Connecting GO: " + str + ", mac=" + str3 + ", frequency=" + i2);
        if (TextUtils.isEmpty(str3)) {
            EasyLog.c("WifiP2pService", "Empty GO mac address.");
            l0();
            return;
        }
        boolean z = true;
        z0(true);
        this.u = str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || i2 == 0) {
            z = false;
        }
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.i(str).j(str2).h(false).g(str3).f(i2);
        final WifiP2pConfig a2 = WifiP2pConfigBuilderProxy.a(groupInfo);
        if (!z || !a0() || a2 == null) {
            EasyLog.e("WifiP2pService", "Method selected: Classic");
            RescanRunner rescanRunner = new RescanRunner();
            this.i = rescanRunner;
            this.f.postDelayed(rescanRunner, 5000);
            w0(new Runnable() {
                public void run() {
                    DebugTools.b("P2p-discoverPeer");
                    WifiP2pService.this.W(false);
                }
            });
            return;
        }
        EasyLog.e("WifiP2pService", "Method selected: Q");
        w0(new Runnable() {
            public void run() {
                DebugTools.b("P2p-connectGroup");
                WifiP2pService.this.A0();
                WifiP2pService.this.b.connect(WifiP2pService.this.c, a2, new LogActionListener("WifiP2pService", "Connect group on Q") {
                    public void onFailure(int i) {
                        super.onFailure(i);
                        WifiP2pService.this.u0();
                        WifiP2pService.this.l0();
                    }
                });
            }
        });
    }

    public final void T(WifiP2pDevice wifiP2pDevice) {
        EasyLog.e("WifiP2pService", "Found target device: " + wifiP2pDevice.deviceAddress);
        DebugTools.b("P2p-connectGroup");
        WifiP2pConfig wifiP2pConfig = new WifiP2pConfig();
        wifiP2pConfig.deviceAddress = wifiP2pDevice.deviceAddress;
        A0();
        WifiP2pManager wifiP2pManager = this.b;
        WifiP2pManager.Channel channel = this.c;
        wifiP2pManager.connect(channel, wifiP2pConfig, new LogActionListener("WifiP2pService", "Connect device: " + wifiP2pConfig.deviceAddress) {
            public void onFailure(int i) {
                super.onFailure(i);
                WifiP2pService.this.u0();
                WifiP2pService.this.l0();
            }
        });
    }

    public final void U() {
        final int d2 = WifiUtils.d(this.l, this.m, this.d);
        int c2 = WifiUtils.c(d2);
        if (!a0() && d2 == 0) {
            d2 = 36;
        }
        final GroupInfo groupInfo = new GroupInfo();
        groupInfo.i("DIRECT-vs-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        groupInfo.j(UUID.randomUUID().toString().substring(0, 8));
        groupInfo.f(c2);
        groupInfo.h(true);
        if (c2 == 0) {
            groupInfo.e(2);
        }
        final WifiP2pConfig a2 = WifiP2pConfigBuilderProxy.a(groupInfo);
        w0(new Runnable() {
            public void run() {
                DebugTools.b("P2p-createGroup");
                WifiP2pService.this.B0(groupInfo);
                final AnonymousClass1 r0 = new LogActionListener("WifiP2pService", "Create group") {
                    public void onFailure(int i) {
                        super.onFailure(i);
                        WifiP2pService.this.v0();
                        WifiP2pService.this.i0();
                    }
                };
                if (!WifiP2pService.this.a0() || a2 == null) {
                    EasyLog.e("WifiP2pService", "Method selected: Classic");
                    WifiP2pManager P = WifiP2pService.this.b;
                    WifiP2pManager.Channel N = WifiP2pService.this.c;
                    int i = d2;
                    WifiP2pManagerProxy.d(P, N, i, new LogActionListener("WifiP2pService", "Set channel to " + d2) {
                        public void onFailure(int i) {
                            super.onFailure(i);
                            WifiP2pService.this.k.lock();
                            try {
                                if (WifiP2pService.this.c != null) {
                                    groupInfo.f(0);
                                    WifiP2pService.this.b.createGroup(WifiP2pService.this.c, r0);
                                }
                            } finally {
                                WifiP2pService.this.k.unlock();
                            }
                        }

                        public void onSuccess() {
                            super.onSuccess();
                            WifiP2pService.this.k.lock();
                            try {
                                if (WifiP2pService.this.c != null) {
                                    WifiP2pService.this.b.createGroup(WifiP2pService.this.c, r0);
                                }
                            } finally {
                                WifiP2pService.this.k.unlock();
                            }
                        }
                    });
                    return;
                }
                EasyLog.e("WifiP2pService", "Method selected: Q");
                WifiP2pService.this.b.createGroup(WifiP2pService.this.c, a2, r0);
            }
        });
    }

    public void V() {
        if (h0()) {
            EasyLog.i("WifiP2pService", "need wait tether closed");
        } else if (this.d.isWifiEnabled()) {
            Y();
        } else {
            this.t = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (intent.getIntExtra("wifi_state", 4) == 3) {
                        WifiP2pService.this.unregisterReceiver(this);
                        WifiP2pService.this.Y();
                    }
                }
            };
            registerReceiver(this.t, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
            if (!this.d.setWifiEnabled(true)) {
                EasyLog.c("WifiP2pService", "setWifiEnabled(true) failed, were hotspot or airplane mode activated?");
                q0();
                R();
            }
        }
    }

    public final void W(boolean z) {
        C0();
        this.f.postDelayed(new Runnable() {
            public void run() {
                WifiP2pService.this.s.e(new WifiP2pStateReceiver.OnPeersChangedListener() {
                    public void a(WifiP2pDeviceList wifiP2pDeviceList) {
                        WifiP2pDevice wifiP2pDevice = wifiP2pDeviceList.get(WifiP2pService.this.u);
                        if (wifiP2pDevice != null) {
                            WifiP2pService.this.f.removeCallbacks(WifiP2pService.this.i);
                            WifiP2pService.this.s.e((WifiP2pStateReceiver.OnPeersChangedListener) null);
                            DebugTools.a("P2p-discoverPeer");
                            WifiP2pService.this.T(wifiP2pDevice);
                        }
                    }
                });
                WifiP2pService.this.b.discoverPeers(WifiP2pService.this.c, new LogActionListener("WifiP2pService", "Discover peers") {
                    public void onFailure(int i) {
                        super.onFailure(i);
                        WifiP2pService.this.f.removeCallbacks(WifiP2pService.this.i);
                        WifiP2pService.this.u0();
                        WifiP2pService.this.l0();
                    }
                });
            }
        }, z ? 500 : 0);
    }

    public final boolean X(Collection collection) {
        return !collection.isEmpty();
    }

    public final void Y() {
        this.k.lock();
        try {
            WifiP2pManager.Channel channel = this.c;
            if (channel != null) {
                channel.close();
                this.c = null;
            }
        } catch (Exception e2) {
            EasyLog.d("WifiP2pService", "Channel close failed.", e2);
        } catch (Throwable th) {
            this.k.unlock();
            throw th;
        }
        this.c = this.b.initialize(this, getMainLooper(), (WifiP2pManager.ChannelListener) null);
        this.k.unlock();
        if (this.c == null) {
            EasyLog.c("WifiP2pService", "P2pChannel is null");
            q0();
        } else if (a0()) {
            this.b.requestDeviceInfo(this.c, new WifiP2pManager.DeviceInfoListener() {
                public void onDeviceInfoAvailable(WifiP2pDevice wifiP2pDevice) {
                    if (wifiP2pDevice != null) {
                        WifiP2pService.this.U();
                        return;
                    }
                    EasyLog.c("WifiP2pService", "Device info is null.");
                    WifiP2pService.this.q0();
                }
            });
            this.s.c(this, true);
            this.s.f(new WifiP2pStateReceiver.OnThisDeviceChangedListener() {
                public void a(WifiP2pDevice wifiP2pDevice) {
                    WifiP2pService.this.k.lock();
                    try {
                        if (WifiP2pService.this.c == null) {
                            EasyLog.i("WifiP2pService", "onThisDeviceChanged: mChannel is null, return!");
                            return;
                        }
                        EasyLog.a("WifiP2pService", "Requesting device info...");
                        WifiP2pService.this.b.requestDeviceInfo(WifiP2pService.this.c, new WifiP2pManager.DeviceInfoListener() {
                            public void onDeviceInfoAvailable(WifiP2pDevice wifiP2pDevice) {
                                if (wifiP2pDevice != null) {
                                    EasyLog.e("WifiP2pService", "Device changed: " + wifiP2pDevice);
                                    WifiP2pService.this.j0(wifiP2pDevice.deviceAddress);
                                    return;
                                }
                                EasyLog.c("WifiP2pService", "Device info is null.");
                            }
                        });
                        WifiP2pService.this.k.unlock();
                    } finally {
                        WifiP2pService.this.k.unlock();
                    }
                }
            });
        } else {
            this.s.f(new WifiP2pStateReceiver.OnThisDeviceChangedListener() {
                public void a(WifiP2pDevice wifiP2pDevice) {
                    WifiP2pService.this.s.f((WifiP2pStateReceiver.OnThisDeviceChangedListener) null);
                    WifiP2pService.this.U();
                }
            });
            this.s.c(this, true);
        }
    }

    public final boolean Z() {
        return this.f.hasCallbacks(this.p);
    }

    public final boolean a0() {
        EasyLog.e("WifiP2pService", "Build.VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
        return true;
    }

    public final boolean b0() {
        return this.f.hasCallbacks(this.q);
    }

    public final /* synthetic */ void c0() {
        EasyLog.i("WifiP2pService", "Haven't found p2p device, cancel peer discovery");
        C0();
        l0();
    }

    public final /* synthetic */ void d0(WifiP2pDeviceList wifiP2pDeviceList) {
        if (!X(wifiP2pDeviceList.getDeviceList())) {
            EasyLog.i("WifiP2pService", "No client join. notifyOnDisconnected");
            this.g = false;
            u0();
            o0();
        }
    }

    public final /* synthetic */ void e0() {
        if (!this.g) {
            EasyLog.i("WifiP2pService", "No client join. notifyOnAcceptFailed");
            v0();
            k0();
            return;
        }
        this.b.requestPeers(this.c, new e(this));
    }

    public final /* synthetic */ void f0() {
        EasyLog.c("WifiP2pService", "close tethering failure");
        if (ConnectState.b().i()) {
            i0();
        }
    }

    public final /* synthetic */ void g0() {
        this.k.lock();
        try {
            WifiP2pManager.Channel channel = this.c;
            if (channel != null) {
                channel.close();
                this.c = null;
            }
        } catch (Exception e2) {
            EasyLog.d("WifiP2pService", "Channel close failed.", e2);
        } catch (Throwable th) {
            this.k.unlock();
            throw th;
        }
        this.k.unlock();
    }

    public final boolean h0() {
        int i2;
        try {
            i2 = ((Integer) WifiManager.class.getMethod("getWifiApState", (Class[]) null).invoke(this.d, (Object[]) null)).intValue();
        } catch (Exception e2) {
            EasyLog.d("WifiP2pService", "call getWifiApState method error: ", e2);
            i2 = 0;
        }
        if (i2 != 13 && i2 != 12 && i2 != 14 && i2 != 10) {
            return false;
        }
        EasyLog.e("WifiP2pService", "wifi ap state = " + i2 + ", stopTethering");
        y0(true);
        if (i2 == 10) {
            EasyLog.e("WifiP2pService", "wifi ap state is disabling, waiting for it to be disabled");
            return true;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                Class.forName("android.net.TetheringManager").getMethod("stopTethering", new Class[]{Integer.TYPE}).invoke(getSystemService("tethering"), new Object[]{0});
            } catch (Exception e3) {
                EasyLog.d("WifiP2pService", "call stopTetheringMethod error", e3);
            }
        } else {
            try {
                Field declaredField = ConnectivityManager.class.getDeclaredField("mService");
                declaredField.setAccessible(true);
                Class.forName("android.net.IConnectivityManager").getDeclaredMethod("stopTethering", new Class[]{Integer.TYPE, String.class}).invoke(declaredField.get((ConnectivityManager) getSystemService("connectivity")), new Object[]{0, getPackageName()});
            } catch (Exception e4) {
                EasyLog.d("WifiP2pService", "call old function for stopTethering error", e4);
            }
        }
        return true;
    }

    public final void i0() {
        synchronized (this.v) {
            for (WifiP2pObserver onCreateGroupFailed : this.v) {
                try {
                    onCreateGroupFailed.onCreateGroupFailed();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onAcceptFailed() failed.", e2);
                }
            }
        }
    }

    public final void j0(String str) {
        synchronized (this.v) {
            for (WifiP2pObserver onDeviceChanged : this.v) {
                try {
                    onDeviceChanged.onDeviceChanged(str);
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onDeviceChanged(" + str + ") failed.", e2);
                }
            }
        }
    }

    public final void k0() {
        synchronized (this.v) {
            for (WifiP2pObserver onAcceptFailed : this.v) {
                try {
                    onAcceptFailed.onAcceptFailed();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onAcceptFailed() failed.", e2);
                }
            }
        }
    }

    public final void l0() {
        synchronized (this.v) {
            for (WifiP2pObserver onConnectFailed : this.v) {
                try {
                    onConnectFailed.onConnectFailed();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onConnectFailed() failed.", e2);
                }
            }
        }
    }

    public void m0() {
        synchronized (this.v) {
            for (WifiP2pObserver onConnected : this.v) {
                try {
                    onConnected.onConnected();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onConnect() failed.", e2);
                }
            }
        }
    }

    public final void n0(final InetAddress inetAddress, final String str, boolean z) {
        WorkThread.a(new Runnable() {
            public void run() {
                try {
                    String hostAddress = inetAddress.getHostAddress();
                    String a2 = NetworkInterfaceUtils.a(NetworkInterface.getByName(str));
                    EasyLog.a("WifiP2pService", "Group owner address: " + hostAddress + ", local address: " + a2);
                    for (int i = 0; i < 10; i++) {
                        if (inetAddress.isReachable(200)) {
                            EasyLog.a("WifiP2pService", "isReachable=true, ready to notifyOnConnected.");
                            DebugTools.a("P2p-connectGroup");
                            WifiP2pService.this.m0();
                            return;
                        }
                        EasyLog.i("WifiP2pService", "isReachable=false, waiting...");
                        Thread.sleep(200);
                    }
                    EasyLog.c("WifiP2pService", "Network can't reach.");
                    WifiP2pService.this.l0();
                } catch (Exception e) {
                    EasyLog.d("WifiP2pService", "checking is reachable exception: ", e);
                    WifiP2pService.this.l0();
                }
            }
        }, "Check address reachable");
    }

    public final void o0() {
        Iterator it;
        synchronized (this.v) {
            try {
                it = this.v.iterator();
            } catch (RemoteException e2) {
                EasyLog.d("WifiP2pService", "Observer.onDisconnected() failed.", e2);
            } finally {
            }
            while (it.hasNext()) {
                WifiP2pObserver wifiP2pObserver = (WifiP2pObserver) it.next();
                if (this.d.isWifiEnabled()) {
                    wifiP2pObserver.onDisconnected(false);
                } else {
                    wifiP2pObserver.onDisconnected(true);
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f9940a;
    }

    public void onCreate() {
        super.onCreate();
        this.f = new Handler();
        this.d = (WifiManager) getSystemService("wifi");
        this.b = (WifiP2pManager) getSystemService("wifip2p");
    }

    public void onDestroy() {
        super.onDestroy();
        R();
    }

    public final void p0(WifiP2pGroup wifiP2pGroup, int i2) {
        synchronized (this.v) {
            for (WifiP2pObserver onGroupCreated : this.v) {
                try {
                    onGroupCreated.onGroupCreated(wifiP2pGroup, i2);
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onGroupCreated(...) failed.", e2);
                }
            }
        }
    }

    public final void q0() {
        synchronized (this.v) {
            for (WifiP2pObserver onOpenFailed : this.v) {
                try {
                    onOpenFailed.onOpenFailed();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onOpenFailed() failed.", e2);
                }
            }
        }
    }

    public final void r0() {
        synchronized (this.v) {
            for (WifiP2pObserver onOpenSuccess : this.v) {
                try {
                    onOpenSuccess.onOpenSuccess();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiP2pService", "Observer.onOpenSuccess() failed.", e2);
                }
            }
        }
    }

    public void s0() {
        r0();
    }

    public void t0(WifiP2pObserver wifiP2pObserver) {
        synchronized (this.v) {
            try {
                if (!this.v.contains(wifiP2pObserver)) {
                    this.v.add(wifiP2pObserver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u0() {
        EasyLog.e("WifiP2pService", "reset...");
        this.s.e((WifiP2pStateReceiver.OnPeersChangedListener) null);
        this.s.d((WifiP2pStateReceiver.OnConnectionChangedListener) null);
        if (!a0()) {
            this.s.f((WifiP2pStateReceiver.OnThisDeviceChangedListener) null);
        }
        this.u = null;
        z0(false);
        x0(false);
        y0(false);
        v0();
    }

    public void v0() {
        this.h = false;
        w0(new a(this));
    }

    public final void w0(final Runnable runnable) {
        EasyLog.e("WifiP2pService", "resetP2pNetworks...");
        Thread thread = this.j;
        if (thread != null) {
            thread.interrupt();
            try {
                this.j.join(50);
            } catch (Exception e2) {
                EasyLog.d("WifiP2pService", "Wait last reset thread error.", e2);
            }
            this.j = null;
        }
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                if (WifiP2pService.this.c != null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    try {
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        WifiP2pService.this.D0(new LatchActionListener("WifiP2pService", "Stop peer discovery", countDownLatch));
                        if (!countDownLatch.await(5, timeUnit)) {
                            EasyLog.i("WifiP2pService", "Stop peer discovery timeout.");
                        }
                        EasyLog.a("WifiP2pService", "Removing group...");
                        CountDownLatch countDownLatch2 = new CountDownLatch(1);
                        WifiP2pService.this.b.removeGroup(WifiP2pService.this.c, new LatchActionListener("WifiP2pService", "Remove group", countDownLatch2));
                        if (!countDownLatch2.await(5, timeUnit)) {
                            EasyLog.i("WifiP2pService", "Remove group timeout.");
                        }
                        EasyLog.a("WifiP2pService", "Reset p2p channel...");
                        CountDownLatch countDownLatch3 = new CountDownLatch(1);
                        if (WifiP2pManagerProxy.d(WifiP2pService.this.b, WifiP2pService.this.c, 0, new LatchActionListener("WifiP2pService", "Reset channel", countDownLatch3)) && !countDownLatch3.await(5, timeUnit)) {
                            EasyLog.i("WifiP2pService", "Reset p2p channel timeout.");
                        }
                        EasyLog.a("WifiP2pService", "Cancel invited requests...");
                        CountDownLatch countDownLatch4 = new CountDownLatch(1);
                        WifiP2pService.this.b.cancelConnect(WifiP2pService.this.c, new LatchActionListener("WifiP2pService", "Cancel invited requests", countDownLatch4));
                        if (!countDownLatch4.await(5, timeUnit)) {
                            EasyLog.i("WifiP2pService", "Cancel invited requests timeout.");
                        }
                        WifiP2pManagerProxy.a(WifiP2pService.this.b, WifiP2pService.this.c);
                    } catch (Exception e) {
                        EasyLog.d("WifiP2pService", "Latch await failed.", e);
                    }
                } else {
                    EasyLog.i("WifiP2pService", "Channel is null, resetP2pNetworks is not executable");
                }
                if (runnable != null && !Thread.currentThread().isInterrupted()) {
                    WifiP2pService.this.f.post(runnable);
                }
            }
        }, "Reset networks");
        this.j = thread2;
        thread2.start();
        this.e = null;
    }

    public final void x0(boolean z) {
        EasyLog.e("WifiP2pService", "setAcceptTimeout: " + z);
        if (Z()) {
            this.f.removeCallbacks(this.p);
        }
        if (z) {
            this.f.postDelayed(this.p, 30000);
        }
    }

    public final void y0(boolean z) {
        EasyLog.e("WifiP2pService", "setCloseApListenerTimeout: " + z);
        if (b0()) {
            this.f.removeCallbacks(this.q);
        }
        if (z) {
            if (this.n.compareAndSet(false, true)) {
                registerReceiver(this.r, new IntentFilter(WiFiApManager.WIFI_AP_STATE_CHANGED_ACTION));
            }
            this.f.postDelayed(this.q, 3000);
        } else if (this.n.compareAndSet(true, false)) {
            try {
                unregisterReceiver(this.r);
            } catch (Exception unused) {
            }
        }
    }

    public final void z0(boolean z) {
        EasyLog.e("WifiP2pService", "setJoinTimeout: " + z);
        if (z) {
            this.f.postDelayed(this.o, 20000);
        } else {
            this.f.removeCallbacks(this.o);
        }
    }
}
