package com.upuphone.ar.transcribe.phone.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TcbDb_Impl extends TcbDb {
    public volatile TcbDao k;
    public volatile AiDao l;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `transcribe`");
            I.P("DELETE FROM `messages`");
            I.P("DELETE FROM `summary`");
            I.P("DELETE FROM `todo_list`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "transcribe", "messages", "summary", "todo_list");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(9) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `transcribe` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `transResult` TEXT, `recordTime` INTEGER NOT NULL, `xrType` INTEGER NOT NULL, `title` TEXT, `location` TEXT, `type` INTEGER NOT NULL, `account` TEXT, `superTitle` TEXT, `title2` TEXT, `recognizeId` TEXT, `language` TEXT, `fullLocation` TEXT, `simpleLocation` TEXT)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `message` TEXT NOT NULL, `owner` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `transcribeId` INTEGER NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `summary` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `summary` TEXT NOT NULL, `src` TEXT, `deleted` INTEGER, `requestId` TEXT, `reported` INTEGER)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `todo_list` (`title` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `content` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `calendarId` INTEGER NOT NULL DEFAULT 0, `calendarEventId` INTEGER NOT NULL DEFAULT 0, `src` TEXT, `deleted` INTEGER, `requestId` TEXT, `reported` INTEGER, `isIsDone` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '81b6523f48a83b1bda8e219fe8f98419')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `transcribe`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `messages`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `summary`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `todo_list`");
                List<RoomDatabase.Callback> p = TcbDb_Impl.this.mCallbacks;
                if (p != null) {
                    for (RoomDatabase.Callback b : p) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> q = TcbDb_Impl.this.mCallbacks;
                if (q != null) {
                    for (RoomDatabase.Callback a2 : q) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = TcbDb_Impl.this.mDatabase = supportSQLiteDatabase;
                TcbDb_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> t = TcbDb_Impl.this.mCallbacks;
                if (t != null) {
                    for (RoomDatabase.Callback c : t) {
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
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(14);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", false, 1, (String) null, 1));
                hashMap.put("transResult", new TableInfo.Column("transResult", "TEXT", false, 0, (String) null, 1));
                hashMap.put("recordTime", new TableInfo.Column("recordTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("xrType", new TableInfo.Column("xrType", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("title", new TableInfo.Column("title", "TEXT", false, 0, (String) null, 1));
                hashMap.put("location", new TableInfo.Column("location", "TEXT", false, 0, (String) null, 1));
                hashMap.put("type", new TableInfo.Column("type", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("account", new TableInfo.Column("account", "TEXT", false, 0, (String) null, 1));
                hashMap.put("superTitle", new TableInfo.Column("superTitle", "TEXT", false, 0, (String) null, 1));
                hashMap.put("title2", new TableInfo.Column("title2", "TEXT", false, 0, (String) null, 1));
                hashMap.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("language", new TableInfo.Column("language", "TEXT", false, 0, (String) null, 1));
                hashMap.put("fullLocation", new TableInfo.Column("fullLocation", "TEXT", false, 0, (String) null, 1));
                hashMap.put("simpleLocation", new TableInfo.Column("simpleLocation", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("transcribe", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "transcribe");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "transcribe(com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", false, 1, (String) null, 1));
                hashMap2.put("message", new TableInfo.Column("message", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("owner", new TableInfo.Column("owner", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("transcribeId", new TableInfo.Column("transcribeId", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("messages", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "messages");
                if (!tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(false, "messages(com.upuphone.ar.transcribe.phone.db.entity.MessageEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(8);
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap3.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("summary", new TableInfo.Column("summary", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("src", new TableInfo.Column("src", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("deleted", new TableInfo.Column("deleted", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("requestId", new TableInfo.Column("requestId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("reported", new TableInfo.Column("reported", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("summary", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo a4 = TableInfo.a(supportSQLiteDatabase2, "summary");
                if (!tableInfo3.equals(a4)) {
                    return new RoomOpenHelper.ValidationResult(false, "summary(com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(14);
                hashMap4.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap4.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("calendarId", new TableInfo.Column("calendarId", "INTEGER", true, 0, "0", 1));
                hashMap4.put("calendarEventId", new TableInfo.Column("calendarEventId", "INTEGER", true, 0, "0", 1));
                hashMap4.put("src", new TableInfo.Column("src", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("deleted", new TableInfo.Column("deleted", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("requestId", new TableInfo.Column("requestId", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("reported", new TableInfo.Column("reported", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("isIsDone", new TableInfo.Column("isIsDone", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo4 = new TableInfo("todo_list", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo a5 = TableInfo.a(supportSQLiteDatabase2, "todo_list");
                if (tableInfo4.equals(a5)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "todo_list(com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + a5);
            }
        }, "81b6523f48a83b1bda8e219fe8f98419", "0d861ce3e3e91cae4aec72f057708298")).b());
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(TcbDao.class, TcbDao_Impl.r());
        hashMap.put(AiDao.class, AiDao_Impl.k());
        return hashMap;
    }

    public AiDao n() {
        AiDao aiDao;
        if (this.l != null) {
            return this.l;
        }
        synchronized (this) {
            try {
                if (this.l == null) {
                    this.l = new AiDao_Impl(this);
                }
                aiDao = this.l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aiDao;
    }

    public TcbDao o() {
        TcbDao tcbDao;
        if (this.k != null) {
            return this.k;
        }
        synchronized (this) {
            try {
                if (this.k == null) {
                    this.k = new TcbDao_Impl(this);
                }
                tcbDao = this.k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tcbDao;
    }
}
