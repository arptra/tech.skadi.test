package com.meizu.flyme.policy.sdk.util;

public class PolicySdkNetworkUtil {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r1 = r1.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNetworkAvailable(android.content.Context r1) {
        /*
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            if (r1 == 0) goto L_0x001c
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x001c
            boolean r1 = r1.isAvailable()
            if (r1 == 0) goto L_0x001c
            r1 = 1
            return r1
        L_0x001c:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkNetworkUtil.isNetworkAvailable(android.content.Context):boolean");
    }
}
