package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager$sendStarryMessage$1", f = "TiciStarryMsgManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciStarryMsgManager$sendStarryMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StarryNetMessage $message;
    final /* synthetic */ SendMessageListener $messageListener;
    final /* synthetic */ StarryNetMessageOperator $messageOperator;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciStarryMsgManager$sendStarryMessage$1(StarryNetMessageOperator starryNetMessageOperator, StarryNetMessage starryNetMessage, SendMessageListener sendMessageListener, Continuation<? super TiciStarryMsgManager$sendStarryMessage$1> continuation) {
        super(2, continuation);
        this.$messageOperator = starryNetMessageOperator;
        this.$message = starryNetMessage;
        this.$messageListener = sendMessageListener;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciStarryMsgManager$sendStarryMessage$1(this.$messageOperator, this.$message, this.$messageListener, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StarryNetMessageOperator starryNetMessageOperator = this.$messageOperator;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.sendMessage2(this.$message, this.$messageListener);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciStarryMsgManager$sendStarryMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
