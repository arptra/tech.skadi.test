package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class PageFetcher$generateNewPagingSource$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public PageFetcher$generateNewPagingSource$3(Object obj) {
        super(0, obj, PageFetcher.class, "invalidate", "invalidate()V", 0);
    }

    public final void invoke() {
        ((PageFetcher) this.receiver).j();
    }
}
