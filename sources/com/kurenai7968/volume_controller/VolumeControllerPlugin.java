package com.kurenai7968.volume_controller;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00128\u0002XD¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/kurenai7968/volume_controller/VolumeControllerPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "<init>", "()V", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "flutterPluginBinding", "", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "Lio/flutter/plugin/common/MethodCall;", "call", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "binding", "onDetachedFromEngine", "", "a", "Ljava/lang/String;", "CHANNEL", "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "Lcom/kurenai7968/volume_controller/VolumeObserver;", "c", "Lcom/kurenai7968/volume_controller/VolumeObserver;", "volumeObserver", "Lio/flutter/plugin/common/MethodChannel;", "d", "Lio/flutter/plugin/common/MethodChannel;", "methodChannel", "Lio/flutter/plugin/common/EventChannel;", "e", "Lio/flutter/plugin/common/EventChannel;", "volumeListenerEventChannel", "Lcom/kurenai7968/volume_controller/VolumeListener;", "f", "Lcom/kurenai7968/volume_controller/VolumeListener;", "volumeListenerStreamHandler", "volume_controller_release"}, k = 1, mv = {1, 7, 1})
public final class VolumeControllerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public final String f9257a = "com.kurenai7968.volume_controller.";
    public Context b;
    public VolumeObserver c;
    public MethodChannel d;
    public EventChannel e;
    public VolumeListener f;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
        this.b = applicationContext;
        VolumeListener volumeListener = null;
        if (applicationContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            applicationContext = null;
        }
        this.c = new VolumeObserver(applicationContext);
        this.e = new EventChannel(flutterPluginBinding.getBinaryMessenger(), this.f9257a + "volume_listener_event");
        Context context = this.b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        this.f = new VolumeListener(context);
        EventChannel eventChannel = this.e;
        if (eventChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeListenerEventChannel");
            eventChannel = null;
        }
        VolumeListener volumeListener2 = this.f;
        if (volumeListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeListenerStreamHandler");
        } else {
            volumeListener = volumeListener2;
        }
        eventChannel.setStreamHandler(volumeListener);
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), this.f9257a + "method");
        this.d = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.d;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        EventChannel eventChannel = this.e;
        if (eventChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeListenerEventChannel");
            eventChannel = null;
        }
        eventChannel.setStreamHandler((EventChannel.StreamHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        VolumeObserver volumeObserver = null;
        if (Intrinsics.areEqual((Object) str, (Object) "setVolume")) {
            Object argument = methodCall.argument("volume");
            Intrinsics.checkNotNull(argument);
            double doubleValue = ((Number) argument).doubleValue();
            Object argument2 = methodCall.argument("showSystemUI");
            Intrinsics.checkNotNull(argument2);
            boolean booleanValue = ((Boolean) argument2).booleanValue();
            VolumeObserver volumeObserver2 = this.c;
            if (volumeObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("volumeObserver");
            } else {
                volumeObserver = volumeObserver2;
            }
            volumeObserver.b(doubleValue, booleanValue);
        } else if (Intrinsics.areEqual((Object) str, (Object) "getVolume")) {
            VolumeObserver volumeObserver3 = this.c;
            if (volumeObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("volumeObserver");
            } else {
                volumeObserver = volumeObserver3;
            }
            result.success(Double.valueOf(volumeObserver.a()));
        }
    }
}
