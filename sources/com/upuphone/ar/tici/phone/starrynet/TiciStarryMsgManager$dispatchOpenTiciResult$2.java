package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.data.OpenTiciConfig;
import com.upuphone.ar.tici.phone.data.OpenTiciConfigKt;
import com.upuphone.ar.tici.phone.data.OpenTiciResult;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager$dispatchOpenTiciResult$2", f = "TiciStarryMsgManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciStarryMsgManager$dispatchOpenTiciResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    int label;
    final /* synthetic */ TiciStarryMsgManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciStarryMsgManager$dispatchOpenTiciResult$2(TiciStarryMsgManager ticiStarryMsgManager, int i, Continuation<? super TiciStarryMsgManager$dispatchOpenTiciResult$2> continuation) {
        super(2, continuation);
        this.this$0 = ticiStarryMsgManager;
        this.$code = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciStarryMsgManager$dispatchOpenTiciResult$2(this.this$0, this.$code, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            OpenTiciConfig access$getWaitingTiciConfig$p = this.this$0.waitingTiciConfig;
            if (access$getWaitingTiciConfig$p != null) {
                this.this$0.dispatchOpenTiciResult(new OpenTiciResult(access$getWaitingTiciConfig$p.d(), this.$code, OpenTiciConfigKt.b(access$getWaitingTiciConfig$p), access$getWaitingTiciConfig$p.c()));
            }
            this.this$0.waitingTiciConfig = null;
            this.this$0._impatientTiciData.setValue((Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciStarryMsgManager$dispatchOpenTiciResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
