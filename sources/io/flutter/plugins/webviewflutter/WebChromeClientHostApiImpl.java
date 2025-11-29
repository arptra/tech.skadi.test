package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.honey.account.hb.h3;
import com.honey.account.hb.i3;
import com.honey.account.hb.j3;
import com.honey.account.hb.k3;
import com.honey.account.hb.l3;
import com.honey.account.hb.m3;
import com.honey.account.hb.n3;
import com.honey.account.hb.o3;
import com.honey.account.hb.p3;
import com.honey.account.hb.q3;
import com.honey.account.hb.r3;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.List;
import java.util.Objects;

public class WebChromeClientHostApiImpl implements GeneratedAndroidWebView.WebChromeClientHostApi {
    private Context context;
    private final WebChromeClientFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;
    private final WebChromeClientCreator webChromeClientCreator;

    public static class SecureWebChromeClient extends WebChromeClient {
        @Nullable
        WebViewClient webViewClient;

        public boolean onCreateWindow(@NonNull WebView webView, boolean z, boolean z2, @NonNull Message message) {
            return onCreateWindow(webView, message, new WebView(webView.getContext()));
        }

        public void setWebViewClient(@NonNull WebViewClient webViewClient2) {
            this.webViewClient = webViewClient2;
        }

        @VisibleForTesting
        public boolean onCreateWindow(@NonNull final WebView webView, @NonNull Message message, @Nullable WebView webView2) {
            if (this.webViewClient == null) {
                return false;
            }
            AnonymousClass1 r0 = new WebViewClient() {
                @RequiresApi
                public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
                    if (SecureWebChromeClient.this.webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest)) {
                        return true;
                    }
                    webView.loadUrl(webResourceRequest.getUrl().toString());
                    return true;
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (SecureWebChromeClient.this.webViewClient.shouldOverrideUrlLoading(webView, str)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                }
            };
            if (webView2 == null) {
                webView2 = new WebView(webView.getContext());
            }
            webView2.setWebViewClient(r0);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }

    public static class WebChromeClientCreator {
        @NonNull
        public WebChromeClientImpl createWebChromeClient(@NonNull WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl) {
            return new WebChromeClientImpl(webChromeClientFlutterApiImpl);
        }
    }

    public static class WebChromeClientImpl extends SecureWebChromeClient {
        private final WebChromeClientFlutterApiImpl flutterApi;
        private boolean returnValueForOnConsoleMessage = false;
        private boolean returnValueForOnJsAlert = false;
        private boolean returnValueForOnJsConfirm = false;
        private boolean returnValueForOnJsPrompt = false;
        private boolean returnValueForOnShowFileChooser = false;

        public WebChromeClientImpl(@NonNull WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl) {
            this.flutterApi = webChromeClientFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onConsoleMessage$7(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onGeolocationPermissionsHidePrompt$4(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onGeolocationPermissionsShowPrompt$3(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onHideCustomView$2(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onJsConfirm$9(JsResult jsResult, Boolean bool) {
            if (bool.booleanValue()) {
                jsResult.confirm();
            } else {
                jsResult.cancel();
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onJsPrompt$10(JsPromptResult jsPromptResult, String str) {
            if (str != null) {
                jsPromptResult.confirm(str);
            } else {
                jsPromptResult.cancel();
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onPermissionRequest$6(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onProgressChanged$0(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onShowCustomView$1(Void voidR) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onShowFileChooser$5(boolean z, ValueCallback valueCallback, List list) {
            if (z) {
                Uri[] uriArr = new Uri[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    uriArr[i] = Uri.parse((String) list.get(i));
                }
                valueCallback.onReceiveValue(uriArr);
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            this.flutterApi.onConsoleMessage(this, consoleMessage, new k3());
            return this.returnValueForOnConsoleMessage;
        }

        public void onGeolocationPermissionsHidePrompt() {
            this.flutterApi.onGeolocationPermissionsHidePrompt(this, new q3());
        }

        public void onGeolocationPermissionsShowPrompt(@NonNull String str, @NonNull GeolocationPermissions.Callback callback) {
            this.flutterApi.onGeolocationPermissionsShowPrompt(this, str, callback, new p3());
        }

        public void onHideCustomView() {
            this.flutterApi.onHideCustomView(this, new r3());
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (!this.returnValueForOnJsAlert) {
                return false;
            }
            this.flutterApi.onJsAlert(this, str, str2, new m3(jsResult));
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (!this.returnValueForOnJsConfirm) {
                return false;
            }
            this.flutterApi.onJsConfirm(this, str, str2, new i3(jsResult));
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!this.returnValueForOnJsPrompt) {
                return false;
            }
            this.flutterApi.onJsPrompt(this, str, str2, str3, new l3(jsPromptResult));
            return true;
        }

        @RequiresApi
        public void onPermissionRequest(@NonNull PermissionRequest permissionRequest) {
            this.flutterApi.onPermissionRequest(this, permissionRequest, new j3());
        }

        public void onProgressChanged(@NonNull WebView webView, int i) {
            this.flutterApi.onProgressChanged(this, webView, Long.valueOf((long) i), new o3());
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            this.flutterApi.onShowCustomView(this, view, customViewCallback, new h3());
        }

        @RequiresApi
        public boolean onShowFileChooser(@NonNull WebView webView, @NonNull ValueCallback<Uri[]> valueCallback, @NonNull WebChromeClient.FileChooserParams fileChooserParams) {
            boolean z = this.returnValueForOnShowFileChooser;
            this.flutterApi.onShowFileChooser(this, webView, fileChooserParams, new n3(z, valueCallback));
            return z;
        }

        public void setReturnValueForOnConsoleMessage(boolean z) {
            this.returnValueForOnConsoleMessage = z;
        }

        public void setReturnValueForOnJsAlert(boolean z) {
            this.returnValueForOnJsAlert = z;
        }

        public void setReturnValueForOnJsConfirm(boolean z) {
            this.returnValueForOnJsConfirm = z;
        }

        public void setReturnValueForOnJsPrompt(boolean z) {
            this.returnValueForOnJsPrompt = z;
        }

        public void setReturnValueForOnShowFileChooser(boolean z) {
            this.returnValueForOnShowFileChooser = z;
        }
    }

    public WebChromeClientHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull WebChromeClientCreator webChromeClientCreator2, @NonNull WebChromeClientFlutterApiImpl webChromeClientFlutterApiImpl) {
        this.instanceManager = instanceManager2;
        this.webChromeClientCreator = webChromeClientCreator2;
        this.flutterApi = webChromeClientFlutterApiImpl;
    }

    public void create(@NonNull Long l) {
        this.instanceManager.addDartCreatedInstance(this.webChromeClientCreator.createWebChromeClient(this.flutterApi), l.longValue());
    }

    public void setSynchronousReturnValueForOnConsoleMessage(@NonNull Long l, @NonNull Boolean bool) {
        WebChromeClientImpl webChromeClientImpl = (WebChromeClientImpl) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webChromeClientImpl);
        webChromeClientImpl.setReturnValueForOnConsoleMessage(bool.booleanValue());
    }

    public void setSynchronousReturnValueForOnJsAlert(@NonNull Long l, @NonNull Boolean bool) {
        WebChromeClientImpl webChromeClientImpl = (WebChromeClientImpl) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webChromeClientImpl);
        webChromeClientImpl.setReturnValueForOnJsAlert(bool.booleanValue());
    }

    public void setSynchronousReturnValueForOnJsConfirm(@NonNull Long l, @NonNull Boolean bool) {
        WebChromeClientImpl webChromeClientImpl = (WebChromeClientImpl) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webChromeClientImpl);
        webChromeClientImpl.setReturnValueForOnJsConfirm(bool.booleanValue());
    }

    public void setSynchronousReturnValueForOnJsPrompt(@NonNull Long l, @NonNull Boolean bool) {
        WebChromeClientImpl webChromeClientImpl = (WebChromeClientImpl) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webChromeClientImpl);
        webChromeClientImpl.setReturnValueForOnJsPrompt(bool.booleanValue());
    }

    public void setSynchronousReturnValueForOnShowFileChooser(@NonNull Long l, @NonNull Boolean bool) {
        WebChromeClientImpl webChromeClientImpl = (WebChromeClientImpl) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webChromeClientImpl);
        webChromeClientImpl.setReturnValueForOnShowFileChooser(bool.booleanValue());
    }
}
