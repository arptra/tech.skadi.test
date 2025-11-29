package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.here.sdk.search.PlaceCategory;
import com.meizu.common.widget.MzContactsContract;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ag;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;

public final class as {

    /* renamed from: a  reason: collision with root package name */
    public static int f9540a;
    private static final Map<Integer, Pair<String, String>> h = new HashMap<Integer, Pair<String, String>>() {
        {
            put(3, new Pair("203", FactorAuthenticationUtil.CODE_ERROR_CANCEL));
            put(7, new Pair("208", "108"));
            put(0, new Pair("200", PlaceCategory.EAT_AND_DRINK));
            put(1, new Pair("201", FactorAuthenticationUtil.CODE_ERROR_TOKEN_NULL));
            put(2, new Pair("202", FactorAuthenticationUtil.CODE_ERROR_MODE_NULL));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };
    private static final ArrayList<a> i = new ArrayList<a>() {
        {
            add(new b((byte) 0));
            add(new c((byte) 0));
            add(new d((byte) 0));
            add(new e((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
        }
    };
    private static final Map<Integer, Integer> j = new HashMap<Integer, Integer>() {
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };
    private static final Map<Integer, String> k = new HashMap<Integer, String>() {
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };
    private static final Map<Integer, String> l = new HashMap<Integer, String>() {
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };
    protected final Context b;
    protected final ai c;
    protected final w d;
    protected final ac e;
    protected aw f = null;
    protected BuglyStrategy.a g;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f9542a;

        public /* synthetic */ a(int i, byte b) {
            this(i);
        }

        public abstract boolean a();

        public a(int i) {
            this.f9542a = i;
        }
    }

    public static class b extends a {
        public /* synthetic */ b(byte b) {
            this();
        }

        public final boolean a() {
            return at.a().k();
        }

        public b() {
            super(3, (byte) 0);
        }
    }

    public static class c extends a {
        public /* synthetic */ c(byte b) {
            this();
        }

        public final boolean a() {
            return true;
        }

        public c() {
            super(7, (byte) 0);
        }
    }

    public static class d extends a {
        public /* synthetic */ d(byte b) {
            this();
        }

        public final boolean a() {
            return true;
        }

        public d() {
            super(2, (byte) 0);
        }
    }

    public static class e extends a {
        public /* synthetic */ e(byte b) {
            this();
        }

        public final boolean a() {
            return at.a().j();
        }

        public e() {
            super(0, (byte) 0);
        }
    }

    public static class f extends a {
        public /* synthetic */ f(byte b) {
            this();
        }

        public final boolean a() {
            return (at.a().B & 2) > 0;
        }

        public f() {
            super(5, (byte) 0);
        }
    }

    public static class g extends a {
        public /* synthetic */ g(byte b) {
            this();
        }

        public final boolean a() {
            return (at.a().B & 1) > 0;
        }

        public g() {
            super(6, (byte) 0);
        }
    }

    public static class h extends a {
        public /* synthetic */ h(byte b) {
            this();
        }

        public final boolean a() {
            return at.a().j();
        }

        public h() {
            super(1, (byte) 0);
        }
    }

    public static class i extends a {
        public /* synthetic */ i(byte b) {
            this();
        }

        public final boolean a() {
            return (at.a().B & 4) > 0;
        }

        public i() {
            super(4, (byte) 0);
        }
    }

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        f9540a = 1004;
        this.b = context;
        this.c = aiVar;
        this.d = wVar;
        this.e = acVar;
        this.g = aVar;
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar next : list) {
            if (next.d && next.b <= currentTimeMillis - DateUtils.MILLIS_PER_DAY) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (ar next : list) {
            if (!next.e && !next.d) {
                String str = crashDetailBean.s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(next.b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.t++;
                    sb.append(next.b);
                    sb.append(StringUtils.LF);
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = crashDetailBean.f9505a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", ap.a((Parcelable) crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void d(List<ar> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("_id in (");
            for (ar arVar : list) {
                sb.append(arVar.f9539a);
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            }
            StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)));
            sb2.append(")");
            String sb3 = sb2.toString();
            sb2.setLength(0);
            try {
                al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() != 0) {
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id = ");
                    sb.append(crashDetailBean.f9505a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                sb.setLength(0);
                al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private static void b(List<ar> list) {
        List<CrashDetailBean> c2 = c(list);
        if (c2 != null && !c2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (CrashDetailBean next : c2) {
                String str = l.get(Integer.valueOf(next.b));
                if (!TextUtils.isEmpty(str)) {
                    al.c("find expired data,crashId:%s eventType:%s", next.c, str);
                    arrayList.add(new ag.c(next.c, str, next.r, false, 0, "expired", (String) null));
                }
            }
            ag.a.f9520a.a((List<ag.c>) arrayList);
        }
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> c2;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (ar next : list) {
            if (next.e) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty() || (c2 = c((List<ar>) arrayList)) == null || c2.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(c2);
            crashDetailBean2 = c2.get(0);
            a(crashDetailBean2, c2);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.r != crashDetailBean.r) {
            String str = crashDetailBean2.s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.r);
            if (!str.contains(sb.toString())) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + StringUtils.LF;
            }
        }
        return crashDetailBean2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00df A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> c(java.util.List<com.tencent.bugly.proguard.ar> r10) {
        /*
            java.lang.String r0 = "t_cr"
            r1 = 0
            if (r10 == 0) goto L_0x00f1
            int r2 = r10.size()
            if (r2 != 0) goto L_0x000d
            goto L_0x00f1
        L_0x000d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "_id in ("
            r2.append(r3)
            java.util.Iterator r10 = r10.iterator()
        L_0x001b:
            boolean r4 = r10.hasNext()
            java.lang.String r5 = ","
            if (r4 == 0) goto L_0x0032
            java.lang.Object r4 = r10.next()
            com.tencent.bugly.proguard.ar r4 = (com.tencent.bugly.proguard.ar) r4
            long r6 = r4.f9539a
            r2.append(r6)
            r2.append(r5)
            goto L_0x001b
        L_0x0032:
            java.lang.String r10 = r2.toString()
            boolean r10 = r10.contains(r5)
            r4 = 0
            if (r10 == 0) goto L_0x004b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            int r6 = r2.lastIndexOf(r5)
            java.lang.String r2 = r2.substring(r4, r6)
            r10.<init>(r2)
            r2 = r10
        L_0x004b:
            java.lang.String r10 = ")"
            r2.append(r10)
            java.lang.String r6 = r2.toString()
            r2.setLength(r4)
            com.tencent.bugly.proguard.w r7 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x00d7 }
            android.database.Cursor r6 = r7.a((java.lang.String) r0, (java.lang.String[]) r1, (java.lang.String) r6)     // Catch:{ all -> 0x00d7 }
            if (r6 != 0) goto L_0x0067
            if (r6 == 0) goto L_0x0066
            r6.close()
        L_0x0066:
            return r1
        L_0x0067:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0080 }
            r7.<init>()     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            r3 = r4
        L_0x0070:
            boolean r8 = r6.moveToNext()     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x009d
            com.tencent.bugly.crashreport.crash.CrashDetailBean r8 = a((android.database.Cursor) r6)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x0082
            r7.add(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x0070
        L_0x0080:
            r10 = move-exception
            goto L_0x00d9
        L_0x0082:
            java.lang.String r8 = "_id"
            int r8 = r6.getColumnIndex(r8)     // Catch:{ all -> 0x0095 }
            long r8 = r6.getLong(r8)     // Catch:{ all -> 0x0095 }
            r2.append(r8)     // Catch:{ all -> 0x0095 }
            r2.append(r5)     // Catch:{ all -> 0x0095 }
            int r3 = r3 + 1
            goto L_0x0070
        L_0x0095:
            java.lang.String r8 = "unknown id!"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0080 }
            com.tencent.bugly.proguard.al.d(r8, r9)     // Catch:{ all -> 0x0080 }
            goto L_0x0070
        L_0x009d:
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0080 }
            boolean r8 = r8.contains(r5)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x00b5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            int r5 = r2.lastIndexOf(r5)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.substring(r4, r5)     // Catch:{ all -> 0x0080 }
            r8.<init>(r2)     // Catch:{ all -> 0x0080 }
            r2 = r8
        L_0x00b5:
            r2.append(r10)     // Catch:{ all -> 0x0080 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x0080 }
            if (r3 <= 0) goto L_0x00d3
            com.tencent.bugly.proguard.w r2 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x0080 }
            int r10 = r2.a((java.lang.String) r0, (java.lang.String) r10)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "deleted %s illegal data %d"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0080 }
            java.lang.Object[] r10 = new java.lang.Object[]{r0, r10}     // Catch:{ all -> 0x0080 }
            com.tencent.bugly.proguard.al.d(r2, r10)     // Catch:{ all -> 0x0080 }
        L_0x00d3:
            r6.close()
            return r7
        L_0x00d7:
            r10 = move-exception
            r6 = r1
        L_0x00d9:
            boolean r0 = com.tencent.bugly.proguard.al.a(r10)     // Catch:{ all -> 0x00e3 }
            if (r0 != 0) goto L_0x00e5
            r10.printStackTrace()     // Catch:{ all -> 0x00e3 }
            goto L_0x00e5
        L_0x00e3:
            r10 = move-exception
            goto L_0x00eb
        L_0x00e5:
            if (r6 == 0) goto L_0x00ea
            r6.close()
        L_0x00ea:
            return r1
        L_0x00eb:
            if (r6 == 0) goto L_0x00f0
            r6.close()
        L_0x00f0:
            throw r10
        L_0x00f1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.c(java.util.List):java.util.List");
    }

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair pair = h.get(Integer.valueOf(crashDetailBean.b));
            if (pair == null) {
                al.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                return "";
            } else if (crashDetailBean.j) {
                return (String) pair.first;
            } else {
                return (String) pair.second;
            }
        } catch (Exception e2) {
            al.a(e2);
            return "";
        }
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        String str;
        try {
            al.c("save eup logs", new Object[0]);
            aa b2 = aa.b();
            String str2 = "#--------\npackage:" + b2.e() + "\nversion:" + b2.o + "\nsdk:" + b2.h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.r)) + "\ntype:" + crashDetailBean.n + "\nmessage:" + crashDetailBean.o + "\nstack:\n" + crashDetailBean.q + "\neupID:" + crashDetailBean.c + StringUtils.LF;
            if (at.m != null) {
                File file = new File(at.m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.b.getPackageName();
            } else {
                str = null;
            }
            am.a(str + "/euplog.txt", str2, at.n);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z) {
        boolean z2 = false;
        if (at.o) {
            al.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            if (crashDetailBean.b == 7) {
                z2 = true;
            }
            a((List<CrashDetailBean>) arrayList, 3000, z, z2, z);
            return;
        }
        al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            ContentValues c2 = c(crashDetailBean);
            if (c2 != null) {
                long a2 = w.a().a("t_cr", c2, (v) null);
                if (a2 >= 0) {
                    al.c("insert %s success!", "t_cr");
                    crashDetailBean.f9505a = a2;
                }
            }
            if (at.l) {
                d(crashDetailBean);
            }
        }
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        for (int i2 = 1; i2 < list.size(); i2++) {
            String str = list.get(i2).s;
            if (!(str == null || (split = str.split(StringUtils.LF)) == null)) {
                for (String str2 : split) {
                    if (!crashDetailBean.s.contains(str2)) {
                        crashDetailBean.t++;
                        sb.append(str2);
                        sb.append(StringUtils.LF);
                    }
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.f9539a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            boolean z = false;
            arVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            arVar.e = z;
            arVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00db A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f4 A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012f A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.bugly.crashreport.crash.CrashDetailBean r19, boolean r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.String r3 = "t_cr"
            r4 = 1
            r5 = 0
            if (r2 != 0) goto L_0x0012
            java.lang.String r0 = "CrashBean is null, won't handle."
            java.lang.Object[] r1 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.d(r0, r1)
            return r4
        L_0x0012:
            r18.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r19)
            if (r20 == 0) goto L_0x0160
            com.tencent.bugly.BuglyStrategy$a r0 = r1.g
            if (r0 != 0) goto L_0x001f
            com.tencent.bugly.proguard.aw r0 = r1.f
            if (r0 == 0) goto L_0x0160
        L_0x001f:
            java.util.ArrayList<com.tencent.bugly.proguard.as$a> r0 = i
            java.util.Iterator r0 = r0.iterator()
        L_0x0025:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r0.next()
            com.tencent.bugly.proguard.as$a r6 = (com.tencent.bugly.proguard.as.a) r6
            int r7 = r6.f9542a
            int r8 = r2.b
            if (r7 != r8) goto L_0x0025
            boolean r0 = r6.a()
            goto L_0x003d
        L_0x003c:
            r0 = r5
        L_0x003d:
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = "Should not call back."
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.c(r0, r6)
            goto L_0x0160
        L_0x0048:
            java.util.Map<java.lang.Integer, java.lang.Integer> r0 = j     // Catch:{ all -> 0x006d }
            int r6 = r2.b     // Catch:{ all -> 0x006d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x006d }
            boolean r6 = r0.containsKey(r6)     // Catch:{ all -> 0x006d }
            if (r6 != 0) goto L_0x0070
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            java.lang.String r6 = "Cannot get crash type for crashBean type:"
            r0.<init>(r6)     // Catch:{ all -> 0x006d }
            int r6 = r2.b     // Catch:{ all -> 0x006d }
            r0.append(r6)     // Catch:{ all -> 0x006d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006d }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.d(r0, r6)     // Catch:{ all -> 0x006d }
            goto L_0x0160
        L_0x006d:
            r0 = move-exception
            goto L_0x0146
        L_0x0070:
            int r6 = r2.b     // Catch:{ all -> 0x006d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x006d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x006d }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x006d }
            int r0 = r0.intValue()     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.aw r6 = r1.f     // Catch:{ all -> 0x006d }
            r7 = 0
            if (r6 == 0) goto L_0x00a6
            java.lang.String r6 = "Calling 'onCrashHandleStart' of RQD crash listener."
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.c(r6, r8)     // Catch:{ all -> 0x006d }
            java.lang.String r6 = "Calling 'getCrashExtraMessage' of RQD crash listener."
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.c(r6, r8)     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.aw r6 = r1.f     // Catch:{ all -> 0x006d }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x006d }
            if (r6 == 0) goto L_0x00be
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x006d }
            r8.<init>(r4)     // Catch:{ all -> 0x006d }
            java.lang.String r9 = "userData"
            r8.put(r9, r6)     // Catch:{ all -> 0x006d }
            goto L_0x00bf
        L_0x00a6:
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x006d }
            if (r6 == 0) goto L_0x00be
            java.lang.String r6 = "Calling 'onCrashHandleStart' of Bugly crash listener."
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.c(r6, r8)     // Catch:{ all -> 0x006d }
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x006d }
            java.lang.String r8 = r2.n     // Catch:{ all -> 0x006d }
            java.lang.String r9 = r2.o     // Catch:{ all -> 0x006d }
            java.lang.String r10 = r2.q     // Catch:{ all -> 0x006d }
            java.util.Map r8 = r6.onCrashHandleStart(r0, r8, r9, r10)     // Catch:{ all -> 0x006d }
            goto L_0x00bf
        L_0x00be:
            r8 = r7
        L_0x00bf:
            a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r2, (java.util.Map<java.lang.String, java.lang.String>) r8)     // Catch:{ all -> 0x006d }
            java.lang.String r6 = "[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()"
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.a((java.lang.String) r6, (java.lang.Object[]) r8)     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.aw r6 = r1.f     // Catch:{ all -> 0x006d }
            if (r6 == 0) goto L_0x00db
            java.lang.String r0 = "Calling 'getCrashExtraData' of RQD crash listener."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.c(r0, r6)     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.aw r0 = r1.f     // Catch:{ all -> 0x006d }
            byte[] r7 = r0.a()     // Catch:{ all -> 0x006d }
            goto L_0x00f2
        L_0x00db:
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x006d }
            if (r6 == 0) goto L_0x00f2
            java.lang.String r6 = "Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener."
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.c(r6, r7)     // Catch:{ all -> 0x006d }
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x006d }
            java.lang.String r7 = r2.n     // Catch:{ all -> 0x006d }
            java.lang.String r8 = r2.o     // Catch:{ all -> 0x006d }
            java.lang.String r9 = r2.q     // Catch:{ all -> 0x006d }
            byte[] r7 = r6.onCrashHandleStart2GetExtraDatas(r0, r7, r8, r9)     // Catch:{ all -> 0x006d }
        L_0x00f2:
            if (r7 != 0) goto L_0x00fc
            java.lang.String r0 = "extra user byte is null. CrashBean won't have userExtraByteDatas."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.d(r0, r6)     // Catch:{ all -> 0x006d }
            goto L_0x012b
        L_0x00fc:
            int r0 = r7.length     // Catch:{ all -> 0x006d }
            r6 = 100000(0x186a0, float:1.4013E-40)
            if (r0 > r6) goto L_0x0105
            r2.Y = r7     // Catch:{ all -> 0x006d }
            goto L_0x011d
        L_0x0105:
            java.lang.String r0 = "extra bytes size %d is over limit %d will drop over part"
            int r8 = r7.length     // Catch:{ all -> 0x006d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x006d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x006d }
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r9}     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.d(r0, r8)     // Catch:{ all -> 0x006d }
            byte[] r0 = java.util.Arrays.copyOf(r7, r6)     // Catch:{ all -> 0x006d }
            r2.Y = r0     // Catch:{ all -> 0x006d }
        L_0x011d:
            java.lang.String r0 = "add extra bytes %d "
            int r6 = r7.length     // Catch:{ all -> 0x006d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x006d }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r6)     // Catch:{ all -> 0x006d }
        L_0x012b:
            com.tencent.bugly.proguard.aw r0 = r1.f     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x0160
            java.lang.String r0 = "Calling 'onCrashSaving' of RQD crash listener."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.c(r0, r6)     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.aw r0 = r1.f     // Catch:{ all -> 0x006d }
            boolean r0 = r0.c()     // Catch:{ all -> 0x006d }
            if (r0 != 0) goto L_0x0160
            java.lang.String r0 = "Crash listener 'onCrashSaving' return 'false' thus will not handle this crash."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x006d }
            com.tencent.bugly.proguard.al.d(r0, r6)     // Catch:{ all -> 0x006d }
            goto L_0x0160
        L_0x0146:
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = r6.getName()
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r7 = "crash handle callback something wrong! %s"
            com.tencent.bugly.proguard.al.d(r7, r6)
            boolean r6 = com.tencent.bugly.proguard.al.a(r0)
            if (r6 != 0) goto L_0x0160
            r0.printStackTrace()
        L_0x0160:
            boolean r0 = com.tencent.bugly.proguard.ab.r()
            if (r0 != 0) goto L_0x0170
            int r0 = com.tencent.bugly.proguard.at.f
            java.lang.String r6 = com.tencent.bugly.proguard.at.k
            java.lang.String r0 = com.tencent.bugly.proguard.ap.a((int) r0, (java.lang.String) r6)
            r2.w = r0
        L_0x0170:
            java.lang.String r0 = r2.q
            java.lang.String r6 = com.tencent.bugly.proguard.at.q
            if (r6 == 0) goto L_0x0198
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0198
            java.lang.String r6 = com.tencent.bugly.proguard.at.q
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r7 = "Crash filter for crash stack is: %s"
            com.tencent.bugly.proguard.al.c(r7, r6)
            java.lang.String r6 = com.tencent.bugly.proguard.at.q
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = "This crash contains the filter string set. It will not be record and upload."
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.d(r0, r6)
            r0 = r4
            goto L_0x0199
        L_0x0198:
            r0 = r5
        L_0x0199:
            if (r0 == 0) goto L_0x019c
            return r4
        L_0x019c:
            java.lang.String r0 = r2.q
            boolean r0 = a((java.lang.String) r0)
            if (r0 == 0) goto L_0x01a5
            return r4
        L_0x01a5:
            int r0 = r2.b
            r6 = 2
            if (r0 == r6) goto L_0x01d3
            com.tencent.bugly.proguard.y r0 = new com.tencent.bugly.proguard.y
            r0.<init>()
            r0.b = r4
            java.lang.String r6 = r2.A
            r0.c = r6
            java.lang.String r6 = r2.B
            r0.d = r6
            long r6 = r2.r
            r0.e = r6
            com.tencent.bugly.proguard.w r6 = com.tencent.bugly.proguard.w.a()
            r6.b((int) r4)
            com.tencent.bugly.proguard.w r6 = com.tencent.bugly.proguard.w.a()
            r6.a((com.tencent.bugly.proguard.y) r0)
            java.lang.String r0 = "[crash] a crash occur, handling..."
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.b(r0, r6)
            goto L_0x01da
        L_0x01d3:
            java.lang.String r0 = "[crash] a caught exception occur, handling..."
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.b(r0, r6)
        L_0x01da:
            java.util.List r6 = b()
            java.util.ArrayList r7 = new java.util.ArrayList
            r0 = 10
            r7.<init>(r0)
            if (r6 == 0) goto L_0x0244
            int r0 = r6.size()
            if (r0 <= 0) goto L_0x0244
            java.util.List r0 = a((java.util.List<com.tencent.bugly.proguard.ar>) r6)
            r7.addAll(r0)
            r6.removeAll(r7)
            int r0 = r6.size()
            long r8 = (long) r0
            r10 = 20
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x023d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "_id in ("
            r0.append(r8)
            java.lang.String r8 = "SELECT _id FROM t_cr order by _id limit 5"
            r0.append(r8)
            java.lang.String r8 = ")"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0.setLength(r5)
            com.tencent.bugly.proguard.w r0 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x0233 }
            int r0 = r0.a((java.lang.String) r3, (java.lang.String) r8)     // Catch:{ all -> 0x0233 }
            java.lang.String r8 = "deleted first record %s data %d"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0233 }
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r0}     // Catch:{ all -> 0x0233 }
            com.tencent.bugly.proguard.al.c(r8, r0)     // Catch:{ all -> 0x0233 }
            goto L_0x023d
        L_0x0233:
            r0 = move-exception
            boolean r3 = com.tencent.bugly.proguard.al.a(r0)
            if (r3 != 0) goto L_0x023d
            r0.printStackTrace()
        L_0x023d:
            boolean r0 = r1.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r2, (java.util.List<com.tencent.bugly.proguard.ar>) r6, (java.util.List<com.tencent.bugly.proguard.ar>) r7)
            if (r0 == 0) goto L_0x0244
            return r4
        L_0x0244:
            r18.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r19)
            java.util.Map<java.lang.Integer, java.lang.String> r0 = k
            int r1 = r2.b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x0274
            com.tencent.bugly.proguard.ag r0 = com.tencent.bugly.proguard.ag.a.f9520a
            com.tencent.bugly.proguard.ag$c r1 = new com.tencent.bugly.proguard.ag$c
            java.lang.String r9 = r2.c
            long r11 = r2.r
            java.lang.String r16 = "realtime"
            r17 = 0
            r13 = 1
            r14 = 0
            r8 = r1
            r8.<init>(r9, r10, r11, r13, r14, r16, r17)
            r0.a((com.tencent.bugly.proguard.ag.c) r1)
        L_0x0274:
            d((java.util.List<com.tencent.bugly.proguard.ar>) r7)
            java.lang.String r0 = "[crash] save crash success"
            java.lang.Object[] r1 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.b(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.a(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.List<com.tencent.bugly.proguard.ar>, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4 A[Catch:{ all -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bc A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tencent.bugly.proguard.ar> b() {
        /*
            java.lang.String r0 = "t_cr"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.lang.String r3 = "_id"
            java.lang.String r4 = "_tm"
            java.lang.String r5 = "_s1"
            java.lang.String r6 = "_up"
            java.lang.String r7 = "_me"
            java.lang.String r8 = "_uc"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}     // Catch:{ all -> 0x00ad }
            com.tencent.bugly.proguard.w r4 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x00ad }
            android.database.Cursor r3 = r4.a((java.lang.String) r0, (java.lang.String[]) r3, (java.lang.String) r2)     // Catch:{ all -> 0x00ad }
            if (r3 != 0) goto L_0x0028
            if (r3 == 0) goto L_0x0027
            r3.close()
        L_0x0027:
            return r2
        L_0x0028:
            int r2 = r3.getCount()     // Catch:{ all -> 0x0050 }
            if (r2 > 0) goto L_0x0032
            r3.close()
            return r1
        L_0x0032:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            r2.<init>()     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "_id in ("
            r2.append(r4)     // Catch:{ all -> 0x0050 }
            r4 = 0
            r5 = r4
        L_0x003e:
            boolean r6 = r3.moveToNext()     // Catch:{ all -> 0x0050 }
            java.lang.String r7 = ","
            if (r6 == 0) goto L_0x006e
            com.tencent.bugly.proguard.ar r6 = b((android.database.Cursor) r3)     // Catch:{ all -> 0x0050 }
            if (r6 == 0) goto L_0x0053
            r1.add(r6)     // Catch:{ all -> 0x0050 }
            goto L_0x003e
        L_0x0050:
            r0 = move-exception
            r2 = r3
            goto L_0x00ae
        L_0x0053:
            java.lang.String r6 = "_id"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ all -> 0x0066 }
            long r8 = r3.getLong(r6)     // Catch:{ all -> 0x0066 }
            r2.append(r8)     // Catch:{ all -> 0x0066 }
            r2.append(r7)     // Catch:{ all -> 0x0066 }
            int r5 = r5 + 1
            goto L_0x003e
        L_0x0066:
            java.lang.String r6 = "unknown id!"
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x0050 }
            com.tencent.bugly.proguard.al.d(r6, r7)     // Catch:{ all -> 0x0050 }
            goto L_0x003e
        L_0x006e:
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0050 }
            boolean r6 = r6.contains(r7)     // Catch:{ all -> 0x0050 }
            if (r6 == 0) goto L_0x0086
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            int r7 = r2.lastIndexOf(r7)     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = r2.substring(r4, r7)     // Catch:{ all -> 0x0050 }
            r6.<init>(r2)     // Catch:{ all -> 0x0050 }
            r2 = r6
        L_0x0086:
            java.lang.String r6 = ")"
            r2.append(r6)     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0050 }
            r2.setLength(r4)     // Catch:{ all -> 0x0050 }
            if (r5 <= 0) goto L_0x00a9
            com.tencent.bugly.proguard.w r2 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x0050 }
            int r2 = r2.a((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "deleted %s illegal data %d"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0050 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r2}     // Catch:{ all -> 0x0050 }
            com.tencent.bugly.proguard.al.d(r4, r0)     // Catch:{ all -> 0x0050 }
        L_0x00a9:
            r3.close()
            return r1
        L_0x00ad:
            r0 = move-exception
        L_0x00ae:
            boolean r3 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x00ba
            r0.printStackTrace()     // Catch:{ all -> 0x00b8 }
            goto L_0x00ba
        L_0x00b8:
            r0 = move-exception
            goto L_0x00c0
        L_0x00ba:
            if (r2 == 0) goto L_0x00bf
            r2.close()
        L_0x00bf:
            return r1
        L_0x00c0:
            if (r2 == 0) goto L_0x00c5
            r2.close()
        L_0x00c5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.b():java.util.List");
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (!ap.b(str)) {
            try {
                bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
                al.c("attach crash infos", new Object[0]);
                arrayList.add(bnVar);
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.b == 1 && (str = crashDetailBean.v) != null) {
            try {
                bn a2 = a("tomb.zip", context, str);
                if (a2 != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
                al.c("attach extraData", new Object[0]);
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private boolean b(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        int i2 = crashDetailBean.b;
        if (!(!p.c ? ((i2 == 3) || (i2 == 0 || i2 == 1)) ? at.e : true : false)) {
            return false;
        }
        ArrayList<ar> arrayList = new ArrayList<>(10);
        if (!a(crashDetailBean, list, (List<ar>) arrayList)) {
            try {
                if (arrayList.size() >= at.d) {
                }
            } catch (Exception e2) {
                al.a(e2);
                al.d("Failed to merge crash.", new Object[0]);
            }
            return false;
        }
        al.a("same crash occur too much do merged!", new Object[0]);
        CrashDetailBean a2 = a((List<ar>) arrayList, crashDetailBean);
        for (ar arVar : arrayList) {
            if (arVar.f9539a != a2.f9505a) {
                list2.add(arVar);
            }
        }
        b(a2);
        d(list2);
        al.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
        return true;
    }

    private static boolean a(String str) {
        String str2 = at.r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                al.c("Crash regular filter for crash stack is: %s", at.r);
                if (Pattern.compile(at.r).matcher(str).find()) {
                    al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e2) {
                al.a(e2);
                al.d("Failed to compile " + at.r, new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z = false;
        for (ar next : list) {
            if (crashDetailBean.u.equals(next.c)) {
                if (next.e) {
                    z = true;
                }
                list2.add(next);
            }
        }
        return z;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c2 = ac.a().c();
        if (c2 == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c2.f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b2 = ap.b();
            List<ar> b3 = b();
            al.c("Size of crash list loaded from DB: %s", Integer.valueOf(b3.size()));
            if (b3.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(a(b3));
            b3.removeAll(arrayList);
            Iterator<ar> it = b3.iterator();
            while (it.hasNext()) {
                ar next = it.next();
                long j2 = next.b;
                if (j2 < b2 - at.j) {
                    arrayList2.add(next);
                    it.remove();
                    arrayList.add(next);
                } else if (next.d) {
                    if (j2 >= currentTimeMillis - DateUtils.MILLIS_PER_DAY) {
                        it.remove();
                    } else if (!next.e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (((long) next.f) >= 3 && j2 < currentTimeMillis - DateUtils.MILLIS_PER_DAY) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            b((List<ar>) arrayList2);
            if (arrayList.size() > 0) {
                d((List<ar>) arrayList);
            }
            ArrayList arrayList3 = new ArrayList();
            List<CrashDetailBean> c3 = c(b3);
            if (c3 != null && c3.size() > 0) {
                String str = aa.b().o;
                Iterator<CrashDetailBean> it2 = c3.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f)) {
                        it2.remove();
                        arrayList3.add(next2);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                e((List<CrashDetailBean>) arrayList3);
            }
            return c3;
        }
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void a(List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        List<CrashDetailBean> list2 = list;
        if (!aa.a(this.b).f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
        } else if (z3 || aiVar.b(at.f9543a)) {
            StrategyBean c2 = this.e.c();
            if (!c2.f) {
                al.d("remote report is disable!", new Object[0]);
                al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list2 == null || list.size() == 0) {
                al.d("warn: crashList is null or crashList num is 0", new Object[0]);
            } else {
                try {
                    String str = c2.r;
                    String str2 = StrategyBean.b;
                    bp a2 = a(this.b, list, aa.b());
                    if (a2 == null) {
                        al.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] a3 = ae.a((m) a2);
                    if (a3 == null) {
                        al.d("send encode fail!", new Object[0]);
                        return;
                    }
                    bq a4 = ae.a(this.b, 830, a3);
                    if (a4 == null) {
                        al.d("request package is null.", new Object[0]);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    final List<CrashDetailBean> list3 = list;
                    final boolean z4 = z;
                    AnonymousClass6 r1 = new ah() {
                        public final void a(boolean z, String str) {
                            as.a(list3, z, System.currentTimeMillis() - currentTimeMillis, z4 ? "realtime" : "cache", str);
                            as.a(z, (List<CrashDetailBean>) list3);
                        }
                    };
                    if (z) {
                        this.c.a(f9540a, a4, str, str2, (ah) r1, j2, z2);
                        return;
                    }
                    this.c.a(f9540a, a4, str, str2, r1, false);
                } catch (Throwable th) {
                    al.e("req cr error %s", th.toString());
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        } else {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
        }
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean next : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", next.c, Integer.valueOf(next.l), Boolean.valueOf(next.d), Boolean.valueOf(next.j));
                int i2 = next.l + 1;
                next.l = i2;
                next.d = z;
                al.c("set uid:%s uc:%d re:%b me:%b", next.c, Integer.valueOf(i2), Boolean.valueOf(next.d), Boolean.valueOf(next.j));
            }
            for (CrashDetailBean a2 : list) {
                at.a().a(a2);
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            al.b("[crash] upload fail.", new Object[0]);
        }
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f9505a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        Context context2 = context;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        aa aaVar2 = aaVar;
        boolean z = false;
        ArrayList<bl> arrayList = null;
        if (context2 == null || crashDetailBean2 == null || aaVar2 == null) {
            al.d("enExp args == null", new Object[0]);
            return null;
        }
        bo boVar = new bo();
        boVar.f9570a = e(crashDetailBean);
        boVar.b = crashDetailBean2.r;
        boVar.c = crashDetailBean2.n;
        boVar.d = crashDetailBean2.o;
        boVar.e = crashDetailBean2.p;
        boVar.g = crashDetailBean2.q;
        boVar.h = crashDetailBean2.z;
        boVar.i = crashDetailBean2.c;
        boVar.j = null;
        boVar.l = crashDetailBean2.m;
        boVar.m = crashDetailBean2.e;
        boVar.f = crashDetailBean2.B;
        boVar.n = null;
        Map<String, PlugInBean> map = crashDetailBean2.h;
        if (map != null && !map.isEmpty()) {
            arrayList = new ArrayList<>(crashDetailBean2.h.size());
            for (Map.Entry next : crashDetailBean2.h.entrySet()) {
                bl blVar = new bl();
                blVar.f9567a = ((PlugInBean) next.getValue()).f9503a;
                blVar.c = ((PlugInBean) next.getValue()).c;
                blVar.e = ((PlugInBean) next.getValue()).b;
                arrayList.add(blVar);
            }
        }
        boVar.p = arrayList;
        al.c("libInfo %s", boVar.o);
        ArrayList<bn> arrayList2 = new ArrayList<>(20);
        a(arrayList2, crashDetailBean2);
        a(arrayList2, crashDetailBean2.w);
        b(arrayList2, crashDetailBean2.x);
        c(arrayList2, crashDetailBean2.Z);
        a(arrayList2, crashDetailBean2.aa, context2);
        a(arrayList2, crashDetailBean2.y);
        a(arrayList2, crashDetailBean2, context2);
        b(arrayList2, crashDetailBean2, context2);
        a(arrayList2, aaVar2.L);
        b(arrayList2, crashDetailBean2.Y);
        boVar.q = arrayList2;
        if (crashDetailBean2.j) {
            boVar.k = crashDetailBean2.t;
        }
        boVar.r = a(crashDetailBean, aaVar);
        boVar.s = new HashMap();
        Map<String, String> map2 = crashDetailBean2.S;
        if (map2 != null && map2.size() > 0) {
            boVar.s.putAll(crashDetailBean2.S);
            al.a("setted message size %d", Integer.valueOf(boVar.s.size()));
        }
        Map<String, String> map3 = boVar.s;
        al.c("pss:" + crashDetailBean2.I + " vss:" + crashDetailBean2.J + " javaHeap:" + crashDetailBean2.K, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(crashDetailBean2.I);
        map3.put("SDK_UPLOAD_U1", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean2.J);
        map3.put("SDK_UPLOAD_U2", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean2.K);
        map3.put("SDK_UPLOAD_U3", sb3.toString());
        String str = crashDetailBean2.n;
        String str2 = crashDetailBean2.c;
        String d2 = aaVar.d();
        Long valueOf = Long.valueOf((crashDetailBean2.r - crashDetailBean2.Q) / 1000);
        Boolean valueOf2 = Boolean.valueOf(crashDetailBean2.k);
        Boolean valueOf3 = Boolean.valueOf(crashDetailBean2.R);
        Boolean valueOf4 = Boolean.valueOf(crashDetailBean2.j);
        if (crashDetailBean2.b == 1) {
            z = true;
        }
        al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", str, str2, d2, valueOf, valueOf2, valueOf3, valueOf4, Boolean.valueOf(z), Integer.valueOf(crashDetailBean2.t), crashDetailBean2.s, Boolean.valueOf(crashDetailBean2.d), Integer.valueOf(boVar.r.size()));
        return boVar;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context == null || list == null || list.size() == 0 || aaVar == null) {
            al.d("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        bp bpVar = new bp();
        bpVar.f9571a = new ArrayList<>();
        for (CrashDetailBean a2 : list) {
            bpVar.f9571a.add(a(context, a2, aaVar));
        }
        return bpVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095 A[SYNTHETIC, Splitter:B:37:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a9 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.bugly.proguard.bn a(java.lang.String r6, android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "del tmp"
            r1 = 0
            r2 = 0
            if (r8 == 0) goto L_0x00d1
            if (r7 != 0) goto L_0x000a
            goto L_0x00d1
        L_0x000a:
            java.lang.String r3 = "zip %s"
            java.lang.Object[] r4 = new java.lang.Object[]{r8}
            com.tencent.bugly.proguard.al.c(r3, r4)
            java.io.File r3 = new java.io.File
            r3.<init>(r8)
            java.io.File r8 = new java.io.File
            java.io.File r7 = r7.getCacheDir()
            r8.<init>(r7, r6)
            boolean r6 = com.tencent.bugly.proguard.ap.a((java.io.File) r3, (java.io.File) r8)
            if (r6 != 0) goto L_0x002f
            java.lang.String r6 = "zip fail!"
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.d(r6, r7)
            return r1
        L_0x002f:
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0085 }
            r7.<init>(r8)     // Catch:{ all -> 0x0085 }
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x004a }
        L_0x003d:
            int r4 = r7.read(r3)     // Catch:{ all -> 0x004a }
            if (r4 <= 0) goto L_0x004c
            r6.write(r3, r2, r4)     // Catch:{ all -> 0x004a }
            r6.flush()     // Catch:{ all -> 0x004a }
            goto L_0x003d
        L_0x004a:
            r6 = move-exception
            goto L_0x0087
        L_0x004c:
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "read bytes :%d"
            int r4 = r6.length     // Catch:{ all -> 0x004a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x004a }
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch:{ all -> 0x004a }
            com.tencent.bugly.proguard.al.c(r3, r4)     // Catch:{ all -> 0x004a }
            com.tencent.bugly.proguard.bn r3 = new com.tencent.bugly.proguard.bn     // Catch:{ all -> 0x004a }
            java.lang.String r4 = r8.getName()     // Catch:{ all -> 0x004a }
            r5 = 2
            r3.<init>(r5, r4, r6)     // Catch:{ all -> 0x004a }
            r7.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0076
        L_0x006c:
            r6 = move-exception
            boolean r7 = com.tencent.bugly.proguard.al.a(r6)
            if (r7 != 0) goto L_0x0076
            r6.printStackTrace()
        L_0x0076:
            boolean r6 = r8.exists()
            if (r6 == 0) goto L_0x0084
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.c(r0, r6)
            r8.delete()
        L_0x0084:
            return r3
        L_0x0085:
            r6 = move-exception
            r7 = r1
        L_0x0087:
            boolean r3 = com.tencent.bugly.proguard.al.a(r6)     // Catch:{ all -> 0x0091 }
            if (r3 != 0) goto L_0x0093
            r6.printStackTrace()     // Catch:{ all -> 0x0091 }
            goto L_0x0093
        L_0x0091:
            r6 = move-exception
            goto L_0x00b2
        L_0x0093:
            if (r7 == 0) goto L_0x00a3
            r7.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x00a3
        L_0x0099:
            r6 = move-exception
            boolean r7 = com.tencent.bugly.proguard.al.a(r6)
            if (r7 != 0) goto L_0x00a3
            r6.printStackTrace()
        L_0x00a3:
            boolean r6 = r8.exists()
            if (r6 == 0) goto L_0x00b1
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.c(r0, r6)
            r8.delete()
        L_0x00b1:
            return r1
        L_0x00b2:
            if (r7 == 0) goto L_0x00c2
            r7.close()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00c2
        L_0x00b8:
            r7 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r7)
            if (r1 != 0) goto L_0x00c2
            r7.printStackTrace()
        L_0x00c2:
            boolean r7 = r8.exists()
            if (r7 == 0) goto L_0x00d0
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.c(r0, r7)
            r8.delete()
        L_0x00d0:
            throw r6
        L_0x00d1:
            java.lang.String r6 = "rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}"
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.d(r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.a(java.lang.String, android.content.Context, java.lang.String):com.tencent.bugly.proguard.bn");
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa b2 = aa.b();
        if (b2 != null) {
            al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            al.e("# PKG NAME: %s", b2.c);
            al.e("# APP VER: %s", b2.o);
            al.e("# SDK VER: %s", b2.h);
            al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().f9513a)));
            al.e("# CRASH TYPE: %s", str);
            al.e("# CRASH TIME: %s", str2);
            al.e("# CRASH PROCESS: %s", str3);
            al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b2.a()));
            al.e("# CRASH THREAD: %s", str4);
            if (crashDetailBean != null) {
                al.e("# REPORT ID: %s", crashDetailBean.c);
                al.e("# CRASH DEVICE: %s %s", b2.h(), b2.r().booleanValue() ? "ROOTED" : "UNROOT");
                al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
                al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
                if (!ap.b(crashDetailBean.O)) {
                    al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
                } else if (crashDetailBean.b == 3) {
                    if (crashDetailBean.T == null) {
                        str6 = "null";
                    } else {
                        str6 = crashDetailBean.T.get("BUGLY_CR_01");
                    }
                    al.e("# EXCEPTION ANR MESSAGE:\n %s", str6);
                }
            }
            if (!ap.b(str5)) {
                al.e("# CRASH STACK: ", new Object[0]);
                al.e(str5, new Object[0]);
            }
            al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String str;
        if (map == null || map.isEmpty()) {
            al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
            return;
        }
        crashDetailBean.S = new LinkedHashMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (!ap.b((String) next.getKey())) {
                String str2 = (String) next.getKey();
                if (str2.length() > 100) {
                    str2 = str2.substring(0, 100);
                    al.d("setted key length is over limit %d substring to %s", 100, str2);
                }
                if (ap.b((String) next.getValue()) || ((String) next.getValue()).length() <= 100000) {
                    str = (String) next.getValue();
                } else {
                    str = ((String) next.getValue()).substring(((String) next.getValue()).length() - 100000);
                    al.d("setted %s value length is over limit %d substring", str2, 100000);
                }
                crashDetailBean.S.put(str2, str);
                al.a("add setted key %s value size:%d", str2, Integer.valueOf(str.length()));
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.j && (str = crashDetailBean.s) != null && str.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn a2 = a("backupRecord.zip", context, str);
                if (a2 != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
                al.c("attach user log", new Object[0]);
                arrayList.add(bnVar);
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn a2;
        if (crashDetailBean.b == 3) {
            al.c("crashBean.anrMessages:%s", crashDetailBean.T);
            try {
                Map<String, String> map = crashDetailBean.T;
                if (map != null && map.containsKey("BUGLY_CR_01")) {
                    if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                        arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                        al.c("attach anr message", new Object[0]);
                    }
                    crashDetailBean.T.remove("BUGLY_CR_01");
                }
                String str = crashDetailBean.v;
                if (str != null && (a2 = a("trace.zip", context, str)) != null) {
                    al.c("attach traces", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String append : list) {
                sb.append(append);
            }
            try {
                arrayList.add(new bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                al.c("attach pageTracingList", new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.C);
            hashMap.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.D);
            hashMap.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.E);
            hashMap.put("A10", sb3.toString());
            hashMap.put("A23", crashDetailBean.f);
            StringBuilder sb4 = new StringBuilder();
            aaVar.getClass();
            hashMap.put("A7", sb4.toString());
            hashMap.put("A6", aa.n());
            hashMap.put("A5", aaVar.m());
            hashMap.put("A22", aaVar.g());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.G);
            hashMap.put("A2", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.F);
            hashMap.put("A1", sb6.toString());
            hashMap.put("A24", aaVar.k);
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.H);
            hashMap.put("A17", sb7.toString());
            hashMap.put("A25", aaVar.g());
            hashMap.put("A15", aaVar.q());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(aaVar.r());
            hashMap.put("A13", sb8.toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                hashMap.put("productIdentify", aaVar.G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.L, "utf-8"));
            if (crashDetailBean.b == 1) {
                hashMap.put("A27", crashDetailBean.O);
                hashMap.put("A28", crashDetailBean.N);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(crashDetailBean.k);
                hashMap.put("A29", sb9.toString());
            }
            hashMap.put("A30", crashDetailBean.P);
            StringBuilder sb10 = new StringBuilder();
            sb10.append(crashDetailBean.Q);
            hashMap.put("A18", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(true ^ crashDetailBean.R);
            hashMap.put("A36", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(aaVar.z);
            hashMap.put("F02", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aaVar.A);
            hashMap.put("F03", sb13.toString());
            hashMap.put("F04", aaVar.d());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aaVar.B);
            hashMap.put("F05", sb14.toString());
            hashMap.put("F06", aaVar.y);
            hashMap.put("F08", aaVar.E);
            hashMap.put("F09", aaVar.F);
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aaVar.C);
            hashMap.put("F10", sb15.toString());
            a((Map<String, String>) hashMap, crashDetailBean);
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.U);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.V >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.V);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = crashDetailBean.W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry next : crashDetailBean.W.entrySet()) {
                map.put("C03_" + ((String) next.getKey()), next.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.X;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry next2 : crashDetailBean.X.entrySet()) {
                map.put("C04_" + ((String) next2.getKey()), next2.getValue());
            }
        }
    }

    public static /* synthetic */ void a(List list, boolean z, long j2, String str, String str2) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
                String str3 = l.get(Integer.valueOf(crashDetailBean.b));
                if (!TextUtils.isEmpty(str3)) {
                    arrayList.add(new ag.c(crashDetailBean.c, str3, crashDetailBean.r, z, j2, str, str2));
                }
            }
            ag.a.f9520a.a((List<ag.c>) arrayList);
        }
    }
}
