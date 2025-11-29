package com.foo.statusbarcontrol;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class StatusBarControlPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    public static Activity b;

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel f2836a;

    public final float b() {
        return b.getResources().getDisplayMetrics().density;
    }

    public final void c(MethodCall methodCall, MethodChannel.Result result) {
        int i;
        try {
            int identifier = b.getResources().getIdentifier("status_bar_height", "dimen", "android");
            i = l(identifier > 0 ? b.getResources().getDimensionPixelSize(identifier) : 0);
        } catch (Exception unused) {
            Log.e("StatusBarControl", "StatusBarControl: failed return default: 32");
            i = 32;
        }
        result.success(Double.valueOf((double) i));
    }

    public final void d(MethodCall methodCall, MethodChannel.Result result) {
        int i = 0;
        try {
            WindowInsetsCompat H = ViewCompat.H(b.findViewById(16908290));
            if (H.q(WindowInsetsCompat.Type.a())) {
                i = l(H.f(WindowInsetsCompat.Type.a()).d - H.f(WindowInsetsCompat.Type.d()).d);
            }
        } catch (Exception e) {
            Log.e("StatusBarControl", "StatusBarControl handleGetKeyboardHeight: failed return default:  e" + e.toString() + "this:" + this);
        }
        result.success(Double.valueOf((double) i));
    }

    public final void e(MethodCall methodCall, MethodChannel.Result result) {
        int i;
        try {
            i = l(ViewCompat.H(b.findViewById(16908290)).f(WindowInsetsCompat.Type.d()).d);
        } catch (Exception e) {
            Log.e("StatusBarControl", "StatusBarControl handleGetNavHeight: failed return default:  e" + e.toString() + "this:" + this);
            i = 0;
        }
        result.success(Double.valueOf((double) i));
    }

    public final void f(MethodCall methodCall, MethodChannel.Result result) {
        if (b == null) {
            Log.e("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.");
            result.error("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.", (Object) null);
            return;
        }
        int intValue = ((Number) methodCall.argument("color")).intValue();
        boolean booleanValue = ((Boolean) methodCall.argument("animated")).booleanValue();
        b.getWindow().addFlags(Integer.MIN_VALUE);
        if (booleanValue) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(b.getWindow().getStatusBarColor()), Integer.valueOf(intValue)});
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StatusBarControlPlugin.b.getWindow().setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofObject.setDuration(300).setStartDelay(0);
            ofObject.start();
            result.success(Boolean.TRUE);
            return;
        }
        b.getWindow().setStatusBarColor(intValue);
        result.success(Boolean.TRUE);
    }

    public final void g(MethodCall methodCall, MethodChannel.Result result) {
        if (b == null) {
            Log.e("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.");
            result.error("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.", (Object) null);
            return;
        }
        if (((Boolean) methodCall.argument("hidden")).booleanValue()) {
            b.getWindow().addFlags(1024);
            b.getWindow().clearFlags(2048);
        } else {
            b.getWindow().addFlags(2048);
            b.getWindow().clearFlags(1024);
        }
        result.success(Boolean.TRUE);
    }

    public final void h(MethodCall methodCall, MethodChannel.Result result) {
        if (b == null) {
            Log.e("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.");
            result.error("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.", (Object) null);
            return;
        }
        int intValue = ((Number) methodCall.argument("color")).intValue();
        if (((Boolean) methodCall.argument("animated")).booleanValue()) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(b.getWindow().getNavigationBarColor()), Integer.valueOf(intValue)});
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StatusBarControlPlugin.b.getWindow().setNavigationBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofObject.setDuration(300).setStartDelay(0);
            ofObject.start();
            result.success(Boolean.TRUE);
            return;
        }
        b.getWindow().setNavigationBarColor(intValue);
        result.success(Boolean.TRUE);
    }

    public final void i(MethodCall methodCall, MethodChannel.Result result) {
        if (b == null) {
            Log.e("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.");
            result.error("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.", (Object) null);
            return;
        }
        View decorView = b.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(((String) methodCall.argument("style")).equals("dark") ? systemUiVisibility & -17 : systemUiVisibility | 16);
        result.success(Boolean.TRUE);
    }

    public final void j(MethodCall methodCall, MethodChannel.Result result) {
        if (b == null) {
            Log.e("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.");
            result.error("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.", (Object) null);
            return;
        }
        View decorView = b.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(((String) methodCall.argument("style")).equals("dark-content") ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        result.success(Boolean.TRUE);
    }

    public final void k(MethodCall methodCall, MethodChannel.Result result) {
        if (b == null) {
            Log.e("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.");
            result.error("StatusBarControl", "StatusBarControl: Ignored status bar change, current activity is null.", (Object) null);
            return;
        }
        boolean booleanValue = ((Boolean) methodCall.argument("translucent")).booleanValue();
        View decorView = b.getWindow().getDecorView();
        if (booleanValue) {
            decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                    return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
                }
            });
        } else {
            decorView.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        }
        ViewCompat.q0(decorView);
        result.success(Boolean.TRUE);
    }

    public final int l(int i) {
        return (int) ((((float) i) - 0.5f) / b());
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Log.d("StatusBarControl", "StatusBarControl: Attached to Activity");
        b = activityPluginBinding.getActivity();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.d("StatusBarControl", "StatusBarControl: Attached to Flutter Engine " + toString());
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "status_bar_control");
        this.f2836a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        Log.d("StatusBarControl", "StatusBarControl: Detached from Activity");
        b = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        Log.d("StatusBarControl", "StatusBarControl: Detached from Activity for Config changes");
        b = null;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.d("StatusBarControl", "StatusBarControl: Detached from Flutter Engine" + toString());
        this.f2836a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1896655546:
                if (str.equals("setNavigationBarColor")) {
                    c = 0;
                    break;
                }
                break;
            case -1881717868:
                if (str.equals("setNavigationBarStyle")) {
                    c = 1;
                    break;
                }
                break;
            case -1726417692:
                if (str.equals("getKeyboardHeight")) {
                    c = 2;
                    break;
                }
                break;
            case -203165324:
                if (str.equals("getNavHeight")) {
                    c = 3;
                    break;
                }
                break;
            case 60275095:
                if (str.equals("setTranslucent")) {
                    c = 4;
                    break;
                }
                break;
            case 263910572:
                if (str.equals("setHidden")) {
                    c = 5;
                    break;
                }
                break;
            case 474985501:
                if (str.equals("getHeight")) {
                    c = 6;
                    break;
                }
                break;
            case 1198417950:
                if (str.equals("setNetworkActivityIndicatorVisible")) {
                    c = 7;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals("getPlatformVersion")) {
                    c = 8;
                    break;
                }
                break;
            case 1389555745:
                if (str.equals("setColor")) {
                    c = 9;
                    break;
                }
                break;
            case 1404493423:
                if (str.equals("setStyle")) {
                    c = 10;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                h(methodCall, result);
                return;
            case 1:
                i(methodCall, result);
                return;
            case 2:
                d(methodCall, result);
                return;
            case 3:
                e(methodCall, result);
                return;
            case 4:
                k(methodCall, result);
                return;
            case 5:
                g(methodCall, result);
                return;
            case 6:
                c(methodCall, result);
                return;
            case 7:
                result.success(Boolean.TRUE);
                return;
            case 8:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 9:
                f(methodCall, result);
                return;
            case 10:
                j(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Log.d("StatusBarControl", "StatusBarControl: Reattached to Activity for Config changes");
        b = activityPluginBinding.getActivity();
    }
}
