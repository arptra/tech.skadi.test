package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.Operation;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Database f10032a;
    public final /* synthetic */ Operation b;

    public /* synthetic */ a(Database database, Operation operation) {
        this.f10032a = database;
        this.b = operation;
    }

    public final void run() {
        this.f10032a.K(this.b);
    }
}
