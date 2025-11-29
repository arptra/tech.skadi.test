package com.tekartik.sqflite;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DatabaseWorkerPoolImpl f10041a;
    public final /* synthetic */ DatabaseWorker b;

    public /* synthetic */ i(DatabaseWorkerPoolImpl databaseWorkerPoolImpl, DatabaseWorker databaseWorker) {
        this.f10041a = databaseWorkerPoolImpl;
        this.b = databaseWorker;
    }

    public final void run() {
        this.f10041a.h(this.b);
    }
}
