package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {}, l = {215, 216}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1(FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, long j, Continuation<? super FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
        this.$recordId = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1(this.this$0, this.$recordId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(500, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel = this.this$0;
        long j = this.$recordId;
        this.label = 2;
        if (fastRecordDetailRecordHistoryViewModel.getTodoAndSummaryData(j, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
