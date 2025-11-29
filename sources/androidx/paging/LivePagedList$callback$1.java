package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Key", "", "Value", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class LivePagedList$callback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LivePagedList<Object, Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LivePagedList$callback$1(LivePagedList<Object, Object> livePagedList) {
        super(0);
        this.this$0 = livePagedList;
    }

    public final void invoke() {
        this.this$0.o(true);
    }
}
