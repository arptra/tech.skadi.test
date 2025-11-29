package androidx.paging;

import androidx.paging.DataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0002*\u00020\u0004\"\b\b\u0003\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "Key", "Value", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class DataSource$Factory$asPagingSourceFactory$1 extends Lambda implements Function0<PagingSource<Object, Object>> {
    final /* synthetic */ CoroutineDispatcher $fetchDispatcher;
    final /* synthetic */ DataSource.Factory<Object, Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataSource$Factory$asPagingSourceFactory$1(CoroutineDispatcher coroutineDispatcher, DataSource.Factory<Object, Object> factory) {
        super(0);
        this.$fetchDispatcher = coroutineDispatcher;
        this.this$0 = factory;
    }

    @NotNull
    public final PagingSource<Object, Object> invoke() {
        return new LegacyPagingSource(this.$fetchDispatcher, this.this$0.a());
    }
}
