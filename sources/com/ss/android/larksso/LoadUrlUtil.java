package com.ss.android.larksso;

import android.annotation.TargetApi;
import android.webkit.ValueCallback;
import android.webkit.WebView;

public class LoadUrlUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final BaseImpl f10008a = new KitKatImpl();

    public static class BaseImpl {
        public BaseImpl() {
        }

        public void a(WebView webView, String str) {
            if (webView != null) {
                try {
                    webView.loadUrl(str);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @TargetApi(19)
    public static class KitKatImpl extends BaseImpl {
        public KitKatImpl() {
            super();
        }

        public void a(WebView webView, String str) {
            if (webView != null) {
                if (str != null && str.startsWith("javascript:")) {
                    try {
                        webView.evaluateJavascript(str, (ValueCallback) null);
                        return;
                    } catch (Throwable th) {
                        boolean z = th instanceof IllegalStateException;
                    }
                }
                try {
                    webView.loadUrl(str);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
