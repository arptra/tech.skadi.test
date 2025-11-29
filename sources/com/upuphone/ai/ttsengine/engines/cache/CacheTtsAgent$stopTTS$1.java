package com.upuphone.ai.ttsengine.engines.cache;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cache.CacheTtsAgent$stopTTS$1", f = "CacheTtsAgent.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class CacheTtsAgent$stopTTS$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CacheTtsAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CacheTtsAgent$stopTTS$1(CacheTtsAgent cacheTtsAgent, Continuation<? super CacheTtsAgent$stopTTS$1> continuation) {
        super(2, continuation);
        this.this$0 = cacheTtsAgent;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CacheTtsAgent$stopTTS$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job access$getPlayingJob$p = this.this$0.playingJob;
            if (access$getPlayingJob$p == null) {
                return null;
            }
            this.label = 1;
            if (JobKt.f(access$getPlayingJob$p, this) == coroutine_suspended) {
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
        return ((CacheTtsAgent$stopTTS$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
