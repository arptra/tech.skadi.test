package androidx.paging;

import androidx.paging.PagePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J!\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"androidx/paging/PagingDataDiffer$processPageEventCallback$1", "Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "", "position", "count", "", "a", "(II)V", "onInserted", "onRemoved", "Landroidx/paging/LoadStates;", "source", "mediator", "c", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "Landroidx/paging/LoadType;", "loadType", "", "fromMediator", "Landroidx/paging/LoadState;", "loadState", "b", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PagingDataDiffer$processPageEventCallback$1 implements PagePresenter.ProcessPageEventCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PagingDataDiffer f1603a;

    public void a(int i, int i2) {
        this.f1603a.f1601a.a(i, i2);
    }

    public void b(LoadType loadType, boolean z, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        this.f1603a.f.h(loadType, z, loadState);
    }

    public void c(LoadStates loadStates, LoadStates loadStates2) {
        Intrinsics.checkNotNullParameter(loadStates, "source");
        this.f1603a.q(loadStates, loadStates2);
    }

    public void onInserted(int i, int i2) {
        this.f1603a.f1601a.onInserted(i, i2);
    }

    public void onRemoved(int i, int i2) {
        this.f1603a.f1601a.onRemoved(i, i2);
    }
}
