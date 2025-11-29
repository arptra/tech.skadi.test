package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.SummaryViewModel", f = "AiSummaryViewModel.kt", i = {0, 0}, l = {123, 128, 132}, m = "getSummaryByDb", n = {"this", "noteBean"}, s = {"L$0", "L$1"})
public final class SummaryViewModel$getSummaryByDb$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryViewModel$getSummaryByDb$1(SummaryViewModel summaryViewModel, Continuation<? super SummaryViewModel$getSummaryByDb$1> continuation) {
        super(continuation);
        this.this$0 = summaryViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m((TranscribeBean) null, this);
    }
}
