package XI.xo.XI.XI;

import android.content.BroadcastReceiver;

public class xo extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r3 == 0) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (android.text.TextUtils.equals(r5.getStringExtra("openIdPackage"), r4.getPackageName()) != false) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x007c
            if (r5 != 0) goto L_0x0006
            goto L_0x007c
        L_0x0006:
            java.lang.String r3 = "openIdNotifyFlag"
            r0 = 0
            int r3 = r5.getIntExtra(r3, r0)
            r1 = 1
            if (r3 != r1) goto L_0x0021
            java.lang.String r3 = "openIdPackage"
            java.lang.String r3 = r5.getStringExtra(r3)
            java.lang.String r4 = r4.getPackageName()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L_0x0038
            goto L_0x0037
        L_0x0021:
            r2 = 2
            if (r3 != r2) goto L_0x0035
            java.lang.String r3 = "openIdPackageList"
            java.util.ArrayList r3 = r5.getStringArrayListExtra(r3)
            if (r3 == 0) goto L_0x0038
            java.lang.String r4 = r4.getPackageName()
            boolean r0 = r3.contains(r4)
            goto L_0x0038
        L_0x0035:
            if (r3 != 0) goto L_0x0038
        L_0x0037:
            r0 = r1
        L_0x0038:
            if (r0 != 0) goto L_0x003b
            return
        L_0x003b:
            java.lang.String r3 = "openIdType"
            java.lang.String r3 = r5.getStringExtra(r3)
            XI.xo.XI.XI.CA r4 = XI.xo.XI.XI.CA.XI()
            r4.getClass()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0053
            XI.xo.XI.XI.XI r3 = r4.K0
            goto L_0x0075
        L_0x0053:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x005e
            XI.xo.XI.XI.XI r3 = r4.xo
            goto L_0x0075
        L_0x005e:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0069
            XI.xo.XI.XI.XI r3 = r4.kM
            goto L_0x0075
        L_0x0069:
            java.lang.String r5 = "udid"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0074
            XI.xo.XI.XI.XI r3 = r4.f59XI
            goto L_0x0075
        L_0x0074:
            r3 = 0
        L_0x0075:
            if (r3 != 0) goto L_0x0078
            return
        L_0x0078:
            r4 = 0
            r3.f61XI = r4
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.xo.XI.XI.xo.onReceive(android.content.Context, android.content.Intent):void");
    }
}
