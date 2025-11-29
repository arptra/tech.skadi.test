package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature implements Key {
    public final String b;
    public final long c;
    public final int d;

    public void b(MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.c).putInt(this.d).array());
        messageDigest.update(this.b.getBytes(Key.f2451a));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.c == mediaStoreSignature.c && this.d == mediaStoreSignature.d && this.b.equals(mediaStoreSignature.b);
    }

    public int hashCode() {
        long j = this.c;
        return (((this.b.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.d;
    }
}
