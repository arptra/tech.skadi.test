package com.benjaminabel.vibration;

import android.content.Context;
import android.os.Vibrator;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public class VibrationPlugin implements FlutterPlugin {

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel f2414a;

    public final void a(BinaryMessenger binaryMessenger, Context context) {
        VibrationMethodChannelHandler vibrationMethodChannelHandler = new VibrationMethodChannelHandler(new Vibration((Vibrator) context.getSystemService("vibrator")));
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "vibration");
        this.f2414a = methodChannel;
        methodChannel.setMethodCallHandler(vibrationMethodChannelHandler);
    }

    public final void b() {
        this.f2414a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f2414a = null;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        a(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        b();
    }
}
