package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.phone.helper.TtsToGlassHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TtsToGlassHelper$sendReminderTtsData$1", f = "TtsToGlassHelper.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
public final class TtsToGlassHelper$sendReminderTtsData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TtsToGlassHelper.OpusTtsData $opusTts;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsToGlassHelper$sendReminderTtsData$1(TtsToGlassHelper.OpusTtsData opusTtsData, Continuation<? super TtsToGlassHelper$sendReminderTtsData$1> continuation) {
        super(2, continuation);
        this.$opusTts = opusTtsData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsToGlassHelper$sendReminderTtsData$1(this.$opusTts, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Channel b = TtsToGlassHelper.f;
            TtsToGlassHelper.OpusTtsData opusTtsData = this.$opusTts;
            this.label = 1;
            if (b.L(opusTtsData, this) == coroutine_suspended) {
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
        return ((TtsToGlassHelper$sendReminderTtsData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
