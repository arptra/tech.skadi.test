package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f10046a;
    public final /* synthetic */ String b;
    public final /* synthetic */ MethodChannel.Result c;
    public final /* synthetic */ Boolean d;
    public final /* synthetic */ Database e;
    public final /* synthetic */ MethodCall f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ int h;

    public /* synthetic */ n(boolean z, String str, MethodChannel.Result result, Boolean bool, Database database, MethodCall methodCall, boolean z2, int i) {
        this.f10046a = z;
        this.b = str;
        this.c = result;
        this.d = bool;
        this.e = database;
        this.f = methodCall;
        this.g = z2;
        this.h = i;
    }

    public final void run() {
        SqflitePlugin.s(this.f10046a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
