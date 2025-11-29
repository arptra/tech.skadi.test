package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u0005R\u0014\u0010#\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010\u0005R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u001a8TX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u0014\u0010-\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001fR\u0014\u0010/\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001f¨\u00060"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", "task", "", "M0", "(Ljava/lang/Runnable;)V", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "H0", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "shutdown", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "run", "b1", "Ljava/lang/Thread;", "X0", "()Ljava/lang/Thread;", "", "a1", "()Z", "W0", "h", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "debugStatus", "I", "G0", "thread", "Y0", "isShutDown", "Z0", "isShutdownRequested", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final DefaultExecutor g;
    public static final long h;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        g = defaultExecutor;
        EventLoop.A0(defaultExecutor, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        h = timeUnit.toNanos(l.longValue());
    }

    public Thread G0() {
        Thread thread = _thread;
        return thread == null ? X0() : thread;
    }

    public void H0(long j, EventLoopImplBase.DelayedTask delayedTask) {
        b1();
    }

    public void M0(Runnable runnable) {
        if (Y0()) {
            b1();
        }
        super.M0(runnable);
    }

    public final synchronized void W0() {
        if (Z0()) {
            debugStatus = 3;
            Q0();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread X0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean Y0() {
        return debugStatus == 4;
    }

    public final boolean Z0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public final synchronized boolean a1() {
        if (Z0()) {
            return false;
        }
        debugStatus = 1;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void b1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return T0(j, runnable);
    }

    public void run() {
        Unit unit;
        ThreadLocalEventLoop.f3744a.d(this);
        AbstractTimeSource a2 = AbstractTimeSourceKt.a();
        if (a2 != null) {
            a2.c();
        }
        try {
            if (!a1()) {
                _thread = null;
                W0();
                AbstractTimeSource a3 = AbstractTimeSourceKt.a();
                if (a3 != null) {
                    a3.g();
                }
                if (!O0()) {
                    G0();
                    return;
                }
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long D0 = D0();
                if (D0 == LongCompanionObject.MAX_VALUE) {
                    AbstractTimeSource a4 = AbstractTimeSourceKt.a();
                    long a5 = a4 != null ? a4.a() : System.nanoTime();
                    if (j == LongCompanionObject.MAX_VALUE) {
                        j = h + a5;
                    }
                    long j2 = j - a5;
                    if (j2 <= 0) {
                        _thread = null;
                        W0();
                        AbstractTimeSource a6 = AbstractTimeSourceKt.a();
                        if (a6 != null) {
                            a6.g();
                        }
                        if (!O0()) {
                            G0();
                            return;
                        }
                        return;
                    }
                    D0 = RangesKt.coerceAtMost(D0, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (D0 > 0) {
                    if (Z0()) {
                        _thread = null;
                        W0();
                        AbstractTimeSource a7 = AbstractTimeSourceKt.a();
                        if (a7 != null) {
                            a7.g();
                        }
                        if (!O0()) {
                            G0();
                            return;
                        }
                        return;
                    }
                    AbstractTimeSource a8 = AbstractTimeSourceKt.a();
                    if (a8 != null) {
                        a8.b(this, D0);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, D0);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            W0();
            AbstractTimeSource a9 = AbstractTimeSourceKt.a();
            if (a9 != null) {
                a9.g();
            }
            if (!O0()) {
                G0();
            }
            throw th;
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
