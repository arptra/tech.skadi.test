package androidx.paging;

import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/paging/WrapperPositionalDataSource$loadRange$1", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "", "data", "", "a", "(Ljava/util/List;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class WrapperPositionalDataSource$loadRange$1 extends PositionalDataSource.LoadRangeCallback<A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PositionalDataSource.LoadRangeCallback f1648a;
    public final /* synthetic */ WrapperPositionalDataSource b;

    public WrapperPositionalDataSource$loadRange$1(PositionalDataSource.LoadRangeCallback loadRangeCallback, WrapperPositionalDataSource wrapperPositionalDataSource) {
        this.f1648a = loadRangeCallback;
        this.b = wrapperPositionalDataSource;
    }

    public void a(List list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f1648a.a(DataSource.e.a(this.b.q(), list));
    }
}
