package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.MethodCallOperation;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodCall f10042a;
    public final /* synthetic */ MethodChannel.Result b;
    public final /* synthetic */ Database c;

    public /* synthetic */ j(MethodCall methodCall, MethodChannel.Result result, Database database) {
        this.f10042a = methodCall;
        this.b = result;
        this.c = database;
    }

    public final void run() {
        this.c.P(new MethodCallOperation(this.f10042a, this.b));
    }
}
