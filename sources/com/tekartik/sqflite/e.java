package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.Operation;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Database f10037a;
    public final /* synthetic */ Operation b;

    public /* synthetic */ e(Database database, Operation operation) {
        this.f10037a = database;
        this.b = operation;
    }

    public final void run() {
        this.f10037a.H(this.b);
    }
}
