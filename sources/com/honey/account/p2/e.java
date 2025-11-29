package com.honey.account.p2;

import com.lib.flutter_blue_plus.FlutterBluePlusPlugin;
import java.util.HashMap;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterBluePlusPlugin f9219a;
    public final /* synthetic */ String b;
    public final /* synthetic */ HashMap c;

    public /* synthetic */ e(FlutterBluePlusPlugin flutterBluePlusPlugin, String str, HashMap hashMap) {
        this.f9219a = flutterBluePlusPlugin;
        this.b = str;
        this.c = hashMap;
    }

    public final void run() {
        this.f9219a.p0(this.b, this.c);
    }
}
