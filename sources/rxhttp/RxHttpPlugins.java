package rxhttp;

import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import rxhttp.wrapper.cache.CacheMode;
import rxhttp.wrapper.cache.CacheStrategy;
import rxhttp.wrapper.cache.InternalCache;
import rxhttp.wrapper.callback.Consumer;
import rxhttp.wrapper.callback.Function;
import rxhttp.wrapper.callback.IConverter;
import rxhttp.wrapper.converter.GsonConverter;
import rxhttp.wrapper.param.Param;

public class RxHttpPlugins {
    public static final RxHttpPlugins h = new RxHttpPlugins();

    /* renamed from: a  reason: collision with root package name */
    public OkHttpClient f3526a;
    public Consumer b;
    public Function c;
    public IConverter d = GsonConverter.b();
    public List e = Collections.emptyList();
    public InternalCache f;
    public CacheStrategy g = new CacheStrategy(CacheMode.ONLY_NETWORK);

    public static InternalCache a() {
        InternalCache internalCache = h.f;
        if (internalCache != null) {
            return internalCache;
        }
        throw new IllegalArgumentException("Call 'setCache(File,long)' method to set the cache directory and size before using the cache");
    }

    public static CacheStrategy b() {
        return new CacheStrategy(h.g);
    }

    public static IConverter c() {
        return h.d;
    }

    public static OkHttpClient d() {
        return new OkHttpClient.Builder().build();
    }

    public static List e() {
        return h.e;
    }

    public static OkHttpClient f() {
        RxHttpPlugins rxHttpPlugins = h;
        if (rxHttpPlugins.f3526a == null) {
            g(d());
        }
        return rxHttpPlugins.f3526a;
    }

    public static RxHttpPlugins g(OkHttpClient okHttpClient) {
        RxHttpPlugins rxHttpPlugins = h;
        rxHttpPlugins.f3526a = okHttpClient;
        return rxHttpPlugins;
    }

    public static void h(Param param) {
        Consumer consumer;
        if (param.e() && (consumer = h.b) != null) {
            consumer.accept(param);
        }
    }

    public static String i(String str) {
        Function function = h.c;
        return function != null ? (String) function.apply(str) : str;
    }
}
