package rxhttp.wrapper.param;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.cache.CacheMode;
import rxhttp.wrapper.cache.CacheStrategy;
import rxhttp.wrapper.callback.IConverter;
import rxhttp.wrapper.callback.OutputStreamFactory;
import rxhttp.wrapper.intercept.CacheInterceptor;
import rxhttp.wrapper.intercept.LogInterceptor;
import rxhttp.wrapper.intercept.RangeInterceptor;
import rxhttp.wrapper.param.Param;
import rxhttp.wrapper.param.RxHttp;
import rxhttp.wrapper.utils.LogUtil;

@SourceDebugExtension({"SMAP\nRxHttp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxHttp.kt\nrxhttp/wrapper/param/RxHttp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,530:1\n1#2:531\n*E\n"})
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 =*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u00020\u0004:\u0001@B\u0011\b\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0015J-\u0010\u001e\u001a\u00028\u0001\"\u0004\b\u0002\u0010\u001a2\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u001b2\u0006\u0010\u001d\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b!\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010*R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010/R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u00101R$\u00107\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u00103\u001a\u0004\b4\u0010%\"\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00101R\u0011\u0010<\u001a\u00020:8G¢\u0006\u0006\u001a\u0004\b8\u0010;R\u0011\u0010?\u001a\u0002008G¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lrxhttp/wrapper/param/RxHttp;", "Lrxhttp/wrapper/param/Param;", "P", "R", "Lrxhttp/wrapper/param/BaseRxHttp;", "param", "<init>", "(Lrxhttp/wrapper/param/Param;)V", "", "g", "()V", "Lrxhttp/wrapper/callback/IConverter;", "converter", "m", "(Lrxhttp/wrapper/callback/IConverter;)V", "d", "l", "()Lrxhttp/wrapper/param/RxHttp;", "", "connectTimeout", "f", "(J)Lrxhttp/wrapper/param/RxHttp;", "readTimeout", "k", "writeTimeout", "o", "T", "Ljava/lang/Class;", "type", "tag", "n", "(Ljava/lang/Class;Ljava/lang/Object;)Lrxhttp/wrapper/param/RxHttp;", "Lokhttp3/Call;", "a", "()Lokhttp3/Call;", "Lokhttp3/Request;", "e", "()Lokhttp3/Request;", "Lrxhttp/wrapper/param/Param;", "j", "()Lrxhttp/wrapper/param/Param;", "b", "J", "connectTimeoutMillis", "c", "readTimeoutMillis", "writeTimeoutMillis", "Lrxhttp/wrapper/callback/IConverter;", "Lokhttp3/OkHttpClient;", "Lokhttp3/OkHttpClient;", "okClient", "Lokhttp3/Request;", "getRequest", "setRequest", "(Lokhttp3/Request;)V", "request", "h", "_okHttpClient", "Lrxhttp/wrapper/cache/CacheStrategy;", "()Lrxhttp/wrapper/cache/CacheStrategy;", "cacheStrategy", "i", "()Lokhttp3/OkHttpClient;", "okHttpClient", "Companion", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public class RxHttp<P extends Param<P>, R extends RxHttp<P, R>> extends BaseRxHttp {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Param f3562a;
    public long b;
    public long c;
    public long d;
    public IConverter e;
    public OkHttpClient f;
    public Request g;
    public OkHttpClient h;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lrxhttp/wrapper/param/RxHttp$Companion;", "", "<init>", "()V", "", "url", "", "formatArgs", "Lrxhttp/wrapper/param/RxHttpNoBodyParam;", "b", "(Ljava/lang/String;[Ljava/lang/Object;)Lrxhttp/wrapper/param/RxHttpNoBodyParam;", "a", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str, Object... objArr) {
            if (objArr.length == 0) {
                return str;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }

        public final RxHttpNoBodyParam b(String str, Object... objArr) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(objArr, "formatArgs");
            NoBodyParam i = Param.i(a(str, Arrays.copyOf(objArr, objArr.length)));
            Intrinsics.checkNotNullExpressionValue(i, "get(...)");
            return new RxHttpNoBodyParam(i);
        }

        public Companion() {
        }
    }

    public RxHttp(Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.f3562a = param;
        IConverter c2 = RxHttpPlugins.c();
        Intrinsics.checkNotNullExpressionValue(c2, "getConverter(...)");
        this.e = c2;
        OkHttpClient f2 = RxHttpPlugins.f();
        Intrinsics.checkNotNullExpressionValue(f2, "getOkHttpClient(...)");
        this.f = f2;
    }

    public Call a() {
        return i().newCall(e());
    }

    public final void d() {
    }

    public final Request e() {
        if (this.g == null) {
            g();
            this.g = this.f3562a.f();
        }
        Request request = this.g;
        Intrinsics.checkNotNull(request);
        return request;
    }

    public final RxHttp f(long j) {
        this.b = j;
        return l();
    }

    public final void g() {
        m(this.e);
        d();
    }

    public final CacheStrategy h() {
        CacheStrategy h2 = this.f3562a.h();
        Intrinsics.checkNotNullExpressionValue(h2, "getCacheStrategy(...)");
        return h2;
    }

    public final OkHttpClient i() {
        OkHttpClient.Builder builder;
        OkHttpClient build;
        OkHttpClient okHttpClient = this.h;
        if (okHttpClient != null) {
            Intrinsics.checkNotNull(okHttpClient);
            return okHttpClient;
        }
        OkHttpClient okHttpClient2 = this.f;
        if (LogUtil.g()) {
            builder = okHttpClient2.newBuilder();
            builder.addInterceptor(new LogInterceptor(okHttpClient2));
        } else {
            builder = null;
        }
        if (this.b != 0) {
            if (builder == null) {
                builder = okHttpClient2.newBuilder();
            }
            builder.connectTimeout(this.b, TimeUnit.MILLISECONDS);
        }
        if (this.c != 0) {
            if (builder == null) {
                builder = okHttpClient2.newBuilder();
            }
            builder.readTimeout(this.c, TimeUnit.MILLISECONDS);
        }
        if (this.d != 0) {
            if (builder == null) {
                builder = okHttpClient2.newBuilder();
            }
            builder.writeTimeout(this.d, TimeUnit.MILLISECONDS);
        }
        if (this.f3562a.getCacheMode() != CacheMode.ONLY_NETWORK) {
            if (builder == null) {
                builder = okHttpClient2.newBuilder();
            }
            builder.addInterceptor(new CacheInterceptor(h()));
        }
        if (!(builder == null || (build = builder.build()) == null)) {
            okHttpClient2 = build;
        }
        this.h = okHttpClient2;
        Intrinsics.checkNotNull(okHttpClient2);
        return okHttpClient2;
    }

    public final Param j() {
        return this.f3562a;
    }

    public final RxHttp k(long j) {
        this.c = j;
        return l();
    }

    public final RxHttp l() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type R of rxhttp.wrapper.param.RxHttp");
        return this;
    }

    public final void m(IConverter iConverter) {
        this.f3562a.b(IConverter.class, iConverter);
    }

    /* renamed from: n */
    public RxHttp b(Class cls, Object obj) {
        Intrinsics.checkNotNullParameter(cls, "type");
        this.f3562a.b(cls, obj);
        if (cls == OutputStreamFactory.class) {
            this.f = this.f.newBuilder().addInterceptor(new RangeInterceptor()).build();
        }
        return l();
    }

    public final RxHttp o(long j) {
        this.d = j;
        return l();
    }
}
