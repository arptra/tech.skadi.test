package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.Operation;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Database f10034a;
    public final /* synthetic */ Operation b;

    public /* synthetic */ c(Database database, Operation operation) {
        this.f10034a = database;
        this.b = operation;
    }

    public final void run() {
        this.f10034a.L(this.b);
    }
}
