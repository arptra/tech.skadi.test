package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "V", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class KProperty0Impl$delegateValue$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ KProperty0Impl<V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty0Impl$delegateValue$1(KProperty0Impl<? extends V> kProperty0Impl) {
        super(0);
        this.this$0 = kProperty0Impl;
    }

    @Nullable
    public final Object invoke() {
        KProperty0Impl<V> kProperty0Impl = this.this$0;
        return kProperty0Impl.getDelegateImpl(kProperty0Impl.computeDelegateSource(), (Object) null, (Object) null);
    }
}
