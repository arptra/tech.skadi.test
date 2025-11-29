package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/paging/PositionalDataSource$loadRange$2$1", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "", "data", "", "a", "(Ljava/util/List;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class PositionalDataSource$loadRange$2$1 extends PositionalDataSource.LoadRangeCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadRangeParams f1626a;
    public final /* synthetic */ PositionalDataSource b;
    public final /* synthetic */ CancellableContinuation c;

    public PositionalDataSource$loadRange$2$1(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource positionalDataSource, CancellableContinuation cancellableContinuation) {
        this.f1626a = loadRangeParams;
        this.b = positionalDataSource;
        this.c = cancellableContinuation;
    }

    public void a(List list) {
        Intrinsics.checkNotNullParameter(list, "data");
        int i = this.f1626a.f1624a;
        Integer valueOf = i == 0 ? null : Integer.valueOf(i);
        if (this.b.e()) {
            CancellableContinuation cancellableContinuation = this.c;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(DataSource.BaseResult.f.b()));
            return;
        }
        CancellableContinuation cancellableContinuation2 = this.c;
        Result.Companion companion2 = Result.Companion;
        cancellableContinuation2.resumeWith(Result.m20constructorimpl(new DataSource.BaseResult(list, valueOf, Integer.valueOf(this.f1626a.f1624a + list.size()), 0, 0, 24, (DefaultConstructorMarker) null)));
    }
}
