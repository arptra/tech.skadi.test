package androidx.paging;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e0\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010 R\u0014\u00104\u001a\u0002018\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Landroidx/paging/LivePagedList;", "", "Key", "Value", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "", "onActive", "()V", "", "force", "o", "(Z)V", "previous", "next", "p", "(Landroidx/paging/PagedList;Landroidx/paging/PagedList;)V", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/paging/PagedList$Config;", "b", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagedList$BoundaryCallback;", "c", "Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallback", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "d", "Lkotlin/jvm/functions/Function0;", "pagingSourceFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "e", "Lkotlinx/coroutines/CoroutineDispatcher;", "notifyDispatcher", "f", "fetchDispatcher", "g", "Landroidx/paging/PagedList;", "currentData", "Lkotlinx/coroutines/Job;", "h", "Lkotlinx/coroutines/Job;", "currentJob", "i", "callback", "Ljava/lang/Runnable;", "j", "Ljava/lang/Runnable;", "refreshRetryCallback", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class LivePagedList<Key, Value> extends LiveData<PagedList<Value>> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f1553a;
    public final PagedList.Config b;
    public final PagedList.BoundaryCallback c;
    public final Function0 d;
    public final CoroutineDispatcher e;
    public final CoroutineDispatcher f;
    public PagedList g;
    public Job h;
    public final Function0 i;
    public final Runnable j;

    public final void o(boolean z) {
        Job job = this.h;
        if (job == null || z) {
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            this.h = BuildersKt__Builders_commonKt.d(this.f1553a, this.f, (CoroutineStart) null, new LivePagedList$invalidate$1(this, (Continuation<? super LivePagedList$invalidate$1>) null), 2, (Object) null);
        }
    }

    public void onActive() {
        super.onActive();
        o(false);
    }

    public final void p(PagedList pagedList, PagedList pagedList2) {
        pagedList.y((Runnable) null);
        pagedList2.y(this.j);
    }
}
