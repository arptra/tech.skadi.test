package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final long f9596a = System.currentTimeMillis();
    private static u b;
    private Context c;
    /* access modifiers changed from: private */
    public String d = aa.b().d;
    /* access modifiers changed from: private */
    public Map<Integer, Map<String, t>> e = new HashMap();
    /* access modifiers changed from: private */
    public SharedPreferences f;

    private u(Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if (r6 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004e, code lost:
        if (r6 != null) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0053 A[SYNTHETIC, Splitter:B:36:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T extends java.util.List<?>> T d(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            android.content.Context r3 = r5.c     // Catch:{ Exception -> 0x0057 }
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0057 }
            r2.<init>(r3, r6)     // Catch:{ Exception -> 0x0057 }
            boolean r6 = r2.exists()     // Catch:{ Exception -> 0x0057 }
            if (r6 != 0) goto L_0x001c
            monitor-exit(r5)
            return r0
        L_0x001c:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0046, ClassNotFoundException -> 0x0038, all -> 0x0035 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0046, ClassNotFoundException -> 0x0038, all -> 0x0035 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0046, ClassNotFoundException -> 0x0038, all -> 0x0035 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0046, ClassNotFoundException -> 0x0038, all -> 0x0035 }
            java.lang.Object r2 = r6.readObject()     // Catch:{ IOException -> 0x0047, ClassNotFoundException -> 0x0039 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ IOException -> 0x0047, ClassNotFoundException -> 0x0039 }
            r6.close()     // Catch:{ Exception -> 0x0057 }
            monitor-exit(r5)
            return r2
        L_0x0031:
            r6 = move-exception
            goto L_0x0060
        L_0x0033:
            r2 = move-exception
            goto L_0x0051
        L_0x0035:
            r2 = move-exception
            r6 = r0
            goto L_0x0051
        L_0x0038:
            r6 = r0
        L_0x0039:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0033 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0033 }
            if (r6 == 0) goto L_0x005e
        L_0x0042:
            r6.close()     // Catch:{ Exception -> 0x0057 }
            goto L_0x005e
        L_0x0046:
            r6 = r0
        L_0x0047:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0033 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0033 }
            if (r6 == 0) goto L_0x005e
            goto L_0x0042
        L_0x0051:
            if (r6 == 0) goto L_0x0056
            r6.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0056:
            throw r2     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0031 }
            com.tencent.bugly.proguard.al.e(r6, r1)     // Catch:{ all -> 0x0031 }
        L_0x005e:
            monitor-exit(r5)
            return r0
        L_0x0060:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.d(int):java.util.List");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean c(int r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 0
            java.util.List r1 = r12.d(r13)     // Catch:{ Exception -> 0x0081 }
            if (r1 != 0) goto L_0x000a
            monitor-exit(r12)
            return r0
        L_0x000a:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0081 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0081 }
            r4.<init>()     // Catch:{ Exception -> 0x0081 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0081 }
            r5.<init>()     // Catch:{ Exception -> 0x0081 }
            java.util.Iterator r6 = r1.iterator()     // Catch:{ Exception -> 0x0081 }
        L_0x001c:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0081 }
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            if (r7 == 0) goto L_0x004c
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0081 }
            com.tencent.bugly.proguard.t r7 = (com.tencent.bugly.proguard.t) r7     // Catch:{ Exception -> 0x0081 }
            java.lang.String r10 = r7.b     // Catch:{ Exception -> 0x0081 }
            if (r10 == 0) goto L_0x0041
            java.lang.String r11 = r12.d     // Catch:{ Exception -> 0x0081 }
            boolean r10 = r10.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0081 }
            if (r10 == 0) goto L_0x0041
            int r10 = r7.d     // Catch:{ Exception -> 0x0081 }
            if (r10 <= 0) goto L_0x0041
            r4.add(r7)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0041
        L_0x003f:
            r13 = move-exception
            goto L_0x008a
        L_0x0041:
            long r10 = r7.c     // Catch:{ Exception -> 0x0081 }
            long r10 = r10 + r8
            int r8 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x001c
            r5.add(r7)     // Catch:{ Exception -> 0x0081 }
            goto L_0x001c
        L_0x004c:
            java.util.Collections.sort(r4)     // Catch:{ Exception -> 0x0081 }
            int r6 = r4.size()     // Catch:{ Exception -> 0x0081 }
            r7 = 2
            if (r6 < r7) goto L_0x0079
            int r5 = r4.size()     // Catch:{ Exception -> 0x0081 }
            r6 = 1
            if (r5 <= 0) goto L_0x0077
            int r5 = r4.size()     // Catch:{ Exception -> 0x0081 }
            int r5 = r5 - r6
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x0081 }
            com.tencent.bugly.proguard.t r4 = (com.tencent.bugly.proguard.t) r4     // Catch:{ Exception -> 0x0081 }
            long r4 = r4.c     // Catch:{ Exception -> 0x0081 }
            long r4 = r4 + r8
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0077
            r1.clear()     // Catch:{ Exception -> 0x0081 }
            r12.a((int) r13, r1)     // Catch:{ Exception -> 0x0081 }
            monitor-exit(r12)
            return r0
        L_0x0077:
            monitor-exit(r12)
            return r6
        L_0x0079:
            r1.removeAll(r5)     // Catch:{ Exception -> 0x0081 }
            r12.a((int) r13, r1)     // Catch:{ Exception -> 0x0081 }
            monitor-exit(r12)
            return r0
        L_0x0081:
            java.lang.String r13 = "isFrequentCrash failed"
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x003f }
            com.tencent.bugly.proguard.al.e(r13, r1)     // Catch:{ all -> 0x003f }
            monitor-exit(r12)
            return r0
        L_0x008a:
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.c(int):boolean");
    }

    public final synchronized boolean b(final int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f;
            z = sharedPreferences.getBoolean(i + AccountConstantKt.DEFAULT_SEGMENT + this.d, true);
            ak.a().a(new Runnable() {
                public final void run() {
                    boolean b2 = u.this.c(i);
                    SharedPreferences.Editor edit = u.this.f.edit();
                    edit.putBoolean(i + AccountConstantKt.DEFAULT_SEGMENT + u.this.d, !b2).commit();
                }
            });
        } catch (Exception unused) {
            al.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            try {
                if (b == null) {
                    b = new u(context);
                }
                uVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = b;
        }
        return uVar;
    }

    public static /* synthetic */ boolean b(t tVar, t tVar2) {
        String str = tVar.e;
        if (str != null && !str.equalsIgnoreCase(tVar2.e)) {
            return true;
        }
        String str2 = tVar.f;
        return (str2 != null && !str2.equalsIgnoreCase(tVar2.f)) || tVar.d <= 0;
    }

    public final void a(final int i) {
        ak.a().a(new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f9597a = 1004;

            public final void run() {
                t tVar;
                try {
                    if (!TextUtils.isEmpty(u.this.d)) {
                        List<t> a2 = u.this.d(this.f9597a);
                        if (a2 == null) {
                            a2 = new ArrayList<>();
                        }
                        if (u.this.e.get(Integer.valueOf(this.f9597a)) == null) {
                            u.this.e.put(Integer.valueOf(this.f9597a), new HashMap());
                        }
                        if (((Map) u.this.e.get(Integer.valueOf(this.f9597a))).get(u.this.d) == null) {
                            tVar = new t();
                            tVar.f9595a = (long) this.f9597a;
                            tVar.g = u.f9596a;
                            tVar.b = u.this.d;
                            tVar.f = aa.b().o;
                            tVar.e = aa.b().h;
                            tVar.c = System.currentTimeMillis();
                            tVar.d = i;
                            ((Map) u.this.e.get(Integer.valueOf(this.f9597a))).put(u.this.d, tVar);
                        } else {
                            tVar = (t) ((Map) u.this.e.get(Integer.valueOf(this.f9597a))).get(u.this.d);
                            tVar.d = i;
                        }
                        ArrayList arrayList = new ArrayList();
                        boolean z = false;
                        for (t tVar2 : a2) {
                            if (u.a(tVar2, tVar)) {
                                tVar2.d = tVar.d;
                                z = true;
                            }
                            if (u.b(tVar2, tVar)) {
                                arrayList.add(tVar2);
                            }
                        }
                        a2.removeAll(arrayList);
                        if (!z) {
                            a2.add(tVar);
                        }
                        u.this.a(this.f9597a, a2);
                    }
                } catch (Exception unused) {
                    al.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC, Splitter:B:26:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0048 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004c A[SYNTHETIC, Splitter:B:33:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L_0x0005
            monitor-exit(r4)
            return
        L_0x0005:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0050 }
            android.content.Context r2 = r4.c     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0050 }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x0050 }
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0034, all -> 0x0030 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034, all -> 0x0030 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0034, all -> 0x0030 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0034, all -> 0x0030 }
            r2.writeObject(r6)     // Catch:{ IOException -> 0x002e }
            r2.close()     // Catch:{ Exception -> 0x0050 }
            monitor-exit(r4)
            return
        L_0x002a:
            r5 = move-exception
            goto L_0x0059
        L_0x002c:
            r5 = move-exception
            goto L_0x004a
        L_0x002e:
            r5 = move-exception
            goto L_0x0037
        L_0x0030:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L_0x004a
        L_0x0034:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L_0x0037:
            r5.printStackTrace()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x002c }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ Exception -> 0x0050 }
            monitor-exit(r4)
            return
        L_0x0048:
            monitor-exit(r4)
            return
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ Exception -> 0x0050 }
        L_0x004f:
            throw r5     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x002a }
            com.tencent.bugly.proguard.al.e(r5, r6)     // Catch:{ all -> 0x002a }
            monitor-exit(r4)
            return
        L_0x0059:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.a(int, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r4 = r4.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean a(com.tencent.bugly.proguard.t r4, com.tencent.bugly.proguard.t r5) {
        /*
            long r0 = r4.g
            long r2 = r5.g
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0016
            java.lang.String r4 = r4.b
            if (r4 == 0) goto L_0x0016
            java.lang.String r5 = r5.b
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x0016
            r4 = 1
            return r4
        L_0x0016:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.a(com.tencent.bugly.proguard.t, com.tencent.bugly.proguard.t):boolean");
    }
}
