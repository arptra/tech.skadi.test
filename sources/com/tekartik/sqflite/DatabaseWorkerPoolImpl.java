package com.tekartik.sqflite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

class DatabaseWorkerPoolImpl implements DatabaseWorkerPool {

    /* renamed from: a  reason: collision with root package name */
    public final String f10025a;
    public final int b;
    public final int c;
    public final LinkedList d = new LinkedList();
    public final Set e = new HashSet();
    public final Set f = new HashSet();
    public final Map g = new HashMap();

    public DatabaseWorkerPoolImpl(String str, int i, int i2) {
        this.f10025a = str;
        this.b = i;
        this.c = i2;
    }

    public synchronized void b(DatabaseTask databaseTask) {
        this.d.add(databaseTask);
        for (DatabaseWorker j : new HashSet(this.e)) {
            j(j);
        }
    }

    public synchronized void c() {
        try {
            for (DatabaseWorker f2 : this.e) {
                f2.f();
            }
            for (DatabaseWorker f3 : this.f) {
                f3.f();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public DatabaseWorker f(String str, int i) {
        return new DatabaseWorker(str, i);
    }

    public final synchronized DatabaseTask g(DatabaseWorker databaseWorker) {
        DatabaseTask databaseTask;
        try {
            ListIterator listIterator = this.d.listIterator();
            while (true) {
                DatabaseWorker databaseWorker2 = null;
                if (!listIterator.hasNext()) {
                    return null;
                }
                databaseTask = (DatabaseTask) listIterator.next();
                if (databaseTask.a() != null) {
                    databaseWorker2 = (DatabaseWorker) this.g.get(databaseTask.a());
                }
                if (databaseWorker2 == null || databaseWorker2 == databaseWorker) {
                    listIterator.remove();
                }
            }
            listIterator.remove();
            return databaseTask;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: i */
    public final synchronized void h(DatabaseWorker databaseWorker) {
        try {
            HashSet<DatabaseWorker> hashSet = new HashSet<>(this.e);
            this.f.remove(databaseWorker);
            this.e.add(databaseWorker);
            if (!databaseWorker.b() && databaseWorker.d() != null) {
                this.g.remove(databaseWorker.d());
            }
            j(databaseWorker);
            for (DatabaseWorker j : hashSet) {
                j(j);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void j(DatabaseWorker databaseWorker) {
        try {
            DatabaseTask g2 = g(databaseWorker);
            if (g2 != null) {
                this.f.add(databaseWorker);
                this.e.remove(databaseWorker);
                if (g2.a() != null) {
                    this.g.put(g2.a(), databaseWorker);
                }
                databaseWorker.e(g2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void start() {
        for (int i = 0; i < this.b; i++) {
            DatabaseWorker f2 = f(this.f10025a + i, this.c);
            f2.g(new i(this, f2));
            this.e.add(f2);
        }
    }
}
