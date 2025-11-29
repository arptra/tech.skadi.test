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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u001a\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH'J\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH'J\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH'J\u001a\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\r\u001a\u00020\u000bH'J*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH'J$\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH'J\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH'J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0005H'J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0005H'¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/FastRecordPersonDao;", "", "delete", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "deleteAllData", "deleteAllNormalTag", "recordId", "", "personType", "", "deleteAllNormalTagByPersonName", "accountId", "personName", "deleteByRecordId", "deleteNormalTagByContent", "contentName", "findAllHistoryPersonWithOutSelf", "", "findAllNormalPersonByRecord", "findAllRecordPersonEntity", "findNormalPersonByRecord", "findNormalPersonEntityByName", "findPersonEntityByRecord", "insert", "recordPersonEntity", "update", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FastRecordPersonDao {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void deleteAllNormalTagByPersonName$default(FastRecordPersonDao fastRecordPersonDao, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                fastRecordPersonDao.deleteAllNormalTagByPersonName(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteAllNormalTagByPersonName");
        }

        public static /* synthetic */ List findAllHistoryPersonWithOutSelf$default(FastRecordPersonDao fastRecordPersonDao, long j, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordPersonDao.findAllHistoryPersonWithOutSelf(j, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllHistoryPersonWithOutSelf");
        }

        public static /* synthetic */ List findAllNormalPersonByRecord$default(FastRecordPersonDao fastRecordPersonDao, long j, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordPersonDao.findAllNormalPersonByRecord(j, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllNormalPersonByRecord");
        }

        public static /* synthetic */ List findAllRecordPersonEntity$default(FastRecordPersonDao fastRecordPersonDao, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordPersonDao.findAllRecordPersonEntity(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllRecordPersonEntity");
        }

        public static /* synthetic */ List findNormalPersonByRecord$default(FastRecordPersonDao fastRecordPersonDao, long j, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordPersonDao.findNormalPersonByRecord(j, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNormalPersonByRecord");
        }

        public static /* synthetic */ RecordPersonEntity findNormalPersonEntityByName$default(FastRecordPersonDao fastRecordPersonDao, String str, long j, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordPersonDao.findNormalPersonEntityByName(str, j, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNormalPersonEntityByName");
        }

        public static /* synthetic */ List findPersonEntityByRecord$default(FastRecordPersonDao fastRecordPersonDao, long j, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordPersonDao.findPersonEntityByRecord(j, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPersonEntityByRecord");
        }
    }

    @Delete
    void delete(@NotNull RecordPersonEntity recordPersonEntity);

    @Query
    void deleteAllData();

    @Query
    void deleteAllNormalTag(long j, @NotNull String str);

    @Query
    void deleteAllNormalTagByPersonName(@NotNull String str, @NotNull String str2);

    @Query
    void deleteByRecordId(long j);

    @Query
    void deleteNormalTagByContent(@NotNull String str, long j);

    @Nullable
    @Query
    List<RecordPersonEntity> findAllHistoryPersonWithOutSelf(long j, @NotNull String str);

    @Nullable
    @Query
    List<RecordPersonEntity> findAllNormalPersonByRecord(long j, @NotNull String str);

    @Nullable
    @Query
    List<RecordPersonEntity> findAllRecordPersonEntity(@NotNull String str);

    @Nullable
    @Query
    List<RecordPersonEntity> findNormalPersonByRecord(long j, @NotNull String str, @NotNull String str2);

    @Nullable
    @Query
    RecordPersonEntity findNormalPersonEntityByName(@NotNull String str, long j, @NotNull String str2);

    @Nullable
    @Query
    List<RecordPersonEntity> findPersonEntityByRecord(long j, @NotNull String str);

    @Insert
    void insert(@NotNull RecordPersonEntity recordPersonEntity);

    @Update
    void update(@NotNull RecordPersonEntity recordPersonEntity);
}
