package com.tekartik.sqflite;

final class DatabaseTask {

    /* renamed from: a  reason: collision with root package name */
    public final DatabaseDelegate f10022a;
    public final Runnable b;

    public DatabaseTask(DatabaseDelegate databaseDelegate, Runnable runnable) {
        this.f10022a = databaseDelegate;
        this.b = runnable;
    }

    public Integer a() {
        DatabaseDelegate databaseDelegate = this.f10022a;
        if (databaseDelegate != null) {
            return Integer.valueOf(databaseDelegate.a());
        }
        return null;
    }

    public boolean b() {
        DatabaseDelegate databaseDelegate = this.f10022a;
        return databaseDelegate != null && databaseDelegate.b();
    }
}
