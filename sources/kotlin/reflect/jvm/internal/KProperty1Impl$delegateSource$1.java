package kotlin.reflect.jvm.internal;

import java.lang.reflect.Member;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Member;", "T", "V", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class KProperty1Impl$delegateSource$1 extends Lambda implements Function0<Member> {
    final /* synthetic */ KProperty1Impl<T, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty1Impl$delegateSource$1(KProperty1Impl<T, ? extends V> kProperty1Impl) {
        super(0);
        this.this$0 = kProperty1Impl;
    }

    @Nullable
    public final Member invoke() {
        return this.this$0.computeDelegateSource();
    }
}
