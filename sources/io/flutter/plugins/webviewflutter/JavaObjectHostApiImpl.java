package io.flutter.plugins.webviewflutter;

import androidx.annotation.NonNull;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebViewHostApiImpl;

public class JavaObjectHostApiImpl implements GeneratedAndroidWebView.JavaObjectHostApi {
    private final InstanceManager instanceManager;

    public JavaObjectHostApiImpl(@NonNull InstanceManager instanceManager2) {
        this.instanceManager = instanceManager2;
    }

    public void dispose(@NonNull Long l) {
        Object instance = this.instanceManager.getInstance(l.longValue());
        if (instance instanceof WebViewHostApiImpl.WebViewPlatformView) {
            ((WebViewHostApiImpl.WebViewPlatformView) instance).destroy();
        }
        this.instanceManager.remove(l.longValue());
    }
}
