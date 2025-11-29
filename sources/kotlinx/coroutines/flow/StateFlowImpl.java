package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030!2\u0006\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\b\"\u0010#J-\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010+J!\u0010.\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010\u000fR\u0016\u00101\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u0017\u001a\u0004\b2\u00103\"\u0004\b4\u0010\nR\u0011\u00107\u001a\b\u0012\u0004\u0012\u00020\u0007068\u0002X\u0004\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "value", "b", "(Ljava/lang/Object;)Z", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "()V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "n", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "d", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "expectedState", "newState", "o", "e", "I", "sequence", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "Lkotlinx/atomicfu/AtomicRef;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,428:1\n18#2:429\n18#2:443\n28#3,4:430\n28#3,4:437\n20#4:434\n20#4:441\n13579#5,2:435\n329#6:442\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n315#1:429\n396#1:443\n324#1:430,4\n352#1:437,4\n324#1:434\n352#1:441\n348#1:435,2\n385#1:442\n*E\n"})
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    @Volatile
    @Nullable
    private volatile Object _state;
    public int e;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    public void a() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public boolean b(Object obj) {
        setValue(obj);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: kotlinx.coroutines.flow.StateFlowSlot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: type inference failed for: r12v14, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c3 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c5 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d8 A[Catch:{ all -> 0x0078 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d9 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e4 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x007d
            if (r2 == r6) goto L_0x0066
            if (r2 == r5) goto L_0x004f
            if (r2 != r4) goto L_0x0047
            java.lang.Object r10 = r0.L$4
            java.lang.Object r11 = r0.L$3
            kotlinx.coroutines.Job r11 = (kotlinx.coroutines.Job) r11
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r2 = (kotlinx.coroutines.flow.StateFlowSlot) r2
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r7 = (kotlinx.coroutines.flow.StateFlowImpl) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0044 }
            r12 = r10
            r10 = r7
            goto L_0x00ac
        L_0x0044:
            r10 = move-exception
            goto L_0x00f7
        L_0x0047:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x004f:
            java.lang.Object r10 = r0.L$4
            java.lang.Object r11 = r0.L$3
            kotlinx.coroutines.Job r11 = (kotlinx.coroutines.Job) r11
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r2 = (kotlinx.coroutines.flow.StateFlowSlot) r2
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r7 = (kotlinx.coroutines.flow.StateFlowImpl) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0044 }
            goto L_0x00dc
        L_0x0066:
            java.lang.Object r10 = r0.L$2
            r2 = r10
            kotlinx.coroutines.flow.StateFlowSlot r2 = (kotlinx.coroutines.flow.StateFlowSlot) r2
            java.lang.Object r10 = r0.L$1
            r11 = r10
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r10 = (kotlinx.coroutines.flow.StateFlowImpl) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0078 }
            goto L_0x009d
        L_0x0078:
            r11 = move-exception
            r7 = r10
            r10 = r11
            goto L_0x00f7
        L_0x007d:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r12 = r10.g()
            r2 = r12
            kotlinx.coroutines.flow.StateFlowSlot r2 = (kotlinx.coroutines.flow.StateFlowSlot) r2
            boolean r12 = r11 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x0078 }
            if (r12 == 0) goto L_0x009d
            r12 = r11
            kotlinx.coroutines.flow.SubscribedFlowCollector r12 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r12     // Catch:{ all -> 0x0078 }
            r0.L$0 = r10     // Catch:{ all -> 0x0078 }
            r0.L$1 = r11     // Catch:{ all -> 0x0078 }
            r0.L$2 = r2     // Catch:{ all -> 0x0078 }
            r0.label = r6     // Catch:{ all -> 0x0078 }
            java.lang.Object r12 = r12.d(r0)     // Catch:{ all -> 0x0078 }
            if (r12 != r1) goto L_0x009d
            return r1
        L_0x009d:
            kotlin.coroutines.CoroutineContext r12 = r0.getContext()     // Catch:{ all -> 0x0078 }
            kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.b0     // Catch:{ all -> 0x0078 }
            kotlin.coroutines.CoroutineContext$Element r12 = r12.get(r6)     // Catch:{ all -> 0x0078 }
            kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12     // Catch:{ all -> 0x0078 }
            r6 = r11
            r11 = r12
            r12 = r3
        L_0x00ac:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = f     // Catch:{ all -> 0x0078 }
            java.lang.Object r7 = r7.get(r10)     // Catch:{ all -> 0x0078 }
            if (r11 == 0) goto L_0x00b7
            kotlinx.coroutines.JobKt.j(r11)     // Catch:{ all -> 0x0078 }
        L_0x00b7:
            if (r12 == 0) goto L_0x00bf
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r7)     // Catch:{ all -> 0x0078 }
            if (r8 != 0) goto L_0x00de
        L_0x00bf:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f3899a     // Catch:{ all -> 0x0078 }
            if (r7 != r12) goto L_0x00c5
            r12 = r3
            goto L_0x00c6
        L_0x00c5:
            r12 = r7
        L_0x00c6:
            r0.L$0 = r10     // Catch:{ all -> 0x0078 }
            r0.L$1 = r6     // Catch:{ all -> 0x0078 }
            r0.L$2 = r2     // Catch:{ all -> 0x0078 }
            r0.L$3 = r11     // Catch:{ all -> 0x0078 }
            r0.L$4 = r7     // Catch:{ all -> 0x0078 }
            r0.label = r5     // Catch:{ all -> 0x0078 }
            java.lang.Object r12 = r6.emit(r12, r0)     // Catch:{ all -> 0x0078 }
            if (r12 != r1) goto L_0x00d9
            return r1
        L_0x00d9:
            r9 = r7
            r7 = r10
            r10 = r9
        L_0x00dc:
            r12 = r10
            r10 = r7
        L_0x00de:
            boolean r7 = r2.h()     // Catch:{ all -> 0x0078 }
            if (r7 != 0) goto L_0x00ac
            r0.L$0 = r10     // Catch:{ all -> 0x0078 }
            r0.L$1 = r6     // Catch:{ all -> 0x0078 }
            r0.L$2 = r2     // Catch:{ all -> 0x0078 }
            r0.L$3 = r11     // Catch:{ all -> 0x0078 }
            r0.L$4 = r12     // Catch:{ all -> 0x0078 }
            r0.label = r4     // Catch:{ all -> 0x0078 }
            java.lang.Object r7 = r2.e(r0)     // Catch:{ all -> 0x0078 }
            if (r7 != r1) goto L_0x00ac
            return r1
        L_0x00f7:
            r7.j(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean compareAndSet(Object obj, Object obj2) {
        if (obj == null) {
            obj = NullSurrogateKt.f3899a;
        }
        if (obj2 == null) {
            obj2 = NullSurrogateKt.f3899a;
        }
        return o(obj, obj2);
    }

    public Flow d(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.d(this, coroutineContext, i, bufferOverflow);
    }

    public Object emit(Object obj, Continuation continuation) {
        setValue(obj);
        return Unit.INSTANCE;
    }

    public Object getValue() {
        Symbol symbol = NullSurrogateKt.f3899a;
        Object obj = f.get(this);
        if (obj == symbol) {
            return null;
        }
        return obj;
    }

    /* renamed from: m */
    public StateFlowSlot h() {
        return new StateFlowSlot();
    }

    /* renamed from: n */
    public StateFlowSlot[] i(int i) {
        return new StateFlowSlot[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r8 == null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r1 = r8.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        if (r2 >= r1) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r4 = r8[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        if (r4 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        r4.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r8 = r6.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        if (r8 != r7) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0046, code lost:
        r6.e = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0049, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r7 = l();
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0053, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0054, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean o(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            r0 = 1
            monitor-enter(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f     // Catch:{ all -> 0x0013 }
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0013 }
            r3 = 0
            if (r7 == 0) goto L_0x0015
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)     // Catch:{ all -> 0x0013 }
            if (r7 != 0) goto L_0x0015
            monitor-exit(r6)
            return r3
        L_0x0013:
            r7 = move-exception
            goto L_0x0060
        L_0x0015:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r8)     // Catch:{ all -> 0x0013 }
            if (r7 == 0) goto L_0x001d
            monitor-exit(r6)
            return r0
        L_0x001d:
            r1.set(r6, r8)     // Catch:{ all -> 0x0013 }
            int r7 = r6.e     // Catch:{ all -> 0x0013 }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x005a
            int r7 = r7 + r0
            r6.e = r7     // Catch:{ all -> 0x0013 }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r8 = r6.l()     // Catch:{ all -> 0x0013 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0013 }
            monitor-exit(r6)
        L_0x0030:
            kotlinx.coroutines.flow.StateFlowSlot[] r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8
            if (r8 == 0) goto L_0x0041
            int r1 = r8.length
            r2 = r3
        L_0x0036:
            if (r2 >= r1) goto L_0x0041
            r4 = r8[r2]
            if (r4 == 0) goto L_0x003f
            r4.g()
        L_0x003f:
            int r2 = r2 + r0
            goto L_0x0036
        L_0x0041:
            monitor-enter(r6)
            int r8 = r6.e     // Catch:{ all -> 0x004b }
            if (r8 != r7) goto L_0x004d
            int r7 = r7 + r0
            r6.e = r7     // Catch:{ all -> 0x004b }
            monitor-exit(r6)
            return r0
        L_0x004b:
            r7 = move-exception
            goto L_0x0058
        L_0x004d:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r6.l()     // Catch:{ all -> 0x004b }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0030
        L_0x0058:
            monitor-exit(r6)
            throw r7
        L_0x005a:
            int r7 = r7 + 2
            r6.e = r7     // Catch:{ all -> 0x0013 }
            monitor-exit(r6)
            return r0
        L_0x0060:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.o(java.lang.Object, java.lang.Object):boolean");
    }

    public void setValue(Object obj) {
        if (obj == null) {
            obj = NullSurrogateKt.f3899a;
        }
        o((Object) null, obj);
    }
}
