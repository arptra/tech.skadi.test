package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032&\u0010\u0005\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004 \u0007*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/PagingSource;", "kotlin.jvm.PlatformType", "invoke", "(Landroidx/paging/PagingSource;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class InvalidatingPagingSourceFactory$invalidate$1 extends Lambda implements Function1<PagingSource<Object, Object>, Boolean> {
    public static final InvalidatingPagingSourceFactory$invalidate$1 INSTANCE = new InvalidatingPagingSourceFactory$invalidate$1();

    public InvalidatingPagingSourceFactory$invalidate$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(PagingSource<Object, Object> pagingSource) {
        return Boolean.valueOf(pagingSource.a());
    }
}
