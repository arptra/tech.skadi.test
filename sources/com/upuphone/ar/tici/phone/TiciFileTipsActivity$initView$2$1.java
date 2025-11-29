package com.upuphone.ar.tici.phone;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0019"}, d2 = {"com/upuphone/ar/tici/phone/TiciFileTipsActivity$initView$2$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciFileTipsActivity$initView$2$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciFileTipsActivity f5883a;

    public TiciFileTipsActivity$initView$2$1(TiciFileTipsActivity ticiFileTipsActivity) {
        this.f5883a = ticiFileTipsActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        CommonExtKt.e("onPageFinished", "TiciFileTipsActivity");
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        CommonExtKt.e("onPageStarted", "TiciFileTipsActivity");
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        CharSequence charSequence = null;
        Integer valueOf = webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null;
        if (webResourceError != null) {
            charSequence = webResourceError.getDescription();
        }
        CommonExtKt.e("onReceivedError, errorCode: " + valueOf + ", description: " + charSequence, "TiciFileTipsActivity");
        this.f5883a.I0();
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str = null;
        Integer valueOf = webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null;
        if (webResourceResponse != null) {
            str = webResourceResponse.getReasonPhrase();
        }
        CommonExtKt.e("onReceivedHttpError, statusCode: " + valueOf + ", reasonPhrase: " + str, "TiciFileTipsActivity");
        this.f5883a.I0();
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        CommonExtKt.e("onReceivedSslError, error: " + sslError, "TiciFileTipsActivity");
        this.f5883a.I0();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return true;
    }
}
