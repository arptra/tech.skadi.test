package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;

public final class a extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0049, code lost:
        if (r3 == 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
        if (android.text.TextUtils.equals(r5.getStringExtra("openIdPackage"), r4.getPackageName()) != false) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x008f
            if (r5 != 0) goto L_0x0006
            goto L_0x008f
        L_0x0006:
            java.lang.String r3 = "openIdNotifyFlag"
            r0 = 0
            int r3 = r5.getIntExtra(r3, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "shouldUpdateId, notifyFlag : "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.meizu.flyme.openidsdk.b.a((java.lang.String) r1)
            r1 = 1
            if (r3 != r1) goto L_0x0035
            java.lang.String r3 = "openIdPackage"
            java.lang.String r3 = r5.getStringExtra(r3)
            java.lang.String r4 = r4.getPackageName()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L_0x004c
            goto L_0x004b
        L_0x0035:
            r2 = 2
            if (r3 != r2) goto L_0x0049
            java.lang.String r3 = "openIdPackageList"
            java.util.ArrayList r3 = r5.getStringArrayListExtra(r3)
            if (r3 == 0) goto L_0x004c
            java.lang.String r4 = r4.getPackageName()
            boolean r0 = r3.contains(r4)
            goto L_0x004c
        L_0x0049:
            if (r3 != 0) goto L_0x004c
        L_0x004b:
            r0 = r1
        L_0x004c:
            if (r0 != 0) goto L_0x004f
            return
        L_0x004f:
            java.lang.String r3 = "openIdType"
            java.lang.String r3 = r5.getStringExtra(r3)
            com.meizu.flyme.openidsdk.b r4 = com.meizu.flyme.openidsdk.b.a()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0067
            com.meizu.flyme.openidsdk.OpenId r3 = r4.b
            goto L_0x0089
        L_0x0067:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0072
            com.meizu.flyme.openidsdk.OpenId r3 = r4.d
            goto L_0x0089
        L_0x0072:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x007d
            com.meizu.flyme.openidsdk.OpenId r3 = r4.c
            goto L_0x0089
        L_0x007d:
            java.lang.String r5 = "udid"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0088
            com.meizu.flyme.openidsdk.OpenId r3 = r4.f3145a
            goto L_0x0089
        L_0x0088:
            r3 = 0
        L_0x0089:
            if (r3 != 0) goto L_0x008c
            return
        L_0x008c:
            r3.setDataExpired()
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.openidsdk.a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
