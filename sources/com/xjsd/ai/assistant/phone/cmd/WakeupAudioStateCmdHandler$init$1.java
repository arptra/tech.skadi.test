package com.xjsd.ai.assistant.phone.cmd;

import android.content.Context;
import com.xjmz.ai.voice.SpeakerVerificationType;
import com.xjmz.ai.voice.VoiceManager;
import com.xjsd.ai.assistant.core.ContextHelper;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.cmd.WakeupAudioStateCmdHandler$init$1", f = "WakeupAudioCmdHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupAudioStateCmdHandler$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WakeupAudioStateCmdHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupAudioStateCmdHandler$init$1(WakeupAudioStateCmdHandler wakeupAudioStateCmdHandler, Continuation<? super WakeupAudioStateCmdHandler$init$1> continuation) {
        super(2, continuation);
        this.this$0 = wakeupAudioStateCmdHandler;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupAudioStateCmdHandler$init$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            VoiceManager.Companion companion = VoiceManager.Companion;
            VoiceManager instance = companion.getInstance();
            Context a2 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
            instance.init(a2);
            WakeupAudioStateCmdHandler wakeupAudioStateCmdHandler = this.this$0;
            VoiceManager instance2 = companion.getInstance();
            Context a3 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getContext(...)");
            wakeupAudioStateCmdHandler.b = VoiceManager.spkRecogInit$default(instance2, a3, SpeakerVerificationType.SV_Wakeup, false, 4, (Object) null);
            this.this$0.c = true;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupAudioStateCmdHandler$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
