package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class WebViewFlutterApiImpl {
    private GeneratedAndroidWebView.WebViewFlutterApi api;
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public WebViewFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.api = new GeneratedAndroidWebView.WebViewFlutterApi(binaryMessenger2);
    }

    public void create(@NonNull WebView webView, @NonNull GeneratedAndroidWebView.WebViewFlutterApi.Reply<Void> reply) {
        if (!this.instanceManager.containsInstance(webView)) {
            this.api.create(Long.valueOf(this.instanceManager.addHostCreatedInstance(webView)), reply);
        }
    }

    public void onScrollChanged(@NonNull WebView webView, @NonNull Long l, @NonNull Long l2, @NonNull Long l3, @NonNull Long l4, @NonNull GeneratedAndroidWebView.WebViewFlutterApi.Reply<Void> reply) {
        GeneratedAndroidWebView.WebViewFlutterApi webViewFlutterApi = this.api;
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(webView);
        Objects.requireNonNull(identifierForStrongReference);
        webViewFlutterApi.onScrollChanged(identifierForStrongReference, l, l2, l3, l4, reply);
    }

    @VisibleForTesting
    public void setApi(@NonNull GeneratedAndroidWebView.WebViewFlutterApi webViewFlutterApi) {
        this.api = webViewFlutterApi;
    }
}
