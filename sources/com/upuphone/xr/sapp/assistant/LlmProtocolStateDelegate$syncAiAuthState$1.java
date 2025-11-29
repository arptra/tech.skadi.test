package com.upuphone.xr.sapp.assistant;

import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.entity.AccountInfo;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate$syncAiAuthState$1", f = "LlmProtocolStateDelegate.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
public final class LlmProtocolStateDelegate$syncAiAuthState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $action;
    int label;
    final /* synthetic */ LlmProtocolStateDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LlmProtocolStateDelegate$syncAiAuthState$1(LlmProtocolStateDelegate llmProtocolStateDelegate, int i, Continuation<? super LlmProtocolStateDelegate$syncAiAuthState$1> continuation) {
        super(2, continuation);
        this.this$0 = llmProtocolStateDelegate;
        this.$action = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LlmProtocolStateDelegate$syncAiAuthState$1(this.this$0, this.$action, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AccountInfo a2 = MzAccountManager.c.a();
            String id = a2 != null ? a2.getId() : null;
            LlmProtocolStateDelegate llmProtocolStateDelegate = this.this$0;
            int i2 = this.$action;
            this.label = 1;
            if (llmProtocolStateDelegate.t(id, i2, this) == coroutine_suspended) {
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
        return ((LlmProtocolStateDelegate$syncAiAuthState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
