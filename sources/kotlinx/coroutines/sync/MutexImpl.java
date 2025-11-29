package kotlinx.coroutines.sync;

import com.honey.account.i.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002/0B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u00020\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\rJ\u0019\u0010\u001f\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u001dRq\u0010*\u001a_\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0011¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u000b0%0 j\u0002`'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070.8\u0002X\u0004\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Mutex;", "", "locked", "<init>", "(Z)V", "", "owner", "r", "(Ljava/lang/Object;)Z", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "d", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "x", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "result", "w", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "", "s", "(Ljava/lang/Object;)I", "v", "y", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "param", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "h", "Lkotlin/jvm/functions/Function3;", "onSelectCancellationUnlockConstructor", "t", "()Z", "isLocked", "Lkotlinx/atomicfu/AtomicRef;", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n332#2,12:311\n1#3:323\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n175#1:311,12\n*E\n"})
public class MutexImpl extends SemaphoreImpl implements Mutex {
    public static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    public final Function3 h;
    @Volatile
    @Nullable
    private volatile Object owner;

    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J9\u0010\u0017\u001a\u00020\u00022'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\u0012j\u0002`\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0011J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010!\u001a\u00020\u0002*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0001¢\u0006\u0004\b!\u0010\"J\u001c\u0010#\u001a\u00020\u0002*\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\nH\u0001¢\u0006\u0004\b#\u0010$J$\u0010)\u001a\u00020\u00022\n\u0010&\u001a\u0006\u0012\u0002\b\u00030%2\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b)\u0010*JH\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00062#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b-\u0010.J<\u0010/\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b/\u00100R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b/\u00101R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b)\u00102R\u0014\u00106\u001a\u0002038\u0016X\u0005¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00107\u001a\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b9\u00108\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "", "cause", "", "e", "(Ljava/lang/Throwable;)Z", "token", "B", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "E", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "exception", "F", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "value", "c", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/Unit;)V", "f", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "b", "(Lkotlinx/coroutines/internal/Segment;I)V", "idempotent", "onCancellation", "d", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "a", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isActive", "()Z", "isCompleted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {

        /* renamed from: a  reason: collision with root package name */
        public final CancellableContinuationImpl f3977a;
        public final Object b;

        public CancellableContinuationWithOwner(CancellableContinuationImpl cancellableContinuationImpl, Object obj) {
            this.f3977a = cancellableContinuationImpl;
            this.b = obj;
        }

        public void B(Object obj) {
            this.f3977a.B(obj);
        }

        public void E(Function1 function1) {
            this.f3977a.E(function1);
        }

        public Object F(Throwable th) {
            return this.f3977a.F(th);
        }

        /* renamed from: a */
        public void m(Unit unit, Function1 function1) {
            MutexImpl.i.set(MutexImpl.this, this.b);
            this.f3977a.m(unit, new MutexImpl$CancellableContinuationWithOwner$resume$2(MutexImpl.this, this));
        }

        public void b(Segment segment, int i) {
            this.f3977a.b(segment, i);
        }

        /* renamed from: c */
        public void I(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.f3977a.I(coroutineDispatcher, unit);
        }

        /* renamed from: d */
        public Object H(Unit unit, Object obj, Function1 function1) {
            Object H = this.f3977a.H(unit, obj, new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(MutexImpl.this, this));
            if (H != null) {
                MutexImpl.i.set(MutexImpl.this, this.b);
            }
            return H;
        }

        public boolean e(Throwable th) {
            return this.f3977a.e(th);
        }

        public void f(CoroutineDispatcher coroutineDispatcher, Throwable th) {
            this.f3977a.f(coroutineDispatcher, th);
        }

        public CoroutineContext getContext() {
            return this.f3977a.getContext();
        }

        public boolean isActive() {
            return this.f3977a.isActive();
        }

        public boolean isCompleted() {
            return this.f3977a.isCompleted();
        }

        public void resumeWith(Object obj) {
            this.f3977a.resumeWith(obj);
        }
    }

    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0011\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "select", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstanceInternal;Ljava/lang/Object;)V", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "", "d", "(Lkotlinx/coroutines/DisposableHandle;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "b", "(Lkotlinx/coroutines/internal/Segment;I)V", "clauseObject", "result", "", "e", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "internalResult", "c", "(Ljava/lang/Object;)V", "a", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public final class SelectInstanceWithOwner<Q> implements SelectInstanceInternal<Q> {

        /* renamed from: a  reason: collision with root package name */
        public final SelectInstanceInternal f3978a;
        public final Object b;

        public SelectInstanceWithOwner(SelectInstanceInternal selectInstanceInternal, Object obj) {
            this.f3978a = selectInstanceInternal;
            this.b = obj;
        }

        public void b(Segment segment, int i) {
            this.f3978a.b(segment, i);
        }

        public void c(Object obj) {
            MutexImpl.i.set(MutexImpl.this, this.b);
            this.f3978a.c(obj);
        }

        public void d(DisposableHandle disposableHandle) {
            this.f3978a.d(disposableHandle);
        }

        public boolean e(Object obj, Object obj2) {
            boolean e = this.f3978a.e(obj, obj2);
            MutexImpl mutexImpl = MutexImpl.this;
            if (e) {
                MutexImpl.i.set(mutexImpl, this.b);
            }
            return e;
        }

        public CoroutineContext getContext() {
            return this.f3978a.getContext();
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        this.owner = z ? null : MutexKt.f3979a;
        this.h = new MutexImpl$onSelectCancellationUnlockConstructor$1(this);
    }

    public static /* synthetic */ Object u(MutexImpl mutexImpl, Object obj, Continuation continuation) {
        if (mutexImpl.a(obj)) {
            return Unit.INSTANCE;
        }
        Object v = mutexImpl.v(obj, continuation);
        return v == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? v : Unit.INSTANCE;
    }

    public boolean a(Object obj) {
        int y = y(obj);
        if (y == 0) {
            return true;
        }
        if (y == 1) {
            return false;
        }
        if (y != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public Object c(Object obj, Continuation continuation) {
        return u(this, obj, continuation);
    }

    public void d(Object obj) {
        while (t()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != MutexKt.f3979a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                } else if (a.a(atomicReferenceFieldUpdater, this, obj2, MutexKt.f3979a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public boolean r(Object obj) {
        return s(obj) == 1;
    }

    public final int s(Object obj) {
        while (t()) {
            Object obj2 = i.get(this);
            if (obj2 != MutexKt.f3979a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    public boolean t() {
        return l() == 0;
    }

    public String toString() {
        return "Mutex@" + DebugStringsKt.b(this) + "[isLocked=" + t() + ",owner=" + i.get(this) + ']';
    }

    public final Object v(Object obj, Continuation continuation) {
        CancellableContinuationImpl b = CancellableContinuationKt.b(IntrinsicsKt.intercepted(continuation));
        try {
            f(new CancellableContinuationWithOwner(b, obj));
            Object u = b.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
        } catch (Throwable th) {
            b.K();
            throw th;
        }
    }

    public Object w(Object obj, Object obj2) {
        if (!Intrinsics.areEqual(obj2, (Object) MutexKt.b)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public void x(SelectInstance selectInstance, Object obj) {
        if (obj == null || !r(obj)) {
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            m(new SelectInstanceWithOwner((SelectInstanceInternal) selectInstance, obj), obj);
            return;
        }
        selectInstance.c(MutexKt.b);
    }

    public final int y(Object obj) {
        while (!n()) {
            if (obj == null) {
                return 1;
            }
            int s = s(obj);
            if (s == 1) {
                return 2;
            }
            if (s == 2) {
                return 1;
            }
        }
        i.set(this, obj);
        return 0;
    }
}
