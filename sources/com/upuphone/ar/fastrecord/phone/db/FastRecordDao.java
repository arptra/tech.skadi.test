package com.upuphone.ar.fastrecord.phone.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b9\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H§@¢\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\"\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH'J\"\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u000bH'J \u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0018\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ \u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ(\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010$J \u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001c\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+H'J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'Jf\u0010.\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020+2\u0006\u0010*\u001a\u00020+H§@¢\u0006\u0002\u00108J&\u00109\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH§@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0019J\u001e\u0010?\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020+H§@¢\u0006\u0002\u0010@J\u001e\u0010A\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020+H§@¢\u0006\u0002\u0010@J&\u0010C\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H§@¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H§@¢\u0006\u0002\u0010@J\u0018\u0010F\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u00020+H'J\u0018\u0010G\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020#H'J\u0018\u0010I\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020+H'J\u0018\u0010J\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020+H'J\u001e\u0010L\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020+H§@¢\u0006\u0002\u0010@J\u0018\u0010N\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000bH'J\u0018\u0010P\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000bH'J\u0018\u0010R\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u000fH'J>\u0010T\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020#2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020+2\u0006\u00106\u001a\u00020+H§@¢\u0006\u0002\u0010WJ\u001e\u0010X\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020#H§@¢\u0006\u0002\u0010YJ&\u0010Z\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020#2\u0006\u00104\u001a\u00020\u000fH§@¢\u0006\u0002\u0010[J\u001e\u0010\\\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH§@¢\u0006\u0002\u0010]J\u001e\u0010^\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0019J\u0018\u0010`\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH'JN\u0010a\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020+2\u0006\u0010*\u001a\u00020+H§@¢\u0006\u0002\u0010c¨\u0006d"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/FastRecordDao;", "", "delete", "", "recordEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "(Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByFilePath", "fileKey", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByRecordId", "recordId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteList", "recordEntityList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAllDownloadingRecordEntity", "accountId", "findAllNewItem", "findRecordEntityById", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findRecordEntityByIdNormal", "findRecordEntityContent", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRecordEntity", "getRecordEntityByCreateTime", "getRecordEntityCount", "getRecordEntityFinisRecordByCreateTime", "getRecordEntityForTypeCreate", "type", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordEntityNotDowningByCreateTime", "insert", "insertForCacheDownloading", "update", "updateAllEmptyRecordToNoFinish", "isFinishAsr", "", "isEmptyRecord", "updateNormal", "updatePhoneRecordAfterMergeFile", "cacheFileDir", "cacheLastUpMergePcmChannelPath", "cacheLastUpMergeWavChannelPath", "cacheLastDownMergePcmChannelPath", "cacheLastDownMergeWavChannelPath", "totalTime", "cacheLastWavChannelPath", "isFinishFileMerge", "isTwoChannelType", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordArsRequestInfo", "requestId", "recognizeId", "(JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordContent", "content", "updateRecordEmptyRecordState", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordEntityDownloadState", "isDownloadIng", "updateRecordFinishAsrAndEmptyState", "(JZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordFinishAsrState", "updateRecordFinishFileMergeState", "updateRecordIngState", "recordStatus", "updateRecordIsEmptyAsrById", "updateRecordIsFinishAsrByIdNormal", "state", "updateRecordIsNewRecordItemState", "isNewRecordItem", "updateRecordLangType", "languageType", "updateRecordOriginTextByIdNormal", "shortHandText", "updateRecordOriginTextSizeByIdNormal", "originTextSize", "updateRecordState", "lastModified", "isDownloading", "(JIJJZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordStatus", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordStatusAndTime", "(JIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordTime", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordTitleItemState", "title", "updateRecordTotalTime", "updateSceneRecordAfterMergeFile", "cacheLastMergeAllScenePcmChannelPath", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FastRecordDao {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object findAllDownloadingRecordEntity$default(FastRecordDao fastRecordDao, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.findAllDownloadingRecordEntity(str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllDownloadingRecordEntity");
        }

        public static /* synthetic */ Object findAllNewItem$default(FastRecordDao fastRecordDao, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.findAllNewItem(str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllNewItem");
        }

        public static /* synthetic */ Object findRecordEntityById$default(FastRecordDao fastRecordDao, long j, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.findRecordEntityById(j, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findRecordEntityById");
        }

        public static /* synthetic */ Object findRecordEntityContent$default(FastRecordDao fastRecordDao, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.findRecordEntityContent(str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findRecordEntityContent");
        }

        public static /* synthetic */ List getAllRecordEntity$default(FastRecordDao fastRecordDao, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.getAllRecordEntity(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllRecordEntity");
        }

        public static /* synthetic */ Object getRecordEntityByCreateTime$default(FastRecordDao fastRecordDao, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.getRecordEntityByCreateTime(str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecordEntityByCreateTime");
        }

        public static /* synthetic */ Object getRecordEntityCount$default(FastRecordDao fastRecordDao, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.getRecordEntityCount(str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecordEntityCount");
        }

        public static /* synthetic */ Object getRecordEntityFinisRecordByCreateTime$default(FastRecordDao fastRecordDao, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.getRecordEntityFinisRecordByCreateTime(str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecordEntityFinisRecordByCreateTime");
        }

        public static /* synthetic */ Object getRecordEntityForTypeCreate$default(FastRecordDao fastRecordDao, int i, String str, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.getRecordEntityForTypeCreate(i, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecordEntityForTypeCreate");
        }

        public static /* synthetic */ Object getRecordEntityNotDowningByCreateTime$default(FastRecordDao fastRecordDao, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordDao.getRecordEntityNotDowningByCreateTime(str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecordEntityNotDowningByCreateTime");
        }

        public static /* synthetic */ void updateAllEmptyRecordToNoFinish$default(FastRecordDao fastRecordDao, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                fastRecordDao.updateAllEmptyRecordToNoFinish(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAllEmptyRecordToNoFinish");
        }
    }

    @Nullable
    @Delete
    Object delete(@NotNull RecordEntity recordEntity, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteAllData(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteByFilePath(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteByRecordId(long j, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Delete
    Object deleteList(@NotNull List<RecordEntity> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object findAllDownloadingRecordEntity(@NotNull String str, @NotNull Continuation<? super List<RecordEntity>> continuation);

    @Nullable
    @Query
    Object findAllNewItem(@NotNull String str, @NotNull Continuation<? super List<RecordEntity>> continuation);

    @Nullable
    @Query
    Object findRecordEntityById(long j, @NotNull String str, @NotNull Continuation<? super RecordEntity> continuation);

    @Nullable
    @Query
    RecordEntity findRecordEntityByIdNormal(long j);

    @Nullable
    @Query
    Object findRecordEntityContent(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super RecordEntity> continuation);

    @Nullable
    @Query
    List<RecordEntity> getAllRecordEntity(@NotNull String str);

    @Nullable
    @Query
    Object getRecordEntityByCreateTime(@NotNull String str, @NotNull Continuation<? super List<RecordEntity>> continuation);

    @Nullable
    @Query
    Object getRecordEntityCount(@NotNull String str, @NotNull Continuation<? super Long> continuation);

    @Nullable
    @Query
    Object getRecordEntityFinisRecordByCreateTime(@NotNull String str, @NotNull Continuation<? super List<RecordEntity>> continuation);

    @Nullable
    @Query
    Object getRecordEntityForTypeCreate(int i, @NotNull String str, @NotNull Continuation<? super List<RecordEntity>> continuation);

    @Nullable
    @Query
    Object getRecordEntityNotDowningByCreateTime(@NotNull String str, @NotNull Continuation<? super List<RecordEntity>> continuation);

    @Nullable
    @Insert
    Object insert(@NotNull RecordEntity recordEntity, @NotNull Continuation<? super Unit> continuation);

    @Insert
    void insertForCacheDownloading(@NotNull RecordEntity recordEntity);

    @Nullable
    @Update
    Object update(@NotNull RecordEntity recordEntity, @NotNull Continuation<? super Unit> continuation);

    @Query
    void updateAllEmptyRecordToNoFinish(boolean z, boolean z2);

    @Update
    void updateNormal(@NotNull RecordEntity recordEntity);

    @Nullable
    @Query
    Object updatePhoneRecordAfterMergeFile(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j2, @NotNull String str6, boolean z, boolean z2, boolean z3, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordArsRequestInfo(long j, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordContent(long j, @NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordEmptyRecordState(long j, boolean z, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordEntityDownloadState(long j, boolean z, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordFinishAsrAndEmptyState(long j, boolean z, boolean z2, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordFinishAsrState(long j, boolean z, @NotNull Continuation<? super Unit> continuation);

    @Query
    void updateRecordFinishFileMergeState(long j, boolean z);

    @Query
    void updateRecordIngState(long j, int i);

    @Query
    void updateRecordIsEmptyAsrById(long j, boolean z);

    @Query
    void updateRecordIsFinishAsrByIdNormal(long j, boolean z);

    @Nullable
    @Query
    Object updateRecordIsNewRecordItemState(long j, boolean z, @NotNull Continuation<? super Unit> continuation);

    @Query
    void updateRecordLangType(long j, @NotNull String str);

    @Query
    void updateRecordOriginTextByIdNormal(long j, @NotNull String str);

    @Query
    void updateRecordOriginTextSizeByIdNormal(long j, long j2);

    @Nullable
    @Query
    Object updateRecordState(long j, int i, long j2, long j3, boolean z, boolean z2, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordStatus(long j, int i, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordStatusAndTime(long j, int i, long j2, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordTime(long j, long j2, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object updateRecordTitleItemState(long j, @NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Query
    void updateRecordTotalTime(long j, long j2);

    @Nullable
    @Query
    Object updateSceneRecordAfterMergeFile(long j, @NotNull String str, @NotNull String str2, long j2, @NotNull String str3, boolean z, boolean z2, boolean z3, @NotNull Continuation<? super Unit> continuation);
}
