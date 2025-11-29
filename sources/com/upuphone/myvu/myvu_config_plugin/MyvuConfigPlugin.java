package com.upuphone.myvu.myvu_config_plugin;

import android.content.Context;
import com.upuphone.xr.sapp.context.SdkContext;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.PrintStream;

public class MyvuConfigPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel f6426a;
    public Context b;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.b = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "myvu_config_plugin");
        this.f6426a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f6426a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        if (methodCall.method.equals("getNetworkConfig")) {
            try {
                str = SdkContext.f6675a.c().i();
            } catch (Exception unused) {
                System.out.println("获取NetworkConfig失败");
                str = "";
            }
            result.success(str);
        } else if (methodCall.method.equals("getIsOversea")) {
            Boolean bool = Boolean.FALSE;
            try {
                bool = Boolean.valueOf(SdkContext.f6675a.c().e());
            } catch (Exception unused2) {
                System.out.println("获取getIsOversea失败");
            }
            result.success(bool);
        } else if (methodCall.method.equals("getIsLoadChineseLanguage")) {
            String string = this.b.getResources().getString(R.string.language_detector_myvu_config);
            PrintStream printStream = System.out;
            printStream.println("getIsLoadChineseLanguage value:" + string);
            if (string.equals("zh")) {
                result.success(Boolean.TRUE);
            } else {
                result.success(Boolean.FALSE);
            }
        } else {
            result.notImplemented();
        }
    }
}
