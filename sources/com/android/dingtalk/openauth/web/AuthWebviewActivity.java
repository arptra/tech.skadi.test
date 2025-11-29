package com.android.dingtalk.openauth.web;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.android.dingtalk.openauth.R;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.android.dingtalk.openauth.utils.DDAuthUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AuthWebviewActivity extends BaseCommonActivity {
    public static final String f = "redirect_uri";
    public static final String g = "response_type";
    public static final String h = "client_id";
    public static final String i = "scope";
    public static final String j = "nonce";
    public static final String k = "state";
    public static final String l = "prompt";
    public static final String m = "sdk_version";
    public static final String n = "identifier";
    public static final String o = "signature";
    public static final String p = "client_type";
    public static final String q = "android";

    /* renamed from: a  reason: collision with root package name */
    public WebView f2353a;
    public ImageView b;
    public ImageView c;
    public String d;
    public String e;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            AuthWebviewActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            AuthWebviewActivity.this.onBackPressed();
        }
    }

    public class c extends WebViewClient {
        public c() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AuthWebviewActivity.this.m();
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest != null && webResourceError != null) {
                a.a.a.a.a.c.a("WebView, onReceivedError, request = " + webResourceRequest.getUrl() + ", errorCode = " + webResourceError.getErrorCode() + ", errorDescription = " + webResourceError.getDescription());
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            a.a.a.a.a.c.a("WebView, onReceivedHttpError, request = " + webResourceRequest.getUrl() + ", errorCode = " + webResourceResponse.getStatusCode() + ", errorDescription = " + webResourceResponse.getReasonPhrase());
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (sslError != null) {
                a.a.a.a.a.c.a("WebView, onReceivedSslError, error = " + sslError.toString());
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String host;
            Uri url = webResourceRequest.getUrl();
            if (url == null || TextUtils.isEmpty(AuthWebviewActivity.this.d) || (host = url.getHost()) == null || !AuthWebviewActivity.this.d.contains(host)) {
                return false;
            }
            AuthWebviewActivity authWebviewActivity = AuthWebviewActivity.this;
            a.a.a.a.a.a.d(authWebviewActivity, authWebviewActivity.e, url, DDAuthConstant.AUTH_LOGIN_TYPE_WEB);
            AuthWebviewActivity.this.finish();
            return true;
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            if (AuthWebviewActivity.this.b != null) {
                AuthWebviewActivity.this.b.setVisibility(AuthWebviewActivity.this.j() ? 0 : 8);
            }
        }
    }

    private void h() {
        Intent intent = getIntent();
        this.d = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_REDIRECT_URI);
        this.e = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_APP_PACKAGE_NAME);
    }

    private void i() {
        ImageView imageView = (ImageView) findViewById(R.id.close_icon);
        this.b = imageView;
        imageView.setOnClickListener(new a());
        ImageView imageView2 = (ImageView) findViewById(R.id.back_icon);
        this.c = imageView2;
        imageView2.setOnClickListener(new b());
        this.f2353a = (WebView) findViewById(R.id.webview);
    }

    /* access modifiers changed from: private */
    public boolean j() {
        WebView webView = this.f2353a;
        return webView != null && webView.canGoBack();
    }

    private void k() {
        Method method;
        if (DDAuthUtil.isDebug(this)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        WebSettings settings = this.f2353a.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAppCacheMaxSize(8388608);
        settings.setCacheMode(-1);
        settings.setAppCachePath(getDir("cache", 0).getPath());
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setDisplayZoomControls(false);
        try {
            method = WebSettings.class.getMethod("setHardwareAccelSkiaEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(settings, new Object[]{Boolean.TRUE});
            } catch (IllegalAccessException | InvocationTargetException unused) {
                a.a.a.a.a.c.a("call WebView setHardwareAccelSkiaEnabled error");
            }
        }
    }

    private void l() {
        this.f2353a.setWebViewClient(new c());
    }

    /* access modifiers changed from: private */
    public void m() {
        runOnUiThread(new d());
    }

    public void onBackPressed() {
        if (j()) {
            this.f2353a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h();
        i();
        d();
        this.f2353a.loadUrl(e());
    }

    private void d() {
        this.f2353a.setHorizontalScrollBarEnabled(false);
        this.f2353a.setVerticalFadingEdgeEnabled(false);
        k();
        l();
    }

    private String e() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_APP_SIGNATURE);
        String stringExtra2 = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_APP_ID);
        String stringExtra3 = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_STATE);
        String stringExtra4 = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_NONCE);
        String stringExtra5 = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_SCOPE);
        String stringExtra6 = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_RESPONSE_TYPE);
        String stringExtra7 = intent.getStringExtra(DDAuthConstant.EXTRA_MESSAGE_PROMPT);
        int intExtra = intent.getIntExtra(DDAuthConstant.EXTRA_MESSAGE_SDK_VERSION, 0);
        Uri parse = Uri.parse(DDAuthUtil.getAuthLoginUrl(this));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        builder.query(parse.getQuery());
        builder.fragment(parse.getFragment());
        a(builder, f, this.d);
        a(builder, g, stringExtra6);
        a(builder, "client_id", stringExtra2);
        a(builder, "scope", stringExtra5);
        a(builder, "nonce", stringExtra4);
        a(builder, "state", stringExtra3);
        a(builder, l, stringExtra7);
        a(builder, m, String.valueOf(intExtra));
        a(builder, "identifier", this.e);
        a(builder, "signature", stringExtra);
        a(builder, p, "android");
        return builder.toString();
    }

    public int a() {
        return R.layout.auth_webview_layout;
    }

    private void a(Uri.Builder builder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }
}
