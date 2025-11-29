package com.upuphone.xr.sapp.utils;

import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0012"}, d2 = {"com/upuphone/xr/sapp/utils/WebViewStateDelegate$watch$2", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "errorCode", "", "description", "failingUrl", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WebViewStateDelegate$watch$2 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewStateDelegate f7936a;
    public final /* synthetic */ WebSettings b;

    public WebViewStateDelegate$watch$2(WebViewStateDelegate webViewStateDelegate, WebSettings webSettings) {
        this.f7936a = webViewStateDelegate;
        this.b = webSettings;
    }

    public void onPageFinished(WebView webView, String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WebViewStateMonitor", "onPageFinished, url->" + str);
        super.onPageFinished(webView, str);
        this.b.setBlockNetworkImage(false);
        if (this.f7936a.b == 0) {
            this.f7936a.c().d(str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WebViewStateMonitor", "onPageStarted, url->" + str);
        this.f7936a.b = 0;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WebViewStateMonitor", "onReceivedError, code->" + i + ", des->" + str);
        super.onReceivedError(webView, i, str, str2);
        if (i == -2 && str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "ERR_INTERNET_DISCONNECTED", false, 2, (Object) null)) {
            this.f7936a.c().a(str2, -1);
        } else {
            this.f7936a.c().a(str2, -2);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WebViewStateMonitor", "shouldInterceptRequest, url->" + str);
        return super.shouldInterceptRequest(webView, str);
    }
}
