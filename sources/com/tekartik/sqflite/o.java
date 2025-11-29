package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.MethodCallOperation;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodCall f10047a;
    public final /* synthetic */ MethodChannel.Result b;
    public final /* synthetic */ Database c;

    public /* synthetic */ o(MethodCall methodCall, MethodChannel.Result result, Database database) {
        this.f10047a = methodCall;
        this.b = result;
        this.c = database;
    }

    public final void run() {
        this.c.v(new MethodCallOperation(this.f10047a, this.b));
    }
}
