package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.honey.account.hb.x4;
import com.honey.account.hb.y4;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import java.util.Map;
import java.util.Objects;

public class WebViewHostApiImpl implements GeneratedAndroidWebView.WebViewHostApi {
    private final BinaryMessenger binaryMessenger;
    private Context context;
    private final InstanceManager instanceManager;
    private final WebViewProxy webViewProxy;

    @SuppressLint({"ViewConstructor"})
    public static class WebViewPlatformView extends WebView implements PlatformView {
        private WebViewFlutterApiImpl api;
        private WebChromeClientHostApiImpl.SecureWebChromeClient currentWebChromeClient;
        private WebViewClient currentWebViewClient;
        @NonNull
        private final AndroidSdkChecker sdkChecker;

        @VisibleForTesting
        public interface AndroidSdkChecker {
            @ChecksSdkIntAtLeast
            boolean sdkIsAtLeast(int i);
        }

        public WebViewPlatformView(@NonNull Context context, @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager) {
            this(context, binaryMessenger, instanceManager, new b());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(int i) {
            return Build.VERSION.SDK_INT >= i;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onScrollChanged$1(Void voidR) {
        }

        private FlutterView tryFindFlutterView() {
            ViewParent parent;
            boolean z;
            do {
                ViewParent parent2 = this.getParent();
                this = this;
                if (parent2 == null) {
                    return null;
                }
                parent = this.getParent();
                z = parent instanceof FlutterView;
                this = parent;
            } while (!z);
            return (FlutterView) parent;
        }

        public void dispose() {
        }

        @Nullable
        public View getView() {
            return this;
        }

        @Nullable
        public WebChromeClient getWebChromeClient() {
            return this.currentWebChromeClient;
        }

        public void onAttachedToWindow() {
            FlutterView tryFindFlutterView;
            super.onAttachedToWindow();
            if (this.sdkChecker.sdkIsAtLeast(26) && (tryFindFlutterView = tryFindFlutterView()) != null) {
                tryFindFlutterView.setImportantForAutofill(1);
            }
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            this.api.onScrollChanged(this, Long.valueOf((long) i), Long.valueOf((long) i2), Long.valueOf((long) i3), Long.valueOf((long) i4), new y4());
        }

        @VisibleForTesting
        public void setApi(WebViewFlutterApiImpl webViewFlutterApiImpl) {
            this.api = webViewFlutterApiImpl;
        }

        public void setWebChromeClient(@Nullable WebChromeClient webChromeClient) {
            super.setWebChromeClient(webChromeClient);
            if (webChromeClient instanceof WebChromeClientHostApiImpl.SecureWebChromeClient) {
                WebChromeClientHostApiImpl.SecureWebChromeClient secureWebChromeClient = (WebChromeClientHostApiImpl.SecureWebChromeClient) webChromeClient;
                this.currentWebChromeClient = secureWebChromeClient;
                secureWebChromeClient.setWebViewClient(this.currentWebViewClient);
                return;
            }
            throw new AssertionError("Client must be a SecureWebChromeClient.");
        }

        public void setWebViewClient(@NonNull WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.currentWebViewClient = webViewClient;
            this.currentWebChromeClient.setWebViewClient(webViewClient);
        }

        @VisibleForTesting
        public WebViewPlatformView(@NonNull Context context, @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager, @NonNull AndroidSdkChecker androidSdkChecker) {
            super(context);
            this.currentWebViewClient = new WebViewClient();
            this.currentWebChromeClient = new WebChromeClientHostApiImpl.SecureWebChromeClient();
            this.api = new WebViewFlutterApiImpl(binaryMessenger, instanceManager);
            this.sdkChecker = androidSdkChecker;
            setWebViewClient(this.currentWebViewClient);
            setWebChromeClient(this.currentWebChromeClient);
        }
    }

    public static class WebViewProxy {
        @NonNull
        public WebViewPlatformView createWebView(@NonNull Context context, @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager) {
            return new WebViewPlatformView(context, binaryMessenger, instanceManager);
        }

        public void setWebContentsDebuggingEnabled(boolean z) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
    }

    public WebViewHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull BinaryMessenger binaryMessenger2, @NonNull WebViewProxy webViewProxy2, @Nullable Context context2) {
        this.instanceManager = instanceManager2;
        this.binaryMessenger = binaryMessenger2;
        this.webViewProxy = webViewProxy2;
        this.context = context2;
    }

    @SuppressLint({"JavascriptInterface"})
    public void addJavaScriptChannel(@NonNull Long l, @NonNull Long l2) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        JavaScriptChannel javaScriptChannel = (JavaScriptChannel) this.instanceManager.getInstance(l2.longValue());
        Objects.requireNonNull(javaScriptChannel);
        webView.addJavascriptInterface(javaScriptChannel, javaScriptChannel.javaScriptChannelName);
    }

    @NonNull
    public Boolean canGoBack(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        return Boolean.valueOf(webView.canGoBack());
    }

    @NonNull
    public Boolean canGoForward(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        return Boolean.valueOf(webView.canGoForward());
    }

    public void clearCache(@NonNull Long l, @NonNull Boolean bool) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.clearCache(bool.booleanValue());
    }

    public void create(@NonNull Long l) {
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) this.context.getSystemService("display");
        displayListenerProxy.onPreWebViewInitialization(displayManager);
        WebViewPlatformView createWebView = this.webViewProxy.createWebView(this.context, this.binaryMessenger, this.instanceManager);
        displayListenerProxy.onPostWebViewInitialization(displayManager);
        this.instanceManager.addDartCreatedInstance(createWebView, l.longValue());
    }

    public void evaluateJavascript(@NonNull Long l, @NonNull String str, @NonNull GeneratedAndroidWebView.Result<String> result) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        Objects.requireNonNull(result);
        webView.evaluateJavascript(str, new x4(result));
    }

    @NonNull
    public InstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    @NonNull
    public GeneratedAndroidWebView.WebViewPoint getScrollPosition(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        return new GeneratedAndroidWebView.WebViewPoint.Builder().setX(Long.valueOf((long) webView.getScrollX())).setY(Long.valueOf((long) webView.getScrollY())).build();
    }

    @NonNull
    public Long getScrollX(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        return Long.valueOf((long) webView.getScrollX());
    }

    @NonNull
    public Long getScrollY(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        return Long.valueOf((long) webView.getScrollY());
    }

    @Nullable
    public String getTitle(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        return webView.getTitle();
    }

    @Nullable
    public String getUrl(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        return webView.getUrl();
    }

    public void goBack(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.goBack();
    }

    public void goForward(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.goForward();
    }

    public void loadData(@NonNull Long l, @NonNull String str, @Nullable String str2, @Nullable String str3) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseUrl(@NonNull Long l, @Nullable String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(@NonNull Long l, @NonNull String str, @NonNull Map<String, String> map) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.loadUrl(str, map);
    }

    public void postUrl(@NonNull Long l, @NonNull String str, @NonNull byte[] bArr) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.postUrl(str, bArr);
    }

    public void reload(@NonNull Long l) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.reload();
    }

    public void removeJavaScriptChannel(@NonNull Long l, @NonNull Long l2) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        JavaScriptChannel javaScriptChannel = (JavaScriptChannel) this.instanceManager.getInstance(l2.longValue());
        Objects.requireNonNull(javaScriptChannel);
        webView.removeJavascriptInterface(javaScriptChannel.javaScriptChannelName);
    }

    public void scrollBy(@NonNull Long l, @NonNull Long l2, @NonNull Long l3) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.scrollBy(l2.intValue(), l3.intValue());
    }

    public void scrollTo(@NonNull Long l, @NonNull Long l2, @NonNull Long l3) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.scrollTo(l2.intValue(), l3.intValue());
    }

    public void setBackgroundColor(@NonNull Long l, @NonNull Long l2) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.setBackgroundColor(l2.intValue());
    }

    public void setContext(@Nullable Context context2) {
        this.context = context2;
    }

    public void setDownloadListener(@NonNull Long l, @Nullable Long l2) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        InstanceManager instanceManager2 = this.instanceManager;
        Objects.requireNonNull(l2);
        webView.setDownloadListener((DownloadListener) instanceManager2.getInstance(l2.longValue()));
    }

    public void setWebChromeClient(@NonNull Long l, @Nullable Long l2) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        InstanceManager instanceManager2 = this.instanceManager;
        Objects.requireNonNull(l2);
        webView.setWebChromeClient((WebChromeClient) instanceManager2.getInstance(l2.longValue()));
    }

    public void setWebContentsDebuggingEnabled(@NonNull Boolean bool) {
        this.webViewProxy.setWebContentsDebuggingEnabled(bool.booleanValue());
    }

    public void setWebViewClient(@NonNull Long l, @NonNull Long l2) {
        WebView webView = (WebView) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(webView);
        webView.setWebViewClient((WebViewClient) this.instanceManager.getInstance(l2.longValue()));
    }
}
