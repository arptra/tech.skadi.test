package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class AwaitKt$awaitOne$2$1$onSubscribe$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Mode $mode;
    final /* synthetic */ Subscription $sub;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitKt$awaitOne$2$1$onSubscribe$3(Subscription subscription, Mode mode) {
        super(0);
        this.$sub = subscription;
        this.$mode = mode;
    }

    public final void invoke() {
        Subscription subscription = this.$sub;
        Mode mode = this.$mode;
        subscription.request((mode == Mode.FIRST || mode == Mode.FIRST_OR_DEFAULT) ? 1 : LongCompanionObject.MAX_VALUE);
    }
}
