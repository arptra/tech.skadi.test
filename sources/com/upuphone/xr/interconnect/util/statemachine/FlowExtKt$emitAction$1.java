package com.upuphone.xr.interconnect.util.statemachine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFlowExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExt.kt\ncom/upuphone/xr/interconnect/util/statemachine/FlowExtKt$emitAction$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,29:1\n81#2,9:30\n*S KotlinDebug\n*F\n+ 1 FlowExt.kt\ncom/upuphone/xr/interconnect/util/statemachine/FlowExtKt$emitAction$1\n*L\n25#1:30,9\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.util.statemachine.FlowExtKt$emitAction$1", f = "FlowExt.kt", i = {0}, l = {34}, m = "invokeSuspend", n = {"$this$withPermit$iv"}, s = {"L$0"})
public final class FlowExtKt$emitAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ E $event;
    final /* synthetic */ Semaphore $lock;
    final /* synthetic */ MutableSharedFlow<E> $this_emitAction;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$emitAction$1(Semaphore semaphore, MutableSharedFlow<E> mutableSharedFlow, E e, Continuation<? super FlowExtKt$emitAction$1> continuation) {
        super(2, continuation);
        this.$lock = semaphore;
        this.$this_emitAction = mutableSharedFlow;
        this.$event = e;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FlowExtKt$emitAction$1(this.$lock, this.$this_emitAction, this.$event, continuation);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Semaphore semaphore;
        MutableSharedFlow<E> mutableSharedFlow;
        E e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Semaphore semaphore2 = this.$lock;
            mutableSharedFlow = this.$this_emitAction;
            E e2 = this.$event;
            this.L$0 = semaphore2;
            this.L$1 = mutableSharedFlow;
            this.L$2 = e2;
            this.label = 1;
            if (semaphore2.b(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            semaphore = semaphore2;
            e = e2;
        } else if (i == 1) {
            e = this.L$2;
            mutableSharedFlow = (MutableSharedFlow) this.L$1;
            semaphore = (Semaphore) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            FlowExtKt.emitOrErr(mutableSharedFlow, e);
            Unit unit = Unit.INSTANCE;
            semaphore.release();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            semaphore.release();
            throw th;
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowExtKt$emitAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
