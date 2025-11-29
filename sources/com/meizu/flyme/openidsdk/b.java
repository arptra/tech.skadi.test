package com.meizu.flyme.openidsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;

public final class b {
    public static volatile b h = null;
    public static boolean i = false;

    /* renamed from: a  reason: collision with root package name */
    public OpenId f3145a = new OpenId("udid");
    public OpenId b = new OpenId(AccountConstantKt.REQUEST_HEADER_OAID);
    public OpenId c = new OpenId("aaid");
    public OpenId d = new OpenId("vaid");
    public SupportInfo e = new SupportInfo();
    public c f;
    public a g;

    public static ValueData a(Cursor cursor) {
        ValueData valueData = new ValueData((String) null, 0);
        if (cursor.isClosed()) {
            a("parseValue fail, cursor is closed.");
            return valueData;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(AccountConstantKt.RESPONSE_VALUE);
        if (columnIndex >= 0) {
            valueData.value = cursor.getString(columnIndex);
        } else {
            a("parseValue fail, index < 0.");
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            valueData.code = cursor.getInt(columnIndex2);
        } else {
            a("parseCode fail, index < 0.");
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            valueData.expired = cursor.getLong(columnIndex3);
        } else {
            a("parseExpired fail, index < 0.");
        }
        return valueData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r0 != null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "querySupport version : 1.1.0"
            a((java.lang.String) r0)
            com.meizu.flyme.openidsdk.c r8 = r8.a((android.content.Context) r9)
            boolean r0 = a((com.meizu.flyme.openidsdk.c) r8)
            r1 = 0
            if (r0 != 0) goto L_0x0011
            return r1
        L_0x0011:
            r0 = 0
            java.lang.String r8 = r8.b     // Catch:{ Exception -> 0x0042 }
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x0042 }
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ Exception -> 0x0042 }
            java.lang.String r8 = "supported"
            java.lang.String[] r6 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x0042 }
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0042 }
            if (r0 == 0) goto L_0x0049
            com.meizu.flyme.openidsdk.ValueData r8 = a((android.database.Cursor) r0)     // Catch:{ Exception -> 0x0042 }
            int r9 = r8.code     // Catch:{ Exception -> 0x0042 }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r9) goto L_0x0044
            java.lang.String r9 = "0"
            java.lang.String r8 = r8.value     // Catch:{ Exception -> 0x0042 }
            boolean r8 = r9.equals(r8)     // Catch:{ Exception -> 0x0042 }
            if (r8 == 0) goto L_0x0045
            goto L_0x0044
        L_0x0040:
            r8 = move-exception
            goto L_0x006a
        L_0x0042:
            r8 = move-exception
            goto L_0x004c
        L_0x0044:
            r1 = 1
        L_0x0045:
            r0.close()
            return r1
        L_0x0049:
            if (r0 == 0) goto L_0x0069
            goto L_0x0066
        L_0x004c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r9.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = "querySupport, Exception : "
            r9.append(r2)     // Catch:{ all -> 0x0040 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0040 }
            r9.append(r8)     // Catch:{ all -> 0x0040 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0040 }
            a((java.lang.String) r8)     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0069
        L_0x0066:
            r0.close()
        L_0x0069:
            return r1
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            r0.close()
        L_0x006f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.openidsdk.b.b(android.content.Context):boolean");
    }

    public static final b a() {
        if (h == null) {
            synchronized (b.class) {
                try {
                    if (h == null) {
                        h = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    public final c a(Context context) {
        boolean z;
        if (a(this.f)) {
            return this.f;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            a("makeSureProviderData, packageManager is null");
            return null;
        }
        String a2 = a(packageManager, "com.flyme.secureservice.openidsdk");
        if (TextUtils.isEmpty(a2)) {
            a2 = a(packageManager, "com.meizu.flyme.openidsdk");
            a("makeSureProviderData, use SAFE_AUTHORITIES");
            z = false;
        } else {
            a("makeSureProviderData, use SECURESERVICE_AUTHORITIES");
            z = true;
        }
        c cVar = new c(a2, z);
        this.f = cVar;
        return cVar;
    }

    public static String a(PackageManager packageManager, String str) {
        String str2;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            str2 = "fetchProviderPackageName, providerInfo is null";
        } else if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
            return resolveContentProvider.packageName;
        } else {
            str2 = "fetchProviderPackageName, providerInfoFlags is not system";
        }
        a(str2);
        return null;
    }

    public final synchronized void a(Context context, String str) {
        if (this.g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            a aVar = new a();
            this.g = aVar;
            context.registerReceiver(aVar, intentFilter, str, (Handler) null);
            a("registerReceivers, permission : " + str);
        }
    }

    public static void a(String str) {
        if (i) {
            Log.d("OpenIdManager", str);
        }
    }

    public final boolean a(Context context, boolean z) {
        if (this.e.isCached() && !z) {
            return this.e.isSupport();
        }
        if (!a(a(context))) {
            return false;
        }
        boolean b2 = b(context);
        a("query support, result : " + b2);
        this.e.setSupport(b2);
        return b2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(android.content.Context r11, com.meizu.flyme.openidsdk.OpenId r12) {
        /*
            r10 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0009
            java.lang.String r10 = "getId, openId = null."
        L_0x0005:
            a((java.lang.String) r10)
            return r0
        L_0x0009:
            boolean r1 = r12.isValid()
            if (r1 == 0) goto L_0x0012
            java.lang.String r10 = r12.value
            return r10
        L_0x0012:
            r1 = 1
            boolean r2 = r10.a((android.content.Context) r11, (boolean) r1)
            if (r2 != 0) goto L_0x001c
            java.lang.String r10 = "getId, isSupported = false."
            goto L_0x0005
        L_0x001c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "queryId : "
            r2.append(r3)
            java.lang.String r3 = r12.type
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            a((java.lang.String) r2)
            com.meizu.flyme.openidsdk.c r2 = r10.a((android.content.Context) r11)
            boolean r3 = a((com.meizu.flyme.openidsdk.c) r2)
            if (r3 != 0) goto L_0x003e
            goto L_0x00f6
        L_0x003e:
            java.lang.String r3 = r2.b     // Catch:{ Exception -> 0x00d3 }
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00d3 }
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r3 = r12.type     // Catch:{ Exception -> 0x00d3 }
            java.lang.String[] r8 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x00d3 }
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00d3 }
            r4 = 0
            if (r3 == 0) goto L_0x00b0
            com.meizu.flyme.openidsdk.ValueData r5 = a((android.database.Cursor) r3)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r0 = r5.value     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r12.updateValue(r0)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            long r6 = r5.expired     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r12.updateExpiredTime(r6)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            int r6 = r5.code     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r12.updateCode(r6)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r6.<init>()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r7 = r12.type     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r6.append(r7)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r7 = " errorCode : "
            r6.append(r7)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            int r12 = r12.code     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r6.append(r12)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r12 = r6.toString()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            a((java.lang.String) r12)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            int r12 = r5.code     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r12 == r5) goto L_0x00ce
            java.lang.String r12 = r2.f3146a     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r10.a((android.content.Context) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            boolean r12 = r10.a((android.content.Context) r11, (boolean) r4)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            if (r12 != 0) goto L_0x00ce
            boolean r10 = r10.a((android.content.Context) r11, (boolean) r1)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r11.<init>()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r12 = "not support, forceQuery isSupported: "
            r11.append(r12)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r11.append(r10)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            goto L_0x00c7
        L_0x00a9:
            r10 = move-exception
            r0 = r3
            goto L_0x00f7
        L_0x00ac:
            r10 = move-exception
            r11 = r0
            r0 = r3
            goto L_0x00d5
        L_0x00b0:
            boolean r12 = r10.a((android.content.Context) r11, (boolean) r4)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            if (r12 == 0) goto L_0x00ce
            boolean r10 = r10.a((android.content.Context) r11, (boolean) r1)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r11.<init>()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.lang.String r12 = "forceQuery isSupported : "
            r11.append(r12)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r11.append(r10)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
        L_0x00c7:
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            a((java.lang.String) r10)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
        L_0x00ce:
            if (r3 == 0) goto L_0x00f6
            goto L_0x00f1
        L_0x00d1:
            r10 = move-exception
            goto L_0x00f7
        L_0x00d3:
            r10 = move-exception
            r11 = r0
        L_0x00d5:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r12.<init>()     // Catch:{ all -> 0x00d1 }
            java.lang.String r1 = "queryId, Exception : "
            r12.append(r1)     // Catch:{ all -> 0x00d1 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00d1 }
            r12.append(r10)     // Catch:{ all -> 0x00d1 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x00d1 }
            a((java.lang.String) r10)     // Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x00f5
            r3 = r0
            r0 = r11
        L_0x00f1:
            r3.close()
            goto L_0x00f6
        L_0x00f5:
            r0 = r11
        L_0x00f6:
            return r0
        L_0x00f7:
            if (r0 == 0) goto L_0x00fc
            r0.close()
        L_0x00fc:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.openidsdk.b.a(android.content.Context, com.meizu.flyme.openidsdk.OpenId):java.lang.String");
    }

    public static boolean a(c cVar) {
        return cVar != null && cVar.c;
    }
}
