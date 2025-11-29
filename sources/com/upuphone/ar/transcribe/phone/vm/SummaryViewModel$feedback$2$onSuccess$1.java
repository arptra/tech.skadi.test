package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo;
import com.upuphone.ar.transcribe.phone.vm.SummaryData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$feedback$2$onSuccess$1", f = "AiSummaryViewModel.kt", i = {}, l = {86, 87}, m = "invokeSuspend", n = {}, s = {})
public final class SummaryViewModel$feedback$2$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryViewModel$feedback$2$onSuccess$1(SummaryViewModel summaryViewModel, Continuation<? super SummaryViewModel$feedback$2$onSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = summaryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SummaryViewModel$feedback$2$onSuccess$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow g = this.this$0.d;
            SummaryData.ReportStatus reportStatus = new SummaryData.ReportStatus(true);
            this.label = 1;
            if (g.emit(reportStatus, this) == coroutine_suspended) {
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
        TranscribeAiRepo e = this.this$0.c;
        AiSummaryEntity l = this.this$0.l();
        Intrinsics.checkNotNull(l);
        this.label = 2;
        if (e.v(l, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SummaryViewModel$feedback$2$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
