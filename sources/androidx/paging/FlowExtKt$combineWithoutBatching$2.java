package androidx.paging;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFlowExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExt.kt\nandroidx/paging/FlowExtKt$combineWithoutBatching$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,224:1\n13644#2,3:225\n*S KotlinDebug\n*F\n+ 1 FlowExt.kt\nandroidx/paging/FlowExtKt$combineWithoutBatching$2\n*L\n145#1:225,3\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Landroidx/paging/SimpleProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2", f = "FlowExt.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$combineWithoutBatching$2 extends SuspendLambda implements Function2<SimpleProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $otherFlow;
    final /* synthetic */ Flow<Object> $this_combineWithoutBatching;
    final /* synthetic */ Function4<Object, Object, CombineSource, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$combineWithoutBatching$2(Flow<Object> flow, Flow<Object> flow2, Function4<Object, Object, ? super CombineSource, ? super Continuation<Object>, ? extends Object> function4, Continuation<? super FlowExtKt$combineWithoutBatching$2> continuation) {
        super(2, continuation);
        this.$this_combineWithoutBatching = flow;
        this.$otherFlow = flow2;
        this.$transform = function4;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowExtKt$combineWithoutBatching$2 flowExtKt$combineWithoutBatching$2 = new FlowExtKt$combineWithoutBatching$2(this.$this_combineWithoutBatching, this.$otherFlow, this.$transform, continuation);
        flowExtKt$combineWithoutBatching$2.L$0 = obj;
        return flowExtKt$combineWithoutBatching$2;
    }

    @Nullable
    public final Object invoke(@NotNull SimpleProducerScope<Object> simpleProducerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowExtKt$combineWithoutBatching$2) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i = 0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(simpleProducerScope, this.$transform, (Continuation<? super FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1>) null));
            final CompletableJob b = JobKt__JobKt.b((Job) null, 1, (Object) null);
            Flow[] flowArr = {this.$this_combineWithoutBatching, this.$otherFlow};
            int i3 = 0;
            while (i < 2) {
                Job unused = BuildersKt__Builders_commonKt.d(simpleProducerScope, b, (CoroutineStart) null, new FlowExtKt$combineWithoutBatching$2$1$1(flowArr[i], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, i3, (Continuation<? super FlowExtKt$combineWithoutBatching$2$1$1>) null), 2, (Object) null);
                i++;
                i3++;
                flowArr = flowArr;
            }
            AnonymousClass2 r1 = new Function0<Unit>() {
                public final void invoke() {
                    Job.DefaultImpls.a(r13, (CancellationException) null, 1, (Object) null);
                }
            };
            this.label = 1;
            if (simpleProducerScope.f0(r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
        AtomicInteger atomicInteger = new AtomicInteger(2);
        UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(simpleProducerScope, this.$transform, (Continuation<? super FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1>) null));
        final CompletableJob b = JobKt__JobKt.b((Job) null, 1, (Object) null);
        Flow[] flowArr = {this.$this_combineWithoutBatching, this.$otherFlow};
        int i = 0;
        int i2 = 0;
        while (i2 < 2) {
            int i3 = i + 1;
            Job unused = BuildersKt__Builders_commonKt.d(simpleProducerScope, b, (CoroutineStart) null, new FlowExtKt$combineWithoutBatching$2$1$1(flowArr[i2], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, Integer.valueOf(i).intValue(), (Continuation<? super FlowExtKt$combineWithoutBatching$2$1$1>) null), 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            i2++;
            i = i3;
        }
        AnonymousClass2 r2 = new Function0<Unit>() {
            public final void invoke() {
                Job.DefaultImpls.a(b, (CancellationException) null, 1, (Object) null);
            }
        };
        InlineMarker.mark(0);
        simpleProducerScope.f0(r2, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
