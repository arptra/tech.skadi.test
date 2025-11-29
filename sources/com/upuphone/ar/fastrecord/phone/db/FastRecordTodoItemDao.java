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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H'J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H'J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0014H'J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0014H'¨\u0006\u001e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTodoItemDao;", "", "delete", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "(Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByRecordId", "recordId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByToDoId", "todoItemId", "insert", "recordEntity", "queryAllNoFinishByRecordId", "", "isFinishDel", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryByRecordId", "update", "updateFinishDelStateByRecord", "isReport", "updateFinishDelStateByTodoId", "updateNeedRequestServer", "isNeedRequestServer", "updateReportStateByRecord", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FastRecordTodoItemDao {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object queryAllNoFinishByRecordId$default(FastRecordTodoItemDao fastRecordTodoItemDao, long j, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return fastRecordTodoItemDao.queryAllNoFinishByRecordId(j, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryAllNoFinishByRecordId");
        }
    }

    @Nullable
    @Delete
    Object delete(@NotNull RecordTodoItemEntity recordTodoItemEntity, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteAllData(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteByRecordId(long j, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object deleteByToDoId(long j, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Insert
    Object insert(@NotNull RecordTodoItemEntity recordTodoItemEntity, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @Query
    Object queryAllNoFinishByRecordId(long j, boolean z, @NotNull Continuation<? super List<RecordTodoItemEntity>> continuation);

    @Nullable
    @Query
    Object queryByRecordId(long j, @NotNull Continuation<? super List<RecordTodoItemEntity>> continuation);

    @Nullable
    @Update
    Object update(@NotNull RecordTodoItemEntity recordTodoItemEntity, @NotNull Continuation<? super Unit> continuation);

    @Query
    void updateFinishDelStateByRecord(long j, boolean z, boolean z2);

    @Query
    void updateFinishDelStateByTodoId(long j, boolean z);

    @Query
    void updateNeedRequestServer(long j, boolean z);

    @Query
    void updateReportStateByRecord(long j, boolean z);
}
