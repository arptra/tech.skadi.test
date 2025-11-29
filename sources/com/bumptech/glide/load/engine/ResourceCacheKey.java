package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {
    public static final LruCache j = new LruCache(50);
    public final ArrayPool b;
    public final Key c;
    public final Key d;
    public final int e;
    public final int f;
    public final Class g;
    public final Options h;
    public final Transformation i;

    public ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i2, int i3, Transformation transformation, Class cls, Options options) {
        this.b = arrayPool;
        this.c = key;
        this.d = key2;
        this.e = i2;
        this.f = i3;
        this.i = transformation;
        this.g = cls;
        this.h = options;
    }

    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        Transformation transformation = this.i;
        if (transformation != null) {
            transformation.b(messageDigest);
        }
        this.h.b(messageDigest);
        messageDigest.update(c());
        this.b.put(bArr);
    }

    public final byte[] c() {
        LruCache lruCache = j;
        byte[] bArr = (byte[]) lruCache.h(this.g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.g.getName().getBytes(Key.f2451a);
        lruCache.k(this.g, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        return this.f == resourceCacheKey.f && this.e == resourceCacheKey.e && Util.e(this.i, resourceCacheKey.i) && this.g.equals(resourceCacheKey.g) && this.c.equals(resourceCacheKey.c) && this.d.equals(resourceCacheKey.d) && this.h.equals(resourceCacheKey.h);
    }

    public int hashCode() {
        int hashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        Transformation transformation = this.i;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + '\'' + ", options=" + this.h + '}';
    }
}
