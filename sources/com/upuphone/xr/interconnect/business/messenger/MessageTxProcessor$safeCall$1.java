package com.upuphone.xr.interconnect.business.messenger;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$safeCall$1", f = "MessageTxProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageTxProcessor$safeCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<IMessageSendListener, Unit> $action;
    final /* synthetic */ IMessageSendListener $this_safeCall;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageTxProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageTxProcessor$safeCall$1(Function1<? super IMessageSendListener, Unit> function1, IMessageSendListener iMessageSendListener, MessageTxProcessor messageTxProcessor, Continuation<? super MessageTxProcessor$safeCall$1> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.$this_safeCall = iMessageSendListener;
        this.this$0 = messageTxProcessor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MessageTxProcessor$safeCall$1 messageTxProcessor$safeCall$1 = new MessageTxProcessor$safeCall$1(this.$action, this.$this_safeCall, this.this$0, continuation);
        messageTxProcessor$safeCall$1.L$0 = obj;
        return messageTxProcessor$safeCall$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                this.$action.invoke(this.$this_safeCall);
            } catch (RemoteException e) {
                String access$getTag = this.this$0.getTag();
                String localizedMessage = e.getLocalizedMessage();
                ILog.d(access$getTag, "Remote callback failed because of " + localizedMessage + " on " + coroutineScope + "!");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MessageTxProcessor$safeCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
