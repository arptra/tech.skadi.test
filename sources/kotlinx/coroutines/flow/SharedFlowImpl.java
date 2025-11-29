package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001tB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001e2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J/\u0010.\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010\u0015J\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u001a2\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0001\u00102J\u0017\u00103\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0004\u0018\u00010\u001a2\u0006\u00105\u001a\u00020\u0016H\u0002¢\u0006\u0004\b6\u00107J\u001b\u00108\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b8\u00109J3\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001e2\u0014\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001eH\u0002¢\u0006\u0004\b<\u0010=J!\u0010A\u001a\u00020@2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\bC\u0010\u0011J\u001b\u0010D\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\bD\u0010%J\u000f\u0010E\u001a\u00020\u0016H\u0000¢\u0006\u0004\bE\u0010FJ%\u0010H\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001e2\u0006\u0010G\u001a\u00020\u0016H\u0000¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0003H\u0014¢\u0006\u0004\bJ\u0010KJ\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001e2\u0006\u0010L\u001a\u00020\u0007H\u0014¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0013H\u0016¢\u0006\u0004\bO\u0010\u0015J-\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000S2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bT\u0010UR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010WR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR \u0010]\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010_R\u0016\u0010d\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010WR\u0016\u0010f\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010WR\u0014\u0010g\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010FR\u0014\u0010j\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010l\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010iR\u0014\u0010m\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\bW\u0010FR\u0014\u0010o\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\bn\u0010FR\u001a\u0010s\u001a\u00028\u00008DX\u0004¢\u0006\f\u0012\u0004\br\u0010\u0015\u001a\u0004\bp\u0010q\u0002\u0004\n\u0002\b\u0019¨\u0006u"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "value", "", "Q", "(Ljava/lang/Object;)Z", "R", "", "D", "()V", "", "newHead", "A", "(J)V", "", "item", "G", "(Ljava/lang/Object;)V", "", "curBuffer", "curSize", "newSize", "P", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "F", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "x", "(Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "U", "(JJJJ)V", "y", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)Ljava/lang/Object;", "S", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)J", "index", "L", "(J)Ljava/lang/Object;", "w", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "resumesIn", "H", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "emit", "W", "()J", "oldIndex", "V", "(J)[Lkotlin/coroutines/Continuation;", "B", "()Lkotlinx/coroutines/flow/SharedFlowSlot;", "size", "C", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "a", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "d", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "e", "I", "f", "g", "Lkotlinx/coroutines/channels/BufferOverflow;", "h", "[Ljava/lang/Object;", "buffer", "i", "J", "replayIndex", "j", "minCollectorIndex", "k", "bufferSize", "l", "queueSize", "head", "N", "()I", "replaySize", "O", "totalSize", "bufferEndIndex", "M", "queueEndIndex", "K", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "lastReplayedLocked", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public final int e;
    public final int f;
    public final BufferOverflow g;
    public Object[] h;
    public long i;
    public long j;
    public int k;
    public int l;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "index", "", "value", "Lkotlin/coroutines/Continuation;", "", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "()V", "a", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "b", "J", "c", "Ljava/lang/Object;", "d", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class Emitter implements DisposableHandle {

        /* renamed from: a  reason: collision with root package name */
        public final SharedFlowImpl f3875a;
        public long b;
        public final Object c;
        public final Continuation d;

        public Emitter(SharedFlowImpl sharedFlowImpl, long j, Object obj, Continuation continuation) {
            this.f3875a = sharedFlowImpl;
            this.b = j;
            this.c = obj;
            this.d = continuation;
        }

        public void dispose() {
            this.f3875a.x(this);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlinx.coroutines.channels.BufferOverflow[] r0 = kotlinx.coroutines.channels.BufferOverflow.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.WhenMappings.<clinit>():void");
        }
    }

    public SharedFlowImpl(int i2, int i3, BufferOverflow bufferOverflow) {
        this.e = i2;
        this.f = i3;
        this.g = bufferOverflow;
    }

    public static /* synthetic */ Object E(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        if (sharedFlowImpl.b(obj)) {
            return Unit.INSTANCE;
        }
        Object F = sharedFlowImpl.F(obj, continuation);
        return F == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? F : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: kotlinx.coroutines.flow.SharedFlowSlot} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c6 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object z(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r5) goto L_0x005f
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x003f }
            goto L_0x005b
        L_0x003f:
            r8 = move-exception
            goto L_0x00dc
        L_0x0042:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004a:
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
            goto L_0x003b
        L_0x005b:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x00a9
        L_0x005f:
            java.lang.Object r8 = r0.L$2
            r9 = r8
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r2 = (kotlinx.coroutines.flow.SharedFlowImpl) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0072 }
            r10 = r8
            r8 = r2
            goto L_0x009d
        L_0x0072:
            r8 = move-exception
            r5 = r2
            goto L_0x00dc
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r10 = r8.g()
            kotlinx.coroutines.flow.SharedFlowSlot r10 = (kotlinx.coroutines.flow.SharedFlowSlot) r10
            boolean r2 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x009a
            r2 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x0095 }
            r0.L$0 = r8     // Catch:{ all -> 0x0095 }
            r0.L$1 = r9     // Catch:{ all -> 0x0095 }
            r0.L$2 = r10     // Catch:{ all -> 0x0095 }
            r0.label = r5     // Catch:{ all -> 0x0095 }
            java.lang.Object r2 = r2.d(r0)     // Catch:{ all -> 0x0095 }
            if (r2 != r1) goto L_0x009a
            return r1
        L_0x0095:
            r9 = move-exception
            r5 = r8
            r8 = r9
            r9 = r10
            goto L_0x00dc
        L_0x009a:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x009d:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()     // Catch:{ all -> 0x00c2 }
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.b0     // Catch:{ all -> 0x00c2 }
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r5)     // Catch:{ all -> 0x00c2 }
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2     // Catch:{ all -> 0x00c2 }
        L_0x00a9:
            java.lang.Object r5 = r8.T(r9)     // Catch:{ all -> 0x00c2 }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.SharedFlowKt.f3876a     // Catch:{ all -> 0x00c2 }
            if (r5 != r6) goto L_0x00c6
            r0.L$0 = r8     // Catch:{ all -> 0x00c2 }
            r0.L$1 = r10     // Catch:{ all -> 0x00c2 }
            r0.L$2 = r9     // Catch:{ all -> 0x00c2 }
            r0.L$3 = r2     // Catch:{ all -> 0x00c2 }
            r0.label = r4     // Catch:{ all -> 0x00c2 }
            java.lang.Object r5 = r8.w(r9, r0)     // Catch:{ all -> 0x00c2 }
            if (r5 != r1) goto L_0x00a9
            return r1
        L_0x00c2:
            r10 = move-exception
            r5 = r8
            r8 = r10
            goto L_0x00dc
        L_0x00c6:
            if (r2 == 0) goto L_0x00cb
            kotlinx.coroutines.JobKt.j(r2)     // Catch:{ all -> 0x00c2 }
        L_0x00cb:
            r0.L$0 = r8     // Catch:{ all -> 0x00c2 }
            r0.L$1 = r10     // Catch:{ all -> 0x00c2 }
            r0.L$2 = r9     // Catch:{ all -> 0x00c2 }
            r0.L$3 = r2     // Catch:{ all -> 0x00c2 }
            r0.label = r3     // Catch:{ all -> 0x00c2 }
            java.lang.Object r5 = r10.emit(r5, r0)     // Catch:{ all -> 0x00c2 }
            if (r5 != r1) goto L_0x00a9
            return r1
        L_0x00dc:
            r5.j(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.z(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void A(long j2) {
        AbstractSharedFlowSlot[] f2;
        if (!(this.b == 0 || (f2 = this.f3886a) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : f2) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j3 = sharedFlowSlot.f3877a;
                    if (j3 >= 0 && j3 < j2) {
                        sharedFlowSlot.f3877a = j2;
                    }
                }
            }
        }
        this.j = j2;
    }

    /* renamed from: B */
    public SharedFlowSlot h() {
        return new SharedFlowSlot();
    }

    /* renamed from: C */
    public SharedFlowSlot[] i(int i2) {
        return new SharedFlowSlot[i2];
    }

    public final void D() {
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.g(objArr, J(), (Object) null);
        this.k--;
        long J = J() + 1;
        if (this.i < J) {
            this.i = J;
        }
        if (this.j < J) {
            A(J);
        }
    }

    public final Object F(Object obj, Continuation continuation) {
        Continuation[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        Continuation[] continuationArr2 = AbstractSharedFlowKt.f3887a;
        synchronized (this) {
            try {
                if (Q(obj)) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
                    continuationArr = H(continuationArr2);
                    emitter = null;
                } else {
                    Emitter emitter2 = new Emitter(this, ((long) O()) + J(), obj, cancellableContinuationImpl);
                    G(emitter2);
                    this.l = this.l + 1;
                    if (this.f == 0) {
                        continuationArr2 = H(continuationArr2);
                    }
                    continuationArr = continuationArr2;
                    emitter = emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.a(cancellableContinuationImpl, emitter);
        }
        for (Continuation continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
            }
        }
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    public final void G(Object obj) {
        int O = O();
        Object[] objArr = this.h;
        if (objArr == null) {
            objArr = P((Object[]) null, 0, 2);
        } else if (O >= objArr.length) {
            objArr = P(objArr, O, objArr.length * 2);
        }
        SharedFlowKt.g(objArr, J() + ((long) O), obj);
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation[] H(kotlin.coroutines.Continuation[] r11) {
        /*
            r10 = this;
            int r0 = r11.length
            int r1 = r10.b
            if (r1 == 0) goto L_0x0047
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r1 = r10.f3886a
            if (r1 == 0) goto L_0x0047
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x0047
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0044
            kotlinx.coroutines.flow.SharedFlowSlot r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4
            kotlin.coroutines.Continuation r5 = r4.b
            if (r5 != 0) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            long r6 = r10.S(r4)
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0044
            int r6 = r11.length
            if (r0 < r6) goto L_0x0039
            int r6 = r11.length
            r7 = 2
            int r6 = r6 * r7
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r6)
        L_0x0039:
            r6 = r11
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.b = r0
            r0 = r7
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0047:
            kotlin.coroutines.Continuation[] r11 = (kotlin.coroutines.Continuation[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.H(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    public final long I() {
        return J() + ((long) this.k);
    }

    public final long J() {
        return Math.min(this.j, this.i);
    }

    public final Object K() {
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        return SharedFlowKt.f(objArr, (this.i + ((long) N())) - 1);
    }

    public final Object L(long j2) {
        Object[] objArr = this.h;
        Intrinsics.checkNotNull(objArr);
        Object c = SharedFlowKt.f(objArr, j2);
        return c instanceof Emitter ? ((Emitter) c).c : c;
    }

    public final long M() {
        return J() + ((long) this.k) + ((long) this.l);
    }

    public final int N() {
        return (int) ((J() + ((long) this.k)) - this.i);
    }

    public final int O() {
        return this.k + this.l;
    }

    public final Object[] P(Object[] objArr, int i2, int i3) {
        if (i3 > 0) {
            Object[] objArr2 = new Object[i3];
            this.h = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long J = J();
            for (int i4 = 0; i4 < i2; i4++) {
                long j2 = ((long) i4) + J;
                SharedFlowKt.g(objArr2, j2, SharedFlowKt.f(objArr, j2));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean Q(Object obj) {
        if (k() == 0) {
            return R(obj);
        }
        if (this.k >= this.f && this.j <= this.i) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.g.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 == 2) {
                return true;
            }
        }
        G(obj);
        int i3 = this.k + 1;
        this.k = i3;
        if (i3 > this.f) {
            D();
        }
        if (N() > this.e) {
            U(this.i + 1, this.j, I(), M());
        }
        return true;
    }

    public final boolean R(Object obj) {
        if (this.e == 0) {
            return true;
        }
        G(obj);
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 > this.e) {
            D();
        }
        this.j = J() + ((long) this.k);
        return true;
    }

    public final long S(SharedFlowSlot sharedFlowSlot) {
        long j2 = sharedFlowSlot.f3877a;
        if (j2 < I()) {
            return j2;
        }
        if (this.f <= 0 && j2 <= J() && this.l != 0) {
            return j2;
        }
        return -1;
    }

    public final Object T(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation[] continuationArr = AbstractSharedFlowKt.f3887a;
        synchronized (this) {
            try {
                long S = S(sharedFlowSlot);
                if (S < 0) {
                    obj = SharedFlowKt.f3876a;
                } else {
                    long j2 = sharedFlowSlot.f3877a;
                    Object L = L(S);
                    sharedFlowSlot.f3877a = S + 1;
                    Object obj2 = L;
                    continuationArr = V(j2);
                    obj = obj2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    public final void U(long j2, long j3, long j4, long j5) {
        long min = Math.min(j3, j2);
        for (long J = J(); J < min; J++) {
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.g(objArr, J, (Object) null);
        }
        this.i = j2;
        this.j = j3;
        this.k = (int) (j4 - min);
        this.l = (int) (j5 - j4);
    }

    public final Continuation[] V(long j2) {
        long j3;
        long j4;
        long j5;
        AbstractSharedFlowSlot[] f2;
        if (j2 > this.j) {
            return AbstractSharedFlowKt.f3887a;
        }
        long J = J();
        long j6 = ((long) this.k) + J;
        if (this.f == 0 && this.l > 0) {
            j6++;
        }
        if (!(this.b == 0 || (f2 = this.f3886a) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : f2) {
                if (abstractSharedFlowSlot != null) {
                    long j7 = ((SharedFlowSlot) abstractSharedFlowSlot).f3877a;
                    if (j7 >= 0 && j7 < j6) {
                        j6 = j7;
                    }
                }
            }
        }
        if (j6 <= this.j) {
            return AbstractSharedFlowKt.f3887a;
        }
        long I = I();
        int min = k() > 0 ? Math.min(this.l, this.f - ((int) (I - j6))) : this.l;
        Continuation[] continuationArr = AbstractSharedFlowKt.f3887a;
        long j8 = ((long) this.l) + I;
        if (min > 0) {
            continuationArr = new Continuation[min];
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            long j9 = I;
            int i2 = 0;
            while (true) {
                if (I >= j8) {
                    j4 = j6;
                    j3 = j8;
                    break;
                }
                Object c = SharedFlowKt.f(objArr, I);
                j4 = j6;
                Symbol symbol = SharedFlowKt.f3876a;
                if (c != symbol) {
                    Intrinsics.checkNotNull(c, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) c;
                    int i3 = i2 + 1;
                    j3 = j8;
                    continuationArr[i2] = emitter.d;
                    SharedFlowKt.g(objArr, I, symbol);
                    SharedFlowKt.g(objArr, j9, emitter.c);
                    j5 = 1;
                    j9++;
                    if (i3 >= min) {
                        break;
                    }
                    i2 = i3;
                } else {
                    j3 = j8;
                    j5 = 1;
                }
                I += j5;
                j6 = j4;
                j8 = j3;
            }
            I = j9;
        } else {
            j4 = j6;
            j3 = j8;
        }
        int i4 = (int) (I - J);
        long j10 = k() == 0 ? I : j4;
        long max = Math.max(this.i, I - ((long) Math.min(this.e, i4)));
        if (this.f == 0 && max < j3) {
            Object[] objArr2 = this.h;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.f(objArr2, max), (Object) SharedFlowKt.f3876a)) {
                I++;
                max++;
            }
        }
        U(max, j10, I, j3);
        y();
        return (continuationArr.length == 0) ^ true ? H(continuationArr) : continuationArr;
    }

    public final long W() {
        long j2 = this.i;
        if (j2 < this.j) {
            this.j = j2;
        }
        return j2;
    }

    public void a() {
        synchronized (this) {
            U(I(), this.j, I(), M());
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean b(Object obj) {
        int i2;
        boolean z;
        Continuation[] continuationArr = AbstractSharedFlowKt.f3887a;
        synchronized (this) {
            if (Q(obj)) {
                continuationArr = H(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        return z(this, flowCollector, continuation);
    }

    public Flow d(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return SharedFlowKt.e(this, coroutineContext, i2, bufferOverflow);
    }

    public Object emit(Object obj, Continuation continuation) {
        return E(this, obj, continuation);
    }

    public final Object w(SharedFlowSlot sharedFlowSlot, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        synchronized (this) {
            try {
                if (S(sharedFlowSlot) < 0) {
                    sharedFlowSlot.b = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    public final void x(Emitter emitter) {
        synchronized (this) {
            if (emitter.b >= J()) {
                Object[] objArr = this.h;
                Intrinsics.checkNotNull(objArr);
                if (SharedFlowKt.f(objArr, emitter.b) == emitter) {
                    SharedFlowKt.g(objArr, emitter.b, SharedFlowKt.f3876a);
                    y();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final void y() {
        if (this.f != 0 || this.l > 1) {
            Object[] objArr = this.h;
            Intrinsics.checkNotNull(objArr);
            while (this.l > 0 && SharedFlowKt.f(objArr, (J() + ((long) O())) - 1) == SharedFlowKt.f3876a) {
                this.l--;
                SharedFlowKt.g(objArr, J() + ((long) O()), (Object) null);
            }
        }
    }
}
