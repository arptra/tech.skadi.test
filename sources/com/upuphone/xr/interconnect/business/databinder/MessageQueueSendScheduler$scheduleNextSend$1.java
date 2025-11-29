package com.upuphone.xr.interconnect.business.databinder;

import android.os.SystemClock;
import com.upuphone.xr.interconnect.util.statemachine.FlowExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.databinder.MessageQueueSendScheduler$scheduleNextSend$1", f = "MessageQueueSendScheduler.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class MessageQueueSendScheduler$scheduleNextSend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $targetSendTime;
    int label;
    final /* synthetic */ MessageQueueSendScheduler<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageQueueSendScheduler$scheduleNextSend$1(long j, MessageQueueSendScheduler<E> messageQueueSendScheduler, Continuation<? super MessageQueueSendScheduler$scheduleNextSend$1> continuation) {
        super(2, continuation);
        this.$targetSendTime = j;
        this.this$0 = messageQueueSendScheduler;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MessageQueueSendScheduler$scheduleNextSend$1(this.$targetSendTime, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long coerceAtLeast = RangesKt.coerceAtLeast(this.$targetSendTime - SystemClock.uptimeMillis(), 0);
            this.label = 1;
            if (DelayKt.b(coerceAtLeast, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FlowExtKt.emitOrErr(this.this$0.flow, this.this$0.sendEvent);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MessageQueueSendScheduler$scheduleNextSend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
