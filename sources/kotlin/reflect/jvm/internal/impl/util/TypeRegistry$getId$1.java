package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class TypeRegistry$getId$1 extends Lambda implements Function1<String, Integer> {
    final /* synthetic */ TypeRegistry<K, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeRegistry$getId$1(TypeRegistry<K, V> typeRegistry) {
        super(1);
        this.this$0 = typeRegistry;
    }

    @NotNull
    public final Integer invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return Integer.valueOf(this.this$0.idCounter.getAndIncrement());
    }
}
