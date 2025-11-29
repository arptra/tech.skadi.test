package com.geetest.captcha.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.geetest.captcha.d0;
import com.geetest.captcha.e0;
import com.geetest.captcha.h0;
import com.geetest.captcha.v;
import com.geetest.captcha.w;
import com.geetest.captcha.y;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003+,-B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB-\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\fB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J/\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/geetest/captcha/views/GTC4WebView;", "Landroid/webkit/WebView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "", "onDetachedFromWindow", "()V", "onResume", "newWidth", "newHeight", "oldWidth", "oldHeight", "onSizeChanged", "(IIII)V", "Lcom/geetest/captcha/observer/WebViewObservable;", "observable", "Lcom/geetest/captcha/model/DataBean;", "dataBean", "", "loadUrl", "init", "(Lcom/geetest/captcha/observer/WebViewObservable;Lcom/geetest/captcha/model/DataBean;Ljava/lang/String;)V", "url", "parseUrl", "(Ljava/lang/String;)V", "setWebViewObservable", "(Lcom/geetest/captcha/observer/WebViewObservable;)V", "Lcom/geetest/captcha/views/GTC4WebView$MyWebViewClient;", "myWebViewClient", "Lcom/geetest/captcha/views/GTC4WebView$MyWebViewClient;", "", "resumeTimers", "Z", "Companion", "MyWebChromeClient", "MyWebViewClient", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class GTC4WebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public b f2883a;

    public static final class a extends WebChromeClient {
        public void onProgressChanged(WebView webView, int i) {
            Intrinsics.checkNotNullParameter(webView, "view");
            super.onProgressChanged(webView, i);
            h0 h0Var = h0.d;
            h0Var.b("GTC4WebView", "onProgressChanged: " + i);
        }

        public void onReceivedTitle(WebView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "title");
            super.onReceivedTitle(webView, str);
            h0 h0Var = h0.d;
            h0Var.a("onReceivedTitle: " + str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GTC4WebView(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
    }

    public final void a(y yVar, v vVar, String str) {
        Intrinsics.checkNotNullParameter(yVar, "observable");
        Intrinsics.checkNotNullParameter(vVar, "dataBean");
        Intrinsics.checkNotNullParameter(str, "loadUrl");
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "settings");
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(2);
        settings.setSupportZoom(true);
        settings.setTextZoom(100);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setGeolocationEnabled(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        setOverScrollMode(2);
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWebChromeClient(new a());
        b bVar = new b(str, yVar);
        this.f2883a = bVar;
        setWebViewClient(bVar);
        setBackgroundColor(vVar.j);
        if (vVar.c) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        super.onResume();
        resumeTimers();
    }

    public void onDetachedFromWindow() {
        h0.d.e("GTC4WebView.onDetachedFromWindow");
        super.onDetachedFromWindow();
        removeJavascriptInterface("JSInterface");
        removeAllViews();
        removeAllViewsInLayout();
        loadUrl("");
    }

    public void onResume() {
        super.onResume();
        resumeTimers();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        h0 h0Var = h0.d;
        h0Var.b("GTC4WebView", "newWidth: " + i + ", newHeight: " + i2 + ", oldWidth: " + i3 + ", oldHeight: " + i4);
    }

    public final void setWebViewObservable(@NotNull y yVar) {
        Intrinsics.checkNotNullParameter(yVar, "observable");
        b bVar = this.f2883a;
        if (bVar != null) {
            Intrinsics.checkNotNullParameter(yVar, "observable");
            bVar.f2884a = yVar;
        }
    }

    public static final class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public y f2884a;

        public b(String str, y yVar) {
            Intrinsics.checkNotNullParameter(str, "loadUrl");
            Intrinsics.checkNotNullParameter(yVar, "observable");
            this.f2884a = yVar;
        }

        public void onLoadResource(WebView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            super.onLoadResource(webView, str);
            h0 h0Var = h0.d;
            h0Var.e("onLoadResource: " + str);
        }

        public void onPageFinished(WebView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            super.onPageFinished(webView, str);
            h0 h0Var = h0.d;
            h0Var.e("onPageFinished: " + str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            h0 h0Var = h0.d;
            h0Var.e("onPageStarted: " + str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(webResourceRequest, "request");
            Intrinsics.checkNotNullParameter(webResourceError, "error");
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            h0 h0Var = h0.d;
            h0Var.e("WebViewClient.onReceivedError: URL: " + webResourceRequest.getUrl() + ", " + "Method: " + webResourceRequest.getMethod() + ", ErrorCode: " + webResourceError.getErrorCode() + ", Description: " + webResourceError.getDescription());
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(webResourceRequest, "request");
            Intrinsics.checkNotNullParameter(webResourceResponse, "errorResponse");
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            h0 h0Var = h0.d;
            h0Var.e("WebViewClient.onReceivedHttpError: URL: " + webResourceRequest.getUrl() + ", " + "Code: " + webResourceResponse.getStatusCode() + ", Message: " + webResourceResponse.getReasonPhrase());
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(sslErrorHandler, "handler");
            Intrinsics.checkNotNullParameter(sslError, "error");
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            h0.d.e("WebViewClient.onReceivedSslError: URL: " + sslError.getUrl() + ", ErrorCode: " + sslError.getPrimaryError() + ", Description: " + sslError);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(sslError.getPrimaryError()))}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            String str = e0.b;
            w.a aVar = w.d;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", sslError.getUrl());
            jSONObject.put("description", sslError.toString());
            Unit unit = Unit.INSTANCE;
            this.f2884a.b(d0.WEB_VIEW_SSL.getType() + format, str, jSONObject);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Context context;
            h0 h0Var = h0.d;
            StringBuilder sb = new StringBuilder();
            sb.append("shouldOverrideUrlLoading(high): ");
            Uri uri = null;
            sb.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
            h0Var.e(sb.toString());
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (webResourceRequest != null) {
                    uri = webResourceRequest.getUrl();
                }
                intent.setData(Uri.parse(String.valueOf(uri)));
                if (webView == null || (context = webView.getContext()) == null) {
                    return true;
                }
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "description");
            Intrinsics.checkNotNullParameter(str2, "failingUrl");
            super.onReceivedError(webView, i, str, str2);
        }
    }
}
