package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    public OpenSslServerSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        super(referenceCountedOpenSslContext, openSslKeyMaterialProvider, SSL.SSL_SESS_CACHE_SERVER, new OpenSslSessionCache(referenceCountedOpenSslContext.engineMap));
    }

    public boolean setSessionIdContext(byte[] bArr) {
        Lock writeLock = this.context.ctxLock.writeLock();
        writeLock.lock();
        try {
            return SSLContext.setSessionIdContext(this.context.ctx, bArr);
        } finally {
            writeLock.unlock();
        }
    }
}
