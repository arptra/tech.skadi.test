package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1", f = "FastRecordHistoryAsrOperatorManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $curTime;
    final /* synthetic */ long $recordId;
    final /* synthetic */ long $totalTime;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1(long j, long j2, long j3, Continuation<? super FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$totalTime = j2;
        this.$curTime = j3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1(this.$recordId, this.$totalTime, this.$curTime, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordHistoryAsrOperatorManager.AsrCallbackInterface asrCallbackInterface = (FastRecordHistoryAsrOperatorManager.AsrCallbackInterface) FastRecordHistoryAsrOperatorManager.callBackMap.get(Boxing.boxLong(this.$recordId));
            if (asrCallbackInterface != null) {
                asrCallbackInterface.asrResultProgress(this.$recordId, this.$totalTime, this.$curTime);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
