package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.starrynet.msg.AutoTiciRunningMsg;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$handleAutoTiciRunningState$1", f = "TiciAppViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciAppViewModel$handleAutoTiciRunningState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AutoTiciRunningMsg $msg;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$handleAutoTiciRunningState$1(TiciAppViewModel ticiAppViewModel, AutoTiciRunningMsg autoTiciRunningMsg, Continuation<? super TiciAppViewModel$handleAutoTiciRunningState$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiAppViewModel;
        this.$msg = autoTiciRunningMsg;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$handleAutoTiciRunningState$1(this.this$0, this.$msg, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.E0(this.$msg.isFinish());
            this.this$0.F0(this.$msg.isRunning());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$handleAutoTiciRunningState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
