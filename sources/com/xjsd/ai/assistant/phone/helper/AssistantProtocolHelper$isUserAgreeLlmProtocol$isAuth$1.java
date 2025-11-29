package com.xjsd.ai.assistant.phone.helper;

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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1", f = "AssistantProtocolHelper.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1(Continuation<? super AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AssistantProtocolHelper assistantProtocolHelper = AssistantProtocolHelper.f8558a;
            this.label = 1;
            obj = assistantProtocolHelper.d(this);
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
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((AssistantProtocolHelper$isUserAgreeLlmProtocol$isAuth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
