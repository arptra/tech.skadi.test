package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class FlutterPluginRegistry implements PluginRegistry, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.WindowFocusChangedListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener {
    private static final String TAG = "FlutterPluginRegistry";
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public final List<PluginRegistry.ActivityResultListener> mActivityResultListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public Context mAppContext;
    /* access modifiers changed from: private */
    public FlutterView mFlutterView;
    /* access modifiers changed from: private */
    public FlutterNativeView mNativeView;
    /* access modifiers changed from: private */
    public final List<PluginRegistry.NewIntentListener> mNewIntentListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public final PlatformViewsController mPlatformViewsController;
    /* access modifiers changed from: private */
    public final Map<String, Object> mPluginMap = new LinkedHashMap(0);
    /* access modifiers changed from: private */
    public final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners = new ArrayList(0);
    /* access modifiers changed from: private */
    public final List<PluginRegistry.WindowFocusChangedListener> mWindowFocusChangedListeners = new ArrayList(0);

    public class FlutterRegistrar implements PluginRegistry.Registrar {
        private final String pluginKey;

        public FlutterRegistrar(String str) {
            this.pluginKey = str;
        }

        public Context activeContext() {
            Activity access$000 = FlutterPluginRegistry.this.mActivity;
            FlutterPluginRegistry flutterPluginRegistry = FlutterPluginRegistry.this;
            return access$000 != null ? flutterPluginRegistry.mActivity : flutterPluginRegistry.mAppContext;
        }

        public Activity activity() {
            return FlutterPluginRegistry.this.mActivity;
        }

        public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            FlutterPluginRegistry.this.mActivityResultListeners.add(activityResultListener);
            return this;
        }

        public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            FlutterPluginRegistry.this.mNewIntentListeners.add(newIntentListener);
            return this;
        }

        public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            FlutterPluginRegistry.this.mRequestPermissionsResultListeners.add(requestPermissionsResultListener);
            return this;
        }

        public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            FlutterPluginRegistry.this.mUserLeaveHintListeners.add(userLeaveHintListener);
            return this;
        }

        public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
            FlutterPluginRegistry.this.mViewDestroyListeners.add(viewDestroyListener);
            return this;
        }

        public PluginRegistry.Registrar addWindowFocusChangedListener(PluginRegistry.WindowFocusChangedListener windowFocusChangedListener) {
            FlutterPluginRegistry.this.mWindowFocusChangedListeners.add(windowFocusChangedListener);
            return this;
        }

        public Context context() {
            return FlutterPluginRegistry.this.mAppContext;
        }

        public String lookupKeyForAsset(String str) {
            return FlutterMain.getLookupKeyForAsset(str);
        }

        public BinaryMessenger messenger() {
            return FlutterPluginRegistry.this.mNativeView;
        }

        public PlatformViewRegistry platformViewRegistry() {
            return FlutterPluginRegistry.this.mPlatformViewsController.getRegistry();
        }

        public PluginRegistry.Registrar publish(Object obj) {
            FlutterPluginRegistry.this.mPluginMap.put(this.pluginKey, obj);
            return this;
        }

        public TextureRegistry textures() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        public FlutterView view() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        public String lookupKeyForAsset(String str, String str2) {
            return FlutterMain.getLookupKeyForAsset(str, str2);
        }
    }

    public FlutterPluginRegistry(FlutterNativeView flutterNativeView, Context context) {
        this.mNativeView = flutterNativeView;
        this.mAppContext = context;
        this.mPlatformViewsController = new PlatformViewsController();
    }

    public void attach(FlutterView flutterView, Activity activity) {
        this.mFlutterView = flutterView;
        this.mActivity = activity;
        this.mPlatformViewsController.attach(activity, flutterView, flutterView.getDartExecutor());
    }

    public void destroy() {
        this.mPlatformViewsController.onDetachedFromJNI();
    }

    public void detach() {
        this.mPlatformViewsController.detach();
        this.mPlatformViewsController.onDetachedFromJNI();
        this.mFlutterView = null;
        this.mActivity = null;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.mPlatformViewsController;
    }

    public boolean hasPlugin(String str) {
        return this.mPluginMap.containsKey(str);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        for (PluginRegistry.ActivityResultListener onActivityResult : this.mActivityResultListeners) {
            if (onActivityResult.onActivityResult(i, i2, intent)) {
                return true;
            }
        }
        return false;
    }

    public boolean onNewIntent(Intent intent) {
        for (PluginRegistry.NewIntentListener onNewIntent : this.mNewIntentListeners) {
            if (onNewIntent.onNewIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public void onPreEngineRestart() {
        this.mPlatformViewsController.onPreEngineRestart();
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        for (PluginRegistry.RequestPermissionsResultListener onRequestPermissionsResult : this.mRequestPermissionsResultListeners) {
            if (onRequestPermissionsResult.onRequestPermissionsResult(i, strArr, iArr)) {
                return true;
            }
        }
        return false;
    }

    public void onUserLeaveHint() {
        for (PluginRegistry.UserLeaveHintListener onUserLeaveHint : this.mUserLeaveHintListeners) {
            onUserLeaveHint.onUserLeaveHint();
        }
    }

    public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        boolean z = false;
        for (PluginRegistry.ViewDestroyListener onViewDestroy : this.mViewDestroyListeners) {
            if (onViewDestroy.onViewDestroy(flutterNativeView)) {
                z = true;
            }
        }
        return z;
    }

    public void onWindowFocusChanged(boolean z) {
        for (PluginRegistry.WindowFocusChangedListener onWindowFocusChanged : this.mWindowFocusChangedListeners) {
            onWindowFocusChanged.onWindowFocusChanged(z);
        }
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        if (!this.mPluginMap.containsKey(str)) {
            this.mPluginMap.put(str, (Object) null);
            return new FlutterRegistrar(str);
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.mPluginMap.get(str);
    }

    public FlutterPluginRegistry(FlutterEngine flutterEngine, Context context) {
        this.mAppContext = context;
        this.mPlatformViewsController = new PlatformViewsController();
    }
}
