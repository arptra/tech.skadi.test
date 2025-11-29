package com.upuphone.datatrack.base.db;

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
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class DataTrackDB_Impl extends DataTrackDB {
    public volatile ReportTypeDao c;
    public volatile AppTrackDao d;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `app_track`");
            I.P("DELETE FROM `report_type`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "app_track", "report_type");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `app_track` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `name` TEXT NOT NULL, `msg` TEXT NOT NULL, `iotDeviceId` TEXT, `iotDeviceRom` TEXT)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `report_type` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `type` INTEGER NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f03119a4c9038d30660724c77a48d46a')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `app_track`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `report_type`");
                List<RoomDatabase.Callback> h = DataTrackDB_Impl.this.mCallbacks;
                if (h != null) {
                    for (RoomDatabase.Callback b : h) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> i = DataTrackDB_Impl.this.mCallbacks;
                if (i != null) {
                    for (RoomDatabase.Callback a2 : i) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = DataTrackDB_Impl.this.mDatabase = supportSQLiteDatabase;
                DataTrackDB_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> l = DataTrackDB_Impl.this.mCallbacks;
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
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(6);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, new TableInfo.Column(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, "TEXT", true, 0, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap.put(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, new TableInfo.Column(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, "TEXT", true, 0, (String) null, 1));
                hashMap.put("iotDeviceId", new TableInfo.Column("iotDeviceId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("iotDeviceRom", new TableInfo.Column("iotDeviceRom", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("app_track", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "app_track");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "app_track(com.upuphone.datatrack.base.db.AppTrack).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(3);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("type", new TableInfo.Column("type", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("report_type", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "report_type");
                if (tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "report_type(com.upuphone.datatrack.base.db.ReportType).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
            }
        }, "f03119a4c9038d30660724c77a48d46a", "69ad6addac07ea5c58ba82cbdedb3e42")).b());
    }

    public AppTrackDao f() {
        AppTrackDao appTrackDao;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            try {
                if (this.d == null) {
                    this.d = new AppTrackDao_Impl(this);
                }
                appTrackDao = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appTrackDao;
    }

    public ReportTypeDao g() {
        ReportTypeDao reportTypeDao;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new ReportTypeDao_Impl(this);
                }
                reportTypeDao = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return reportTypeDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(ReportTypeDao.class, ReportTypeDao_Impl.g());
        hashMap.put(AppTrackDao.class, AppTrackDao_Impl.k());
        return hashMap;
    }
}
