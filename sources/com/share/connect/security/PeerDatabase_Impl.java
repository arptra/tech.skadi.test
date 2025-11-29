package com.share.connect.security;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class PeerDatabase_Impl extends PeerDatabase {

    /* renamed from: a  reason: collision with root package name */
    public volatile PeerDao f9910a;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `Peer`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Peer");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `Peer` (`id` TEXT NOT NULL, `auth_key` TEXT, `connection_time` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4243c174af6db32a5c9f09d053c8940f')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `Peer`");
                if (PeerDatabase_Impl.this.mCallbacks != null) {
                    int size = PeerDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) PeerDatabase_Impl.this.mCallbacks.get(i)).b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (PeerDatabase_Impl.this.mCallbacks != null) {
                    int size = PeerDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) PeerDatabase_Impl.this.mCallbacks.get(i)).a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = PeerDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                PeerDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (PeerDatabase_Impl.this.mCallbacks != null) {
                    int size = PeerDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) PeerDatabase_Impl.this.mCallbacks.get(i)).c(supportSQLiteDatabase);
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
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("auth_key", new TableInfo.Column("auth_key", "TEXT", false, 0, (String) null, 1));
                hashMap.put("connection_time", new TableInfo.Column("connection_time", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("Peer", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase, "Peer");
                if (tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "Peer(com.share.connect.security.Peer).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
            }
        }, "4243c174af6db32a5c9f09d053c8940f", "d4081c6b96ff6901349afea96b2e0acf")).b());
    }

    public PeerDao d() {
        PeerDao peerDao;
        if (this.f9910a != null) {
            return this.f9910a;
        }
        synchronized (this) {
            try {
                if (this.f9910a == null) {
                    this.f9910a = new PeerDao_Impl(this);
                }
                peerDao = this.f9910a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return peerDao;
    }

    public Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(PeerDao.class, PeerDao_Impl.d());
        return hashMap;
    }
}
