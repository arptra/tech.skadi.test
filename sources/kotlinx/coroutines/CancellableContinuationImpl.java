package kotlinx.coroutines;

import com.honey.account.i.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u000fJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b#\u0010$J8\u0010*\u001a\u00020)2'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00160%j\u0002`(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\b-\u0010.JZ\u00103\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\t2#\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0016\u0018\u00010%2\b\u00102\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b3\u00104JH\u00105\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\t2%\b\u0002\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0016\u0018\u00010%H\u0002¢\u0006\u0004\b5\u00106JJ\u00108\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u00010\u001e2\b\u00102\u001a\u0004\u0018\u00010\u001e2#\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0016\u0018\u00010%H\u0002¢\u0006\u0004\b8\u00109J\u0019\u0010;\u001a\u00020:2\b\u00100\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0016H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0016H\u0016¢\u0006\u0004\b?\u0010>J\u000f\u0010@\u001a\u00020\rH\u0001¢\u0006\u0004\b@\u0010\u000fJ\u0017\u0010C\u001a\n\u0018\u00010Aj\u0004\u0018\u0001`BH\u0016¢\u0006\u0004\bC\u0010DJ\u0011\u0010E\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bE\u0010FJ!\u0010H\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0010¢\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\bJ\u0010\u0013J\u0017\u0010K\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\bK\u0010LJ\u001f\u0010M\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020)2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bM\u0010NJ8\u0010O\u001a\u00020\u00162!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00160%2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u00102\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u0011\u0010U\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\bU\u0010FJ\u000f\u0010V\u001a\u00020\u0016H\u0000¢\u0006\u0004\bV\u0010>J \u0010Y\u001a\u00020\u00162\f\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000WH\u0016ø\u0001\u0000¢\u0006\u0004\bY\u0010!J<\u0010[\u001a\u00020\u00162\u0006\u0010Z\u001a\u00028\u00002#\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0016\u0018\u00010%H\u0016¢\u0006\u0004\b[\u0010\\J#\u0010^\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010]\u001a\u00020\tH\u0016¢\u0006\u0004\b^\u0010_J8\u0010`\u001a\u00020\u00162'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00160%j\u0002`(H\u0016¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u0016H\u0000¢\u0006\u0004\bb\u0010>JH\u0010c\u001a\u0004\u0018\u00010\u001e2\u0006\u0010Z\u001a\u00028\u00002\b\u00102\u001a\u0004\u0018\u00010\u001e2#\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0016\u0018\u00010%H\u0016¢\u0006\u0004\bc\u0010dJ\u0019\u0010f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010e\u001a\u00020\u0010H\u0016¢\u0006\u0004\bf\u0010gJ\u0017\u0010i\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u001eH\u0016¢\u0006\u0004\bi\u0010!J\u001b\u0010k\u001a\u00020\u0016*\u00020j2\u0006\u0010Z\u001a\u00028\u0000H\u0016¢\u0006\u0004\bk\u0010lJ\u001b\u0010m\u001a\u00020\u0016*\u00020j2\u0006\u0010e\u001a\u00020\u0010H\u0016¢\u0006\u0004\bm\u0010nJ\u001f\u0010o\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bo\u0010pJ\u001b\u0010q\u001a\u0004\u0018\u00010\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bq\u0010rJ\u000f\u0010t\u001a\u00020sH\u0016¢\u0006\u0004\bt\u0010uJ\u000f\u0010v\u001a\u00020sH\u0014¢\u0006\u0004\bv\u0010uR \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000X\u0004¢\u0006\f\n\u0004\bq\u0010w\u001a\u0004\bx\u0010yR\u001a\u0010~\u001a\u00020z8\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010{\u001a\u0004\b|\u0010}R\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u001dR\u0016\u0010\u0001\u001a\u00020s8BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010uR\u0017\u0010\"\u001a\u0004\u0018\u00010\u001e8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010FR\u0016\u0010\u0001\u001a\u00020\r8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000fR\u0016\u0010\u0001\u001a\u00020\r8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000fR\u001f\u0010\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\r\u0010\u0001\u001a\u00030\u00018\u0002X\u0004R\u0015\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00018\u0002X\u0004R\u0015\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00018\u0002X\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "A", "()Z", "", "cause", "o", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "n", "(Lkotlinx/coroutines/internal/Segment;Ljava/lang/Throwable;)V", "R", "P", "Lkotlinx/coroutines/DisposableHandle;", "y", "()Lkotlinx/coroutines/DisposableHandle;", "", "handler", "z", "(Ljava/lang/Object;)V", "state", "D", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlinx/coroutines/CancelHandler;", "C", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "mode", "r", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "onCancellation", "idempotent", "O", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "M", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/Symbol;", "Q", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "", "j", "(Ljava/lang/Object;)Ljava/lang/Void;", "q", "()V", "x", "L", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "i", "()Ljava/lang/Object;", "takenState", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "e", "J", "(Ljava/lang/Throwable;)V", "k", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "l", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/Job;", "parent", "s", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "u", "K", "Lkotlin/Result;", "result", "resumeWith", "value", "m", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "index", "b", "(Lkotlinx/coroutines/internal/Segment;I)V", "E", "(Lkotlin/jvm/functions/Function1;)V", "p", "H", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "F", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "B", "Lkotlinx/coroutines/CoroutineDispatcher;", "I", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "f", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "g", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "G", "Lkotlin/coroutines/Continuation;", "c", "()Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "t", "parentHandle", "w", "stateDebugRepresentation", "v", "isActive", "isCompleted", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlinx/atomicfu/AtomicInt;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {
    public static final AtomicIntegerFieldUpdater f;
    public static final AtomicReferenceFieldUpdater g;
    public static final AtomicReferenceFieldUpdater h;
    @Volatile
    private volatile int _decisionAndIndex = 536870911;
    @Volatile
    @Nullable
    private volatile Object _parentHandle;
    @Volatile
    @Nullable
    private volatile Object _state = Active.f3709a;
    public final Continuation d;
    public final CoroutineContext e;

    static {
        Class<CancellableContinuationImpl> cls = CancellableContinuationImpl.class;
        f = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex");
        Class<Object> cls2 = Object.class;
        g = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public CancellableContinuationImpl(Continuation continuation, int i) {
        super(i);
        this.d = continuation;
        this.e = continuation.getContext();
    }

    public static /* synthetic */ void N(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.M(obj, i, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final boolean P() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f.compareAndSet(this, i, 1073741824 + (536870911 & i)));
        return true;
    }

    private final boolean R() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f.compareAndSet(this, i, 536870912 + (536870911 & i)));
        return true;
    }

    public final boolean A() {
        if (DispatchedTaskKt.c(this.c)) {
            Continuation continuation = this.d;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((DispatchedContinuation) continuation).o()) {
                return true;
            }
        }
        return false;
    }

    public void B(Object obj) {
        r(this.c);
    }

    public final CancelHandler C(Function1 function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    public final void D(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public void E(Function1 function1) {
        z(C(function1));
    }

    public Object F(Throwable th) {
        return Q(new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null), (Object) null, (Function1) null);
    }

    public String G() {
        return "CancellableContinuation";
    }

    public Object H(Object obj, Object obj2, Function1 function1) {
        return Q(obj, obj2, function1);
    }

    public void I(CoroutineDispatcher coroutineDispatcher, Object obj) {
        Continuation continuation = this.d;
        CoroutineDispatcher coroutineDispatcher2 = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.d;
        }
        N(this, obj, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.c, (Function1) null, 4, (Object) null);
    }

    public final void J(Throwable th) {
        if (!o(th)) {
            e(th);
            q();
        }
    }

    public final void K() {
        Throwable r;
        Continuation continuation = this.d;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null && (r = dispatchedContinuation.r(this)) != null) {
            p();
            e(r);
        }
    }

    public final boolean L() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (!(obj instanceof CompletedContinuation) || ((CompletedContinuation) obj).d == null) {
            f.set(this, 536870911);
            atomicReferenceFieldUpdater.set(this, Active.f3709a);
            return true;
        }
        p();
        return false;
    }

    public final void M(Object obj, int i, Function1 function1) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.c()) {
                        if (function1 != null) {
                            l(function1, cancelledContinuation.f3715a);
                            return;
                        }
                        return;
                    }
                }
                j(obj);
                throw new KotlinNothingValueException();
            }
        } while (!a.a(g, this, obj2, O((NotCompleted) obj2, obj, i, function1, (Object) null)));
        q();
        r(i);
    }

    public final Object O(NotCompleted notCompleted, Object obj, int i, Function1 function1, Object obj2) {
        if (obj instanceof CompletedExceptionally) {
            return obj;
        }
        if (!DispatchedTaskKt.b(i) && obj2 == null) {
            return obj;
        }
        if (function1 == null && !(notCompleted instanceof CancelHandler) && obj2 == null) {
            return obj;
        }
        return new CompletedContinuation(obj, notCompleted instanceof CancelHandler ? (CancelHandler) notCompleted : null, function1, obj2, (Throwable) null, 16, (DefaultConstructorMarker) null);
    }

    public final Symbol Q(Object obj, Object obj2, Function1 function1) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof CompletedContinuation) || obj2 == null || ((CompletedContinuation) obj3).d != obj2) {
                return null;
            } else {
                return CancellableContinuationImplKt.f3713a;
            }
        } while (!a.a(g, this, obj3, O((NotCompleted) obj3, obj, this.c, function1, obj2)));
        q();
        return CancellableContinuationImplKt.f3713a;
    }

    public void a(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof CompletedExceptionally)) {
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (!completedContinuation.c()) {
                        Throwable th2 = th;
                        if (a.a(g, this, obj2, CompletedContinuation.b(completedContinuation, (Object) null, (CancelHandler) null, (Function1) null, (Object) null, th, 15, (Object) null))) {
                            completedContinuation.d(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    Throwable th3 = th;
                    if (a.a(g, this, obj2, new CompletedContinuation(obj2, (CancelHandler) null, (Function1) null, (Object) null, th, 14, (DefaultConstructorMarker) null))) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public void b(Segment segment, int i) {
        int i2;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        z(segment);
    }

    public final Continuation c() {
        return this.d;
    }

    public Throwable d(Object obj) {
        Throwable d2 = super.d(obj);
        if (d2 != null) {
            return d2;
        }
        return null;
    }

    public boolean e(Throwable th) {
        Object obj;
        boolean z;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            z = false;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            if ((obj instanceof CancelHandler) || (obj instanceof Segment)) {
                z = true;
            }
        } while (!a.a(g, this, obj, new CancelledContinuation(this, th, z)));
        NotCompleted notCompleted = (NotCompleted) obj;
        if (notCompleted instanceof CancelHandler) {
            k((CancelHandler) obj, th);
        } else if (notCompleted instanceof Segment) {
            n((Segment) obj, th);
        }
        q();
        r(this.c);
        return true;
    }

    public void f(CoroutineDispatcher coroutineDispatcher, Throwable th) {
        Continuation continuation = this.d;
        CoroutineDispatcher coroutineDispatcher2 = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.d;
        }
        N(this, completedExceptionally, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.c, (Function1) null, 4, (Object) null);
    }

    public Object g(Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).f3714a : obj;
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.e;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object i() {
        return v();
    }

    public boolean isActive() {
        return v() instanceof NotCompleted;
    }

    public boolean isCompleted() {
        return !(v() instanceof NotCompleted);
    }

    public final Void j(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void k(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.g(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void l(Function1 function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public void m(Object obj, Function1 function1) {
        M(obj, this.c, function1);
    }

    public final void n(Segment segment, Throwable th) {
        int i = f.get(this) & 536870911;
        if (i != 536870911) {
            try {
                segment.o(i, th, getContext());
            } catch (Throwable th2) {
                CoroutineContext context = getContext();
                CoroutineExceptionHandlerKt.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
    }

    public final boolean o(Throwable th) {
        if (!A()) {
            return false;
        }
        Continuation continuation = this.d;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).p(th);
    }

    public final void p() {
        DisposableHandle t = t();
        if (t != null) {
            t.dispose();
            h.set(this, NonDisposableHandle.f3741a);
        }
    }

    public final void q() {
        if (!A()) {
            p();
        }
    }

    public final void r(int i) {
        if (!P()) {
            DispatchedTaskKt.a(this, i);
        }
    }

    public void resumeWith(Object obj) {
        N(this, CompletionStateKt.c(obj, this), this.c, (Function1) null, 4, (Object) null);
    }

    public Throwable s(Job job) {
        return job.U();
    }

    public final DisposableHandle t() {
        return (DisposableHandle) h.get(this);
    }

    public String toString() {
        return G() + '(' + DebugStringsKt.c(this.d) + "){" + w() + "}@" + DebugStringsKt.b(this);
    }

    public final Object u() {
        Job job;
        boolean A = A();
        if (R()) {
            if (t() == null) {
                y();
            }
            if (A) {
                K();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (A) {
            K();
        }
        Object v = v();
        if (v instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) v).f3715a;
        } else if (!DispatchedTaskKt.b(this.c) || (job = (Job) getContext().get(Job.b0)) == null || job.isActive()) {
            return g(v);
        } else {
            CancellationException U = job.U();
            a(v, U);
            throw U;
        }
    }

    public final Object v() {
        return g.get(this);
    }

    public final String w() {
        Object v = v();
        return v instanceof NotCompleted ? "Active" : v instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    public void x() {
        DisposableHandle y = y();
        if (y != null && isCompleted()) {
            y.dispose();
            h.set(this, NonDisposableHandle.f3741a);
        }
    }

    public final DisposableHandle y() {
        Job job = (Job) getContext().get(Job.b0);
        if (job == null) {
            return null;
        }
        DisposableHandle d2 = Job.DefaultImpls.d(job, true, false, new ChildContinuation(this), 2, (Object) null);
        a.a(h, this, (Object) null, d2);
        return d2;
    }

    public final void z(Object obj) {
        Object obj2 = obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof Active)) {
                if (obj3 instanceof CancelHandler ? true : obj3 instanceof Segment) {
                    D(obj2, obj3);
                } else if (obj3 instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj3;
                    if (!completedExceptionally.b()) {
                        D(obj2, obj3);
                    }
                    if (obj3 instanceof CancelledContinuation) {
                        Throwable th = null;
                        if (!(obj3 instanceof CompletedExceptionally)) {
                            completedExceptionally = null;
                        }
                        if (completedExceptionally != null) {
                            th = completedExceptionally.f3715a;
                        }
                        if (obj2 instanceof CancelHandler) {
                            k((CancelHandler) obj2, th);
                            return;
                        }
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        n((Segment) obj2, th);
                        return;
                    }
                    return;
                } else if (obj3 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj3;
                    if (completedContinuation.b != null) {
                        D(obj2, obj3);
                    }
                    if (!(obj2 instanceof Segment)) {
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        CancelHandler cancelHandler = (CancelHandler) obj2;
                        if (completedContinuation.c()) {
                            k(cancelHandler, completedContinuation.e);
                            return;
                        } else {
                            if (a.a(g, this, obj3, CompletedContinuation.b(completedContinuation, (Object) null, cancelHandler, (Function1) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } else if (!(obj2 instanceof Segment)) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (a.a(g, this, obj3, new CompletedContinuation(obj3, (CancelHandler) obj2, (Function1) null, (Object) null, (Throwable) null, 28, (DefaultConstructorMarker) null))) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (a.a(g, this, obj3, obj2)) {
                return;
            }
        }
    }
}
