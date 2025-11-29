package com.tekartik.sqflite;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DatabaseWorker f10040a;
    public final /* synthetic */ DatabaseTask b;

    public /* synthetic */ h(DatabaseWorker databaseWorker, DatabaseTask databaseTask) {
        this.f10040a = databaseWorker;
        this.b = databaseTask;
    }

    public final void run() {
        this.f10040a.c(this.b);
    }
}
