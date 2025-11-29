package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.honey.account.i0.a;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u0010\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\u00020 8\u0016X\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ListenableWorker$Result;", "n", "()Lcom/google/common/util/concurrent/ListenableFuture;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/ForegroundInfo;", "t", "c", "", "l", "()V", "Lkotlinx/coroutines/CompletableJob;", "e", "Lkotlinx/coroutines/CompletableJob;", "getJob$work_runtime_release", "()Lkotlinx/coroutines/CompletableJob;", "job", "Landroidx/work/impl/utils/futures/SettableFuture;", "f", "Landroidx/work/impl/utils/futures/SettableFuture;", "v", "()Landroidx/work/impl/utils/futures/SettableFuture;", "future", "Lkotlinx/coroutines/CoroutineDispatcher;", "g", "Lkotlinx/coroutines/CoroutineDispatcher;", "s", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "coroutineContext", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCoroutineWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineWorker.kt\nandroidx/work/CoroutineWorker\n+ 2 ListenableFuture.kt\nandroidx/work/ListenableFutureKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,144:1\n40#2,8:145\n48#2:162\n60#2,7:163\n40#2,8:172\n48#2:189\n60#2,7:190\n314#3,9:153\n323#3,2:170\n314#3,9:180\n323#3,2:197\n*S KotlinDebug\n*F\n+ 1 CoroutineWorker.kt\nandroidx/work/CoroutineWorker\n*L\n110#1:145,8\n110#1:162\n110#1:163,7\n125#1:172,8\n125#1:189\n125#1:190,7\n110#1:153,9\n110#1:170,2\n125#1:180,9\n125#1:197,2\n*E\n"})
public abstract class CoroutineWorker extends ListenableWorker {
    public final CompletableJob e = JobKt__JobKt.b((Job) null, 1, (Object) null);
    public final SettableFuture f;
    public final CoroutineDispatcher g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, PayloadConstant.KEY_PARAMS);
        SettableFuture s = SettableFuture.s();
        Intrinsics.checkNotNullExpressionValue(s, "create()");
        this.f = s;
        s.addListener(new a(this), h().d());
        this.g = Dispatchers.a();
    }

    public static final void q(CoroutineWorker coroutineWorker) {
        Intrinsics.checkNotNullParameter(coroutineWorker, "this$0");
        if (coroutineWorker.f.isCancelled()) {
            Job.DefaultImpls.a(coroutineWorker.e, (CancellationException) null, 1, (Object) null);
        }
    }

    public static /* synthetic */ Object u(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public final ListenableFuture c() {
        CompletableJob b = JobKt__JobKt.b((Job) null, 1, (Object) null);
        CoroutineScope a2 = CoroutineScopeKt.a(s().plus(b));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(b, (SettableFuture) null, 2, (DefaultConstructorMarker) null);
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, (Continuation<? super CoroutineWorker$getForegroundInfoAsync$1>) null), 3, (Object) null);
        return jobListenableFuture;
    }

    public final void l() {
        super.l();
        this.f.cancel(false);
    }

    public final ListenableFuture n() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(s().plus(this.e)), (CoroutineContext) null, (CoroutineStart) null, new CoroutineWorker$startWork$1(this, (Continuation<? super CoroutineWorker$startWork$1>) null), 3, (Object) null);
        return this.f;
    }

    public abstract Object r(Continuation continuation);

    public CoroutineDispatcher s() {
        return this.g;
    }

    public Object t(Continuation continuation) {
        return u(this, continuation);
    }

    public final SettableFuture v() {
        return this.f;
    }
}
