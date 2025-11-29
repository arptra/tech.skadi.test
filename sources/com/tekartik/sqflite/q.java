package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Database f10054a;
    public final /* synthetic */ MethodCall b;
    public final /* synthetic */ MethodChannel.Result c;

    public /* synthetic */ q(Database database, MethodCall methodCall, MethodChannel.Result result) {
        this.f10054a = database;
        this.b = methodCall;
        this.c = result;
    }

    public final void run() {
        this.f10054a.h(this.b, this.c);
    }
}
