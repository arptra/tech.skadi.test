package com.xingin.xhssharesdk.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f8172a;
    public final Context b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public a(Context context) {
        this.b = context;
        d();
    }

    public abstract long a();

    public abstract long b(f fVar);

    public abstract boolean c(ArrayList arrayList);

    public final void d() {
        try {
            if (!e() && !this.c.getAndSet(true)) {
                Context context = this.b;
                if (b.f8173a == null) {
                    synchronized (b.class) {
                        if (b.f8173a == null) {
                            b.f8173a = new b(context.getApplicationContext());
                        }
                    }
                }
                SQLiteDatabase writableDatabase = b.f8173a.getWritableDatabase();
                this.f8172a = writableDatabase;
                writableDatabase.enableWriteAheadLogging();
            }
        } catch (Exception unused) {
            this.c.set(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean e() {
        SQLiteDatabase sQLiteDatabase = this.f8172a;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }

    public abstract ArrayList f();
}
