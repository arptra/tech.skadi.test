package com.upuphone.xr.interconnect.util.statemachine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/util/statemachine/StartFlow;", "E", "Lkotlinx/coroutines/flow/Flow;", "startEvent", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StartFlow<E> implements Flow<E> {
    private final E startEvent;

    public StartFlow(E e) {
        this.startEvent = e;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector<? super E> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object emit = flowCollector.emit(this.startEvent, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}
