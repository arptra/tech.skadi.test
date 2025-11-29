package com.upuphone.star.download.manager.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DownloadDb_Impl extends DownloadDb {
    public volatile DownloadDao c;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `DownloadStatus`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "DownloadStatus");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `DownloadStatus` (`url` TEXT NOT NULL, `filePath` TEXT NOT NULL, `fileSize` INTEGER NOT NULL, `progress` REAL NOT NULL, PRIMARY KEY(`url`, `filePath`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '76d748a5985b3e1447a32f6aa1170265')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `DownloadStatus`");
                List<RoomDatabase.Callback> g = DownloadDb_Impl.this.mCallbacks;
                if (g != null) {
                    for (RoomDatabase.Callback b : g) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> h = DownloadDb_Impl.this.mCallbacks;
                if (h != null) {
                    for (RoomDatabase.Callback a2 : h) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = DownloadDb_Impl.this.mDatabase = supportSQLiteDatabase;
                DownloadDb_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> k = DownloadDb_Impl.this.mCallbacks;
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
                HashMap hashMap = new HashMap(4);
                hashMap.put("url", new TableInfo.Column("url", "TEXT", true, 1, (String) null, 1));
                hashMap.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 2, (String) null, 1));
                hashMap.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, (String) null, 1));
                hashMap.put(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS, new TableInfo.Column(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS, "REAL", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("DownloadStatus", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase, "DownloadStatus");
                if (tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "DownloadStatus(com.upuphone.star.download.manager.db.DownloadStatus).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
            }
        }, "76d748a5985b3e1447a32f6aa1170265", "30ddae2353182690fdeab168e6b60c11")).b());
    }

    public DownloadDao f() {
        DownloadDao downloadDao;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new DownloadDao_Impl(this);
                }
                downloadDao = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return downloadDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadDao.class, DownloadDao_Impl.f());
        return hashMap;
    }
}
