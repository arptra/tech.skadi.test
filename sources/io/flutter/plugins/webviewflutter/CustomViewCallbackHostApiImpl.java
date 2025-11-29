package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.Objects;

public class CustomViewCallbackHostApiImpl implements GeneratedAndroidWebView.CustomViewCallbackHostApi {
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public CustomViewCallbackHostApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
    }

    private WebChromeClient.CustomViewCallback getCustomViewCallbackInstance(@NonNull Long l) {
        WebChromeClient.CustomViewCallback customViewCallback = (WebChromeClient.CustomViewCallback) this.instanceManager.getInstance(l.longValue());
        Objects.requireNonNull(customViewCallback);
        return customViewCallback;
    }

    public void onCustomViewHidden(@NonNull Long l) {
        getCustomViewCallbackInstance(l).onCustomViewHidden();
    }
}
