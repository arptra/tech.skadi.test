package androidx.paging;

import androidx.paging.PageKeyedDataSource;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J1\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u000e\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0010\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/paging/InitialDataSource;", "", "K", "V", "Landroidx/paging/PageKeyedDataSource;", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "params", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "callback", "", "p", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;)V", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "n", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Landroidx/paging/PageKeyedDataSource$LoadCallback;)V", "l", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class InitialDataSource<K, V> extends PageKeyedDataSource<K, V> {
    public void l(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback) {
        Intrinsics.checkNotNullParameter(loadParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadCallback, "callback");
        loadCallback.a(CollectionsKt.emptyList(), (Object) null);
    }

    public void n(PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback) {
        Intrinsics.checkNotNullParameter(loadParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadCallback, "callback");
        loadCallback.a(CollectionsKt.emptyList(), (Object) null);
    }

    public void p(PageKeyedDataSource.LoadInitialParams loadInitialParams, PageKeyedDataSource.LoadInitialCallback loadInitialCallback) {
        Intrinsics.checkNotNullParameter(loadInitialParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadInitialCallback, "callback");
        loadInitialCallback.a(CollectionsKt.emptyList(), 0, 0, (Object) null, (Object) null);
    }
}
