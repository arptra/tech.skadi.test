package com.share.connect.wifiap;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.honey.account.c3.b;
import com.honey.account.c3.e;
import com.honey.account.c3.f;
import com.honey.account.c3.g;
import com.honey.account.c3.h;
import com.honey.account.c3.i;
import com.honey.account.c3.j;
import com.honey.account.c3.k;
import com.honey.account.c3.l;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.net.pedometerprovider.util.Constants;
import com.share.connect.ConnectState;
import com.share.connect.wifiap.IWifiAp;
import com.share.connect.wifiap.WifiApConfigHelper;
import com.share.connect.wifip2p.WifiUtils;
import com.upuphone.starrynet.core.ap.WiFiApManager;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WifiApService extends Service {
    public final List A = new ArrayList();
    public final BroadcastReceiver B = new BroadcastReceiver() {
        public final /* synthetic */ void b() {
            EasyLog.a("WifiApService", "ap disconnect, reset state");
            boolean unused = WifiApService.this.n = false;
            boolean unused2 = WifiApService.this.o = false;
            boolean unused3 = WifiApService.this.p = false;
            Runnable unused4 = WifiApService.this.f = null;
            String unused5 = WifiApService.this.j = null;
            String unused6 = WifiApService.this.i = null;
            WifiApService.this.D0();
            WifiApService.this.r0();
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (WiFiApManager.WIFI_AP_STATE_CHANGED_ACTION.equals(action)) {
                int intExtra = intent.getIntExtra("wifi_state", 14);
                EasyLog.a("WifiApService", "receiver WIFI_AP_STATE_CHANGED_ACTION,  state = " + intExtra + " connect state = " + ConnectState.b().a());
                if (intExtra == 11) {
                    WifiApService.this.d.post(new a(this));
                }
            } else if ("android.net.conn.TETHER_STATE_CHANGED".equals(action)) {
                EasyLog.a("WifiApService", "ACTION_TETHER_STATE_CHANGED !");
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tetherArray");
                if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
                    Message obtain = Message.obtain();
                    obtain.what = 13;
                    obtain.obj = stringArrayListExtra;
                    WifiApService.this.d.sendMessage(obtain);
                }
            }
        }
    };
    public final Runnable C = new h(this);
    public final Runnable D = new i(this);
    public final Runnable E = new j(this);

    /* renamed from: a  reason: collision with root package name */
    public final WifiApStub f9925a = new WifiApStub();
    public WifiManager b;
    public ConnectivityManager c;
    public Handler d = null;
    public HandlerThread e = null;
    public Runnable f;
    public Object g;
    public final Executor h = Executors.newSingleThreadExecutor();
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public int m = 36;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public String v = null;
    public String w = null;
    public SoftApConfiguration x;
    public int y = 0;
    public boolean z = false;

    public final class ApCallbackHandler implements InvocationHandler {
        public ApCallbackHandler() {
        }

        public final /* synthetic */ void f(List list) {
            WifiApService.this.v0(false);
            if (list.get(0) != null && !WifiApService.this.o) {
                EasyLog.a("WifiApService", "onConnectedClientsChanged WifiClient = " + list.get(0));
                WifiApService.this.m0();
                boolean unused = WifiApService.this.o = true;
            }
        }

        public final /* synthetic */ void g() {
            if (WifiApService.this.o && !WifiApService.this.Z()) {
                boolean unused = WifiApService.this.o = false;
                WifiApService.this.n0();
            }
        }

        public final /* synthetic */ void h(int i, SoftApConfiguration softApConfiguration) {
            EasyLog.a("WifiApService", "onInfoChanged mIsApCreated: " + WifiApService.this.n + ", freq: " + i + ", mIsAllowReconfigureWifi: " + WifiApService.this.s + ", mIsSystemApEnabled: " + WifiApService.this.p);
            if (!WifiApService.this.n && i != 0 && !WifiApService.this.s) {
                SoftApConfiguration unused = WifiApService.this.x = softApConfiguration;
                int unused2 = WifiApService.this.y = i;
                WifiApService.this.x0(true);
                WifiApService.this.W();
            }
        }

        public final /* synthetic */ void i() {
            WifiApService.this.v0(false);
            if (!WifiApService.this.o) {
                WifiApService.this.m0();
                boolean unused = WifiApService.this.o = true;
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            int i;
            if (Build.VERSION.SDK_INT >= 30) {
                if (TextUtils.equals("onConnectedClientsChanged", method.getName())) {
                    List list = objArr.length == 2 ? objArr[1] : objArr[0];
                    EasyLog.a("WifiApService", "onConnectedClientsChanged clientNum: " + list.size() + ", currentState: " + ConnectState.b().a());
                    if (list.isEmpty()) {
                        WifiApService.this.d.post(new c(this));
                    } else if (!ConnectState.b().i()) {
                        EasyLog.a("WifiApService", "onConnectedClientsChanged not in wireless connecting, ignore");
                        return null;
                    } else {
                        WifiApService.this.d.post(new b(this, list));
                    }
                    return null;
                } else if (TextUtils.equals("onInfoChanged", method.getName())) {
                    try {
                        Method method2 = Class.forName("android.net.wifi.SoftApInfo").getMethod("getFrequency", (Class[]) null);
                        List list2 = objArr[0];
                        if (!(list2 instanceof List)) {
                            i = ((Integer) method2.invoke(list2, (Object[]) null)).intValue();
                        } else if (list2.size() > 0) {
                            i = ((Integer) method2.invoke(objArr[0].get(0), (Object[]) null)).intValue();
                        } else {
                            EasyLog.c("WifiApService", "onInfoChanged SoftApInfo list size is 0");
                            return null;
                        }
                        SoftApConfiguration a2 = b.a(WifiManager.class.getMethod("getSoftApConfiguration", (Class[]) null).invoke(WifiApService.this.b, (Object[]) null));
                        EasyLog.a("WifiApService", "SoftApInfo freq = " + i + " ssid = " + a2.getSsid());
                        WifiApService.this.d.post(new d(this, i, a2));
                        return null;
                    } catch (Exception e) {
                        EasyLog.d("WifiApService", "onInfoChanged reflect error: ", e);
                        return null;
                    }
                }
            } else if (TextUtils.equals("onStateChanged", method.getName())) {
                EasyLog.a("WifiApService", "onStateChanged state = " + objArr[0]);
                return null;
            } else if (TextUtils.equals("onNumClientsChanged", method.getName())) {
                EasyLog.a("WifiApService", "onNumClientsChanged WifiClient size = " + objArr[0] + ", currentState: " + ConnectState.b().a());
                if (WifiApService.this.X() != 13 || objArr[0].intValue() <= 0) {
                    WifiApService.this.d.post(new f(this, objArr));
                } else if (!ConnectState.b().i()) {
                    EasyLog.a("WifiApService", "onNumClientsChanged not in wireless connecting, ignore");
                    return null;
                } else {
                    WifiApService.this.d.post(new e(this));
                }
                return null;
            }
            if (String.class == method.getReturnType()) {
                return "";
            }
            if (Integer.class == method.getReturnType() || Integer.TYPE == method.getReturnType()) {
                return 0;
            }
            if (Boolean.class == method.getReturnType()) {
                return Boolean.FALSE;
            }
            if (Boolean.TYPE == method.getReturnType()) {
                return Boolean.FALSE;
            }
            return null;
        }

        public final /* synthetic */ void j(Object[] objArr) {
            if (WifiApService.this.o && objArr[0].intValue() == 0 && !WifiApService.this.Z()) {
                boolean unused = WifiApService.this.o = false;
                WifiApService.this.n0();
            }
        }
    }

    public class WifiApHandler extends Handler {
        public WifiApHandler(Looper looper) {
            super(looper);
        }

        public final /* synthetic */ void c() {
            WifiApService wifiApService = WifiApService.this;
            wifiApService.l0(wifiApService.i, WifiApService.this.j, WifiApService.this.l, WifiApService.this.k, WifiUtils.c(WifiApService.this.m));
            boolean unused = WifiApService.this.n = true;
        }

        public final /* synthetic */ void d() {
            WifiApService wifiApService = WifiApService.this;
            wifiApService.l0(wifiApService.i, WifiApService.this.j, WifiApService.this.l, WifiApService.this.k, WifiUtils.c(WifiApService.this.m));
            boolean unused = WifiApService.this.n = true;
        }

        public void handleMessage(Message message) {
            String str;
            if (message.what == 13) {
                ArrayList arrayList = (ArrayList) message.obj;
                EasyLog.a("WifiApService", "tetherList = " + arrayList);
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    str = (String) it.next();
                    if (!str.startsWith("eth")) {
                        EasyLog.a("WifiApService", "tether name = " + str);
                        break;
                    }
                }
                if (str == null) {
                    EasyLog.c("WifiApService", "don't find matched wifi tether");
                    return;
                }
                WifiApService.this.w0(str);
                try {
                    if (!WifiApService.this.n) {
                        if (WifiApService.this.i == null) {
                            boolean unused = WifiApService.this.p = true;
                            WifiApConfigHelper b = new WifiApConfigHelper.Builder(WifiApService.this.b).b();
                            if (!WifiApService.this.b0(b.e()) || TextUtils.isEmpty(b.d()) || !WifiApService.this.Y(b.a())) {
                                EasyLog.a("WifiApService", "the existing soft ap config is invalid");
                                return;
                            }
                            EasyLog.a("WifiApService", "the existing soft ap config ---- " + b);
                            WifiApService.this.t0();
                            String unused2 = WifiApService.this.i = b.e();
                            int unused3 = WifiApService.this.m = b.b();
                            String unused4 = WifiApService.this.j = b.d();
                        }
                        if (Build.VERSION.SDK_INT < 30) {
                            Runnable unused5 = WifiApService.this.f = new h(this);
                            WifiApService.this.f.run();
                        } else if (WifiApService.this.s) {
                            EasyLog.a("WifiApService", "allowReconfigureWifi, notify ap info to HMI");
                            Runnable unused6 = WifiApService.this.f = new g(this);
                            WifiApService.this.f.run();
                        } else {
                            boolean unused7 = WifiApService.this.z = true;
                            WifiApService.this.W();
                        }
                    }
                } catch (Exception e) {
                    EasyLog.d("WifiApService", "onReceive ACTION_TETHER_STATE_CHANGED error: ", e);
                }
            }
        }
    }

    public class WifiApStub extends IWifiAp.Stub {
        private WifiApStub() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$createSoftAp$0(String str, String str2, int i, boolean z, boolean z2, boolean z3) {
            EasyLog.a("WifiApService", "createSoftAp ssid: " + str + ", password: " + str2 + ", channel: " + i + ", isApStaCoexist: " + z + ", ssidNeedPrefix: " + z2 + ", isAllowReconfigureWifi: " + z3);
            boolean unused = WifiApService.this.q = z2;
            boolean unused2 = WifiApService.this.r = z;
            boolean unused3 = WifiApService.this.s = z3;
            WifiApConfigHelper b = new WifiApConfigHelper.Builder(WifiApService.this.b).b();
            if (WifiApService.this.b0(b.e())) {
                str = b.e();
            } else if (TextUtils.isEmpty(str)) {
                str = "DIRECT-ICCOA-" + UUID.randomUUID().toString().substring(0, 3).toUpperCase();
            } else if (z2 && !str.matches("^DIRECT-[a-zA-Z0-9]{2}.*")) {
                str = "DIRECT-ICCOA-" + UUID.randomUUID().toString().substring(0, 3).toUpperCase();
            }
            String d = b.d();
            if (TextUtils.isEmpty(d)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString().substring(0, 8);
                }
                d = str2;
            }
            WifiApService.this.v0(true);
            boolean unused4 = WifiApService.this.o = false;
            if (WifiApService.this.i == null || !WifiApService.this.i.equals(str) || WifiApService.this.X() != 13) {
                WifiApService.this.z0(i, str, d);
                return;
            }
            EasyLog.e("WifiApService", "reuse existing Wifi softAp");
            if (WifiApService.this.f != null) {
                WifiApService.this.f.run();
            } else if (ConnectState.b().i()) {
                EasyLog.e("WifiApService", "Wireless is connecting, but the softAp is not ready");
                WifiApService.this.z0(i, str, d);
            }
        }

        public void cancelConnect() {
            WifiApService.this.d.post(new l(WifiApService.this));
        }

        public void close() {
            WifiApService.this.d.post(new l(WifiApService.this));
        }

        public void createSoftAp(int i, String str, String str2, boolean z, boolean z2, boolean z3) {
            WifiApService.this.d.post(new i(this, str, str2, i, z, z2, z3));
        }

        public boolean isUserClose() {
            return !WifiApService.this.t && (WifiApService.this.X() == 10 || WifiApService.this.X() == 11);
        }

        public void open() {
            WifiApService.this.q0();
        }

        public void registerWifiApObserver(WifiApObserver wifiApObserver) {
            WifiApService.this.u0(wifiApObserver);
        }

        public void unregisterWifiApObserver(WifiApObserver wifiApObserver) {
            WifiApService.this.E0(wifiApObserver);
        }
    }

    public final class startTetheringCallbackHandler implements InvocationHandler {
        public startTetheringCallbackHandler() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (TextUtils.equals("onTetheringStarted", method.getName())) {
                EasyLog.a("WifiApService", "WifiApService startTethering Success");
                return null;
            } else if (!TextUtils.equals("onTetheringFailed", method.getName())) {
                return null;
            } else {
                EasyLog.a("WifiApService", "WifiApService startTethering failed, error num: " + objArr[0]);
                WifiApService.this.k0();
                return null;
            }
        }
    }

    public final void A0(String str, String str2) {
        this.n = false;
        this.i = str;
        this.j = str2;
        if (Build.VERSION.SDK_INT >= 30) {
            EasyLog.a("WifiApService", "call new function for startTethering");
            i0();
            return;
        }
        EasyLog.a("WifiApService", "call old function for startTethering");
        p0();
    }

    public void B0() {
        if (this.p) {
            EasyLog.a("WifiApService", "we should keep system softAp alive");
        } else if (this.c != null) {
            D0();
            if (X() == 13 || X() == 12 || X() == 14) {
                EasyLog.e("WifiApService", "wifi ap state = " + X() + ", stopTethering");
                this.t = true;
                if (Build.VERSION.SDK_INT >= 30) {
                    try {
                        Class.forName("android.net.TetheringManager").getMethod("stopTethering", new Class[]{Integer.TYPE}).invoke(getSystemService("tethering"), new Object[]{0});
                    } catch (Exception e2) {
                        EasyLog.d("WifiApService", "call stopTetheringMethod error", e2);
                    }
                } else {
                    try {
                        Field declaredField = ConnectivityManager.class.getDeclaredField("mService");
                        declaredField.setAccessible(true);
                        Class.forName("android.net.IConnectivityManager").getDeclaredMethod("stopTethering", new Class[]{Integer.TYPE, String.class}).invoke(declaredField.get(this.c), new Object[]{0, getPackageName()});
                    } catch (Exception e3) {
                        EasyLog.d("WifiApService", "call old function for stopTethering error", e3);
                    }
                }
            }
        }
    }

    public final String C0(byte[] bArr) {
        if (bArr == null) {
            EasyLog.c("WifiApService", "MacAddress params is null");
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(hexString);
            } else {
                stringBuffer.append(hexString);
            }
            if (i2 < length - 1) {
                stringBuffer.append(AccountConstantKt.CODE_SEPARTOR);
            }
        }
        return String.valueOf(stringBuffer);
    }

    public final void D0() {
        if (this.g != null) {
            try {
                WifiManager.class.getMethod("unregisterSoftApCallback", new Class[]{Class.forName("android.net.wifi.WifiManager$SoftApCallback")}).invoke(this.b, new Object[]{this.g});
            } catch (Exception e2) {
                EasyLog.d("WifiApService", "call unregisterSoftApCallback error", e2);
            } catch (Throwable th) {
                this.g = null;
                throw th;
            }
            this.g = null;
        }
    }

    public void E0(WifiApObserver wifiApObserver) {
        synchronized (this.A) {
            this.A.remove(wifiApObserver);
        }
    }

    public final void V(boolean z2) {
        if (this.b != null && !z2 && ConnectState.b().i()) {
            if (this.b.getWifiState() == 3 || this.b.getWifiState() == 2) {
                EasyLog.a("WifiApService", "disable wifi, before start startTethering");
                this.b.setWifiEnabled(false);
            }
        }
    }

    public final void W() {
        if (this.x == null) {
            EasyLog.a("WifiApService", "checkTetherCreate config is null, wait info callback");
        } else if (!this.z) {
            EasyLog.a("WifiApService", "checkTetherCreate tether not ready");
        } else {
            x0(false);
            SoftApConfiguration softApConfiguration = this.x;
            this.x = null;
            k kVar = new k(this, softApConfiguration);
            this.f = kVar;
            if (!this.p) {
                kVar.run();
            }
        }
    }

    public final int X() {
        try {
            return ((Integer) WifiManager.class.getMethod("getWifiApState", (Class[]) null).invoke(this.b, (Object[]) null)).intValue();
        } catch (Exception e2) {
            EasyLog.d("WifiApService", "call getWifiApState method error: ", e2);
            return 0;
        }
    }

    public final boolean Y(int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 30 || i2 == 2) {
            return i3 >= 30 || i2 == 1;
        }
        return false;
    }

    public final boolean Z() {
        return this.d.hasCallbacks(this.E);
    }

    public final boolean a0(String str) {
        try {
            return InetAddress.getByName(str) instanceof Inet4Address;
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    public final boolean b0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length < 9 || bytes.length > 32) {
            return false;
        }
        return !this.q || str.matches("^DIRECT-[a-zA-Z0-9]{2}.*");
    }

    public final /* synthetic */ void c0(SoftApConfiguration softApConfiguration) {
        l0(softApConfiguration.getSsid(), softApConfiguration.getPassphrase(), this.l, this.k, this.y);
        this.n = true;
    }

    public final /* synthetic */ void d0() {
        EasyLog.i("WifiApService", "tether reset timeout!");
        k0();
    }

    public final /* synthetic */ void e0() {
        if (!this.z) {
            EasyLog.i("WifiApService", "tether ready timeout!");
            k0();
        }
    }

    public final /* synthetic */ void f0() {
        if (!this.o) {
            EasyLog.i("WifiApService", "No client join. notifyOnAcceptFailed");
            B0();
            j0();
        }
    }

    public final /* synthetic */ void g0(IntentFilter intentFilter) {
        registerReceiver(this.B, intentFilter);
    }

    public final /* synthetic */ void h0() {
        B0();
        unregisterReceiver(this.B);
    }

    public final void i0() {
        if (this.c != null) {
            try {
                WifiApConfigHelper.Builder e2 = new WifiApConfigHelper.Builder().f(this.i).e(this.j);
                int i2 = this.m;
                if (i2 != 0) {
                    e2.d(i2);
                } else {
                    e2.c(2);
                }
                WifiApConfigHelper b2 = e2.b();
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
                wifiManager.getClass().getMethod("setSoftApConfiguration", new Class[]{e.a()}).invoke(wifiManager, new Object[]{b2.c()});
                t0();
                Class<?> cls = Class.forName("android.net.TetheringManager$TetheringRequest$Builder");
                Object newInstance = cls.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{0});
                Method method = cls.getMethod("setShouldShowEntitlementUi", new Class[]{Boolean.TYPE});
                Method method2 = cls.getMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, (Class[]) null);
                method.invoke(newInstance, new Object[]{Boolean.TRUE});
                Object invoke = method2.invoke(newInstance, (Object[]) null);
                Class<?> cls2 = Class.forName("android.net.TetheringManager$StartTetheringCallback");
                Class.forName("android.net.TetheringManager").getMethod("startTethering", new Class[]{Class.forName("android.net.TetheringManager$TetheringRequest"), Executor.class, cls2}).invoke(getSystemService("tethering"), new Object[]{invoke, Executors.newSingleThreadExecutor(), Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new startTetheringCallbackHandler())});
            } catch (Exception e3) {
                EasyLog.d("WifiApService", "start new startTethering method error: ", e3);
            }
        }
    }

    public final void j0() {
        synchronized (this.A) {
            for (WifiApObserver onAcceptFailed : this.A) {
                try {
                    onAcceptFailed.onAcceptFailed();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiApService", "Observer.onAcceptFailed() failed.", e2);
                }
            }
        }
    }

    public final void k0() {
        synchronized (this.A) {
            for (WifiApObserver onApCreateFailed : this.A) {
                try {
                    onApCreateFailed.onApCreateFailed();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiApService", "Observer.notifyOnApCreateFailed() failed.", e2);
                }
            }
        }
    }

    public final void l0(String str, String str2, String str3, String str4, int i2) {
        synchronized (this.A) {
            for (WifiApObserver onApCreated : this.A) {
                try {
                    onApCreated.onApCreated(str3, str, str2, str4, i2);
                } catch (RemoteException e2) {
                    EasyLog.d("WifiApService", "Observer.notifyOnApCreated(...) failed.", e2);
                }
            }
        }
    }

    public final void m0() {
        synchronized (this.A) {
            this.t = false;
            V(this.r);
            for (WifiApObserver onConnected : this.A) {
                try {
                    onConnected.onConnected();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiApService", "Observer.notifyOnConnected() failed.", e2);
                }
            }
        }
    }

    public final void n0() {
        Iterator it;
        synchronized (this.A) {
            try {
                it = this.A.iterator();
            } catch (RemoteException e2) {
                EasyLog.d("WifiApService", "Observer.onDisconnected() failed.", e2);
            } finally {
            }
            while (it.hasNext()) {
                WifiApObserver wifiApObserver = (WifiApObserver) it.next();
                if (X() != 10) {
                    if (X() != 11) {
                        wifiApObserver.onDisconnected(false);
                    }
                }
                wifiApObserver.onDisconnected(true);
            }
        }
    }

    public final void o0() {
        synchronized (this.A) {
            for (WifiApObserver onOpenSuccess : this.A) {
                try {
                    onOpenSuccess.onOpenSuccess();
                } catch (RemoteException e2) {
                    EasyLog.d("WifiApService", "Observer.onOpenSuccess error: ", e2);
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f9925a;
    }

    public void onCreate() {
        super.onCreate();
        this.b = (WifiManager) getSystemService("wifi");
        this.c = (ConnectivityManager) getSystemService("connectivity");
        HandlerThread handlerThread = new HandlerThread("WifiApThread");
        this.e = handlerThread;
        handlerThread.start();
        this.d = new WifiApHandler(this.e.getLooper());
        IntentFilter intentFilter = new IntentFilter(WiFiApManager.WIFI_AP_STATE_CHANGED_ACTION);
        intentFilter.addAction("android.net.conn.TETHER_STATE_CHANGED");
        this.d.post(new f(this, intentFilter));
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.post(new g(this));
        this.e.quitSafely();
    }

    public final void p0() {
        Class<String> cls = String.class;
        Class<WifiManager> cls2 = WifiManager.class;
        if (this.c != null) {
            try {
                WifiApConfigHelper b2 = new WifiApConfigHelper.Builder().f(this.i).e(this.j).d(this.m).c(1).b();
                Method method = cls2.getMethod("setCountryCode", new Class[]{cls});
                if (((String) cls2.getMethod("getCountryCode", (Class[]) null).invoke(this.b, (Object[]) null)) == null) {
                    EasyLog.c("WifiApService", "getCountryCode is null, reset it");
                    method.invoke(this.b, new Object[]{Constants.CHINA_COUNTRY});
                }
                cls2.getMethod("setWifiApConfiguration", new Class[]{WifiConfiguration.class}).invoke(this.b, new Object[]{b2.c()});
                t0();
                Field declaredField = ConnectivityManager.class.getDeclaredField("mService");
                declaredField.setAccessible(true);
                Class.forName("android.net.IConnectivityManager").getDeclaredMethod("startTethering", new Class[]{Integer.TYPE, ResultReceiver.class, Boolean.TYPE, cls}).invoke(declaredField.get(this.c), new Object[]{0, new ResultReceiver((Handler) null) {
                    public void onReceiveResult(int i, Bundle bundle) {
                        super.onReceiveResult(i, bundle);
                    }
                }, Boolean.TRUE, getPackageName()});
            } catch (Exception e2) {
                EasyLog.d("WifiApService", "start old startTethering method error: ", e2);
            }
        }
    }

    public void q0() {
        EasyLog.e("WifiApService", "WifiApService open");
        o0();
    }

    public final void r0() {
        if (this.u) {
            this.u = false;
            EasyLog.a("WifiApService", "reStartTether tether name: " + this.v);
            y0(false);
            A0(this.v, this.w);
        }
    }

    public final void s0(String str, String str2) {
        try {
            this.p = false;
            this.v = str;
            this.w = str2;
            this.u = true;
            y0(true);
            B0();
        } catch (Exception e2) {
            EasyLog.d("WifiApService", "useExistSoftAp error: ", e2);
        }
    }

    public final void t0() {
        if (this.g == null) {
            EasyLog.a("WifiApService", "register SoftAp Callback");
            try {
                Class<?> cls = Class.forName("android.net.wifi.WifiManager$SoftApCallback");
                this.g = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ApCallbackHandler());
                Class<WifiManager> cls2 = WifiManager.class;
                if (Build.VERSION.SDK_INT >= 30) {
                    this.z = false;
                    cls2.getMethod("registerSoftApCallback", new Class[]{Executor.class, cls}).invoke(this.b, new Object[]{this.h, this.g});
                    return;
                }
                cls2.getMethod("registerSoftApCallback", new Class[]{cls, Handler.class}).invoke(this.b, new Object[]{this.g, this.d});
            } catch (Exception e2) {
                this.g = null;
                EasyLog.d("WifiApService", "registerSoftApCallback reflect error!", e2);
            }
        }
    }

    public void u0(WifiApObserver wifiApObserver) {
        synchronized (this.A) {
            try {
                if (!this.A.contains(wifiApObserver)) {
                    this.A.add(wifiApObserver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v0(boolean z2) {
        EasyLog.e("WifiApService", "setAcceptTimeout: " + z2);
        this.d.removeCallbacks(this.E);
        if (z2) {
            this.d.postDelayed(this.E, 20000);
        }
    }

    public final void w0(String str) {
        try {
            NetworkInterface byName = NetworkInterface.getByName(str);
            if (byName != null) {
                this.k = C0(byName.getHardwareAddress());
                Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && a0(nextElement.getHostAddress())) {
                        this.l = nextElement.getHostAddress();
                    }
                }
            }
            EasyLog.a("WifiApService", "ipAddress: " + this.l + ", mac: " + this.k);
        } catch (Exception e2) {
            EasyLog.d("WifiApService", "set ap address error: ", e2);
        }
    }

    public final void x0(boolean z2) {
        EasyLog.e("WifiApService", "setTetherReadyTimeout: " + z2);
        this.d.removeCallbacks(this.D);
        if (z2) {
            this.d.postDelayed(this.D, 3000);
        }
    }

    public final void y0(boolean z2) {
        EasyLog.e("WifiApService", "setTetherResetTimeout: " + z2);
        this.d.removeCallbacks(this.C);
        if (z2) {
            this.d.postDelayed(this.C, AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    public void z0(int i2, String str, String str2) {
        this.m = WifiUtils.d(1, i2, this.b);
        if (X() == 12 || X() == 13) {
            EasyLog.e("WifiApService", "the current soft ap can't be used, we need to recreate it");
            s0(str, str2);
            return;
        }
        A0(str, str2);
    }
}
