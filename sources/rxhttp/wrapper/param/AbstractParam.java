package rxhttp.wrapper.param;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.cache.CacheMode;
import rxhttp.wrapper.cache.CacheStrategy;
import rxhttp.wrapper.callback.IConverter;
import rxhttp.wrapper.param.Param;
import rxhttp.wrapper.utils.BuildUtil;
import rxhttp.wrapper.utils.CacheUtil;

public abstract class AbstractParam<P extends Param<P>> extends Param<P> {
    public String b;
    public Headers.Builder c;
    public final Method d;
    public final CacheStrategy e;
    public List f;
    public List g;
    public final Request.Builder h = new Request.Builder();
    public boolean i = true;

    public AbstractParam(String str, Method method) {
        this.b = str;
        this.d = method;
        this.e = RxHttpPlugins.b();
    }

    public final Headers a() {
        Headers.Builder builder = this.c;
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Param b(Class cls, Object obj) {
        this.h.tag(cls, obj);
        return s();
    }

    public HttpUrl d() {
        return BuildUtil.d(this.b, this.f, this.g);
    }

    public final boolean e() {
        return this.i;
    }

    public final Request f() {
        RxHttpPlugins.h(this);
        return BuildUtil.c(this, this.h);
    }

    public final CacheMode getCacheMode() {
        return this.e.b();
    }

    public Method getMethod() {
        return this.d;
    }

    public final CacheStrategy h() {
        if (l() == null) {
            t(j());
        }
        return this.e;
    }

    public String j() {
        return BuildUtil.d(q(), CacheUtil.b(o()), this.g).toString();
    }

    public final RequestBody k(Object obj) {
        try {
            return m().convert(obj);
        } catch (IOException e2) {
            throw new IllegalArgumentException("Unable to convert " + obj + " to RequestBody", e2);
        }
    }

    public final String l() {
        return this.e.a();
    }

    public IConverter m() {
        IConverter iConverter = (IConverter) p().build().tag(IConverter.class);
        Objects.requireNonNull(iConverter, "converter can not be null");
        return iConverter;
    }

    public List n() {
        return this.g;
    }

    public List o() {
        return this.f;
    }

    public Request.Builder p() {
        return this.h;
    }

    public final String q() {
        return this.b;
    }

    public final String r() {
        return d().toString();
    }

    public Param s() {
        return this;
    }

    public final Param t(String str) {
        this.e.d(str);
        return s();
    }
}
