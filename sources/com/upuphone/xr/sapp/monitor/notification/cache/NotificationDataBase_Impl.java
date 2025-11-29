package com.upuphone.xr.sapp.monitor.notification.cache;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.honey.account.constant.NetworkParamsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationDataBase_Impl extends NotificationDataBase {
    public volatile WechatMissedCallDao c;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `ArTakeout`");
            I.P("DELETE FROM `WechatMissedCall`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ArTakeout", "WechatMissedCall");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(5) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `ArTakeout` (`id` TEXT NOT NULL, `crate_time` INTEGER NOT NULL, `reminder_type` TEXT NOT NULL, `package_name` TEXT NOT NULL, `takeout_state` TEXT NOT NULL, `takeout_state_desc` TEXT NOT NULL, `estimated_delivery_time` TEXT NOT NULL, `show_text` TEXT NOT NULL, `restaurant_name` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `WechatMissedCall` (`name` TEXT NOT NULL, `date` INTEGER NOT NULL, PRIMARY KEY(`date`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '00ede3a55e6bba7ac1c8642101fb0cd0')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `ArTakeout`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `WechatMissedCall`");
                List<RoomDatabase.Callback> g = NotificationDataBase_Impl.this.mCallbacks;
                if (g != null) {
                    for (RoomDatabase.Callback b : g) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> h = NotificationDataBase_Impl.this.mCallbacks;
                if (h != null) {
                    for (RoomDatabase.Callback a2 : h) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = NotificationDataBase_Impl.this.mDatabase = supportSQLiteDatabase;
                NotificationDataBase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> k = NotificationDataBase_Impl.this.mCallbacks;
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
                HashMap hashMap = new HashMap(9);
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("crate_time", new TableInfo.Column("crate_time", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("reminder_type", new TableInfo.Column("reminder_type", "TEXT", true, 0, (String) null, 1));
                hashMap.put(NetworkParamsKt.PACKAGE_NAME, new TableInfo.Column(NetworkParamsKt.PACKAGE_NAME, "TEXT", true, 0, (String) null, 1));
                hashMap.put("takeout_state", new TableInfo.Column("takeout_state", "TEXT", true, 0, (String) null, 1));
                hashMap.put("takeout_state_desc", new TableInfo.Column("takeout_state_desc", "TEXT", true, 0, (String) null, 1));
                hashMap.put("estimated_delivery_time", new TableInfo.Column("estimated_delivery_time", "TEXT", true, 0, (String) null, 1));
                hashMap.put("show_text", new TableInfo.Column("show_text", "TEXT", true, 0, (String) null, 1));
                hashMap.put("restaurant_name", new TableInfo.Column("restaurant_name", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("ArTakeout", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase, "ArTakeout");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "ArTakeout(com.upuphone.xr.sapp.monitor.notification.model.ArTakeoutModel).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(2);
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("date", new TableInfo.Column("date", "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("WechatMissedCall", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase, "WechatMissedCall");
                if (tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "WechatMissedCall(com.upuphone.xr.sapp.monitor.notification.model.WechatMissedCallModel).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
            }
        }, "00ede3a55e6bba7ac1c8642101fb0cd0", "6d76d60977e955ce689c9d3ec751a0bb")).b());
    }

    public WechatMissedCallDao f() {
        WechatMissedCallDao wechatMissedCallDao;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new WechatMissedCallDao_Impl(this);
                }
                wechatMissedCallDao = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wechatMissedCallDao;
    }

    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(TakeoutDao.class, TakeoutDao_Impl.e());
        hashMap.put(WechatMissedCallDao.class, WechatMissedCallDao_Impl.i());
        return hashMap;
    }
}
