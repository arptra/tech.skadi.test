package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public final class PermissionHandlerPlugin implements FlutterPlugin, ActivityAware {

    /* renamed from: a  reason: collision with root package name */
    public PermissionManager f2401a;
    public MethodChannel b;
    public ActivityPluginBinding c;
    public MethodCallHandlerImpl d;

    public final void a() {
        ActivityPluginBinding activityPluginBinding = this.c;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.f2401a);
            this.c.removeRequestPermissionsResultListener(this.f2401a);
        }
    }

    public final void b() {
        ActivityPluginBinding activityPluginBinding = this.c;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.f2401a);
            this.c.addRequestPermissionsResultListener(this.f2401a);
        }
    }

    public final void c(Context context, BinaryMessenger binaryMessenger) {
        this.b = new MethodChannel(binaryMessenger, "flutter.baseflow.com/permissions/methods");
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(context, new AppSettingsManager(), this.f2401a, new ServiceManager());
        this.d = methodCallHandlerImpl;
        this.b.setMethodCallHandler(methodCallHandlerImpl);
    }

    public final void d(Activity activity) {
        PermissionManager permissionManager = this.f2401a;
        if (permissionManager != null) {
            permissionManager.h(activity);
        }
    }

    public final void e() {
        this.b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.b = null;
        this.d = null;
    }

    public final void f() {
        PermissionManager permissionManager = this.f2401a;
        if (permissionManager != null) {
            permissionManager.h((Activity) null);
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        d(activityPluginBinding.getActivity());
        this.c = activityPluginBinding;
        b();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f2401a = new PermissionManager(flutterPluginBinding.getApplicationContext());
        c(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        f();
        a();
        this.c = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        e();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
