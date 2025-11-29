package dev.fluttercommunity.plus.connectivity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

class ConnectivityMethodChannelHandler implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Connectivity f8790a;

    public ConnectivityMethodChannelHandler(Connectivity connectivity) {
        this.f8790a = connectivity;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if ("check".equals(methodCall.method)) {
            result.success(this.f8790a.b());
        } else {
            result.notImplemented();
        }
    }
}
