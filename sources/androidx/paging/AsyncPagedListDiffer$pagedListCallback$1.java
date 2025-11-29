package androidx.paging;

import androidx.paging.PagedList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"androidx/paging/AsyncPagedListDiffer$pagedListCallback$1", "Landroidx/paging/PagedList$Callback;", "", "position", "count", "", "b", "(II)V", "c", "a", "paging-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class AsyncPagedListDiffer$pagedListCallback$1 extends PagedList.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsyncPagedListDiffer f1515a;

    public void a(int i, int i2) {
        this.f1515a.d().onChanged(i, i2, (Object) null);
    }

    public void b(int i, int i2) {
        this.f1515a.d().onInserted(i, i2);
    }

    public void c(int i, int i2) {
        this.f1515a.d().onRemoved(i, i2);
    }
}
