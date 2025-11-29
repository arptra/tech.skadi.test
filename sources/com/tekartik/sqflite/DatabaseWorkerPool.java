package com.tekartik.sqflite;

public interface DatabaseWorkerPool {
    static DatabaseWorkerPool a(String str, int i, int i2) {
        return i == 1 ? new SingleDatabaseWorkerPoolImpl(str, i2) : new DatabaseWorkerPoolImpl(str, i, i2);
    }

    void b(DatabaseTask databaseTask);

    void c();

    void d(final Database database, Runnable runnable) {
        b(new DatabaseTask(database == null ? null : new DatabaseDelegate() {
            public int a() {
                return database.c;
            }

            public boolean b() {
                return database.F();
            }
        }, runnable));
    }

    void start();
}
