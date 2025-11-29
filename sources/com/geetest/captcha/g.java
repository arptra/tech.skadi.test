package com.geetest.captcha;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.views.GTC4WebView;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public h f2855a;
    public GTC4WebView b;
    public l0 c;
    public GTCaptcha4Client.OnDialogShowListener d;

    public g(GTCaptcha4Client.OnDialogShowListener onDialogShowListener) {
        this.d = onDialogShowListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0308 A[Catch:{ Exception -> 0x0325 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x033f A[Catch:{ Exception -> 0x0325 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0342 A[Catch:{ Exception -> 0x0325 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03e0 A[Catch:{ Exception -> 0x03e4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r25, com.geetest.captcha.v r26, com.geetest.captcha.z r27) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            java.lang.String r5 = "url"
            java.lang.String r6 = "utf-8"
            java.lang.String r7 = "mi"
            java.lang.String r8 = "displayMode"
            java.lang.String r9 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r9)
            java.lang.String r10 = "dataBean"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r10)
            java.lang.String r0 = "webViewObserver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.geetest.captcha.y r11 = new com.geetest.captcha.y
            r11.<init>()
            r11.a(r4)
            com.geetest.captcha.f0$a r0 = com.geetest.captcha.f0.c
            java.lang.String r12 = r3.b
            com.geetest.captcha.f0 r0 = r0.a(r12)
            java.lang.String r12 = "description"
            if (r0 != 0) goto L_0x005e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.geetest.captcha.d0 r1 = com.geetest.captcha.d0.PARAM
            java.lang.String r1 = r1.getType()
            r0.append(r1)
            java.lang.String r1 = "75"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = com.geetest.captcha.e0.c
            com.geetest.captcha.w$a r2 = com.geetest.captcha.w.d
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "Address configuration error"
            r2.put(r12, r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r4.a(r0, r1, r2)
            return
        L_0x005e:
            java.lang.String r13 = r0.f2854a
            java.util.Map r14 = r0.b
            java.lang.String r0 = "baseUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            com.geetest.captcha.b0 r0 = com.geetest.captcha.b0.CENTER
            java.lang.String r0 = r0.getValue()
            java.lang.String r4 = "displayArea"
            r15.put(r4, r0)
            java.lang.String r0 = "protocol"
            java.lang.String r4 = "https://"
            r15.put(r0, r4)
            java.lang.String r0 = "loading"
            java.lang.String r4 = "./gt4-loading.gif"
            r15.put(r0, r4)
            java.util.Map r0 = r3.g
            com.geetest.captcha.h0 r4 = com.geetest.captcha.h0.d
            r16 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Config Params: "
            r12.append(r1)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            r12.append(r1)
            java.lang.String r1 = r12.toString()
            r4.a(r1)
            r4 = 0
            if (r0 == 0) goto L_0x012f
            boolean r12 = r0.isEmpty()
            if (r12 == 0) goto L_0x00ae
            goto L_0x012f
        L_0x00ae:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x00b6:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x012d
            java.lang.Object r12 = r0.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r17 = r12.getKey()
            r1 = r17
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r12 = r12.getValue()
            r17 = r0
            java.lang.String r0 = "xid"
            boolean r18 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r18 == 0) goto L_0x00ed
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r18 = r4
            if (r12 == 0) goto L_0x00e8
            boolean r4 = r12 instanceof org.json.JSONObject
            if (r4 == 0) goto L_0x00e8
            r1.put(r0, r12)
        L_0x00e8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            com.geetest.captcha.a0.f2844a = r1
            goto L_0x0128
        L_0x00ed:
            r18 = r4
            java.lang.String r0 = "_gee_info"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0125
            if (r12 == 0) goto L_0x0128
            boolean r0 = r12 instanceof org.json.JSONObject
            if (r0 == 0) goto L_0x0128
            r4 = r12
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r22 = "build"
            java.lang.String r23 = "clientVersion"
            java.lang.String r18 = "geeid"
            java.lang.String r19 = "packageName"
            java.lang.String r20 = "displayName"
            java.lang.String r21 = "appVer"
            java.lang.String[] r0 = new java.lang.String[]{r18, r19, r20, r21, r22, r23}
            r1 = 0
        L_0x0111:
            r12 = 6
            if (r1 >= r12) goto L_0x0122
            r12 = r0[r1]
            boolean r18 = r4.has(r12)
            if (r18 == 0) goto L_0x011f
            r4.remove(r12)
        L_0x011f:
            int r1 = r1 + 1
            goto L_0x0111
        L_0x0122:
            r0 = r17
            goto L_0x00b6
        L_0x0125:
            r15.put(r1, r12)
        L_0x0128:
            r0 = r17
            r4 = r18
            goto L_0x00b6
        L_0x012d:
            r18 = r4
        L_0x012f:
            if (r14 == 0) goto L_0x015a
            java.util.Set r0 = r14.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0139:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0155
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r15.put(r12, r1)
            goto L_0x0139
        L_0x0155:
            r14.clear()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x015a:
            java.lang.String r0 = r3.f2882a
            java.lang.String r1 = "captchaId"
            if (r0 != 0) goto L_0x0163
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0163:
            r15.put(r1, r0)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "challenge"
            r15.put(r1, r0)
            boolean r0 = r3.c
            java.lang.String r1 = "debug"
            r15.put(r1, r0)
            java.lang.String r0 = r3.d
            java.lang.String r1 = "language"
            if (r0 == 0) goto L_0x0191
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0187
            goto L_0x0191
        L_0x0187:
            java.lang.String r0 = r3.d
            r15.put(r1, r0)
            r17 = r10
            r18 = r11
            goto L_0x01f4
        L_0x0191:
            android.content.Context r0 = r25.getApplicationContext()
            java.lang.String r12 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r12 = "context.applicationContext.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.lang.String r12 = "context.applicationContext.resources.configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)
            android.os.LocaleList r0 = r0.getLocales()
            r12 = 0
            java.util.Locale r0 = r0.get(r12)
            java.lang.String r12 = "context.applicationConte….configuration.locales[0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r17 = r10
            java.lang.String r10 = r0.getLanguage()
            r12.append(r10)
            r10 = 45
            r12.append(r10)
            java.lang.String r0 = r0.getCountry()
            java.lang.String r10 = "locale.country"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
            java.util.Locale r10 = java.util.Locale.ROOT
            r18 = r11
            java.lang.String r11 = "Locale.ROOT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            if (r0 == 0) goto L_0x043e
            java.lang.String r0 = r0.toLowerCase(r10)
            java.lang.String r10 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            r15.put(r1, r0)
        L_0x01f4:
            java.lang.String[] r0 = r3.e
            if (r0 == 0) goto L_0x0217
            int r0 = r0.length
            if (r0 != 0) goto L_0x01fc
            goto L_0x0217
        L_0x01fc:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String[] r1 = r3.e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r10 = r1.length
            r11 = 0
        L_0x0208:
            if (r11 >= r10) goto L_0x0212
            r12 = r1[r11]
            r0.put(r12)
            int r11 = r11 + 1
            goto L_0x0208
        L_0x0212:
            java.lang.String r1 = "apiServers"
            r15.put(r1, r0)
        L_0x0217:
            java.lang.String[] r0 = r3.f
            if (r0 == 0) goto L_0x023a
            int r0 = r0.length
            if (r0 != 0) goto L_0x021f
            goto L_0x023a
        L_0x021f:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String[] r1 = r3.f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r10 = r1.length
            r11 = 0
        L_0x022b:
            if (r11 >= r10) goto L_0x0235
            r12 = r1[r11]
            r0.put(r12)
            int r11 = r11 + 1
            goto L_0x022b
        L_0x0235:
            java.lang.String r1 = "staticServers"
            r15.put(r1, r0)
        L_0x023a:
            int r0 = r3.i
            java.lang.String r1 = "timeout"
            r15.put(r1, r0)
            java.lang.String r0 = "clientVersion"
            java.lang.String r1 = "1.8.3.1"
            r15.put(r0, r1)
            java.lang.String r10 = "clientType"
            java.lang.String r11 = "android"
            r15.put(r10, r11)
            boolean r10 = r3.h
            java.lang.String r11 = "outside"
            r15.put(r11, r10)
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fb }
            r10.<init>()     // Catch:{ Exception -> 0x02fb }
            java.lang.String r11 = "geeid"
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fb }
            r19 = r5
            com.geetest.captcha.j r5 = com.geetest.captcha.j.a.f2863a     // Catch:{ Exception -> 0x02f7 }
            java.lang.String r5 = r5.a(r2)     // Catch:{ Exception -> 0x02f7 }
            r12.<init>(r5)     // Catch:{ Exception -> 0x02f7 }
            r10.put(r11, r12)     // Catch:{ Exception -> 0x02f7 }
            java.lang.String r5 = "packageName"
            java.lang.String r11 = r25.getPackageName()     // Catch:{ Exception -> 0x02f7 }
            r10.put(r5, r11)     // Catch:{ Exception -> 0x02f7 }
            android.content.pm.PackageManager r5 = r25.getPackageManager()     // Catch:{ Exception -> 0x02f7 }
            java.lang.String r11 = r25.getPackageName()     // Catch:{ Exception -> 0x02f7 }
            r12 = 0
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r11, r12)     // Catch:{ Exception -> 0x02f7 }
            android.content.pm.PackageManager r11 = r25.getPackageManager()     // Catch:{ Exception -> 0x02f7 }
            java.lang.CharSequence r5 = r5.loadLabel(r11)     // Catch:{ Exception -> 0x02f7 }
            java.lang.String r11 = "context.packageManager.g…l(context.packageManager)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r11)     // Catch:{ Exception -> 0x02f7 }
            android.content.pm.PackageManager r11 = r25.getPackageManager()     // Catch:{ Exception -> 0x02f7 }
            java.lang.String r12 = r25.getPackageName()     // Catch:{ Exception -> 0x02f7 }
            r20 = r13
            r13 = 0
            android.content.pm.PackageInfo r11 = r11.getPackageInfo(r12, r13)     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r12 = "displayName"
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r5 = java.net.URLEncoder.encode(r5, r6)     // Catch:{ Exception -> 0x02e6 }
            r10.put(r12, r5)     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r5 = "appVer"
            java.lang.String r12 = r11.versionName     // Catch:{ Exception -> 0x02e6 }
            r10.put(r5, r12)     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r5 = "build"
            int r11 = r11.versionCode     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x02e6 }
            r10.put(r5, r11)     // Catch:{ Exception -> 0x02e6 }
            r10.put(r0, r1)     // Catch:{ Exception -> 0x02e6 }
            if (r4 == 0) goto L_0x02e8
            int r0 = r4.length()     // Catch:{ Exception -> 0x02e6 }
            if (r0 <= 0) goto L_0x02e8
            java.util.Iterator r0 = r4.keys()     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r1 = "keys"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x02e6 }
        L_0x02d2:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x02e6 }
            if (r1 == 0) goto L_0x02e8
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x02e6 }
            java.lang.Object r5 = r4.opt(r1)     // Catch:{ Exception -> 0x02e6 }
            r10.put(r1, r5)     // Catch:{ Exception -> 0x02e6 }
            goto L_0x02d2
        L_0x02e6:
            r0 = move-exception
            goto L_0x02ff
        L_0x02e8:
            java.lang.String r0 = "zid"
            com.geetest.captcha.k0 r1 = com.geetest.captcha.k0.f2865a     // Catch:{ Exception -> 0x02e6 }
            java.lang.String r1 = r1.a(r2)     // Catch:{ Exception -> 0x02e6 }
            r10.put(r0, r1)     // Catch:{ Exception -> 0x02e6 }
            r15.put(r7, r10)     // Catch:{ Exception -> 0x02e6 }
            goto L_0x0302
        L_0x02f7:
            r0 = move-exception
        L_0x02f8:
            r20 = r13
            goto L_0x02ff
        L_0x02fb:
            r0 = move-exception
            r19 = r5
            goto L_0x02f8
        L_0x02ff:
            r0.printStackTrace()
        L_0x0302:
            boolean r0 = r15.has(r8)     // Catch:{ Exception -> 0x0325 }
            if (r0 == 0) goto L_0x0327
            java.lang.Object r0 = r15.get(r8)     // Catch:{ Exception -> 0x0325 }
            boolean r0 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0325 }
            if (r0 == 0) goto L_0x034f
            java.lang.Object r0 = r15.get(r8)     // Catch:{ Exception -> 0x0325 }
            com.geetest.captcha.c0 r1 = com.geetest.captcha.c0.AUTO     // Catch:{ Exception -> 0x0325 }
            int r1 = r1.getValue()     // Catch:{ Exception -> 0x0325 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0325 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0325 }
            if (r0 == 0) goto L_0x034f
            goto L_0x0327
        L_0x0325:
            r0 = move-exception
            goto L_0x034c
        L_0x0327:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r9)     // Catch:{ Exception -> 0x0325 }
            android.content.res.Resources r0 = r25.getResources()     // Catch:{ Exception -> 0x0325 }
            java.lang.String r1 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0325 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x0325 }
            int r0 = r0.uiMode     // Catch:{ Exception -> 0x0325 }
            r0 = r0 & 48
            r1 = 32
            if (r0 != r1) goto L_0x0342
            com.geetest.captcha.c0 r0 = com.geetest.captcha.c0.DARK     // Catch:{ Exception -> 0x0325 }
            goto L_0x0344
        L_0x0342:
            com.geetest.captcha.c0 r0 = com.geetest.captcha.c0.NORMAL     // Catch:{ Exception -> 0x0325 }
        L_0x0344:
            int r0 = r0.getValue()     // Catch:{ Exception -> 0x0325 }
            r15.put(r8, r0)     // Catch:{ Exception -> 0x0325 }
            goto L_0x034f
        L_0x034c:
            r0.printStackTrace()
        L_0x034f:
            com.geetest.captcha.h0 r0 = com.geetest.captcha.h0.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "BaseURL: "
            r1.append(r4)
            java.lang.String r5 = r3.b
            r1.append(r5)
            java.lang.String r5 = ", Parameter: "
            r1.append(r5)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.a(r1)
            org.json.JSONObject r1 = new org.json.JSONObject
            java.lang.String r8 = r15.toString()
            r1.<init>(r8)
            boolean r8 = r1.has(r7)
            if (r8 == 0) goto L_0x0381
            r1.remove(r7)
        L_0x0381:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = r3.b
            r7.append(r4)
            r7.append(r5)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            r0.e(r1)
            java.lang.String r0 = r15.toString()
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r6)
            java.lang.String r1 = "name"
            java.lang.String r4 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            if (r14 == 0) goto L_0x03af
            r14.put(r4, r0)
        L_0x03af:
            com.geetest.captcha.l0$a r0 = new com.geetest.captcha.l0$a     // Catch:{ Exception -> 0x03e4 }
            r0.<init>()     // Catch:{ Exception -> 0x03e4 }
            com.geetest.captcha.f0 r1 = new com.geetest.captcha.f0     // Catch:{ Exception -> 0x03e4 }
            r4 = r20
            r1.<init>(r4, r14)     // Catch:{ Exception -> 0x03e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03e4 }
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)     // Catch:{ Exception -> 0x03e4 }
            r0.f2869a = r1     // Catch:{ Exception -> 0x03e4 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r9)     // Catch:{ Exception -> 0x03e4 }
            java.lang.String r1 = "observable"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch:{ Exception -> 0x03e4 }
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)     // Catch:{ Exception -> 0x03e4 }
            com.geetest.captcha.views.GTC4WebView r1 = new com.geetest.captcha.views.GTC4WebView     // Catch:{ Exception -> 0x03e4 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x03e4 }
            r0.c = r1     // Catch:{ Exception -> 0x03e4 }
            java.lang.String r2 = r0.f2869a     // Catch:{ Exception -> 0x03e4 }
            if (r2 != 0) goto L_0x03e6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ Exception -> 0x03e4 }
            goto L_0x03e6
        L_0x03e4:
            r0 = move-exception
            goto L_0x03fd
        L_0x03e6:
            r1.a(r5, r3, r2)     // Catch:{ Exception -> 0x03e4 }
            r0.b = r5     // Catch:{ Exception -> 0x03e4 }
            com.geetest.captcha.l0 r1 = new com.geetest.captcha.l0     // Catch:{ Exception -> 0x03e4 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x03e4 }
            com.geetest.captcha.l0 r0 = r1.a()     // Catch:{ Exception -> 0x03e4 }
            r1 = r24
            r1.c = r0     // Catch:{ Exception -> 0x03e4 }
            com.geetest.captcha.views.GTC4WebView r0 = r0.c     // Catch:{ Exception -> 0x03e4 }
            r1.b = r0     // Catch:{ Exception -> 0x03e4 }
            goto L_0x043d
        L_0x03fd:
            r0.printStackTrace()
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x043d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.geetest.captcha.d0 r2 = com.geetest.captcha.d0.WEB_VIEW_NEW
            java.lang.String r2 = r2.getType()
            r1.append(r2)
            java.lang.String r2 = "99"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = com.geetest.captcha.e0.e
            com.geetest.captcha.w$a r3 = com.geetest.captcha.w.d
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "Device not supported"
            r5 = r16
            r3.put(r5, r4)
            java.lang.String r0 = r0.getMessage()
            java.lang.String r4 = "exception"
            r3.put(r4, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r4 = r27
            r4.a(r1, r2, r3)
        L_0x043d:
            return
        L_0x043e:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.g.a(android.content.Context, com.geetest.captcha.v, com.geetest.captcha.z):void");
    }

    public final void b(Context context, v vVar, z zVar) {
        h hVar;
        if (TextUtils.isEmpty(vVar.k)) {
            hVar = new h(context);
        } else {
            String str = vVar.k;
            hVar = str != null ? new h(context, str) : null;
        }
        this.f2855a = hVar;
        if (hVar != null) {
            hVar.b = this.d;
        }
        if (hVar != null) {
            hVar.f2857a = this.b;
        }
        if (hVar != null) {
            hVar.setOnKeyListener(new e(zVar));
        }
        h hVar2 = this.f2855a;
        if (hVar2 != null) {
            hVar2.show();
        }
    }
}
