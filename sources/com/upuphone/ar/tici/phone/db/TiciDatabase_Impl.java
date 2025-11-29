package com.upuphone.ar.tici.phone.db;

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

public final class TiciDatabase_Impl extends TiciDatabase {
    public volatile TiciDao c;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `TiciEntity`");
            I.P("DELETE FROM `TiciContentPart`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "TiciEntity", "TiciContentPart");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(2) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `TiciEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fileName` TEXT NOT NULL, `sourceText` TEXT NOT NULL, `paragraphIndexes` TEXT NOT NULL, `index` INTEGER NOT NULL, `fileSize` INTEGER NOT NULL, `lastShowTime` INTEGER NOT NULL, `lastModified` INTEGER NOT NULL, `fileType` INTEGER, `fileStatus` INTEGER NOT NULL, `userId` TEXT, `currentPage` INTEGER NOT NULL DEFAULT 0, `totalPage` INTEGER NOT NULL DEFAULT 1, `totalTextLength` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `TiciContentPart` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ticiId` INTEGER NOT NULL, `contentText` TEXT NOT NULL, `paragraphIndexes` TEXT NOT NULL, `highlightIndex` INTEGER NOT NULL, `partSize` INTEGER NOT NULL, `partIndex` INTEGER NOT NULL, `contentOffsetStart` INTEGER NOT NULL, `contentOffsetEnd` INTEGER NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e4c03dd5ccc34a075c62f138384c6358')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `TiciEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `TiciContentPart`");
                List<RoomDatabase.Callback> g = TiciDatabase_Impl.this.mCallbacks;
                if (g != null) {
                    for (RoomDatabase.Callback b : g) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> h = TiciDatabase_Impl.this.mCallbacks;
                if (h != null) {
                    for (RoomDatabase.Callback a2 : h) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = TiciDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                TiciDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> k = TiciDatabase_Impl.this.mCallbacks;
                if (k != null) {
                    for (RoomDatabase.Callback c : k) {
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
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("fileName", new TableInfo.Column("fileName", "TEXT", true, 0, (String) null, 1));
                hashMap.put("sourceText", new TableInfo.Column("sourceText", "TEXT", true, 0, (String) null, 1));
                hashMap.put("paragraphIndexes", new TableInfo.Column("paragraphIndexes", "TEXT", true, 0, (String) null, 1));
                hashMap.put("index", new TableInfo.Column("index", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("lastShowTime", new TableInfo.Column("lastShowTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("lastModified", new TableInfo.Column("lastModified", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("fileType", new TableInfo.Column("fileType", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("fileStatus", new TableInfo.Column("fileStatus", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("currentPage", new TableInfo.Column("currentPage", "INTEGER", true, 0, "0", 1));
                hashMap.put("totalPage", new TableInfo.Column("totalPage", "INTEGER", true, 0, "1", 1));
                hashMap.put("totalTextLength", new TableInfo.Column("totalTextLength", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo = new TableInfo("TiciEntity", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "TiciEntity");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "TiciEntity(com.upuphone.ar.tici.phone.db.entity.TiciEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(9);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("ticiId", new TableInfo.Column("ticiId", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("contentText", new TableInfo.Column("contentText", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("paragraphIndexes", new TableInfo.Column("paragraphIndexes", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("highlightIndex", new TableInfo.Column("highlightIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("partSize", new TableInfo.Column("partSize", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("partIndex", new TableInfo.Column("partIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("contentOffsetStart", new TableInfo.Column("contentOffsetStart", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("contentOffsetEnd", new TableInfo.Column("contentOffsetEnd", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("TiciContentPart", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "TiciContentPart");
                if (tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "TiciContentPart(com.upuphone.ar.tici.phone.db.entity.TiciContentPart).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
            }
        }, "e4c03dd5ccc34a075c62f138384c6358", "49d1c384030c21c90f43594c5b029f0c")).b());
    }

    public TiciDao f() {
        TiciDao ticiDao;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new TiciDao_Impl(this);
                }
                ticiDao = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ticiDao;
    }

    public List getAutoMigrations(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TiciDatabase_AutoMigration_1_2_Impl());
        return arrayList;
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(TiciDao.class, TiciDao_Impl.P());
        return hashMap;
    }
}
