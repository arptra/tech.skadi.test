package com.honey.account.e0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f3047a;

    public /* synthetic */ a(SupportSQLiteQuery supportSQLiteQuery) {
        this.f3047a = supportSQLiteQuery;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.g(this.f3047a, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
