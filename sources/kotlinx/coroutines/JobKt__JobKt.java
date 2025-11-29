package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\t*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u0010\u001a\u00020\t*\u00020\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\t*\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0019\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001a\"\u0015\u0010\u001e\u001a\u00020\u001b*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0015\u0010!\u001a\u00020\u0000*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "a", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "g", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)Lkotlinx/coroutines/DisposableHandle;", "", "f", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "c", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "i", "(Lkotlinx/coroutines/Job;)V", "h", "(Lkotlin/coroutines/CoroutineContext;)V", "", "message", "", "d", "(Lkotlinx/coroutines/Job;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "k", "(Lkotlin/coroutines/CoroutineContext;)Z", "isActive", "j", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "job", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xs = "kotlinx/coroutines/JobKt")
@SourceDebugExtension({"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,685:1\n13#2:686\n1295#3,2:687\n1295#3,2:689\n1295#3,2:691\n1295#3,2:693\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n494#1:686\n521#1:687,2\n535#1:689,2\n629#1:691,2\n653#1:693,2\n*E\n"})
final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob a(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.b0);
        if (job != null) {
            job.a(cancellationException);
        }
    }

    public static final void d(Job job, String str, Throwable th) {
        job.a(ExceptionsKt.a(str, th));
    }

    public static /* synthetic */ void e(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.c(coroutineContext, cancellationException);
    }

    public static final Object f(Job job, Continuation continuation) {
        Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        Object i0 = job.i0(continuation);
        return i0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? i0 : Unit.INSTANCE;
    }

    public static final DisposableHandle g(Job job, DisposableHandle disposableHandle) {
        return job.r(new DisposeOnCompletion(disposableHandle));
    }

    public static final void h(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.b0);
        if (job != null) {
            JobKt.j(job);
        }
    }

    public static final void i(Job job) {
        if (!job.isActive()) {
            throw job.U();
        }
    }

    public static final Job j(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.b0);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean k(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.b0);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }
}
