package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J-\u0010\b\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/paging/PositionalDataSource$loadInitial$2$1", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "", "data", "", "position", "totalCount", "", "a", "(Ljava/util/List;II)V", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "params", "Landroidx/paging/DataSource$BaseResult;", "result", "b", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Landroidx/paging/DataSource$BaseResult;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PositionalDataSource$loadInitial$2$1 extends PositionalDataSource.LoadInitialCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource f1625a;
    public final /* synthetic */ CancellableContinuation b;
    public final /* synthetic */ PositionalDataSource.LoadInitialParams c;

    public PositionalDataSource$loadInitial$2$1(PositionalDataSource positionalDataSource, CancellableContinuation cancellableContinuation, PositionalDataSource.LoadInitialParams loadInitialParams) {
        this.f1625a = positionalDataSource;
        this.b = cancellableContinuation;
        this.c = loadInitialParams;
    }

    public void a(List list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "data");
        if (this.f1625a.e()) {
            CancellableContinuation cancellableContinuation = this.b;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(DataSource.BaseResult.f.b()));
            return;
        }
        int size = list.size() + i;
        b(this.c, new DataSource.BaseResult(list, i == 0 ? null : Integer.valueOf(i), size == i2 ? null : Integer.valueOf(size), i, (i2 - list.size()) - i));
    }

    public final void b(PositionalDataSource.LoadInitialParams loadInitialParams, DataSource.BaseResult baseResult) {
        if (loadInitialParams.d) {
            baseResult.e(loadInitialParams.c);
        }
        this.b.resumeWith(Result.m20constructorimpl(baseResult));
    }
}
