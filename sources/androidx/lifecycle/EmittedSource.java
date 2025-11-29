package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0003¢\u0006\u0004\b\r\u0010\fR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/EmittedSource;", "Lkotlinx/coroutines/DisposableHandle;", "Landroidx/lifecycle/LiveData;", "source", "Landroidx/lifecycle/MediatorLiveData;", "mediator", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "()V", "d", "a", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/MediatorLiveData;", "", "Z", "disposed", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class EmittedSource implements DisposableHandle {

    /* renamed from: a  reason: collision with root package name */
    public final LiveData f1354a;
    public final MediatorLiveData b;
    public boolean c;

    public EmittedSource(LiveData liveData, MediatorLiveData mediatorLiveData) {
        Intrinsics.checkNotNullParameter(liveData, "source");
        Intrinsics.checkNotNullParameter(mediatorLiveData, "mediator");
        this.f1354a = liveData;
        this.b = mediatorLiveData;
    }

    public final Object c(Continuation continuation) {
        Object g = BuildersKt.g(Dispatchers.c().getImmediate(), new EmittedSource$disposeNow$2(this, (Continuation<? super EmittedSource$disposeNow$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    public final void d() {
        if (!this.c) {
            this.b.d(this.f1354a);
            this.c = true;
        }
    }

    public void dispose() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new EmittedSource$dispose$1(this, (Continuation<? super EmittedSource$dispose$1>) null), 3, (Object) null);
    }
}
