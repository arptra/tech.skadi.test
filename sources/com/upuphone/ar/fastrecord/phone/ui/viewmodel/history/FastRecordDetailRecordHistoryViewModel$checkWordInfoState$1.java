package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.List;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {1}, l = {365, 374}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
public final class FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecordVoiceWordEntity> $notEmptyList;
    final /* synthetic */ long $recordId;
    final /* synthetic */ StringBuffer $stringBuffer;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1(List<RecordVoiceWordEntity> list, long j, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, StringBuffer stringBuffer, Continuation<? super FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1> continuation) {
        super(2, continuation);
        this.$notEmptyList = list;
        this.$recordId = j;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
        this.$stringBuffer = stringBuffer;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1(this.$notEmptyList, this.$recordId, this.this$0, this.$stringBuffer, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel;
        RecordEntity recordEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$notEmptyList.isEmpty()) {
                FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
                long j = this.$recordId;
                this.label = 1;
                obj = FastRecordDao.DefaultImpls.findRecordEntityById$default(fastRecordDao, j, (String) null, this, 2, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.this$0.saveRecordTotalWorld(this.$recordId, this.$stringBuffer);
                this.this$0._mCurRecordVoiceWordList.postValue(this.$notEmptyList);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            recordEntity = (RecordEntity) this.L$1;
            fastRecordDetailRecordHistoryViewModel = (FastRecordDetailRecordHistoryViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            fastRecordDetailRecordHistoryViewModel._mCurFastRecordLiveData.postValue(recordEntity);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordEntity recordEntity2 = (RecordEntity) obj;
        LogExt.logE("checkWordInfoState isNullOrEmpty recordItem = " + recordEntity2, "FastRecordDetailRecordHistoryViewModel");
        if (recordEntity2 != null && !recordEntity2.isEmptyRecord()) {
            recordEntity2.setFinishAsr(false);
        }
        if (recordEntity2 != null) {
            long j2 = this.$recordId;
            FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel2 = this.this$0;
            FastRecordDao fastRecordDao2 = FastRecordManager.Companion.getInstance().fastRecordDao();
            boolean isFinishAsr = recordEntity2.isFinishAsr();
            this.L$0 = fastRecordDetailRecordHistoryViewModel2;
            this.L$1 = recordEntity2;
            this.label = 2;
            if (fastRecordDao2.updateRecordFinishAsrState(j2, isFinishAsr, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            recordEntity = recordEntity2;
            fastRecordDetailRecordHistoryViewModel = fastRecordDetailRecordHistoryViewModel2;
            fastRecordDetailRecordHistoryViewModel._mCurFastRecordLiveData.postValue(recordEntity);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
