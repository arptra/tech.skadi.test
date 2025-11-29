package io.netty.handler.ssl;

import io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SniHostNameMatcher;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

public final class ReferenceCountedOpenSslServerContext extends ReferenceCountedOpenSslContext {
    private static final byte[] ID = {110, 101, 116, 116, 121};
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslServerContext.class);
    private final OpenSslServerSessionContext sessionContext;

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        public ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = x509ExtendedTrustManager;
        }

        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }
    }

    public static final class OpenSslServerCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        public OpenSslServerCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }

        public void handle(long j, byte[] bArr, byte[][] bArr2) throws Exception {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j);
            if (referenceCountedOpenSslEngine != null) {
                try {
                    this.keyManagerHolder.setKeyMaterialServerSide(referenceCountedOpenSslEngine);
                } catch (Throwable th) {
                    referenceCountedOpenSslEngine.initHandshakeException(th);
                    if (th instanceof Exception) {
                        throw th;
                    }
                    throw new SSLException(th);
                }
            }
        }
    }

    public static final class OpenSslSniHostnameMatcher implements SniHostNameMatcher {
        private final OpenSslEngineMap engineMap;

        public OpenSslSniHostnameMatcher(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }

        public boolean match(long j, String str) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j);
            if (referenceCountedOpenSslEngine != null) {
                return referenceCountedOpenSslEngine.checkSniHostnameMatch(str.getBytes(CharsetUtil.UTF_8));
            }
            ReferenceCountedOpenSslServerContext.logger.warn("No ReferenceCountedOpenSslEngine found for SSL pointer: {}", (Object) Long.valueOf(j));
            return false;
        }
    }

    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        public TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }

        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    public ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2, ClientAuth clientAuth, String[] strArr, boolean z, boolean z2, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        this(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j, j2, clientAuth, strArr, z, z2, str2, entryArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.netty.handler.ssl.OpenSslServerSessionContext newSessionContext(io.netty.handler.ssl.ReferenceCountedOpenSslContext r16, long r17, io.netty.handler.ssl.OpenSslEngineMap r19, java.security.cert.X509Certificate[] r20, javax.net.ssl.TrustManagerFactory r21, java.security.cert.X509Certificate[] r22, java.security.PrivateKey r23, java.lang.String r24, javax.net.ssl.KeyManagerFactory r25, java.lang.String r26, long r27, long r29) throws javax.net.ssl.SSLException {
        /*
            r0 = r17
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r26
            r9 = r27
            r11 = r29
            r13 = 0
            r14 = 10
            r15 = 0
            io.netty.internal.tcnative.SSLContext.setVerify(r0, r13, r14)     // Catch:{ Exception -> 0x0030 }
            boolean r13 = io.netty.handler.ssl.OpenSsl.useKeyManagerFactory()     // Catch:{ Exception -> 0x0030 }
            if (r13 != 0) goto L_0x003b
            if (r25 != 0) goto L_0x0033
            java.lang.String r13 = "keyCertChain"
            io.netty.util.internal.ObjectUtil.checkNotNull(r5, r13)     // Catch:{ Exception -> 0x0030 }
            io.netty.handler.ssl.ReferenceCountedOpenSslContext.setKeyMaterial(r0, r5, r6, r7)     // Catch:{ Exception -> 0x0030 }
            r5 = r15
            goto L_0x0079
        L_0x002d:
            r0 = move-exception
            goto L_0x012e
        L_0x0030:
            r0 = move-exception
            goto L_0x0126
        L_0x0033:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "KeyManagerFactory not supported"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0030 }
            throw r0     // Catch:{ Exception -> 0x0030 }
        L_0x003b:
            if (r25 != 0) goto L_0x0066
            char[] r13 = io.netty.handler.ssl.SslContext.keyStorePassword(r24)     // Catch:{ Exception -> 0x0030 }
            java.security.KeyStore r5 = io.netty.handler.ssl.SslContext.buildKeyStore(r5, r6, r13, r8)     // Catch:{ Exception -> 0x0030 }
            java.util.Enumeration r6 = r5.aliases()     // Catch:{ Exception -> 0x0030 }
            boolean r6 = r6.hasMoreElements()     // Catch:{ Exception -> 0x0030 }
            if (r6 == 0) goto L_0x0055
            io.netty.handler.ssl.OpenSslX509KeyManagerFactory r6 = new io.netty.handler.ssl.OpenSslX509KeyManagerFactory     // Catch:{ Exception -> 0x0030 }
            r6.<init>()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0062
        L_0x0055:
            io.netty.handler.ssl.OpenSslCachingX509KeyManagerFactory r6 = new io.netty.handler.ssl.OpenSslCachingX509KeyManagerFactory     // Catch:{ Exception -> 0x0030 }
            java.lang.String r14 = javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x0030 }
            javax.net.ssl.KeyManagerFactory r14 = javax.net.ssl.KeyManagerFactory.getInstance(r14)     // Catch:{ Exception -> 0x0030 }
            r6.<init>(r14)     // Catch:{ Exception -> 0x0030 }
        L_0x0062:
            r6.init(r5, r13)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0068
        L_0x0066:
            r6 = r25
        L_0x0068:
            io.netty.handler.ssl.OpenSslKeyMaterialProvider r5 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.providerFor(r6, r7)     // Catch:{ Exception -> 0x0030 }
            io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback r6 = new io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$OpenSslServerCertificateCallback     // Catch:{ Exception -> 0x0124 }
            io.netty.handler.ssl.OpenSslKeyMaterialManager r7 = new io.netty.handler.ssl.OpenSslKeyMaterialManager     // Catch:{ Exception -> 0x0124 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0124 }
            r6.<init>(r2, r7)     // Catch:{ Exception -> 0x0124 }
            io.netty.internal.tcnative.SSLContext.setCertificateCallback(r0, r6)     // Catch:{ Exception -> 0x0124 }
        L_0x0079:
            if (r3 == 0) goto L_0x008a
            javax.net.ssl.TrustManagerFactory r3 = io.netty.handler.ssl.SslContext.buildTrustManagerFactory((java.security.cert.X509Certificate[]) r3, (javax.net.ssl.TrustManagerFactory) r4, (java.lang.String) r8)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            goto L_0x0099
        L_0x0080:
            r0 = move-exception
            r15 = r5
            goto L_0x012e
        L_0x0084:
            r0 = move-exception
            goto L_0x011b
        L_0x0087:
            r0 = move-exception
            goto L_0x0123
        L_0x008a:
            if (r4 != 0) goto L_0x0098
            java.lang.String r3 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            javax.net.ssl.TrustManagerFactory r3 = javax.net.ssl.TrustManagerFactory.getInstance(r3)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            r3.init(r15)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            goto L_0x0099
        L_0x0098:
            r3 = r4
        L_0x0099:
            javax.net.ssl.TrustManager[] r3 = r3.getTrustManagers()     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            javax.net.ssl.X509TrustManager r3 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.chooseTrustManager(r3)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            setVerifyCallback(r0, r2, r3)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            java.security.cert.X509Certificate[] r4 = r3.getAcceptedIssuers()     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            r6 = 0
            if (r4 == 0) goto L_0x00de
            int r8 = r4.length     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            if (r8 <= 0) goto L_0x00de
            io.netty.buffer.ByteBufAllocator r8 = io.netty.buffer.ByteBufAllocator.DEFAULT     // Catch:{ all -> 0x00d9 }
            long r13 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO((io.netty.buffer.ByteBufAllocator) r8, (java.security.cert.X509Certificate[]) r4)     // Catch:{ all -> 0x00d9 }
            boolean r4 = io.netty.internal.tcnative.SSLContext.setCACertificateBio(r0, r13)     // Catch:{ all -> 0x00d6 }
            if (r4 == 0) goto L_0x00bf
            io.netty.handler.ssl.ReferenceCountedOpenSslContext.freeBio(r13)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            goto L_0x00de
        L_0x00bf:
            javax.net.ssl.SSLException r0 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x00d6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d6 }
            r1.<init>()     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "unable to setup accepted issuers for trustmanager "
            r1.append(r2)     // Catch:{ all -> 0x00d6 }
            r1.append(r3)     // Catch:{ all -> 0x00d6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d6 }
            r0.<init>(r1)     // Catch:{ all -> 0x00d6 }
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            r0 = move-exception
            r6 = r13
            goto L_0x00da
        L_0x00d9:
            r0 = move-exception
        L_0x00da:
            io.netty.handler.ssl.ReferenceCountedOpenSslContext.freeBio(r6)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            throw r0     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
        L_0x00de:
            int r3 = io.netty.util.internal.PlatformDependent.javaVersion()     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            r4 = 8
            if (r3 < r4) goto L_0x00ee
            io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$OpenSslSniHostnameMatcher r3 = new io.netty.handler.ssl.ReferenceCountedOpenSslServerContext$OpenSslSniHostnameMatcher     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            r3.<init>(r2)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
            io.netty.internal.tcnative.SSLContext.setSniHostnameMatcher(r0, r3)     // Catch:{ SSLException -> 0x0087, Exception -> 0x0084 }
        L_0x00ee:
            io.netty.handler.ssl.OpenSslServerSessionContext r0 = new io.netty.handler.ssl.OpenSslServerSessionContext     // Catch:{ all -> 0x0080 }
            r1 = r16
            r0.<init>(r1, r5)     // Catch:{ all -> 0x0080 }
            byte[] r1 = ID     // Catch:{ all -> 0x0080 }
            r0.setSessionIdContext(r1)     // Catch:{ all -> 0x0080 }
            boolean r1 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_CACHE     // Catch:{ all -> 0x0080 }
            r0.setSessionCacheEnabled(r1)     // Catch:{ all -> 0x0080 }
            int r1 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r1 <= 0) goto L_0x010e
            long r8 = java.lang.Math.min(r9, r2)     // Catch:{ all -> 0x0080 }
            int r1 = (int) r8     // Catch:{ all -> 0x0080 }
            r0.setSessionCacheSize(r1)     // Catch:{ all -> 0x0080 }
        L_0x010e:
            int r1 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x011a
            long r1 = java.lang.Math.min(r11, r2)     // Catch:{ all -> 0x0080 }
            int r1 = (int) r1     // Catch:{ all -> 0x0080 }
            r0.setSessionTimeout(r1)     // Catch:{ all -> 0x0080 }
        L_0x011a:
            return r0
        L_0x011b:
            javax.net.ssl.SSLException r1 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "unable to setup trustmanager"
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0080 }
            throw r1     // Catch:{ all -> 0x0080 }
        L_0x0123:
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0124:
            r0 = move-exception
            r15 = r5
        L_0x0126:
            javax.net.ssl.SSLException r1 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "failed to set certificate and key"
            r1.<init>(r2, r0)     // Catch:{ all -> 0x002d }
            throw r1     // Catch:{ all -> 0x002d }
        L_0x012e:
            if (r15 == 0) goto L_0x0133
            r15.destroy()
        L_0x0133:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslServerContext.newSessionContext(io.netty.handler.ssl.ReferenceCountedOpenSslContext, long, io.netty.handler.ssl.OpenSslEngineMap, java.security.cert.X509Certificate[], javax.net.ssl.TrustManagerFactory, java.security.cert.X509Certificate[], java.security.PrivateKey, java.lang.String, javax.net.ssl.KeyManagerFactory, java.lang.String, long, long):io.netty.handler.ssl.OpenSslServerSessionContext");
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static void setVerifyCallback(long j, OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
        if (ReferenceCountedOpenSslContext.useExtendedTrustManager(x509TrustManager)) {
            SSLContext.setCertVerifyCallback(j, new ExtendedTrustManagerVerifyCallback(openSslEngineMap, (X509ExtendedTrustManager) x509TrustManager));
        } else {
            SSLContext.setCertVerifyCallback(j, new TrustManagerVerifyCallback(openSslEngineMap, x509TrustManager));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j, long j2, ClientAuth clientAuth, String[] strArr, boolean z, boolean z2, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, 1, x509CertificateArr2, clientAuth, strArr, z, z2, true, entryArr);
        OpenSslServerSessionContext newSessionContext;
        try {
            try {
                newSessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2, j, j2);
            } catch (Throwable th) {
                th = th;
                release();
                throw th;
            }
            try {
                this.sessionContext = newSessionContext;
                if (ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET) {
                    newSessionContext.setTicketKeys(new OpenSslSessionTicketKey[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            release();
            throw th;
        }
    }

    public OpenSslServerSessionContext sessionContext() {
        return this.sessionContext;
    }
}
