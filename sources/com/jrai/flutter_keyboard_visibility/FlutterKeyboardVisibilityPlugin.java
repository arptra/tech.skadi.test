package com.jrai.flutter_keyboard_visibility;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

public class FlutterKeyboardVisibilityPlugin implements FlutterPlugin, ActivityAware, EventChannel.StreamHandler, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public EventChannel.EventSink f9253a;
    public View b;
    public boolean c;

    public final void a(BinaryMessenger binaryMessenger) {
        new EventChannel(binaryMessenger, "flutter_keyboard_visibility").setStreamHandler(this);
    }

    public final void b(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        this.b = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void c() {
        View view = this.b;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.b = null;
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        b(activityPluginBinding.getActivity());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        a(flutterPluginBinding.getBinaryMessenger());
    }

    public void onCancel(Object obj) {
        this.f9253a = null;
    }

    public void onDetachedFromActivity() {
        c();
    }

    public void onDetachedFromActivityForConfigChanges() {
        c();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        c();
    }

    public void onGlobalLayout() {
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            boolean z = ((double) rect.height()) / ((double) this.b.getRootView().getHeight()) < 0.85d;
            if (z != this.c) {
                this.c = z;
                EventChannel.EventSink eventSink = this.f9253a;
                if (eventSink != null) {
                    eventSink.success(Integer.valueOf(z ? 1 : 0));
                }
            }
        }
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f9253a = eventSink;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        b(activityPluginBinding.getActivity());
    }
}
