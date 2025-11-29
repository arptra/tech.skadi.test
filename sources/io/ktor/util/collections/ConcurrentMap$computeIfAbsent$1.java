package io.ktor.util.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Value", "Key", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentMap$computeIfAbsent$1 extends Lambda implements Function1<Key, Value> {
    final /* synthetic */ Function0<Value> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConcurrentMap$computeIfAbsent$1(Function0<? extends Value> function0) {
        super(1);
        this.$block = function0;
    }

    public final Value invoke(Key key) {
        return this.$block.invoke();
    }
}
