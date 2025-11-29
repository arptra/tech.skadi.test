package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao;
import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel$insertSummary$1", f = "FastRecordSummaryViewModel.kt", i = {}, l = {149, 151}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordSummaryViewModel$insertSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordSummaryEntity $summaryEntity;
    int label;
    final /* synthetic */ FastRecordSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryViewModel$insertSummary$1(RecordSummaryEntity recordSummaryEntity, FastRecordSummaryViewModel fastRecordSummaryViewModel, Continuation<? super FastRecordSummaryViewModel$insertSummary$1> continuation) {
        super(2, continuation);
        this.$summaryEntity = recordSummaryEntity;
        this.this$0 = fastRecordSummaryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordSummaryViewModel$insertSummary$1(this.$summaryEntity, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long recordId = this.$summaryEntity.getRecordId();
            FastRecordSummaryDao fastRecordSummaryDao = FastRecordManager.Companion.getInstance().fastRecordSummaryDao();
            this.label = 1;
            if (fastRecordSummaryDao.deleteByRecordId(recordId, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.this$0._mSummaryLiveData.postValue(this.$summaryEntity);
            this.this$0._mSummaryResult.postValue(Boxing.boxInt(0));
            FastRecordManager.Companion.getInstance().fastRecordSummaryDao().updateNeedRequestServer(this.$summaryEntity.getRecordId(), false);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FastRecordSummaryDao fastRecordSummaryDao2 = FastRecordManager.Companion.getInstance().fastRecordSummaryDao();
        RecordSummaryEntity recordSummaryEntity = this.$summaryEntity;
        this.label = 2;
        if (fastRecordSummaryDao2.insert(recordSummaryEntity, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0._mSummaryLiveData.postValue(this.$summaryEntity);
        this.this$0._mSummaryResult.postValue(Boxing.boxInt(0));
        FastRecordManager.Companion.getInstance().fastRecordSummaryDao().updateNeedRequestServer(this.$summaryEntity.getRecordId(), false);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordSummaryViewModel$insertSummary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
