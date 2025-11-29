package io.flutter.plugin.text;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.systemchannels.ProcessTextChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.Map;

public class ProcessTextPlugin implements FlutterPlugin, ActivityAware, PluginRegistry.ActivityResultListener, ProcessTextChannel.ProcessTextMethodHandler {
    private static final String TAG = "ProcessTextPlugin";
    @Nullable
    private ActivityPluginBinding activityBinding;
    @NonNull
    private final PackageManager packageManager;
    @NonNull
    private final ProcessTextChannel processTextChannel;
    @NonNull
    private Map<Integer, MethodChannel.Result> requestsByCode = new HashMap();
    private Map<String, ResolveInfo> resolveInfosById;

    public ProcessTextPlugin(@NonNull ProcessTextChannel processTextChannel2) {
        this.processTextChannel = processTextChannel2;
        this.packageManager = processTextChannel2.packageManager;
        processTextChannel2.setMethodHandler(this);
    }

    private void cacheResolveInfos() {
        this.resolveInfosById = new HashMap();
        int i = Build.VERSION.SDK_INT;
        Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        for (ResolveInfo next : i >= 33 ? this.packageManager.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0)) : this.packageManager.queryIntentActivities(type, 0)) {
            String str = next.activityInfo.name;
            next.loadLabel(this.packageManager).toString();
            this.resolveInfosById.put(str, next);
        }
    }

    public void destroy() {
        this.processTextChannel.setMethodHandler((ProcessTextChannel.ProcessTextMethodHandler) null);
    }

    @RequiresApi
    @TargetApi(23)
    public boolean onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (!this.requestsByCode.containsKey(Integer.valueOf(i))) {
            return false;
        }
        this.requestsByCode.remove(Integer.valueOf(i)).success(i2 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
        return true;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
        activityPluginBinding.addActivityResultListener(this);
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onDetachedFromActivity() {
        this.activityBinding.removeActivityResultListener(this);
        this.activityBinding = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.activityBinding.removeActivityResultListener(this);
        this.activityBinding = null;
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
        activityPluginBinding.addActivityResultListener(this);
    }

    public void processTextAction(@NonNull String str, @NonNull String str2, @NonNull boolean z, @NonNull MethodChannel.Result result) {
        if (this.activityBinding == null) {
            result.error("error", "Plugin not bound to an Activity", (Object) null);
            return;
        }
        Map<String, ResolveInfo> map = this.resolveInfosById;
        if (map == null) {
            result.error("error", "Can not process text actions before calling queryTextActions", (Object) null);
            return;
        }
        ResolveInfo resolveInfo = map.get(str);
        if (resolveInfo == null) {
            result.error("error", "Text processing activity not found", (Object) null);
            return;
        }
        int hashCode = result.hashCode();
        this.requestsByCode.put(Integer.valueOf(hashCode), result);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z);
        this.activityBinding.getActivity().startActivityForResult(intent, hashCode);
    }

    public Map<String, String> queryTextActions() {
        if (this.resolveInfosById == null) {
            cacheResolveInfos();
        }
        HashMap hashMap = new HashMap();
        for (String next : this.resolveInfosById.keySet()) {
            hashMap.put(next, this.resolveInfosById.get(next).loadLabel(this.packageManager).toString());
        }
        return hashMap;
    }
}
