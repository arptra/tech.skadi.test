package com.tekartik.sqflite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.actions.SearchIntents;
import com.meizu.common.widget.MzContactsContract;
import com.tekartik.sqflite.operation.BatchOperation;
import com.tekartik.sqflite.operation.MethodCallOperation;
import com.tekartik.sqflite.operation.Operation;
import com.tekartik.sqflite.operation.QueuedOperation;
import com.tekartik.sqflite.operation.SqlErrorInfo;
import com.upuphone.runasone.uupcast.CaptureType;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {
    public static Boolean n;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10020a;
    public final String b;
    public final int c;
    public final int d;
    public final Context e;
    public final List f = new ArrayList();
    public final Map g = new HashMap();
    public DatabaseWorkerPool h;
    public SQLiteDatabase i;
    public int j = 0;
    public int k = 0;
    public Integer l;
    public int m = 0;

    public Database(Context context, String str, int i2, boolean z, int i3) {
        this.e = context;
        this.b = str;
        this.f10020a = z;
        this.c = i2;
        this.d = i3;
    }

    public static boolean i(Context context, String str, boolean z) {
        try {
            String packageName = context.getPackageName();
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128)) : y(context, packageName, 128)).metaData.getBoolean(str, z);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean j(Context context) {
        return i(context, "com.tekartik.sqflite.wal_enabled", false);
    }

    public static void o(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public static boolean x(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static ApplicationInfo y(Context context, String str, int i2) {
        return context.getPackageManager().getApplicationInfo(str, i2);
    }

    public String A() {
        return "[" + B() + "] ";
    }

    public String B() {
        Thread currentThread = Thread.currentThread();
        return this.c + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    public SQLiteDatabase C() {
        return this.i;
    }

    public void D(Exception exc, Operation operation) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            operation.error("sqlite_error", "open_failed " + this.b, (Object) null);
        } else if (exc instanceof SQLException) {
            operation.error("sqlite_error", exc.getMessage(), SqlErrorInfo.a(operation));
        } else {
            operation.error("sqlite_error", exc.getMessage(), SqlErrorInfo.a(operation));
        }
    }

    public void E(Operation operation) {
        S(operation, new d(this, operation));
    }

    public synchronized boolean F() {
        return this.j > 0;
    }

    public final /* synthetic */ void H(Operation operation) {
        Boolean e2 = operation.e();
        boolean z = Boolean.TRUE.equals(e2) && operation.d();
        if (z) {
            int i2 = this.k + 1;
            this.k = i2;
            this.l = Integer.valueOf(i2);
        }
        if (!w(operation)) {
            if (z) {
                this.l = null;
            }
        } else if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", this.l);
            operation.success(hashMap);
        } else {
            if (Boolean.FALSE.equals(e2)) {
                this.l = null;
            }
            operation.success((Object) null);
        }
    }

    public void M() {
        if (n == null) {
            Boolean valueOf = Boolean.valueOf(j(this.e));
            n = valueOf;
            if (valueOf.booleanValue() && LogLevel.c(this.d)) {
                Log.d("Sqflite", A() + "[sqflite] WAL enabled");
            }
        }
        this.i = SQLiteDatabase.openDatabase(this.b, (SQLiteDatabase.CursorFactory) null, n.booleanValue() ? 805306368 : CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
    }

    public void N() {
        this.i = SQLiteDatabase.openDatabase(this.b, (SQLiteDatabase.CursorFactory) null, 1, new DatabaseErrorHandler() {
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            }
        });
    }

    public void O(Operation operation) {
        S(operation, new b(this, operation));
    }

    public void P(Operation operation) {
        S(operation, new a(this, operation));
    }

    public final void Q() {
        while (!this.f.isEmpty() && this.l == null) {
            ((QueuedOperation) this.f.get(0)).a();
            this.f.remove(0);
        }
    }

    public void R(Operation operation) {
        S(operation, new c(this, operation));
    }

    public final void S(Operation operation, Runnable runnable) {
        Integer g2 = operation.g();
        Integer num = this.l;
        if (num == null) {
            runnable.run();
        } else if (g2 == null || (!g2.equals(num) && g2.intValue() != -1)) {
            this.f.add(new QueuedOperation(operation, runnable));
        } else {
            runnable.run();
            if (this.l == null && !this.f.isEmpty()) {
                this.h.d(this, new g(this));
            }
        }
    }

    public void h(MethodCall methodCall, MethodChannel.Result result) {
        MethodCallOperation methodCallOperation = new MethodCallOperation(methodCall, result);
        boolean f2 = methodCallOperation.f();
        boolean i2 = methodCallOperation.i();
        ArrayList arrayList = new ArrayList();
        for (Map batchOperation : (List) methodCallOperation.a("operations")) {
            BatchOperation batchOperation2 = new BatchOperation(batchOperation, f2);
            String method = batchOperation2.getMethod();
            method.hashCode();
            char c2 = 65535;
            switch (method.hashCode()) {
                case -1319569547:
                    if (method.equals("execute")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1183792455:
                    if (method.equals("insert")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -838846263:
                    if (method.equals("update")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 107944136:
                    if (method.equals(SearchIntents.EXTRA_QUERY)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (p(batchOperation2)) {
                        batchOperation2.q(arrayList);
                        break;
                    } else if (i2) {
                        batchOperation2.p(arrayList);
                        break;
                    } else {
                        batchOperation2.o(result);
                        return;
                    }
                case 1:
                    if (I(batchOperation2)) {
                        batchOperation2.q(arrayList);
                        break;
                    } else if (i2) {
                        batchOperation2.p(arrayList);
                        break;
                    } else {
                        batchOperation2.o(result);
                        return;
                    }
                case 2:
                    if (L(batchOperation2)) {
                        batchOperation2.q(arrayList);
                        break;
                    } else if (i2) {
                        batchOperation2.p(arrayList);
                        break;
                    } else {
                        batchOperation2.o(result);
                        return;
                    }
                case 3:
                    if (J(batchOperation2)) {
                        batchOperation2.q(arrayList);
                        break;
                    } else if (i2) {
                        batchOperation2.p(arrayList);
                        break;
                    } else {
                        batchOperation2.o(result);
                        return;
                    }
                default:
                    result.error("bad_param", "Batch method '" + method + "' not supported", (Object) null);
                    return;
            }
        }
        if (f2) {
            result.success((Object) null);
        } else {
            result.success(arrayList);
        }
    }

    public void k() {
        if (!this.g.isEmpty() && LogLevel.b(this.d)) {
            Log.d("Sqflite", A() + this.g.size() + " cursor(s) are left opened");
        }
        this.i.close();
    }

    public final void l(int i2) {
        SqfliteCursor sqfliteCursor = (SqfliteCursor) this.g.get(Integer.valueOf(i2));
        if (sqfliteCursor != null) {
            m(sqfliteCursor);
        }
    }

    public final void m(SqfliteCursor sqfliteCursor) {
        try {
            int i2 = sqfliteCursor.f10027a;
            if (LogLevel.c(this.d)) {
                Log.d("Sqflite", A() + "closing cursor " + i2);
            }
            this.g.remove(Integer.valueOf(i2));
            sqfliteCursor.c.close();
        } catch (Exception unused) {
        }
    }

    public final Map n(Cursor cursor, Integer num) {
        HashMap hashMap = null;
        int i2 = 0;
        ArrayList arrayList = null;
        while (cursor.moveToNext()) {
            if (hashMap == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap2 = new HashMap();
                i2 = cursor.getColumnCount();
                hashMap2.put("columns", Arrays.asList(cursor.getColumnNames()));
                hashMap2.put("rows", arrayList2);
                HashMap hashMap3 = hashMap2;
                arrayList = arrayList2;
                hashMap = hashMap3;
            }
            arrayList.add(Utils.a(cursor, i2));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return hashMap == null ? new HashMap() : hashMap;
    }

    public final boolean p(Operation operation) {
        if (!w(operation)) {
            return false;
        }
        operation.success((Object) null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d1  */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean I(com.tekartik.sqflite.operation.Operation r10) {
        /*
            r9 = this;
            boolean r0 = r9.w(r10)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r10.f()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0014
            r10.success(r2)
            return r3
        L_0x0014:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r9.C()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x009f
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0064 }
            if (r5 <= 0) goto L_0x009f
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0064 }
            if (r5 == 0) goto L_0x009f
            int r5 = r0.getInt(r1)     // Catch:{ Exception -> 0x0064 }
            if (r5 != 0) goto L_0x006d
            int r5 = r9.d     // Catch:{ Exception -> 0x0064 }
            boolean r5 = com.tekartik.sqflite.LogLevel.b(r5)     // Catch:{ Exception -> 0x0064 }
            if (r5 == 0) goto L_0x0066
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064 }
            r5.<init>()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = r9.A()     // Catch:{ Exception -> 0x0064 }
            r5.append(r6)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = "no changes (id was "
            r5.append(r6)     // Catch:{ Exception -> 0x0064 }
            long r6 = r0.getLong(r3)     // Catch:{ Exception -> 0x0064 }
            r5.append(r6)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0064 }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0066
        L_0x0061:
            r9 = move-exception
            r2 = r0
            goto L_0x00cf
        L_0x0064:
            r2 = move-exception
            goto L_0x00c6
        L_0x0066:
            r10.success(r2)     // Catch:{ Exception -> 0x0064 }
            r0.close()
            return r3
        L_0x006d:
            long r5 = r0.getLong(r3)     // Catch:{ Exception -> 0x0064 }
            int r2 = r9.d     // Catch:{ Exception -> 0x0064 }
            boolean r2 = com.tekartik.sqflite.LogLevel.b(r2)     // Catch:{ Exception -> 0x0064 }
            if (r2 == 0) goto L_0x0094
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064 }
            r2.<init>()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r7 = r9.A()     // Catch:{ Exception -> 0x0064 }
            r2.append(r7)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r7 = "inserted "
            r2.append(r7)     // Catch:{ Exception -> 0x0064 }
            r2.append(r5)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0064 }
            android.util.Log.d(r4, r2)     // Catch:{ Exception -> 0x0064 }
        L_0x0094:
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0064 }
            r10.success(r2)     // Catch:{ Exception -> 0x0064 }
            r0.close()
            return r3
        L_0x009f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064 }
            r5.<init>()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = r9.A()     // Catch:{ Exception -> 0x0064 }
            r5.append(r6)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = "fail to read changes for Insert"
            r5.append(r6)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0064 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0064 }
            r10.success(r2)     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x00bf
            r0.close()
        L_0x00bf:
            return r3
        L_0x00c0:
            r9 = move-exception
            goto L_0x00cf
        L_0x00c2:
            r0 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        L_0x00c6:
            r9.D(r2, r10)     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x00ce
            r0.close()
        L_0x00ce:
            return r1
        L_0x00cf:
            if (r2 == 0) goto L_0x00d4
            r2.close()
        L_0x00d4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.I(com.tekartik.sqflite.operation.Operation):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094 A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean J(com.tekartik.sqflite.operation.Operation r9) {
        /*
            r8 = this;
            java.lang.String r0 = "cursorPageSize"
            java.lang.Object r0 = r9.a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            com.tekartik.sqflite.SqlCommand r1 = r9.c()
            int r2 = r8.d
            boolean r2 = com.tekartik.sqflite.LogLevel.b(r2)
            if (r2 == 0) goto L_0x002c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r8.A()
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Sqflite"
            android.util.Log.d(r3, r2)
        L_0x002c:
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r8.z()     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            com.tekartik.sqflite.f r4 = new com.tekartik.sqflite.f     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            r4.<init>(r1)     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            java.lang.String[] r5 = com.tekartik.sqflite.Constant.f10019a     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            android.database.Cursor r1 = r3.rawQueryWithFactory(r4, r1, r5, r2)     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            java.util.Map r3 = r8.n(r1, r0)     // Catch:{ Exception -> 0x007d }
            r4 = 1
            if (r0 == 0) goto L_0x007f
            boolean r5 = r1.isLast()     // Catch:{ Exception -> 0x007d }
            if (r5 != 0) goto L_0x007f
            boolean r5 = r1.isAfterLast()     // Catch:{ Exception -> 0x007d }
            if (r5 != 0) goto L_0x007f
            int r5 = r8.m     // Catch:{ Exception -> 0x007d }
            int r5 = r5 + r4
            r8.m = r5     // Catch:{ Exception -> 0x007d }
            java.lang.String r6 = "cursorId"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x007d }
            r3.put(r6, r7)     // Catch:{ Exception -> 0x007d }
            com.tekartik.sqflite.SqfliteCursor r6 = new com.tekartik.sqflite.SqfliteCursor     // Catch:{ Exception -> 0x007d }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x007d }
            r6.<init>(r5, r0, r1)     // Catch:{ Exception -> 0x007d }
            java.util.Map r0 = r8.g     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            r0.put(r2, r6)     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            r2 = r6
            goto L_0x007f
        L_0x0075:
            r8 = move-exception
            r2 = r6
            goto L_0x00a0
        L_0x0078:
            r0 = move-exception
            r2 = r6
            goto L_0x008f
        L_0x007b:
            r8 = move-exception
            goto L_0x00a0
        L_0x007d:
            r0 = move-exception
            goto L_0x008f
        L_0x007f:
            r9.success(r3)     // Catch:{ Exception -> 0x007d }
            if (r2 != 0) goto L_0x0089
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            return r4
        L_0x008a:
            r8 = move-exception
            r1 = r2
            goto L_0x00a0
        L_0x008d:
            r0 = move-exception
            r1 = r2
        L_0x008f:
            r8.D(r0, r9)     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0097
            r8.m(r2)     // Catch:{ all -> 0x007b }
        L_0x0097:
            if (r2 != 0) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            r8 = 0
            return r8
        L_0x00a0:
            if (r2 != 0) goto L_0x00a7
            if (r1 == 0) goto L_0x00a7
            r1.close()
        L_0x00a7:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.J(com.tekartik.sqflite.operation.Operation):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2 A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b6  */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean K(com.tekartik.sqflite.operation.Operation r10) {
        /*
            r9 = this;
            java.lang.String r0 = "cursorId"
            java.lang.Object r1 = r10.a(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r2 = r1.intValue()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            java.lang.String r4 = "cancel"
            java.lang.Object r4 = r10.a(r4)
            boolean r3 = r3.equals(r4)
            int r4 = r9.d
            boolean r4 = com.tekartik.sqflite.LogLevel.c(r4)
            if (r4 == 0) goto L_0x0047
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r9.A()
            r4.append(r5)
            java.lang.String r5 = "cursor "
            r4.append(r5)
            r4.append(r2)
            if (r3 == 0) goto L_0x0039
            java.lang.String r5 = " cancel"
            goto L_0x003b
        L_0x0039:
            java.lang.String r5 = " next"
        L_0x003b:
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "Sqflite"
            android.util.Log.d(r5, r4)
        L_0x0047:
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0052
            r9.l(r2)
            r10.success(r4)
            return r5
        L_0x0052:
            java.util.Map r3 = r9.g
            java.lang.Object r3 = r3.get(r1)
            com.tekartik.sqflite.SqfliteCursor r3 = (com.tekartik.sqflite.SqfliteCursor) r3
            r6 = 0
            if (r3 == 0) goto L_0x0091
            android.database.Cursor r2 = r3.c     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            int r7 = r3.b     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.util.Map r7 = r9.n(r2, r7)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            boolean r8 = r2.isLast()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r8 != 0) goto L_0x007c
            boolean r2 = r2.isAfterLast()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r2 != 0) goto L_0x007c
            r2 = r5
            goto L_0x007d
        L_0x0077:
            r10 = move-exception
            goto L_0x00bf
        L_0x0079:
            r0 = move-exception
            r2 = r6
            goto L_0x00ad
        L_0x007c:
            r2 = r6
        L_0x007d:
            if (r2 == 0) goto L_0x0088
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0086 }
            goto L_0x0088
        L_0x0083:
            r10 = move-exception
            r6 = r2
            goto L_0x00bf
        L_0x0086:
            r0 = move-exception
            goto L_0x00ad
        L_0x0088:
            r10.success(r7)     // Catch:{ Exception -> 0x0086 }
            if (r2 != 0) goto L_0x0090
            r9.m(r3)
        L_0x0090:
            return r5
        L_0x0091:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r1.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r5 = "Cursor "
            r1.append(r5)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r1.append(r2)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r2 = " not found"
            r1.append(r2)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            throw r0     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
        L_0x00ad:
            r9.D(r0, r10)     // Catch:{ all -> 0x0083 }
            if (r3 == 0) goto L_0x00b6
            r9.m(r3)     // Catch:{ all -> 0x0083 }
            goto L_0x00b7
        L_0x00b6:
            r4 = r3
        L_0x00b7:
            if (r2 != 0) goto L_0x00be
            if (r4 == 0) goto L_0x00be
            r9.m(r4)
        L_0x00be:
            return r6
        L_0x00bf:
            if (r6 != 0) goto L_0x00c6
            if (r3 == 0) goto L_0x00c6
            r9.m(r3)
        L_0x00c6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.K(com.tekartik.sqflite.operation.Operation):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean L(com.tekartik.sqflite.operation.Operation r8) {
        /*
            r7 = this;
            boolean r0 = r7.w(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r8.f()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0014
            r8.success(r3)
            return r2
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r0 = r7.C()     // Catch:{ Exception -> 0x008a }
            java.lang.String r4 = "SELECT changes()"
            android.database.Cursor r0 = r0.rawQuery(r4, r3)     // Catch:{ Exception -> 0x008a }
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x0067
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r5 <= 0) goto L_0x0067
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r5 == 0) goto L_0x0067
            int r3 = r0.getInt(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            int r5 = r7.d     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            boolean r5 = com.tekartik.sqflite.LogLevel.b(r5)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r5 == 0) goto L_0x005c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r5.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r6 = r7.A()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r5.append(r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r6 = "changed "
            r5.append(r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r5.append(r3)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            goto L_0x005c
        L_0x0056:
            r7 = move-exception
            r3 = r0
            goto L_0x0094
        L_0x0059:
            r2 = move-exception
            r3 = r0
            goto L_0x008b
        L_0x005c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r8.success(r3)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r0.close()
            return r2
        L_0x0067:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r5.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r6 = r7.A()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r5.append(r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r6 = "fail to read changes for Update/Delete"
            r5.append(r6)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r8.success(r3)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r0 == 0) goto L_0x0087
            r0.close()
        L_0x0087:
            return r2
        L_0x0088:
            r7 = move-exception
            goto L_0x0094
        L_0x008a:
            r2 = move-exception
        L_0x008b:
            r7.D(r2, r8)     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x0093
            r3.close()
        L_0x0093:
            return r1
        L_0x0094:
            if (r3 == 0) goto L_0x0099
            r3.close()
        L_0x0099:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.L(com.tekartik.sqflite.operation.Operation):boolean");
    }

    public synchronized void u(Boolean bool) {
        try {
            if (Boolean.TRUE.equals(bool)) {
                this.j++;
            } else if (Boolean.FALSE.equals(bool)) {
                this.j--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void v(Operation operation) {
        S(operation, new e(this, operation));
    }

    public final boolean w(Operation operation) {
        SqlCommand c2 = operation.c();
        if (LogLevel.b(this.d)) {
            Log.d("Sqflite", A() + c2);
        }
        Boolean e2 = operation.e();
        try {
            C().execSQL(c2.c(), c2.d());
            u(e2);
            return true;
        } catch (Exception e3) {
            D(e3, operation);
            return false;
        }
    }

    public SQLiteDatabase z() {
        return this.i;
    }
}
