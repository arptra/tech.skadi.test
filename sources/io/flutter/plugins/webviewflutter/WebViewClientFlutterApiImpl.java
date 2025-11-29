package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import com.honey.account.hb.a4;
import com.honey.account.hb.b4;
import com.honey.account.hb.s3;
import com.honey.account.hb.t3;
import com.honey.account.hb.u3;
import com.honey.account.hb.v3;
import com.honey.account.hb.w3;
import com.honey.account.hb.x3;
import com.honey.account.hb.y3;
import com.honey.account.hb.z3;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.HashMap;
import java.util.Objects;

public class WebViewClientFlutterApiImpl extends GeneratedAndroidWebView.WebViewClientFlutterApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;
    private final WebViewFlutterApiImpl webViewFlutterApi;

    public WebViewClientFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        super(binaryMessenger2);
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.webViewFlutterApi = new WebViewFlutterApiImpl(binaryMessenger2, instanceManager2);
    }

    @RequiresApi
    public static GeneratedAndroidWebView.WebResourceErrorData createWebResourceErrorData(WebResourceError webResourceError) {
        return new GeneratedAndroidWebView.WebResourceErrorData.Builder().setErrorCode(Long.valueOf((long) webResourceError.getErrorCode())).setDescription(webResourceError.getDescription().toString()).build();
    }

    @RequiresApi
    public static GeneratedAndroidWebView.WebResourceRequestData createWebResourceRequestData(WebResourceRequest webResourceRequest) {
        GeneratedAndroidWebView.WebResourceRequestData.Builder requestHeaders = new GeneratedAndroidWebView.WebResourceRequestData.Builder().setUrl(webResourceRequest.getUrl().toString()).setIsForMainFrame(Boolean.valueOf(webResourceRequest.isForMainFrame())).setHasGesture(Boolean.valueOf(webResourceRequest.hasGesture())).setMethod(webResourceRequest.getMethod()).setRequestHeaders(webResourceRequest.getRequestHeaders() != null ? webResourceRequest.getRequestHeaders() : new HashMap());
        requestHeaders.setIsRedirect(Boolean.valueOf(webResourceRequest.isRedirect()));
        return requestHeaders.build();
    }

    @RequiresApi
    public static GeneratedAndroidWebView.WebResourceResponseData createWebResourceResponseData(WebResourceResponse webResourceResponse) {
        return new GeneratedAndroidWebView.WebResourceResponseData.Builder().setStatusCode(Long.valueOf((long) webResourceResponse.getStatusCode())).build();
    }

    private long getIdentifierForClient(WebViewClient webViewClient) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webViewClient);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for WebViewClient.");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$doUpdateVisitedHistory$8(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPageFinished$1(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPageStarted$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedError$5(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedHttpAuthRequest$9(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedHttpError$2(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedRequestError$3(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceivedRequestError$4(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestLoading$6(Void voidR) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$urlLoading$7(Void voidR) {
    }

    public void doUpdateVisitedHistory(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, boolean z, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new a4());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        doUpdateVisitedHistory(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, Boolean.valueOf(z), reply);
    }

    public void onPageFinished(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new t3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onPageFinished(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
    }

    public void onPageStarted(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new w3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onPageStarted(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
    }

    public void onReceivedError(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull Long l, @NonNull String str, @NonNull String str2, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new z3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onReceivedError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, l, str, str2, reply);
    }

    public void onReceivedHttpAuthRequest(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull HttpAuthHandler httpAuthHandler, @NonNull String str, @NonNull String str2, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        new HttpAuthHandlerFlutterApiImpl(this.binaryMessenger, this.instanceManager).create(httpAuthHandler, new v3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webViewClient);
        Objects.requireNonNull(identifierForStrongReference);
        Long identifierForStrongReference2 = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference2);
        Long identifierForStrongReference3 = this.instanceManager.getIdentifierForStrongReference(httpAuthHandler);
        Objects.requireNonNull(identifierForStrongReference3);
        onReceivedHttpAuthRequest(identifierForStrongReference, identifierForStrongReference2, identifierForStrongReference3, str, str2, reply);
    }

    @RequiresApi
    public void onReceivedHttpError(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new s3());
        onReceivedHttpError(Long.valueOf(getIdentifierForClient(webViewClient)), this.instanceManager.getIdentifierForStrongReference(webView), createWebResourceRequestData(webResourceRequest), createWebResourceResponseData(webResourceResponse), reply);
    }

    @RequiresApi
    public void onReceivedRequestError(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new y3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onReceivedRequestError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, createWebResourceRequestData(webResourceRequest), createWebResourceErrorData(webResourceError), reply);
    }

    @RequiresApi
    public void requestLoading(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new u3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        requestLoading(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, createWebResourceRequestData(webResourceRequest), reply);
    }

    public void urlLoading(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull String str, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new b4());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        urlLoading(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, str, reply);
    }

    @SuppressLint({"RequiresFeature"})
    public static GeneratedAndroidWebView.WebResourceErrorData createWebResourceErrorData(WebResourceErrorCompat webResourceErrorCompat) {
        return new GeneratedAndroidWebView.WebResourceErrorData.Builder().setErrorCode(Long.valueOf((long) webResourceErrorCompat.b())).setDescription(webResourceErrorCompat.a().toString()).build();
    }

    @RequiresApi
    public void onReceivedRequestError(@NonNull WebViewClient webViewClient, @NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceErrorCompat webResourceErrorCompat, @NonNull GeneratedAndroidWebView.WebViewClientFlutterApi.Reply<Void> reply) {
        this.webViewFlutterApi.create(webView, new x3());
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        onReceivedRequestError(Long.valueOf(getIdentifierForClient(webViewClient)), identifierForStrongReference, createWebResourceRequestData(webResourceRequest), createWebResourceErrorData(webResourceErrorCompat), reply);
    }
}
