package io.flutter.plugins.webviewflutter;

import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class JavaScriptChannelFlutterApiImpl extends GeneratedAndroidWebView.JavaScriptChannelFlutterApi {
    private final InstanceManager instanceManager;

    public JavaScriptChannelFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager2) {
        super(binaryMessenger);
        this.instanceManager = instanceManager2;
    }

    private long getIdentifierForJavaScriptChannel(JavaScriptChannel javaScriptChannel) {
        Long identifierForStrongReference = this.instanceManager.getIdentifierForStrongReference(javaScriptChannel);
        if (identifierForStrongReference != null) {
            return identifierForStrongReference.longValue();
        }
        throw new IllegalStateException("Could not find identifier for JavaScriptChannel.");
    }

    public void postMessage(@NonNull JavaScriptChannel javaScriptChannel, @NonNull String str, @NonNull GeneratedAndroidWebView.JavaScriptChannelFlutterApi.Reply<Void> reply) {
        super.postMessage(Long.valueOf(getIdentifierForJavaScriptChannel(javaScriptChannel)), str, reply);
    }
}
