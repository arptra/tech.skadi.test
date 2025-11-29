package io.flutter.plugins.webviewflutter;

import android.webkit.HttpAuthHandler;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class HttpAuthHandlerFlutterApiImpl {
    private final GeneratedAndroidWebView.HttpAuthHandlerFlutterApi api;
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public HttpAuthHandlerFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.api = new GeneratedAndroidWebView.HttpAuthHandlerFlutterApi(binaryMessenger2);
    }

    public void create(@NonNull HttpAuthHandler httpAuthHandler, @NonNull GeneratedAndroidWebView.HttpAuthHandlerFlutterApi.Reply<Void> reply) {
        if (!this.instanceManager.containsInstance(httpAuthHandler)) {
            this.api.create(Long.valueOf(this.instanceManager.addHostCreatedInstance(httpAuthHandler)), reply);
        }
    }
}
