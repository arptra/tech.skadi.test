package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u0018\u0010\u0011\u001a\u00020\t*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0013\u001a\u00020\t*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"T", "Lkotlinx/coroutines/DispatchedTask;", "", "mode", "", "a", "(Lkotlinx/coroutines/DispatchedTask;I)V", "Lkotlin/coroutines/Continuation;", "delegate", "", "undispatched", "d", "(Lkotlinx/coroutines/DispatchedTask;Lkotlin/coroutines/Continuation;Z)V", "e", "(Lkotlinx/coroutines/DispatchedTask;)V", "b", "(I)Z", "isCancellableMode", "c", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,222:1\n200#1,17:240\n1#2:223\n255#3:224\n256#3,2:235\n258#3:239\n107#4,10:225\n118#4,2:237\n61#5,2:257\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n190#1:240,17\n178#1:224\n178#1:235,2\n178#1:239\n178#1:225,10\n178#1:237,2\n220#1:257,2\n*E\n"})
public final class DispatchedTaskKt {
    public static final void a(DispatchedTask dispatchedTask, int i) {
        Continuation c = dispatchedTask.c();
        boolean z = i == 4;
        if (z || !(c instanceof DispatchedContinuation) || b(i) != b(dispatchedTask.c)) {
            d(dispatchedTask, c, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) c).d;
        CoroutineContext context = c.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            e(dispatchedTask);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final void d(DispatchedTask dispatchedTask, Continuation continuation, boolean z) {
        Object g;
        Object i = dispatchedTask.i();
        Throwable d = dispatchedTask.d(i);
        if (d != null) {
            Result.Companion companion = Result.Companion;
            g = ResultKt.createFailure(d);
        } else {
            Result.Companion companion2 = Result.Companion;
            g = dispatchedTask.g(i);
        }
        Object r3 = Result.m20constructorimpl(g);
        if (z) {
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation continuation2 = dispatchedContinuation.e;
            Object obj = dispatchedContinuation.g;
            CoroutineContext context = continuation2.getContext();
            Object c = ThreadContextKt.c(context, obj);
            UndispatchedCoroutine g2 = c != ThreadContextKt.f3933a ? CoroutineContextKt.g(continuation2, context, c) : null;
            try {
                dispatchedContinuation.e.resumeWith(r3);
                Unit unit = Unit.INSTANCE;
            } finally {
                if (g2 == null || g2.s1()) {
                    ThreadContextKt.a(context, c);
                }
            }
        } else {
            continuation.resumeWith(r3);
        }
    }

    public static final void e(DispatchedTask dispatchedTask) {
        EventLoop b = ThreadLocalEventLoop.f3744a.b();
        if (b.B0()) {
            b.q0(dispatchedTask);
            return;
        }
        b.z0(true);
        try {
            d(dispatchedTask, dispatchedTask.c(), true);
            do {
            } while (b.E0());
        } catch (Throwable th) {
            b.d0(true);
            throw th;
        }
        b.d0(true);
    }
}
