package io.ktor.utils.io.pool;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class DefaultPool$Companion$Top$1 extends MutablePropertyReference1Impl {
    public static final DefaultPool$Companion$Top$1 INSTANCE = new DefaultPool$Companion$Top$1();

    public DefaultPool$Companion$Top$1() {
        super(DefaultPool.class, "top", "getTop()J", 0);
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        return Long.valueOf(((DefaultPool) obj).f9118top);
    }

    public void set(@Nullable Object obj, @Nullable Object obj2) {
        ((DefaultPool) obj).f9118top = ((Number) obj2).longValue();
    }
}
