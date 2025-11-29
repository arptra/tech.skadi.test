package com.lib.flutter_blue_plus;

import com.lib.flutter_blue_plus.FlutterBluePlusPlugin;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;

public final /* synthetic */ class d implements FlutterBluePlusPlugin.OperationOnPermission {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterBluePlusPlugin f9270a;
    public final /* synthetic */ MethodChannel.Result b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ List e;
    public final /* synthetic */ List f;
    public final /* synthetic */ List g;
    public final /* synthetic */ List h;
    public final /* synthetic */ List i;
    public final /* synthetic */ List j;
    public final /* synthetic */ HashMap k;

    public /* synthetic */ d(FlutterBluePlusPlugin flutterBluePlusPlugin, MethodChannel.Result result, int i2, boolean z, List list, List list2, List list3, List list4, List list5, List list6, HashMap hashMap) {
        this.f9270a = flutterBluePlusPlugin;
        this.b = result;
        this.c = i2;
        this.d = z;
        this.e = list;
        this.f = list2;
        this.g = list3;
        this.h = list4;
        this.i = list5;
        this.j = list6;
        this.k = hashMap;
    }

    public final void a(boolean z, String str) {
        this.f9270a.t0(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, z, str);
    }
}
