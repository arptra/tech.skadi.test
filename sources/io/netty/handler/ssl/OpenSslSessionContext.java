package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SessionTicketKey;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

public abstract class OpenSslSessionContext implements SSLSessionContext {
    final ReferenceCountedOpenSslContext context;
    private final long mask;
    private final OpenSslKeyMaterialProvider provider;
    /* access modifiers changed from: private */
    public final OpenSslSessionCache sessionCache;
    private final OpenSslSessionStats stats;

    public OpenSslSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider, long j, OpenSslSessionCache openSslSessionCache) {
        this.context = referenceCountedOpenSslContext;
        this.provider = openSslKeyMaterialProvider;
        this.mask = j;
        this.stats = new OpenSslSessionStats(referenceCountedOpenSslContext);
        this.sessionCache = openSslSessionCache;
        SSLContext.setSSLSessionCache(referenceCountedOpenSslContext.ctx, openSslSessionCache);
    }

    public final void destroy() {
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = this.provider;
        if (openSslKeyMaterialProvider != null) {
            openSslKeyMaterialProvider.destroy();
        }
        this.sessionCache.clear();
    }

    public Enumeration<byte[]> getIds() {
        return new Enumeration<byte[]>() {
            private final Iterator<OpenSslSessionId> ids;

            {
                this.ids = OpenSslSessionContext.this.sessionCache.getIds().iterator();
            }

            public boolean hasMoreElements() {
                return this.ids.hasNext();
            }

            public byte[] nextElement() {
                return this.ids.next().cloneBytes();
            }
        };
    }

    public SSLSession getSession(byte[] bArr) {
        return this.sessionCache.getSession(new OpenSslSessionId(bArr));
    }

    public int getSessionCacheSize() {
        return this.sessionCache.getSessionCacheSize();
    }

    public int getSessionTimeout() {
        return this.sessionCache.getSessionTimeout();
    }

    public final boolean isInCache(OpenSslSessionId openSslSessionId) {
        return this.sessionCache.containsSessionWithId(openSslSessionId);
    }

    public boolean isSessionCacheEnabled() {
        Lock readLock = this.context.ctxLock.readLock();
        readLock.lock();
        try {
            return (SSLContext.getSessionCacheMode(this.context.ctx) & this.mask) != 0;
        } finally {
            readLock.unlock();
        }
    }

    public final void removeFromCache(OpenSslSessionId openSslSessionId) {
        this.sessionCache.removeSessionWithId(openSslSessionId);
    }

    public void setSessionCacheEnabled(boolean z) {
        long j = z ? this.mask | SSL.SSL_SESS_CACHE_NO_INTERNAL_LOOKUP | SSL.SSL_SESS_CACHE_NO_INTERNAL_STORE : SSL.SSL_SESS_CACHE_OFF;
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setSessionCacheMode(this.context.ctx, j);
            if (!z) {
                this.sessionCache.clear();
            }
        } finally {
            writeLock.unlock();
        }
    }

    public void setSessionCacheSize(int i) {
        ObjectUtil.checkPositiveOrZero(i, "size");
        this.sessionCache.setSessionCacheSize(i);
    }

    public void setSessionFromCache(String str, int i, long j) {
        this.sessionCache.setSession(j, str, i);
    }

    public void setSessionTimeout(int i) {
        ObjectUtil.checkPositiveOrZero(i, "seconds");
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setSessionCacheTimeout(this.context.ctx, (long) i);
            this.sessionCache.setSessionTimeout(i);
        } finally {
            writeLock.unlock();
        }
    }

    @Deprecated
    public void setTicketKeys(byte[] bArr) {
        if (bArr.length % 48 == 0) {
            int length = bArr.length / 48;
            SessionTicketKey[] sessionTicketKeyArr = new SessionTicketKey[length];
            int i = 0;
            for (int i2 = 0; i2 < length; i2 += 17) {
                int i3 = i + 16;
                i += 32;
                sessionTicketKeyArr[i2 + 16] = new SessionTicketKey(Arrays.copyOfRange(bArr, i, 16), Arrays.copyOfRange(bArr, i3, 16), Arrays.copyOfRange(bArr, i3, 16));
            }
            Lock writeLock = this.context.ctxLock.writeLock();
            writeLock.lock();
            try {
                SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
                SSLContext.setSessionTicketKeys(this.context.ctx, sessionTicketKeyArr);
            } finally {
                writeLock.unlock();
            }
        } else {
            throw new IllegalArgumentException("keys.length % 48 != 0");
        }
    }

    public OpenSslSessionStats stats() {
        return this.stats;
    }

    public final boolean useKeyManager() {
        return this.provider != null;
    }

    public void setTicketKeys(OpenSslSessionTicketKey... openSslSessionTicketKeyArr) {
        ObjectUtil.checkNotNull(openSslSessionTicketKeyArr, "keys");
        int length = openSslSessionTicketKeyArr.length;
        SessionTicketKey[] sessionTicketKeyArr = new SessionTicketKey[length];
        for (int i = 0; i < length; i++) {
            sessionTicketKeyArr[i] = openSslSessionTicketKeyArr[i].key;
        }
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
            if (length > 0) {
                SSLContext.setSessionTicketKeys(this.context.ctx, sessionTicketKeyArr);
            }
        } finally {
            writeLock.unlock();
        }
    }
}
