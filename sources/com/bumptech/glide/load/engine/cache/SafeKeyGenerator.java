package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class SafeKeyGenerator {

    /* renamed from: a  reason: collision with root package name */
    public final LruCache f2531a = new LruCache(1000);
    public final Pools.Pool b = FactoryPools.d(10, new FactoryPools.Factory<PoolableDigestContainer>() {
        /* renamed from: a */
        public PoolableDigestContainer create() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    public static final class PoolableDigestContainer implements FactoryPools.Poolable {

        /* renamed from: a  reason: collision with root package name */
        public final MessageDigest f2533a;
        public final StateVerifier b = StateVerifier.a();

        public PoolableDigestContainer(MessageDigest messageDigest) {
            this.f2533a = messageDigest;
        }

        public StateVerifier f() {
            return this.b;
        }
    }

    public final String a(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.d(this.b.acquire());
        try {
            key.b(poolableDigestContainer.f2533a);
            return Util.y(poolableDigestContainer.f2533a.digest());
        } finally {
            this.b.a(poolableDigestContainer);
        }
    }

    public String b(Key key) {
        String str;
        synchronized (this.f2531a) {
            str = (String) this.f2531a.h(key);
        }
        if (str == null) {
            str = a(key);
        }
        synchronized (this.f2531a) {
            this.f2531a.k(key, str);
        }
        return str;
    }
}
