package com.upuphone.ai.ttsengine.engines.cloud;

import com.upuphone.ai.ttsengine.base.player.PcmPlayer;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$onPlayError$1", f = "CloudEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CloudEngine$onPlayError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$onPlayError$1(CloudEngine cloudEngine, Continuation<? super CloudEngine$onPlayError$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudEngine;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CloudEngine$onPlayError$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getAiLog().c("playing unLock", new Object[0]);
            this.this$0.pendingText.clear();
            this.this$0.pendingText = new ArrayList();
            this.this$0.requestSize = 0;
            this.this$0.playedSize = 0;
            this.this$0.speakingText = "";
            PcmPlayer access$getAudioPlayer$p = this.this$0.audioPlayer;
            if (access$getAudioPlayer$p != null) {
                access$getAudioPlayer$p.j();
            }
            this.this$0.audioPlayer = null;
            this.this$0.releaseChannel();
            this.this$0.scheduleCloseWS(false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CloudEngine$onPlayError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
