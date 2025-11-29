package com.upuphone.xr.sapp.utils;

import android.content.Intent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J2\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, d2 = {"com/upuphone/xr/sapp/utils/WebViewStateDelegate$watch$1", "Landroid/webkit/WebChromeClient;", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "onReceivedTitle", "title", "", "onShowFileChooser", "", "webView", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WebViewStateDelegate$watch$1 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewStateDelegate f7935a;

    public WebViewStateDelegate$watch$1(WebViewStateDelegate webViewStateDelegate) {
        this.f7935a = webViewStateDelegate;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.f7935a.c().onProgress(i);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WebViewStateMonitor", "收到title->" + str);
        if (str != null) {
            this.f7935a.c().b(str);
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Intent createIntent;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WebViewStateMonitor", "onShowFileChooser webView: " + webView + ", filePathCallback: " + valueCallback + ", fileChooserParams: " + fileChooserParams);
        if (fileChooserParams == null || (createIntent = fileChooserParams.createIntent()) == null) {
            this.f7935a.c().c((ValueCallback) null, (Intent) null);
            return false;
        }
        this.f7935a.c().c(valueCallback, createIntent);
        return true;
    }
}
