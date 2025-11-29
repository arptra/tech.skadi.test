package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey implements Key {
    public final Object b;
    public final int c;
    public final int d;
    public final Class e;
    public final Class f;
    public final Key g;
    public final Map h;
    public final Options i;
    public int j;

    public EngineKey(Object obj, Key key, int i2, int i3, Map map, Class cls, Class cls2, Options options) {
        this.b = Preconditions.d(obj);
        this.g = (Key) Preconditions.e(key, "Signature must not be null");
        this.c = i2;
        this.d = i3;
        this.h = (Map) Preconditions.d(map);
        this.e = (Class) Preconditions.e(cls, "Resource class must not be null");
        this.f = (Class) Preconditions.e(cls2, "Transcode class must not be null");
        this.i = (Options) Preconditions.d(options);
    }

    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        return this.b.equals(engineKey.b) && this.g.equals(engineKey.g) && this.d == engineKey.d && this.c == engineKey.c && this.h.equals(engineKey.h) && this.e.equals(engineKey.e) && this.f.equals(engineKey.f) && this.i.equals(engineKey.i);
    }

    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.b.hashCode();
            this.j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.g.hashCode()) * 31) + this.c) * 31) + this.d;
            this.j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
