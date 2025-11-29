package androidx.room.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final /* synthetic */ class LimitOffsetPagingSource$observer$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public LimitOffsetPagingSource$observer$1(Object obj) {
        super(0, obj, LimitOffsetPagingSource.class, "invalidate", "invalidate()V", 0);
    }

    public final void invoke() {
        ((LimitOffsetPagingSource) this.receiver).e();
    }
}
