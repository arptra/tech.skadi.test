package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.Operation;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Database f10035a;
    public final /* synthetic */ Operation b;

    public /* synthetic */ d(Database database, Operation operation) {
        this.f10035a = database;
        this.b = operation;
    }

    public final void run() {
        this.f10035a.I(this.b);
    }
}
