package com.crazecoder.flutterbugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.crazecoder.flutterbugly.bean.BuglyInitResultInfo;
import com.crazecoder.flutterbugly.utils.JsonUtil;
import com.crazecoder.flutterbugly.utils.MapUtil;
import com.honey.account.constant.AccountConstantKt;
import com.tencent.bugly.crashreport.CrashReport;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.relay.api.IntentKey;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

public class FlutterBuglyPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel.Result f2804a;
    public boolean b = false;
    public MethodChannel c;
    public FlutterPlugin.FlutterPluginBinding d;

    private Context a() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.d;
        if (flutterPluginBinding == null) {
            return null;
        }
        return flutterPluginBinding.getApplicationContext();
    }

    public final BuglyInitResultInfo b(boolean z, String str, String str2) {
        BuglyInitResultInfo buglyInitResultInfo = new BuglyInitResultInfo();
        buglyInitResultInfo.setSuccess(z);
        buglyInitResultInfo.setAppId(str);
        buglyInitResultInfo.setMessage(str2);
        return buglyInitResultInfo;
    }

    public final void c(MethodCall methodCall) {
        String str = methodCall.hasArgument("crash_message") ? (String) methodCall.argument("crash_message") : "";
        String str2 = methodCall.hasArgument("crash_detail") ? (String) methodCall.argument("crash_detail") : null;
        if (!TextUtils.isEmpty(str2)) {
            CrashReport.postException(8, "Flutter Exception", str, str2, (Map<String, String>) null);
        }
    }

    public final void d(Object obj) {
        MethodChannel.Result result = this.f2804a;
        if (result != null && !this.b) {
            if (obj == null) {
                result.success((Object) null);
            } else {
                result.success(JsonUtil.a(MapUtil.a(obj)));
            }
            this.b = true;
        }
    }

    public final void e(MethodCall methodCall, CrashReport.UserStrategy userStrategy) {
        if (methodCall.hasArgument("appPackage")) {
            String str = (String) methodCall.argument("appPackage");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (userStrategy == null) {
                CrashReport.setAppPackage(a(), str);
            } else {
                userStrategy.setAppPackageName(str);
            }
        }
    }

    public final void f(MethodCall methodCall, CrashReport.UserStrategy userStrategy) {
        if (methodCall.hasArgument("appVersion")) {
            String str = (String) methodCall.argument("appVersion");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (userStrategy == null) {
                CrashReport.setAppVersion(a(), str);
            } else {
                userStrategy.setAppVersion(str);
            }
        }
    }

    public final void g(MethodCall methodCall, CrashReport.UserStrategy userStrategy) {
        if (methodCall.hasArgument("channel")) {
            String str = (String) methodCall.argument("channel");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (userStrategy == null) {
                CrashReport.setAppChannel(a(), str);
            } else {
                userStrategy.setAppChannel(str);
            }
        }
    }

    public final void h(MethodCall methodCall, CrashReport.UserStrategy userStrategy) {
        if (methodCall.hasArgument(Constants.DEVICE_ID)) {
            String str = (String) methodCall.argument(Constants.DEVICE_ID);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (userStrategy == null) {
                CrashReport.setDeviceId(a(), str);
            } else {
                userStrategy.setDeviceID(str);
            }
        }
    }

    public final void i(MethodCall methodCall, CrashReport.UserStrategy userStrategy) {
        if (methodCall.hasArgument("deviceModel")) {
            String str = (String) methodCall.argument("deviceModel");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (userStrategy == null) {
                CrashReport.setDeviceModel(a(), str);
            } else {
                userStrategy.setDeviceModel(str);
            }
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Log.d("FlutterBuglyPlugin", "onAttachedToActivity");
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.d("FlutterBuglyPlugin", "onAttachedToEngine, flutterEngine: " + flutterPluginBinding.getFlutterEngine());
        this.d = flutterPluginBinding;
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "crazecoder/flutter_bugly");
        this.c = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        Log.d("FlutterBuglyPlugin", "onDetachedFromActivity");
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.d("FlutterBuglyPlugin", "onDetachedFromEngine");
        this.c.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.d = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Integer num;
        Log.d("FlutterBuglyPlugin", "onMethodCall, method: " + methodCall.method);
        this.b = false;
        this.f2804a = result;
        if (methodCall.method.equals("initBugly")) {
            if (methodCall.hasArgument("appId")) {
                String obj = methodCall.argument("appId").toString();
                CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(a());
                g(methodCall, userStrategy);
                h(methodCall, userStrategy);
                i(methodCall, userStrategy);
                f(methodCall, userStrategy);
                e(methodCall, userStrategy);
                if (methodCall.hasArgument("initDelay")) {
                    userStrategy.setAppReportDelay(Long.parseLong(methodCall.argument("initDelay").toString()));
                }
                if (methodCall.hasArgument("enableCatchAnrTrace")) {
                    userStrategy.setEnableCatchAnrTrace(((Boolean) methodCall.argument("enableCatchAnrTrace")).booleanValue());
                }
                if (methodCall.hasArgument("enableRecordAnrMainStack")) {
                    userStrategy.setEnableRecordAnrMainStack(((Boolean) methodCall.argument("enableRecordAnrMainStack")).booleanValue());
                }
                CrashReport.initCrashReport(a(), obj, false);
                d(b(true, obj, "Bugly 初始化成功"));
                return;
            }
            d(b(false, (String) null, "Bugly appId不能为空"));
        } else if (methodCall.method.equals("setUserId")) {
            if (methodCall.hasArgument("userId")) {
                CrashReport.setUserId(a(), (String) methodCall.argument("userId"));
            }
            d((Object) null);
        } else if (methodCall.method.equals("setUserTag")) {
            if (methodCall.hasArgument("userTag") && (num = (Integer) methodCall.argument("userTag")) != null) {
                CrashReport.setUserSceneTag(a(), num.intValue());
            }
            d((Object) null);
        } else if (methodCall.method.equals("setChannel")) {
            g(methodCall, (CrashReport.UserStrategy) null);
            d((Object) null);
        } else if (methodCall.method.equals("setDeviceID")) {
            h(methodCall, (CrashReport.UserStrategy) null);
            d((Object) null);
        } else if (methodCall.method.equals("setDeviceModel")) {
            i(methodCall, (CrashReport.UserStrategy) null);
            d((Object) null);
        } else if (methodCall.method.equals("setAppVersion")) {
            f(methodCall, (CrashReport.UserStrategy) null);
            d((Object) null);
        } else if (methodCall.method.equals("setAppPackageName")) {
            e(methodCall, (CrashReport.UserStrategy) null);
            d((Object) null);
        } else if (methodCall.method.equals("putUserData")) {
            if (methodCall.hasArgument(IntentKey.ACTIVITY.ACTION_KEY) && methodCall.hasArgument(AccountConstantKt.RESPONSE_VALUE)) {
                CrashReport.putUserData(a(), (String) methodCall.argument(IntentKey.ACTIVITY.ACTION_KEY), (String) methodCall.argument(AccountConstantKt.RESPONSE_VALUE));
            }
            d((Object) null);
        } else if (methodCall.method.equals("postCatchedException")) {
            c(methodCall);
            d((Object) null);
        } else {
            result.notImplemented();
            this.b = true;
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }
}
