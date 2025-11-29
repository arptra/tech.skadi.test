package com.tekartik.sqflite;

import android.os.Handler;
import android.os.HandlerThread;

class DatabaseWorker {

    /* renamed from: a  reason: collision with root package name */
    public final String f10023a;
    public final int b;
    public HandlerThread c;
    public Handler d;
    public Runnable e;
    public DatabaseTask f;

    public DatabaseWorker(String str, int i) {
        this.f10023a = str;
        this.b = i;
    }

    public boolean b() {
        DatabaseTask databaseTask = this.f;
        return databaseTask != null && databaseTask.b();
    }

    public Integer d() {
        DatabaseTask databaseTask = this.f;
        if (databaseTask != null) {
            return databaseTask.a();
        }
        return null;
    }

    public void e(DatabaseTask databaseTask) {
        this.d.post(new h(this, databaseTask));
    }

    public synchronized void f() {
        HandlerThread handlerThread = this.c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.c = null;
            this.d = null;
        }
    }

    public synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f10023a, this.b);
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
        this.e = runnable;
    }

    /* renamed from: h */
    public void c(DatabaseTask databaseTask) {
        databaseTask.b.run();
        this.f = databaseTask;
        this.e.run();
    }
}
