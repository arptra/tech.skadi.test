package com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording.FastRecordDetailRecordIngViewModel$changeRecordFinishState$1", f = "FastRecordDetailRecordIngViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailRecordIngViewModel$changeRecordFinishState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ FastRecordDetailRecordIngViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordIngViewModel$changeRecordFinishState$1(FastRecordDetailRecordIngViewModel fastRecordDetailRecordIngViewModel, int i, Function0<Unit> function0, Continuation<? super FastRecordDetailRecordIngViewModel$changeRecordFinishState$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordDetailRecordIngViewModel;
        this.$state = i;
        this.$callBack = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordIngViewModel$changeRecordFinishState$1(this.this$0, this.$state, this.$callBack, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RecordEntity recordEntity = (RecordEntity) this.this$0._mCurFastRecordLiveData.getValue();
            if (recordEntity != null) {
                int i = this.$state;
                Function0<Unit> function0 = this.$callBack;
                FastRecordManager.Companion.getInstance().fastRecordDao().updateRecordIngState(recordEntity.getRecordId(), i);
                long recordId = recordEntity.getRecordId();
                String shortHandTitle = recordEntity.getShortHandTitle();
                LogExt.logE("changeRecordFinishState update record it  = " + recordId + ",title = " + shortHandTitle + ",state = " + i, "FastRecordDetailRecordIngViewModel");
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordIngViewModel$changeRecordFinishState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
