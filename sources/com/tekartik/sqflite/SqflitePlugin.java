package com.tekartik.sqflite;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.actions.SearchIntents;
import com.tekartik.sqflite.dev.Debug;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class SqflitePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final Map c = new HashMap();
    public static final Map d = new HashMap();
    public static final Object e = new Object();
    public static final Object f = new Object();
    public static int g = 0;
    public static String h;
    public static int i = 0;
    public static int j = 1;
    public static int k = 0;
    public static DatabaseWorkerPool l;

    /* renamed from: a  reason: collision with root package name */
    public Context f10028a;
    public MethodChannel b;

    public static boolean o(String str) {
        return str == null || str.equals(":memory:");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        r4.success(x(r9, false, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void s(boolean r2, java.lang.String r3, io.flutter.plugin.common.MethodChannel.Result r4, java.lang.Boolean r5, com.tekartik.sqflite.Database r6, io.flutter.plugin.common.MethodCall r7, boolean r8, int r9) {
        /*
            java.lang.Object r0 = f
            monitor-enter(r0)
            if (r2 != 0) goto L_0x0040
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x003e }
            r2.<init>(r3)     // Catch:{ all -> 0x003e }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x003e }
            java.lang.String r2 = r2.getParent()     // Catch:{ all -> 0x003e }
            r1.<init>(r2)     // Catch:{ all -> 0x003e }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x0040
            boolean r2 = r1.mkdirs()     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x0040
            boolean r2 = r1.exists()     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x0040
            java.lang.String r2 = "sqlite_error"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r5.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r6 = "open_failed "
            r5.append(r6)     // Catch:{ all -> 0x003e }
            r5.append(r3)     // Catch:{ all -> 0x003e }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x003e }
            r5 = 0
            r4.error(r2, r3, r5)     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x003e:
            r2 = move-exception
            goto L_0x00af
        L_0x0040:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x004c }
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x004e
            r6.N()     // Catch:{ Exception -> 0x004c }
            goto L_0x0051
        L_0x004c:
            r2 = move-exception
            goto L_0x00a5
        L_0x004e:
            r6.M()     // Catch:{ Exception -> 0x004c }
        L_0x0051:
            java.lang.Object r2 = e     // Catch:{ all -> 0x003e }
            monitor-enter(r2)     // Catch:{ all -> 0x003e }
            if (r8 == 0) goto L_0x0062
            java.util.Map r5 = c     // Catch:{ all -> 0x0060 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0060 }
            r5.put(r3, r7)     // Catch:{ all -> 0x0060 }
            goto L_0x0062
        L_0x0060:
            r3 = move-exception
            goto L_0x00a3
        L_0x0062:
            java.util.Map r5 = d     // Catch:{ all -> 0x0060 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0060 }
            r5.put(r7, r6)     // Catch:{ all -> 0x0060 }
            monitor-exit(r2)     // Catch:{ all -> 0x0060 }
            int r2 = r6.d     // Catch:{ all -> 0x003e }
            boolean r2 = com.tekartik.sqflite.LogLevel.b(r2)     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = "Sqflite"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r5.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r6 = r6.A()     // Catch:{ all -> 0x003e }
            r5.append(r6)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = "opened "
            r5.append(r6)     // Catch:{ all -> 0x003e }
            r5.append(r9)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = " "
            r5.append(r6)     // Catch:{ all -> 0x003e }
            r5.append(r3)     // Catch:{ all -> 0x003e }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x003e }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x003e }
        L_0x0099:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            r2 = 0
            java.util.Map r2 = x(r9, r2, r2)
            r4.success(r2)
            return
        L_0x00a3:
            monitor-exit(r2)     // Catch:{ all -> 0x0060 }
            throw r3     // Catch:{ all -> 0x003e }
        L_0x00a5:
            com.tekartik.sqflite.operation.MethodCallOperation r3 = new com.tekartik.sqflite.operation.MethodCallOperation     // Catch:{ all -> 0x003e }
            r3.<init>(r7, r4)     // Catch:{ all -> 0x003e }
            r6.D(r2, r3)     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return
        L_0x00af:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.s(boolean, java.lang.String, io.flutter.plugin.common.MethodChannel$Result, java.lang.Boolean, com.tekartik.sqflite.Database, io.flutter.plugin.common.MethodCall, boolean, int):void");
    }

    public static /* synthetic */ void v(MethodCall methodCall, Database database, MethodChannel.Result result) {
        try {
            database.i.setLocale(Utils.d((String) methodCall.argument("locale")));
            result.success((Object) null);
        } catch (Exception e2) {
            result.error("sqlite_error", "Error calling setLocale: " + e2.getMessage(), (Object) null);
        }
    }

    public static Map x(int i2, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i2));
        if (z) {
            hashMap.put("recovered", Boolean.TRUE);
        }
        if (z2) {
            hashMap.put("recoveredInTransaction", Boolean.TRUE);
        }
        return hashMap;
    }

    public final void A(MethodCall methodCall, final MethodChannel.Result result) {
        Integer num = (Integer) methodCall.argument("id");
        int intValue = num.intValue();
        final Database n = n(methodCall, result);
        if (n != null) {
            if (LogLevel.b(n.d)) {
                Log.d("Sqflite", n.A() + "closing " + intValue + " " + n.b);
            }
            String str = n.b;
            synchronized (e) {
                try {
                    d.remove(num);
                    if (n.f10020a) {
                        c.remove(str);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            l.d(n, new Runnable() {
                public void run() {
                    synchronized (SqflitePlugin.f) {
                        SqflitePlugin.this.l(n);
                    }
                    result.success((Object) null);
                }
            });
        }
    }

    public final void B(MethodCall methodCall, MethodChannel.Result result) {
        result.success(Boolean.valueOf(Database.x((String) methodCall.argument("path"))));
    }

    public final void C(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        if ("get".equals((String) methodCall.argument("cmd"))) {
            int i2 = g;
            if (i2 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i2));
            }
            Map map = d;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    Database database = (Database) entry.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", database.b);
                    hashMap3.put("singleInstance", Boolean.valueOf(database.f10020a));
                    int i3 = database.d;
                    if (i3 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i3));
                    }
                    hashMap2.put(((Integer) entry.getKey()).toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        result.success(hashMap);
    }

    public final void D(MethodCall methodCall, MethodChannel.Result result) {
        Debug.f10036a = Boolean.TRUE.equals(methodCall.arguments());
        Debug.c = Debug.b && Debug.f10036a;
        if (!Debug.f10036a) {
            g = 0;
        } else if (Debug.c) {
            g = 2;
        } else if (Debug.f10036a) {
            g = 1;
        }
        result.success((Object) null);
    }

    public final void E(MethodCall methodCall, final MethodChannel.Result result) {
        final Database database;
        final String str = (String) methodCall.argument("path");
        synchronized (e) {
            try {
                if (LogLevel.c(g)) {
                    Log.d("Sqflite", "Look for " + str + " in " + c.keySet());
                }
                Map map = c;
                Integer num = (Integer) map.get(str);
                if (num != null) {
                    Map map2 = d;
                    database = (Database) map2.get(num);
                    if (database != null && database.i.isOpen()) {
                        if (LogLevel.c(g)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(database.A());
                            sb.append("found single instance ");
                            sb.append(database.F() ? "(in transaction) " : "");
                            sb.append(num);
                            sb.append(" ");
                            sb.append(str);
                            Log.d("Sqflite", sb.toString());
                        }
                        map2.remove(num);
                        map.remove(str);
                    }
                }
                database = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                synchronized (SqflitePlugin.f) {
                    Database database = database;
                    if (database != null) {
                        SqflitePlugin.this.l(database);
                    }
                    try {
                        if (LogLevel.c(SqflitePlugin.g)) {
                            Log.d("Sqflite", "delete database " + str);
                        }
                        Database.o(str);
                    } catch (Exception e) {
                        Log.e("Sqflite", "error " + e + " while closing database " + SqflitePlugin.k);
                    }
                }
                result.success((Object) null);
            }
        };
        DatabaseWorkerPool databaseWorkerPool = l;
        if (databaseWorkerPool != null) {
            databaseWorkerPool.d(database, r0);
        } else {
            r0.run();
        }
    }

    public final void F(MethodCall methodCall, MethodChannel.Result result) {
        Database n = n(methodCall, result);
        if (n != null) {
            l.d(n, new o(methodCall, result, n));
        }
    }

    public void G(MethodCall methodCall, MethodChannel.Result result) {
        if (h == null) {
            h = this.f10028a.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(h);
    }

    public final void H(MethodCall methodCall, MethodChannel.Result result) {
        Database n = n(methodCall, result);
        if (n != null) {
            l.d(n, new k(methodCall, result, n));
        }
    }

    public final void I(MethodCall methodCall, MethodChannel.Result result) {
        int i2;
        Database database;
        MethodCall methodCall2 = methodCall;
        String str = (String) methodCall2.argument("path");
        Boolean bool = (Boolean) methodCall2.argument("readOnly");
        boolean o = o(str);
        boolean z = !Boolean.FALSE.equals(methodCall2.argument("singleInstance")) && !o;
        if (z) {
            synchronized (e) {
                try {
                    if (LogLevel.c(g)) {
                        Log.d("Sqflite", "Look for " + str + " in " + c.keySet());
                    }
                    Integer num = (Integer) c.get(str);
                    if (!(num == null || (database = (Database) d.get(num)) == null)) {
                        if (database.i.isOpen()) {
                            if (LogLevel.c(g)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(database.A());
                                sb.append("re-opened single instance ");
                                sb.append(database.F() ? "(in transaction) " : "");
                                sb.append(num);
                                sb.append(" ");
                                sb.append(str);
                                Log.d("Sqflite", sb.toString());
                            }
                            result.success(x(num.intValue(), true, database.F()));
                            return;
                        } else if (LogLevel.c(g)) {
                            Log.d("Sqflite", database.A() + "single instance database of " + str + " not opened");
                        }
                    }
                    MethodChannel.Result result2 = result;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            MethodChannel.Result result3 = result;
        }
        Object obj = e;
        synchronized (obj) {
            i2 = k + 1;
            k = i2;
        }
        Database database2 = new Database(this.f10028a, str, i2, z, g);
        synchronized (obj) {
            try {
                if (l == null) {
                    DatabaseWorkerPool a2 = DatabaseWorkerPool.a("Sqflite", j, i);
                    l = a2;
                    a2.start();
                    if (LogLevel.b(database2.d)) {
                        Log.d("Sqflite", database2.A() + "starting worker pool with priority " + i);
                    }
                }
                database2.h = l;
                if (LogLevel.b(database2.d)) {
                    Log.d("Sqflite", database2.A() + "opened " + i2 + " " + str);
                }
                n nVar = r1;
                DatabaseWorkerPool databaseWorkerPool = l;
                n nVar2 = new n(o, str, result, bool, database2, methodCall, z, i2);
                databaseWorkerPool.d(database2, nVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void J(MethodCall methodCall, MethodChannel.Result result) {
        Object argument = methodCall.argument("androidThreadPriority");
        if (argument != null) {
            i = ((Integer) argument).intValue();
        }
        Object argument2 = methodCall.argument("androidThreadCount");
        if (argument2 != null && !argument2.equals(Integer.valueOf(j))) {
            j = ((Integer) argument2).intValue();
            DatabaseWorkerPool databaseWorkerPool = l;
            if (databaseWorkerPool != null) {
                databaseWorkerPool.c();
                l = null;
            }
        }
        Integer a2 = LogLevel.a(methodCall);
        if (a2 != null) {
            g = a2.intValue();
        }
        result.success((Object) null);
    }

    public final void K(MethodCall methodCall, MethodChannel.Result result) {
        Database n = n(methodCall, result);
        if (n != null) {
            l.d(n, new l(methodCall, result, n));
        }
    }

    public final void L(MethodCall methodCall, MethodChannel.Result result) {
        Database n = n(methodCall, result);
        if (n != null) {
            l.d(n, new j(methodCall, result, n));
        }
    }

    public final void M(MethodCall methodCall, MethodChannel.Result result) {
        Database n = n(methodCall, result);
        if (n != null) {
            l.d(n, new m(methodCall, n, result));
        }
    }

    public final void N(MethodCall methodCall, MethodChannel.Result result) {
        Database n = n(methodCall, result);
        if (n != null) {
            l.d(n, new p(methodCall, result, n));
        }
    }

    public final void l(Database database) {
        try {
            if (LogLevel.b(database.d)) {
                Log.d("Sqflite", database.A() + "closing database ");
            }
            database.k();
        } catch (Exception e2) {
            Log.e("Sqflite", "error " + e2 + " while closing database " + k);
        }
        synchronized (e) {
            try {
                if (d.isEmpty() && l != null) {
                    if (LogLevel.b(database.d)) {
                        Log.d("Sqflite", database.A() + "stopping thread");
                    }
                    l.c();
                    l = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Database m(int i2) {
        return (Database) d.get(Integer.valueOf(i2));
    }

    public final Database n(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        Database m = m(intValue);
        if (m != null) {
            return m;
        }
        result.error("sqlite_error", "database_closed " + intValue, (Object) null);
        return null;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        y(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f10028a = null;
        this.b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.b = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1319569547:
                if (str.equals("execute")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1253581933:
                if (str.equals("closeDatabase")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1249474914:
                if (str.equals("options")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    c2 = 3;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c2 = 4;
                    break;
                }
                break;
            case -396289107:
                if (str.equals("androidSetLocale")) {
                    c2 = 5;
                    break;
                }
                break;
            case -263511994:
                if (str.equals("deleteDatabase")) {
                    c2 = 6;
                    break;
                }
                break;
            case -198450538:
                if (str.equals("debugMode")) {
                    c2 = 7;
                    break;
                }
                break;
            case -17190427:
                if (str.equals("openDatabase")) {
                    c2 = 8;
                    break;
                }
                break;
            case 93509434:
                if (str.equals("batch")) {
                    c2 = 9;
                    break;
                }
                break;
            case 95458899:
                if (str.equals("debug")) {
                    c2 = 10;
                    break;
                }
                break;
            case 107944136:
                if (str.equals(SearchIntents.EXTRA_QUERY)) {
                    c2 = 11;
                    break;
                }
                break;
            case 956410295:
                if (str.equals("databaseExists")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1193546321:
                if (str.equals("queryCursorNext")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals("getPlatformVersion")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1863829223:
                if (str.equals("getDatabasesPath")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                F(methodCall, result);
                return;
            case 1:
                A(methodCall, result);
                return;
            case 2:
                J(methodCall, result);
                return;
            case 3:
                H(methodCall, result);
                return;
            case 4:
                N(methodCall, result);
                return;
            case 5:
                M(methodCall, result);
                return;
            case 6:
                E(methodCall, result);
                return;
            case 7:
                D(methodCall, result);
                return;
            case 8:
                I(methodCall, result);
                return;
            case 9:
                z(methodCall, result);
                return;
            case 10:
                C(methodCall, result);
                return;
            case 11:
                K(methodCall, result);
                return;
            case 12:
                B(methodCall, result);
                return;
            case 13:
                L(methodCall, result);
                return;
            case 14:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 15:
                G(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public final void y(Context context, BinaryMessenger binaryMessenger) {
        this.f10028a = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.tekartik.sqflite", StandardMethodCodec.INSTANCE, binaryMessenger.makeBackgroundTaskQueue());
        this.b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public final void z(MethodCall methodCall, MethodChannel.Result result) {
        Database n = n(methodCall, result);
        if (n != null) {
            l.d(n, new q(n, methodCall, result));
        }
    }
}
