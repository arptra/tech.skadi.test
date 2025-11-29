package com.upuphone.ar.fastrecord.phone.db;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordDatabase$Companion$get$1$instance$1 extends Lambda implements Function1<SupportSQLiteDatabase, Unit> {
    public static final RecordDatabase$Companion$get$1$instance$1 INSTANCE = new RecordDatabase$Companion$get$1$instance$1();

    public RecordDatabase$Companion$get$1$instance$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SupportSQLiteDatabase) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.P("ALTER TABLE RecordTodoItemEntity RENAME TO temp_RecordTodoItemEntity");
        supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordTodoItemEntity` (`todoItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `recognizeId` TEXT NOT NULL, `recordId` INTEGER NOT NULL, `start_time` TEXT NOT NULL, `end_time` TEXT NOT NULL, `todoTitle` TEXT NOT NULL, `content` TEXT NOT NULL, `contentTemp` TEXT, `viewType` INTEGER NOT NULL, `isAddSchedule` INTEGER NOT NULL, `isFinish` INTEGER NOT NULL, `isEdit` INTEGER NOT NULL, `calendarId` INTEGER NOT NULL, `calendarEventId` INTEGER NOT NULL, `isFinishDel` INTEGER NOT NULL, `isReport` INTEGER NOT NULL DEFAULT 0, `requestId` TEXT NOT NULL DEFAULT '', `isNeedRequestServer` INTEGER NOT NULL DEFAULT 0)");
        supportSQLiteDatabase.P("INSERT INTO RecordTodoItemEntity SELECT * FROM temp_RecordTodoItemEntity");
        supportSQLiteDatabase.P("DROP TABLE temp_RecordTodoItemEntity");
        supportSQLiteDatabase.P("ALTER TABLE RecordEntity RENAME TO temp_RecordEntity");
        supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordEntity` (`recordId` INTEGER NOT NULL, `filePath` TEXT, `fileName` TEXT, `md5` TEXT, `shortHandText` TEXT, `shortHandTitle` TEXT, `location` TEXT, `locationShort` TEXT, `totalTime` INTEGER NOT NULL, `summaryInfo` TEXT, `fileSize` INTEGER NOT NULL, `lastModified` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `latitude` INTEGER NOT NULL, `longitude` INTEGER NOT NULL, `type` INTEGER NOT NULL, `playStatus` INTEGER NOT NULL, `recordStatus` INTEGER NOT NULL, `isChoose` INTEGER NOT NULL, `hasRenameRecord` INTEGER NOT NULL, `cacheFileDir` TEXT, `isFinishFileMerge` INTEGER NOT NULL, `cacheLastMergeAllScenePcmChannelPath` TEXT, `cacheLastUpMergePcmChannelPath` TEXT, `cacheLastDownMergePcmChannelPath` TEXT, `cacheLastUpMergeWavChannelPath` TEXT, `cacheLastDownMergeWavChannelPath` TEXT, `cacheLastWavChannelPath` TEXT, `isTwoChannelType` INTEGER NOT NULL, `isFinishAsr` INTEGER NOT NULL, `isEmptyRecord` INTEGER NOT NULL, `isNewRecordItem` INTEGER NOT NULL, `requestId` TEXT NOT NULL, `accountId` TEXT NOT NULL, `recognizeId` TEXT NOT NULL, `isDownloading` INTEGER NOT NULL, `isVoiceHasNewMerge` INTEGER NOT NULL, `originTextSize` INTEGER NOT NULL, `languageType` TEXT NOT NULL, `wordShareCount` INTEGER NOT NULL DEFAULT 0, `videoShareCount` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`recordId`))");
        supportSQLiteDatabase.P("INSERT INTO RecordEntity SELECT * FROM temp_RecordEntity");
        supportSQLiteDatabase.P("DROP TABLE temp_RecordEntity");
        supportSQLiteDatabase.P("ALTER TABLE RecordSummaryEntity RENAME TO temp_RecordSummaryEntity");
        supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS `RecordSummaryEntity` (`summaryId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fileName` TEXT, `content` TEXT, `contentTemp` TEXT, `versionCode` TEXT, `appName` TEXT NOT NULL, `recognizeId` TEXT, `accountId` TEXT NOT NULL, `requestId` TEXT NOT NULL, `traceId` TEXT NOT NULL, `recordId` INTEGER NOT NULL, `terminalTraceId` TEXT NOT NULL, `isFinishDel` INTEGER NOT NULL, `isReport` INTEGER NOT NULL DEFAULT 0, `isNeedRequestServer` INTEGER NOT NULL DEFAULT 0)");
        supportSQLiteDatabase.P("INSERT INTO RecordSummaryEntity SELECT * FROM temp_RecordSummaryEntity");
        supportSQLiteDatabase.P("DROP TABLE temp_RecordSummaryEntity");
    }
}
