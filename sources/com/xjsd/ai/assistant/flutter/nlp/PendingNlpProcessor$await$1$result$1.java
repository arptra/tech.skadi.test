package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.core.api.tts.TtsData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.PendingNlpProcessor$await$1$result$1", f = "PendingNlpProcessor.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class PendingNlpProcessor$await$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsData>, Object> {
    int label;
    final /* synthetic */ PendingNlpProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PendingNlpProcessor$await$1$result$1(PendingNlpProcessor pendingNlpProcessor, Continuation<? super PendingNlpProcessor$await$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = pendingNlpProcessor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PendingNlpProcessor$await$1$result$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Channel j = this.this$0.f8489a;
            this.label = 1;
            obj = j.K(this);
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
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super TtsData> continuation) {
        return ((PendingNlpProcessor$await$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
