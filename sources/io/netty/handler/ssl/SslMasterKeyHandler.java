package io.netty.handler.ssl;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;

public abstract class SslMasterKeyHandler extends ChannelInboundHandlerAdapter {
    private static final Class<?> SSL_SESSIONIMPL_CLASS;
    private static final Field SSL_SESSIONIMPL_MASTER_SECRET_FIELD;
    public static final String SYSTEM_PROP_KEY = "io.netty.ssl.masterKeyHandler";
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SslMasterKeyHandler.class);

    public static final class WiresharkSslMasterKeyHandler extends SslMasterKeyHandler {
        private static final InternalLogger wireshark_logger = InternalLoggerFactory.getInstance("io.netty.wireshark");

        private WiresharkSslMasterKeyHandler() {
        }

        public void accept(SecretKey secretKey, SSLSession sSLSession) {
            if (secretKey.getEncoded().length == 48) {
                wireshark_logger.warn("RSA Session-ID:{} Master-Key:{}", ByteBufUtil.hexDump(sSLSession.getId()).toLowerCase(), ByteBufUtil.hexDump(secretKey.getEncoded()).toLowerCase());
                return;
            }
            throw new IllegalArgumentException("An invalid length master key was provided.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    static {
        /*
            java.lang.Class<io.netty.handler.ssl.SslMasterKeyHandler> r0 = io.netty.handler.ssl.SslMasterKeyHandler.class
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r0)
            logger = r0
            r0 = 0
            java.lang.String r1 = "sun.security.ssl.SSLSessionImpl"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = "masterSecret"
            java.lang.reflect.Field r0 = r1.getDeclaredField(r2)     // Catch:{ all -> 0x001b }
            r2 = 1
            java.lang.Throwable r2 = io.netty.util.internal.ReflectionUtil.trySetAccessible(r0, r2)     // Catch:{ all -> 0x001b }
            goto L_0x003d
        L_0x001b:
            r2 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0023
        L_0x0020:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0023:
            io.netty.util.internal.logging.InternalLogger r3 = logger
            boolean r4 = r3.isTraceEnabled()
            if (r4 == 0) goto L_0x0031
            java.lang.String r4 = "sun.security.ssl.SSLSessionImpl is unavailable."
            r3.debug((java.lang.String) r4, (java.lang.Throwable) r2)
            goto L_0x003a
        L_0x0031:
            java.lang.String r4 = "sun.security.ssl.SSLSessionImpl is unavailable: {}"
            java.lang.String r5 = r2.getMessage()
            r3.debug((java.lang.String) r4, (java.lang.Object) r5)
        L_0x003a:
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x003d:
            UNAVAILABILITY_CAUSE = r2
            SSL_SESSIONIMPL_CLASS = r1
            SSL_SESSIONIMPL_MASTER_SECRET_FIELD = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslMasterKeyHandler.<clinit>():void");
    }

    public static void ensureSunSslEngineAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw new IllegalStateException("Failed to find SSLSessionImpl on classpath", th);
        }
    }

    public static boolean isSunSslEngineAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static SslMasterKeyHandler newWireSharkSslMasterKeyHandler() {
        return new WiresharkSslMasterKeyHandler();
    }

    public static Throwable sunSslEngineUnavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    public abstract void accept(SecretKey secretKey, SSLSession sSLSession);

    public boolean masterKeyHandlerEnabled() {
        return SystemPropertyUtil.getBoolean(SYSTEM_PROP_KEY, false);
    }

    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj == SslHandshakeCompletionEvent.SUCCESS && masterKeyHandlerEnabled()) {
            SSLEngine engine = ((SslHandler) channelHandlerContext.pipeline().get(SslHandler.class)).engine();
            SSLSession session = engine.getSession();
            if (isSunSslEngineAvailable() && session.getClass().equals(SSL_SESSIONIMPL_CLASS)) {
                try {
                    accept((SecretKey) SSL_SESSIONIMPL_MASTER_SECRET_FIELD.get(session), session);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Failed to access the field 'masterSecret' via reflection.", e);
                }
            } else if (OpenSsl.isAvailable() && (engine instanceof ReferenceCountedOpenSslEngine)) {
                accept(((ReferenceCountedOpenSslEngine) engine).masterKey(), session);
            }
        }
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
