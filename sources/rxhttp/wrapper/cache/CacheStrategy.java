package rxhttp.wrapper.cache;

import kotlin.jvm.internal.LongCompanionObject;

public class CacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public String f3538a;
    public long b = LongCompanionObject.MAX_VALUE;
    public CacheMode c;

    public CacheStrategy(CacheStrategy cacheStrategy) {
        this.f3538a = cacheStrategy.f3538a;
        this.c = cacheStrategy.c;
        e(cacheStrategy.b);
    }

    public String a() {
        return this.f3538a;
    }

    public CacheMode b() {
        return this.c;
    }

    public long c() {
        return this.b;
    }

    public void d(String str) {
        this.f3538a = str;
    }

    public void e(long j) {
        if (j > 0) {
            this.b = j;
            return;
        }
        throw new IllegalArgumentException("validTime > 0 required but it was " + j);
    }

    public CacheStrategy(CacheMode cacheMode) {
        this.c = cacheMode;
    }
}
