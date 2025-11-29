package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/paging/MulticastedPagingData;", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/paging/PagingData;", "parent", "Landroidx/paging/ActiveFlowTracker;", "tracker", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagingData;Landroidx/paging/ActiveFlowTracker;)V", "b", "()Landroidx/paging/PagingData;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "Landroidx/paging/PagingData;", "getParent", "Landroidx/paging/ActiveFlowTracker;", "d", "()Landroidx/paging/ActiveFlowTracker;", "Landroidx/paging/CachedPageEventFlow;", "Landroidx/paging/CachedPageEventFlow;", "accumulated", "paging-common"}, k = 1, mv = {1, 8, 0})
final class MulticastedPagingData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f1558a;
    public final PagingData b;
    public final ActiveFlowTracker c;
    public final CachedPageEventFlow d;

    public MulticastedPagingData(CoroutineScope coroutineScope, PagingData pagingData, ActiveFlowTracker activeFlowTracker) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(pagingData, "parent");
        this.f1558a = coroutineScope;
        this.b = pagingData;
        this.c = activeFlowTracker;
        CachedPageEventFlow cachedPageEventFlow = new CachedPageEventFlow(pagingData.a(), coroutineScope);
        if (activeFlowTracker != null) {
            activeFlowTracker.b(cachedPageEventFlow);
        }
        this.d = cachedPageEventFlow;
    }

    public final PagingData b() {
        return new PagingData(FlowKt.K(FlowKt.M(this.d.g(), new MulticastedPagingData$asPagingData$1(this, (Continuation<? super MulticastedPagingData$asPagingData$1>) null)), new MulticastedPagingData$asPagingData$2(this, (Continuation<? super MulticastedPagingData$asPagingData$2>) null)), this.b.c(), this.b.b(), new MulticastedPagingData$asPagingData$3(this));
    }

    public final Object c(Continuation continuation) {
        this.d.e();
        return Unit.INSTANCE;
    }

    public final ActiveFlowTracker d() {
        return this.c;
    }
}
