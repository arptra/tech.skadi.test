package com.lib.flutter_blue_plus;

import com.lib.flutter_blue_plus.FlutterBluePlusPlugin;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class f implements FlutterBluePlusPlugin.OperationOnPermission {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterBluePlusPlugin f9272a;
    public final /* synthetic */ MethodChannel.Result b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ f(FlutterBluePlusPlugin flutterBluePlusPlugin, MethodChannel.Result result, String str, boolean z) {
        this.f9272a = flutterBluePlusPlugin;
        this.b = result;
        this.c = str;
        this.d = z;
    }

    public final void a(boolean z, String str) {
        this.f9272a.v0(this.b, this.c, this.d, z, str);
    }
}
