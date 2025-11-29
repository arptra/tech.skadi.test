package com.ss.android.larksso;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.ss.android.larksso.uploadLog.LogUpload;
import java.util.List;

public class LarkSSOActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public WebView f10005a;
    public String b;

    public class LarkSSOWebViewClient extends WebViewClient {
        public LarkSSOWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (LarkSSOActivity.o0(LarkSSOActivity.this, str)) {
                CookieSyncManager createInstance = CookieSyncManager.createInstance(LarkSSOActivity.this.f10005a.getContext());
                CookieManager instance = CookieManager.getInstance();
                instance.setAcceptCookie(true);
                instance.removeSessionCookie();
                instance.removeAllCookie();
                createInstance.sync();
                LarkSSOActivity larkSSOActivity = LarkSSOActivity.this;
                larkSSOActivity.getClass();
                try {
                    Intent intent = larkSSOActivity.getIntent();
                    intent.setData(Uri.parse(str));
                    larkSSOActivity.setResult(-1, intent);
                    LogUpload.a("LarkSSOActivity", "successCallBack, Jump back from WebView successfully");
                    larkSSOActivity.finish();
                } catch (Exception unused) {
                    LogUpload.a("LarkSSOActivity", "successCallBack, Jump back to SSOSDK failed");
                }
                return true;
            } else if (TextUtils.isEmpty(str) || !str.contains("https://www.feishu.cn/download")) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.setData(Uri.parse("https://www.feishu.cn/download"));
                LarkSSOActivity.this.startActivity(intent2);
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = android.net.Uri.parse(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean o0(com.ss.android.larksso.LarkSSOActivity r1, java.lang.String r2) {
        /*
            r1.getClass()
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x000a
            goto L_0x0037
        L_0x000a:
            android.net.Uri r1 = android.net.Uri.parse(r2)
            if (r1 != 0) goto L_0x0011
            goto L_0x0037
        L_0x0011:
            java.lang.String r2 = r1.getHost()
            java.lang.String r0 = "oauth"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0037
            java.lang.String r2 = "state"
            java.lang.String r2 = r1.getQueryParameter(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0037
            java.lang.String r2 = "code"
            java.lang.String r1 = r1.getQueryParameter(r2)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0037
            r1 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.larksso.LarkSSOActivity.o0(com.ss.android.larksso.LarkSSOActivity, java.lang.String):boolean");
    }

    public final void n0() {
        try {
            Uri parse = Uri.parse(this.b);
            String format = String.format("%s://oauth/cancel?state=%s&code=%s", new Object[]{parse.getQueryParameter("app_id"), parse.getQueryParameter("state"), SSOErrorType.CANCELLED.f10011a});
            Intent intent = getIntent();
            intent.setData(Uri.parse(format));
            setResult(0, intent);
            finish();
        } catch (Exception unused) {
            LogUpload.a("LarkSSOActivity", "cancelCallBack, Jump back to SSOSDK failed");
        }
    }

    public void onBackPressed() {
        CookieSyncManager createInstance = CookieSyncManager.createInstance(this.f10005a.getContext());
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.removeSessionCookie();
        instance.removeAllCookie();
        createInstance.sync();
        n0();
        super.onBackPressed();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00c2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            int r6 = com.ss.android.larksso.R.layout.activity_lark_sso
            r5.setContentView((int) r6)
            java.lang.String r6 = "#ffffff"
            int r6 = android.graphics.Color.parseColor(r6)
            com.githang.statusbar.StatusBarCompat.b(r5, r6)
            androidx.appcompat.app.ActionBar r6 = r5.getSupportActionBar()
            if (r6 == 0) goto L_0x001a
            r6.g()
        L_0x001a:
            int r6 = com.ss.android.larksso.R.id.btn_close_window
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            com.ss.android.larksso.LarkSSOActivity$1 r0 = new com.ss.android.larksso.LarkSSOActivity$1
            r0.<init>()
            r6.setOnClickListener(r0)
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r0 = "build_url"
            java.lang.String r1 = r6.getStringExtra(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x003e
            r5.finish()
            return
        L_0x003e:
            java.lang.String r6 = r6.getStringExtra(r0)
            r5.b = r6
            android.content.ComponentName r6 = r5.getCallingActivity()
            r0 = 0
            java.lang.String r1 = "LarkSSOActivity"
            if (r6 != 0) goto L_0x004e
            goto L_0x00b7
        L_0x004e:
            android.content.ComponentName r6 = r5.getCallingActivity()
            java.lang.String r6 = r6.getPackageName()
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0088
            java.util.List r2 = com.ss.android.larksso.SignatureUtils.a(r5, r6)
            if (r2 == 0) goto L_0x0082
            int r4 = r2.size()
            if (r4 != 0) goto L_0x006b
            goto L_0x0082
        L_0x006b:
            java.lang.Object r4 = r2.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r5.s0(r6, r4)
            if (r4 == 0) goto L_0x007f
            java.lang.Object r2 = r2.get(r0)
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x008b
        L_0x007f:
            java.lang.String r2 = "Package name and signature verification failed"
            goto L_0x0084
        L_0x0082:
            java.lang.String r2 = "the md5 list is null"
        L_0x0084:
            android.util.Log.i(r1, r2)
            goto L_0x008b
        L_0x0088:
            java.lang.String r2 = "the PackageName is null"
            goto L_0x0084
        L_0x008b:
            java.lang.String r2 = "package_id"
            java.lang.String r4 = "signature"
            java.lang.Object[] r6 = new java.lang.Object[]{r2, r6, r4, r3}
            java.lang.String r2 = "&%s=%s&%s=%s"
            java.lang.String r6 = java.lang.String.format(r2, r6)
            java.lang.String r2 = r5.b
            java.lang.String r6 = r2.concat(r6)
            r5.b = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "buildUrl is:"
            r6.append(r2)
            java.lang.String r2 = r5.b
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r1, r6)
        L_0x00b7:
            java.lang.String r6 = r5.b     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r2 = "UTF-8"
            java.lang.String r6 = java.net.URLDecoder.decode(r6, r2)     // Catch:{ Exception -> 0x00c2 }
            r5.b = r6     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00f9
        L_0x00c2:
            java.lang.String r6 = r5.b     // Catch:{ Exception -> 0x00f4 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r2 = "app_id"
            java.lang.String r2 = r6.getQueryParameter(r2)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r3 = "state"
            java.lang.String r6 = r6.getQueryParameter(r3)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r3 = "%s://oauth/failure?state=%s&code=%s&err_code=0"
            com.ss.android.larksso.SSOErrorType r4 = com.ss.android.larksso.SSOErrorType.AUTH_FAILED     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r4 = r4.f10011a     // Catch:{ Exception -> 0x00f4 }
            java.lang.Object[] r6 = new java.lang.Object[]{r2, r6, r4}     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r6 = java.lang.String.format(r3, r6)     // Catch:{ Exception -> 0x00f4 }
            android.content.Intent r2 = r5.getIntent()     // Catch:{ Exception -> 0x00f4 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x00f4 }
            r2.setData(r6)     // Catch:{ Exception -> 0x00f4 }
            r5.setResult(r0, r2)     // Catch:{ Exception -> 0x00f4 }
            r5.finish()     // Catch:{ Exception -> 0x00f4 }
            goto L_0x00f9
        L_0x00f4:
            java.lang.String r6 = "errorCallBack, Jump back to SSOSDK failed"
            com.ss.android.larksso.uploadLog.LogUpload.a(r1, r6)
        L_0x00f9:
            int r6 = com.ss.android.larksso.R.id.sso_webView
            android.view.View r6 = r5.findViewById(r6)
            android.webkit.WebView r6 = (android.webkit.WebView) r6
            r5.f10005a = r6
            android.webkit.WebSettings r6 = r6.getSettings()
            r0 = 1
            r6.setJavaScriptEnabled(r0)
            android.webkit.WebView r6 = r5.f10005a
            com.ss.android.larksso.LarkSSOActivity$LarkSSOWebViewClient r0 = new com.ss.android.larksso.LarkSSOActivity$LarkSSOWebViewClient
            r0.<init>()
            r6.setWebViewClient(r0)
            android.webkit.WebView r6 = r5.f10005a
            android.webkit.WebChromeClient r0 = new android.webkit.WebChromeClient
            r0.<init>()
            r6.setWebChromeClient(r0)
            android.webkit.WebView r6 = r5.f10005a
            java.lang.String r5 = r5.b
            com.ss.android.larksso.LoadUrlUtil$BaseImpl r0 = com.ss.android.larksso.LoadUrlUtil.f10008a
            r0.a(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.larksso.LarkSSOActivity.onCreate(android.os.Bundle):void");
    }

    public final boolean s0(String str, String str2) {
        List<String> a2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a2 = SignatureUtils.a(this, str)) == null || a2.size() <= 0) {
            return false;
        }
        for (String equalsIgnoreCase : a2) {
            if (str2.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }
}
