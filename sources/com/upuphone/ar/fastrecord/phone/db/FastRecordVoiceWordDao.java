package com.upuphone.ar.fastrecord.phone.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH§@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH'J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH'J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H'J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u001a\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/FastRecordVoiceWordDao;", "", "delete", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;", "(Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByRecordId", "recordId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItems", "entityList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findFastRecordById", "findFastRecordNumberById", "", "findFastRecordNumberByIdNoSuspend", "findFastRecordOrderByStartTime", "insert", "recordEntity", "insertDbNoSuspend", "update", "updateList", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FastRecordVoiceWordDao {
    @Nullable
    @Delete
    Object delete(@NotNull RecordVoiceWordEntity recordVoiceWordEntity, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteAllData(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteByRecordId(long j, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Delete
    Object deleteItems(@NotNull List<RecordVoiceWordEntity> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object findFastRecordById(long j, @NotNull Continuation<? super List<RecordVoiceWordEntity>> continuation);

    @Nullable
    @Query
    Object findFastRecordNumberById(long j, @NotNull Continuation<? super Integer> continuation);

    @Query
    int findFastRecordNumberByIdNoSuspend(long j);

    @Nullable
    @Query
    List<RecordVoiceWordEntity> findFastRecordOrderByStartTime(long j);

    @Nullable
    @Insert
    Object insert(@NotNull RecordVoiceWordEntity recordVoiceWordEntity, @NotNull Continuation<? super Unit> continuation);

    @Insert
    void insertDbNoSuspend(@NotNull RecordVoiceWordEntity recordVoiceWordEntity);

    @Nullable
    @Update
    Object update(@NotNull RecordVoiceWordEntity recordVoiceWordEntity, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Update
    Object updateList(@NotNull List<RecordVoiceWordEntity> list, @NotNull Continuation<? super Unit> continuation);
}
