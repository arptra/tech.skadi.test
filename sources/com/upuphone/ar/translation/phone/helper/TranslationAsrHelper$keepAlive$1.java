package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.ext.LogExt;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TranslationAsrHelper$keepAlive$1", f = "TranslationAsrHelper.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
public final class TranslationAsrHelper$keepAlive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationAsrHelper$keepAlive$1(long j, Continuation<? super TranslationAsrHelper$keepAlive$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslationAsrHelper$keepAlive$1(this.$delayTime, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            do {
                LogExt.f("keepAlive 持续保活数据灌输", "TranslationAsrHelper", "keepAlive_audio_xunfei", 0, 4, (Object) null);
                TranslationAsrHelper.f6306a.n();
                j = this.$delayTime;
                this.label = 1;
            } while (DelayKt.b(j, this) != coroutine_suspended);
            return coroutine_suspended;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslationAsrHelper$keepAlive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
