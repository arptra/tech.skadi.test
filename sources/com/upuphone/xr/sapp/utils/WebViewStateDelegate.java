package com.upuphone.xr.sapp.utils;

import android.content.Intent;
import android.graphics.Paint;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0002\u0013\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate;", "", "Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$OnWebViewStateListener;", "listener", "<init>", "(Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$OnWebViewStateListener;)V", "Landroid/webkit/WebView;", "webView", "", "d", "(Landroid/webkit/WebView;)V", "a", "Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$OnWebViewStateListener;", "c", "()Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$OnWebViewStateListener;", "", "b", "I", "mLoadState", "Companion", "OnWebViewStateListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WebViewStateDelegate {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final OnWebViewStateListener f7934a;
    public int b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$Companion;", "", "()V", "STATE_DEFAULT", "", "STATE_NO_NETWORK", "STATE_SERVER_ERROR", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J!\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0016\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewStateDelegate$OnWebViewStateListener;", "", "", "title", "", "b", "(Ljava/lang/String;)V", "", "newProgress", "onProgress", "(I)V", "url", "d", "errorState", "a", "(Ljava/lang/String;I)V", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/content/Intent;", "intent", "c", "(Landroid/webkit/ValueCallback;Landroid/content/Intent;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnWebViewStateListener {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void a(OnWebViewStateListener onWebViewStateListener, String str) {
            }

            public static void b(OnWebViewStateListener onWebViewStateListener, int i) {
            }

            public static void c(OnWebViewStateListener onWebViewStateListener, String str) {
                Intrinsics.checkNotNullParameter(str, "title");
            }

            public static void d(OnWebViewStateListener onWebViewStateListener, ValueCallback valueCallback, Intent intent) {
            }
        }

        void a(String str, int i);

        void b(String str);

        void c(ValueCallback valueCallback, Intent intent);

        void d(String str);

        void onProgress(int i);
    }

    public WebViewStateDelegate(OnWebViewStateListener onWebViewStateListener) {
        Intrinsics.checkNotNullParameter(onWebViewStateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f7934a = onWebViewStateListener;
    }

    public final OnWebViewStateListener c() {
        return this.f7934a;
    }

    public final void d(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        if (WebViewFeature.a("ALGORITHMIC_DARKENING")) {
            WebSettingsCompat.b(settings, true);
        } else {
            ULog.f6446a.o("WebViewStateMonitor", "AlgorithmicDarkening is not Allowed");
        }
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        webView.setLayerType(2, (Paint) null);
        webView.setWebChromeClient(new WebViewStateDelegate$watch$1(this));
        webView.setWebViewClient(new WebViewStateDelegate$watch$2(this, settings));
    }
}
