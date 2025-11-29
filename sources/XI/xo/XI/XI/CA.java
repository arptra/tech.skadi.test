package XI.xo.XI.XI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Handler;
import com.honey.account.constant.AccountConstantKt;

public class CA {
    public static volatile CA J9;
    public K0 CA = new K0();
    public XI K0 = new XI(AccountConstantKt.REQUEST_HEADER_OAID);

    /* renamed from: XI  reason: collision with root package name */
    public XI f59XI = new XI("udid");
    public XI kM = new XI("aaid");
    public BroadcastReceiver vs;
    public XI xo = new XI("vaid");

    public static final CA XI() {
        if (J9 == null) {
            synchronized (CA.class) {
                try {
                    if (J9 == null) {
                        J9 = new CA();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return J9;
    }

    public static kM XI(Cursor cursor) {
        kM kMVar = new kM((String) null, 0);
        if (cursor.isClosed()) {
            return kMVar;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(AccountConstantKt.RESPONSE_VALUE);
        if (columnIndex >= 0) {
            kMVar.f62XI = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            kMVar.K0 = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            kMVar.kM = cursor.getLong(columnIndex3);
        }
        return kMVar;
    }

    public final synchronized void XI(Context context) {
        if (this.vs == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            xo xoVar = new xo();
            this.vs = xoVar;
            context.registerReceiver(xoVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", (Handler) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.database.Cursor} */
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
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String XI(android.content.Context r10, XI.xo.XI.XI.XI r11) {
        /*
            r9 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            long r1 = r11.f61XI
            long r3 = java.lang.System.currentTimeMillis()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0011
            java.lang.String r9 = r11.K0
            return r9
        L_0x0011:
            r1 = 1
            boolean r2 = r9.XI((android.content.Context) r10, (boolean) r1)
            if (r2 != 0) goto L_0x0019
            return r0
        L_0x0019:
            java.lang.String r2 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r4 = android.net.Uri.parse(r2)
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r2 = r11.kM     // Catch:{ Exception -> 0x0082 }
            java.lang.String[] r7 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0082 }
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0082 }
            r3 = 0
            if (r2 == 0) goto L_0x0068
            XI.xo.XI.XI.kM r4 = XI((android.database.Cursor) r2)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r0 = r4.f62XI     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r11.K0 = r0     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            long r5 = r4.kM     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r11.f61XI = r5     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            int r5 = r4.K0     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r11.xo = r5     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            int r11 = r4.K0     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r4) goto L_0x007d
            r9.XI((android.content.Context) r10)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            boolean r11 = r9.XI((android.content.Context) r10, (boolean) r3)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            if (r11 != 0) goto L_0x007d
            boolean r9 = r9.XI((android.content.Context) r10, (boolean) r1)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r10.<init>()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r11 = "not support, forceQuery isSupported: "
        L_0x005d:
            r10.append(r11)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            goto L_0x007a
        L_0x0061:
            r9 = move-exception
            r0 = r2
            goto L_0x0091
        L_0x0064:
            r9 = move-exception
            r10 = r0
            r0 = r2
            goto L_0x0084
        L_0x0068:
            boolean r11 = r9.XI((android.content.Context) r10, (boolean) r3)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            if (r11 == 0) goto L_0x007d
            boolean r9 = r9.XI((android.content.Context) r10, (boolean) r1)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            r10.<init>()     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
            java.lang.String r11 = "forceQuery isSupported : "
            goto L_0x005d
        L_0x007a:
            r10.append(r9)     // Catch:{ Exception -> 0x0064, all -> 0x0061 }
        L_0x007d:
            if (r2 == 0) goto L_0x0090
            goto L_0x008b
        L_0x0080:
            r9 = move-exception
            goto L_0x0091
        L_0x0082:
            r9 = move-exception
            r10 = r0
        L_0x0084:
            r9.getMessage()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x008f
            r2 = r0
            r0 = r10
        L_0x008b:
            r2.close()
            goto L_0x0090
        L_0x008f:
            r0 = r10
        L_0x0090:
            return r0
        L_0x0091:
            if (r0 == 0) goto L_0x0096
            r0.close()
        L_0x0096:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.xo.XI.XI.CA.XI(android.content.Context, XI.xo.XI.XI.XI):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009a, code lost:
        if ("0".equals(r11.f62XI) != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a6, code lost:
        if (r1 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ac, code lost:
        if (r1 == null) goto L_0x00af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean XI(android.content.Context r11, boolean r12) {
        /*
            r10 = this;
            java.lang.String r0 = "com.meizu.safe"
            XI.xo.XI.XI.K0 r1 = r10.CA
            java.lang.Boolean r1 = r1.K0
            r2 = 0
            if (r1 == 0) goto L_0x0012
            if (r12 != 0) goto L_0x0012
            if (r1 == 0) goto L_0x0011
            boolean r2 = r1.booleanValue()
        L_0x0011:
            return r2
        L_0x0012:
            android.content.pm.PackageManager r12 = r11.getPackageManager()
            if (r12 != 0) goto L_0x0019
            return r2
        L_0x0019:
            r1 = 0
            android.content.pm.PackageInfo r3 = r12.getPackageInfo(r0, r2)     // Catch:{ Exception -> 0x0023 }
            if (r3 == 0) goto L_0x002a
            java.lang.String r3 = r3.versionName     // Catch:{ Exception -> 0x0023 }
            goto L_0x002b
        L_0x0023:
            r3 = move-exception
            r3.printStackTrace()
            r3.getMessage()
        L_0x002a:
            r3 = r1
        L_0x002b:
            XI.xo.XI.XI.K0 r4 = r10.CA
            java.lang.Boolean r5 = r4.K0
            if (r5 == 0) goto L_0x004c
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 == 0) goto L_0x0039
            r4 = r2
            goto L_0x003f
        L_0x0039:
            java.lang.String r4 = r4.f60XI
            boolean r4 = android.text.TextUtils.equals(r4, r3)
        L_0x003f:
            if (r4 == 0) goto L_0x004c
            XI.xo.XI.XI.K0 r10 = r10.CA
            java.lang.Boolean r10 = r10.K0
            if (r10 == 0) goto L_0x004b
            boolean r2 = r10.booleanValue()
        L_0x004b:
            return r2
        L_0x004c:
            XI.xo.XI.XI.K0 r4 = r10.CA
            r4.f60XI = r3
            java.lang.String r3 = "com.meizu.flyme.openidsdk"
            android.content.pm.ProviderInfo r12 = r12.resolveContentProvider(r3, r2)
            r3 = 1
            if (r12 != 0) goto L_0x005a
            goto L_0x006a
        L_0x005a:
            android.content.pm.ApplicationInfo r4 = r12.applicationInfo
            int r4 = r4.flags
            r4 = r4 & r3
            if (r4 != 0) goto L_0x0062
            goto L_0x006a
        L_0x0062:
            java.lang.String r12 = r12.packageName
            boolean r12 = android.text.TextUtils.equals(r0, r12)
            if (r12 != 0) goto L_0x006c
        L_0x006a:
            r12 = r2
            goto L_0x006d
        L_0x006c:
            r12 = r3
        L_0x006d:
            if (r12 == 0) goto L_0x00be
            java.lang.String r12 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r5 = android.net.Uri.parse(r12)
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch:{ Exception -> 0x009f }
            java.lang.String r11 = "supported"
            java.lang.String[] r8 = new java.lang.String[]{r11}     // Catch:{ Exception -> 0x009f }
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x009f }
            if (r1 == 0) goto L_0x00a6
            XI.xo.XI.XI.kM r11 = XI((android.database.Cursor) r1)     // Catch:{ Exception -> 0x009f }
            int r12 = r11.K0     // Catch:{ Exception -> 0x009f }
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r0 != r12) goto L_0x00a1
            java.lang.String r12 = "0"
            java.lang.String r11 = r11.f62XI     // Catch:{ Exception -> 0x009f }
            boolean r11 = r12.equals(r11)     // Catch:{ Exception -> 0x009f }
            if (r11 == 0) goto L_0x00a2
            goto L_0x00a1
        L_0x009d:
            r10 = move-exception
            goto L_0x00b8
        L_0x009f:
            r11 = move-exception
            goto L_0x00a9
        L_0x00a1:
            r2 = r3
        L_0x00a2:
            r1.close()
            goto L_0x00af
        L_0x00a6:
            if (r1 == 0) goto L_0x00af
            goto L_0x00ae
        L_0x00a9:
            r11.getMessage()     // Catch:{ all -> 0x009d }
            if (r1 == 0) goto L_0x00af
        L_0x00ae:
            goto L_0x00a2
        L_0x00af:
            XI.xo.XI.XI.K0 r10 = r10.CA
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r2)
            r10.K0 = r11
            return r2
        L_0x00b8:
            if (r1 == 0) goto L_0x00bd
            r1.close()
        L_0x00bd:
            throw r10
        L_0x00be:
            XI.xo.XI.XI.K0 r10 = r10.CA
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r10.K0 = r11
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.xo.XI.XI.CA.XI(android.content.Context, boolean):boolean");
    }
}
