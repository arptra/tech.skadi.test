package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.FlutterEngine;

public interface WebViewFlutterAndroidExternalApi {
    @Nullable
    static WebView getWebView(@NonNull FlutterEngine flutterEngine, long j) {
        WebViewFlutterPlugin webViewFlutterPlugin = (WebViewFlutterPlugin) flutterEngine.getPlugins().get(WebViewFlutterPlugin.class);
        if (webViewFlutterPlugin == null || webViewFlutterPlugin.getInstanceManager() == null) {
            return null;
        }
        Object instance = webViewFlutterPlugin.getInstanceManager().getInstance(j);
        if (instance instanceof WebView) {
            return (WebView) instance;
        }
        return null;
    }
}
