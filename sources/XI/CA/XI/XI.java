package XI.CA.XI;

import android.content.Context;

public class XI {

    /* renamed from: XI  reason: collision with root package name */
    public Context f44XI;

    public XI(Context context) {
        this.f44XI = context;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[SYNTHETIC, Splitter:B:18:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String XI(int r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0030
            r1 = 1
            if (r9 == r1) goto L_0x0028
            r1 = 2
            if (r9 == r1) goto L_0x0016
            r10 = 4
            if (r9 == r10) goto L_0x000e
            r2 = r0
            goto L_0x0033
        L_0x000e:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS"
        L_0x0010:
            android.net.Uri r9 = android.net.Uri.parse(r9)
            r2 = r9
            goto L_0x0033
        L_0x0016:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
        L_0x001d:
            r9.append(r1)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            goto L_0x0010
        L_0x0028:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            goto L_0x001d
        L_0x0030:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            goto L_0x0010
        L_0x0033:
            android.content.Context r8 = r8.f44XI     // Catch:{ Exception -> 0x0069, all -> 0x0062 }
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0069, all -> 0x0062 }
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0069, all -> 0x0062 }
            if (r8 == 0) goto L_0x005f
            boolean r9 = r8.moveToNext()     // Catch:{ Exception -> 0x005b, all -> 0x0054 }
            if (r9 == 0) goto L_0x0057
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch:{ Exception -> 0x005b, all -> 0x0054 }
            java.lang.String r0 = r8.getString(r9)     // Catch:{ Exception -> 0x005b, all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            r9 = move-exception
            r0 = r8
            goto L_0x0063
        L_0x0057:
            r8.close()     // Catch:{ Exception -> 0x005b, all -> 0x0054 }
            goto L_0x005f
        L_0x005b:
            r7 = r0
            r0 = r8
            r8 = r7
            goto L_0x006a
        L_0x005f:
            if (r8 == 0) goto L_0x0074
            goto L_0x006f
        L_0x0062:
            r9 = move-exception
        L_0x0063:
            if (r0 == 0) goto L_0x0068
            r0.close()
        L_0x0068:
            throw r9
        L_0x0069:
            r8 = r0
        L_0x006a:
            if (r0 == 0) goto L_0x0073
            r7 = r0
            r0 = r8
            r8 = r7
        L_0x006f:
            r8.close()
            goto L_0x0074
        L_0x0073:
            r0 = r8
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.CA.XI.XI.XI(int, java.lang.String):java.lang.String");
    }
}
