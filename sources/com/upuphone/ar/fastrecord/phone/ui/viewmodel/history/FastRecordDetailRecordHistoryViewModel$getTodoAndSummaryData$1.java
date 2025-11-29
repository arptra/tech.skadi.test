package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {0, 0, 1, 1}, l = {222, 224}, m = "getTodoAndSummaryData", n = {"this", "recordId", "this", "recordId"}, s = {"L$0", "J$0", "L$0", "J$0"})
public final class FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1(FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Continuation<? super FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1> continuation) {
        super(continuation);
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getTodoAndSummaryData(0, this);
    }
}
