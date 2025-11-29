package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodCall f10045a;
    public final /* synthetic */ Database b;
    public final /* synthetic */ MethodChannel.Result c;

    public /* synthetic */ m(MethodCall methodCall, Database database, MethodChannel.Result result) {
        this.f10045a = methodCall;
        this.b = database;
        this.c = result;
    }

    public final void run() {
        SqflitePlugin.v(this.f10045a, this.b, this.c);
    }
}
