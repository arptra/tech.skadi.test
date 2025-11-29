package com.upuphone.ar.navi.lite.dao;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.meizu.common.widget.MzContactsContract;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NaviDatabase_Impl extends NaviDatabase {
    public volatile RecordDao f;
    public volatile CommonAddressDao g;
    public volatile NaviRecordDao h;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `history_record`");
            I.P("DELETE FROM `common_address`");
            I.P("DELETE FROM `navi_record`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "history_record", "common_address", "navi_record");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(6) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `history_record` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `accountId` TEXT, `name` TEXT, `acode` TEXT, `address` TEXT, `country` TEXT, `province` TEXT, `city` TEXT, `district` TEXT, `distance` INTEGER NOT NULL, `lng` REAL NOT NULL, `lat` REAL NOT NULL, `lastUseTime` TEXT, `count` INTEGER NOT NULL, `alias` TEXT)");
                supportSQLiteDatabase.P("CREATE UNIQUE INDEX IF NOT EXISTS `history_record_index` ON `history_record` (`accountId`, `name`, `lat`, `lng`)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `common_address` (`alias` TEXT NOT NULL, `accountId` TEXT, `name` TEXT, `acode` TEXT, `address` TEXT, `country` TEXT, `province` TEXT, `city` TEXT, `district` TEXT, `lng` REAL NOT NULL, `lat` REAL NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`alias`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `navi_record` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `accountId` TEXT, `name` TEXT, `address` TEXT, `acode` TEXT, `city` TEXT, `distance` INTEGER NOT NULL, `lng` REAL NOT NULL, `lat` REAL NOT NULL, `mode` INTEGER NOT NULL, `alias` TEXT, `count` INTEGER NOT NULL, `time` INTEGER NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f64dad816b3ce6ffd6e7801dcb9616ee')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `history_record`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `common_address`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `navi_record`");
                List<RoomDatabase.Callback> g = NaviDatabase_Impl.this.mCallbacks;
                if (g != null) {
                    for (RoomDatabase.Callback b : g) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> h = NaviDatabase_Impl.this.mCallbacks;
                if (h != null) {
                    for (RoomDatabase.Callback a2 : h) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = NaviDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                NaviDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> k = NaviDatabase_Impl.this.mCallbacks;
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
                HashMap hashMap = new HashMap(15);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("accountId", new TableInfo.Column("accountId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap.put("acode", new TableInfo.Column("acode", "TEXT", false, 0, (String) null, 1));
                hashMap.put(MzContactsContract.MzContactColumns.ADDRESS, new TableInfo.Column(MzContactsContract.MzContactColumns.ADDRESS, "TEXT", false, 0, (String) null, 1));
                hashMap.put("country", new TableInfo.Column("country", "TEXT", false, 0, (String) null, 1));
                hashMap.put("province", new TableInfo.Column("province", "TEXT", false, 0, (String) null, 1));
                hashMap.put("city", new TableInfo.Column("city", "TEXT", false, 0, (String) null, 1));
                hashMap.put("district", new TableInfo.Column("district", "TEXT", false, 0, (String) null, 1));
                hashMap.put(MzContactsContract.MzContactColumns.DISTANCE, new TableInfo.Column(MzContactsContract.MzContactColumns.DISTANCE, "INTEGER", true, 0, (String) null, 1));
                hashMap.put("lng", new TableInfo.Column("lng", "REAL", true, 0, (String) null, 1));
                hashMap.put("lat", new TableInfo.Column("lat", "REAL", true, 0, (String) null, 1));
                hashMap.put("lastUseTime", new TableInfo.Column("lastUseTime", "TEXT", false, 0, (String) null, 1));
                hashMap.put("count", new TableInfo.Column("count", "INTEGER", true, 0, (String) null, 1));
                Object obj = "count";
                hashMap.put("alias", new TableInfo.Column("alias", "TEXT", false, 0, (String) null, 1));
                Object obj2 = MzContactsContract.MzContactColumns.DISTANCE;
                HashSet hashSet = new HashSet(0);
                Object obj3 = "id";
                HashSet hashSet2 = new HashSet(1);
                Object obj4 = "lat";
                Object obj5 = "lng";
                Object obj6 = "district";
                Object obj7 = "city";
                hashSet2.add(new TableInfo.Index("history_record_index", true, Arrays.asList(new String[]{"accountId", "name", "lat", "lng"}), Arrays.asList(new String[]{"ASC", "ASC", "ASC", "ASC"})));
                TableInfo tableInfo = new TableInfo("history_record", hashMap, hashSet, hashSet2);
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "history_record");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "history_record(com.upuphone.ar.navi.lite.base.Record).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(12);
                hashMap2.put("alias", new TableInfo.Column("alias", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("accountId", new TableInfo.Column("accountId", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("acode", new TableInfo.Column("acode", "TEXT", false, 0, (String) null, 1));
                hashMap2.put(MzContactsContract.MzContactColumns.ADDRESS, new TableInfo.Column(MzContactsContract.MzContactColumns.ADDRESS, "TEXT", false, 0, (String) null, 1));
                hashMap2.put("country", new TableInfo.Column("country", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("province", new TableInfo.Column("province", "TEXT", false, 0, (String) null, 1));
                Object obj8 = obj7;
                hashMap2.put(obj8, new TableInfo.Column("city", "TEXT", false, 0, (String) null, 1));
                hashMap2.put(obj6, new TableInfo.Column("district", "TEXT", false, 0, (String) null, 1));
                Object obj9 = obj5;
                hashMap2.put(obj9, new TableInfo.Column("lng", "REAL", true, 0, (String) null, 1));
                Object obj10 = obj4;
                hashMap2.put(obj10, new TableInfo.Column("lat", "REAL", true, 0, (String) null, 1));
                hashMap2.put(RtspHeaders.Values.TIME, new TableInfo.Column(RtspHeaders.Values.TIME, "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("common_address", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "common_address");
                if (!tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(false, "common_address(com.upuphone.ar.navi.lite.base.CommonAddress).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(13);
                hashMap3.put(obj3, new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap3.put("accountId", new TableInfo.Column("accountId", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(MzContactsContract.MzContactColumns.ADDRESS, new TableInfo.Column(MzContactsContract.MzContactColumns.ADDRESS, "TEXT", false, 0, (String) null, 1));
                hashMap3.put("acode", new TableInfo.Column("acode", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(obj8, new TableInfo.Column("city", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(obj2, new TableInfo.Column(MzContactsContract.MzContactColumns.DISTANCE, "INTEGER", true, 0, (String) null, 1));
                hashMap3.put(obj9, new TableInfo.Column("lng", "REAL", true, 0, (String) null, 1));
                hashMap3.put(obj10, new TableInfo.Column("lat", "REAL", true, 0, (String) null, 1));
                hashMap3.put(RtspHeaders.Values.MODE, new TableInfo.Column(RtspHeaders.Values.MODE, "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("alias", new TableInfo.Column("alias", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(obj, new TableInfo.Column("count", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put(RtspHeaders.Values.TIME, new TableInfo.Column(RtspHeaders.Values.TIME, "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("navi_record", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo a4 = TableInfo.a(supportSQLiteDatabase2, "navi_record");
                if (tableInfo3.equals(a4)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "navi_record(com.upuphone.ar.navi.lite.base.NaviRecord).\n Expected:\n" + tableInfo3 + "\n Found:\n" + a4);
            }
        }, "f64dad816b3ce6ffd6e7801dcb9616ee", "684fa1c2c0bae2d19c33d92f37e9a52f")).b());
    }

    public CommonAddressDao d() {
        CommonAddressDao commonAddressDao;
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            try {
                if (this.g == null) {
                    this.g = new CommonAddressDao_Impl(this);
                }
                commonAddressDao = this.g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return commonAddressDao;
    }

    public NaviRecordDao e() {
        NaviRecordDao naviRecordDao;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            try {
                if (this.h == null) {
                    this.h = new NaviRecordDao_Impl(this);
                }
                naviRecordDao = this.h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return naviRecordDao;
    }

    public RecordDao f() {
        RecordDao recordDao;
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            try {
                if (this.f == null) {
                    this.f = new RecordDao_Impl(this);
                }
                recordDao = this.f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return recordDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(RecordDao.class, RecordDao_Impl.l());
        hashMap.put(CommonAddressDao.class, CommonAddressDao_Impl.j());
        hashMap.put(NaviRecordDao.class, NaviRecordDao_Impl.k());
        return hashMap;
    }
}
