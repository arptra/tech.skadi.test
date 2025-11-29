package br.com.yanncabral.open_settings_plus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.upuphone.runasone.uupcast.CaptureType;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u001b¨\u0006\u001d"}, d2 = {"Lbr/com/yanncabral/open_settings_plus/OpenSettingsPlusPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "<init>", "()V", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "flutterPluginBinding", "", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "Lio/flutter/plugin/common/MethodCall;", "call", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "binding", "onDetachedFromEngine", "", "target", "a", "(Ljava/lang/String;)V", "b", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/MethodChannel;", "channel", "open_settings_plus_release"}, k = 1, mv = {1, 7, 1})
public final class OpenSettingsPlusPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public Context f2264a;
    public MethodChannel b;

    public final void a(String str) {
        Intent intent = new Intent(str);
        if (intent.getAction() != null) {
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            Context context = this.f2264a;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            context.startActivity(intent);
        }
    }

    public final void b(String str) {
        Intent intent = new Intent(str);
        if (intent.getAction() != null) {
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            Context context = null;
            if (Intrinsics.areEqual((Object) str, (Object) "android.settings.APP_NOTIFICATION_SETTINGS")) {
                Context context2 = this.f2264a;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                intent.putExtra("android.provider.extra.APP_PACKAGE", context2.getPackageName());
            } else if (Intrinsics.areEqual((Object) str, (Object) "android.settings.APPLICATION_DETAILS_SETTINGS")) {
                Context context3 = this.f2264a;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context3 = null;
                }
                intent.setData(Uri.fromParts("package", context3.getPackageName(), (String) null));
            } else {
                Context context4 = this.f2264a;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context4 = null;
                }
                intent.setData(Uri.fromParts("package", context4.getPackageName(), (String) null));
            }
            Context context5 = this.f2264a;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context5;
            }
            context.startActivity(intent);
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "open_settings_plus");
        this.b = methodChannel;
        methodChannel.setMethodCallHandler(this);
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.getApplicationContext()");
        this.f2264a = applicationContext;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.b;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "openSettings")) {
            String str = (String) methodCall.argument("settingToOpen");
            if (str != null) {
                if (Intrinsics.areEqual((Object) str, (Object) "android.settings.APPLICATION_DETAILS_SETTINGS") ? true : Intrinsics.areEqual((Object) str, (Object) "android.settings.APP_NOTIFICATION_SETTINGS")) {
                    b(str);
                } else {
                    a(str);
                }
                result.success(Boolean.TRUE);
                return;
            }
            return;
        }
        result.notImplemented();
    }
}
