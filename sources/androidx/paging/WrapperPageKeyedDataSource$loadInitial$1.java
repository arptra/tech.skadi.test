package androidx.paging;

import androidx.paging.PageKeyedDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001JA\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"androidx/paging/WrapperPageKeyedDataSource$loadInitial$1", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "", "data", "", "position", "totalCount", "previousPageKey", "nextPageKey", "", "a", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class WrapperPageKeyedDataSource$loadInitial$1 extends PageKeyedDataSource.LoadInitialCallback<K, A> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WrapperPageKeyedDataSource f1646a;
    public final /* synthetic */ PageKeyedDataSource.LoadInitialCallback b;

    public WrapperPageKeyedDataSource$loadInitial$1(WrapperPageKeyedDataSource wrapperPageKeyedDataSource, PageKeyedDataSource.LoadInitialCallback loadInitialCallback) {
        this.f1646a = wrapperPageKeyedDataSource;
        this.b = loadInitialCallback;
    }

    public void a(List list, int i, int i2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.b.a(DataSource.e.a(this.f1646a.g, list), i, i2, obj, obj2);
    }
}
