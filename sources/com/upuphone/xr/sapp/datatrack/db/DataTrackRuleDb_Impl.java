package com.upuphone.xr.sapp.datatrack.db;

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

public final class DataTrackRuleDb_Impl extends DataTrackRuleDb {
    public volatile DataTrackRuleDao c;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `DataTrackRule`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "DataTrackRule");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `DataTrackRule` (`ruleId` INTEGER NOT NULL, `deviceType` TEXT NOT NULL, `eventName` TEXT NOT NULL, `eventUseType` INTEGER NOT NULL, PRIMARY KEY(`ruleId`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e87d0e93d4f52f822e2e30e2fb9ecd87')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `DataTrackRule`");
                List<RoomDatabase.Callback> f = DataTrackRuleDb_Impl.this.mCallbacks;
                if (f != null) {
                    for (RoomDatabase.Callback b : f) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> g = DataTrackRuleDb_Impl.this.mCallbacks;
                if (g != null) {
                    for (RoomDatabase.Callback a2 : g) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = DataTrackRuleDb_Impl.this.mDatabase = supportSQLiteDatabase;
                DataTrackRuleDb_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> j = DataTrackRuleDb_Impl.this.mCallbacks;
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
                HashMap hashMap = new HashMap(4);
                hashMap.put("ruleId", new TableInfo.Column("ruleId", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("deviceType", new TableInfo.Column("deviceType", "TEXT", true, 0, (String) null, 1));
                hashMap.put("eventName", new TableInfo.Column("eventName", "TEXT", true, 0, (String) null, 1));
                hashMap.put("eventUseType", new TableInfo.Column("eventUseType", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("DataTrackRule", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase, "DataTrackRule");
                if (tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "DataTrackRule(com.upuphone.xr.sapp.datatrack.DataTrackRule).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
            }
        }, "e87d0e93d4f52f822e2e30e2fb9ecd87", "14ac9f6228d04659efa2cb32590675ac")).b());
    }

    public DataTrackRuleDao e() {
        DataTrackRuleDao dataTrackRuleDao;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new DataTrackRuleDao_Impl(this);
                }
                dataTrackRuleDao = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataTrackRuleDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(DataTrackRuleDao.class, DataTrackRuleDao_Impl.h());
        return hashMap;
    }
}
