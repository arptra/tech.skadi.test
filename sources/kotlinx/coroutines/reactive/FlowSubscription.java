package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@SourceDebugExtension({"SMAP\nReactiveFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/FlowSubscription\n+ 2 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,273:1\n163#2:274\n*S KotlinDebug\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/FlowSubscription\n*L\n212#1:274\n*E\n"})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B-\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0019\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00130 8\u0002X\u0004R\u000b\u0010#\u001a\u00020\"8\u0002X\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", "T", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V", "cancel", "()V", "", "n", "request", "(J)V", "Lkotlin/coroutines/Continuation;", "w1", "()Lkotlin/coroutines/Continuation;", "x1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v1", "d", "Lkotlinx/coroutines/flow/Flow;", "e", "Lorg/reactivestreams/Subscriber;", "", "cancellationRequested", "Z", "Lkotlinx/atomicfu/AtomicRef;", "producer", "Lkotlinx/atomicfu/AtomicLong;", "requested", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 8, 0})
@InternalCoroutinesApi
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    public static final AtomicLongFieldUpdater f;
    public static final AtomicReferenceFieldUpdater g;
    private volatile boolean cancellationRequested;
    public final Flow d;
    public final Subscriber e;
    @Volatile
    @Nullable
    private volatile Object producer = w1();
    @Volatile
    private volatile long requested;

    static {
        Class<FlowSubscription> cls = FlowSubscription.class;
        f = AtomicLongFieldUpdater.newUpdater(cls, "requested");
        g = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "producer");
    }

    public FlowSubscription(Flow flow, Subscriber subscriber, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.d = flow;
        this.e = subscriber;
    }

    public void cancel() {
        this.cancellationRequested = true;
        a((CancellationException) null);
    }

    public void request(long j) {
        long j2;
        long j3;
        Continuation continuation;
        if (j > 0) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            do {
                j2 = atomicLongFieldUpdater.get(this);
                j3 = j2 + j;
                if (j3 <= 0) {
                    j3 = LongCompanionObject.MAX_VALUE;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j3));
            if (j2 <= 0) {
                do {
                    continuation = (Continuation) g.getAndSet(this, (Object) null);
                } while (continuation == null);
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
            }
        }
    }

    public final Object v1(Continuation continuation) {
        Object collect = this.d.collect(new FlowSubscription$consumeFlow$2(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final Continuation w1() {
        return new FlowSubscription$createInitialContinuation$$inlined$Continuation$1(getCoroutineContext(), this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x1(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = (kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = new kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.reactive.FlowSubscription r4 = (kotlinx.coroutines.reactive.FlowSubscription) r4
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0045
        L_0x002d:
            r5 = move-exception
            goto L_0x0056
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r4.v1(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            org.reactivestreams.Subscriber r5 = r4.e     // Catch:{ all -> 0x004b }
            r5.onComplete()     // Catch:{ all -> 0x004b }
            goto L_0x0053
        L_0x004b:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r4 = r4.getCoroutineContext()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.a(r4, r5)
        L_0x0053:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0056:
            boolean r0 = r4.cancellationRequested
            if (r0 == 0) goto L_0x0066
            boolean r0 = r4.isActive()
            if (r0 != 0) goto L_0x0066
            java.util.concurrent.CancellationException r0 = r4.U()
            if (r5 == r0) goto L_0x0077
        L_0x0066:
            org.reactivestreams.Subscriber r0 = r4.e     // Catch:{ all -> 0x006c }
            r0.onError(r5)     // Catch:{ all -> 0x006c }
            goto L_0x0077
        L_0x006c:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r5, r0)
            kotlin.coroutines.CoroutineContext r4 = r4.getCoroutineContext()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.a(r4, r5)
        L_0x0077:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.FlowSubscription.x1(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
