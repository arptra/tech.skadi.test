package com.dexterous.flutterlocalnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.dexterous.flutterlocalnotifications.isolate.IsolatePreferences;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.FlutterCallbackInformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActionBroadcastReceiver extends BroadcastReceiver {
    public static ActionEventSink b;
    public static FlutterEngine c;

    /* renamed from: a  reason: collision with root package name */
    public IsolatePreferences f2807a;

    public static class ActionEventSink implements EventChannel.StreamHandler {

        /* renamed from: a  reason: collision with root package name */
        public final List f2808a;
        public EventChannel.EventSink b;

        public ActionEventSink() {
            this.f2808a = new ArrayList();
        }

        public void a(Map map) {
            EventChannel.EventSink eventSink = this.b;
            if (eventSink != null) {
                eventSink.success(map);
            } else {
                this.f2808a.add(map);
            }
        }

        public void onCancel(Object obj) {
            this.b = null;
        }

        public void onListen(Object obj, EventChannel.EventSink eventSink) {
            for (Map success : this.f2808a) {
                eventSink.success(success);
            }
            this.f2808a.clear();
            this.b = eventSink;
        }
    }

    public final void a(DartExecutor dartExecutor) {
        new EventChannel(dartExecutor.getBinaryMessenger(), "dexterous.com/flutter/local_notifications/actions").setStreamHandler(b);
    }

    public final void b(Context context) {
        if (c != null) {
            Log.e("ActionBroadcastReceiver", "Engine is already initialised");
            return;
        }
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        flutterLoader.startInitialization(context);
        flutterLoader.ensureInitializationComplete(context, (String[]) null);
        c = new FlutterEngine(context);
        FlutterCallbackInformation d = this.f2807a.d();
        if (d == null) {
            Log.w("ActionBroadcastReceiver", "Callback information could not be retrieved");
            return;
        }
        DartExecutor dartExecutor = c.getDartExecutor();
        a(dartExecutor);
        dartExecutor.executeDartCallback(new DartExecutor.DartCallback(context.getAssets(), flutterLoader.findAppBundlePath(), d));
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED".equalsIgnoreCase(intent.getAction())) {
            IsolatePreferences isolatePreferences = this.f2807a;
            if (isolatePreferences == null) {
                isolatePreferences = new IsolatePreferences(context);
            }
            this.f2807a = isolatePreferences;
            Map<String, Object> extractNotificationResponseMap = FlutterLocalNotificationsPlugin.extractNotificationResponseMap(intent);
            if (intent.getBooleanExtra("cancelNotification", false)) {
                int intValue = ((Integer) extractNotificationResponseMap.get("notificationId")).intValue();
                Object obj = extractNotificationResponseMap.get("notificationTag");
                if (obj instanceof String) {
                    NotificationManagerCompat.g(context).c((String) obj, intValue);
                } else {
                    NotificationManagerCompat.g(context).b(intValue);
                }
            }
            if (b == null) {
                b = new ActionEventSink();
            }
            b.a(extractNotificationResponseMap);
            b(context);
        }
    }
}
