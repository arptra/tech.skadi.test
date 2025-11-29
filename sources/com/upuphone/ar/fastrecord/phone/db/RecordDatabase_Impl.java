package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
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

public final class RecordDatabase_Impl extends RecordDatabase {
    private volatile FastRecordDao _fastRecordDao;
    private volatile FastRecordPersonDao _fastRecordPersonDao;
    private volatile FastRecordPersonHistoryDao _fastRecordPersonHistoryDao;
    private volatile FastRecordSummaryDao _fastRecordSummaryDao;
    private volatile FastRecordTagDao _fastRecordTagDao;
    private volatile FastRecordTagHistoryDao _fastRecordTagHistoryDao;
    private volatile FastRecordTodoItemDao _fastRecordTodoItemDao;
    private volatile FastRecordVoiceDao _fastRecordVoiceDao;
    private volatile FastRecordVoiceWordDao _fastRecordVoiceWordDao;

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase I = super.getOpenHelper().I();
        try {
            super.beginTransaction();
            I.P("DELETE FROM `RecordHistoryPersonEntity`");
            I.P("DELETE FROM `RecordContentHistoryTagEntity`");
            I.P("DELETE FROM `RecordTodoItemEntity`");
            I.P("DELETE FROM `RecordPersonEntity`");
            I.P("DELETE FROM `RecordContentTagEntity`");
            I.P("DELETE FROM `RecordEntity`");
            I.P("DELETE FROM `RecordSummaryEntity`");
            I.P("DELETE FROM `RecordVoiceWordEntity`");
            I.P("DELETE FROM `RecordVoiceEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            I.n0("PRAGMA wal_checkpoint(FULL)").close();
            if (!I.s0()) {
                I.P("VACUUM");
            }
        }
    }

    @NonNull
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "RecordHistoryPersonEntity", "RecordContentHistoryTagEntity", "RecordTodoItemEntity", "RecordPersonEntity", "RecordContentTagEntity", "RecordEntity", "RecordSummaryEntity", "RecordVoiceWordEntity", "RecordVoiceEntity");
    }

    @NonNull
    public SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f1731a).d(databaseConfiguration.b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(63) {
            public void createAllTables(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordHistoryPersonEntity` (`personTagId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `personName` TEXT, `createTime` INTEGER NOT NULL, `accountId` TEXT NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordContentHistoryTagEntity` (`contentTagId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contentName` TEXT, `createTime` INTEGER NOT NULL, `accountId` TEXT NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordTodoItemEntity` (`todoItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recognizeId` TEXT NOT NULL, `recordId` INTEGER NOT NULL, `start_time` TEXT NOT NULL, `end_time` TEXT NOT NULL, `todoTitle` TEXT NOT NULL, `content` TEXT NOT NULL, `contentTemp` TEXT, `viewType` INTEGER NOT NULL, `isAddSchedule` INTEGER NOT NULL, `isFinish` INTEGER NOT NULL, `isEdit` INTEGER NOT NULL, `calendarId` INTEGER NOT NULL, `calendarEventId` INTEGER NOT NULL, `isFinishDel` INTEGER NOT NULL, `isReport` INTEGER NOT NULL DEFAULT 0, `requestId` TEXT NOT NULL DEFAULT '', `isNeedRequestServer` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordPersonEntity` (`personTagId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recordId` INTEGER NOT NULL, `personName` TEXT, `personType` TEXT NOT NULL, `createTime` INTEGER NOT NULL, `accountId` TEXT NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordContentTagEntity` (`contentTagId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recordId` INTEGER NOT NULL, `contentName` TEXT, `createTime` INTEGER NOT NULL, `accountId` TEXT NOT NULL)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordEntity` (`recordId` INTEGER NOT NULL, `filePath` TEXT, `fileName` TEXT, `md5` TEXT, `shortHandText` TEXT, `shortHandTitle` TEXT, `location` TEXT, `locationShort` TEXT, `totalTime` INTEGER NOT NULL, `summaryInfo` TEXT, `fileSize` INTEGER NOT NULL, `lastModified` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `latitude` INTEGER NOT NULL, `longitude` INTEGER NOT NULL, `type` INTEGER NOT NULL, `playStatus` INTEGER NOT NULL, `recordStatus` INTEGER NOT NULL, `isChoose` INTEGER NOT NULL, `hasRenameRecord` INTEGER NOT NULL, `cacheFileDir` TEXT, `isFinishFileMerge` INTEGER NOT NULL, `cacheLastMergeAllScenePcmChannelPath` TEXT, `cacheLastUpMergePcmChannelPath` TEXT, `cacheLastDownMergePcmChannelPath` TEXT, `cacheLastUpMergeWavChannelPath` TEXT, `cacheLastDownMergeWavChannelPath` TEXT, `cacheLastWavChannelPath` TEXT, `isTwoChannelType` INTEGER NOT NULL, `isFinishAsr` INTEGER NOT NULL, `isEmptyRecord` INTEGER NOT NULL, `isNewRecordItem` INTEGER NOT NULL, `requestId` TEXT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `isDownloading` INTEGER NOT NULL, `isVoiceHasNewMerge` INTEGER NOT NULL, `originTextSize` INTEGER NOT NULL, `languageType` TEXT NOT NULL, `wordShareCount` INTEGER NOT NULL DEFAULT 0, `videoShareCount` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`recordId`))");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordSummaryEntity` (`summaryId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fileName` TEXT, `content` TEXT, `contentTemp` TEXT, `versionCode` TEXT, `appName` TEXT NOT NULL, `recognizeId` TEXT, `accountId` TEXT NOT NULL, `requestId` TEXT NOT NULL, `traceId` TEXT NOT NULL, `recordId` INTEGER NOT NULL, `terminalTraceId` TEXT NOT NULL, `isFinishDel` INTEGER NOT NULL, `isReport` INTEGER NOT NULL DEFAULT 0, `isNeedRequestServer` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordVoiceWordEntity` (`wordId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT, `recordId` INTEGER NOT NULL, `fileName` TEXT, `startTime` INTEGER NOT NULL, `endTime` INTEGER NOT NULL, `wordContent` TEXT, `wordContentTemp` TEXT, `isFinishWord` INTEGER NOT NULL, `roles` TEXT)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordVoiceEntity` (`recordVoiceId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT, `recordId` INTEGER NOT NULL, `cacheFileDir` TEXT, `cachePcmFilePath` TEXT, `cacheOPlusFilePath` TEXT, `startTag` INTEGER NOT NULL, `endTag` INTEGER NOT NULL, `tagInfo` TEXT, `role` TEXT)");
                supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.P("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '506e8f686989f40c2886a8c76b59407e')");
            }

            public void dropAllTables(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordHistoryPersonEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordContentHistoryTagEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordTodoItemEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordPersonEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordContentTagEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordSummaryEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordVoiceWordEntity`");
                supportSQLiteDatabase.P("DROP TABLE IF EXISTS `RecordVoiceEntity`");
                List<RoomDatabase.Callback> access$000 = RecordDatabase_Impl.this.mCallbacks;
                if (access$000 != null) {
                    for (RoomDatabase.Callback b : access$000) {
                        b.b(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> access$100 = RecordDatabase_Impl.this.mCallbacks;
                if (access$100 != null) {
                    for (RoomDatabase.Callback a2 : access$100) {
                        a2.a(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = RecordDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                RecordDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> access$400 = RecordDatabase_Impl.this.mCallbacks;
                if (access$400 != null) {
                    for (RoomDatabase.Callback c : access$400) {
                        c.c(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.b(supportSQLiteDatabase);
            }

            @NonNull
            public RoomOpenHelper.ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(4);
                hashMap.put("personTagId", new TableInfo.Column("personTagId", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("personName", new TableInfo.Column("personName", "TEXT", false, 0, (String) null, 1));
                hashMap.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("RecordHistoryPersonEntity", hashMap, new HashSet(0), new HashSet(0));
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "RecordHistoryPersonEntity");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordHistoryPersonEntity(com.upuphone.ar.fastrecord.phone.db.RecordHistoryPersonEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("contentTagId", new TableInfo.Column("contentTagId", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("contentName", new TableInfo.Column("contentName", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("RecordContentHistoryTagEntity", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "RecordContentHistoryTagEntity");
                if (!tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordContentHistoryTagEntity(com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(18);
                hashMap3.put("todoItemId", new TableInfo.Column("todoItemId", "INTEGER", true, 1, (String) null, 1));
                hashMap3.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("recordId", new TableInfo.Column("recordId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("start_time", new TableInfo.Column("start_time", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("end_time", new TableInfo.Column("end_time", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("todoTitle", new TableInfo.Column("todoTitle", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("contentTemp", new TableInfo.Column("contentTemp", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("viewType", new TableInfo.Column("viewType", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("isAddSchedule", new TableInfo.Column("isAddSchedule", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("isFinish", new TableInfo.Column("isFinish", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("isEdit", new TableInfo.Column("isEdit", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("calendarId", new TableInfo.Column("calendarId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("calendarEventId", new TableInfo.Column("calendarEventId", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("isFinishDel", new TableInfo.Column("isFinishDel", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("isReport", new TableInfo.Column("isReport", "INTEGER", true, 0, "0", 1));
                Object obj = "isReport";
                hashMap3.put("requestId", new TableInfo.Column("requestId", "TEXT", true, 0, "''", 1));
                Object obj2 = "isFinishDel";
                hashMap3.put("isNeedRequestServer", new TableInfo.Column("isNeedRequestServer", "INTEGER", true, 0, "0", 1));
                Object obj3 = "isNeedRequestServer";
                Object obj4 = "contentTemp";
                Object obj5 = "content";
                TableInfo tableInfo3 = new TableInfo("RecordTodoItemEntity", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo a4 = TableInfo.a(supportSQLiteDatabase2, "RecordTodoItemEntity");
                if (!tableInfo3.equals(a4)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordTodoItemEntity(com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(6);
                hashMap4.put("personTagId", new TableInfo.Column("personTagId", "INTEGER", true, 1, (String) null, 1));
                hashMap4.put("recordId", new TableInfo.Column("recordId", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("personName", new TableInfo.Column("personName", "TEXT", false, 0, (String) null, 1));
                hashMap4.put("personType", new TableInfo.Column("personType", "TEXT", true, 0, (String) null, 1));
                hashMap4.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo("RecordPersonEntity", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo a5 = TableInfo.a(supportSQLiteDatabase2, "RecordPersonEntity");
                if (!tableInfo4.equals(a5)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordPersonEntity(com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + a5);
                }
                HashMap hashMap5 = new HashMap(5);
                hashMap5.put("contentTagId", new TableInfo.Column("contentTagId", "INTEGER", true, 1, (String) null, 1));
                hashMap5.put("recordId", new TableInfo.Column("recordId", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("contentName", new TableInfo.Column("contentName", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo("RecordContentTagEntity", hashMap5, new HashSet(0), new HashSet(0));
                TableInfo a6 = TableInfo.a(supportSQLiteDatabase2, "RecordContentTagEntity");
                if (!tableInfo5.equals(a6)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordContentTagEntity(com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + a6);
                }
                HashMap hashMap6 = new HashMap(41);
                hashMap6.put("recordId", new TableInfo.Column("recordId", "INTEGER", true, 1, (String) null, 1));
                hashMap6.put("filePath", new TableInfo.Column("filePath", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("fileName", new TableInfo.Column("fileName", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("md5", new TableInfo.Column("md5", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("shortHandText", new TableInfo.Column("shortHandText", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("shortHandTitle", new TableInfo.Column("shortHandTitle", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("location", new TableInfo.Column("location", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("locationShort", new TableInfo.Column("locationShort", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("totalTime", new TableInfo.Column("totalTime", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("summaryInfo", new TableInfo.Column("summaryInfo", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("lastModified", new TableInfo.Column("lastModified", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("latitude", new TableInfo.Column("latitude", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("longitude", new TableInfo.Column("longitude", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("type", new TableInfo.Column("type", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("playStatus", new TableInfo.Column("playStatus", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("recordStatus", new TableInfo.Column("recordStatus", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("isChoose", new TableInfo.Column("isChoose", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("hasRenameRecord", new TableInfo.Column("hasRenameRecord", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("cacheFileDir", new TableInfo.Column("cacheFileDir", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("isFinishFileMerge", new TableInfo.Column("isFinishFileMerge", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("cacheLastMergeAllScenePcmChannelPath", new TableInfo.Column("cacheLastMergeAllScenePcmChannelPath", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("cacheLastUpMergePcmChannelPath", new TableInfo.Column("cacheLastUpMergePcmChannelPath", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("cacheLastDownMergePcmChannelPath", new TableInfo.Column("cacheLastDownMergePcmChannelPath", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("cacheLastUpMergeWavChannelPath", new TableInfo.Column("cacheLastUpMergeWavChannelPath", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("cacheLastDownMergeWavChannelPath", new TableInfo.Column("cacheLastDownMergeWavChannelPath", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("cacheLastWavChannelPath", new TableInfo.Column("cacheLastWavChannelPath", "TEXT", false, 0, (String) null, 1));
                hashMap6.put("isTwoChannelType", new TableInfo.Column("isTwoChannelType", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("isFinishAsr", new TableInfo.Column("isFinishAsr", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("isEmptyRecord", new TableInfo.Column("isEmptyRecord", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("isNewRecordItem", new TableInfo.Column("isNewRecordItem", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("requestId", new TableInfo.Column("requestId", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("isDownloading", new TableInfo.Column("isDownloading", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("isVoiceHasNewMerge", new TableInfo.Column("isVoiceHasNewMerge", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("originTextSize", new TableInfo.Column("originTextSize", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("languageType", new TableInfo.Column("languageType", "TEXT", true, 0, (String) null, 1));
                hashMap6.put("wordShareCount", new TableInfo.Column("wordShareCount", "INTEGER", true, 0, "0", 1));
                hashMap6.put("videoShareCount", new TableInfo.Column("videoShareCount", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo6 = new TableInfo("RecordEntity", hashMap6, new HashSet(0), new HashSet(0));
                TableInfo a7 = TableInfo.a(supportSQLiteDatabase2, "RecordEntity");
                if (!tableInfo6.equals(a7)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordEntity(com.upuphone.ar.fastrecord.phone.db.RecordEntity).\n Expected:\n" + tableInfo6 + "\n Found:\n" + a7);
                }
                HashMap hashMap7 = new HashMap(15);
                hashMap7.put("summaryId", new TableInfo.Column("summaryId", "INTEGER", true, 1, (String) null, 1));
                hashMap7.put("fileName", new TableInfo.Column("fileName", "TEXT", false, 0, (String) null, 1));
                hashMap7.put(obj5, new TableInfo.Column("content", "TEXT", false, 0, (String) null, 1));
                hashMap7.put(obj4, new TableInfo.Column("contentTemp", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("versionCode", new TableInfo.Column("versionCode", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("appName", new TableInfo.Column("appName", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("recognizeId", new TableInfo.Column("recognizeId", "TEXT", false, 0, (String) null, 1));
                hashMap7.put("accountId", new TableInfo.Column("accountId", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("requestId", new TableInfo.Column("requestId", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("traceId", new TableInfo.Column("traceId", "TEXT", true, 0, (String) null, 1));
                hashMap7.put("recordId", new TableInfo.Column("recordId", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("terminalTraceId", new TableInfo.Column("terminalTraceId", "TEXT", true, 0, (String) null, 1));
                hashMap7.put(obj2, new TableInfo.Column("isFinishDel", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put(obj, new TableInfo.Column("isReport", "INTEGER", true, 0, "0", 1));
                hashMap7.put(obj3, new TableInfo.Column("isNeedRequestServer", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo7 = new TableInfo("RecordSummaryEntity", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo a8 = TableInfo.a(supportSQLiteDatabase2, "RecordSummaryEntity");
                if (!tableInfo7.equals(a8)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordSummaryEntity(com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + a8);
                }
                HashMap hashMap8 = new HashMap(10);
                hashMap8.put("wordId", new TableInfo.Column("wordId", "INTEGER", true, 1, (String) null, 1));
                hashMap8.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("recordId", new TableInfo.Column("recordId", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("fileName", new TableInfo.Column("fileName", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("endTime", new TableInfo.Column("endTime", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("wordContent", new TableInfo.Column("wordContent", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("wordContentTemp", new TableInfo.Column("wordContentTemp", "TEXT", false, 0, (String) null, 1));
                hashMap8.put("isFinishWord", new TableInfo.Column("isFinishWord", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("roles", new TableInfo.Column("roles", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo8 = new TableInfo("RecordVoiceWordEntity", hashMap8, new HashSet(0), new HashSet(0));
                TableInfo a9 = TableInfo.a(supportSQLiteDatabase2, "RecordVoiceWordEntity");
                if (!tableInfo8.equals(a9)) {
                    return new RoomOpenHelper.ValidationResult(false, "RecordVoiceWordEntity(com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity).\n Expected:\n" + tableInfo8 + "\n Found:\n" + a9);
                }
                HashMap hashMap9 = new HashMap(10);
                hashMap9.put("recordVoiceId", new TableInfo.Column("recordVoiceId", "INTEGER", true, 1, (String) null, 1));
                hashMap9.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("recordId", new TableInfo.Column("recordId", "INTEGER", true, 0, (String) null, 1));
                hashMap9.put("cacheFileDir", new TableInfo.Column("cacheFileDir", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("cachePcmFilePath", new TableInfo.Column("cachePcmFilePath", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("cacheOPlusFilePath", new TableInfo.Column("cacheOPlusFilePath", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("startTag", new TableInfo.Column("startTag", "INTEGER", true, 0, (String) null, 1));
                hashMap9.put("endTag", new TableInfo.Column("endTag", "INTEGER", true, 0, (String) null, 1));
                hashMap9.put("tagInfo", new TableInfo.Column("tagInfo", "TEXT", false, 0, (String) null, 1));
                hashMap9.put("role", new TableInfo.Column("role", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo9 = new TableInfo("RecordVoiceEntity", hashMap9, new HashSet(0), new HashSet(0));
                TableInfo a10 = TableInfo.a(supportSQLiteDatabase2, "RecordVoiceEntity");
                if (tableInfo9.equals(a10)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "RecordVoiceEntity(com.upuphone.ar.fastrecord.phone.db.RecordVoiceEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + a10);
            }
        }, "506e8f686989f40c2886a8c76b59407e", "f26a262d908c71846681c84d4516f5ca")).b());
    }

    public FastRecordDao fastRecordDao() {
        FastRecordDao fastRecordDao;
        if (this._fastRecordDao != null) {
            return this._fastRecordDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordDao == null) {
                    this._fastRecordDao = new FastRecordDao_Impl(this);
                }
                fastRecordDao = this._fastRecordDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordDao;
    }

    public FastRecordPersonDao fastRecordPersonDao() {
        FastRecordPersonDao fastRecordPersonDao;
        if (this._fastRecordPersonDao != null) {
            return this._fastRecordPersonDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordPersonDao == null) {
                    this._fastRecordPersonDao = new FastRecordPersonDao_Impl(this);
                }
                fastRecordPersonDao = this._fastRecordPersonDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordPersonDao;
    }

    public FastRecordPersonHistoryDao fastRecordPersonHistoryDao() {
        FastRecordPersonHistoryDao fastRecordPersonHistoryDao;
        if (this._fastRecordPersonHistoryDao != null) {
            return this._fastRecordPersonHistoryDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordPersonHistoryDao == null) {
                    this._fastRecordPersonHistoryDao = new FastRecordPersonHistoryDao_Impl(this);
                }
                fastRecordPersonHistoryDao = this._fastRecordPersonHistoryDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordPersonHistoryDao;
    }

    public FastRecordSummaryDao fastRecordSummaryDao() {
        FastRecordSummaryDao fastRecordSummaryDao;
        if (this._fastRecordSummaryDao != null) {
            return this._fastRecordSummaryDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordSummaryDao == null) {
                    this._fastRecordSummaryDao = new FastRecordSummaryDao_Impl(this);
                }
                fastRecordSummaryDao = this._fastRecordSummaryDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordSummaryDao;
    }

    public FastRecordTagDao fastRecordTagDao() {
        FastRecordTagDao fastRecordTagDao;
        if (this._fastRecordTagDao != null) {
            return this._fastRecordTagDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordTagDao == null) {
                    this._fastRecordTagDao = new FastRecordTagDao_Impl(this);
                }
                fastRecordTagDao = this._fastRecordTagDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordTagDao;
    }

    public FastRecordTagHistoryDao fastRecordTagHistoryDao() {
        FastRecordTagHistoryDao fastRecordTagHistoryDao;
        if (this._fastRecordTagHistoryDao != null) {
            return this._fastRecordTagHistoryDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordTagHistoryDao == null) {
                    this._fastRecordTagHistoryDao = new FastRecordTagHistoryDao_Impl(this);
                }
                fastRecordTagHistoryDao = this._fastRecordTagHistoryDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordTagHistoryDao;
    }

    public FastRecordTodoItemDao fastRecordTodoItemDao() {
        FastRecordTodoItemDao fastRecordTodoItemDao;
        if (this._fastRecordTodoItemDao != null) {
            return this._fastRecordTodoItemDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordTodoItemDao == null) {
                    this._fastRecordTodoItemDao = new FastRecordTodoItemDao_Impl(this);
                }
                fastRecordTodoItemDao = this._fastRecordTodoItemDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordTodoItemDao;
    }

    public FastRecordVoiceDao fastRecordVoiceDao() {
        FastRecordVoiceDao fastRecordVoiceDao;
        if (this._fastRecordVoiceDao != null) {
            return this._fastRecordVoiceDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordVoiceDao == null) {
                    this._fastRecordVoiceDao = new FastRecordVoiceDao_Impl(this);
                }
                fastRecordVoiceDao = this._fastRecordVoiceDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordVoiceDao;
    }

    public FastRecordVoiceWordDao fastRecordVoiceWordDao() {
        FastRecordVoiceWordDao fastRecordVoiceWordDao;
        if (this._fastRecordVoiceWordDao != null) {
            return this._fastRecordVoiceWordDao;
        }
        synchronized (this) {
            try {
                if (this._fastRecordVoiceWordDao == null) {
                    this._fastRecordVoiceWordDao = new FastRecordVoiceWordDao_Impl(this);
                }
                fastRecordVoiceWordDao = this._fastRecordVoiceWordDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fastRecordVoiceWordDao;
    }

    @NonNull
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RecordDatabase_AutoMigration_57_63_Impl());
        arrayList.add(new RecordDatabase_AutoMigration_60_63_Impl());
        return arrayList;
    }

    @NonNull
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @NonNull
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(FastRecordDao.class, FastRecordDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordSummaryDao.class, FastRecordSummaryDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordVoiceDao.class, FastRecordVoiceDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordVoiceWordDao.class, FastRecordVoiceWordDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordPersonDao.class, FastRecordPersonDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordPersonHistoryDao.class, FastRecordPersonHistoryDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordTagHistoryDao.class, FastRecordTagHistoryDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordTagDao.class, FastRecordTagDao_Impl.getRequiredConverters());
        hashMap.put(FastRecordTodoItemDao.class, FastRecordTodoItemDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
