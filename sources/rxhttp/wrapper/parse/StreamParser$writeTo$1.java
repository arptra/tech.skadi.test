package rxhttp.wrapper.parse;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import rxhttp.wrapper.callback.ProgressCallbackHelper;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StreamParser$writeTo$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ProgressCallbackHelper $callback;
    final /* synthetic */ Ref.LongRef $contentLength;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StreamParser$writeTo$1(ProgressCallbackHelper progressCallbackHelper, Ref.LongRef longRef) {
        super(1);
        this.$callback = progressCallbackHelper;
        this.$contentLength = longRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$callback.a((long) i, this.$contentLength.element);
    }
}
