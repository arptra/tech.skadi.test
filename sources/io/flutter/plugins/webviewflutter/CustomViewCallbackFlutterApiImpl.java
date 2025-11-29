package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class CustomViewCallbackFlutterApiImpl {
    private GeneratedAndroidWebView.CustomViewCallbackFlutterApi api;
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public CustomViewCallbackFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.api = new GeneratedAndroidWebView.CustomViewCallbackFlutterApi(binaryMessenger2);
    }

    public void create(@NonNull WebChromeClient.CustomViewCallback customViewCallback, @NonNull GeneratedAndroidWebView.CustomViewCallbackFlutterApi.Reply<Void> reply) {
        if (!this.instanceManager.containsInstance(customViewCallback)) {
            this.api.create(Long.valueOf(this.instanceManager.addHostCreatedInstance(customViewCallback)), reply);
        }
    }

    @VisibleForTesting
    public void setApi(@NonNull GeneratedAndroidWebView.CustomViewCallbackFlutterApi customViewCallbackFlutterApi) {
        this.api = customViewCallbackFlutterApi;
    }
}
