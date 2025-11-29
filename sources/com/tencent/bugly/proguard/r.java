package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

public final class r {
    private static boolean e = true;

    /* renamed from: a  reason: collision with root package name */
    private Context f9587a;
    /* access modifiers changed from: private */
    public long b;
    private int c;
    /* access modifiers changed from: private */
    public boolean d;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9590a;
        public UserInfoBean b;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.f9590a = z;
        }

        public final void run() {
            if (r.this.d) {
                try {
                    UserInfoBean userInfoBean = this.b;
                    if (userInfoBean != null) {
                        r.a(userInfoBean);
                        al.c("[UserInfo] Record user info.", new Object[0]);
                        r.this.a(this.b, false);
                    }
                    if (this.f9590a) {
                        r.this.b();
                    }
                } catch (Throwable th) {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < r.this.b) {
                ak.a().a(new b(), (r.this.b - currentTimeMillis) + 5000);
                return;
            }
            r.this.a(3, false);
            r.this.a();
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public long f9592a;

        public c(long j) {
            this.f9592a = j;
        }

        public final void run() {
            r.this.b();
            r.this.a(this.f9592a);
        }
    }

    public r(Context context, boolean z) {
        this.f9587a = context;
        this.d = z;
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f != -1) {
                it.remove();
                if (next.e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    public final void a(int i, boolean z) {
        ac a2 = ac.a();
        int i2 = 0;
        if (a2 == null || a2.c().g || i == 1 || i == 3) {
            if (i == 1 || i == 3) {
                this.c++;
            }
            aa a3 = aa.a(this.f9587a);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.b = i;
            userInfoBean.c = a3.d;
            userInfoBean.d = a3.f();
            userInfoBean.e = System.currentTimeMillis();
            userInfoBean.f = -1;
            userInfoBean.n = a3.o;
            if (i == 1) {
                i2 = 1;
            }
            userInfoBean.o = i2;
            userInfoBean.l = a3.a();
            userInfoBean.m = a3.y;
            userInfoBean.g = a3.z;
            userInfoBean.h = a3.A;
            userInfoBean.i = a3.B;
            userInfoBean.k = a3.C;
            userInfoBean.r = a3.t();
            userInfoBean.s = a3.y();
            userInfoBean.p = a3.z();
            userInfoBean.q = a3.x;
            ak.a().a(new a(userInfoBean, z), 0);
            return;
        }
        al.e("UserInfo is disable", new Object[0]);
    }

    public final void b() {
        ak a2 = ak.a();
        if (a2 != null) {
            a2.a(new Runnable() {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f9589a = false;

                public final void run() {
                    try {
                        r.this.a(this.f9589a);
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
            });
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < list.size() && i < 50) {
                sb.append(" or _id = ");
                sb.append(list.get(i).f9502a);
                i++;
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            try {
                al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2)));
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = userInfoBean.f9502a;
            if (j > 0) {
                contentValues.put("_id", Long.valueOf(j));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", ap.a((Parcelable) userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void a(long j) {
        ak.a().a(new c(j), j);
    }

    public final void a() {
        this.b = ap.b() + DateUtils.MILLIS_PER_DAY;
        ak.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    private boolean b(boolean z) {
        boolean z2 = true;
        if (!e) {
            return true;
        }
        File file = new File(this.f9587a.getFilesDir(), "bugly_last_us_up_tm");
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            am.a(file, String.valueOf(currentTimeMillis), 1024, false);
            return true;
        }
        if (!file.exists()) {
            am.a(file, String.valueOf(currentTimeMillis), 1024, false);
        } else {
            BufferedReader a2 = ap.a(file);
            if (a2 != null) {
                try {
                    long longValue = Long.valueOf(a2.readLine().trim()).longValue();
                    if (currentTimeMillis >= longValue) {
                        if (currentTimeMillis - longValue <= DateUtils.MILLIS_PER_DAY) {
                            if (currentTimeMillis - longValue < 300000) {
                                z2 = false;
                            }
                        }
                    }
                    am.a(file, String.valueOf(currentTimeMillis), 1024, false);
                } catch (Throwable th) {
                    try {
                        a2.close();
                    } catch (Exception e2) {
                        al.a(e2);
                    }
                    throw th;
                }
            }
            if (a2 != null) {
                a2.close();
            }
        }
        return z2;
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i = 0;
            while (i < list.size() - 1) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < list.size(); i3++) {
                    if (list.get(i).e > list.get(i3).e) {
                        list.set(i, list.get(i3));
                        list.set(i3, list.get(i));
                    }
                }
                i = i2;
            }
            for (int i4 = 0; i4 < size; i4++) {
                list2.add(list.get(i4));
            }
        }
    }

    private static int a(List<UserInfoBean> list) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (UserInfoBean next : list) {
            if (next.e > currentTimeMillis - 600000 && ((i = next.b) == 1 || i == 4 || i == 3)) {
                i2++;
            }
        }
        return i2;
    }

    private void a(final List<UserInfoBean> list, boolean z) {
        aa b2;
        if (!b(z)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean next : list) {
                next.f = currentTimeMillis;
                a(next, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i = this.c == 1 ? 1 : 2;
        bv bvVar = null;
        if (!(list == null || list.size() == 0 || (b2 = aa.b()) == null)) {
            b2.o();
            bv bvVar2 = new bv();
            bvVar2.b = b2.d;
            bvVar2.c = b2.g();
            ArrayList<bu> arrayList = new ArrayList<>();
            for (UserInfoBean a2 : list) {
                bu a3 = ae.a(a2);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
            bvVar2.d = arrayList;
            HashMap hashMap = new HashMap();
            bvVar2.e = hashMap;
            hashMap.put("A7", new StringBuilder().toString());
            Map<String, String> map = bvVar2.e;
            map.put("A6", aa.n());
            Map<String, String> map2 = bvVar2.e;
            map2.put("A5", b2.m());
            Map<String, String> map3 = bvVar2.e;
            StringBuilder sb = new StringBuilder();
            sb.append(b2.k());
            map3.put("A2", sb.toString());
            Map<String, String> map4 = bvVar2.e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b2.k());
            map4.put("A1", sb2.toString());
            Map<String, String> map5 = bvVar2.e;
            map5.put("A24", b2.k);
            Map<String, String> map6 = bvVar2.e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b2.l());
            map6.put("A17", sb3.toString());
            Map<String, String> map7 = bvVar2.e;
            map7.put("A15", b2.q());
            Map<String, String> map8 = bvVar2.e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(b2.r());
            map8.put("A13", sb4.toString());
            Map<String, String> map9 = bvVar2.e;
            map9.put("F08", b2.E);
            Map<String, String> map10 = bvVar2.e;
            map10.put("F09", b2.F);
            Map<String, String> y = b2.y();
            if (y != null && y.size() > 0) {
                for (Map.Entry next2 : y.entrySet()) {
                    Map<String, String> map11 = bvVar2.e;
                    map11.put("C04_" + ((String) next2.getKey()), next2.getValue());
                }
            }
            if (i == 1) {
                bvVar2.f9577a = 1;
            } else if (i != 2) {
                al.e("unknown up type %d ", Integer.valueOf(i));
            } else {
                bvVar2.f9577a = 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a4 = ae.a((m) bvVar);
        if (a4 == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq a5 = ae.a(this.f9587a, 840, a4);
        if (a5 == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        AnonymousClass1 r9 = new ah() {
            public final void a(boolean z, String str) {
                if (z) {
                    al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (UserInfoBean userInfoBean : list) {
                        userInfoBean.f = currentTimeMillis;
                        r.this.a(userInfoBean, true);
                    }
                }
            }
        };
        ai.a().a(1001, a5, ac.a().c().q, StrategyBean.f9504a, r9, this.c == 1);
    }

    /* access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean != null) {
            if (z || userInfoBean.b == 1 || (a2 = a(aa.a(this.f9587a).d)) == null || a2.size() < 20) {
                long a3 = w.a().a("t_ui", b(userInfoBean), (v) null);
                if (a3 >= 0) {
                    al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
                    userInfoBean.f9502a = a3;
                    return;
                }
                return;
            }
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096 A[Catch:{ all -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009e A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> a(java.lang.String r7) {
        /*
            java.lang.String r0 = "t_ui"
            r1 = 0
            boolean r2 = com.tencent.bugly.proguard.ap.b((java.lang.String) r7)     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x000b
            r7 = r1
            goto L_0x001e
        L_0x000b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            java.lang.String r3 = "_pc = '"
            r2.<init>(r3)     // Catch:{ all -> 0x008e }
            r2.append(r7)     // Catch:{ all -> 0x008e }
            java.lang.String r7 = "'"
            r2.append(r7)     // Catch:{ all -> 0x008e }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x008e }
        L_0x001e:
            com.tencent.bugly.proguard.w r2 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x008e }
            android.database.Cursor r7 = r2.a((java.lang.String) r0, (java.lang.String[]) r1, (java.lang.String) r7)     // Catch:{ all -> 0x008e }
            if (r7 != 0) goto L_0x002e
            if (r7 == 0) goto L_0x002d
            r7.close()
        L_0x002d:
            return r1
        L_0x002e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r2.<init>()     // Catch:{ all -> 0x0048 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0048 }
            r3.<init>()     // Catch:{ all -> 0x0048 }
        L_0x0038:
            boolean r4 = r7.moveToNext()     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0066
            com.tencent.bugly.crashreport.biz.UserInfoBean r4 = a((android.database.Cursor) r7)     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x004a
            r3.add(r4)     // Catch:{ all -> 0x0048 }
            goto L_0x0038
        L_0x0048:
            r0 = move-exception
            goto L_0x0090
        L_0x004a:
            java.lang.String r4 = "_id"
            int r4 = r7.getColumnIndex(r4)     // Catch:{ all -> 0x005d }
            long r4 = r7.getLong(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r6 = " or _id = "
            r2.append(r6)     // Catch:{ all -> 0x005d }
            r2.append(r4)     // Catch:{ all -> 0x005d }
            goto L_0x0038
        L_0x005d:
            java.lang.String r4 = "[Database] unknown id."
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0048 }
            com.tencent.bugly.proguard.al.d(r4, r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0038
        L_0x0066:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0048 }
            int r4 = r2.length()     // Catch:{ all -> 0x0048 }
            if (r4 <= 0) goto L_0x008a
            r4 = 4
            java.lang.String r2 = r2.substring(r4)     // Catch:{ all -> 0x0048 }
            com.tencent.bugly.proguard.w r4 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x0048 }
            int r2 = r4.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = "[Database] deleted %s error data %d"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0048 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r2}     // Catch:{ all -> 0x0048 }
            com.tencent.bugly.proguard.al.d(r4, r0)     // Catch:{ all -> 0x0048 }
        L_0x008a:
            r7.close()
            return r3
        L_0x008e:
            r0 = move-exception
            r7 = r1
        L_0x0090:
            boolean r2 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x009a }
            if (r2 != 0) goto L_0x009c
            r0.printStackTrace()     // Catch:{ all -> 0x009a }
            goto L_0x009c
        L_0x009a:
            r0 = move-exception
            goto L_0x00a2
        L_0x009c:
            if (r7 == 0) goto L_0x00a1
            r7.close()
        L_0x00a1:
            return r1
        L_0x00a2:
            if (r7 == 0) goto L_0x00a7
            r7.close()
        L_0x00a7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(java.lang.String):java.util.List");
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f9502a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(boolean r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.d     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0006
            goto L_0x0022
        L_0x0006:
            com.tencent.bugly.proguard.ai r0 = com.tencent.bugly.proguard.ai.a()     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x000d
            goto L_0x0022
        L_0x000d:
            com.tencent.bugly.proguard.ac r1 = com.tencent.bugly.proguard.ac.a()     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            boolean r1 = r1.b()     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0026
            r1 = 1001(0x3e9, float:1.403E-42)
            boolean r0 = r0.b((int) r1)     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0026
        L_0x0022:
            monitor-exit(r6)
            return
        L_0x0024:
            r7 = move-exception
            goto L_0x008e
        L_0x0026:
            android.content.Context r0 = r6.f9587a     // Catch:{ all -> 0x0024 }
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.a((android.content.Context) r0)     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = r0.d     // Catch:{ all -> 0x0024 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            java.util.List r0 = a((java.lang.String) r0)     // Catch:{ all -> 0x0024 }
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0058
            a((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r0, (java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r1)     // Catch:{ all -> 0x0024 }
            b(r0, r1)     // Catch:{ all -> 0x0024 }
            int r4 = a((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r0)     // Catch:{ all -> 0x0024 }
            r5 = 15
            if (r4 <= r5) goto L_0x005d
            java.lang.String r3 = "[UserInfo] Upload user info too many times in 10 min: %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0024 }
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch:{ all -> 0x0024 }
            com.tencent.bugly.proguard.al.d(r3, r4)     // Catch:{ all -> 0x0024 }
            r3 = r2
            goto L_0x005d
        L_0x0058:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0024 }
            r0.<init>()     // Catch:{ all -> 0x0024 }
        L_0x005d:
            int r4 = r1.size()     // Catch:{ all -> 0x0024 }
            if (r4 <= 0) goto L_0x0066
            b((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r1)     // Catch:{ all -> 0x0024 }
        L_0x0066:
            if (r3 == 0) goto L_0x0085
            int r1 = r0.size()     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x006f
            goto L_0x0085
        L_0x006f:
            java.lang.String r1 = "[UserInfo] Upload user info(size: %d)"
            int r2 = r0.size()     // Catch:{ all -> 0x0024 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0024 }
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch:{ all -> 0x0024 }
            com.tencent.bugly.proguard.al.c(r1, r2)     // Catch:{ all -> 0x0024 }
            r6.a((java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean>) r0, (boolean) r7)     // Catch:{ all -> 0x0024 }
            monitor-exit(r6)
            return
        L_0x0085:
            java.lang.String r7 = "[UserInfo] There is no user info in local database."
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0024 }
            com.tencent.bugly.proguard.al.c(r7, r0)     // Catch:{ all -> 0x0024 }
            monitor-exit(r6)
            return
        L_0x008e:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(boolean):void");
    }

    public static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa b2;
        if (userInfoBean != null && (b2 = aa.b()) != null) {
            userInfoBean.j = b2.d();
        }
    }
}
