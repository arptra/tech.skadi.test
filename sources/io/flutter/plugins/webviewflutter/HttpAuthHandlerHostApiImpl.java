package io.flutter.plugins.webviewflutter;

import android.webkit.HttpAuthHandler;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class HttpAuthHandlerHostApiImpl implements GeneratedAndroidWebView.HttpAuthHandlerHostApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public HttpAuthHandlerHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
    }

    private HttpAuthHandler getHttpAuthHandlerInstance(@NonNull Long l) {
        HttpAuthHandler httpAuthHandler = (HttpAuthHandler) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(httpAuthHandler);
        return httpAuthHandler;
    }

    public void cancel(@NonNull Long l) {
        getHttpAuthHandlerInstance(l).cancel();
    }

    public void proceed(@NonNull Long l, @NonNull String str, @NonNull String str2) {
        getHttpAuthHandlerInstance(l).proceed(str, str2);
    }

    @NonNull
    public Boolean useHttpAuthUsernamePassword(@NonNull Long l) {
        return Boolean.valueOf(getHttpAuthHandlerInstance(l).useHttpAuthUsernamePassword());
    }
}
