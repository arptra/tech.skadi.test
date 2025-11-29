package com.upuphone.xr.sapp.glass.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GlassUpdateDB_Impl extends GlassUpdateDB {
    public volatile GlassUpdateResultDao c;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `GlassUpdateResultEntity`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "GlassUpdateResultEntity");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `GlassUpdateResultEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `content` TEXT NOT NULL, `time` INTEGER NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2f68457f60268b677e3d233b7aba38a3')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `GlassUpdateResultEntity`");
                List<RoomDatabase.Callback> f = GlassUpdateDB_Impl.this.mCallbacks;
                if (f != null) {
                    for (RoomDatabase.Callback b : f) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> g = GlassUpdateDB_Impl.this.mCallbacks;
                if (g != null) {
                    for (RoomDatabase.Callback a2 : g) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = GlassUpdateDB_Impl.this.mDatabase = supportSQLiteDatabase;
                GlassUpdateDB_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> j = GlassUpdateDB_Impl.this.mCallbacks;
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
                HashMap hashMap = new HashMap(3);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
                hashMap.put(RtspHeaders.Values.TIME, new TableInfo.Column(RtspHeaders.Values.TIME, "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("GlassUpdateResultEntity", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase, "GlassUpdateResultEntity");
                if (tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "GlassUpdateResultEntity(com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
            }
        }, "2f68457f60268b677e3d233b7aba38a3", "07330192a70871ad33ea0f039adae291")).b());
    }

    public GlassUpdateResultDao e() {
        GlassUpdateResultDao glassUpdateResultDao;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new GlassUpdateResultDao_Impl(this);
                }
                glassUpdateResultDao = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return glassUpdateResultDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(GlassUpdateResultDao.class, GlassUpdateResultDao_Impl.h());
        return hashMap;
    }
}
