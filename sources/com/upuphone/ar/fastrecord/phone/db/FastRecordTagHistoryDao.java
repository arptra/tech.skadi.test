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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH'J\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H'¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTagHistoryDao;", "", "delete", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentHistoryTagEntity;", "deleteAllData", "findAllRecordPersonEntity", "", "accountId", "", "findAllTagData", "insert", "recordContentTagEntity", "update", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FastRecordTagHistoryDao {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ List findAllRecordPersonEntity$default(FastRecordTagHistoryDao fastRecordTagHistoryDao, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordTagHistoryDao.findAllRecordPersonEntity(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllRecordPersonEntity");
        }

        public static /* synthetic */ List findAllTagData$default(FastRecordTagHistoryDao fastRecordTagHistoryDao, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = RecordDataSaveUtil.INSTANCE.getAccountId();
                }
                return fastRecordTagHistoryDao.findAllTagData(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAllTagData");
        }
    }

    @Delete
    void delete(@NotNull RecordContentHistoryTagEntity recordContentHistoryTagEntity);

    @Query
    void deleteAllData();

    @Nullable
    @Query
    List<RecordContentHistoryTagEntity> findAllRecordPersonEntity(@NotNull String str);

    @Nullable
    @Query
    List<RecordContentHistoryTagEntity> findAllTagData(@NotNull String str);

    @Insert
    void insert(@NotNull RecordContentHistoryTagEntity recordContentHistoryTagEntity);

    @Update
    void update(@NotNull RecordContentHistoryTagEntity recordContentHistoryTagEntity);
}
