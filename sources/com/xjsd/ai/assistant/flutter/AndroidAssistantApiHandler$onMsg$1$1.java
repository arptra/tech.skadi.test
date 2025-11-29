package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
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
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler$onMsg$1$1", f = "AndroidAssistantApiHandler.kt", i = {}, l = {519}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidAssistantApiHandler$onMsg$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EndToEndResponse $response;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAssistantApiHandler$onMsg$1$1(EndToEndResponse endToEndResponse, Continuation<? super AndroidAssistantApiHandler$onMsg$1$1> continuation) {
        super(2, continuation);
        this.$response = endToEndResponse;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AndroidAssistantApiHandler$onMsg$1$1(this.$response, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NlpPreprocessorManager nlpPreprocessorManager = NlpPreprocessorManager.f8482a;
            EndToEndResponse endToEndResponse = this.$response;
            this.label = 1;
            obj = nlpPreprocessorManager.g(endToEndResponse, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AndroidAssistantApiHandler.INSTANCE.sendResToFlutter((AndroidAssistantApi.CloudResponse) obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AndroidAssistantApiHandler$onMsg$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
