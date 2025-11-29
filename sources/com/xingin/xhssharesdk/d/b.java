package com.xingin.xhssharesdk.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static b f8173a;

    public b(Context context) {
        super(context, "tracker.sqlite", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS biz ( id INTEGER PRIMARY KEY, data BLOB, eventId TEXT, createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, monitorKey TEXT ) ");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS apm ( id INTEGER PRIMARY KEY, data BLOB, eventId TEXT, createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, monitorKey TEXT  ) ");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
