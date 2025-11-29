package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9599a = false;
    private static w b;
    private static x c;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public int f9600a = 4;
        public v b = null;
        public String c;
        public ContentValues d;
        public boolean e;
        public String[] f;
        public String g;
        public String[] h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String[] n;
        public int o;
        public String p;
        public byte[] q;

        public a() {
        }

        public final void a(int i2, String str, byte[] bArr) {
            this.o = i2;
            this.p = str;
            this.q = bArr;
        }

        public final void run() {
            switch (this.f9600a) {
                case 1:
                    long unused = w.this.a(this.c, this.d, this.b);
                    return;
                case 2:
                    int unused2 = w.this.a(this.c, this.m, this.n, this.b);
                    return;
                case 3:
                    Cursor a2 = w.this.a(this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                case 4:
                    boolean unused3 = w.this.a(this.o, this.p, this.q, this.b);
                    return;
                case 5:
                    Map unused4 = w.this.a(this.o, this.b);
                    return;
                case 6:
                    boolean unused5 = w.this.a(this.o, this.p, this.b);
                    return;
                default:
                    return;
            }
        }
    }

    private w(Context context, List<o> list) {
        c = new x(context, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0044=Splitter:B:24:0x0044, B:36:0x005b=Splitter:B:36:0x005b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(com.tencent.bugly.proguard.y r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.x r2 = c     // Catch:{ all -> 0x0039 }
            android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0044
            android.content.ContentValues r2 = d(r7)     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0044
            java.lang.String r3 = "t_pf"
            java.lang.String r4 = "_id"
            long r2 = r1.replace(r3, r4, r2)     // Catch:{ all -> 0x0039 }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x003b
            java.lang.String r4 = "[Database] insert %s success."
            java.lang.String r5 = "t_pf"
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0039 }
            com.tencent.bugly.proguard.al.c(r4, r5)     // Catch:{ all -> 0x0039 }
            r7.f9602a = r2     // Catch:{ all -> 0x0039 }
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x0036
            r1.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0036
        L_0x0034:
            r7 = move-exception
            goto L_0x0070
        L_0x0036:
            monitor-exit(r6)
            r6 = 1
            return r6
        L_0x0039:
            r7 = move-exception
            goto L_0x004f
        L_0x003b:
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x0042
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x0042:
            monitor-exit(r6)
            return r0
        L_0x0044:
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x004d
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x004d:
            monitor-exit(r6)
            return r0
        L_0x004f:
            boolean r2 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x005b
            r7.printStackTrace()     // Catch:{ all -> 0x0059 }
            goto L_0x005b
        L_0x0059:
            r7 = move-exception
            goto L_0x0066
        L_0x005b:
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x0064
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x0064:
            monitor-exit(r6)
            return r0
        L_0x0066:
            boolean r0 = f9599a     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x006f
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x006f:
            throw r7     // Catch:{ all -> 0x0034 }
        L_0x0070:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.b(com.tencent.bugly.proguard.y):boolean");
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = yVar.f9602a;
            if (j > 0) {
                contentValues.put("_id", Long.valueOf(j));
            }
            contentValues.put("_tp", Integer.valueOf(yVar.b));
            contentValues.put("_pc", yVar.c);
            contentValues.put("_th", yVar.d);
            contentValues.put("_tm", Long.valueOf(yVar.e));
            byte[] bArr = yVar.g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(y yVar) {
        if (yVar != null && !ap.b(yVar.f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j = yVar.f9602a;
                if (j > 0) {
                    contentValues.put("_id", Long.valueOf(j));
                }
                contentValues.put("_tp", yVar.f);
                contentValues.put("_tm", Long.valueOf(yVar.e));
                byte[] bArr = yVar.g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized w a(Context context, List<o> list) {
        w wVar;
        synchronized (w.class) {
            try {
                if (b == null) {
                    b = new w(context, list);
                }
                wVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            wVar = b;
        }
        return wVar;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a0, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a8, code lost:
        if (r1 != null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00aa, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bb, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c6, code lost:
        if (r1 != null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cb, code lost:
        if (r2 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d6, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d9, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00db, code lost:
        throw r12;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x0025, B:52:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7 A[Catch:{ all -> 0x00bb, all -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bf A[SYNTHETIC, Splitter:B:58:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.List<com.tencent.bugly.proguard.y> c(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            com.tencent.bugly.proguard.x r1 = c     // Catch:{ all -> 0x00ae }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x00a4
            java.lang.String r2 = "_id = "
            java.lang.String r3 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x00a1 }
            java.lang.String r10 = r2.concat(r3)     // Catch:{ all -> 0x00a1 }
            java.lang.String r3 = "t_pf"
            r8 = 0
            r9 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r2 = r1
            r5 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00a1 }
            if (r2 != 0) goto L_0x0035
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            r12 = move-exception
            goto L_0x00da
        L_0x002c:
            boolean r12 = f9599a     // Catch:{ all -> 0x0029 }
            if (r12 == 0) goto L_0x0033
            r1.close()     // Catch:{ all -> 0x0029 }
        L_0x0033:
            monitor-exit(r11)
            return r0
        L_0x0035:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r3.<init>()     // Catch:{ all -> 0x004f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x004f }
            r4.<init>()     // Catch:{ all -> 0x004f }
        L_0x003f:
            boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x004f }
            if (r5 == 0) goto L_0x006d
            com.tencent.bugly.proguard.y r5 = b((android.database.Cursor) r2)     // Catch:{ all -> 0x004f }
            if (r5 == 0) goto L_0x0051
            r4.add(r5)     // Catch:{ all -> 0x004f }
            goto L_0x003f
        L_0x004f:
            r12 = move-exception
            goto L_0x00b1
        L_0x0051:
            java.lang.String r5 = "_tp"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = " or _tp = "
            r3.append(r6)     // Catch:{ all -> 0x0064 }
            r3.append(r5)     // Catch:{ all -> 0x0064 }
            goto L_0x003f
        L_0x0064:
            java.lang.String r5 = "[Database] unknown id."
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x004f }
            com.tencent.bugly.proguard.al.d(r5, r6)     // Catch:{ all -> 0x004f }
            goto L_0x003f
        L_0x006d:
            int r5 = r3.length()     // Catch:{ all -> 0x004f }
            if (r5 <= 0) goto L_0x0095
            java.lang.String r5 = " and _id = "
            r3.append(r5)     // Catch:{ all -> 0x004f }
            r3.append(r12)     // Catch:{ all -> 0x004f }
            r12 = 4
            java.lang.String r12 = r10.substring(r12)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "t_pf"
            int r12 = r1.delete(r3, r12, r0)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "[Database] deleted %s illegal data %d."
            java.lang.String r5 = "t_pf"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x004f }
            java.lang.Object[] r12 = new java.lang.Object[]{r5, r12}     // Catch:{ all -> 0x004f }
            com.tencent.bugly.proguard.al.d(r3, r12)     // Catch:{ all -> 0x004f }
        L_0x0095:
            r2.close()     // Catch:{ all -> 0x0029 }
            boolean r12 = f9599a     // Catch:{ all -> 0x0029 }
            if (r12 == 0) goto L_0x009f
            r1.close()     // Catch:{ all -> 0x0029 }
        L_0x009f:
            monitor-exit(r11)
            return r4
        L_0x00a1:
            r12 = move-exception
            r2 = r0
            goto L_0x00b1
        L_0x00a4:
            boolean r12 = f9599a     // Catch:{ all -> 0x0029 }
            if (r12 == 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c9
        L_0x00aa:
            r1.close()     // Catch:{ all -> 0x0029 }
            goto L_0x00c9
        L_0x00ae:
            r12 = move-exception
            r1 = r0
            r2 = r1
        L_0x00b1:
            boolean r3 = com.tencent.bugly.proguard.al.a(r12)     // Catch:{ all -> 0x00bb }
            if (r3 != 0) goto L_0x00bd
            r12.printStackTrace()     // Catch:{ all -> 0x00bb }
            goto L_0x00bd
        L_0x00bb:
            r12 = move-exception
            goto L_0x00cb
        L_0x00bd:
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ all -> 0x0029 }
        L_0x00c2:
            boolean r12 = f9599a     // Catch:{ all -> 0x0029 }
            if (r12 == 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c9
            goto L_0x00aa
        L_0x00c9:
            monitor-exit(r11)
            return r0
        L_0x00cb:
            if (r2 == 0) goto L_0x00d0
            r2.close()     // Catch:{ all -> 0x0029 }
        L_0x00d0:
            boolean r0 = f9599a     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d9
            r1.close()     // Catch:{ all -> 0x0029 }
        L_0x00d9:
            throw r12     // Catch:{ all -> 0x0029 }
        L_0x00da:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.c(int):java.util.List");
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, (String[]) null, (String) null, (String) null, str3, str4, (v) null);
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r9 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        if (r9 != null) goto L_0x0036;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0030=Splitter:B:13:0x0030, B:24:0x0048=Splitter:B:24:0x0048} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long a(java.lang.String r7, android.content.ContentValues r8, com.tencent.bugly.proguard.v r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = -1
            r9 = 0
            com.tencent.bugly.proguard.x r2 = c     // Catch:{ all -> 0x0024 }
            android.database.sqlite.SQLiteDatabase r9 = r2.getWritableDatabase()     // Catch:{ all -> 0x0024 }
            if (r9 == 0) goto L_0x0030
            if (r8 == 0) goto L_0x0030
            java.lang.String r2 = "_id"
            long r2 = r9.replace(r7, r2, r8)     // Catch:{ all -> 0x0024 }
            r4 = 0
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x0026
            java.lang.String r8 = "[Database] insert %s success."
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch:{ all -> 0x0024 }
            com.tencent.bugly.proguard.al.c(r8, r7)     // Catch:{ all -> 0x0024 }
            goto L_0x002f
        L_0x0024:
            r7 = move-exception
            goto L_0x003c
        L_0x0026:
            java.lang.String r8 = "[Database] replace %s error."
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch:{ all -> 0x0024 }
            com.tencent.bugly.proguard.al.d(r8, r7)     // Catch:{ all -> 0x0024 }
        L_0x002f:
            r0 = r2
        L_0x0030:
            boolean r7 = f9599a     // Catch:{ all -> 0x003a }
            if (r7 == 0) goto L_0x004f
            if (r9 == 0) goto L_0x004f
        L_0x0036:
            r9.close()     // Catch:{ all -> 0x003a }
            goto L_0x004f
        L_0x003a:
            r7 = move-exception
            goto L_0x005b
        L_0x003c:
            boolean r8 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x0046 }
            if (r8 != 0) goto L_0x0048
            r7.printStackTrace()     // Catch:{ all -> 0x0046 }
            goto L_0x0048
        L_0x0046:
            r7 = move-exception
            goto L_0x0051
        L_0x0048:
            boolean r7 = f9599a     // Catch:{ all -> 0x003a }
            if (r7 == 0) goto L_0x004f
            if (r9 == 0) goto L_0x004f
            goto L_0x0036
        L_0x004f:
            monitor-exit(r6)
            return r0
        L_0x0051:
            boolean r8 = f9599a     // Catch:{ all -> 0x003a }
            if (r8 == 0) goto L_0x005a
            if (r9 == 0) goto L_0x005a
            r9.close()     // Catch:{ all -> 0x003a }
        L_0x005a:
            throw r7     // Catch:{ all -> 0x003a }
        L_0x005b:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.lang.String, android.content.ContentValues, com.tencent.bugly.proguard.v):long");
    }

    public final synchronized void b(int i) {
        String str;
        SQLiteDatabase writableDatabase = c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = ".concat(String.valueOf(i));
                } catch (Throwable th) {
                    if (f9599a) {
                        writableDatabase.close();
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, (String[]) null)));
            if (f9599a) {
                writableDatabase.close();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.database.Cursor a(boolean r13, java.lang.String r14, java.lang.String[] r15, java.lang.String r16, java.lang.String[] r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.tencent.bugly.proguard.v r22) {
        /*
            r12 = this;
            monitor-enter(r12)
            r1 = 0
            com.tencent.bugly.proguard.x r0 = c     // Catch:{ all -> 0x001e }
            android.database.sqlite.SQLiteDatabase r2 = r0.getWritableDatabase()     // Catch:{ all -> 0x001e }
            if (r2 == 0) goto L_0x002b
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x001e }
            goto L_0x002b
        L_0x001e:
            r0 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x0029 }
            if (r2 != 0) goto L_0x002b
            r0.printStackTrace()     // Catch:{ all -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            r0 = move-exception
            goto L_0x002d
        L_0x002b:
            monitor-exit(r12)
            return r1
        L_0x002d:
            throw r0     // Catch:{ all -> 0x002e }
        L_0x002e:
            r0 = move-exception
            r1 = r0
            monitor-exit(r12)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(boolean, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.bugly.proguard.v):android.database.Cursor");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r0 != null) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        if (r0 != null) goto L_0x0018;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:7:0x0012=Splitter:B:7:0x0012, B:18:0x002a=Splitter:B:18:0x002a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a(java.lang.String r3, java.lang.String r4, java.lang.String[] r5, com.tencent.bugly.proguard.v r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            r6 = 0
            r0 = 0
            com.tencent.bugly.proguard.x r1 = c     // Catch:{ all -> 0x0010 }
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0012
            int r6 = r0.delete(r3, r4, r5)     // Catch:{ all -> 0x0010 }
            goto L_0x0012
        L_0x0010:
            r3 = move-exception
            goto L_0x001e
        L_0x0012:
            boolean r3 = f9599a     // Catch:{ all -> 0x001c }
            if (r3 == 0) goto L_0x0031
            if (r0 == 0) goto L_0x0031
        L_0x0018:
            r0.close()     // Catch:{ all -> 0x001c }
            goto L_0x0031
        L_0x001c:
            r3 = move-exception
            goto L_0x003d
        L_0x001e:
            boolean r4 = com.tencent.bugly.proguard.al.a(r3)     // Catch:{ all -> 0x0028 }
            if (r4 != 0) goto L_0x002a
            r3.printStackTrace()     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r3 = move-exception
            goto L_0x0033
        L_0x002a:
            boolean r3 = f9599a     // Catch:{ all -> 0x001c }
            if (r3 == 0) goto L_0x0031
            if (r0 == 0) goto L_0x0031
            goto L_0x0018
        L_0x0031:
            monitor-exit(r2)
            return r6
        L_0x0033:
            boolean r4 = f9599a     // Catch:{ all -> 0x001c }
            if (r4 == 0) goto L_0x003c
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ all -> 0x001c }
        L_0x003c:
            throw r3     // Catch:{ all -> 0x001c }
        L_0x003d:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.lang.String, java.lang.String, java.lang.String[], com.tencent.bugly.proguard.v):int");
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f9602a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f = cursor.getString(cursor.getColumnIndex("_tp"));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean a(int i, String str, byte[] bArr, boolean z) {
        if (z) {
            return a(i, str, bArr, (v) null);
        }
        a aVar = new a();
        aVar.a(i, str, bArr);
        ak.a().a(aVar);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean a(int i, String str, byte[] bArr, v vVar) {
        try {
            y yVar = new y();
            yVar.f9602a = (long) i;
            yVar.f = str;
            yVar.e = System.currentTimeMillis();
            yVar.g = bArr;
            return b(yVar);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, byte[]> a(int r2, com.tencent.bugly.proguard.v r3) {
        /*
            r1 = this;
            r3 = 0
            java.util.List r1 = r1.c((int) r2)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0035
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0026 }
        L_0x0010:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0026 }
            if (r3 == 0) goto L_0x0029
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0026 }
            com.tencent.bugly.proguard.y r3 = (com.tencent.bugly.proguard.y) r3     // Catch:{ all -> 0x0026 }
            byte[] r0 = r3.g     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0010
            java.lang.String r3 = r3.f     // Catch:{ all -> 0x0026 }
            r2.put(r3, r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0010
        L_0x0026:
            r1 = move-exception
            r3 = r2
            goto L_0x002c
        L_0x0029:
            r3 = r2
            goto L_0x0035
        L_0x002b:
            r1 = move-exception
        L_0x002c:
            boolean r2 = com.tencent.bugly.proguard.al.a(r1)
            if (r2 != 0) goto L_0x0035
            r1.printStackTrace()
        L_0x0035:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int, com.tencent.bugly.proguard.v):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0044=Splitter:B:24:0x0044, B:36:0x005b=Splitter:B:36:0x005b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(com.tencent.bugly.proguard.y r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.x r2 = c     // Catch:{ all -> 0x0039 }
            android.database.sqlite.SQLiteDatabase r1 = r2.getWritableDatabase()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0044
            android.content.ContentValues r2 = c((com.tencent.bugly.proguard.y) r7)     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0044
            java.lang.String r3 = "t_lr"
            java.lang.String r4 = "_id"
            long r2 = r1.replace(r3, r4, r2)     // Catch:{ all -> 0x0039 }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x003b
            java.lang.String r4 = "[Database] insert %s success."
            java.lang.String r5 = "t_lr"
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0039 }
            com.tencent.bugly.proguard.al.c(r4, r5)     // Catch:{ all -> 0x0039 }
            r7.f9602a = r2     // Catch:{ all -> 0x0039 }
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x0036
            r1.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0036
        L_0x0034:
            r7 = move-exception
            goto L_0x0070
        L_0x0036:
            monitor-exit(r6)
            r6 = 1
            return r6
        L_0x0039:
            r7 = move-exception
            goto L_0x004f
        L_0x003b:
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x0042
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x0042:
            monitor-exit(r6)
            return r0
        L_0x0044:
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x004d
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x004d:
            monitor-exit(r6)
            return r0
        L_0x004f:
            boolean r2 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x005b
            r7.printStackTrace()     // Catch:{ all -> 0x0059 }
            goto L_0x005b
        L_0x0059:
            r7 = move-exception
            goto L_0x0066
        L_0x005b:
            boolean r7 = f9599a     // Catch:{ all -> 0x0034 }
            if (r7 == 0) goto L_0x0064
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x0064:
            monitor-exit(r6)
            return r0
        L_0x0066:
            boolean r0 = f9599a     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x006f
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ all -> 0x0034 }
        L_0x006f:
            throw r7     // Catch:{ all -> 0x0034 }
        L_0x0070:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(com.tencent.bugly.proguard.y):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a7, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ae A[Catch:{ all -> 0x00b2, all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b6 A[SYNTHETIC, Splitter:B:55:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bd A[Catch:{ all -> 0x00b2, all -> 0x0031 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.tencent.bugly.proguard.y> a(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.tencent.bugly.proguard.x r0 = c     // Catch:{ all -> 0x0031 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0031 }
            r9 = 0
            if (r0 == 0) goto L_0x00ce
            if (r12 < 0) goto L_0x001c
            java.lang.String r1 = "_tp = "
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0018 }
            java.lang.String r12 = r1.concat(r12)     // Catch:{ all -> 0x0018 }
            r4 = r12
            goto L_0x001d
        L_0x0018:
            r12 = move-exception
            r1 = r9
            goto L_0x00a8
        L_0x001c:
            r4 = r9
        L_0x001d:
            java.lang.String r2 = "t_lr"
            r7 = 0
            r8 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0018 }
            if (r12 != 0) goto L_0x003d
            if (r12 == 0) goto L_0x0034
            r12.close()     // Catch:{ all -> 0x0031 }
            goto L_0x0034
        L_0x0031:
            r12 = move-exception
            goto L_0x00d0
        L_0x0034:
            boolean r12 = f9599a     // Catch:{ all -> 0x0031 }
            if (r12 == 0) goto L_0x003b
            r0.close()     // Catch:{ all -> 0x0031 }
        L_0x003b:
            monitor-exit(r11)
            return r9
        L_0x003d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r1.<init>()     // Catch:{ all -> 0x0057 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0057 }
            r2.<init>()     // Catch:{ all -> 0x0057 }
        L_0x0047:
            boolean r3 = r12.moveToNext()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0078
            com.tencent.bugly.proguard.y r3 = a((android.database.Cursor) r12)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x005c
            r2.add(r3)     // Catch:{ all -> 0x0057 }
            goto L_0x0047
        L_0x0057:
            r1 = move-exception
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x00a8
        L_0x005c:
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ all -> 0x006f }
            long r3 = r12.getLong(r3)     // Catch:{ all -> 0x006f }
            java.lang.String r5 = " or _id = "
            r1.append(r5)     // Catch:{ all -> 0x006f }
            r1.append(r3)     // Catch:{ all -> 0x006f }
            goto L_0x0047
        L_0x006f:
            java.lang.String r3 = "[Database] unknown id."
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0057 }
            com.tencent.bugly.proguard.al.d(r3, r4)     // Catch:{ all -> 0x0057 }
            goto L_0x0047
        L_0x0078:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0057 }
            int r3 = r1.length()     // Catch:{ all -> 0x0057 }
            if (r3 <= 0) goto L_0x009c
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "t_lr"
            int r1 = r0.delete(r3, r1, r9)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "[Database] deleted %s illegal data %d"
            java.lang.String r4 = "t_lr"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0057 }
            java.lang.Object[] r1 = new java.lang.Object[]{r4, r1}     // Catch:{ all -> 0x0057 }
            com.tencent.bugly.proguard.al.d(r3, r1)     // Catch:{ all -> 0x0057 }
        L_0x009c:
            r12.close()     // Catch:{ all -> 0x0031 }
            boolean r12 = f9599a     // Catch:{ all -> 0x0031 }
            if (r12 == 0) goto L_0x00a6
            r0.close()     // Catch:{ all -> 0x0031 }
        L_0x00a6:
            monitor-exit(r11)
            return r2
        L_0x00a8:
            boolean r2 = com.tencent.bugly.proguard.al.a(r12)     // Catch:{ all -> 0x00b2 }
            if (r2 != 0) goto L_0x00b4
            r12.printStackTrace()     // Catch:{ all -> 0x00b2 }
            goto L_0x00b4
        L_0x00b2:
            r12 = move-exception
            goto L_0x00c1
        L_0x00b4:
            if (r1 == 0) goto L_0x00b9
            r1.close()     // Catch:{ all -> 0x0031 }
        L_0x00b9:
            boolean r12 = f9599a     // Catch:{ all -> 0x0031 }
            if (r12 == 0) goto L_0x00ce
            r0.close()     // Catch:{ all -> 0x0031 }
            goto L_0x00ce
        L_0x00c1:
            if (r1 == 0) goto L_0x00c6
            r1.close()     // Catch:{ all -> 0x0031 }
        L_0x00c6:
            boolean r1 = f9599a     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x00cd
            r0.close()     // Catch:{ all -> 0x0031 }
        L_0x00cd:
            throw r12     // Catch:{ all -> 0x0031 }
        L_0x00ce:
            monitor-exit(r11)
            return r9
        L_0x00d0:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0086, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x008a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.List<com.tencent.bugly.proguard.y> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x0089
            int r0 = r5.size()     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x000b
            goto L_0x0089
        L_0x000b:
            com.tencent.bugly.proguard.x r0 = c     // Catch:{ all -> 0x0033 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0085
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r1.<init>()     // Catch:{ all -> 0x0033 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0033 }
        L_0x001c:
            boolean r2 = r5.hasNext()     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0035
            java.lang.Object r2 = r5.next()     // Catch:{ all -> 0x0033 }
            com.tencent.bugly.proguard.y r2 = (com.tencent.bugly.proguard.y) r2     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = " or _id = "
            r1.append(r3)     // Catch:{ all -> 0x0033 }
            long r2 = r2.f9602a     // Catch:{ all -> 0x0033 }
            r1.append(r2)     // Catch:{ all -> 0x0033 }
            goto L_0x001c
        L_0x0033:
            r5 = move-exception
            goto L_0x0087
        L_0x0035:
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0033 }
            int r2 = r5.length()     // Catch:{ all -> 0x0033 }
            if (r2 <= 0) goto L_0x0044
            r2 = 4
            java.lang.String r5 = r5.substring(r2)     // Catch:{ all -> 0x0033 }
        L_0x0044:
            r2 = 0
            r1.setLength(r2)     // Catch:{ all -> 0x0033 }
            java.lang.String r1 = "t_lr"
            r2 = 0
            int r5 = r0.delete(r1, r5, r2)     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = "[Database] deleted %s data %d"
            java.lang.String r2 = "t_lr"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0067 }
            java.lang.Object[] r5 = new java.lang.Object[]{r2, r5}     // Catch:{ all -> 0x0067 }
            com.tencent.bugly.proguard.al.c(r1, r5)     // Catch:{ all -> 0x0067 }
            boolean r5 = f9599a     // Catch:{ all -> 0x0033 }
            if (r5 == 0) goto L_0x0085
            r0.close()     // Catch:{ all -> 0x0033 }
            monitor-exit(r4)
            return
        L_0x0067:
            r5 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r5)     // Catch:{ all -> 0x0072 }
            if (r1 != 0) goto L_0x0074
            r5.printStackTrace()     // Catch:{ all -> 0x0072 }
            goto L_0x0074
        L_0x0072:
            r5 = move-exception
            goto L_0x007d
        L_0x0074:
            boolean r5 = f9599a     // Catch:{ all -> 0x0033 }
            if (r5 == 0) goto L_0x0085
            r0.close()     // Catch:{ all -> 0x0033 }
            monitor-exit(r4)
            return
        L_0x007d:
            boolean r1 = f9599a     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0084
            r0.close()     // Catch:{ all -> 0x0033 }
        L_0x0084:
            throw r5     // Catch:{ all -> 0x0033 }
        L_0x0085:
            monitor-exit(r4)
            return
        L_0x0087:
            monitor-exit(r4)
            throw r5
        L_0x0089:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(java.util.List):void");
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f9602a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.b = cursor.getInt(cursor.getColumnIndex("_tp"));
            yVar.c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[Catch:{ all -> 0x0069 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0052=Splitter:B:15:0x0052, B:27:0x006b=Splitter:B:27:0x006b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(int r5, java.lang.String r6, com.tencent.bugly.proguard.v r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r7 = 0
            r0 = 0
            com.tencent.bugly.proguard.x r1 = c     // Catch:{ all -> 0x005e }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0052
            boolean r2 = com.tencent.bugly.proguard.ap.b((java.lang.String) r6)     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x001f
            java.lang.String r6 = "_id = "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = r6.concat(r5)     // Catch:{ all -> 0x001c }
            goto L_0x003a
        L_0x001c:
            r5 = move-exception
            r0 = r1
            goto L_0x005f
        L_0x001f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            java.lang.String r3 = "_id = "
            r2.<init>(r3)     // Catch:{ all -> 0x001c }
            r2.append(r5)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = " and _tp = \""
            r2.append(r5)     // Catch:{ all -> 0x001c }
            r2.append(r6)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "\""
            r2.append(r5)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x001c }
        L_0x003a:
            java.lang.String r6 = "t_pf"
            int r5 = r1.delete(r6, r5, r0)     // Catch:{ all -> 0x001c }
            java.lang.String r6 = "[Database] deleted %s data %d"
            java.lang.String r0 = "t_pf"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x001c }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r2}     // Catch:{ all -> 0x001c }
            com.tencent.bugly.proguard.al.c(r6, r0)     // Catch:{ all -> 0x001c }
            if (r5 <= 0) goto L_0x0052
            r7 = 1
        L_0x0052:
            boolean r5 = f9599a     // Catch:{ all -> 0x005c }
            if (r5 == 0) goto L_0x0074
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ all -> 0x005c }
            goto L_0x0074
        L_0x005c:
            r5 = move-exception
            goto L_0x0080
        L_0x005e:
            r5 = move-exception
        L_0x005f:
            boolean r6 = com.tencent.bugly.proguard.al.a(r5)     // Catch:{ all -> 0x0069 }
            if (r6 != 0) goto L_0x006b
            r5.printStackTrace()     // Catch:{ all -> 0x0069 }
            goto L_0x006b
        L_0x0069:
            r5 = move-exception
            goto L_0x0076
        L_0x006b:
            boolean r5 = f9599a     // Catch:{ all -> 0x005c }
            if (r5 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0074
            r0.close()     // Catch:{ all -> 0x005c }
        L_0x0074:
            monitor-exit(r4)
            return r7
        L_0x0076:
            boolean r6 = f9599a     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x007f
            r0.close()     // Catch:{ all -> 0x005c }
        L_0x007f:
            throw r5     // Catch:{ all -> 0x005c }
        L_0x0080:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int, java.lang.String, com.tencent.bugly.proguard.v):boolean");
    }
}
