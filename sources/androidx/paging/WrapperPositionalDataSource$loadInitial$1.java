package androidx.paging;

import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J-\u0010\b\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/paging/WrapperPositionalDataSource$loadInitial$1", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "", "data", "", "position", "totalCount", "", "a", "(Ljava/util/List;II)V", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class WrapperPositionalDataSource$loadInitial$1 extends PositionalDataSource.LoadInitialCallback<A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadInitialCallback f1647a;
    public final /* synthetic */ WrapperPositionalDataSource b;

    public WrapperPositionalDataSource$loadInitial$1(PositionalDataSource.LoadInitialCallback loadInitialCallback, WrapperPositionalDataSource wrapperPositionalDataSource) {
        this.f1647a = loadInitialCallback;
        this.b = wrapperPositionalDataSource;
    }

    public void a(List list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f1647a.a(DataSource.e.a(this.b.q(), list), i, i2);
    }
}
