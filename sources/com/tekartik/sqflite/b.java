package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.Operation;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Database f10033a;
    public final /* synthetic */ Operation b;

    public /* synthetic */ b(Database database, Operation operation) {
        this.f10033a = database;
        this.b = operation;
    }

    public final void run() {
        this.f10033a.J(this.b);
    }
}
