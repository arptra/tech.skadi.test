package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/paging/PageEvent$Insert;", "T", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MulticastedPagingData$asPagingData$3 extends Lambda implements Function0<PageEvent.Insert<T>> {
    final /* synthetic */ MulticastedPagingData<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MulticastedPagingData$asPagingData$3(MulticastedPagingData<T> multicastedPagingData) {
        super(0);
        this.this$0 = multicastedPagingData;
    }

    @Nullable
    public final PageEvent.Insert<T> invoke() {
        return this.this$0.d.f();
    }
}
