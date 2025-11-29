package com.upuphone.ar.fastrecord.phone.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH'J \u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H'J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H'¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/FastRecordVoiceDao;", "", "delete", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceEntity;", "deleteAllData", "deleteByIdAndRole", "recordId", "", "role", "", "deleteByRecordId", "findAllRecordEntity", "", "findVoiceEntityByIdAndRoleAsc", "findVoiceEntityByRecordId", "insert", "recordEntity", "update", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FastRecordVoiceDao {
    @Delete
    void delete(@NotNull RecordVoiceEntity recordVoiceEntity);

    @Query
    void deleteAllData();

    @Query
    void deleteByIdAndRole(long j, @NotNull String str);

    @Query
    void deleteByRecordId(long j);

    @Nullable
    @Query
    List<RecordVoiceEntity> findAllRecordEntity();

    @Nullable
    @Query
    List<RecordVoiceEntity> findVoiceEntityByIdAndRoleAsc(long j, @NotNull String str);

    @Nullable
    @Query
    List<RecordVoiceEntity> findVoiceEntityByRecordId(long j);

    @Insert
    void insert(@NotNull RecordVoiceEntity recordVoiceEntity);

    @Update
    void update(@NotNull RecordVoiceEntity recordVoiceEntity);
}
