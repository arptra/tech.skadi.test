package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/client/plugins/cache/storage/UnlimitedCacheStorage;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpCacheStorage$Companion$Unlimited$1 extends Lambda implements Function0<UnlimitedCacheStorage> {
    public static final HttpCacheStorage$Companion$Unlimited$1 INSTANCE = new HttpCacheStorage$Companion$Unlimited$1();

    public HttpCacheStorage$Companion$Unlimited$1() {
        super(0);
    }

    @NotNull
    public final UnlimitedCacheStorage invoke() {
        return new UnlimitedCacheStorage();
    }
}
