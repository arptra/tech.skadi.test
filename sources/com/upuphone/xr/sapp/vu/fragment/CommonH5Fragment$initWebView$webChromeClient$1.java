package com.upuphone.xr.sapp.vu.fragment;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/upuphone/xr/sapp/vu/fragment/CommonH5Fragment$initWebView$webChromeClient$1", "Landroid/webkit/WebChromeClient;", "onHideCustomView", "", "onProgressChanged", "view", "Landroid/webkit/WebView;", "newProgress", "", "onShowCustomView", "Landroid/view/View;", "callback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommonH5Fragment$initWebView$webChromeClient$1 extends WebChromeClient {
    public void onHideCustomView() {
        super.onHideCustomView();
        ULog.f6446a.a("CommonH5Fragment", "onHideCustomView");
    }

    public void onProgressChanged(WebView webView, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("CommonH5Fragment", "onProgressChanged" + i);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        ULog.f6446a.a("CommonH5Fragment", "onShowCustomView");
    }
}
