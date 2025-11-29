package com.upuphone.xr.sapp.vm;

import com.upuphone.xr.sapp.vm.RecordState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$playTts$2$1", f = "WakeupRecordingViewmodel.kt", i = {}, l = {159, 161}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordingViewmodel$playTts$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ WakeupRecordingViewmodel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordingViewmodel$playTts$2$1(WakeupRecordingViewmodel wakeupRecordingViewmodel, int i, Continuation<? super WakeupRecordingViewmodel$playTts$2$1> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordingViewmodel;
        this.$state = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordingViewmodel$playTts$2$1(this.this$0, this.$state, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow s = this.this$0.b;
            RecordState.Tts tts = new RecordState.Tts(this.$state);
            this.label = 1;
            if (s.emit(tts, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = this.$state;
        if (i2 == 1 || i2 == 2) {
            WakeupRecordingViewmodel wakeupRecordingViewmodel = this.this$0;
            this.label = 2;
            if (wakeupRecordingViewmodel.X(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordingViewmodel$playTts$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
