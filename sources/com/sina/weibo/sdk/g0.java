package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.List;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9981a = false;
    public static AuthInfo b;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r2 = com.sina.weibo.sdk.a.a(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r2) {
        /*
            boolean r0 = b(r2)
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.sina.weibo.sdk.a$a r2 = com.sina.weibo.sdk.a.a(r2)
            if (r2 == 0) goto L_0x0014
            int r2 = r2.b
            r0 = 3441(0xd71, float:4.822E-42)
            if (r2 < r0) goto L_0x0014
            r1 = 1
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.g0.a(android.content.Context):boolean");
    }

    public static boolean b(Context context) {
        List<ResolveInfo> queryIntentServices;
        String[] strArr = {"com.sina.weibo", "com.sina.weibog3"};
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.setPackage(str);
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
