package io.flutter.plugins.webviewflutter;

import android.webkit.GeolocationPermissions;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class GeolocationPermissionsCallbackHostApiImpl implements GeneratedAndroidWebView.GeolocationPermissionsCallbackHostApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public GeolocationPermissionsCallbackHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
    }

    private GeolocationPermissions.Callback getGeolocationPermissionsCallbackInstance(@NonNull Long l) {
        GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(callback);
        return callback;
    }

    public void invoke(@NonNull Long l, @NonNull String str, @NonNull Boolean bool, @NonNull Boolean bool2) {
        getGeolocationPermissionsCallbackInstance(l).invoke(str, bool.booleanValue(), bool2.booleanValue());
    }
}
