package com.sina.weibo.sdk;

import android.net.Uri;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

public final class y extends e {
    public WeiboMultiMessage b;
    public String c;
    public String d;
    public String e;

    public y(int i) {
    }

    public final String a() {
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.e);
        buildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.f9974a.f9999a.getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.c)) {
            buildUpon.appendQueryParameter("access_token", this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            buildUpon.appendQueryParameter("packagename", this.d);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            buildUpon.appendQueryParameter("picinfo", (String) null);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_" + appKey);
        return buildUpon.build().toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c A[SYNTHETIC, Splitter:B:30:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088 A[SYNTHETIC, Splitter:B:36:0x0088] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.os.Bundle r8) {
        /*
            r7 = this;
            com.sina.weibo.sdk.api.WeiboMultiMessage r0 = new com.sina.weibo.sdk.api.WeiboMultiMessage
            r0.<init>()
            r7.b = r0
            r0.readFromBundle(r8)
            java.lang.String r0 = "token"
            java.lang.String r0 = r8.getString(r0)
            r7.c = r0
            java.lang.String r0 = "packageName"
            java.lang.String r8 = r8.getString(r0)
            r7.d = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            com.sina.weibo.sdk.api.WeiboMultiMessage r0 = r7.b
            com.sina.weibo.sdk.api.TextObject r0 = r0.textObject
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r0.text
            r8.append(r0)
        L_0x002a:
            com.sina.weibo.sdk.api.WeiboMultiMessage r0 = r7.b
            com.sina.weibo.sdk.api.ImageObject r0 = r0.imageObject
            if (r0 == 0) goto L_0x009b
            java.lang.String r1 = r0.imagePath
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0091
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 == 0) goto L_0x0091
            boolean r1 = r2.canRead()
            if (r1 == 0) goto L_0x0091
            long r3 = r2.length()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0091
            long r3 = r2.length()
            int r1 = (int) r3
            byte[] r1 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0076 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0076 }
            r4.read(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            com.sina.weibo.sdk.d0.a((byte[]) r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r4.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x009b
        L_0x006a:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x009b
        L_0x006f:
            r7 = move-exception
            goto L_0x0086
        L_0x0071:
            r1 = move-exception
            r3 = r4
            goto L_0x0077
        L_0x0074:
            r7 = move-exception
            goto L_0x0085
        L_0x0076:
            r1 = move-exception
        L_0x0077:
            r1.printStackTrace()     // Catch:{ all -> 0x0074 }
            if (r3 == 0) goto L_0x0091
            r3.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0091
        L_0x0080:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0091
        L_0x0085:
            r4 = r3
        L_0x0086:
            if (r4 == 0) goto L_0x0090
            r4.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0090:
            throw r7
        L_0x0091:
            byte[] r0 = r0.imageData
            if (r0 == 0) goto L_0x009b
            int r1 = r0.length
            if (r1 <= 0) goto L_0x009b
            com.sina.weibo.sdk.d0.a((byte[]) r0)
        L_0x009b:
            java.lang.String r8 = r8.toString()
            r7.e = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.y.a(android.os.Bundle):void");
    }
}
