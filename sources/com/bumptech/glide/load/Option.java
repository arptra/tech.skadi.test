package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T> {
    public static final CacheKeyUpdater e = new CacheKeyUpdater<Object>() {
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Object f2452a;
    public final CacheKeyUpdater b;
    public final String c;
    public volatile byte[] d;

    public interface CacheKeyUpdater<T> {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    public Option(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        this.c = Preconditions.b(str);
        this.f2452a = obj;
        this.b = (CacheKeyUpdater) Preconditions.d(cacheKeyUpdater);
    }

    public static Option a(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        return new Option(str, obj, cacheKeyUpdater);
    }

    public static CacheKeyUpdater b() {
        return e;
    }

    public static Option e(String str) {
        return new Option(str, (Object) null, b());
    }

    public static Option f(String str, Object obj) {
        return new Option(str, obj, b());
    }

    public Object c() {
        return this.f2452a;
    }

    public final byte[] d() {
        if (this.d == null) {
            this.d = this.c.getBytes(Key.f2451a);
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.c.equals(((Option) obj).c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + '\'' + '}';
    }
}
