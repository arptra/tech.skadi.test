package dev.fluttercommunity.plus.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

public class ConnectivityPlugin implements FlutterPlugin {

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel f8791a;
    public EventChannel b;
    public ConnectivityBroadcastReceiver c;

    private void a(BinaryMessenger binaryMessenger, Context context) {
        this.f8791a = new MethodChannel(binaryMessenger, "dev.fluttercommunity.plus/connectivity");
        this.b = new EventChannel(binaryMessenger, "dev.fluttercommunity.plus/connectivity_status");
        Connectivity connectivity = new Connectivity((ConnectivityManager) context.getSystemService("connectivity"));
        ConnectivityMethodChannelHandler connectivityMethodChannelHandler = new ConnectivityMethodChannelHandler(connectivity);
        this.c = new ConnectivityBroadcastReceiver(context, connectivity);
        this.f8791a.setMethodCallHandler(connectivityMethodChannelHandler);
        this.b.setStreamHandler(this.c);
    }

    private void b() {
        this.f8791a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.b.setStreamHandler((EventChannel.StreamHandler) null);
        this.c.onCancel((Object) null);
        this.f8791a = null;
        this.b = null;
        this.c = null;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        a(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        b();
    }
}
