package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

public abstract class DelegatingSslContext extends SslContext {
    private final SslContext ctx;

    public DelegatingSslContext(SslContext sslContext) {
        this.ctx = (SslContext) ObjectUtil.checkNotNull(sslContext, "ctx");
    }

    public final ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.ctx.applicationProtocolNegotiator();
    }

    public final List<String> cipherSuites() {
        return this.ctx.cipherSuites();
    }

    public abstract void initEngine(SSLEngine sSLEngine);

    public void initHandler(SslHandler sslHandler) {
        initEngine(sslHandler.engine());
    }

    public final boolean isClient() {
        return this.ctx.isClient();
    }

    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        SSLEngine newEngine = this.ctx.newEngine(byteBufAllocator);
        initEngine(newEngine);
        return newEngine;
    }

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, z);
        initHandler(newHandler);
        return newHandler;
    }

    public final long sessionCacheSize() {
        return this.ctx.sessionCacheSize();
    }

    public final SSLSessionContext sessionContext() {
        return this.ctx.sessionContext();
    }

    public final long sessionTimeout() {
        return this.ctx.sessionTimeout();
    }

    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i) {
        SSLEngine newEngine = this.ctx.newEngine(byteBufAllocator, str, i);
        initEngine(newEngine);
        return newEngine;
    }

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, str, i, z);
        initHandler(newHandler);
        return newHandler;
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z, Executor executor) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, z, executor);
        initHandler(newHandler);
        return newHandler;
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z, Executor executor) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, str, i, z, executor);
        initHandler(newHandler);
        return newHandler;
    }
}
