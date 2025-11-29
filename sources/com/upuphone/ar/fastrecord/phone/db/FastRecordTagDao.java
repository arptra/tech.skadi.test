package com.upuphone.ar.fastrecord.phone.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u001a\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH'J\u001a\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\b\b\u0002\u0010\u000b\u001a\u00020\fH'J\u001a\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\b\b\u0002\u0010\u000b\u001a\u00020\fH'J\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH'J\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H'J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H'¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTagDao;", "", "delete", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "deleteAllData", "deleteAllNormalTag", "recordId", "", "deleteAllNormalTagByContentName", "accountId", "", "contentName", "deleteByRecordId", "deleteNormalContentTag", "findAllRecordPersonEntity", "", "findAllTagData", "findNormalTagEntityByRecord", "findTagEntityByRecord", "insert", "recordContentTagEntity", "update", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FastRecordTagDao {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void deleteAllNormalTagByContentName$default(FastRecordTagDao fastRecordTagDao, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                fastRecordTagDao.deleteAllNormalTagByContentName(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteAllNormalTagByContentName");
        }

        public static /* synthetic */ List findAllRecordPersonEntity$default(FastRecordTagDao fastRecordTagDao, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordTagDao.findAllRecordPersonEntity(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllRecordPersonEntity");
        }

        public static /* synthetic */ List findAllTagData$default(FastRecordTagDao fastRecordTagDao, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordTagDao.findAllTagData(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllTagData");
        }

        public static /* synthetic */ List findNormalTagEntityByRecord$default(FastRecordTagDao fastRecordTagDao, long j, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordTagDao.findNormalTagEntityByRecord(j, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNormalTagEntityByRecord");
        }

        public static /* synthetic */ List findTagEntityByRecord$default(FastRecordTagDao fastRecordTagDao, long j, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordTagDao.findTagEntityByRecord(j, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findTagEntityByRecord");
        }
    }

    @Delete
    void delete(@NotNull RecordContentTagEntity recordContentTagEntity);

    @Query
    void deleteAllData();

    @Query
    void deleteAllNormalTag(long j);

    @Query
    void deleteAllNormalTagByContentName(@NotNull String str, @NotNull String str2);

    @Query
    void deleteByRecordId(long j);

    @Query
    void deleteNormalContentTag(@NotNull String str, long j);

    @Nullable
    @Query
    List<RecordContentTagEntity> findAllRecordPersonEntity(@NotNull String str);

    @Nullable
    @Query
    List<RecordContentTagEntity> findAllTagData(@NotNull String str);

    @Nullable
    @Query
    List<RecordContentTagEntity> findNormalTagEntityByRecord(long j, @NotNull String str);

    @Nullable
    @Query
    List<RecordContentTagEntity> findTagEntityByRecord(long j, @NotNull String str);

    @Insert
    void insert(@NotNull RecordContentTagEntity recordContentTagEntity);

    @Update
    void update(@NotNull RecordContentTagEntity recordContentTagEntity);
}
