package com.upuphone.ai.ttsengine.engines.cache.db;

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

public final class CacheDatabase_Impl extends CacheDatabase {
    public volatile PCMCacheDao d;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `pcmCache`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "pcmCache");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(2) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `pcmCache` (`word` TEXT NOT NULL, `path` TEXT NOT NULL, `updateTime` INTEGER NOT NULL, `count` INTEGER NOT NULL, PRIMARY KEY(`word`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c763064e529e3a369c265eab445bde86')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `pcmCache`");
                List<RoomDatabase.Callback> h = CacheDatabase_Impl.this.mCallbacks;
                if (h != null) {
                    for (RoomDatabase.Callback b : h) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> i = CacheDatabase_Impl.this.mCallbacks;
                if (i != null) {
                    for (RoomDatabase.Callback a2 : i) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = CacheDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                CacheDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> l = CacheDatabase_Impl.this.mCallbacks;
                if (l != null) {
                    for (RoomDatabase.Callback c : l) {
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
                HashMap hashMap = new HashMap(4);
                hashMap.put("word", new TableInfo.Column("word", "TEXT", true, 1, (String) null, 1));
                hashMap.put("path", new TableInfo.Column("path", "TEXT", true, 0, (String) null, 1));
                hashMap.put("updateTime", new TableInfo.Column("updateTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("count", new TableInfo.Column("count", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("pcmCache", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase, "pcmCache");
                if (tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "pcmCache(com.upuphone.ai.ttsengine.engines.cache.db.CacheEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
            }
        }, "c763064e529e3a369c265eab445bde86", "2fe658db0f8eee17f7a1a113092d3653")).b());
    }

    public PCMCacheDao g() {
        PCMCacheDao pCMCacheDao;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            try {
                if (this.d == null) {
                    this.d = new PCMCacheDao_Impl(this);
                }
                pCMCacheDao = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pCMCacheDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(PCMCacheDao.class, PCMCacheDao_Impl.f());
        return hashMap;
    }
}
