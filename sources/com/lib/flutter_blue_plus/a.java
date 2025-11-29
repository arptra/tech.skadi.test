package com.lib.flutter_blue_plus;

import com.lib.flutter_blue_plus.FlutterBluePlusPlugin;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements FlutterBluePlusPlugin.OperationOnPermission {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterBluePlusPlugin f9267a;
    public final /* synthetic */ MethodChannel.Result b;

    public /* synthetic */ a(FlutterBluePlusPlugin flutterBluePlusPlugin, MethodChannel.Result result) {
        this.f9267a = flutterBluePlusPlugin;
        this.b = result;
    }

    public final void a(boolean z, String str) {
        this.f9267a.q0(this.b, z, str);
    }
}
