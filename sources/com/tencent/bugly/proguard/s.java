package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.r;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9593a = false;
    public static r b = null;
    /* access modifiers changed from: private */
    public static int c = 10;
    /* access modifiers changed from: private */
    public static long d = 300000;
    /* access modifiers changed from: private */
    public static long e = 30000;
    /* access modifiers changed from: private */
    public static long f = 0;
    /* access modifiers changed from: private */
    public static int g = 0;
    /* access modifiers changed from: private */
    public static long h = 0;
    /* access modifiers changed from: private */
    public static long i = 0;
    /* access modifiers changed from: private */
    public static long j = 0;
    private static Application.ActivityLifecycleCallbacks k = null;
    /* access modifiers changed from: private */
    public static Class<?> l = null;
    /* access modifiers changed from: private */
    public static boolean m = true;

    public static class a implements Application.ActivityLifecycleCallbacks {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onCreated <<<", name);
                aa b = aa.b();
                if (b != null) {
                    b.L.add(s.a(name, "onCreated"));
                }
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onDestroyed <<<", name);
                aa b = aa.b();
                if (b != null) {
                    b.L.add(s.a(name, "onDestroyed"));
                }
            }
        }

        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onPaused <<<", name);
                aa b = aa.b();
                if (b != null) {
                    b.L.add(s.a(name, "onPaused"));
                    long currentTimeMillis = System.currentTimeMillis();
                    b.A = currentTimeMillis;
                    b.B = currentTimeMillis - b.z;
                    long unused = s.h = currentTimeMillis;
                    if (b.B < 0) {
                        b.B = 0;
                    }
                    b.y = "background";
                }
            }
        }

        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onResumed <<<", name);
                aa b = aa.b();
                if (b != null) {
                    b.L.add(s.a(name, "onResumed"));
                    b.y = name;
                    long currentTimeMillis = System.currentTimeMillis();
                    b.z = currentTimeMillis;
                    b.C = currentTimeMillis - s.i;
                    long d = b.z - s.h;
                    if (d > (s.f > 0 ? s.f : s.e)) {
                        b.c();
                        s.g();
                        al.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(d / 1000), Long.valueOf(s.e / 1000));
                        if (s.g % s.c == 0) {
                            s.b.a(4, s.m);
                            return;
                        }
                        s.b.a(4, false);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (currentTimeMillis2 - s.j > s.d) {
                            long unused = s.j = currentTimeMillis2;
                            al.a("add a timer to upload hot start user info", new Object[0]);
                            if (s.m) {
                                ak.a().a(new r.a((UserInfoBean) null, true), s.d);
                            }
                        }
                    }
                }
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            al.c(">>> %s onStart <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), true);
        }

        public final void onActivityStopped(Activity activity) {
            al.c(">>> %s onStop <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), false);
        }
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (!f9593a) {
            m = aa.a(context).f;
            b = new r(context, m);
            f9593a = true;
            if (buglyStrategy != null) {
                l = buglyStrategy.getUserInfoActivity();
                j2 = buglyStrategy.getAppReportDelay();
            } else {
                j2 = 0;
            }
            if (j2 <= 0) {
                c(context, buglyStrategy);
            } else {
                ak.a().a(new Runnable() {
                    public final void run() {
                        s.c(context, buglyStrategy);
                    }
                }, j2);
            }
        }
    }

    public static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (z2) {
            aa a2 = aa.a(context);
            List<UserInfoBean> a3 = r.a(a2.d);
            if (a3 != null) {
                for (int i2 = 0; i2 < a3.size(); i2++) {
                    UserInfoBean userInfoBean = a3.get(i2);
                    if (userInfoBean.n.equals(a2.o) && userInfoBean.b == 1) {
                        long b2 = ap.b();
                        if (b2 <= 0) {
                            break;
                        } else if (userInfoBean.e >= b2) {
                            if (userInfoBean.f <= 0) {
                                b.b();
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            z = false;
        }
        aa b3 = aa.b();
        if (b3 != null && z.a()) {
            b3.a(0, true);
        }
        if (z) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k == null) {
                        k = new a();
                    }
                    application.registerActivityLifecycleCallbacks(k);
                } catch (Exception e2) {
                    if (!al.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (m) {
            i = System.currentTimeMillis();
            b.a(1, false);
            al.a("[session] launch app, new start", new Object[0]);
            b.a();
            b.a(21600000);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = ac.a().c().p;
        }
        f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        r rVar = b;
        if (rVar != null && !z) {
            rVar.b();
        }
        if (strategyBean != null) {
            long j2 = strategyBean.p;
            if (j2 > 0) {
                e = j2;
            }
            int i2 = strategyBean.u;
            if (i2 > 0) {
                c = i2;
            }
            long j3 = strategyBean.v;
            if (j3 > 0) {
                d = j3;
            }
        }
    }

    public static void a() {
        r rVar = b;
        if (rVar != null) {
            rVar.a(2, false);
        }
    }

    public static void a(Context context) {
        if (f9593a && context != null) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = k;
                    if (activityLifecycleCallbacks != null) {
                        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    }
                } catch (Exception e2) {
                    if (!al.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
            f9593a = false;
        }
    }

    public static /* synthetic */ String a(String str, String str2) {
        return ap.a() + FastRecordHistoryDetailActivity.TAG_SPLIT + str + FastRecordHistoryDetailActivity.TAG_SPLIT + str2 + StringUtils.LF;
    }
}
