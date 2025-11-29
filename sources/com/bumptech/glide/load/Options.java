package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options implements Key {
    public final ArrayMap b = new CachedHashCodeArrayMap();

    public static void g(Option option, Object obj, MessageDigest messageDigest) {
        option.g(obj, messageDigest);
    }

    public void b(MessageDigest messageDigest) {
        for (int i = 0; i < this.b.size(); i++) {
            g((Option) this.b.j(i), this.b.n(i), messageDigest);
        }
    }

    public Object c(Option option) {
        return this.b.containsKey(option) ? this.b.get(option) : option.c();
    }

    public void d(Options options) {
        this.b.k(options.b);
    }

    public Options e(Option option) {
        this.b.remove(option);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.b.equals(((Options) obj).b);
        }
        return false;
    }

    public Options f(Option option, Object obj) {
        this.b.put(option, obj);
        return this;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }
}
