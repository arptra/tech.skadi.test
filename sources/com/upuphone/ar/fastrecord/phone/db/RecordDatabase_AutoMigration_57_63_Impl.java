package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.NonNull;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

final class RecordDatabase_AutoMigration_57_63_Impl extends Migration {
    private final AutoMigrationSpec callback = new FastRecordAutoMigrationSpec();

    public RecordDatabase_AutoMigration_57_63_Impl() {
        super(57, 63);
    }

    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("ALTER TABLE `RecordTodoItemEntity` ADD COLUMN `isReport` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `RecordTodoItemEntity` ADD COLUMN `requestId` TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.P("ALTER TABLE `RecordTodoItemEntity` ADD COLUMN `isNeedRequestServer` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `RecordEntity` ADD COLUMN `wordShareCount` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `RecordEntity` ADD COLUMN `videoShareCount` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `RecordSummaryEntity` ADD COLUMN `isReport` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("ALTER TABLE `RecordSummaryEntity` ADD COLUMN `isNeedRequestServer` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `_new_RecordEntity` (`recordId` INTEGER NOT NULL, `filePath` TEXT, `fileName` TEXT, `md5` TEXT, `shortHandText` TEXT, `shortHandTitle` TEXT, `location` TEXT, `locationShort` TEXT, `totalTime` INTEGER NOT NULL, `summaryInfo` TEXT, `fileSize` INTEGER NOT NULL, `lastModified` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `latitude` INTEGER NOT NULL, `longitude` INTEGER NOT NULL, `type` INTEGER NOT NULL, `playStatus` INTEGER NOT NULL, `recordStatus` INTEGER NOT NULL, `isChoose` INTEGER NOT NULL, `hasRenameRecord` INTEGER NOT NULL, `cacheFileDir` TEXT, `isFinishFileMerge` INTEGER NOT NULL, `cacheLastMergeAllScenePcmChannelPath` TEXT, `cacheLastUpMergePcmChannelPath` TEXT, `cacheLastDownMergePcmChannelPath` TEXT, `cacheLastUpMergeWavChannelPath` TEXT, `cacheLastDownMergeWavChannelPath` TEXT, `cacheLastWavChannelPath` TEXT, `isTwoChannelType` INTEGER NOT NULL, `isFinishAsr` INTEGER NOT NULL, `isEmptyRecord` INTEGER NOT NULL, `isNewRecordItem` INTEGER NOT NULL, `requestId` TEXT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `isDownloading` INTEGER NOT NULL, `isVoiceHasNewMerge` INTEGER NOT NULL, `originTextSize` INTEGER NOT NULL, `languageType` TEXT NOT NULL, `wordShareCount` INTEGER NOT NULL DEFAULT 0, `videoShareCount` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`recordId`))");
        supportSQLiteDatabase.P("INSERT INTO `_new_RecordEntity` (`recordId`,`filePath`,`fileName`,`md5`,`shortHandText`,`shortHandTitle`,`location`,`locationShort`,`totalTime`,`summaryInfo`,`fileSize`,`lastModified`,`createTime`,`latitude`,`longitude`,`type`,`playStatus`,`recordStatus`,`isChoose`,`hasRenameRecord`,`cacheFileDir`,`isFinishFileMerge`,`cacheLastMergeAllScenePcmChannelPath`,`cacheLastUpMergePcmChannelPath`,`cacheLastDownMergePcmChannelPath`,`cacheLastUpMergeWavChannelPath`,`cacheLastDownMergeWavChannelPath`,`cacheLastWavChannelPath`,`isTwoChannelType`,`isFinishAsr`,`isEmptyRecord`,`isNewRecordItem`,`requestId`,`accountId`,`recognizeId`,`isDownloading`,`isVoiceHasNewMerge`,`originTextSize`,`languageType`) SELECT `recordId`,`filePath`,`fileName`,`md5`,`shortHandText`,`shortHandTitle`,`location`,`locationShort`,`totalTime`,`summaryInfo`,`fileSize`,`lastModified`,`createTime`,`latitude`,`longitude`,`type`,`playStatus`,`recordStatus`,`isChoose`,`hasRenameRecord`,`cacheFileDir`,`isFinishFileMerge`,`cacheLastMergeAllScenePcmChannelPath`,`cacheLastUpMergePcmChannelPath`,`cacheLastDownMergePcmChannelPath`,`cacheLastUpMergeWavChannelPath`,`cacheLastDownMergeWavChannelPath`,`cacheLastWavChannelPath`,`isTwoChannelType`,`isFinishAsr`,`isEmptyRecord`,`isNewRecordItem`,`requestId`,`accountId`,`recognizeId`,`isDownloading`,`isVoiceHasNewMerge`,`originTextSize`,`languageType` FROM `RecordEntity`");
        supportSQLiteDatabase.P("DROP TABLE `RecordEntity`");
        supportSQLiteDatabase.P("ALTER TABLE `_new_RecordEntity` RENAME TO `RecordEntity`");
        this.callback.onPostMigrate(supportSQLiteDatabase);
    }
}
