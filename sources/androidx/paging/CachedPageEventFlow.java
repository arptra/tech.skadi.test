package androidx.paging;

import androidx.paging.PageEvent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R(\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u00150\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u00150\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/paging/CachedPageEventFlow;", "", "T", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "src", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)V", "", "e", "()V", "Landroidx/paging/PageEvent$Insert;", "f", "()Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/FlattenedPageController;", "a", "Landroidx/paging/FlattenedPageController;", "pageController", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/collections/IndexedValue;", "b", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "mutableSharedSrc", "Lkotlinx/coroutines/flow/SharedFlow;", "c", "Lkotlinx/coroutines/flow/SharedFlow;", "sharedForDownstream", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/flow/Flow;", "g", "()Lkotlinx/coroutines/flow/Flow;", "downstreamFlow", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class CachedPageEventFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    public final FlattenedPageController f1518a = new FlattenedPageController();
    public final MutableSharedFlow b;
    public final SharedFlow c;
    public final Job d;
    public final Flow e;

    public CachedPageEventFlow(Flow flow, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(flow, "src");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        MutableSharedFlow a2 = SharedFlowKt.a(1, Integer.MAX_VALUE, BufferOverflow.SUSPEND);
        this.b = a2;
        this.c = FlowKt.N(a2, new CachedPageEventFlow$sharedForDownstream$1(this, (Continuation<? super CachedPageEventFlow$sharedForDownstream$1>) null));
        Job d2 = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, CoroutineStart.LAZY, new CachedPageEventFlow$job$1(flow, this, (Continuation<? super CachedPageEventFlow$job$1>) null), 1, (Object) null);
        d2.r(new CachedPageEventFlow$job$2$1(this));
        this.d = d2;
        this.e = FlowKt.C(new CachedPageEventFlow$downstreamFlow$1(this, (Continuation<? super CachedPageEventFlow$downstreamFlow$1>) null));
    }

    public final void e() {
        Job.DefaultImpls.a(this.d, (CancellationException) null, 1, (Object) null);
    }

    public final PageEvent.Insert f() {
        return this.f1518a.a();
    }

    public final Flow g() {
        return this.e;
    }
}
