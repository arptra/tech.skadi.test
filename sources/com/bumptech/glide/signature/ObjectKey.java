package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class ObjectKey implements Key {
    public final Object b;

    public ObjectKey(Object obj) {
        this.b = Preconditions.d(obj);
    }

    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(Key.f2451a));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.b.equals(((ObjectKey) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }
}
