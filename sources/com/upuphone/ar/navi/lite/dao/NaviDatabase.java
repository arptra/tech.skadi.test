package com.upuphone.ar.navi.lite.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database
public abstract class NaviDatabase extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Migration f5678a = new Migration(1, 2) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.P("ALTER TABLE common_address  ADD COLUMN time INTEGER NOT NULL DEFAULT 0");
        }
    };
    public static final Migration b = new Migration(2, 3) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.P("ALTER TABLE history_record  ADD COLUMN alias TEXT ");
        }
    };
    public static final Migration c = new Migration(3, 4) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS navi_record (id INTEGER PRIMARY KEY NOT NULL, name TEXT,address TEXT,acode TEXT,city TEXT,distance INTEGER NOT NULL DEFAULT 0,lng REAL NOT NULL DEFAULT 0,lat REAL NOT NULL DEFAULT 0,mode INTEGER NOT NULL DEFAULT 0,alias TEXT,count INTEGER NOT NULL DEFAULT 0,time INTEGER NOT NULL DEFAULT 0);");
        }
    };
    public static final Migration d = new Migration(4, 5) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.P("ALTER TABLE common_address ADD COLUMN accountId TEXT ");
            supportSQLiteDatabase.P("ALTER TABLE history_record  ADD COLUMN accountId TEXT ");
            supportSQLiteDatabase.P("ALTER TABLE navi_record  ADD COLUMN accountId TEXT ");
        }
    };
    public static final Migration e = new Migration(5, 6) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.P("DROP INDEX IF EXISTS name_lat_lng_index");
            supportSQLiteDatabase.P("CREATE UNIQUE INDEX IF NOT EXISTS history_record_index ON history_record (`accountId`,`name`,`lat`,`lng`)");
        }
    };

    public abstract CommonAddressDao d();

    public abstract NaviRecordDao e();

    public abstract RecordDao f();
}
