package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.SummaryViewModel", f = "AiSummaryViewModel.kt", i = {0}, l = {103}, m = "updateSummary", n = {"summary"}, s = {"L$0"})
public final class SummaryViewModel$updateSummary$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryViewModel$updateSummary$1(SummaryViewModel summaryViewModel, Continuation<? super SummaryViewModel$updateSummary$1> continuation) {
        super(continuation);
        this.this$0 = summaryViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t((AiSummaryEntity) null, this);
    }
}
