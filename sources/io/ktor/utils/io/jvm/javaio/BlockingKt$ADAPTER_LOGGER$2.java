package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BlockingKt$ADAPTER_LOGGER$2 extends Lambda implements Function0<Logger> {
    public static final BlockingKt$ADAPTER_LOGGER$2 INSTANCE = new BlockingKt$ADAPTER_LOGGER$2();

    public BlockingKt$ADAPTER_LOGGER$2() {
        super(0);
    }

    public final Logger invoke() {
        return LoggerFactory.k(BlockingAdapter.class);
    }
}
