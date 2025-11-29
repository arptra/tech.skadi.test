package com.upuphone.ar.translation.audio;

import com.upuphone.ar.translation.ext.LogExt;
import com.xjsd.ai.voice.VoiceAdapter;
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
@DebugMetadata(c = "com.upuphone.ar.translation.audio.AudioAiManager$reset$1", f = "AudioAiManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioAiManager$reset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioAiManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioAiManager$reset$1(AudioAiManager audioAiManager, Continuation<? super AudioAiManager$reset$1> continuation) {
        super(2, continuation);
        this.this$0 = audioAiManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AudioAiManager$reset$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.z()) {
                LogExt.j("重置音频降噪引擎数据异常", "AudioAiManager");
                return Unit.INSTANCE;
            }
            VoiceAdapter b = this.this$0.b;
            if (b != null) {
                b.Reset();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AudioAiManager$reset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
