package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/sync/Mutex;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FileCacheStorage$writeCache$2$mutex$1 extends Lambda implements Function0<Mutex> {
    public static final FileCacheStorage$writeCache$2$mutex$1 INSTANCE = new FileCacheStorage$writeCache$2$mutex$1();

    public FileCacheStorage$writeCache$2$mutex$1() {
        super(0);
    }

    @NotNull
    public final Mutex invoke() {
        return MutexKt.b(false, 1, (Object) null);
    }
}
