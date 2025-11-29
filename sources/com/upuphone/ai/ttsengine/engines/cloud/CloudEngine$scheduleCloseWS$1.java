package com.upuphone.ai.ttsengine.engines.cloud;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$scheduleCloseWS$1", f = "CloudEngine.kt", i = {}, l = {499}, m = "invokeSuspend", n = {}, s = {})
public final class CloudEngine$scheduleCloseWS$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $delay;
    int label;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$scheduleCloseWS$1(CloudEngine cloudEngine, boolean z, Continuation<? super CloudEngine$scheduleCloseWS$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudEngine;
        this.$delay = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CloudEngine$scheduleCloseWS$1(this.this$0, this.$delay, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getAiLog().c("start close timer", new Object[0]);
            if (this.$delay) {
                this.label = 1;
                if (DelayKt.b(10000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TtsWebsocket access$getWebSocket$p = this.this$0.webSocket;
        if (access$getWebSocket$p != null) {
            access$getWebSocket$p.disconnect();
        }
        this.this$0.webSocket = null;
        this.this$0.getAiLog().c("websocket closed", new Object[0]);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CloudEngine$scheduleCloseWS$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
