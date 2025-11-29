package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import androidx.annotation.NonNull;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class JavaScriptChannelHostApiImpl implements GeneratedAndroidWebView.JavaScriptChannelHostApi {
    private final JavaScriptChannelFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;
    private final JavaScriptChannelCreator javaScriptChannelCreator;
    private Handler platformThreadHandler;

    public static class JavaScriptChannelCreator {
        @NonNull
        public JavaScriptChannel createJavaScriptChannel(@NonNull JavaScriptChannelFlutterApiImpl javaScriptChannelFlutterApiImpl, @NonNull String str, @NonNull Handler handler) {
            return new JavaScriptChannel(javaScriptChannelFlutterApiImpl, str, handler);
        }
    }

    public JavaScriptChannelHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull JavaScriptChannelCreator javaScriptChannelCreator2, @NonNull JavaScriptChannelFlutterApiImpl javaScriptChannelFlutterApiImpl, @NonNull Handler handler) {
        this.instanceManager = instanceManager2;
        this.javaScriptChannelCreator = javaScriptChannelCreator2;
        this.flutterApi = javaScriptChannelFlutterApiImpl;
        this.platformThreadHandler = handler;
    }

    public void create(@NonNull Long l, @NonNull String str) {
        this.instanceManager.addDartCreatedInstance(this.javaScriptChannelCreator.createJavaScriptChannel(this.flutterApi, str, this.platformThreadHandler), l.longValue());
    }

    public void setPlatformThreadHandler(@NonNull Handler handler) {
        this.platformThreadHandler = handler;
    }
}
