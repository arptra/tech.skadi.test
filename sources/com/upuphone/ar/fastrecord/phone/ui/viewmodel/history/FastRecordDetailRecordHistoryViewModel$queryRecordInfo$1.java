package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {}, l = {507, 516}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1(long j, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Continuation<? super FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1(this.$recordId, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$recordId;
            LogExt.logE("queryRecordInfo recordId = " + j, "FastRecordDetailRecordHistoryViewModel");
            if (this.$recordId > 0) {
                FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
                long j2 = this.$recordId;
                this.label = 1;
                obj = FastRecordDao.DefaultImpls.findRecordEntityById$default(fastRecordDao, j2, (String) null, this, 2, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordEntity recordEntity = (RecordEntity) obj;
        if (recordEntity != null) {
            FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel = this.this$0;
            long j3 = this.$recordId;
            if (recordEntity.getTotalTime() < 1000) {
                recordEntity.setTotalTime(1000);
            }
            LogExt.logE("getRecordData info = " + recordEntity, "FastRecordDetailRecordHistoryViewModel");
            fastRecordDetailRecordHistoryViewModel._mCurFastRecordLiveData.postValue(recordEntity);
            this.label = 2;
            if (fastRecordDetailRecordHistoryViewModel.getTodoAndSummaryData(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
