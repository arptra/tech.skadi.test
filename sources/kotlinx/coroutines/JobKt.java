package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class JobKt {
    public static final CompletableJob a(Job job) {
        return JobKt__JobKt.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.c(coroutineContext, cancellationException);
    }

    public static final void d(Job job, String str, Throwable th) {
        JobKt__JobKt.d(job, str, th);
    }

    public static final Object f(Job job, Continuation continuation) {
        return JobKt__JobKt.f(job, continuation);
    }

    public static final void g(CancellableContinuation cancellableContinuation, Future future) {
        JobKt__FutureKt.a(cancellableContinuation, future);
    }

    public static final DisposableHandle h(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.g(job, disposableHandle);
    }

    public static final void i(CoroutineContext coroutineContext) {
        JobKt__JobKt.h(coroutineContext);
    }

    public static final void j(Job job) {
        JobKt__JobKt.i(job);
    }

    public static final Job k(CoroutineContext coroutineContext) {
        return JobKt__JobKt.j(coroutineContext);
    }

    public static final boolean l(CoroutineContext coroutineContext) {
        return JobKt__JobKt.k(coroutineContext);
    }
}
