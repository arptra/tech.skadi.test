package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class FlowKt {
    public static final ReceiveChannel A(CoroutineScope coroutineScope, long j, long j2) {
        return FlowKt__DelayKt.a(coroutineScope, j, j2);
    }

    public static final Flow C(Function2 function2) {
        return FlowKt__BuildersKt.d(function2);
    }

    public static final Flow D(Object obj) {
        return FlowKt__BuildersKt.e(obj);
    }

    public static final Flow E(Object... objArr) {
        return FlowKt__BuildersKt.f(objArr);
    }

    public static final Object F(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.f(flow, continuation);
    }

    public static final Object G(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.g(flow, continuation);
    }

    public static final Flow H(Flow flow, Function2 function2) {
        return FlowKt__MergeKt.a(flow, function2);
    }

    public static final Flow I(Iterable iterable) {
        return FlowKt__MergeKt.b(iterable);
    }

    public static final Flow J(Flow... flowArr) {
        return FlowKt__MergeKt.c(flowArr);
    }

    public static final Flow K(Flow flow, Function3 function3) {
        return FlowKt__EmittersKt.d(flow, function3);
    }

    public static final Flow L(Flow flow, Function2 function2) {
        return FlowKt__TransformKt.b(flow, function2);
    }

    public static final Flow M(Flow flow, Function2 function2) {
        return FlowKt__EmittersKt.e(flow, function2);
    }

    public static final SharedFlow N(SharedFlow sharedFlow, Function2 function2) {
        return FlowKt__ShareKt.c(sharedFlow, function2);
    }

    public static final ReceiveChannel O(Flow flow, CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.e(flow, coroutineScope);
    }

    public static final Object P(Flow flow, Function3 function3, Continuation continuation) {
        return FlowKt__ReduceKt.h(flow, function3, continuation);
    }

    public static final Object Q(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.i(flow, continuation);
    }

    public static final Object R(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.j(flow, continuation);
    }

    public static final Flow S(Flow flow, Function2 function2) {
        return FlowKt__LimitKt.f(flow, function2);
    }

    public static final Object T(Flow flow, Collection collection, Continuation continuation) {
        return FlowKt__CollectionKt.a(flow, collection, continuation);
    }

    public static final Flow U(Flow flow, Function3 function3) {
        return FlowKt__MergeKt.d(flow, function3);
    }

    public static final Flow V(Flow flow) {
        return FlowKt__TransformKt.c(flow);
    }

    public static final Flow a(Iterable iterable) {
        return FlowKt__BuildersKt.a(iterable);
    }

    public static final SharedFlow b(MutableSharedFlow mutableSharedFlow) {
        return FlowKt__ShareKt.a(mutableSharedFlow);
    }

    public static final StateFlow c(MutableStateFlow mutableStateFlow) {
        return FlowKt__ShareKt.b(mutableStateFlow);
    }

    public static final Flow d(Flow flow, int i, BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.a(flow, i, bufferOverflow);
    }

    public static final Flow f(Function2 function2) {
        return FlowKt__BuildersKt.b(function2);
    }

    public static final Flow g(Flow flow, Function3 function3) {
        return FlowKt__ErrorsKt.a(flow, function3);
    }

    public static final Object h(Flow flow, FlowCollector flowCollector, Continuation continuation) {
        return FlowKt__ErrorsKt.b(flow, flowCollector, continuation);
    }

    public static final Flow i(Function2 function2) {
        return FlowKt__BuildersKt.c(function2);
    }

    public static final Object j(Flow flow, Continuation continuation) {
        return FlowKt__CollectKt.a(flow, continuation);
    }

    public static final Object k(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__CollectKt.b(flow, function2, continuation);
    }

    public static final Flow l(Flow flow) {
        return FlowKt__ContextKt.c(flow);
    }

    public static final Flow m(ReceiveChannel receiveChannel) {
        return FlowKt__ChannelsKt.b(receiveChannel);
    }

    public static final Object n(Flow flow, Continuation continuation) {
        return FlowKt__CountKt.a(flow, continuation);
    }

    public static final Object o(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__CountKt.b(flow, function2, continuation);
    }

    public static final Flow p(Flow flow) {
        return FlowKt__DistinctKt.a(flow);
    }

    public static final Flow q(Flow flow, int i) {
        return FlowKt__LimitKt.c(flow, i);
    }

    public static final Flow r(Flow flow, Function2 function2) {
        return FlowKt__LimitKt.d(flow, function2);
    }

    public static final Object s(FlowCollector flowCollector, ReceiveChannel receiveChannel, Continuation continuation) {
        return FlowKt__ChannelsKt.c(flowCollector, receiveChannel, continuation);
    }

    public static final Object t(FlowCollector flowCollector, Flow flow, Continuation continuation) {
        return FlowKt__CollectKt.c(flowCollector, flow, continuation);
    }

    public static final void u(FlowCollector flowCollector) {
        FlowKt__EmittersKt.b(flowCollector);
    }

    public static final Flow v(Flow flow) {
        return FlowKt__TransformKt.a(flow);
    }

    public static final Object w(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.a(flow, continuation);
    }

    public static final Object x(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__ReduceKt.b(flow, function2, continuation);
    }

    public static final Object y(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.c(flow, continuation);
    }

    public static final Object z(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__ReduceKt.d(flow, function2, continuation);
    }
}
