package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B3\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0014J)\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\u00020\u001f8BX\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherAsFlow;", "", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lorg/reactivestreams/Publisher;", "publisher", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "h", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "g", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "n", "injectContext", "m", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lorg/reactivestreams/Publisher;", "", "o", "()J", "getRequestSize$annotations", "()V", "requestSize", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReactiveFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/PublisherAsFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
final class PublisherAsFlow<T> extends ChannelFlow<T> {
    public final Publisher d;

    public PublisherAsFlow(Publisher publisher, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.d = publisher;
    }

    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContext = this.f3888a;
        ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(key);
        if (continuationInterceptor == null || Intrinsics.areEqual((Object) continuationInterceptor, (Object) context.get(key))) {
            Object m = m(context.plus(this.f3888a), flowCollector, continuation);
            return m == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m : Unit.INSTANCE;
        }
        Object n = n(flowCollector, continuation);
        return n == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? n : Unit.INSTANCE;
    }

    public Object g(ProducerScope producerScope, Continuation continuation) {
        Object m = m(producerScope.getCoroutineContext(), new SendingCollector(producerScope.b()), continuation);
        return m == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m : Unit.INSTANCE;
    }

    public ChannelFlow h(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new PublisherAsFlow(this.d, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093 A[SYNTHETIC, Splitter:B:29:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(kotlin.coroutines.CoroutineContext r13, kotlinx.coroutines.flow.FlowCollector r14, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1 r0 = (kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1 r0 = new kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r6) goto L_0x0048
            if (r2 != r5) goto L_0x0040
            long r12 = r0.J$0
            java.lang.Object r14 = r0.L$2
            kotlinx.coroutines.reactive.ReactiveSubscriber r14 = (kotlinx.coroutines.reactive.ReactiveSubscriber) r14
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.reactive.PublisherAsFlow r7 = (kotlinx.coroutines.reactive.PublisherAsFlow) r7
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003d }
            goto L_0x00ab
        L_0x003d:
            r12 = move-exception
            goto L_0x00c1
        L_0x0040:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0048:
            long r12 = r0.J$0
            java.lang.Object r14 = r0.L$2
            kotlinx.coroutines.reactive.ReactiveSubscriber r14 = (kotlinx.coroutines.reactive.ReactiveSubscriber) r14
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.reactive.PublisherAsFlow r7 = (kotlinx.coroutines.reactive.PublisherAsFlow) r7
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003d }
            goto L_0x008b
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.reactive.ReactiveSubscriber r15 = new kotlinx.coroutines.reactive.ReactiveSubscriber
            int r2 = r12.b
            kotlinx.coroutines.channels.BufferOverflow r7 = r12.c
            long r8 = r12.o()
            r15.<init>(r2, r7, r8)
            org.reactivestreams.Publisher r2 = r12.d
            org.reactivestreams.Publisher r13 = kotlinx.coroutines.reactive.ReactiveFlowKt.a(r2, r13)
            r13.subscribe(r15)
            r13 = r14
            r14 = r15
        L_0x0075:
            r7 = r3
        L_0x0076:
            r0.L$0 = r12     // Catch:{ all -> 0x003d }
            r0.L$1 = r13     // Catch:{ all -> 0x003d }
            r0.L$2 = r14     // Catch:{ all -> 0x003d }
            r0.J$0 = r7     // Catch:{ all -> 0x003d }
            r0.label = r6     // Catch:{ all -> 0x003d }
            java.lang.Object r15 = r14.c(r0)     // Catch:{ all -> 0x003d }
            if (r15 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r2 = r13
            r10 = r7
            r7 = r12
            r12 = r10
        L_0x008b:
            if (r15 != 0) goto L_0x0093
            r14.a()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0093:
            kotlin.coroutines.CoroutineContext r8 = r0.getContext()     // Catch:{ all -> 0x003d }
            kotlinx.coroutines.JobKt.i(r8)     // Catch:{ all -> 0x003d }
            r0.L$0 = r7     // Catch:{ all -> 0x003d }
            r0.L$1 = r2     // Catch:{ all -> 0x003d }
            r0.L$2 = r14     // Catch:{ all -> 0x003d }
            r0.J$0 = r12     // Catch:{ all -> 0x003d }
            r0.label = r5     // Catch:{ all -> 0x003d }
            java.lang.Object r15 = r2.emit(r15, r0)     // Catch:{ all -> 0x003d }
            if (r15 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            r8 = 1
            long r12 = r12 + r8
            long r8 = r7.o()     // Catch:{ all -> 0x003d }
            int r15 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r15 != 0) goto L_0x00bc
            r14.b()     // Catch:{ all -> 0x003d }
            r13 = r2
            r12 = r7
            goto L_0x0075
        L_0x00bc:
            r10 = r12
            r13 = r2
            r12 = r7
            r7 = r10
            goto L_0x0076
        L_0x00c1:
            r14.a()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherAsFlow.m(kotlin.coroutines.CoroutineContext, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object n(FlowCollector flowCollector, Continuation continuation) {
        Object f = CoroutineScopeKt.f(new PublisherAsFlow$collectSlowPath$2(flowCollector, this, (Continuation<? super PublisherAsFlow$collectSlowPath$2>) null), continuation);
        return f == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? f : Unit.INSTANCE;
    }

    public final long o() {
        if (this.c != BufferOverflow.SUSPEND) {
            return LongCompanionObject.MAX_VALUE;
        }
        int i = this.b;
        if (i == -2) {
            return (long) Channel.c0.a();
        }
        if (i == 0) {
            return 1;
        }
        if (i == Integer.MAX_VALUE) {
            return LongCompanionObject.MAX_VALUE;
        }
        long j = (long) i;
        if (j >= 1) {
            return j;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
