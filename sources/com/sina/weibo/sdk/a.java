package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;

public final class a {

    /* renamed from: com.sina.weibo.sdk.a$a  reason: collision with other inner class name */
    public static class C0037a {

        /* renamed from: a  reason: collision with root package name */
        public String f9968a = "com.sina.weibo";
        public int b;
    }

    public static boolean a(Context context, Intent intent) {
        PackageManager packageManager;
        ResolveInfo resolveActivity;
        if (context == null || (packageManager = context.getPackageManager()) == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            if (signatureArr == null) {
                return false;
            }
            for (Signature byteArray : signatureArr) {
                if ("18da2bf10352443a00a5e046d9fca6bd".equals(o.a(byteArray.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0035 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sina.weibo.sdk.a.C0037a a(android.content.Context r9) {
        /*
            java.lang.String r0 = "com.sina.weibo"
            java.lang.String r1 = "com.sina.weibog3"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = r1
        L_0x000a:
            r3 = 0
            r4 = 2
            if (r2 >= r4) goto L_0x0087
            r4 = r0[r2]
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "com.sina.weibo.action.sdkidentity"
            r5.<init>(r6)
            r5.setPackage(r4)
            java.lang.String r6 = "android.intent.category.DEFAULT"
            r5.addCategory(r6)
            if (r9 == 0) goto L_0x0084
            android.content.pm.PackageManager r6 = r9.getPackageManager()
            java.util.List r5 = r6.queryIntentServices(r5, r1)
            if (r5 == 0) goto L_0x0084
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x0084
            java.util.Iterator r5 = r5.iterator()
        L_0x0035:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0084
            java.lang.Object r6 = r5.next()
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            android.content.pm.ServiceInfo r7 = r6.serviceInfo
            if (r7 == 0) goto L_0x0035
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo
            if (r8 == 0) goto L_0x0035
            java.lang.String r7 = r7.packageName
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0052
            goto L_0x0035
        L_0x0052:
            android.content.pm.ServiceInfo r6 = r6.serviceInfo
            java.lang.String r6 = r6.packageName
            boolean r7 = android.text.TextUtils.equals(r4, r6)
            if (r7 == 0) goto L_0x0035
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0064
        L_0x0062:
            r7 = r3
            goto L_0x0081
        L_0x0064:
            com.sina.weibo.sdk.a$a r7 = new com.sina.weibo.sdk.a$a     // Catch:{ Exception -> 0x0078 }
            r7.<init>()     // Catch:{ Exception -> 0x0078 }
            r7.f9968a = r6     // Catch:{ Exception -> 0x0078 }
            android.content.pm.PackageManager r8 = r9.getPackageManager()     // Catch:{ Exception -> 0x0078 }
            android.content.pm.PackageInfo r6 = r8.getPackageInfo(r6, r1)     // Catch:{ Exception -> 0x0078 }
            int r6 = r6.versionCode     // Catch:{ Exception -> 0x0078 }
            r7.b = r6     // Catch:{ Exception -> 0x0078 }
            goto L_0x0081
        L_0x0078:
            r6 = move-exception
            java.lang.String r7 = com.sina.weibo.sdk.n.b
            java.lang.String r8 = "check app info fail"
            com.sina.weibo.sdk.n.a(r7, r8, r6)
            goto L_0x0062
        L_0x0081:
            if (r7 == 0) goto L_0x0035
            return r7
        L_0x0084:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0087:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.a.a(android.content.Context):com.sina.weibo.sdk.a$a");
    }
}
