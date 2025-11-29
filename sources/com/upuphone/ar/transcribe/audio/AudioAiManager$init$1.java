package com.upuphone.ar.transcribe.audio;

import android.content.Context;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.audio.AudioAiManager$init$1", f = "AudioAiManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioAiManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ AudioAiManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioAiManager$init$1(AudioAiManager audioAiManager, Context context, Continuation<? super AudioAiManager$init$1> continuation) {
        super(2, continuation);
        this.this$0 = audioAiManager;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AudioAiManager$init$1(this.this$0, this.$context, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.o = TranscribeManager.j.a().l();
            this.this$0.q(this.$context);
            this.this$0.h = false;
            this.this$0.s();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AudioAiManager$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
