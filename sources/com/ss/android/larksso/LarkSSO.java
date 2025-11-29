package com.ss.android.larksso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.meizu.common.util.LunarCalendar;
import com.ss.android.larksso.uploadLog.LogUpload;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@NotProguard
public class LarkSSO {

    /* renamed from: a  reason: collision with root package name */
    public String f10002a;
    public IGetDataCallback b;
    public Activity c;
    public Builder d;
    public String e;
    public ArrayList f;
    public RequestData g;

    @NotProguard
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f10003a;
        public String b;
        public Activity c;
        public String d;
        public String e = "";
        public String f = "";
        public boolean g = false;
        public boolean h = false;
        public ArrayList i = new ArrayList();

        public String j() {
            return this.e;
        }

        public Builder k(String str) {
            this.f10003a = str;
            return this;
        }

        public Builder l(boolean z) {
            this.g = z;
            return this;
        }

        public Builder m(Activity activity) {
            this.c = activity;
            this.e = LarkSSO.f(activity, this.e);
            return this;
        }

        public Builder n(String str) {
            this.e = str;
            return this;
        }

        public Builder o(String str) {
            this.d = str;
            return this;
        }

        public Builder p(ArrayList arrayList) {
            this.i = arrayList;
            return this;
        }

        public Builder q(String str) {
            this.b = str;
            return this;
        }
    }

    public static class HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static final LarkSSO f10004a = new LarkSSO();
    }

    public LarkSSO() {
        this.f = new ArrayList();
        this.g = new RequestData();
    }

    public static String f(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences("ssoDeviceID", 0);
        String string = sharedPreferences.getString("device_id", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String p = p();
        Log.i("LarkSSO", "build deviceID:" + p);
        edit.putString("device_id", p);
        edit.commit();
        return p;
    }

    public static String p() {
        return UUID.randomUUID().toString().replace(LunarCalendar.DATE_SEPARATOR, "");
    }

    public static LarkSSO x() {
        return HOLDER.f10004a;
    }

    public static boolean y(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 1).size() > 0;
    }

    public final void A(String str, String str2, String str3, boolean z) {
        LogUpload.g = str;
        LogUpload.h = str2;
        LogUpload.i = str3;
        LogUpload.j = z;
        try {
            LogUpload.k = new URL(LogUpload.j ? "https://internal-api.feishu.cn/collect/log/v1/" : "https://internal-api.larksuite.com/collect/log/v1/");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
    }

    public final byte[] B(String str, String str2) {
        if (str != null && str.length() > 0) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes());
                return instance.digest();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return new byte[0];
    }

    public synchronized void C(Builder builder, IGetDataCallback iGetDataCallback) {
        this.d = builder;
        this.c = builder.c;
        this.b = iGetDataCallback;
        if (!h()) {
            Log.e("LarkSSO", "The parameter is not correct");
        } else {
            k();
        }
    }

    public final String D(String str) {
        try {
            this.f.add(this.g);
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            LogUpload.a("LarkSSO", "URL encoding failed");
            l(SSOErrorType.PARAMETER_ERROR.f10011a, "");
            return str;
        }
    }

    public final void E(String str, String str2) {
        if (this.b != null) {
            this.b.a(new CallBackData(str, str2));
            this.b = null;
        }
    }

    public final String b(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : Base64.encodeToString(bArr, 11);
    }

    public final void c() {
        String p = p();
        this.f10002a = p;
        this.g.b = p;
    }

    public final String d() {
        return D(String.format("https://%s/%s?%s=%s&%s=%s&%s=%s&%s=%s&sdk_platform=Android&source=sso_web&sso_sdk=1&safety_mode=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", new Object[]{o(), "suite/passport/sdk/oauth", "app_id", this.d.f10003a, AuthWebviewActivity.g, "code", "state", this.f10002a, "lang", u(), 1L, "code_challenge_method", "S256", "code_challenge", m(), AuthWebviewActivity.f, q(), "scope", n(), AuthWebviewActivity.m, s()}));
    }

    public final String e() {
        return D(String.format("https://%s/%s?%s=%s&%s=%s&%s=%s&%s=%s&sdk_platform=Android&source=sso_web&sso_sdk=1&safety_mode=%s", new Object[]{o(), "suite/passport/sdk/oauth", "app_id", this.d.f10003a, AuthWebviewActivity.g, "code", "state", this.f10002a, "lang", u(), 1L}));
    }

    public final void g(Uri uri) {
        SSOErrorType sSOErrorType;
        if (uri != null && uri.toString().contains("state") && uri.toString().contains("code")) {
            LogUpload.a("LarkSSO", "The returned scheme is:" + uri.toString());
            if (TextUtils.isEmpty(uri.getQueryParameter("code"))) {
                LogUpload.a("LarkSSO", "No valid code");
                l(SSOErrorType.NO_VALID_CODE.f10011a, "");
                return;
            }
            if (j(uri)) {
                String queryParameter = uri.getQueryParameter("code");
                if ("/cancel".equalsIgnoreCase(uri.getPath())) {
                    LogUpload.a("LarkSSO", "User cancels the authorization, the code returned is:" + queryParameter);
                    sSOErrorType = SSOErrorType.CANCELLED;
                } else if ("/failure".equalsIgnoreCase(uri.getPath())) {
                    String queryParameter2 = uri.getQueryParameter("err_code");
                    LogUpload.a("LarkSSO", "User authorization failed, the code is:" + queryParameter + ", The error code is" + queryParameter2);
                    sSOErrorType = SSOErrorType.AUTH_FAILED;
                } else {
                    LogUpload.a("LarkSSO", "User authorization is successful, the code is:" + queryParameter);
                    E(queryParameter, r(uri));
                }
                l(sSOErrorType.f10011a, r(uri));
            } else {
                LogUpload.a("LarkSSO", "Authorization failed, state is inconsistent, now state is:" + this.f10002a);
                l(SSOErrorType.BAD_STATE.f10011a, "");
            }
            this.f.clear();
        }
    }

    public final boolean h() {
        Builder builder = this.d;
        if (builder != null && !TextUtils.isEmpty(builder.f10003a) && !TextUtils.isEmpty(this.d.b) && (("Feishu".equals(this.d.b) || "Lark".equals(this.d.b)) && !TextUtils.isEmpty(this.d.e))) {
            return true;
        }
        l(SSOErrorType.PARAMETER_ERROR.f10011a, "");
        return false;
    }

    public final boolean i(Uri uri, int i) {
        return !this.f.isEmpty() && this.f.get(i) != null && !TextUtils.isEmpty(((RequestData) this.f.get(i)).b) && ((RequestData) this.f.get(i)).b.equals(t(uri));
    }

    public final boolean j(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(t(uri)) && !this.f.isEmpty()) {
            for (int i = 0; i < this.f.size(); i++) {
                if (i(uri, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a8, code lost:
        if (com.ss.android.larksso.LarkSSO.Builder.h(r4.d) == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00af, code lost:
        r0 = e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x008a, code lost:
        if (com.ss.android.larksso.LarkSSO.Builder.h(r4.d) != false) goto L_0x00aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k() {
        /*
            r4 = this;
            r4.c()
            com.ss.android.larksso.LarkSSO$Builder r0 = r4.d
            java.lang.String r0 = r0.e
            java.lang.String r1 = r4.f10002a
            com.ss.android.larksso.LarkSSO$Builder r2 = r4.d
            java.lang.String r2 = r2.b
            java.lang.String r3 = "Feishu"
            boolean r2 = r2.equals(r3)
            java.lang.String r3 = "1161"
            r4.A(r3, r0, r1, r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "appId:"
            r0.append(r1)
            com.ss.android.larksso.LarkSSO$Builder r1 = r4.d
            java.lang.String r1 = r1.f10003a
            r0.append(r1)
            java.lang.String r1 = ",deviceId:"
            r0.append(r1)
            com.ss.android.larksso.LarkSSO$Builder r1 = r4.d
            java.lang.String r1 = r1.e
            r0.append(r1)
            java.lang.String r1 = ",testUnit:"
            r0.append(r1)
            com.ss.android.larksso.LarkSSO$Builder r1 = r4.d
            java.lang.String r1 = r1.f
            r0.append(r1)
            java.lang.String r1 = ",server:"
            r0.append(r1)
            com.ss.android.larksso.LarkSSO$Builder r1 = r4.d
            java.lang.String r1 = r1.b
            r0.append(r1)
            java.lang.String r1 = ",useWeb:"
            r0.append(r1)
            com.ss.android.larksso.LarkSSO$Builder r1 = r4.d
            boolean r1 = r1.h
            r0.append(r1)
            java.lang.String r1 = ",sdkVersion:"
            r0.append(r1)
            java.lang.String r1 = r4.s()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "LarkSSO"
            com.ss.android.larksso.uploadLog.LogUpload.a(r1, r0)
            com.ss.android.larksso.LarkSSO$Builder r0 = r4.d
            boolean r0 = r0.h
            if (r0 == 0) goto L_0x008d
            com.ss.android.larksso.LarkSSO$Builder r0 = r4.d
            boolean r0 = r0.g
            if (r0 == 0) goto L_0x00af
            goto L_0x00aa
        L_0x008d:
            com.ss.android.larksso.LarkSSO$Builder r0 = r4.d     // Catch:{ all -> 0x00a2 }
            boolean r0 = r0.g     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = r4.d()     // Catch:{ all -> 0x00a2 }
            goto L_0x009e
        L_0x009a:
            java.lang.String r0 = r4.e()     // Catch:{ all -> 0x00a2 }
        L_0x009e:
            r4.v(r0)     // Catch:{ all -> 0x00a2 }
            goto L_0x00b6
        L_0x00a2:
            com.ss.android.larksso.LarkSSO$Builder r0 = r4.d
            boolean r0 = r0.g
            if (r0 == 0) goto L_0x00af
        L_0x00aa:
            java.lang.String r0 = r4.d()
            goto L_0x00b3
        L_0x00af:
            java.lang.String r0 = r4.e()
        L_0x00b3:
            r4.w(r0)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.larksso.LarkSSO.k():void");
    }

    public void l(String str, String str2) {
        if (this.b != null) {
            this.b.b(new CallBackData(str, str2));
            this.b = null;
        }
    }

    public final String m() {
        String b2 = b(p().getBytes());
        this.e = b2;
        String b3 = b(B(b2, MessageDigestAlgorithms.SHA_256));
        this.g.f10010a = this.e;
        return b3;
    }

    public final String n() {
        String str = new String();
        Builder builder = this.d;
        if (builder == null || builder.i == null) {
            return "";
        }
        for (int i = 0; i < this.d.i.size(); i++) {
            str = str.concat((String) this.d.i.get(i)).concat(" ");
        }
        return str.trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String o() {
        /*
            r4 = this;
            com.ss.android.larksso.LarkSSO$Builder r0 = r4.d
            java.lang.String r0 = r0.f
            int r1 = r0.hashCode()
            r2 = -1897523141(0xffffffff8ee6183b, float:-5.672271E-30)
            r3 = 1
            if (r1 == r2) goto L_0x002f
            r2 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r1 == r2) goto L_0x0025
            r2 = 97720(0x17db8, float:1.36935E-40)
            if (r1 == r2) goto L_0x001b
            goto L_0x0039
        L_0x001b:
            java.lang.String r1 = "boe"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0039
            r0 = r3
            goto L_0x003a
        L_0x0025:
            java.lang.String r1 = "normal"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0039
            r0 = 2
            goto L_0x003a
        L_0x002f:
            java.lang.String r1 = "staging"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0039
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = -1
        L_0x003a:
            java.lang.String r1 = "Feishu"
            com.ss.android.larksso.LarkSSO$Builder r4 = r4.d
            java.lang.String r4 = r4.b
            boolean r4 = r1.equals(r4)
            if (r0 == 0) goto L_0x005a
            if (r0 == r3) goto L_0x0052
            if (r4 == 0) goto L_0x004f
            java.lang.String r4 = "passport.feishu.cn"
            goto L_0x0051
        L_0x004f:
            java.lang.String r4 = "passport.larksuite.com"
        L_0x0051:
            return r4
        L_0x0052:
            if (r4 == 0) goto L_0x0057
            java.lang.String r4 = "passport.feishu-boe.cn"
            goto L_0x0059
        L_0x0057:
            java.lang.String r4 = "passport.larksuite-boe.cn"
        L_0x0059:
            return r4
        L_0x005a:
            if (r4 == 0) goto L_0x005f
            java.lang.String r4 = "passport.feishu-staging.cn"
            goto L_0x0061
        L_0x005f:
            java.lang.String r4 = "passport.larksuite-staging.com"
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.larksso.LarkSSO.o():java.lang.String");
    }

    public final String q() {
        Builder builder = this.d;
        return (builder == null || TextUtils.isEmpty(builder.f10003a)) ? "" : this.d.f10003a.concat("://").concat("oauth");
    }

    public final String r(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(t(uri)) && !this.f.isEmpty()) {
            for (int i = 0; i < this.f.size(); i++) {
                if (i(uri, i)) {
                    return ((RequestData) this.f.get(i)).f10010a;
                }
            }
        }
        return "";
    }

    public final String s() {
        return "3.0.1";
    }

    public final CharSequence t(Uri uri) {
        return uri == null ? "" : uri.getQueryParameter("state");
    }

    public final String u() {
        return !TextUtils.isEmpty(this.d.d) ? this.d.d : !TextUtils.isEmpty(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "zh";
    }

    public final void v(String str) {
        LogUpload.a("LarkSSO", "Feishu/Lark installed, jump verification");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("lark://ssoclient/web?url=".concat(str)));
        intent.putExtra("internal", true);
        if (y(this.c, intent)) {
            this.c.startActivityForResult(intent, 0);
        } else {
            w(str);
        }
    }

    public final void w(String str) {
        LogUpload.a("LarkSSO", "Feishu/Lark is not installed, downgrade operation");
        Intent intent = new Intent(this.c, LarkSSOActivity.class);
        intent.putExtra("build_url", str);
        this.c.startActivityForResult(intent, 0);
    }

    public void z(Activity activity, Intent intent) {
        if (intent != null) {
            g(intent.getData());
            if (activity.getIntent().getData() != null) {
                activity.getIntent().setData((Uri) null);
            }
        }
    }
}
