package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.dispatcher.MessageDispatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.messenger.MainMessageDispatcher$dispatch$1$1$1", f = "MainMessageDispatcher.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
public final class MainMessageDispatcher$dispatch$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isDispatched;
    final /* synthetic */ MessageDispatcher $it;
    final /* synthetic */ StarryNetMessage $message;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainMessageDispatcher$dispatch$1$1$1(Ref.BooleanRef booleanRef, MessageDispatcher messageDispatcher, StarryNetMessage starryNetMessage, Continuation<? super MainMessageDispatcher$dispatch$1$1$1> continuation) {
        super(2, continuation);
        this.$isDispatched = booleanRef;
        this.$it = messageDispatcher;
        this.$message = starryNetMessage;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MainMessageDispatcher$dispatch$1$1$1(this.$isDispatched, this.$it, this.$message, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = this.$isDispatched;
            MessageDispatcher messageDispatcher = this.$it;
            StarryNetMessage starryNetMessage = this.$message;
            this.L$0 = booleanRef2;
            this.label = 1;
            Object dispatch = messageDispatcher.dispatch(starryNetMessage, this);
            if (dispatch == coroutine_suspended) {
                return coroutine_suspended;
            }
            Ref.BooleanRef booleanRef3 = booleanRef2;
            obj = dispatch;
            booleanRef = booleanRef3;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        booleanRef.element = ((Boolean) obj).booleanValue();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MainMessageDispatcher$dispatch$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
