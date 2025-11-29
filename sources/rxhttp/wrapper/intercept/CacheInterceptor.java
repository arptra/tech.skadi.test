package rxhttp.wrapper.intercept;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.cache.CacheMode;
import rxhttp.wrapper.cache.CacheStrategy;
import rxhttp.wrapper.cache.InternalCache;
import rxhttp.wrapper.exception.CacheReadFailedException;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lrxhttp/wrapper/intercept/CacheInterceptor;", "Lokhttp3/Interceptor;", "Lrxhttp/wrapper/cache/CacheStrategy;", "cacheStrategy", "<init>", "(Lrxhttp/wrapper/cache/CacheStrategy;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/Request;", "request", "a", "(Lokhttp3/Request;)Lokhttp3/Response;", "", "Lrxhttp/wrapper/cache/CacheMode;", "cacheModes", "", "b", "([Lrxhttp/wrapper/cache/CacheMode;)Z", "", "validTime", "d", "(Lokhttp3/Request;J)Lokhttp3/Response;", "Lrxhttp/wrapper/cache/CacheStrategy;", "Lrxhttp/wrapper/cache/InternalCache;", "Lkotlin/Lazy;", "c", "()Lrxhttp/wrapper/cache/InternalCache;", "cache", "rxhttp"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCacheInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheInterceptor.kt\nrxhttp/wrapper/intercept/CacheInterceptor\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,77:1\n12474#2,2:78\n*S KotlinDebug\n*F\n+ 1 CacheInterceptor.kt\nrxhttp/wrapper/intercept/CacheInterceptor\n*L\n62#1:78,2\n*E\n"})
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final CacheStrategy f3559a;
    public final Lazy b = LazyKt.lazy(CacheInterceptor$cache$2.INSTANCE);

    public CacheInterceptor(CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        this.f3559a = cacheStrategy;
    }

    public final Response a(Request request) {
        CacheMode cacheMode = CacheMode.ONLY_CACHE;
        if (!b(cacheMode, CacheMode.READ_CACHE_FAILED_REQUEST_NETWORK)) {
            return null;
        }
        Response d = d(request, this.f3559a.c());
        if (d != null) {
            return d;
        }
        if (!b(cacheMode)) {
            return null;
        }
        throw new CacheReadFailedException("Cache read failed");
    }

    public final boolean b(CacheMode... cacheModeArr) {
        CacheMode b2 = this.f3559a.b();
        for (CacheMode cacheMode : cacheModeArr) {
            if (cacheMode == b2) {
                return true;
            }
        }
        return false;
    }

    public final InternalCache c() {
        Object value = this.b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (InternalCache) value;
    }

    public final Response d(Request request, long j) {
        Response b2 = c().b(request, this.f3559a.a());
        if (b2 != null) {
            long m = OkHttpCompat.m(b2);
            if (j == LongCompanionObject.MAX_VALUE || System.currentTimeMillis() - m <= j) {
                return b2;
            }
        }
        return null;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response a2 = a(request);
        if (a2 != null) {
            return a2;
        }
        try {
            Response proceed = chain.proceed(request);
            if (b(CacheMode.ONLY_NETWORK)) {
                return proceed;
            }
            Response a3 = c().a(proceed, this.f3559a.a());
            Intrinsics.checkNotNull(a3);
            return a3;
        } catch (Throwable th) {
            Response d = b(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE) ? d(request, this.f3559a.c()) : null;
            if (d != null) {
                return d;
            }
            throw th;
        }
    }
}
