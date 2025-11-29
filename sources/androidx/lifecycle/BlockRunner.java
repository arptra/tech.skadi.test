package androidx.lifecycle;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR>\u0010\u0011\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\b\u000e8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Landroidx/lifecycle/BlockRunner;", "T", "", "", "h", "()V", "g", "Landroidx/lifecycle/CoroutineLiveData;", "a", "Landroidx/lifecycle/CoroutineLiveData;", "liveData", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "b", "Lkotlin/jvm/functions/Function2;", "block", "", "c", "J", "timeoutInMs", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "onDone", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "runningJob", "cancellationJob", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class BlockRunner<T> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineLiveData f1343a;
    public final Function2 b;
    public final long c;
    public final CoroutineScope d;
    public final Function0 e;
    public Job f;
    public Job g;

    public final void g() {
        if (this.g == null) {
            this.g = BuildersKt__Builders_commonKt.d(this.d, Dispatchers.c().getImmediate(), (CoroutineStart) null, new BlockRunner$cancel$1(this, (Continuation<? super BlockRunner$cancel$1>) null), 2, (Object) null);
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
    }

    public final void h() {
        Job job = this.g;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.g = null;
        if (this.f == null) {
            this.f = BuildersKt__Builders_commonKt.d(this.d, (CoroutineContext) null, (CoroutineStart) null, new BlockRunner$maybeRun$1(this, (Continuation<? super BlockRunner$maybeRun$1>) null), 3, (Object) null);
        }
    }
}
