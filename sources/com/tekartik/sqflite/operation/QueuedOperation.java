package com.tekartik.sqflite.operation;

public class QueuedOperation {

    /* renamed from: a  reason: collision with root package name */
    public final Operation f10052a;
    public final Runnable b;

    public QueuedOperation(Operation operation, Runnable runnable) {
        this.f10052a = operation;
        this.b = runnable;
    }

    public void a() {
        this.b.run();
    }
}
