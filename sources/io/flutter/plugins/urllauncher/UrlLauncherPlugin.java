package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugins.urllauncher.Messages;

public final class UrlLauncherPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "UrlLauncherPlugin";
    @Nullable
    private UrlLauncher urlLauncher;

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        UrlLauncher urlLauncher2 = this.urlLauncher;
        if (urlLauncher2 == null) {
            Log.wtf(TAG, "urlLauncher was never set.");
        } else {
            urlLauncher2.setActivity(activityPluginBinding.getActivity());
        }
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.urlLauncher = new UrlLauncher(flutterPluginBinding.getApplicationContext());
        Messages.UrlLauncherApi.setup(flutterPluginBinding.getBinaryMessenger(), this.urlLauncher);
    }

    public void onDetachedFromActivity() {
        UrlLauncher urlLauncher2 = this.urlLauncher;
        if (urlLauncher2 == null) {
            Log.wtf(TAG, "urlLauncher was never set.");
        } else {
            urlLauncher2.setActivity((Activity) null);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (this.urlLauncher == null) {
            Log.wtf(TAG, "Already detached from the engine.");
            return;
        }
        Messages.UrlLauncherApi.setup(flutterPluginBinding.getBinaryMessenger(), (Messages.UrlLauncherApi) null);
        this.urlLauncher = null;
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
