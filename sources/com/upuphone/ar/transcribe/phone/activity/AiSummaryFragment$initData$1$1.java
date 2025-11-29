package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.vm.SummaryViewModel;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.AiSummaryFragment$initData$1$1", f = "AiSummaryFragment.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class AiSummaryFragment$initData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TranscribeBean $it;
    int label;
    final /* synthetic */ AiSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiSummaryFragment$initData$1$1(AiSummaryFragment aiSummaryFragment, TranscribeBean transcribeBean, Continuation<? super AiSummaryFragment$initData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = aiSummaryFragment;
        this.$it = transcribeBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiSummaryFragment$initData$1$1(this.this$0, this.$it, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SummaryViewModel access$getSummaryViewModel = this.this$0.getSummaryViewModel();
            TranscribeBean transcribeBean = this.$it;
            this.label = 1;
            if (access$getSummaryViewModel.m(transcribeBean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AiSummaryFragment$initData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
