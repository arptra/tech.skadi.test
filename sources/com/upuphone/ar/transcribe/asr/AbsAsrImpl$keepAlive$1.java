package com.upuphone.ar.transcribe.asr;

import com.upuphone.ar.transcribe.ext.LogExt;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.asr.AbsAsrImpl$keepAlive$1", f = "AbsAsrImpl.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class AbsAsrImpl$keepAlive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AbsAsrImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsAsrImpl$keepAlive$1(AbsAsrImpl absAsrImpl, Continuation<? super AbsAsrImpl$keepAlive$1> continuation) {
        super(2, continuation);
        this.this$0 = absAsrImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AbsAsrImpl$keepAlive$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            do {
                LogExt.c("语音助理启动持续保活数据灌输", "AbsAsrImpl", "keepAlive_audio_xunfei", 0, false, 12, (Object) null);
                this.this$0.l();
                this.label = 1;
            } while (DelayKt.b(1000, this) != coroutine_suspended);
            return coroutine_suspended;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AbsAsrImpl$keepAlive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
