package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.IdentityHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001c\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0002H\u0016¢\u0006\u0004\b \u0010!R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R,\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R \u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0014\u0010,\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Landroidx/paging/WrapperItemKeyedDataSource;", "", "K", "A", "B", "Landroidx/paging/ItemKeyedDataSource;", "source", "Landroidx/arch/core/util/Function;", "", "listFunction", "<init>", "(Landroidx/paging/ItemKeyedDataSource;Landroidx/arch/core/util/Function;)V", "Landroidx/paging/DataSource$InvalidatedCallback;", "onInvalidatedCallback", "", "a", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "h", "d", "()V", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "params", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "callback", "p", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;)V", "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "l", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Landroidx/paging/ItemKeyedDataSource$LoadCallback;)V", "n", "item", "k", "(Ljava/lang/Object;)Ljava/lang/Object;", "f", "Landroidx/paging/ItemKeyedDataSource;", "g", "Landroidx/arch/core/util/Function;", "Ljava/util/IdentityHashMap;", "Ljava/util/IdentityHashMap;", "keyMap", "", "e", "()Z", "isInvalid", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {
    public final ItemKeyedDataSource f;
    public final Function g;
    public final IdentityHashMap h = new IdentityHashMap();

    public WrapperItemKeyedDataSource(ItemKeyedDataSource itemKeyedDataSource, Function function) {
        Intrinsics.checkNotNullParameter(itemKeyedDataSource, "source");
        Intrinsics.checkNotNullParameter(function, "listFunction");
        this.f = itemKeyedDataSource;
        this.g = function;
    }

    public void a(DataSource.InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.f.a(invalidatedCallback);
    }

    public void d() {
        this.f.d();
    }

    public boolean e() {
        return this.f.e();
    }

    public void h(DataSource.InvalidatedCallback invalidatedCallback) {
        Intrinsics.checkNotNullParameter(invalidatedCallback, "onInvalidatedCallback");
        this.f.h(invalidatedCallback);
    }

    public Object k(Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(obj, "item");
        synchronized (this.h) {
            obj2 = this.h.get(obj);
            Intrinsics.checkNotNull(obj2);
        }
        return obj2;
    }

    public void l(ItemKeyedDataSource.LoadParams loadParams, ItemKeyedDataSource.LoadCallback loadCallback) {
        Intrinsics.checkNotNullParameter(loadParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadCallback, "callback");
        this.f.l(loadParams, new WrapperItemKeyedDataSource$loadAfter$1(loadCallback, this));
    }

    public void n(ItemKeyedDataSource.LoadParams loadParams, ItemKeyedDataSource.LoadCallback loadCallback) {
        Intrinsics.checkNotNullParameter(loadParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadCallback, "callback");
        this.f.n(loadParams, new WrapperItemKeyedDataSource$loadBefore$1(loadCallback, this));
    }

    public void p(ItemKeyedDataSource.LoadInitialParams loadInitialParams, ItemKeyedDataSource.LoadInitialCallback loadInitialCallback) {
        Intrinsics.checkNotNullParameter(loadInitialParams, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(loadInitialCallback, "callback");
        this.f.p(loadInitialParams, new WrapperItemKeyedDataSource$loadInitial$1(loadInitialCallback, this));
    }
}
