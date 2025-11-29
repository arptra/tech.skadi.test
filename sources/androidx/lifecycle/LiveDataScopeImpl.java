package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/LiveDataScopeImpl;", "T", "Landroidx/lifecycle/LiveDataScope;", "Landroidx/lifecycle/CoroutineLiveData;", "target", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/coroutines/CoroutineContext;)V", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Landroidx/lifecycle/CoroutineLiveData;", "()Landroidx/lifecycle/CoroutineLiveData;", "setTarget$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/CoroutineLiveData;)V", "b", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {

    /* renamed from: a  reason: collision with root package name */
    public CoroutineLiveData f1369a;
    public final CoroutineContext b;

    public LiveDataScopeImpl(CoroutineLiveData coroutineLiveData, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineLiveData, "target");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        this.f1369a = coroutineLiveData;
        this.b = coroutineContext.plus(Dispatchers.c().getImmediate());
    }

    public final CoroutineLiveData a() {
        return this.f1369a;
    }

    public Object emit(Object obj, Continuation continuation) {
        Object g = BuildersKt.g(this.b, new LiveDataScopeImpl$emit$2(this, obj, (Continuation<? super LiveDataScopeImpl$emit$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }
}
