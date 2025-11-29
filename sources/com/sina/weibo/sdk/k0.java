package com.sina.weibo.sdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.WebActivity;

public final class k0 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebActivity f9989a;

    public k0(WebActivity webActivity) {
        this.f9989a = webActivity;
    }

    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f9989a.e.setProgress(i);
        if (i == 100) {
            this.f9989a.e.setVisibility(4);
        } else {
            this.f9989a.e.setVisibility(0);
        }
    }

    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}
