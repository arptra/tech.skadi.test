package com.upuphone.ar.transcribe.phone.repo;

import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1", f = "TranscribeAiRepo.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ AiSummaryEntity $this_apply;
    int label;
    final /* synthetic */ TranscribeAiRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1(TranscribeAiRepo transcribeAiRepo, AiSummaryEntity aiSummaryEntity, Continuation<? super TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeAiRepo;
        this.$this_apply = aiSummaryEntity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1(this.this$0, this.$this_apply, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TranscribeAiRepo transcribeAiRepo = this.this$0;
            AiSummaryEntity aiSummaryEntity = this.$this_apply;
            this.label = 1;
            obj = transcribeAiRepo.A(aiSummaryEntity, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Long> continuation) {
        return ((TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
