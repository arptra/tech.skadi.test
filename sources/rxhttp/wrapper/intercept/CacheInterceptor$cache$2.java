package rxhttp.wrapper.intercept;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.cache.InternalCache;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lrxhttp/wrapper/cache/InternalCache;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class CacheInterceptor$cache$2 extends Lambda implements Function0<InternalCache> {
    public static final CacheInterceptor$cache$2 INSTANCE = new CacheInterceptor$cache$2();

    public CacheInterceptor$cache$2() {
        super(0);
    }

    public final InternalCache invoke() {
        return RxHttpPlugins.a();
    }
}
