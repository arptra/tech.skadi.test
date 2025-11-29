package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.codec.language.bm.Languages;

public class FilePickerPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
    public static String i = null;
    public static boolean j = false;
    public static boolean k = false;
    public static int l;

    /* renamed from: a  reason: collision with root package name */
    public ActivityPluginBinding f9810a;
    public FilePickerDelegate b;
    public Application c;
    public FlutterPlugin.FlutterPluginBinding d;
    public Lifecycle e;
    public LifeCycleObserver f;
    public Activity g;
    public MethodChannel h;

    public class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f9812a;

        public LifeCycleObserver(Activity activity) {
            this.f9812a = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f9812a == activity && activity.getApplicationContext() != null) {
                ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onCreate(LifecycleOwner lifecycleOwner) {
        }

        public void onDestroy(LifecycleOwner lifecycleOwner) {
            onActivityDestroyed(this.f9812a);
        }

        public void onPause(LifecycleOwner lifecycleOwner) {
        }

        public void onResume(LifecycleOwner lifecycleOwner) {
        }

        public void onStart(LifecycleOwner lifecycleOwner) {
        }

        public void onStop(LifecycleOwner lifecycleOwner) {
            onActivityStopped(this.f9812a);
        }
    }

    public static class MethodResultWrapper implements MethodChannel.Result {

        /* renamed from: a  reason: collision with root package name */
        public final MethodChannel.Result f9813a;
        public final Handler b = new Handler(Looper.getMainLooper());

        public MethodResultWrapper(MethodChannel.Result result) {
            this.f9813a = result;
        }

        public void error(final String str, final String str2, final Object obj) {
            this.b.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.f9813a.error(str, str2, obj);
                }
            });
        }

        public void notImplemented() {
            this.b.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.f9813a.notImplemented();
                }
            });
        }

        public void success(final Object obj) {
            this.b.post(new Runnable() {
                public void run() {
                    MethodResultWrapper.this.f9813a.success(obj);
                }
            });
        }
    }

    public static String b(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1349088399:
                if (str.equals(SchedulerSupport.CUSTOM)) {
                    c2 = 0;
                    break;
                }
                break;
            case 96748:
                if (str.equals(Languages.ANY)) {
                    c2 = 1;
                    break;
                }
                break;
            case 99469:
                if (str.equals("dir")) {
                    c2 = 2;
                    break;
                }
                break;
            case 93166550:
                if (str.equals("audio")) {
                    c2 = 3;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c2 = 4;
                    break;
                }
                break;
            case 103772132:
                if (str.equals(VuiModelType.MEDIA)) {
                    c2 = 5;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return "*/*";
            case 2:
                return "dir";
            case 3:
                return RecordConstants.SHARE_TYPE_AUDIO;
            case 4:
                return "image/*";
            case 5:
                return "image/*,video/*";
            case 6:
                return "video/*";
            default:
                return null;
        }
    }

    public final void c(BinaryMessenger binaryMessenger, Application application, Activity activity, ActivityPluginBinding activityPluginBinding) {
        this.g = activity;
        this.c = application;
        this.b = new FilePickerDelegate(activity);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "miguelruivo.flutter.plugins.filepicker");
        this.h = methodChannel;
        methodChannel.setMethodCallHandler(this);
        new EventChannel(binaryMessenger, "miguelruivo.flutter.plugins.filepickerevent").setStreamHandler(new EventChannel.StreamHandler() {
            public void onCancel(Object obj) {
                FilePickerPlugin.this.b.p((EventChannel.EventSink) null);
            }

            public void onListen(Object obj, EventChannel.EventSink eventSink) {
                FilePickerPlugin.this.b.p(eventSink);
            }
        });
        this.f = new LifeCycleObserver(activity);
        activityPluginBinding.addActivityResultListener(this.b);
        Lifecycle activityLifecycle = FlutterLifecycleAdapter.getActivityLifecycle(activityPluginBinding);
        this.e = activityLifecycle;
        activityLifecycle.a(this.f);
    }

    public final void d() {
        this.f9810a.removeActivityResultListener(this.b);
        this.f9810a = null;
        LifeCycleObserver lifeCycleObserver = this.f;
        if (lifeCycleObserver != null) {
            this.e.d(lifeCycleObserver);
            this.c.unregisterActivityLifecycleCallbacks(this.f);
        }
        this.e = null;
        this.b.p((EventChannel.EventSink) null);
        this.b = null;
        this.h.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.h = null;
        this.c = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.f9810a = activityPluginBinding;
        c(this.d.getBinaryMessenger(), (Application) this.d.getApplicationContext(), this.f9810a.getActivity(), this.f9810a);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.d = flutterPluginBinding;
    }

    public void onDetachedFromActivity() {
        d();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.d = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String[] strArr;
        String str;
        if (this.g == null) {
            result.error("no_activity", "file picker plugin requires a foreground activity", (Object) null);
            return;
        }
        MethodResultWrapper methodResultWrapper = new MethodResultWrapper(result);
        HashMap hashMap = (HashMap) methodCall.arguments;
        String str2 = methodCall.method;
        if (str2 == null || !str2.equals("clear")) {
            String str3 = methodCall.method;
            if (str3 == null || !str3.equals("save")) {
                String b2 = b(methodCall.method);
                i = b2;
                if (b2 == null) {
                    methodResultWrapper.notImplemented();
                } else if (b2 != "dir") {
                    j = ((Boolean) hashMap.get("allowMultipleSelection")).booleanValue();
                    k = ((Boolean) hashMap.get("withData")).booleanValue();
                    l = ((Integer) hashMap.get("compressionQuality")).intValue();
                    strArr = FileUtils.h((ArrayList) hashMap.get("allowedExtensions"));
                    str = methodCall.method;
                    if (str == null && !str.equals(SchedulerSupport.CUSTOM) && (strArr == null || strArr.length == 0)) {
                        methodResultWrapper.error("FilePicker", "Unsupported filter. Make sure that you are only using the extension without the dot, (ie., jpg instead of .jpg). This could also have happened because you are using an unsupported file extension.  If the problem persists, you may want to consider using FileType.any instead.", (Object) null);
                        return;
                    } else {
                        this.b.s(i, j, k, strArr, l, methodResultWrapper);
                        return;
                    }
                }
                strArr = null;
                str = methodCall.method;
                if (str == null && !str.equals(SchedulerSupport.CUSTOM)) {
                }
                this.b.s(i, j, k, strArr, l, methodResultWrapper);
                return;
            }
            this.b.o((String) hashMap.get("fileName"), b((String) hashMap.get("fileType")), (String) hashMap.get("initialDirectory"), FileUtils.h((ArrayList) hashMap.get("allowedExtensions")), (byte[]) hashMap.get("bytes"), methodResultWrapper);
            return;
        }
        methodResultWrapper.success(Boolean.valueOf(FileUtils.a(this.g.getApplicationContext())));
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
