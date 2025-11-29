package com.upuphone.ar.tici.phone;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/tici/phone/TiciFileTipsActivity$initView$2$2", "Landroid/webkit/WebChromeClient;", "onReceivedTitle", "", "view", "Landroid/webkit/WebView;", "title", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciFileTipsActivity$initView$2$2 extends WebChromeClient {
    public void onReceivedTitle(WebView webView, String str) {
        CommonExtKt.e("onReceivedTitle, title: " + str, "TiciFileTipsActivity");
    }
}
