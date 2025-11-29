package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.hb.v4;
import com.honey.account.hb.w4;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugins.webviewflutter.DownloadListenerHostApiImpl;
import io.flutter.plugins.webviewflutter.FlutterAssetManager;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.JavaScriptChannelHostApiImpl;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import io.flutter.plugins.webviewflutter.WebSettingsHostApiImpl;
import io.flutter.plugins.webviewflutter.WebStorageHostApiImpl;
import io.flutter.plugins.webviewflutter.WebViewClientHostApiImpl;
import io.flutter.plugins.webviewflutter.WebViewHostApiImpl;

public class WebViewFlutterPlugin implements FlutterPlugin, ActivityAware {
    @Nullable
    private InstanceManager instanceManager;
    private JavaScriptChannelHostApiImpl javaScriptChannelHostApi;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private WebViewHostApiImpl webViewHostApi;

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUp$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUp$2() {
        this.instanceManager.clear();
    }

    private void setUp(BinaryMessenger binaryMessenger, PlatformViewRegistry platformViewRegistry, Context context, FlutterAssetManager flutterAssetManager) {
        this.instanceManager = InstanceManager.create(new v4(binaryMessenger));
        GeneratedAndroidWebView.InstanceManagerHostApi.setup(binaryMessenger, new w4(this));
        platformViewRegistry.registerViewFactory("plugins.flutter.io/webview", new FlutterViewFactory(this.instanceManager));
        this.webViewHostApi = new WebViewHostApiImpl(this.instanceManager, binaryMessenger, new WebViewHostApiImpl.WebViewProxy(), context);
        this.javaScriptChannelHostApi = new JavaScriptChannelHostApiImpl(this.instanceManager, new JavaScriptChannelHostApiImpl.JavaScriptChannelCreator(), new JavaScriptChannelFlutterApiImpl(binaryMessenger, this.instanceManager), new Handler(context.getMainLooper()));
        GeneratedAndroidWebView.JavaObjectHostApi.setup(binaryMessenger, new JavaObjectHostApiImpl(this.instanceManager));
        GeneratedAndroidWebView.WebViewHostApi.setup(binaryMessenger, this.webViewHostApi);
        GeneratedAndroidWebView.JavaScriptChannelHostApi.setup(binaryMessenger, this.javaScriptChannelHostApi);
        GeneratedAndroidWebView.WebViewClientHostApi.setup(binaryMessenger, new WebViewClientHostApiImpl(this.instanceManager, new WebViewClientHostApiImpl.WebViewClientCreator(), new WebViewClientFlutterApiImpl(binaryMessenger, this.instanceManager)));
        GeneratedAndroidWebView.WebChromeClientHostApi.setup(binaryMessenger, new WebChromeClientHostApiImpl(this.instanceManager, new WebChromeClientHostApiImpl.WebChromeClientCreator(), new WebChromeClientFlutterApiImpl(binaryMessenger, this.instanceManager)));
        GeneratedAndroidWebView.DownloadListenerHostApi.setup(binaryMessenger, new DownloadListenerHostApiImpl(this.instanceManager, new DownloadListenerHostApiImpl.DownloadListenerCreator(), new DownloadListenerFlutterApiImpl(binaryMessenger, this.instanceManager)));
        GeneratedAndroidWebView.WebSettingsHostApi.setup(binaryMessenger, new WebSettingsHostApiImpl(this.instanceManager, new WebSettingsHostApiImpl.WebSettingsCreator()));
        GeneratedAndroidWebView.FlutterAssetManagerHostApi.setup(binaryMessenger, new FlutterAssetManagerHostApiImpl(flutterAssetManager));
        GeneratedAndroidWebView.CookieManagerHostApi.setup(binaryMessenger, new CookieManagerHostApiImpl(binaryMessenger, this.instanceManager));
        GeneratedAndroidWebView.WebStorageHostApi.setup(binaryMessenger, new WebStorageHostApiImpl(this.instanceManager, new WebStorageHostApiImpl.WebStorageCreator()));
        GeneratedAndroidWebView.PermissionRequestHostApi.setup(binaryMessenger, new PermissionRequestHostApiImpl(binaryMessenger, this.instanceManager));
        GeneratedAndroidWebView.GeolocationPermissionsCallbackHostApi.setup(binaryMessenger, new GeolocationPermissionsCallbackHostApiImpl(binaryMessenger, this.instanceManager));
        GeneratedAndroidWebView.CustomViewCallbackHostApi.setup(binaryMessenger, new CustomViewCallbackHostApiImpl(binaryMessenger, this.instanceManager));
        GeneratedAndroidWebView.HttpAuthHandlerHostApi.setup(binaryMessenger, new HttpAuthHandlerHostApiImpl(binaryMessenger, this.instanceManager));
    }

    private void updateContext(Context context) {
        this.webViewHostApi.setContext(context);
        this.javaScriptChannelHostApi.setPlatformThreadHandler(new Handler(context.getMainLooper()));
    }

    @Nullable
    public InstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        updateContext(activityPluginBinding.getActivity());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
        setUp(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getPlatformViewRegistry(), flutterPluginBinding.getApplicationContext(), new FlutterAssetManager.PluginBindingFlutterAssetManager(flutterPluginBinding.getApplicationContext().getAssets(), flutterPluginBinding.getFlutterAssets()));
    }

    public void onDetachedFromActivity() {
        updateContext(this.pluginBinding.getApplicationContext());
    }

    public void onDetachedFromActivityForConfigChanges() {
        updateContext(this.pluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        InstanceManager instanceManager2 = this.instanceManager;
        if (instanceManager2 != null) {
            instanceManager2.stopFinalizationListener();
            this.instanceManager = null;
        }
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        updateContext(activityPluginBinding.getActivity());
    }
}
