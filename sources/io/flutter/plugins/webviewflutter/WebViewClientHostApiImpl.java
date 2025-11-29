package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import com.honey.account.hb.c4;
import com.honey.account.hb.d4;
import com.honey.account.hb.e4;
import com.honey.account.hb.f4;
import com.honey.account.hb.g4;
import com.honey.account.hb.h4;
import com.honey.account.hb.i4;
import com.honey.account.hb.j4;
import com.honey.account.hb.k4;
import com.honey.account.hb.l4;
import com.honey.account.hb.m4;
import com.honey.account.hb.n4;
import com.honey.account.hb.o4;
import com.honey.account.hb.p4;
import com.honey.account.hb.q4;
import com.honey.account.hb.r4;
import com.honey.account.hb.s4;
import com.honey.account.hb.t4;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class WebViewClientHostApiImpl implements GeneratedAndroidWebView.WebViewClientHostApi {
    private final WebViewClientFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;
    private final WebViewClientCreator webViewClientCreator;

    public static class WebViewClientCompatImpl extends WebViewClientCompat {
        private final WebViewClientFlutterApiImpl flutterApi;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientCompatImpl(@NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
            this.flutterApi = webViewClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$doUpdateVisitedHistory$7(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedHttpAuthRequest$8(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedHttpError$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$5(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$6(Void voidR) {
        }

        public void doUpdateVisitedHistory(@NonNull WebView webView, @NonNull String str, boolean z) {
            this.flutterApi.doUpdateVisitedHistory(this, webView, str, z, new f4());
        }

        public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.onPageFinished(this, webView, str, new i4());
        }

        public void onPageStarted(@NonNull WebView webView, @NonNull String str, @NonNull Bitmap bitmap) {
            this.flutterApi.onPageStarted(this, webView, str, new g4());
        }

        @RequiresApi
        @SuppressLint({"RequiresFeature"})
        public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceErrorCompat webResourceErrorCompat) {
            this.flutterApi.onReceivedRequestError((WebViewClient) this, webView, webResourceRequest, webResourceErrorCompat, (GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void>) new k4());
        }

        public void onReceivedHttpAuthRequest(@NonNull WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.flutterApi.onReceivedHttpAuthRequest(this, webView, httpAuthHandler, str, str2, new j4());
        }

        @RequiresApi
        public void onReceivedHttpError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse) {
            this.flutterApi.onReceivedHttpError(this, webView, webResourceRequest, webResourceResponse, new d4());
        }

        public void onUnhandledKeyEvent(@NonNull WebView webView, @NonNull KeyEvent keyEvent) {
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z) {
            this.returnValueForShouldOverrideUrlLoading = z;
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
            this.flutterApi.requestLoading(this, webView, webResourceRequest, new h4());
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        public void onReceivedError(@NonNull WebView webView, int i, @NonNull String str, @NonNull String str2) {
            this.flutterApi.onReceivedError(this, webView, Long.valueOf((long) i), str, str2, new e4());
        }

        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.urlLoading(this, webView, str, new c4());
            return this.returnValueForShouldOverrideUrlLoading;
        }
    }

    public static class WebViewClientCreator {
        @NonNull
        public WebViewClient createWebViewClient(@NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
            return new WebViewClientImpl(webViewClientFlutterApiImpl);
        }
    }

    @RequiresApi
    public static class WebViewClientImpl extends WebViewClient {
        private final WebViewClientFlutterApiImpl flutterApi;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientImpl(@NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
            this.flutterApi = webViewClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$doUpdateVisitedHistory$7(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedError$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedHttpAuthRequest$8(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceivedHttpError$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$5(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$shouldOverrideUrlLoading$6(Void voidR) {
        }

        public void doUpdateVisitedHistory(@NonNull WebView webView, @NonNull String str, boolean z) {
            this.flutterApi.doUpdateVisitedHistory(this, webView, str, z, new t4());
        }

        public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.onPageFinished(this, webView, str, new n4());
        }

        public void onPageStarted(@NonNull WebView webView, @NonNull String str, @NonNull Bitmap bitmap) {
            this.flutterApi.onPageStarted(this, webView, str, new q4());
        }

        public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError) {
            this.flutterApi.onReceivedRequestError((WebViewClient) this, webView, webResourceRequest, webResourceError, (GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void>) new l4());
        }

        public void onReceivedHttpAuthRequest(@NonNull WebView webView, @NonNull HttpAuthHandler httpAuthHandler, @NonNull String str, @NonNull String str2) {
            this.flutterApi.onReceivedHttpAuthRequest(this, webView, httpAuthHandler, str, str2, new s4());
        }

        public void onReceivedHttpError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse) {
            this.flutterApi.onReceivedHttpError(this, webView, webResourceRequest, webResourceResponse, new p4());
        }

        public void onUnhandledKeyEvent(@NonNull WebView webView, @NonNull KeyEvent keyEvent) {
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z) {
            this.returnValueForShouldOverrideUrlLoading = z;
        }

        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
            this.flutterApi.requestLoading(this, webView, webResourceRequest, new m4());
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        public void onReceivedError(@NonNull WebView webView, int i, @NonNull String str, @NonNull String str2) {
            this.flutterApi.onReceivedError(this, webView, Long.valueOf((long) i), str, str2, new r4());
        }

        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            this.flutterApi.urlLoading(this, webView, str, new o4());
            return this.returnValueForShouldOverrideUrlLoading;
        }
    }

    public WebViewClientHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull WebViewClientCreator webViewClientCreator2, @NonNull WebViewClientFlutterApiImpl webViewClientFlutterApiImpl) {
        this.instanceManager = instanceManager2;
        this.webViewClientCreator = webViewClientCreator2;
        this.flutterApi = webViewClientFlutterApiImpl;
    }

    public void create(@NonNull Long l) {
        this.instanceManager.addDartCreatedInstance(this.webViewClientCreator.createWebViewClient(this.flutterApi), l.longValue());
    }

    public void setSynchronousReturnValueForShouldOverrideUrlLoading(@NonNull Long l, @NonNull Boolean bool) {
        WebViewClient webViewClient = (WebViewClient) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webViewClient);
        if (webViewClient instanceof WebViewClientCompatImpl) {
            ((WebViewClientCompatImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(bool.booleanValue());
        } else if (webViewClient instanceof WebViewClientImpl) {
            ((WebViewClientImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(bool.booleanValue());
        } else {
            throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
        }
    }
}
