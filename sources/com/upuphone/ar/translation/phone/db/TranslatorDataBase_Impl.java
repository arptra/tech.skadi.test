package com.upuphone.ar.translation.phone.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.upuphone.ar.translation.phone.dao.IntelExtnSummaryDao;
import com.upuphone.ar.translation.phone.dao.IntelExtnSummaryDao_Impl;
import com.upuphone.ar.translation.phone.dao.IntelExtnTodoDao;
import com.upuphone.ar.translation.phone.dao.IntelExtnTodoDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TranslatorDataBase_Impl extends TranslatorDataBase {

    /* renamed from: a  reason: collision with root package name */
    public volatile IntelExtnTodoDao f6272a;
    public volatile IntelExtnSummaryDao b;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `IntelExtnTodo`");
            I.P("DELETE FROM `IntelExtnSummary`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "IntelExtnTodo", "IntelExtnSummary");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(8) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `IntelExtnTodo` (`title` TEXT NOT NULL DEFAULT '', `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `content` TEXT NOT NULL, `originalContent` TEXT NOT NULL DEFAULT '', `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `requestId` TEXT NOT NULL DEFAULT '', `calendarId` INTEGER NOT NULL DEFAULT 0, `calendarEventId` INTEGER NOT NULL DEFAULT 0, `isAddedSchedule` INTEGER NOT NULL DEFAULT 0, `isIsDone` INTEGER NOT NULL DEFAULT 0, `deleteStatus` INTEGER NOT NULL DEFAULT 0, `isReported` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `IntelExtnSummary` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `requestId` TEXT NOT NULL DEFAULT '', `summary` TEXT NOT NULL, `originalSummary` TEXT NOT NULL DEFAULT '', `deleteStatus` INTEGER NOT NULL DEFAULT 0, `isReported` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e1b3b219fa7e290253ce6154aa22ec78')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `IntelExtnTodo`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `IntelExtnSummary`");
                List<RoomDatabase.Callback> f = TranslatorDataBase_Impl.this.mCallbacks;
                if (f != null) {
                    for (RoomDatabase.Callback b : f) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> g = TranslatorDataBase_Impl.this.mCallbacks;
                if (g != null) {
                    for (RoomDatabase.Callback a2 : g) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = TranslatorDataBase_Impl.this.mDatabase = supportSQLiteDatabase;
                TranslatorDataBase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> j = TranslatorDataBase_Impl.this.mCallbacks;
                if (j != null) {
                    for (RoomDatabase.Callback c : j) {
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
                HashMap hashMap = new HashMap(15);
                hashMap.put("title", new TableInfo.Column("title", "TEXT", true, 0, "''", 1));
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
                hashMap.put("originalContent", new TableInfo.Column("originalContent", "TEXT", true, 0, "''", 1));
                hashMap.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, (String) null, 1));
                hashMap.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, (String) null, 1));
                hashMap.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("requestId", new TableInfo.Column("requestId", "TEXT", true, 0, "''", 1));
                hashMap.put("calendarId", new TableInfo.Column("calendarId", "INTEGER", true, 0, "0", 1));
                hashMap.put("calendarEventId", new TableInfo.Column("calendarEventId", "INTEGER", true, 0, "0", 1));
                hashMap.put("isAddedSchedule", new TableInfo.Column("isAddedSchedule", "INTEGER", true, 0, "0", 1));
                hashMap.put("isIsDone", new TableInfo.Column("isIsDone", "INTEGER", true, 0, "0", 1));
                hashMap.put("deleteStatus", new TableInfo.Column("deleteStatus", "INTEGER", true, 0, "0", 1));
                hashMap.put("isReported", new TableInfo.Column("isReported", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo = new TableInfo("IntelExtnTodo", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "IntelExtnTodo");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "IntelExtnTodo(com.upuphone.ar.translation.phone.bean.IntelExtnTodo).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(8);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("requestId", new TableInfo.Column("requestId", "TEXT", true, 0, "''", 1));
                hashMap2.put("summary", new TableInfo.Column("summary", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("originalSummary", new TableInfo.Column("originalSummary", "TEXT", true, 0, "''", 1));
                hashMap2.put("deleteStatus", new TableInfo.Column("deleteStatus", "INTEGER", true, 0, "0", 1));
                hashMap2.put("isReported", new TableInfo.Column("isReported", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo2 = new TableInfo("IntelExtnSummary", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "IntelExtnSummary");
                if (tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "IntelExtnSummary(com.upuphone.ar.translation.phone.bean.IntelExtnSummary).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
            }
        }, "e1b3b219fa7e290253ce6154aa22ec78", "1df632fce498173ca93d88073e717907")).b());
    }

    public IntelExtnSummaryDao d() {
        IntelExtnSummaryDao intelExtnSummaryDao;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            try {
                if (this.b == null) {
                    this.b = new IntelExtnSummaryDao_Impl(this);
                }
                intelExtnSummaryDao = this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return intelExtnSummaryDao;
    }

    public IntelExtnTodoDao e() {
        IntelExtnTodoDao intelExtnTodoDao;
        if (this.f6272a != null) {
            return this.f6272a;
        }
        synchronized (this) {
            try {
                if (this.f6272a == null) {
                    this.f6272a = new IntelExtnTodoDao_Impl(this);
                }
                intelExtnTodoDao = this.f6272a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return intelExtnTodoDao;
    }

    public List getAutoMigrations(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TranslatorDataBase_AutoMigration_1_2_Impl());
        arrayList.add(new TranslatorDataBase_AutoMigration_2_3_Impl());
        arrayList.add(new TranslatorDataBase_AutoMigration_3_4_Impl());
        arrayList.add(new TranslatorDataBase_AutoMigration_4_5_Impl());
        arrayList.add(new TranslatorDataBase_AutoMigration_5_6_Impl());
        arrayList.add(new TranslatorDataBase_AutoMigration_6_7_Impl());
        arrayList.add(new TranslatorDataBase_AutoMigration_7_8_Impl());
        return arrayList;
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(IntelExtnTodoDao.class, IntelExtnTodoDao_Impl.i());
        hashMap.put(IntelExtnSummaryDao.class, IntelExtnSummaryDao_Impl.e());
        return hashMap;
    }
}
