package com.upuphone.ai.ttsengine.engines.cloud;

import com.upuphone.ai.ttsengine.engines.cloud.Status;
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
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$handleAudio$1", f = "CloudEngine.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
public final class CloudEngine$handleAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Status.AudioData $data;
    int label;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$handleAudio$1(CloudEngine cloudEngine, Status.AudioData audioData, Continuation<? super CloudEngine$handleAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudEngine;
        this.$data = audioData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CloudEngine$handleAudio$1(this.this$0, this.$data, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.isAudioPlaying()) {
                this.this$0.getAiLog().c("synthesising but not in audio playing", new Object[0]);
                return Unit.INSTANCE;
            }
            if (this.this$0.channel != null) {
                Channel access$getChannel$p = this.this$0.channel;
                Intrinsics.checkNotNull(access$getChannel$p);
                if (!access$getChannel$p.A()) {
                    Channel access$getChannel$p2 = this.this$0.channel;
                    if (access$getChannel$p2 != null) {
                        Status.AudioData audioData = this.$data;
                        this.label = 1;
                        if (access$getChannel$p2.L(audioData, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            this.this$0.getAiLog().c("handle audio but channel closed", new Object[0]);
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CloudEngine$handleAudio$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
