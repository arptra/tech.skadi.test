package com.lib.flutter_blue_plus;

import com.lib.flutter_blue_plus.FlutterBluePlusPlugin;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c implements FlutterBluePlusPlugin.OperationOnPermission {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterBluePlusPlugin f9269a;
    public final /* synthetic */ MethodChannel.Result b;

    public /* synthetic */ c(FlutterBluePlusPlugin flutterBluePlusPlugin, MethodChannel.Result result) {
        this.f9269a = flutterBluePlusPlugin;
        this.b = result;
    }

    public final void a(boolean z, String str) {
        this.f9269a.s0(this.b, z, str);
    }
}
