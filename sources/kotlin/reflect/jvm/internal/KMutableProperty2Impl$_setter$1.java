package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "D", "E", "V", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class KMutableProperty2Impl$_setter$1 extends Lambda implements Function0<KMutableProperty2Impl.Setter<D, E, V>> {
    final /* synthetic */ KMutableProperty2Impl<D, E, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl$_setter$1(KMutableProperty2Impl<D, E, V> kMutableProperty2Impl) {
        super(0);
        this.this$0 = kMutableProperty2Impl;
    }

    @NotNull
    public final KMutableProperty2Impl.Setter<D, E, V> invoke() {
        return new KMutableProperty2Impl.Setter<>(this.this$0);
    }
}
