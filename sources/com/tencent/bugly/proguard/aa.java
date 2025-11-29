package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.MzContactsContract;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.lang3.BooleanUtils;

public final class aa {
    private static final Map<String, String> W = new HashMap();
    private static aa aq = null;
    public long A = 0;
    public long B = 0;
    public long C = 0;
    public boolean D = false;
    public String E = null;
    public String F = null;
    public String G = null;
    public String H = "";
    public boolean I = false;
    public boolean J = false;
    public HashMap<String, String> K = new HashMap<>();
    public List<String> L = new ArrayList();
    public boolean M = false;
    public q N = null;
    public final SharedPreferences O;
    public final SharedPreferences P;
    public boolean Q = true;
    public boolean R = true;
    public boolean S = false;
    public final Object T = new Object();
    public final Object U = new Object();
    public final Object V = new Object();
    private final Context X;
    private String Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    public final long f9513a = System.currentTimeMillis();
    private String aa;
    private String ab = StarryNetConstant.DEVICE_NAME_UNKNOWN;
    private String ac = "";
    private String ad = null;
    private long ae = -1;
    private long af = -1;
    private long ag = -1;
    private String ah = null;
    private String ai = null;
    private String aj = null;
    private Map<String, PlugInBean> ak = null;
    private String al = null;
    private Boolean am = null;
    private String an = null;
    private Map<String, PlugInBean> ao = null;
    private Map<String, PlugInBean> ap = null;
    private final Map<String, String> ar = new HashMap();
    private final Map<String, String> as = new HashMap();
    private final Map<String, String> at = new HashMap();
    private final Object au = new Object();
    private final Object av = new Object();
    private final Object aw = new Object();
    private final Object ax = new Object();
    private final List<Integer> ay = new ArrayList();
    public final byte b;
    public String c;
    public final String d;
    public String e;
    public boolean f = true;
    public final String g = "com.tencent.bugly";
    public String h = "4.1.9.3";
    public final String i = "";
    @Deprecated
    public final String j = "";
    public final String k;
    public String l = StarryNetConstant.DEVICE_NAME_UNKNOWN;
    public long m = 0;
    public boolean n = false;
    public String o = null;
    public int p;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public List<String> v = null;
    public int w = -1;
    public int x = -1;
    public String y = StarryNetConstant.DEVICE_NAME_UNKNOWN;
    public long z = 0;

    private aa(Context context) {
        this.X = ap.a(context);
        this.b = 1;
        PackageInfo b2 = z.b(context);
        if (b2 != null) {
            try {
                String str = b2.versionName;
                this.o = str;
                this.E = str;
                this.F = Integer.toString(b2.versionCode);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.c = z.a(context);
        this.d = z.a(Process.myPid());
        this.q = z.c(context);
        this.k = "Android " + ab.b() + ",level " + ab.c();
        Map<String, String> d2 = z.d(context);
        if (d2 != null) {
            try {
                this.v = z.a(d2);
                String str2 = d2.get("BUGLY_APPID");
                if (str2 != null) {
                    this.r = str2;
                    b("APP_ID", str2);
                }
                String str3 = d2.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.o = str3;
                }
                String str4 = d2.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.s = str4;
                }
                String str5 = d2.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.D = str5.equalsIgnoreCase(BooleanUtils.TRUE);
                }
                String str6 = d2.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.G = str6;
                }
                String str7 = d2.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.p = Integer.parseInt(str7);
                }
                String str8 = d2.get("BUGLY_AREA");
                if (str8 != null) {
                    this.H = str8;
                }
            } catch (Throwable th2) {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.J = true;
                al.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (p.c) {
                th3.printStackTrace();
            }
        }
        this.O = ap.a("BUGLY_COMMON_VALUES", context);
        this.P = ap.a("BUGLY_RESERVED_VALUES", context);
        this.aj = ab.a(context);
        E();
        al.c("com info create end", new Object[0]);
    }

    public static int B() {
        return ab.c();
    }

    @Deprecated
    public static boolean C() {
        al.a("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    public static boolean D() {
        al.a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    private void E() {
        try {
            for (Map.Entry next : this.P.getAll().entrySet()) {
                al.c("put reserved request data from sp, key:%s value:%s", next.getKey(), next.getValue());
                a((String) next.getKey(), next.getValue().toString(), false);
            }
            for (Map.Entry next2 : W.entrySet()) {
                al.c("put reserved request data from cache, key:%s value:%s", next2.getKey(), next2.getValue());
                a((String) next2.getKey(), (String) next2.getValue(), true);
            }
            W.clear();
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private String F() {
        if (TextUtils.isEmpty(this.ad)) {
            this.ad = ap.d("androidid", (String) null);
        }
        return this.ad;
    }

    private static String G() {
        String uuid = UUID.randomUUID().toString();
        return !ap.b(uuid) ? uuid.replaceAll(LunarCalendar.DATE_SEPARATOR, "") : uuid;
    }

    public static synchronized aa b() {
        aa aaVar;
        synchronized (aa.class) {
            aaVar = aq;
        }
        return aaVar;
    }

    @Deprecated
    public static String n() {
        return "";
    }

    public final synchronized Map<String, PlugInBean> A() {
        Map<String, PlugInBean> map;
        map = this.ao;
        Map<String, PlugInBean> map2 = this.ap;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final boolean a() {
        boolean z2 = this.ay.size() > 0;
        al.c("isAppForeground:%s", Boolean.valueOf(z2));
        return z2;
    }

    public final void c() {
        synchronized (this.au) {
            this.Y = UUID.randomUUID().toString();
        }
    }

    public final String d() {
        String str;
        synchronized (this.au) {
            try {
                if (this.Y == null) {
                    c();
                }
                str = this.Y;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final String e() {
        if (!ap.b(this.e)) {
            return this.e;
        }
        return this.r;
    }

    public final String f() {
        String str;
        synchronized (this.V) {
            str = this.l;
        }
        return str;
    }

    public final String g() {
        String str = this.aa;
        if (str != null) {
            return str;
        }
        String d2 = ap.d(Constants.DEVICE_ID, (String) null);
        this.aa = d2;
        if (d2 != null) {
            return d2;
        }
        String F2 = F();
        this.aa = F2;
        if (TextUtils.isEmpty(F2)) {
            this.aa = G();
        }
        String str2 = this.aa;
        if (str2 == null) {
            return "";
        }
        ap.c(Constants.DEVICE_ID, str2);
        return this.aa;
    }

    public final synchronized String h() {
        String str = this.Z;
        if (str != null) {
            return str;
        }
        String d2 = ap.d("deviceModel", (String) null);
        this.Z = d2;
        if (d2 != null) {
            al.c("collect device model from sp:%s", d2);
            return this.Z;
        } else if (!this.n) {
            al.c("not allow collect device model", new Object[0]);
            return "fail";
        } else {
            String a2 = ab.a();
            this.Z = a2;
            al.c("collect device model:%s", a2);
            ap.c("deviceModel", this.Z);
            return this.Z;
        }
    }

    public final synchronized String i() {
        return this.ac;
    }

    public final long j() {
        if (this.ae <= 0) {
            this.ae = ab.e();
        }
        return this.ae;
    }

    public final long k() {
        if (this.af <= 0) {
            this.af = ab.i();
        }
        return this.af;
    }

    public final long l() {
        if (this.ag <= 0) {
            this.ag = ab.k();
        }
        return this.ag;
    }

    public final String m() {
        if (!TextUtils.isEmpty(this.ai)) {
            al.c("get cpu type from so:%s", this.ai);
            return this.ai;
        } else if (TextUtils.isEmpty(this.aj)) {
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        } else {
            al.c("get cpu type from lib dir:%s", this.aj);
            return this.aj;
        }
    }

    public final String o() {
        try {
            Map<String, ?> all = this.X.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.T) {
                    try {
                        for (Map.Entry next : all.entrySet()) {
                            this.K.put(next.getKey(), next.getValue().toString());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            al.a(th2);
        }
        if (!this.K.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next2 : this.K.entrySet()) {
                sb.append("[");
                sb.append((String) next2.getKey());
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                sb.append((String) next2.getValue());
                sb.append("] ");
            }
            al.c("SDK_INFO = %s", sb.toString());
            b("SDK_INFO", sb.toString());
            return sb.toString();
        }
        al.c("SDK_INFO is empty", new Object[0]);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> p() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> r0 = r2.ak     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0020
            int r0 = r0.size()     // Catch:{ all -> 0x001e }
            if (r0 > 0) goto L_0x000c
            goto L_0x0020
        L_0x000c:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x001e }
            java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> r1 = r2.ak     // Catch:{ all -> 0x001e }
            int r1 = r1.size()     // Catch:{ all -> 0x001e }
            r0.<init>(r1)     // Catch:{ all -> 0x001e }
            java.util.Map<java.lang.String, com.tencent.bugly.crashreport.common.info.PlugInBean> r1 = r2.ak     // Catch:{ all -> 0x001e }
            r0.putAll(r1)     // Catch:{ all -> 0x001e }
            monitor-exit(r2)
            return r0
        L_0x001e:
            r0 = move-exception
            goto L_0x0023
        L_0x0020:
            monitor-exit(r2)
            r2 = 0
            return r2
        L_0x0023:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aa.p():java.util.Map");
    }

    public final String q() {
        if (this.al == null) {
            this.al = ab.m();
        }
        return this.al;
    }

    public final Boolean r() {
        if (this.am == null) {
            this.am = Boolean.valueOf(ab.q());
        }
        return this.am;
    }

    public final String s() {
        if (this.an == null) {
            String str = ab.n();
            this.an = str;
            al.a("ROM ID: %s", str);
        }
        return this.an;
    }

    public final Map<String, String> t() {
        synchronized (this.av) {
            try {
                if (this.ar.size() <= 0) {
                    return null;
                }
                HashMap hashMap = new HashMap(this.ar);
                return hashMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u() {
        synchronized (this.av) {
            this.ar.clear();
        }
    }

    public final int v() {
        int size;
        synchronized (this.av) {
            size = this.ar.size();
        }
        return size;
    }

    public final Set<String> w() {
        Set<String> keySet;
        synchronized (this.av) {
            keySet = this.ar.keySet();
        }
        return keySet;
    }

    public final Map<String, String> x() {
        synchronized (this.ax) {
            try {
                if (this.as.size() <= 0) {
                    return null;
                }
                HashMap hashMap = new HashMap(this.as);
                return hashMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<String, String> y() {
        synchronized (this.aw) {
            try {
                if (this.at.size() <= 0) {
                    return null;
                }
                HashMap hashMap = new HashMap(this.at);
                return hashMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int z() {
        int i2;
        synchronized (this.U) {
            i2 = this.w;
        }
        return i2;
    }

    public final void b(String str) {
        al.a("change deviceModel，old:%s new:%s", this.Z, str);
        this.Z = str;
        if (!TextUtils.isEmpty(str)) {
            ap.c("deviceModel", str);
        }
    }

    public final void a(int i2, boolean z2) {
        al.c("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i2), Boolean.valueOf(z2));
        boolean z3 = false;
        if (z2) {
            this.ay.add(Integer.valueOf(i2));
        } else {
            this.ay.remove(Integer.valueOf(i2));
            this.ay.remove(0);
        }
        q qVar = this.N;
        if (qVar != null) {
            if (this.ay.size() > 0) {
                z3 = true;
            }
            qVar.setNativeIsAppForeground(z3);
        }
    }

    public final synchronized void c(String str) {
        this.ab = String.valueOf(str);
    }

    public final void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ai = str.trim();
        }
    }

    public final String f(String str) {
        String remove;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            remove = this.ar.remove(str);
        }
        return remove;
    }

    public final void b(String str, String str2) {
        if (ap.b(str) || ap.b(str2)) {
            al.d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.aw) {
            this.at.put(str, str2);
        }
    }

    public final synchronized void d(String str) {
        this.ac = String.valueOf(str);
    }

    public static synchronized aa a(Context context) {
        aa aaVar;
        synchronized (aa.class) {
            try {
                if (aq == null) {
                    aq = new aa(context);
                }
                aaVar = aq;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aaVar;
    }

    public final String g(String str) {
        String str2;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            str2 = this.ar.get(str);
        }
        return str2;
    }

    public final void a(String str) {
        this.aa = str;
        if (!TextUtils.isEmpty(str)) {
            ap.c(Constants.DEVICE_ID, str);
        }
        synchronized (this.ax) {
            this.as.put("E8", str);
        }
    }

    public final void a(String str, String str2) {
        if (ap.b(str) || ap.b(str2)) {
            al.d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.av) {
            this.ar.put(str, str2);
        }
    }

    private void a(String str, String str2, boolean z2) {
        if (ap.b(str)) {
            al.d("key should not be empty %s", str);
            return;
        }
        al.c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z2));
        synchronized (this.ax) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    this.as.remove(str);
                    this.P.edit().remove(str).apply();
                } else {
                    this.as.put(str, str2);
                    if (z2) {
                        this.P.edit().putString(str, str2).apply();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
