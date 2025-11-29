package com.upuphone.ar.fastrecord.phone.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class FastRecordDao_Impl implements FastRecordDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordEntity> __deletionAdapterOfRecordEntity;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<RecordEntity> __insertionAdapterOfRecordEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteAllData;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteByFilePath;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteByRecordId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAllEmptyRecordToNoFinish;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdatePhoneRecordAfterMergeFile;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordArsRequestInfo;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordContent;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordEmptyRecordState;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordEntityDownloadState;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordFinishAsrAndEmptyState;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordFinishAsrState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecordFinishFileMergeState;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordIngState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecordIsEmptyAsrById;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecordIsFinishAsrByIdNormal;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordIsNewRecordItemState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecordLangType;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecordOriginTextByIdNormal;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecordOriginTextSizeByIdNormal;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordState;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordStatusAndTime;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordTime;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateRecordTitleItemState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecordTotalTime;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateSceneRecordAfterMergeFile;
    /* access modifiers changed from: private */
    public final EntityDeletionOrUpdateAdapter<RecordEntity> __updateAdapterOfRecordEntity;

    public FastRecordDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecordEntity = new EntityInsertionAdapter<RecordEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecordEntity` (`recordId`,`filePath`,`fileName`,`md5`,`shortHandText`,`shortHandTitle`,`location`,`locationShort`,`totalTime`,`summaryInfo`,`fileSize`,`lastModified`,`createTime`,`latitude`,`longitude`,`type`,`playStatus`,`recordStatus`,`isChoose`,`hasRenameRecord`,`cacheFileDir`,`isFinishFileMerge`,`cacheLastMergeAllScenePcmChannelPath`,`cacheLastUpMergePcmChannelPath`,`cacheLastDownMergePcmChannelPath`,`cacheLastUpMergeWavChannelPath`,`cacheLastDownMergeWavChannelPath`,`cacheLastWavChannelPath`,`isTwoChannelType`,`isFinishAsr`,`isEmptyRecord`,`isNewRecordItem`,`requestId`,`accountId`,`recognizeId`,`isDownloading`,`isVoiceHasNewMerge`,`originTextSize`,`languageType`,`wordShareCount`,`videoShareCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordEntity recordEntity) {
                supportSQLiteStatement.F(1, recordEntity.getRecordId());
                if (recordEntity.getFilePath() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordEntity.getFilePath());
                }
                if (recordEntity.getFileName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordEntity.getFileName());
                }
                if (recordEntity.getMd5() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordEntity.getMd5());
                }
                if (recordEntity.getShortHandText() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, recordEntity.getShortHandText());
                }
                if (recordEntity.getShortHandTitle() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, recordEntity.getShortHandTitle());
                }
                if (recordEntity.getLocation() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, recordEntity.getLocation());
                }
                if (recordEntity.getLocationShort() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, recordEntity.getLocationShort());
                }
                supportSQLiteStatement.F(9, recordEntity.getTotalTime());
                if (recordEntity.getSummaryInfo() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, recordEntity.getSummaryInfo());
                }
                supportSQLiteStatement.F(11, recordEntity.getFileSize());
                supportSQLiteStatement.F(12, recordEntity.getLastModified());
                supportSQLiteStatement.F(13, recordEntity.getCreateTime());
                supportSQLiteStatement.F(14, recordEntity.getLatitude());
                supportSQLiteStatement.F(15, recordEntity.getLongitude());
                supportSQLiteStatement.F(16, (long) recordEntity.getType());
                supportSQLiteStatement.F(17, (long) recordEntity.getPlayStatus());
                supportSQLiteStatement.F(18, (long) recordEntity.getRecordStatus());
                supportSQLiteStatement.F(19, recordEntity.isChoose() ? 1 : 0);
                supportSQLiteStatement.F(20, recordEntity.getHasRenameRecord() ? 1 : 0);
                if (recordEntity.getCacheFileDir() == null) {
                    supportSQLiteStatement.L(21);
                } else {
                    supportSQLiteStatement.B(21, recordEntity.getCacheFileDir());
                }
                supportSQLiteStatement.F(22, recordEntity.isFinishFileMerge() ? 1 : 0);
                if (recordEntity.getCacheLastMergeAllScenePcmChannelPath() == null) {
                    supportSQLiteStatement.L(23);
                } else {
                    supportSQLiteStatement.B(23, recordEntity.getCacheLastMergeAllScenePcmChannelPath());
                }
                if (recordEntity.getCacheLastUpMergePcmChannelPath() == null) {
                    supportSQLiteStatement.L(24);
                } else {
                    supportSQLiteStatement.B(24, recordEntity.getCacheLastUpMergePcmChannelPath());
                }
                if (recordEntity.getCacheLastDownMergePcmChannelPath() == null) {
                    supportSQLiteStatement.L(25);
                } else {
                    supportSQLiteStatement.B(25, recordEntity.getCacheLastDownMergePcmChannelPath());
                }
                if (recordEntity.getCacheLastUpMergeWavChannelPath() == null) {
                    supportSQLiteStatement.L(26);
                } else {
                    supportSQLiteStatement.B(26, recordEntity.getCacheLastUpMergeWavChannelPath());
                }
                if (recordEntity.getCacheLastDownMergeWavChannelPath() == null) {
                    supportSQLiteStatement.L(27);
                } else {
                    supportSQLiteStatement.B(27, recordEntity.getCacheLastDownMergeWavChannelPath());
                }
                if (recordEntity.getCacheLastWavChannelPath() == null) {
                    supportSQLiteStatement.L(28);
                } else {
                    supportSQLiteStatement.B(28, recordEntity.getCacheLastWavChannelPath());
                }
                supportSQLiteStatement.F(29, recordEntity.isTwoChannelType() ? 1 : 0);
                supportSQLiteStatement.F(30, recordEntity.isFinishAsr() ? 1 : 0);
                supportSQLiteStatement.F(31, recordEntity.isEmptyRecord() ? 1 : 0);
                supportSQLiteStatement.F(32, recordEntity.isNewRecordItem() ? 1 : 0);
                supportSQLiteStatement.B(33, recordEntity.getRequestId());
                supportSQLiteStatement.B(34, recordEntity.getAccountId());
                supportSQLiteStatement.B(35, recordEntity.getRecognizeId());
                supportSQLiteStatement.F(36, recordEntity.isDownloading() ? 1 : 0);
                supportSQLiteStatement.F(37, recordEntity.isVoiceHasNewMerge() ? 1 : 0);
                supportSQLiteStatement.F(38, recordEntity.getOriginTextSize());
                supportSQLiteStatement.B(39, recordEntity.getLanguageType());
                supportSQLiteStatement.F(40, recordEntity.getWordShareCount());
                supportSQLiteStatement.F(41, recordEntity.getVideoShareCount());
            }
        };
        this.__deletionAdapterOfRecordEntity = new EntityDeletionOrUpdateAdapter<RecordEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM `RecordEntity` WHERE `recordId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordEntity recordEntity) {
                supportSQLiteStatement.F(1, recordEntity.getRecordId());
            }
        };
        this.__updateAdapterOfRecordEntity = new EntityDeletionOrUpdateAdapter<RecordEntity>(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE OR ABORT `RecordEntity` SET `recordId` = ?,`filePath` = ?,`fileName` = ?,`md5` = ?,`shortHandText` = ?,`shortHandTitle` = ?,`location` = ?,`locationShort` = ?,`totalTime` = ?,`summaryInfo` = ?,`fileSize` = ?,`lastModified` = ?,`createTime` = ?,`latitude` = ?,`longitude` = ?,`type` = ?,`playStatus` = ?,`recordStatus` = ?,`isChoose` = ?,`hasRenameRecord` = ?,`cacheFileDir` = ?,`isFinishFileMerge` = ?,`cacheLastMergeAllScenePcmChannelPath` = ?,`cacheLastUpMergePcmChannelPath` = ?,`cacheLastDownMergePcmChannelPath` = ?,`cacheLastUpMergeWavChannelPath` = ?,`cacheLastDownMergeWavChannelPath` = ?,`cacheLastWavChannelPath` = ?,`isTwoChannelType` = ?,`isFinishAsr` = ?,`isEmptyRecord` = ?,`isNewRecordItem` = ?,`requestId` = ?,`accountId` = ?,`recognizeId` = ?,`isDownloading` = ?,`isVoiceHasNewMerge` = ?,`originTextSize` = ?,`languageType` = ?,`wordShareCount` = ?,`videoShareCount` = ? WHERE `recordId` = ?";
            }

            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RecordEntity recordEntity) {
                supportSQLiteStatement.F(1, recordEntity.getRecordId());
                if (recordEntity.getFilePath() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, recordEntity.getFilePath());
                }
                if (recordEntity.getFileName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, recordEntity.getFileName());
                }
                if (recordEntity.getMd5() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, recordEntity.getMd5());
                }
                if (recordEntity.getShortHandText() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, recordEntity.getShortHandText());
                }
                if (recordEntity.getShortHandTitle() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, recordEntity.getShortHandTitle());
                }
                if (recordEntity.getLocation() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, recordEntity.getLocation());
                }
                if (recordEntity.getLocationShort() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, recordEntity.getLocationShort());
                }
                supportSQLiteStatement.F(9, recordEntity.getTotalTime());
                if (recordEntity.getSummaryInfo() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, recordEntity.getSummaryInfo());
                }
                supportSQLiteStatement.F(11, recordEntity.getFileSize());
                supportSQLiteStatement.F(12, recordEntity.getLastModified());
                supportSQLiteStatement.F(13, recordEntity.getCreateTime());
                supportSQLiteStatement.F(14, recordEntity.getLatitude());
                supportSQLiteStatement.F(15, recordEntity.getLongitude());
                supportSQLiteStatement.F(16, (long) recordEntity.getType());
                supportSQLiteStatement.F(17, (long) recordEntity.getPlayStatus());
                supportSQLiteStatement.F(18, (long) recordEntity.getRecordStatus());
                supportSQLiteStatement.F(19, recordEntity.isChoose() ? 1 : 0);
                supportSQLiteStatement.F(20, recordEntity.getHasRenameRecord() ? 1 : 0);
                if (recordEntity.getCacheFileDir() == null) {
                    supportSQLiteStatement.L(21);
                } else {
                    supportSQLiteStatement.B(21, recordEntity.getCacheFileDir());
                }
                supportSQLiteStatement.F(22, recordEntity.isFinishFileMerge() ? 1 : 0);
                if (recordEntity.getCacheLastMergeAllScenePcmChannelPath() == null) {
                    supportSQLiteStatement.L(23);
                } else {
                    supportSQLiteStatement.B(23, recordEntity.getCacheLastMergeAllScenePcmChannelPath());
                }
                if (recordEntity.getCacheLastUpMergePcmChannelPath() == null) {
                    supportSQLiteStatement.L(24);
                } else {
                    supportSQLiteStatement.B(24, recordEntity.getCacheLastUpMergePcmChannelPath());
                }
                if (recordEntity.getCacheLastDownMergePcmChannelPath() == null) {
                    supportSQLiteStatement.L(25);
                } else {
                    supportSQLiteStatement.B(25, recordEntity.getCacheLastDownMergePcmChannelPath());
                }
                if (recordEntity.getCacheLastUpMergeWavChannelPath() == null) {
                    supportSQLiteStatement.L(26);
                } else {
                    supportSQLiteStatement.B(26, recordEntity.getCacheLastUpMergeWavChannelPath());
                }
                if (recordEntity.getCacheLastDownMergeWavChannelPath() == null) {
                    supportSQLiteStatement.L(27);
                } else {
                    supportSQLiteStatement.B(27, recordEntity.getCacheLastDownMergeWavChannelPath());
                }
                if (recordEntity.getCacheLastWavChannelPath() == null) {
                    supportSQLiteStatement.L(28);
                } else {
                    supportSQLiteStatement.B(28, recordEntity.getCacheLastWavChannelPath());
                }
                supportSQLiteStatement.F(29, recordEntity.isTwoChannelType() ? 1 : 0);
                supportSQLiteStatement.F(30, recordEntity.isFinishAsr() ? 1 : 0);
                supportSQLiteStatement.F(31, recordEntity.isEmptyRecord() ? 1 : 0);
                supportSQLiteStatement.F(32, recordEntity.isNewRecordItem() ? 1 : 0);
                supportSQLiteStatement.B(33, recordEntity.getRequestId());
                supportSQLiteStatement.B(34, recordEntity.getAccountId());
                supportSQLiteStatement.B(35, recordEntity.getRecognizeId());
                supportSQLiteStatement.F(36, recordEntity.isDownloading() ? 1 : 0);
                supportSQLiteStatement.F(37, recordEntity.isVoiceHasNewMerge() ? 1 : 0);
                supportSQLiteStatement.F(38, recordEntity.getOriginTextSize());
                supportSQLiteStatement.B(39, recordEntity.getLanguageType());
                supportSQLiteStatement.F(40, recordEntity.getWordShareCount());
                supportSQLiteStatement.F(41, recordEntity.getVideoShareCount());
                supportSQLiteStatement.F(42, recordEntity.getRecordId());
            }
        };
        this.__preparedStmtOfUpdateRecordLangType = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET languageType = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordIsFinishAsrByIdNormal = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isFinishAsr = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordIsEmptyAsrById = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isEmptyRecord = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateAllEmptyRecordToNoFinish = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isFinishAsr = ? where isEmptyRecord= ?";
            }
        };
        this.__preparedStmtOfUpdateRecordOriginTextByIdNormal = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET shortHandText = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordOriginTextSizeByIdNormal = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET originTextSize = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordTotalTime = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET totalTime = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordFinishFileMergeState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isFinishFileMerge = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordIngState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET recordStatus = ? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordArsRequestInfo = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET requestId = ?,recognizeId = ?  where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordFinishAsrAndEmptyState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isFinishAsr = ?,isEmptyRecord = ?  where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordFinishAsrState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isFinishAsr = ?  where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordEmptyRecordState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isEmptyRecord = ?  where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordStatusAndTime = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET recordStatus = ? ,totalTime=? where recordId=?";
            }
        };
        this.__preparedStmtOfUpdatePhoneRecordAfterMergeFile = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET cacheFileDir = ? ,cacheLastUpMergePcmChannelPath=?,cacheLastUpMergeWavChannelPath=?,cacheLastDownMergePcmChannelPath=?,cacheLastDownMergeWavChannelPath=?,totalTime =?,cacheLastWavChannelPath=?,isFinishFileMerge=?,isTwoChannelType=?,isFinishAsr=?   where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateSceneRecordAfterMergeFile = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET cacheFileDir = ? ,cacheLastMergeAllScenePcmChannelPath=?, totalTime =?,cacheLastWavChannelPath=?,isFinishFileMerge=?,isTwoChannelType=?,isFinishAsr=?   where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET totalTime = ? ,recordStatus=?, lastModified =?,isDownloading=?,isFinishFileMerge=?   where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordTime = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET totalTime = ?   where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordTitleItemState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET shortHandTitle = ?   where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordIsNewRecordItemState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isNewRecordItem = ?   where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordEntityDownloadState = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET isDownloading = ?   where recordId=?";
            }
        };
        this.__preparedStmtOfUpdateRecordContent = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "UPDATE  RecordEntity SET shortHandText = ?   where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteByFilePath = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordEntity where filePath=?";
            }
        };
        this.__preparedStmtOfDeleteByRecordId = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE FROM RecordEntity where recordId=?";
            }
        };
        this.__preparedStmtOfDeleteAllData = new SharedSQLiteStatement(roomDatabase) {
            @NonNull
            public String createQuery() {
                return "DELETE  FROM RecordEntity";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object delete(final RecordEntity recordEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordDao_Impl.this.__deletionAdapterOfRecordEntity.handle(recordEntity);
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object deleteAllData(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfDeleteAllData.acquire();
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfDeleteAllData.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteByFilePath(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfDeleteByFilePath.acquire();
                acquire.B(1, str);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfDeleteByFilePath.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfDeleteByFilePath.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteByRecordId(final long j, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfDeleteByRecordId.acquire();
                acquire.F(1, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfDeleteByRecordId.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object deleteList(final List<RecordEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordDao_Impl.this.__deletionAdapterOfRecordEntity.handleMultiple(list);
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object findAllDownloadingRecordEntity(String str, Continuation<? super List<RecordEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where isDownloading= 1 AND accountId = ?", 1);
        c.B(1, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordEntity>>() {
            @Nullable
            public List<RecordEntity> call() throws Exception {
                AnonymousClass53 r3;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                boolean z;
                boolean z2;
                int i;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        int i2 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            RecordEntity recordEntity = new RecordEntity();
                            int i3 = d11;
                            int i4 = d12;
                            recordEntity.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity.setLocationShort(str7);
                            recordEntity.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity.setSummaryInfo(str8);
                            int i5 = d2;
                            d11 = i3;
                            int i6 = d3;
                            recordEntity.setFileSize(c.getLong(d11));
                            int i7 = i4;
                            int i8 = d4;
                            recordEntity.setLastModified(c.getLong(i7));
                            recordEntity.setCreateTime(c.getLong(d13));
                            int i9 = i2;
                            int i10 = d5;
                            recordEntity.setLatitude(c.getLong(i9));
                            int i11 = i7;
                            int i12 = d15;
                            int i13 = i9;
                            recordEntity.setLongitude(c.getLong(i12));
                            int i14 = d16;
                            recordEntity.setType(c.getInt(i14));
                            int i15 = d;
                            int i16 = d17;
                            recordEntity.setPlayStatus(c.getInt(i16));
                            int i17 = d13;
                            int i18 = d18;
                            recordEntity.setRecordStatus(c.getInt(i18));
                            int i19 = d19;
                            if (c.getInt(i19) != 0) {
                                d18 = i18;
                                z = true;
                            } else {
                                d18 = i18;
                                z = false;
                            }
                            recordEntity.setChoose(z);
                            int i20 = d20;
                            if (c.getInt(i20) != 0) {
                                d20 = i20;
                                z2 = true;
                            } else {
                                d20 = i20;
                                z2 = false;
                            }
                            recordEntity.setHasRenameRecord(z2);
                            int i21 = d21;
                            if (c.isNull(i21)) {
                                i = i21;
                                str9 = null;
                            } else {
                                i = i21;
                                str9 = c.getString(i21);
                            }
                            recordEntity.setCacheFileDir(str9);
                            int i22 = d22;
                            d22 = i22;
                            recordEntity.setFinishFileMerge(c.getInt(i22) != 0);
                            int i23 = d23;
                            if (c.isNull(i23)) {
                                d23 = i23;
                                str10 = null;
                            } else {
                                d23 = i23;
                                str10 = c.getString(i23);
                            }
                            recordEntity.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i24 = d24;
                            if (c.isNull(i24)) {
                                d24 = i24;
                                str11 = null;
                            } else {
                                d24 = i24;
                                str11 = c.getString(i24);
                            }
                            recordEntity.setCacheLastUpMergePcmChannelPath(str11);
                            int i25 = d25;
                            if (c.isNull(i25)) {
                                d25 = i25;
                                str12 = null;
                            } else {
                                d25 = i25;
                                str12 = c.getString(i25);
                            }
                            recordEntity.setCacheLastDownMergePcmChannelPath(str12);
                            int i26 = d26;
                            if (c.isNull(i26)) {
                                d26 = i26;
                                str13 = null;
                            } else {
                                d26 = i26;
                                str13 = c.getString(i26);
                            }
                            recordEntity.setCacheLastUpMergeWavChannelPath(str13);
                            int i27 = d27;
                            if (c.isNull(i27)) {
                                d27 = i27;
                                str14 = null;
                            } else {
                                d27 = i27;
                                str14 = c.getString(i27);
                            }
                            recordEntity.setCacheLastDownMergeWavChannelPath(str14);
                            int i28 = d28;
                            if (c.isNull(i28)) {
                                d28 = i28;
                                str15 = null;
                            } else {
                                d28 = i28;
                                str15 = c.getString(i28);
                            }
                            recordEntity.setCacheLastWavChannelPath(str15);
                            int i29 = d29;
                            d29 = i29;
                            recordEntity.setTwoChannelType(c.getInt(i29) != 0);
                            int i30 = d30;
                            d30 = i30;
                            recordEntity.setFinishAsr(c.getInt(i30) != 0);
                            int i31 = d31;
                            d31 = i31;
                            recordEntity.setEmptyRecord(c.getInt(i31) != 0);
                            int i32 = d32;
                            d32 = i32;
                            recordEntity.setNewRecordItem(c.getInt(i32) != 0);
                            int i33 = i19;
                            int i34 = d33;
                            recordEntity.setRequestId(c.getString(i34));
                            d33 = i34;
                            int i35 = d34;
                            recordEntity.setAccountId(c.getString(i35));
                            d34 = i35;
                            int i36 = d35;
                            recordEntity.setRecognizeId(c.getString(i36));
                            int i37 = d36;
                            if (c.getInt(i37) != 0) {
                                d35 = i36;
                                z3 = true;
                            } else {
                                d35 = i36;
                                z3 = false;
                            }
                            recordEntity.setDownloading(z3);
                            int i38 = d37;
                            d37 = i38;
                            recordEntity.setVoiceHasNewMerge(c.getInt(i38) != 0);
                            int i39 = i14;
                            int i40 = i16;
                            int i41 = d38;
                            recordEntity.setOriginTextSize(c.getLong(i41));
                            int i42 = d39;
                            recordEntity.setLanguageType(c.getString(i42));
                            int i43 = i12;
                            int i44 = i11;
                            int i45 = d40;
                            recordEntity.setWordShareCount(c.getLong(i45));
                            int i46 = i42;
                            d40 = i45;
                            int i47 = d41;
                            recordEntity.setVideoShareCount(c.getLong(i47));
                            arrayList.add(recordEntity);
                            d41 = i47;
                            d2 = i5;
                            d12 = i44;
                            d3 = i6;
                            d4 = i8;
                            d39 = i46;
                            d5 = i10;
                            i2 = i13;
                            d15 = i43;
                            d38 = i41;
                            d = i15;
                            d16 = i39;
                            d19 = i33;
                            d21 = i;
                            int i48 = i40;
                            d36 = i37;
                            d13 = i17;
                            d17 = i48;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object findAllNewItem(String str, Continuation<? super List<RecordEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where isNewRecordItem= 1 AND accountId = ?", 1);
        c.B(1, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordEntity>>() {
            @Nullable
            public List<RecordEntity> call() throws Exception {
                AnonymousClass52 r3;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                boolean z;
                boolean z2;
                int i;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        int i2 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            RecordEntity recordEntity = new RecordEntity();
                            int i3 = d11;
                            int i4 = d12;
                            recordEntity.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity.setLocationShort(str7);
                            recordEntity.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity.setSummaryInfo(str8);
                            int i5 = d2;
                            d11 = i3;
                            int i6 = d3;
                            recordEntity.setFileSize(c.getLong(d11));
                            int i7 = i4;
                            int i8 = d4;
                            recordEntity.setLastModified(c.getLong(i7));
                            recordEntity.setCreateTime(c.getLong(d13));
                            int i9 = i2;
                            int i10 = d5;
                            recordEntity.setLatitude(c.getLong(i9));
                            int i11 = i7;
                            int i12 = d15;
                            int i13 = i9;
                            recordEntity.setLongitude(c.getLong(i12));
                            int i14 = d16;
                            recordEntity.setType(c.getInt(i14));
                            int i15 = d;
                            int i16 = d17;
                            recordEntity.setPlayStatus(c.getInt(i16));
                            int i17 = d13;
                            int i18 = d18;
                            recordEntity.setRecordStatus(c.getInt(i18));
                            int i19 = d19;
                            if (c.getInt(i19) != 0) {
                                d18 = i18;
                                z = true;
                            } else {
                                d18 = i18;
                                z = false;
                            }
                            recordEntity.setChoose(z);
                            int i20 = d20;
                            if (c.getInt(i20) != 0) {
                                d20 = i20;
                                z2 = true;
                            } else {
                                d20 = i20;
                                z2 = false;
                            }
                            recordEntity.setHasRenameRecord(z2);
                            int i21 = d21;
                            if (c.isNull(i21)) {
                                i = i21;
                                str9 = null;
                            } else {
                                i = i21;
                                str9 = c.getString(i21);
                            }
                            recordEntity.setCacheFileDir(str9);
                            int i22 = d22;
                            d22 = i22;
                            recordEntity.setFinishFileMerge(c.getInt(i22) != 0);
                            int i23 = d23;
                            if (c.isNull(i23)) {
                                d23 = i23;
                                str10 = null;
                            } else {
                                d23 = i23;
                                str10 = c.getString(i23);
                            }
                            recordEntity.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i24 = d24;
                            if (c.isNull(i24)) {
                                d24 = i24;
                                str11 = null;
                            } else {
                                d24 = i24;
                                str11 = c.getString(i24);
                            }
                            recordEntity.setCacheLastUpMergePcmChannelPath(str11);
                            int i25 = d25;
                            if (c.isNull(i25)) {
                                d25 = i25;
                                str12 = null;
                            } else {
                                d25 = i25;
                                str12 = c.getString(i25);
                            }
                            recordEntity.setCacheLastDownMergePcmChannelPath(str12);
                            int i26 = d26;
                            if (c.isNull(i26)) {
                                d26 = i26;
                                str13 = null;
                            } else {
                                d26 = i26;
                                str13 = c.getString(i26);
                            }
                            recordEntity.setCacheLastUpMergeWavChannelPath(str13);
                            int i27 = d27;
                            if (c.isNull(i27)) {
                                d27 = i27;
                                str14 = null;
                            } else {
                                d27 = i27;
                                str14 = c.getString(i27);
                            }
                            recordEntity.setCacheLastDownMergeWavChannelPath(str14);
                            int i28 = d28;
                            if (c.isNull(i28)) {
                                d28 = i28;
                                str15 = null;
                            } else {
                                d28 = i28;
                                str15 = c.getString(i28);
                            }
                            recordEntity.setCacheLastWavChannelPath(str15);
                            int i29 = d29;
                            d29 = i29;
                            recordEntity.setTwoChannelType(c.getInt(i29) != 0);
                            int i30 = d30;
                            d30 = i30;
                            recordEntity.setFinishAsr(c.getInt(i30) != 0);
                            int i31 = d31;
                            d31 = i31;
                            recordEntity.setEmptyRecord(c.getInt(i31) != 0);
                            int i32 = d32;
                            d32 = i32;
                            recordEntity.setNewRecordItem(c.getInt(i32) != 0);
                            int i33 = i19;
                            int i34 = d33;
                            recordEntity.setRequestId(c.getString(i34));
                            d33 = i34;
                            int i35 = d34;
                            recordEntity.setAccountId(c.getString(i35));
                            d34 = i35;
                            int i36 = d35;
                            recordEntity.setRecognizeId(c.getString(i36));
                            int i37 = d36;
                            if (c.getInt(i37) != 0) {
                                d35 = i36;
                                z3 = true;
                            } else {
                                d35 = i36;
                                z3 = false;
                            }
                            recordEntity.setDownloading(z3);
                            int i38 = d37;
                            d37 = i38;
                            recordEntity.setVoiceHasNewMerge(c.getInt(i38) != 0);
                            int i39 = i14;
                            int i40 = i16;
                            int i41 = d38;
                            recordEntity.setOriginTextSize(c.getLong(i41));
                            int i42 = d39;
                            recordEntity.setLanguageType(c.getString(i42));
                            int i43 = i12;
                            int i44 = i11;
                            int i45 = d40;
                            recordEntity.setWordShareCount(c.getLong(i45));
                            int i46 = i42;
                            d40 = i45;
                            int i47 = d41;
                            recordEntity.setVideoShareCount(c.getLong(i47));
                            arrayList.add(recordEntity);
                            d41 = i47;
                            d2 = i5;
                            d12 = i44;
                            d3 = i6;
                            d4 = i8;
                            d39 = i46;
                            d5 = i10;
                            i2 = i13;
                            d15 = i43;
                            d38 = i41;
                            d = i15;
                            d16 = i39;
                            d19 = i33;
                            d21 = i;
                            int i48 = i40;
                            d36 = i37;
                            d13 = i17;
                            d17 = i48;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object findRecordEntityById(long j, String str, Continuation<? super RecordEntity> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where recordId=? AND accountId = ?", 2);
        c.F(1, j);
        c.B(2, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<RecordEntity>() {
            @Nullable
            public RecordEntity call() throws Exception {
                RecordEntity recordEntity;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                AnonymousClass51 r1 = this;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        if (c.moveToFirst()) {
                            int i = d41;
                            RecordEntity recordEntity2 = new RecordEntity();
                            int i2 = d13;
                            int i3 = d14;
                            recordEntity2.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity2.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity2.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity2.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity2.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity2.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity2.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity2.setLocationShort(str7);
                            recordEntity2.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity2.setSummaryInfo(str8);
                            recordEntity2.setFileSize(c.getLong(d11));
                            recordEntity2.setLastModified(c.getLong(d12));
                            recordEntity2.setCreateTime(c.getLong(i2));
                            recordEntity2.setLatitude(c.getLong(i3));
                            recordEntity2.setLongitude(c.getLong(d15));
                            recordEntity2.setType(c.getInt(d16));
                            recordEntity2.setPlayStatus(c.getInt(d17));
                            recordEntity2.setRecordStatus(c.getInt(d18));
                            boolean z = true;
                            recordEntity2.setChoose(c.getInt(d19) != 0);
                            recordEntity2.setHasRenameRecord(c.getInt(d20) != 0);
                            int i4 = d21;
                            if (c.isNull(i4)) {
                                str9 = null;
                            } else {
                                str9 = c.getString(i4);
                            }
                            recordEntity2.setCacheFileDir(str9);
                            recordEntity2.setFinishFileMerge(c.getInt(d22) != 0);
                            int i5 = d23;
                            if (c.isNull(i5)) {
                                str10 = null;
                            } else {
                                str10 = c.getString(i5);
                            }
                            recordEntity2.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i6 = d24;
                            if (c.isNull(i6)) {
                                str11 = null;
                            } else {
                                str11 = c.getString(i6);
                            }
                            recordEntity2.setCacheLastUpMergePcmChannelPath(str11);
                            int i7 = d25;
                            if (c.isNull(i7)) {
                                str12 = null;
                            } else {
                                str12 = c.getString(i7);
                            }
                            recordEntity2.setCacheLastDownMergePcmChannelPath(str12);
                            int i8 = d26;
                            if (c.isNull(i8)) {
                                str13 = null;
                            } else {
                                str13 = c.getString(i8);
                            }
                            recordEntity2.setCacheLastUpMergeWavChannelPath(str13);
                            int i9 = d27;
                            if (c.isNull(i9)) {
                                str14 = null;
                            } else {
                                str14 = c.getString(i9);
                            }
                            recordEntity2.setCacheLastDownMergeWavChannelPath(str14);
                            int i10 = d28;
                            if (c.isNull(i10)) {
                                str15 = null;
                            } else {
                                str15 = c.getString(i10);
                            }
                            recordEntity2.setCacheLastWavChannelPath(str15);
                            recordEntity2.setTwoChannelType(c.getInt(d29) != 0);
                            recordEntity2.setFinishAsr(c.getInt(d30) != 0);
                            recordEntity2.setEmptyRecord(c.getInt(d31) != 0);
                            recordEntity2.setNewRecordItem(c.getInt(d32) != 0);
                            recordEntity2.setRequestId(c.getString(d33));
                            recordEntity2.setAccountId(c.getString(d34));
                            recordEntity2.setRecognizeId(c.getString(d35));
                            recordEntity2.setDownloading(c.getInt(d36) != 0);
                            if (c.getInt(d37) == 0) {
                                z = false;
                            }
                            recordEntity2.setVoiceHasNewMerge(z);
                            recordEntity2.setOriginTextSize(c.getLong(d38));
                            recordEntity2.setLanguageType(c.getString(d39));
                            recordEntity2.setWordShareCount(c.getLong(d40));
                            recordEntity2.setVideoShareCount(c.getLong(i));
                            recordEntity = recordEntity2;
                        } else {
                            recordEntity = null;
                        }
                        c.close();
                        c.release();
                        return recordEntity;
                    } catch (Throwable th) {
                        th = th;
                        r1 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public RecordEntity findRecordEntityByIdNormal(long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        RecordEntity recordEntity;
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where recordId=?", 1);
        c.F(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "recordId");
            int d2 = CursorUtil.d(c2, "filePath");
            int d3 = CursorUtil.d(c2, "fileName");
            int d4 = CursorUtil.d(c2, "md5");
            int d5 = CursorUtil.d(c2, "shortHandText");
            int d6 = CursorUtil.d(c2, "shortHandTitle");
            int d7 = CursorUtil.d(c2, "location");
            int d8 = CursorUtil.d(c2, "locationShort");
            int d9 = CursorUtil.d(c2, "totalTime");
            int d10 = CursorUtil.d(c2, "summaryInfo");
            int d11 = CursorUtil.d(c2, "fileSize");
            int d12 = CursorUtil.d(c2, "lastModified");
            int d13 = CursorUtil.d(c2, "createTime");
            int d14 = CursorUtil.d(c2, "latitude");
            roomSQLiteQuery = c;
            try {
                int d15 = CursorUtil.d(c2, "longitude");
                int d16 = CursorUtil.d(c2, "type");
                int d17 = CursorUtil.d(c2, "playStatus");
                int d18 = CursorUtil.d(c2, "recordStatus");
                int d19 = CursorUtil.d(c2, "isChoose");
                int d20 = CursorUtil.d(c2, "hasRenameRecord");
                int d21 = CursorUtil.d(c2, "cacheFileDir");
                int d22 = CursorUtil.d(c2, "isFinishFileMerge");
                int d23 = CursorUtil.d(c2, "cacheLastMergeAllScenePcmChannelPath");
                int d24 = CursorUtil.d(c2, "cacheLastUpMergePcmChannelPath");
                int d25 = CursorUtil.d(c2, "cacheLastDownMergePcmChannelPath");
                int d26 = CursorUtil.d(c2, "cacheLastUpMergeWavChannelPath");
                int d27 = CursorUtil.d(c2, "cacheLastDownMergeWavChannelPath");
                int d28 = CursorUtil.d(c2, "cacheLastWavChannelPath");
                int d29 = CursorUtil.d(c2, "isTwoChannelType");
                int d30 = CursorUtil.d(c2, "isFinishAsr");
                int d31 = CursorUtil.d(c2, "isEmptyRecord");
                int d32 = CursorUtil.d(c2, "isNewRecordItem");
                int d33 = CursorUtil.d(c2, "requestId");
                int d34 = CursorUtil.d(c2, "accountId");
                int d35 = CursorUtil.d(c2, "recognizeId");
                int d36 = CursorUtil.d(c2, "isDownloading");
                int d37 = CursorUtil.d(c2, "isVoiceHasNewMerge");
                int d38 = CursorUtil.d(c2, "originTextSize");
                int d39 = CursorUtil.d(c2, "languageType");
                int d40 = CursorUtil.d(c2, "wordShareCount");
                int d41 = CursorUtil.d(c2, "videoShareCount");
                if (c2.moveToFirst()) {
                    int i = d41;
                    RecordEntity recordEntity2 = new RecordEntity();
                    int i2 = d13;
                    int i3 = d14;
                    recordEntity2.setRecordId(c2.getLong(d));
                    recordEntity2.setFilePath(c2.isNull(d2) ? null : c2.getString(d2));
                    recordEntity2.setFileName(c2.isNull(d3) ? null : c2.getString(d3));
                    recordEntity2.setMd5(c2.isNull(d4) ? null : c2.getString(d4));
                    recordEntity2.setShortHandText(c2.isNull(d5) ? null : c2.getString(d5));
                    recordEntity2.setShortHandTitle(c2.isNull(d6) ? null : c2.getString(d6));
                    recordEntity2.setLocation(c2.isNull(d7) ? null : c2.getString(d7));
                    recordEntity2.setLocationShort(c2.isNull(d8) ? null : c2.getString(d8));
                    recordEntity2.setTotalTime(c2.getLong(d9));
                    recordEntity2.setSummaryInfo(c2.isNull(d10) ? null : c2.getString(d10));
                    recordEntity2.setFileSize(c2.getLong(d11));
                    recordEntity2.setLastModified(c2.getLong(d12));
                    recordEntity2.setCreateTime(c2.getLong(i2));
                    recordEntity2.setLatitude(c2.getLong(i3));
                    recordEntity2.setLongitude(c2.getLong(d15));
                    recordEntity2.setType(c2.getInt(d16));
                    recordEntity2.setPlayStatus(c2.getInt(d17));
                    recordEntity2.setRecordStatus(c2.getInt(d18));
                    recordEntity2.setChoose(c2.getInt(d19) != 0);
                    recordEntity2.setHasRenameRecord(c2.getInt(d20) != 0);
                    int i4 = d21;
                    recordEntity2.setCacheFileDir(c2.isNull(i4) ? null : c2.getString(i4));
                    recordEntity2.setFinishFileMerge(c2.getInt(d22) != 0);
                    int i5 = d23;
                    recordEntity2.setCacheLastMergeAllScenePcmChannelPath(c2.isNull(i5) ? null : c2.getString(i5));
                    int i6 = d24;
                    recordEntity2.setCacheLastUpMergePcmChannelPath(c2.isNull(i6) ? null : c2.getString(i6));
                    int i7 = d25;
                    recordEntity2.setCacheLastDownMergePcmChannelPath(c2.isNull(i7) ? null : c2.getString(i7));
                    int i8 = d26;
                    recordEntity2.setCacheLastUpMergeWavChannelPath(c2.isNull(i8) ? null : c2.getString(i8));
                    int i9 = d27;
                    recordEntity2.setCacheLastDownMergeWavChannelPath(c2.isNull(i9) ? null : c2.getString(i9));
                    int i10 = d28;
                    recordEntity2.setCacheLastWavChannelPath(c2.isNull(i10) ? null : c2.getString(i10));
                    recordEntity2.setTwoChannelType(c2.getInt(d29) != 0);
                    recordEntity2.setFinishAsr(c2.getInt(d30) != 0);
                    recordEntity2.setEmptyRecord(c2.getInt(d31) != 0);
                    recordEntity2.setNewRecordItem(c2.getInt(d32) != 0);
                    recordEntity2.setRequestId(c2.getString(d33));
                    recordEntity2.setAccountId(c2.getString(d34));
                    recordEntity2.setRecognizeId(c2.getString(d35));
                    recordEntity2.setDownloading(c2.getInt(d36) != 0);
                    recordEntity2.setVoiceHasNewMerge(c2.getInt(d37) != 0);
                    recordEntity2.setOriginTextSize(c2.getLong(d38));
                    recordEntity2.setLanguageType(c2.getString(d39));
                    recordEntity2.setWordShareCount(c2.getLong(d40));
                    recordEntity2.setVideoShareCount(c2.getLong(i));
                    recordEntity = recordEntity2;
                } else {
                    recordEntity = null;
                }
                c2.close();
                roomSQLiteQuery.release();
                return recordEntity;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public Object findRecordEntityContent(String str, String str2, Continuation<? super RecordEntity> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where filePath=? AND accountId = ?", 2);
        c.B(1, str);
        c.B(2, str2);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<RecordEntity>() {
            @Nullable
            public RecordEntity call() throws Exception {
                RecordEntity recordEntity;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                AnonymousClass50 r1 = this;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        if (c.moveToFirst()) {
                            int i = d41;
                            RecordEntity recordEntity2 = new RecordEntity();
                            int i2 = d13;
                            int i3 = d14;
                            recordEntity2.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity2.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity2.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity2.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity2.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity2.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity2.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity2.setLocationShort(str7);
                            recordEntity2.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity2.setSummaryInfo(str8);
                            recordEntity2.setFileSize(c.getLong(d11));
                            recordEntity2.setLastModified(c.getLong(d12));
                            recordEntity2.setCreateTime(c.getLong(i2));
                            recordEntity2.setLatitude(c.getLong(i3));
                            recordEntity2.setLongitude(c.getLong(d15));
                            recordEntity2.setType(c.getInt(d16));
                            recordEntity2.setPlayStatus(c.getInt(d17));
                            recordEntity2.setRecordStatus(c.getInt(d18));
                            boolean z = true;
                            recordEntity2.setChoose(c.getInt(d19) != 0);
                            recordEntity2.setHasRenameRecord(c.getInt(d20) != 0);
                            int i4 = d21;
                            if (c.isNull(i4)) {
                                str9 = null;
                            } else {
                                str9 = c.getString(i4);
                            }
                            recordEntity2.setCacheFileDir(str9);
                            recordEntity2.setFinishFileMerge(c.getInt(d22) != 0);
                            int i5 = d23;
                            if (c.isNull(i5)) {
                                str10 = null;
                            } else {
                                str10 = c.getString(i5);
                            }
                            recordEntity2.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i6 = d24;
                            if (c.isNull(i6)) {
                                str11 = null;
                            } else {
                                str11 = c.getString(i6);
                            }
                            recordEntity2.setCacheLastUpMergePcmChannelPath(str11);
                            int i7 = d25;
                            if (c.isNull(i7)) {
                                str12 = null;
                            } else {
                                str12 = c.getString(i7);
                            }
                            recordEntity2.setCacheLastDownMergePcmChannelPath(str12);
                            int i8 = d26;
                            if (c.isNull(i8)) {
                                str13 = null;
                            } else {
                                str13 = c.getString(i8);
                            }
                            recordEntity2.setCacheLastUpMergeWavChannelPath(str13);
                            int i9 = d27;
                            if (c.isNull(i9)) {
                                str14 = null;
                            } else {
                                str14 = c.getString(i9);
                            }
                            recordEntity2.setCacheLastDownMergeWavChannelPath(str14);
                            int i10 = d28;
                            if (c.isNull(i10)) {
                                str15 = null;
                            } else {
                                str15 = c.getString(i10);
                            }
                            recordEntity2.setCacheLastWavChannelPath(str15);
                            recordEntity2.setTwoChannelType(c.getInt(d29) != 0);
                            recordEntity2.setFinishAsr(c.getInt(d30) != 0);
                            recordEntity2.setEmptyRecord(c.getInt(d31) != 0);
                            recordEntity2.setNewRecordItem(c.getInt(d32) != 0);
                            recordEntity2.setRequestId(c.getString(d33));
                            recordEntity2.setAccountId(c.getString(d34));
                            recordEntity2.setRecognizeId(c.getString(d35));
                            recordEntity2.setDownloading(c.getInt(d36) != 0);
                            if (c.getInt(d37) == 0) {
                                z = false;
                            }
                            recordEntity2.setVoiceHasNewMerge(z);
                            recordEntity2.setOriginTextSize(c.getLong(d38));
                            recordEntity2.setLanguageType(c.getString(d39));
                            recordEntity2.setWordShareCount(c.getLong(d40));
                            recordEntity2.setVideoShareCount(c.getLong(i));
                            recordEntity = recordEntity2;
                        } else {
                            recordEntity = null;
                        }
                        c.close();
                        c.release();
                        return recordEntity;
                    } catch (Throwable th) {
                        th = th;
                        r1 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public List<RecordEntity> getAllRecordEntity(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z2;
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where accountId = ?", 1);
        c.B(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.__db, c, false, (CancellationSignal) null);
        try {
            int d = CursorUtil.d(c2, "recordId");
            int d2 = CursorUtil.d(c2, "filePath");
            int d3 = CursorUtil.d(c2, "fileName");
            int d4 = CursorUtil.d(c2, "md5");
            int d5 = CursorUtil.d(c2, "shortHandText");
            int d6 = CursorUtil.d(c2, "shortHandTitle");
            int d7 = CursorUtil.d(c2, "location");
            int d8 = CursorUtil.d(c2, "locationShort");
            int d9 = CursorUtil.d(c2, "totalTime");
            int d10 = CursorUtil.d(c2, "summaryInfo");
            int d11 = CursorUtil.d(c2, "fileSize");
            int d12 = CursorUtil.d(c2, "lastModified");
            int d13 = CursorUtil.d(c2, "createTime");
            int d14 = CursorUtil.d(c2, "latitude");
            roomSQLiteQuery = c;
            try {
                int d15 = CursorUtil.d(c2, "longitude");
                int d16 = CursorUtil.d(c2, "type");
                int d17 = CursorUtil.d(c2, "playStatus");
                int d18 = CursorUtil.d(c2, "recordStatus");
                int d19 = CursorUtil.d(c2, "isChoose");
                int d20 = CursorUtil.d(c2, "hasRenameRecord");
                int d21 = CursorUtil.d(c2, "cacheFileDir");
                int d22 = CursorUtil.d(c2, "isFinishFileMerge");
                int d23 = CursorUtil.d(c2, "cacheLastMergeAllScenePcmChannelPath");
                int d24 = CursorUtil.d(c2, "cacheLastUpMergePcmChannelPath");
                int d25 = CursorUtil.d(c2, "cacheLastDownMergePcmChannelPath");
                int d26 = CursorUtil.d(c2, "cacheLastUpMergeWavChannelPath");
                int d27 = CursorUtil.d(c2, "cacheLastDownMergeWavChannelPath");
                int d28 = CursorUtil.d(c2, "cacheLastWavChannelPath");
                int d29 = CursorUtil.d(c2, "isTwoChannelType");
                int d30 = CursorUtil.d(c2, "isFinishAsr");
                int d31 = CursorUtil.d(c2, "isEmptyRecord");
                int d32 = CursorUtil.d(c2, "isNewRecordItem");
                int d33 = CursorUtil.d(c2, "requestId");
                int d34 = CursorUtil.d(c2, "accountId");
                int d35 = CursorUtil.d(c2, "recognizeId");
                int d36 = CursorUtil.d(c2, "isDownloading");
                int d37 = CursorUtil.d(c2, "isVoiceHasNewMerge");
                int d38 = CursorUtil.d(c2, "originTextSize");
                int d39 = CursorUtil.d(c2, "languageType");
                int d40 = CursorUtil.d(c2, "wordShareCount");
                int d41 = CursorUtil.d(c2, "videoShareCount");
                int i = d14;
                ArrayList arrayList = new ArrayList(c2.getCount());
                while (c2.moveToNext()) {
                    RecordEntity recordEntity = new RecordEntity();
                    ArrayList arrayList2 = arrayList;
                    int i2 = d12;
                    recordEntity.setRecordId(c2.getLong(d));
                    recordEntity.setFilePath(c2.isNull(d2) ? null : c2.getString(d2));
                    recordEntity.setFileName(c2.isNull(d3) ? null : c2.getString(d3));
                    recordEntity.setMd5(c2.isNull(d4) ? null : c2.getString(d4));
                    recordEntity.setShortHandText(c2.isNull(d5) ? null : c2.getString(d5));
                    recordEntity.setShortHandTitle(c2.isNull(d6) ? null : c2.getString(d6));
                    recordEntity.setLocation(c2.isNull(d7) ? null : c2.getString(d7));
                    recordEntity.setLocationShort(c2.isNull(d8) ? null : c2.getString(d8));
                    recordEntity.setTotalTime(c2.getLong(d9));
                    recordEntity.setSummaryInfo(c2.isNull(d10) ? null : c2.getString(d10));
                    recordEntity.setFileSize(c2.getLong(d11));
                    int i3 = d2;
                    int i4 = i2;
                    int i5 = d3;
                    recordEntity.setLastModified(c2.getLong(i4));
                    recordEntity.setCreateTime(c2.getLong(d13));
                    int i6 = d;
                    int i7 = i;
                    int i8 = i4;
                    recordEntity.setLatitude(c2.getLong(i7));
                    int i9 = d15;
                    int i10 = i3;
                    recordEntity.setLongitude(c2.getLong(i9));
                    int i11 = d16;
                    recordEntity.setType(c2.getInt(i11));
                    int i12 = i9;
                    int i13 = d17;
                    recordEntity.setPlayStatus(c2.getInt(i13));
                    int i14 = i11;
                    int i15 = d18;
                    recordEntity.setRecordStatus(c2.getInt(i15));
                    int i16 = d19;
                    if (c2.getInt(i16) != 0) {
                        d18 = i15;
                        z = true;
                    } else {
                        d18 = i15;
                        z = false;
                    }
                    recordEntity.setChoose(z);
                    int i17 = d20;
                    d20 = i17;
                    recordEntity.setHasRenameRecord(c2.getInt(i17) != 0);
                    int i18 = d21;
                    if (c2.isNull(i18)) {
                        d21 = i18;
                        str2 = null;
                    } else {
                        d21 = i18;
                        str2 = c2.getString(i18);
                    }
                    recordEntity.setCacheFileDir(str2);
                    int i19 = d22;
                    d22 = i19;
                    recordEntity.setFinishFileMerge(c2.getInt(i19) != 0);
                    int i20 = d23;
                    if (c2.isNull(i20)) {
                        d23 = i20;
                        str3 = null;
                    } else {
                        d23 = i20;
                        str3 = c2.getString(i20);
                    }
                    recordEntity.setCacheLastMergeAllScenePcmChannelPath(str3);
                    int i21 = d24;
                    if (c2.isNull(i21)) {
                        d24 = i21;
                        str4 = null;
                    } else {
                        d24 = i21;
                        str4 = c2.getString(i21);
                    }
                    recordEntity.setCacheLastUpMergePcmChannelPath(str4);
                    int i22 = d25;
                    if (c2.isNull(i22)) {
                        d25 = i22;
                        str5 = null;
                    } else {
                        d25 = i22;
                        str5 = c2.getString(i22);
                    }
                    recordEntity.setCacheLastDownMergePcmChannelPath(str5);
                    int i23 = d26;
                    if (c2.isNull(i23)) {
                        d26 = i23;
                        str6 = null;
                    } else {
                        d26 = i23;
                        str6 = c2.getString(i23);
                    }
                    recordEntity.setCacheLastUpMergeWavChannelPath(str6);
                    int i24 = d27;
                    if (c2.isNull(i24)) {
                        d27 = i24;
                        str7 = null;
                    } else {
                        d27 = i24;
                        str7 = c2.getString(i24);
                    }
                    recordEntity.setCacheLastDownMergeWavChannelPath(str7);
                    int i25 = d28;
                    if (c2.isNull(i25)) {
                        d28 = i25;
                        str8 = null;
                    } else {
                        d28 = i25;
                        str8 = c2.getString(i25);
                    }
                    recordEntity.setCacheLastWavChannelPath(str8);
                    int i26 = d29;
                    d29 = i26;
                    recordEntity.setTwoChannelType(c2.getInt(i26) != 0);
                    int i27 = d30;
                    d30 = i27;
                    recordEntity.setFinishAsr(c2.getInt(i27) != 0);
                    int i28 = d31;
                    d31 = i28;
                    recordEntity.setEmptyRecord(c2.getInt(i28) != 0);
                    int i29 = d32;
                    d32 = i29;
                    recordEntity.setNewRecordItem(c2.getInt(i29) != 0);
                    d19 = i16;
                    int i30 = d33;
                    recordEntity.setRequestId(c2.getString(i30));
                    d33 = i30;
                    int i31 = d34;
                    recordEntity.setAccountId(c2.getString(i31));
                    d34 = i31;
                    int i32 = d35;
                    recordEntity.setRecognizeId(c2.getString(i32));
                    int i33 = d36;
                    if (c2.getInt(i33) != 0) {
                        d35 = i32;
                        z2 = true;
                    } else {
                        d35 = i32;
                        z2 = false;
                    }
                    recordEntity.setDownloading(z2);
                    int i34 = d37;
                    d37 = i34;
                    recordEntity.setVoiceHasNewMerge(c2.getInt(i34) != 0);
                    int i35 = i13;
                    int i36 = d38;
                    int i37 = i33;
                    recordEntity.setOriginTextSize(c2.getLong(i36));
                    int i38 = d39;
                    recordEntity.setLanguageType(c2.getString(i38));
                    int i39 = i36;
                    int i40 = d40;
                    int i41 = i38;
                    recordEntity.setWordShareCount(c2.getLong(i40));
                    int i42 = d41;
                    int i43 = i40;
                    recordEntity.setVideoShareCount(c2.getLong(i42));
                    arrayList = arrayList2;
                    arrayList.add(recordEntity);
                    d12 = i8;
                    i = i7;
                    d2 = i10;
                    d15 = i12;
                    d16 = i14;
                    d17 = i35;
                    d36 = i37;
                    d38 = i39;
                    d39 = i41;
                    d40 = i43;
                    d41 = i42;
                    d = i6;
                    d3 = i5;
                }
                c2.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public Object getRecordEntityByCreateTime(String str, Continuation<? super List<RecordEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where accountId = ?  ORDER BY createTime DESC", 1);
        c.B(1, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordEntity>>() {
            @Nullable
            public List<RecordEntity> call() throws Exception {
                AnonymousClass56 r3;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                boolean z;
                boolean z2;
                int i;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        int i2 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            RecordEntity recordEntity = new RecordEntity();
                            int i3 = d11;
                            int i4 = d12;
                            recordEntity.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity.setLocationShort(str7);
                            recordEntity.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity.setSummaryInfo(str8);
                            int i5 = d2;
                            d11 = i3;
                            int i6 = d3;
                            recordEntity.setFileSize(c.getLong(d11));
                            int i7 = i4;
                            int i8 = d4;
                            recordEntity.setLastModified(c.getLong(i7));
                            recordEntity.setCreateTime(c.getLong(d13));
                            int i9 = i2;
                            int i10 = d5;
                            recordEntity.setLatitude(c.getLong(i9));
                            int i11 = i7;
                            int i12 = d15;
                            int i13 = i9;
                            recordEntity.setLongitude(c.getLong(i12));
                            int i14 = d16;
                            recordEntity.setType(c.getInt(i14));
                            int i15 = d;
                            int i16 = d17;
                            recordEntity.setPlayStatus(c.getInt(i16));
                            int i17 = d13;
                            int i18 = d18;
                            recordEntity.setRecordStatus(c.getInt(i18));
                            int i19 = d19;
                            if (c.getInt(i19) != 0) {
                                d18 = i18;
                                z = true;
                            } else {
                                d18 = i18;
                                z = false;
                            }
                            recordEntity.setChoose(z);
                            int i20 = d20;
                            if (c.getInt(i20) != 0) {
                                d20 = i20;
                                z2 = true;
                            } else {
                                d20 = i20;
                                z2 = false;
                            }
                            recordEntity.setHasRenameRecord(z2);
                            int i21 = d21;
                            if (c.isNull(i21)) {
                                i = i21;
                                str9 = null;
                            } else {
                                i = i21;
                                str9 = c.getString(i21);
                            }
                            recordEntity.setCacheFileDir(str9);
                            int i22 = d22;
                            d22 = i22;
                            recordEntity.setFinishFileMerge(c.getInt(i22) != 0);
                            int i23 = d23;
                            if (c.isNull(i23)) {
                                d23 = i23;
                                str10 = null;
                            } else {
                                d23 = i23;
                                str10 = c.getString(i23);
                            }
                            recordEntity.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i24 = d24;
                            if (c.isNull(i24)) {
                                d24 = i24;
                                str11 = null;
                            } else {
                                d24 = i24;
                                str11 = c.getString(i24);
                            }
                            recordEntity.setCacheLastUpMergePcmChannelPath(str11);
                            int i25 = d25;
                            if (c.isNull(i25)) {
                                d25 = i25;
                                str12 = null;
                            } else {
                                d25 = i25;
                                str12 = c.getString(i25);
                            }
                            recordEntity.setCacheLastDownMergePcmChannelPath(str12);
                            int i26 = d26;
                            if (c.isNull(i26)) {
                                d26 = i26;
                                str13 = null;
                            } else {
                                d26 = i26;
                                str13 = c.getString(i26);
                            }
                            recordEntity.setCacheLastUpMergeWavChannelPath(str13);
                            int i27 = d27;
                            if (c.isNull(i27)) {
                                d27 = i27;
                                str14 = null;
                            } else {
                                d27 = i27;
                                str14 = c.getString(i27);
                            }
                            recordEntity.setCacheLastDownMergeWavChannelPath(str14);
                            int i28 = d28;
                            if (c.isNull(i28)) {
                                d28 = i28;
                                str15 = null;
                            } else {
                                d28 = i28;
                                str15 = c.getString(i28);
                            }
                            recordEntity.setCacheLastWavChannelPath(str15);
                            int i29 = d29;
                            d29 = i29;
                            recordEntity.setTwoChannelType(c.getInt(i29) != 0);
                            int i30 = d30;
                            d30 = i30;
                            recordEntity.setFinishAsr(c.getInt(i30) != 0);
                            int i31 = d31;
                            d31 = i31;
                            recordEntity.setEmptyRecord(c.getInt(i31) != 0);
                            int i32 = d32;
                            d32 = i32;
                            recordEntity.setNewRecordItem(c.getInt(i32) != 0);
                            int i33 = i19;
                            int i34 = d33;
                            recordEntity.setRequestId(c.getString(i34));
                            d33 = i34;
                            int i35 = d34;
                            recordEntity.setAccountId(c.getString(i35));
                            d34 = i35;
                            int i36 = d35;
                            recordEntity.setRecognizeId(c.getString(i36));
                            int i37 = d36;
                            if (c.getInt(i37) != 0) {
                                d35 = i36;
                                z3 = true;
                            } else {
                                d35 = i36;
                                z3 = false;
                            }
                            recordEntity.setDownloading(z3);
                            int i38 = d37;
                            d37 = i38;
                            recordEntity.setVoiceHasNewMerge(c.getInt(i38) != 0);
                            int i39 = i14;
                            int i40 = i16;
                            int i41 = d38;
                            recordEntity.setOriginTextSize(c.getLong(i41));
                            int i42 = d39;
                            recordEntity.setLanguageType(c.getString(i42));
                            int i43 = i12;
                            int i44 = i11;
                            int i45 = d40;
                            recordEntity.setWordShareCount(c.getLong(i45));
                            int i46 = i42;
                            d40 = i45;
                            int i47 = d41;
                            recordEntity.setVideoShareCount(c.getLong(i47));
                            arrayList.add(recordEntity);
                            d41 = i47;
                            d2 = i5;
                            d12 = i44;
                            d3 = i6;
                            d4 = i8;
                            d39 = i46;
                            d5 = i10;
                            i2 = i13;
                            d15 = i43;
                            d38 = i41;
                            d = i15;
                            d16 = i39;
                            d19 = i33;
                            d21 = i;
                            int i48 = i40;
                            d36 = i37;
                            d13 = i17;
                            d17 = i48;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object getRecordEntityCount(String str, Continuation<? super Long> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT count(*)  FROM RecordEntity where accountId = ?", 1);
        c.B(1, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<Long>() {
            @NonNull
            public Long call() throws Exception {
                long j;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    if (c.moveToFirst()) {
                        j = Long.valueOf(c.getLong(0));
                    } else {
                        j = 0L;
                    }
                    return j;
                } finally {
                    c.close();
                    c.release();
                }
            }
        }, continuation);
    }

    public Object getRecordEntityFinisRecordByCreateTime(String str, Continuation<? super List<RecordEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity  where recordStatus = 2 OR recordStatus = 5 AND  accountId = ? ORDER BY createTime DESC", 1);
        c.B(1, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordEntity>>() {
            @Nullable
            public List<RecordEntity> call() throws Exception {
                AnonymousClass55 r3;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                boolean z;
                boolean z2;
                int i;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        int i2 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            RecordEntity recordEntity = new RecordEntity();
                            int i3 = d11;
                            int i4 = d12;
                            recordEntity.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity.setLocationShort(str7);
                            recordEntity.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity.setSummaryInfo(str8);
                            int i5 = d2;
                            d11 = i3;
                            int i6 = d3;
                            recordEntity.setFileSize(c.getLong(d11));
                            int i7 = i4;
                            int i8 = d4;
                            recordEntity.setLastModified(c.getLong(i7));
                            recordEntity.setCreateTime(c.getLong(d13));
                            int i9 = i2;
                            int i10 = d5;
                            recordEntity.setLatitude(c.getLong(i9));
                            int i11 = i7;
                            int i12 = d15;
                            int i13 = i9;
                            recordEntity.setLongitude(c.getLong(i12));
                            int i14 = d16;
                            recordEntity.setType(c.getInt(i14));
                            int i15 = d;
                            int i16 = d17;
                            recordEntity.setPlayStatus(c.getInt(i16));
                            int i17 = d13;
                            int i18 = d18;
                            recordEntity.setRecordStatus(c.getInt(i18));
                            int i19 = d19;
                            if (c.getInt(i19) != 0) {
                                d18 = i18;
                                z = true;
                            } else {
                                d18 = i18;
                                z = false;
                            }
                            recordEntity.setChoose(z);
                            int i20 = d20;
                            if (c.getInt(i20) != 0) {
                                d20 = i20;
                                z2 = true;
                            } else {
                                d20 = i20;
                                z2 = false;
                            }
                            recordEntity.setHasRenameRecord(z2);
                            int i21 = d21;
                            if (c.isNull(i21)) {
                                i = i21;
                                str9 = null;
                            } else {
                                i = i21;
                                str9 = c.getString(i21);
                            }
                            recordEntity.setCacheFileDir(str9);
                            int i22 = d22;
                            d22 = i22;
                            recordEntity.setFinishFileMerge(c.getInt(i22) != 0);
                            int i23 = d23;
                            if (c.isNull(i23)) {
                                d23 = i23;
                                str10 = null;
                            } else {
                                d23 = i23;
                                str10 = c.getString(i23);
                            }
                            recordEntity.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i24 = d24;
                            if (c.isNull(i24)) {
                                d24 = i24;
                                str11 = null;
                            } else {
                                d24 = i24;
                                str11 = c.getString(i24);
                            }
                            recordEntity.setCacheLastUpMergePcmChannelPath(str11);
                            int i25 = d25;
                            if (c.isNull(i25)) {
                                d25 = i25;
                                str12 = null;
                            } else {
                                d25 = i25;
                                str12 = c.getString(i25);
                            }
                            recordEntity.setCacheLastDownMergePcmChannelPath(str12);
                            int i26 = d26;
                            if (c.isNull(i26)) {
                                d26 = i26;
                                str13 = null;
                            } else {
                                d26 = i26;
                                str13 = c.getString(i26);
                            }
                            recordEntity.setCacheLastUpMergeWavChannelPath(str13);
                            int i27 = d27;
                            if (c.isNull(i27)) {
                                d27 = i27;
                                str14 = null;
                            } else {
                                d27 = i27;
                                str14 = c.getString(i27);
                            }
                            recordEntity.setCacheLastDownMergeWavChannelPath(str14);
                            int i28 = d28;
                            if (c.isNull(i28)) {
                                d28 = i28;
                                str15 = null;
                            } else {
                                d28 = i28;
                                str15 = c.getString(i28);
                            }
                            recordEntity.setCacheLastWavChannelPath(str15);
                            int i29 = d29;
                            d29 = i29;
                            recordEntity.setTwoChannelType(c.getInt(i29) != 0);
                            int i30 = d30;
                            d30 = i30;
                            recordEntity.setFinishAsr(c.getInt(i30) != 0);
                            int i31 = d31;
                            d31 = i31;
                            recordEntity.setEmptyRecord(c.getInt(i31) != 0);
                            int i32 = d32;
                            d32 = i32;
                            recordEntity.setNewRecordItem(c.getInt(i32) != 0);
                            int i33 = i19;
                            int i34 = d33;
                            recordEntity.setRequestId(c.getString(i34));
                            d33 = i34;
                            int i35 = d34;
                            recordEntity.setAccountId(c.getString(i35));
                            d34 = i35;
                            int i36 = d35;
                            recordEntity.setRecognizeId(c.getString(i36));
                            int i37 = d36;
                            if (c.getInt(i37) != 0) {
                                d35 = i36;
                                z3 = true;
                            } else {
                                d35 = i36;
                                z3 = false;
                            }
                            recordEntity.setDownloading(z3);
                            int i38 = d37;
                            d37 = i38;
                            recordEntity.setVoiceHasNewMerge(c.getInt(i38) != 0);
                            int i39 = i14;
                            int i40 = i16;
                            int i41 = d38;
                            recordEntity.setOriginTextSize(c.getLong(i41));
                            int i42 = d39;
                            recordEntity.setLanguageType(c.getString(i42));
                            int i43 = i12;
                            int i44 = i11;
                            int i45 = d40;
                            recordEntity.setWordShareCount(c.getLong(i45));
                            int i46 = i42;
                            d40 = i45;
                            int i47 = d41;
                            recordEntity.setVideoShareCount(c.getLong(i47));
                            arrayList.add(recordEntity);
                            d41 = i47;
                            d2 = i5;
                            d12 = i44;
                            d3 = i6;
                            d4 = i8;
                            d39 = i46;
                            d5 = i10;
                            i2 = i13;
                            d15 = i43;
                            d38 = i41;
                            d = i15;
                            d16 = i39;
                            d19 = i33;
                            d21 = i;
                            int i48 = i40;
                            d36 = i37;
                            d13 = i17;
                            d17 = i48;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object getRecordEntityForTypeCreate(int i, String str, Continuation<? super List<RecordEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity where type=? AND accountId = ?  ORDER BY createTime DESC", 2);
        c.F(1, (long) i);
        c.B(2, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordEntity>>() {
            @Nullable
            public List<RecordEntity> call() throws Exception {
                AnonymousClass58 r3;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                boolean z;
                boolean z2;
                int i;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        int i2 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            RecordEntity recordEntity = new RecordEntity();
                            int i3 = d11;
                            int i4 = d12;
                            recordEntity.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity.setLocationShort(str7);
                            recordEntity.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity.setSummaryInfo(str8);
                            int i5 = d2;
                            d11 = i3;
                            int i6 = d3;
                            recordEntity.setFileSize(c.getLong(d11));
                            int i7 = i4;
                            int i8 = d4;
                            recordEntity.setLastModified(c.getLong(i7));
                            recordEntity.setCreateTime(c.getLong(d13));
                            int i9 = i2;
                            int i10 = d5;
                            recordEntity.setLatitude(c.getLong(i9));
                            int i11 = i7;
                            int i12 = d15;
                            int i13 = i9;
                            recordEntity.setLongitude(c.getLong(i12));
                            int i14 = d16;
                            recordEntity.setType(c.getInt(i14));
                            int i15 = d;
                            int i16 = d17;
                            recordEntity.setPlayStatus(c.getInt(i16));
                            int i17 = d13;
                            int i18 = d18;
                            recordEntity.setRecordStatus(c.getInt(i18));
                            int i19 = d19;
                            if (c.getInt(i19) != 0) {
                                d18 = i18;
                                z = true;
                            } else {
                                d18 = i18;
                                z = false;
                            }
                            recordEntity.setChoose(z);
                            int i20 = d20;
                            if (c.getInt(i20) != 0) {
                                d20 = i20;
                                z2 = true;
                            } else {
                                d20 = i20;
                                z2 = false;
                            }
                            recordEntity.setHasRenameRecord(z2);
                            int i21 = d21;
                            if (c.isNull(i21)) {
                                i = i21;
                                str9 = null;
                            } else {
                                i = i21;
                                str9 = c.getString(i21);
                            }
                            recordEntity.setCacheFileDir(str9);
                            int i22 = d22;
                            d22 = i22;
                            recordEntity.setFinishFileMerge(c.getInt(i22) != 0);
                            int i23 = d23;
                            if (c.isNull(i23)) {
                                d23 = i23;
                                str10 = null;
                            } else {
                                d23 = i23;
                                str10 = c.getString(i23);
                            }
                            recordEntity.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i24 = d24;
                            if (c.isNull(i24)) {
                                d24 = i24;
                                str11 = null;
                            } else {
                                d24 = i24;
                                str11 = c.getString(i24);
                            }
                            recordEntity.setCacheLastUpMergePcmChannelPath(str11);
                            int i25 = d25;
                            if (c.isNull(i25)) {
                                d25 = i25;
                                str12 = null;
                            } else {
                                d25 = i25;
                                str12 = c.getString(i25);
                            }
                            recordEntity.setCacheLastDownMergePcmChannelPath(str12);
                            int i26 = d26;
                            if (c.isNull(i26)) {
                                d26 = i26;
                                str13 = null;
                            } else {
                                d26 = i26;
                                str13 = c.getString(i26);
                            }
                            recordEntity.setCacheLastUpMergeWavChannelPath(str13);
                            int i27 = d27;
                            if (c.isNull(i27)) {
                                d27 = i27;
                                str14 = null;
                            } else {
                                d27 = i27;
                                str14 = c.getString(i27);
                            }
                            recordEntity.setCacheLastDownMergeWavChannelPath(str14);
                            int i28 = d28;
                            if (c.isNull(i28)) {
                                d28 = i28;
                                str15 = null;
                            } else {
                                d28 = i28;
                                str15 = c.getString(i28);
                            }
                            recordEntity.setCacheLastWavChannelPath(str15);
                            int i29 = d29;
                            d29 = i29;
                            recordEntity.setTwoChannelType(c.getInt(i29) != 0);
                            int i30 = d30;
                            d30 = i30;
                            recordEntity.setFinishAsr(c.getInt(i30) != 0);
                            int i31 = d31;
                            d31 = i31;
                            recordEntity.setEmptyRecord(c.getInt(i31) != 0);
                            int i32 = d32;
                            d32 = i32;
                            recordEntity.setNewRecordItem(c.getInt(i32) != 0);
                            int i33 = i19;
                            int i34 = d33;
                            recordEntity.setRequestId(c.getString(i34));
                            d33 = i34;
                            int i35 = d34;
                            recordEntity.setAccountId(c.getString(i35));
                            d34 = i35;
                            int i36 = d35;
                            recordEntity.setRecognizeId(c.getString(i36));
                            int i37 = d36;
                            if (c.getInt(i37) != 0) {
                                d35 = i36;
                                z3 = true;
                            } else {
                                d35 = i36;
                                z3 = false;
                            }
                            recordEntity.setDownloading(z3);
                            int i38 = d37;
                            d37 = i38;
                            recordEntity.setVoiceHasNewMerge(c.getInt(i38) != 0);
                            int i39 = i14;
                            int i40 = i16;
                            int i41 = d38;
                            recordEntity.setOriginTextSize(c.getLong(i41));
                            int i42 = d39;
                            recordEntity.setLanguageType(c.getString(i42));
                            int i43 = i12;
                            int i44 = i11;
                            int i45 = d40;
                            recordEntity.setWordShareCount(c.getLong(i45));
                            int i46 = i42;
                            d40 = i45;
                            int i47 = d41;
                            recordEntity.setVideoShareCount(c.getLong(i47));
                            arrayList.add(recordEntity);
                            d41 = i47;
                            d2 = i5;
                            d12 = i44;
                            d3 = i6;
                            d4 = i8;
                            d39 = i46;
                            d5 = i10;
                            i2 = i13;
                            d15 = i43;
                            d38 = i41;
                            d = i15;
                            d16 = i39;
                            d19 = i33;
                            d21 = i;
                            int i48 = i40;
                            d36 = i37;
                            d13 = i17;
                            d17 = i48;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object getRecordEntityNotDowningByCreateTime(String str, Continuation<? super List<RecordEntity>> continuation) {
        final RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT * FROM RecordEntity  where isDownloading= 0 AND accountId = ? ORDER BY createTime DESC", 1);
        c.B(1, str);
        return CoroutinesRoom.b(this.__db, false, DBUtil.a(), new Callable<List<RecordEntity>>() {
            @Nullable
            public List<RecordEntity> call() throws Exception {
                AnonymousClass54 r3;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                boolean z;
                boolean z2;
                int i;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                boolean z3;
                Cursor c = DBUtil.c(FastRecordDao_Impl.this.__db, c, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "recordId");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileName");
                    int d4 = CursorUtil.d(c, "md5");
                    int d5 = CursorUtil.d(c, "shortHandText");
                    int d6 = CursorUtil.d(c, "shortHandTitle");
                    int d7 = CursorUtil.d(c, "location");
                    int d8 = CursorUtil.d(c, "locationShort");
                    int d9 = CursorUtil.d(c, "totalTime");
                    int d10 = CursorUtil.d(c, "summaryInfo");
                    int d11 = CursorUtil.d(c, "fileSize");
                    int d12 = CursorUtil.d(c, "lastModified");
                    int d13 = CursorUtil.d(c, "createTime");
                    int d14 = CursorUtil.d(c, "latitude");
                    try {
                        int d15 = CursorUtil.d(c, "longitude");
                        int d16 = CursorUtil.d(c, "type");
                        int d17 = CursorUtil.d(c, "playStatus");
                        int d18 = CursorUtil.d(c, "recordStatus");
                        int d19 = CursorUtil.d(c, "isChoose");
                        int d20 = CursorUtil.d(c, "hasRenameRecord");
                        int d21 = CursorUtil.d(c, "cacheFileDir");
                        int d22 = CursorUtil.d(c, "isFinishFileMerge");
                        int d23 = CursorUtil.d(c, "cacheLastMergeAllScenePcmChannelPath");
                        int d24 = CursorUtil.d(c, "cacheLastUpMergePcmChannelPath");
                        int d25 = CursorUtil.d(c, "cacheLastDownMergePcmChannelPath");
                        int d26 = CursorUtil.d(c, "cacheLastUpMergeWavChannelPath");
                        int d27 = CursorUtil.d(c, "cacheLastDownMergeWavChannelPath");
                        int d28 = CursorUtil.d(c, "cacheLastWavChannelPath");
                        int d29 = CursorUtil.d(c, "isTwoChannelType");
                        int d30 = CursorUtil.d(c, "isFinishAsr");
                        int d31 = CursorUtil.d(c, "isEmptyRecord");
                        int d32 = CursorUtil.d(c, "isNewRecordItem");
                        int d33 = CursorUtil.d(c, "requestId");
                        int d34 = CursorUtil.d(c, "accountId");
                        int d35 = CursorUtil.d(c, "recognizeId");
                        int d36 = CursorUtil.d(c, "isDownloading");
                        int d37 = CursorUtil.d(c, "isVoiceHasNewMerge");
                        int d38 = CursorUtil.d(c, "originTextSize");
                        int d39 = CursorUtil.d(c, "languageType");
                        int d40 = CursorUtil.d(c, "wordShareCount");
                        int d41 = CursorUtil.d(c, "videoShareCount");
                        int i2 = d14;
                        ArrayList arrayList = new ArrayList(c.getCount());
                        while (c.moveToNext()) {
                            RecordEntity recordEntity = new RecordEntity();
                            int i3 = d11;
                            int i4 = d12;
                            recordEntity.setRecordId(c.getLong(d));
                            if (c.isNull(d2)) {
                                str = null;
                            } else {
                                str = c.getString(d2);
                            }
                            recordEntity.setFilePath(str);
                            if (c.isNull(d3)) {
                                str2 = null;
                            } else {
                                str2 = c.getString(d3);
                            }
                            recordEntity.setFileName(str2);
                            if (c.isNull(d4)) {
                                str3 = null;
                            } else {
                                str3 = c.getString(d4);
                            }
                            recordEntity.setMd5(str3);
                            if (c.isNull(d5)) {
                                str4 = null;
                            } else {
                                str4 = c.getString(d5);
                            }
                            recordEntity.setShortHandText(str4);
                            if (c.isNull(d6)) {
                                str5 = null;
                            } else {
                                str5 = c.getString(d6);
                            }
                            recordEntity.setShortHandTitle(str5);
                            if (c.isNull(d7)) {
                                str6 = null;
                            } else {
                                str6 = c.getString(d7);
                            }
                            recordEntity.setLocation(str6);
                            if (c.isNull(d8)) {
                                str7 = null;
                            } else {
                                str7 = c.getString(d8);
                            }
                            recordEntity.setLocationShort(str7);
                            recordEntity.setTotalTime(c.getLong(d9));
                            if (c.isNull(d10)) {
                                str8 = null;
                            } else {
                                str8 = c.getString(d10);
                            }
                            recordEntity.setSummaryInfo(str8);
                            int i5 = d2;
                            d11 = i3;
                            int i6 = d3;
                            recordEntity.setFileSize(c.getLong(d11));
                            int i7 = i4;
                            int i8 = d4;
                            recordEntity.setLastModified(c.getLong(i7));
                            recordEntity.setCreateTime(c.getLong(d13));
                            int i9 = i2;
                            int i10 = d5;
                            recordEntity.setLatitude(c.getLong(i9));
                            int i11 = i7;
                            int i12 = d15;
                            int i13 = i9;
                            recordEntity.setLongitude(c.getLong(i12));
                            int i14 = d16;
                            recordEntity.setType(c.getInt(i14));
                            int i15 = d;
                            int i16 = d17;
                            recordEntity.setPlayStatus(c.getInt(i16));
                            int i17 = d13;
                            int i18 = d18;
                            recordEntity.setRecordStatus(c.getInt(i18));
                            int i19 = d19;
                            if (c.getInt(i19) != 0) {
                                d18 = i18;
                                z = true;
                            } else {
                                d18 = i18;
                                z = false;
                            }
                            recordEntity.setChoose(z);
                            int i20 = d20;
                            if (c.getInt(i20) != 0) {
                                d20 = i20;
                                z2 = true;
                            } else {
                                d20 = i20;
                                z2 = false;
                            }
                            recordEntity.setHasRenameRecord(z2);
                            int i21 = d21;
                            if (c.isNull(i21)) {
                                i = i21;
                                str9 = null;
                            } else {
                                i = i21;
                                str9 = c.getString(i21);
                            }
                            recordEntity.setCacheFileDir(str9);
                            int i22 = d22;
                            d22 = i22;
                            recordEntity.setFinishFileMerge(c.getInt(i22) != 0);
                            int i23 = d23;
                            if (c.isNull(i23)) {
                                d23 = i23;
                                str10 = null;
                            } else {
                                d23 = i23;
                                str10 = c.getString(i23);
                            }
                            recordEntity.setCacheLastMergeAllScenePcmChannelPath(str10);
                            int i24 = d24;
                            if (c.isNull(i24)) {
                                d24 = i24;
                                str11 = null;
                            } else {
                                d24 = i24;
                                str11 = c.getString(i24);
                            }
                            recordEntity.setCacheLastUpMergePcmChannelPath(str11);
                            int i25 = d25;
                            if (c.isNull(i25)) {
                                d25 = i25;
                                str12 = null;
                            } else {
                                d25 = i25;
                                str12 = c.getString(i25);
                            }
                            recordEntity.setCacheLastDownMergePcmChannelPath(str12);
                            int i26 = d26;
                            if (c.isNull(i26)) {
                                d26 = i26;
                                str13 = null;
                            } else {
                                d26 = i26;
                                str13 = c.getString(i26);
                            }
                            recordEntity.setCacheLastUpMergeWavChannelPath(str13);
                            int i27 = d27;
                            if (c.isNull(i27)) {
                                d27 = i27;
                                str14 = null;
                            } else {
                                d27 = i27;
                                str14 = c.getString(i27);
                            }
                            recordEntity.setCacheLastDownMergeWavChannelPath(str14);
                            int i28 = d28;
                            if (c.isNull(i28)) {
                                d28 = i28;
                                str15 = null;
                            } else {
                                d28 = i28;
                                str15 = c.getString(i28);
                            }
                            recordEntity.setCacheLastWavChannelPath(str15);
                            int i29 = d29;
                            d29 = i29;
                            recordEntity.setTwoChannelType(c.getInt(i29) != 0);
                            int i30 = d30;
                            d30 = i30;
                            recordEntity.setFinishAsr(c.getInt(i30) != 0);
                            int i31 = d31;
                            d31 = i31;
                            recordEntity.setEmptyRecord(c.getInt(i31) != 0);
                            int i32 = d32;
                            d32 = i32;
                            recordEntity.setNewRecordItem(c.getInt(i32) != 0);
                            int i33 = i19;
                            int i34 = d33;
                            recordEntity.setRequestId(c.getString(i34));
                            d33 = i34;
                            int i35 = d34;
                            recordEntity.setAccountId(c.getString(i35));
                            d34 = i35;
                            int i36 = d35;
                            recordEntity.setRecognizeId(c.getString(i36));
                            int i37 = d36;
                            if (c.getInt(i37) != 0) {
                                d35 = i36;
                                z3 = true;
                            } else {
                                d35 = i36;
                                z3 = false;
                            }
                            recordEntity.setDownloading(z3);
                            int i38 = d37;
                            d37 = i38;
                            recordEntity.setVoiceHasNewMerge(c.getInt(i38) != 0);
                            int i39 = i14;
                            int i40 = i16;
                            int i41 = d38;
                            recordEntity.setOriginTextSize(c.getLong(i41));
                            int i42 = d39;
                            recordEntity.setLanguageType(c.getString(i42));
                            int i43 = i12;
                            int i44 = i11;
                            int i45 = d40;
                            recordEntity.setWordShareCount(c.getLong(i45));
                            int i46 = i42;
                            d40 = i45;
                            int i47 = d41;
                            recordEntity.setVideoShareCount(c.getLong(i47));
                            arrayList.add(recordEntity);
                            d41 = i47;
                            d2 = i5;
                            d12 = i44;
                            d3 = i6;
                            d4 = i8;
                            d39 = i46;
                            d5 = i10;
                            i2 = i13;
                            d15 = i43;
                            d38 = i41;
                            d = i15;
                            d16 = i39;
                            d19 = i33;
                            d21 = i;
                            int i48 = i40;
                            d36 = i37;
                            d13 = i17;
                            d17 = i48;
                        }
                        c.close();
                        c.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        c.close();
                        c.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = this;
                    c.close();
                    c.release();
                    throw th;
                }
            }
        }, continuation);
    }

    public Object insert(final RecordEntity recordEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordDao_Impl.this.__insertionAdapterOfRecordEntity.insert(recordEntity);
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public void insertForCacheDownloading(RecordEntity recordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecordEntity.insert(recordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public Object update(final RecordEntity recordEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                FastRecordDao_Impl.this.__db.beginTransaction();
                try {
                    FastRecordDao_Impl.this.__updateAdapterOfRecordEntity.handle(recordEntity);
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FastRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public void updateAllEmptyRecordToNoFinish(boolean z, boolean z2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateAllEmptyRecordToNoFinish.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, z2 ? 1 : 0);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateAllEmptyRecordToNoFinish.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateAllEmptyRecordToNoFinish.release(acquire);
            throw th;
        }
    }

    public void updateNormal(RecordEntity recordEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRecordEntity.handle(recordEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public Object updatePhoneRecordAfterMergeFile(long j, String str, String str2, String str3, String str4, String str5, long j2, String str6, boolean z, boolean z2, boolean z3, Continuation<? super Unit> continuation) {
        RoomDatabase roomDatabase = this.__db;
        final String str7 = str;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final long j3 = j2;
        final String str12 = str6;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        AnonymousClass39 r16 = r0;
        final long j4 = j;
        AnonymousClass39 r0 = new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdatePhoneRecordAfterMergeFile.acquire();
                acquire.B(1, str7);
                acquire.B(2, str8);
                acquire.B(3, str9);
                acquire.B(4, str10);
                acquire.B(5, str11);
                acquire.F(6, j3);
                acquire.B(7, str12);
                acquire.F(8, z4 ? 1 : 0);
                acquire.F(9, z5 ? 1 : 0);
                acquire.F(10, z6 ? 1 : 0);
                acquire.F(11, j4);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdatePhoneRecordAfterMergeFile.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdatePhoneRecordAfterMergeFile.release(acquire);
                    throw th;
                }
            }
        };
        return CoroutinesRoom.c(roomDatabase, true, r16, continuation);
    }

    public Object updateRecordArsRequestInfo(long j, String str, String str2, Continuation<? super Unit> continuation) {
        final String str3 = str;
        final String str4 = str2;
        final long j2 = j;
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordArsRequestInfo.acquire();
                acquire.B(1, str3);
                acquire.B(2, str4);
                acquire.F(3, j2);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordArsRequestInfo.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordArsRequestInfo.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordContent(final long j, final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordContent.acquire();
                acquire.B(1, str);
                acquire.F(2, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordContent.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordContent.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordEmptyRecordState(final long j, final boolean z, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordEmptyRecordState.acquire();
                acquire.F(1, z ? 1 : 0);
                acquire.F(2, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordEmptyRecordState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordEmptyRecordState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordEntityDownloadState(final long j, final boolean z, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordEntityDownloadState.acquire();
                acquire.F(1, z ? 1 : 0);
                acquire.F(2, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordEntityDownloadState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordEntityDownloadState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordFinishAsrAndEmptyState(long j, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        final boolean z3 = z;
        final boolean z4 = z2;
        final long j2 = j;
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordFinishAsrAndEmptyState.acquire();
                acquire.F(1, z3 ? 1 : 0);
                acquire.F(2, z4 ? 1 : 0);
                acquire.F(3, j2);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordFinishAsrAndEmptyState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordFinishAsrAndEmptyState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordFinishAsrState(final long j, final boolean z, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordFinishAsrState.acquire();
                acquire.F(1, z ? 1 : 0);
                acquire.F(2, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordFinishAsrState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordFinishAsrState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public void updateRecordFinishFileMergeState(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordFinishFileMergeState.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordFinishFileMergeState.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordFinishFileMergeState.release(acquire);
            throw th;
        }
    }

    public void updateRecordIngState(long j, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordIngState.acquire();
        acquire.F(1, (long) i);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordIngState.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordIngState.release(acquire);
            throw th;
        }
    }

    public void updateRecordIsEmptyAsrById(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordIsEmptyAsrById.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordIsEmptyAsrById.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordIsEmptyAsrById.release(acquire);
            throw th;
        }
    }

    public void updateRecordIsFinishAsrByIdNormal(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordIsFinishAsrByIdNormal.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordIsFinishAsrByIdNormal.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordIsFinishAsrByIdNormal.release(acquire);
            throw th;
        }
    }

    public Object updateRecordIsNewRecordItemState(final long j, final boolean z, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordIsNewRecordItemState.acquire();
                acquire.F(1, z ? 1 : 0);
                acquire.F(2, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordIsNewRecordItemState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordIsNewRecordItemState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public void updateRecordLangType(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordLangType.acquire();
        acquire.B(1, str);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordLangType.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordLangType.release(acquire);
            throw th;
        }
    }

    public void updateRecordOriginTextByIdNormal(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordOriginTextByIdNormal.acquire();
        acquire.B(1, str);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordOriginTextByIdNormal.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordOriginTextByIdNormal.release(acquire);
            throw th;
        }
    }

    public void updateRecordOriginTextSizeByIdNormal(long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordOriginTextSizeByIdNormal.acquire();
        acquire.F(1, j2);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordOriginTextSizeByIdNormal.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordOriginTextSizeByIdNormal.release(acquire);
            throw th;
        }
    }

    public Object updateRecordState(long j, int i, long j2, long j3, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        final long j4 = j2;
        final int i2 = i;
        final long j5 = j3;
        final boolean z3 = z;
        final boolean z4 = z2;
        final long j6 = j;
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordState.acquire();
                acquire.F(1, j4);
                acquire.F(2, (long) i2);
                acquire.F(3, j5);
                acquire.F(4, z3 ? 1 : 0);
                acquire.F(5, z4 ? 1 : 0);
                acquire.F(6, j6);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordStatus(final long j, final int i, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordIngState.acquire();
                acquire.F(1, (long) i);
                acquire.F(2, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordIngState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordIngState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordStatusAndTime(long j, int i, long j2, Continuation<? super Unit> continuation) {
        final int i2 = i;
        final long j3 = j2;
        final long j4 = j;
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordStatusAndTime.acquire();
                acquire.F(1, (long) i2);
                acquire.F(2, j3);
                acquire.F(3, j4);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordStatusAndTime.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordStatusAndTime.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordTime(long j, long j2, Continuation<? super Unit> continuation) {
        final long j3 = j2;
        final long j4 = j;
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordTime.acquire();
                acquire.F(1, j3);
                acquire.F(2, j4);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordTime.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordTime.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object updateRecordTitleItemState(final long j, final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordTitleItemState.acquire();
                acquire.B(1, str);
                acquire.F(2, j);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordTitleItemState.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateRecordTitleItemState.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public void updateRecordTotalTime(long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateRecordTotalTime.acquire();
        acquire.F(1, j2);
        acquire.F(2, j);
        try {
            this.__db.beginTransaction();
            acquire.k();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecordTotalTime.release(acquire);
        } catch (Throwable th) {
            this.__preparedStmtOfUpdateRecordTotalTime.release(acquire);
            throw th;
        }
    }

    public Object updateSceneRecordAfterMergeFile(long j, String str, String str2, long j2, String str3, boolean z, boolean z2, boolean z3, Continuation<? super Unit> continuation) {
        final String str4 = str;
        final String str5 = str2;
        final long j3 = j2;
        final String str6 = str3;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final long j4 = j;
        return CoroutinesRoom.c(this.__db, true, new Callable<Unit>() {
            @NonNull
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = FastRecordDao_Impl.this.__preparedStmtOfUpdateSceneRecordAfterMergeFile.acquire();
                acquire.B(1, str4);
                acquire.B(2, str5);
                acquire.F(3, j3);
                acquire.B(4, str6);
                acquire.F(5, z4 ? 1 : 0);
                acquire.F(6, z5 ? 1 : 0);
                acquire.F(7, z6 ? 1 : 0);
                acquire.F(8, j4);
                try {
                    FastRecordDao_Impl.this.__db.beginTransaction();
                    acquire.k();
                    FastRecordDao_Impl.this.__db.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    FastRecordDao_Impl.this.__db.endTransaction();
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateSceneRecordAfterMergeFile.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    FastRecordDao_Impl.this.__preparedStmtOfUpdateSceneRecordAfterMergeFile.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }
}
