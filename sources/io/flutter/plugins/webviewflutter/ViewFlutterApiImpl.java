package io.flutter.plugins.webviewflutter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class ViewFlutterApiImpl {
    private GeneratedAndroidWebView.ViewFlutterApi api;
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public ViewFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.api = new GeneratedAndroidWebView.ViewFlutterApi(binaryMessenger2);
    }

    public void create(@NonNull View view, @NonNull GeneratedAndroidWebView.ViewFlutterApi.Reply<Void> reply) {
        if (!this.instanceManager.containsInstance(view)) {
            this.api.create(Long.valueOf(this.instanceManager.addHostCreatedInstance(view)), reply);
        }
    }

    @VisibleForTesting
    public void setApi(@NonNull GeneratedAndroidWebView.ViewFlutterApi viewFlutterApi) {
        this.api = viewFlutterApi;
    }
}
