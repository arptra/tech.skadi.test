package com.xjsd.ai.assistant.phone.vui.todo;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TodoDatabase_Impl extends TodoDatabase {

    /* renamed from: a  reason: collision with root package name */
    public volatile TodoDao f8654a;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `todo`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            I.n0("PRAGMA wal_checkpoint(FULL)").close();
            if (!I.s0()) {
                I.P("VACUUM");
            }
        }
    }

    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), VuiModelType.TODO);
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(2) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `todo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `target` TEXT NOT NULL, `completed` INTEGER NOT NULL, `startTime` INTEGER, `endTime` INTEGER, `time` TEXT NOT NULL, `time_text` TEXT NOT NULL, `origin_query` TEXT NOT NULL, `create_time` TEXT NOT NULL, `update_time` TEXT, `account_id` TEXT)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1f5e10f813b977b0101e3f6af2703ba0')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `todo`");
                List<RoomDatabase.Callback> e = TodoDatabase_Impl.this.mCallbacks;
                if (e != null) {
                    for (RoomDatabase.Callback b : e) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> f = TodoDatabase_Impl.this.mCallbacks;
                if (f != null) {
                    for (RoomDatabase.Callback a2 : f) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = TodoDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                TodoDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> i = TodoDatabase_Impl.this.mCallbacks;
                if (i != null) {
                    for (RoomDatabase.Callback c : i) {
                        c.c(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.b(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(11);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("target", new TableInfo.Column("target", "TEXT", true, 0, (String) null, 1));
                hashMap.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("startTime", new TableInfo.Column("startTime", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("endTime", new TableInfo.Column("endTime", "INTEGER", false, 0, (String) null, 1));
                hashMap.put(RtspHeaders.Values.TIME, new TableInfo.Column(RtspHeaders.Values.TIME, "TEXT", true, 0, (String) null, 1));
                hashMap.put("time_text", new TableInfo.Column("time_text", "TEXT", true, 0, (String) null, 1));
                hashMap.put("origin_query", new TableInfo.Column("origin_query", "TEXT", true, 0, (String) null, 1));
                hashMap.put("create_time", new TableInfo.Column("create_time", "TEXT", true, 0, (String) null, 1));
                hashMap.put("update_time", new TableInfo.Column("update_time", "TEXT", false, 0, (String) null, 1));
                hashMap.put("account_id", new TableInfo.Column("account_id", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo(VuiModelType.TODO, hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase, VuiModelType.TODO);
                if (tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "todo(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
            }
        }, "1f5e10f813b977b0101e3f6af2703ba0", "9cd333d07183dd8c92d664b2fa5cb608")).b());
    }

    public TodoDao d() {
        TodoDao todoDao;
        if (this.f8654a != null) {
            return this.f8654a;
        }
        synchronized (this) {
            try {
                if (this.f8654a == null) {
                    this.f8654a = new TodoDao_Impl(this);
                }
                todoDao = this.f8654a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return todoDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(TodoDao.class, TodoDao_Impl.p());
        return hashMap;
    }
}
