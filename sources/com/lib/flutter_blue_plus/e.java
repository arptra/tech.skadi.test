package com.lib.flutter_blue_plus;

import com.lib.flutter_blue_plus.FlutterBluePlusPlugin;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e implements FlutterBluePlusPlugin.OperationOnPermission {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterBluePlusPlugin f9271a;
    public final /* synthetic */ MethodChannel.Result b;

    public /* synthetic */ e(FlutterBluePlusPlugin flutterBluePlusPlugin, MethodChannel.Result result) {
        this.f9271a = flutterBluePlusPlugin;
        this.b = result;
    }

    public final void a(boolean z, String str) {
        this.f9271a.u0(this.b, z, str);
    }
}
