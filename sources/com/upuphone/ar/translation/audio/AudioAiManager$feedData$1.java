package com.upuphone.ar.translation.audio;

import java.util.Arrays;
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
@DebugMetadata(c = "com.upuphone.ar.translation.audio.AudioAiManager$feedData$1", f = "AudioAiManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioAiManager$feedData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ boolean $isMono;
    final /* synthetic */ boolean $isRoleSeparate;
    final /* synthetic */ float[] $roleVprintArray;
    int label;
    final /* synthetic */ AudioAiManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioAiManager$feedData$1(boolean z, AudioAiManager audioAiManager, byte[] bArr, boolean z2, float[] fArr, Continuation<? super AudioAiManager$feedData$1> continuation) {
        super(2, continuation);
        this.$isMono = z;
        this.this$0 = audioAiManager;
        this.$bytes = bArr;
        this.$isRoleSeparate = z2;
        this.$roleVprintArray = fArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AudioAiManager$feedData$1(this.$isMono, this.this$0, this.$bytes, this.$isRoleSeparate, this.$roleVprintArray, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isMono) {
                AudioAiManager audioAiManager = this.this$0;
                byte[] bArr = this.$bytes;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                AudioAiManager.v(audioAiManager, copyOf, 0, this.$isRoleSeparate, this.$roleVprintArray, 2, (Object) null);
            } else {
                AudioAiManager audioAiManager2 = this.this$0;
                byte[] bArr2 = this.$bytes;
                byte[] copyOf2 = Arrays.copyOf(bArr2, bArr2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                AudioAiManager.t(audioAiManager2, copyOf2, 0, 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AudioAiManager$feedData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
