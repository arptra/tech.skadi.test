package com.tekartik.sqflite;

import android.os.Handler;
import android.os.HandlerThread;

class SingleDatabaseWorkerPoolImpl implements DatabaseWorkerPool {

    /* renamed from: a  reason: collision with root package name */
    public final String f10026a;
    public final int b;
    public HandlerThread c;
    public Handler d;

    public SingleDatabaseWorkerPoolImpl(String str, int i) {
        this.f10026a = str;
        this.b = i;
    }

    public void b(DatabaseTask databaseTask) {
        this.d.post(databaseTask.b);
    }

    public void c() {
        HandlerThread handlerThread = this.c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.c = null;
            this.d = null;
        }
    }

    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f10026a, this.b);
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
    }
}
