package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public final class au {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static au f9548a;
    private ac b;
    private aa c;
    private as d;
    private Context e;

    private au(Context context) {
        at a2 = at.a();
        if (a2 != null) {
            this.b = ac.a();
            this.c = aa.a(context);
            this.d = a2.s;
            this.e = context;
            ak.a().a(new Runnable() {
                public final void run() {
                    au.a(au.this);
                }
            });
        }
    }

    public static au a(Context context) {
        if (f9548a == null) {
            f9548a = new au(context);
        }
        return f9548a;
    }

    public static void a(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        final Thread thread2 = thread;
        final int i2 = i;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Map<String, String> map2 = map;
        ak.a().a(new Runnable() {
            public final void run() {
                try {
                    if (au.f9548a == null) {
                        al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        au.a(au.f9548a, thread2, i2, str4, str5, str6, map2);
                    }
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                    al.e("[ExtraCrashManager] Crash error %s %s %s", str4, str5, str6);
                }
            }
        });
    }

    public static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            auVar.c.getClass();
            ap.a(cls, "sdkPackageName", (Object) "com.tencent.bugly");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static /* synthetic */ void a(au auVar, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        au auVar2 = auVar;
        int i2 = i;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        Map map2 = map;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        int i3 = 5;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else if (i2 != 8) {
            al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        if (!auVar2.b.b()) {
            al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
        }
        StrategyBean c2 = auVar2.b.c();
        if (!c2.f) {
            if (auVar2.b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                String a2 = ap.a();
                String str9 = auVar2.c.d;
                String name = currentThread.getName();
                as.a(str4, a2, str9, name, str6 + StringUtils.LF + str7 + StringUtils.LF + str8, (CrashDetailBean) null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
        }
        if (i2 == 5 || i2 == 6) {
            try {
                if (!c2.k) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    return;
                }
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return;
            } finally {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            }
        } else if (i2 == 8) {
            if (!c2.l) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
        }
        if (i2 != 8) {
            i3 = i2;
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = ab.j();
        crashDetailBean.D = ab.f();
        crashDetailBean.E = ab.l();
        crashDetailBean.F = auVar2.c.k();
        crashDetailBean.G = auVar2.c.j();
        crashDetailBean.H = auVar2.c.l();
        crashDetailBean.I = ab.b(auVar2.e);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        crashDetailBean.b = i3;
        crashDetailBean.e = auVar2.c.g();
        aa aaVar = auVar2.c;
        crashDetailBean.f = aaVar.o;
        crashDetailBean.g = aaVar.q();
        crashDetailBean.m = auVar2.c.f();
        crashDetailBean.n = String.valueOf(str);
        crashDetailBean.o = String.valueOf(str2);
        String str10 = "";
        if (str8 != null) {
            String[] split = str8.split(StringUtils.LF);
            if (split.length > 0) {
                str10 = split[0];
            }
            str5 = str8;
        } else {
            str5 = str10;
        }
        crashDetailBean.p = str10;
        crashDetailBean.q = str5;
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
        crashDetailBean.z = ap.a(auVar2.c.Q, at.h);
        crashDetailBean.A = auVar2.c.d;
        crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
        crashDetailBean.L = auVar2.c.s();
        crashDetailBean.h = auVar2.c.p();
        aa aaVar2 = auVar2.c;
        crashDetailBean.Q = aaVar2.f9513a;
        crashDetailBean.R = aaVar2.a();
        crashDetailBean.U = auVar2.c.z();
        aa aaVar3 = auVar2.c;
        crashDetailBean.V = aaVar3.x;
        crashDetailBean.W = aaVar3.t();
        crashDetailBean.X = auVar2.c.y();
        crashDetailBean.y = ao.a();
        if (crashDetailBean.S == null) {
            crashDetailBean.S = new LinkedHashMap();
        }
        if (map2 != null) {
            crashDetailBean.S.putAll(map2);
        }
        String a3 = ap.a();
        String str11 = auVar2.c.d;
        String name2 = currentThread.getName();
        as.a(str4, a3, str11, name2, str6 + StringUtils.LF + str7 + StringUtils.LF + str8, crashDetailBean);
        if (!auVar2.d.a(crashDetailBean, !at.a().C)) {
            auVar2.d.b(crashDetailBean, false);
        }
        al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
    }
}
