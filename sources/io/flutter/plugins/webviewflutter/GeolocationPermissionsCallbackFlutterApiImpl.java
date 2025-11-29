package io.flutter.plugins.webviewflutter;

import android.webkit.GeolocationPermissions;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class GeolocationPermissionsCallbackFlutterApiImpl {
    private GeneratedAndroidWebView.GeolocationPermissionsCallbackFlutterApi api;
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public GeolocationPermissionsCallbackFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.api = new GeneratedAndroidWebView.GeolocationPermissionsCallbackFlutterApi(binaryMessenger2);
    }

    public void create(@NonNull GeolocationPermissions.Callback callback, @NonNull GeneratedAndroidWebView.GeolocationPermissionsCallbackFlutterApi.Reply<Void> reply) {
        if (!this.instanceManager.containsInstance(callback)) {
            this.api.create(Long.valueOf(this.instanceManager.addHostCreatedInstance(callback)), reply);
        }
    }

    @VisibleForTesting
    public void setApi(@NonNull GeneratedAndroidWebView.GeolocationPermissionsCallbackFlutterApi geolocationPermissionsCallbackFlutterApi) {
        this.api = geolocationPermissionsCallbackFlutterApi;
    }
}
