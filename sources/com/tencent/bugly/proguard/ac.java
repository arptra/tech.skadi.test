package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static int f9515a = 1000;
    public static long b = 259200000;
    private static ac d;
    /* access modifiers changed from: private */
    public static String i;
    public final ak c;
    private final List<o> e;
    private final StrategyBean f;
    /* access modifiers changed from: private */
    public StrategyBean g = null;
    /* access modifiers changed from: private */
    public Context h;

    private ac(Context context, List<o> list) {
        this.h = context;
        if (aa.a(context) != null) {
            String str = aa.a(context).H;
            if ("oversea".equals(str)) {
                StrategyBean.f9504a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f9504a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f = new StrategyBean();
        this.e = list;
        this.c = ak.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<y> a2 = w.a().a(2);
        if (a2 == null || a2.size() <= 0 || (bArr = a2.get(0).g) == null) {
            return null;
        }
        return (StrategyBean) ap.a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.g;
        if (strategyBean != null) {
            if (!ap.d(strategyBean.q)) {
                this.g.q = StrategyBean.f9504a;
            }
            if (!ap.d(this.g.r)) {
                this.g.r = StrategyBean.b;
            }
            return this.g;
        }
        if (!ap.b(i) && ap.d(i)) {
            StrategyBean strategyBean2 = this.f;
            String str = i;
            strategyBean2.q = str;
            strategyBean2.r = str;
        }
        return this.f;
    }

    public final synchronized boolean b() {
        return this.g != null;
    }

    public static synchronized ac a(Context context, List<o> list) {
        ac acVar;
        synchronized (ac.class) {
            try {
                if (d == null) {
                    d = new ac(context, list);
                }
                acVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return acVar;
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            acVar = d;
        }
        return acVar;
    }

    public final void a(StrategyBean strategyBean, boolean z) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z);
        for (o next : this.e) {
            try {
                al.c("[Strategy] Notify %s", next.getClass().getName());
                next.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (ap.b(str) || !ap.d(str)) {
            al.d("URL user set is invalid.", new Object[0]);
        } else {
            i = str;
        }
    }

    public final void a(bt btVar) {
        int i2;
        bt btVar2 = btVar;
        if (btVar2 != null) {
            StrategyBean strategyBean = this.g;
            if (strategyBean == null || btVar2.h != strategyBean.o) {
                StrategyBean strategyBean2 = new StrategyBean();
                strategyBean2.f = btVar2.f9575a;
                strategyBean2.h = btVar2.c;
                strategyBean2.g = btVar2.b;
                if (ap.b(i) || !ap.d(i)) {
                    if (ap.d(btVar2.d)) {
                        al.c("[Strategy] Upload url changes to %s", btVar2.d);
                        strategyBean2.q = btVar2.d;
                    }
                    if (ap.d(btVar2.e)) {
                        al.c("[Strategy] Exception upload url changes to %s", btVar2.e);
                        strategyBean2.r = btVar2.e;
                    }
                }
                bs bsVar = btVar2.f;
                if (bsVar != null && !ap.b(bsVar.f9574a)) {
                    strategyBean2.s = btVar2.f.f9574a;
                }
                long j = btVar2.h;
                if (j != 0) {
                    strategyBean2.o = j;
                }
                Map<String, String> map = btVar2.g;
                if (map != null && map.size() > 0) {
                    Map<String, String> map2 = btVar2.g;
                    strategyBean2.t = map2;
                    String str = map2.get("B11");
                    strategyBean2.i = str != null && str.equals("1");
                    String str2 = btVar2.g.get("B3");
                    if (str2 != null) {
                        strategyBean2.w = Long.parseLong(str2);
                    }
                    int i3 = btVar2.l;
                    strategyBean2.p = (long) i3;
                    strategyBean2.v = (long) i3;
                    String str3 = btVar2.g.get("B27");
                    if (str3 != null && str3.length() > 0) {
                        try {
                            int parseInt = Integer.parseInt(str3);
                            if (parseInt > 0) {
                                strategyBean2.u = parseInt;
                            }
                        } catch (Exception e2) {
                            if (!al.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    String str4 = btVar2.g.get("B25");
                    strategyBean2.k = str4 != null && str4.equals("1");
                }
                al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f), Boolean.valueOf(strategyBean2.h), Boolean.valueOf(strategyBean2.g), Boolean.valueOf(strategyBean2.i), Boolean.valueOf(strategyBean2.j), Boolean.valueOf(strategyBean2.m), Boolean.valueOf(strategyBean2.n), Long.valueOf(strategyBean2.p), Boolean.valueOf(strategyBean2.k), Long.valueOf(strategyBean2.o));
                this.g = strategyBean2;
                if (!ap.d(btVar2.d)) {
                    i2 = 0;
                    al.c("[Strategy] download url is null", new Object[0]);
                    this.g.q = "";
                } else {
                    i2 = 0;
                }
                if (!ap.d(btVar2.e)) {
                    al.c("[Strategy] download crashurl is null", new Object[i2]);
                    this.g.r = "";
                }
                w.a().b(2);
                y yVar = new y();
                yVar.b = 2;
                yVar.f9602a = strategyBean2.d;
                yVar.e = strategyBean2.e;
                yVar.g = ap.a((Parcelable) strategyBean2);
                w.a().a(yVar);
                a(strategyBean2, true);
            }
        }
    }
}
