package io.netty.handler.ssl;

import io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class ReferenceCountedOpenSslClientContext extends ReferenceCountedOpenSslContext {
    /* access modifiers changed from: private */
    public static final Set<String> SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(new String[]{"RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC"})));
    private final OpenSslSessionContext sessionContext;

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        public ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = x509ExtendedTrustManager;
        }

        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }
    }

    public static final class OpenSslClientCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        public OpenSslClientCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }

        private static String clientKeyType(byte b) {
            if (b == 1) {
                return "RSA";
            }
            if (b == 3) {
                return "DH_RSA";
            }
            switch (b) {
                case 64:
                    return "EC";
                case 65:
                    return "EC_RSA";
                case 66:
                    return "EC_EC";
                default:
                    return null;
            }
        }

        private static Set<String> supportedClientKeyTypes(byte[] bArr) {
            if (bArr == null) {
                return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
            }
            HashSet hashSet = new HashSet(bArr.length);
            for (byte clientKeyType : bArr) {
                String clientKeyType2 = clientKeyType(clientKeyType);
                if (clientKeyType2 != null) {
                    hashSet.add(clientKeyType2);
                }
            }
            return hashSet;
        }

        public void handle(long j, byte[] bArr, byte[][] bArr2) throws Exception {
            X500Principal[] x500PrincipalArr;
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j);
            if (referenceCountedOpenSslEngine != null) {
                try {
                    Set<String> supportedClientKeyTypes = supportedClientKeyTypes(bArr);
                    String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[0]);
                    if (bArr2 == null) {
                        x500PrincipalArr = null;
                    } else {
                        X500Principal[] x500PrincipalArr2 = new X500Principal[bArr2.length];
                        for (int i = 0; i < bArr2.length; i++) {
                            x500PrincipalArr2[i] = new X500Principal(bArr2[i]);
                        }
                        x500PrincipalArr = x500PrincipalArr2;
                    }
                    this.keyManagerHolder.setKeyMaterialClientSide(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
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

    public static final class OpenSslClientSessionContext extends OpenSslSessionContext {
        public OpenSslClientSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
            super(referenceCountedOpenSslContext, openSslKeyMaterialProvider, SSL.SSL_SESS_CACHE_CLIENT, new OpenSslClientSessionCache(referenceCountedOpenSslContext.engineMap));
        }
    }

    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        public TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }

        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferenceCountedOpenSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j, long j2, boolean z, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        super(iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), 0, x509CertificateArr2, ClientAuth.NONE, strArr, false, z, true, entryArr);
        try {
            try {
            } catch (Throwable th) {
                th = th;
                release();
                throw th;
            }
            try {
                this.sessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2, j, j2);
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

    /* JADX WARNING: Removed duplicated region for block: B:69:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.netty.handler.ssl.OpenSslSessionContext newSessionContext(io.netty.handler.ssl.ReferenceCountedOpenSslContext r16, long r17, io.netty.handler.ssl.OpenSslEngineMap r19, java.security.cert.X509Certificate[] r20, javax.net.ssl.TrustManagerFactory r21, java.security.cert.X509Certificate[] r22, java.security.PrivateKey r23, java.lang.String r24, javax.net.ssl.KeyManagerFactory r25, java.lang.String r26, long r27, long r29) throws javax.net.ssl.SSLException {
        /*
            r0 = r17
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r12 = r29
            if (r6 != 0) goto L_0x001a
            if (r5 != 0) goto L_0x001f
        L_0x001a:
            if (r6 == 0) goto L_0x0027
            if (r5 == 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Either both keyCertChain and key needs to be null or none of them"
            r0.<init>(r1)
            throw r0
        L_0x0027:
            r14 = 0
            boolean r15 = io.netty.handler.ssl.OpenSsl.useKeyManagerFactory()     // Catch:{ Exception -> 0x0039 }
            if (r15 != 0) goto L_0x0046
            if (r8 != 0) goto L_0x003e
            if (r5 == 0) goto L_0x003c
            io.netty.handler.ssl.ReferenceCountedOpenSslContext.setKeyMaterial(r0, r5, r6, r7)     // Catch:{ Exception -> 0x0039 }
            goto L_0x003c
        L_0x0036:
            r0 = move-exception
            goto L_0x0108
        L_0x0039:
            r0 = move-exception
            goto L_0x0100
        L_0x003c:
            r5 = r14
            goto L_0x0096
        L_0x003e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = "KeyManagerFactory not supported"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0039 }
            throw r0     // Catch:{ Exception -> 0x0039 }
        L_0x0046:
            if (r8 != 0) goto L_0x0077
            if (r5 == 0) goto L_0x0077
            char[] r8 = io.netty.handler.ssl.SslContext.keyStorePassword(r24)     // Catch:{ Exception -> 0x0039 }
            java.security.KeyStore r5 = io.netty.handler.ssl.SslContext.buildKeyStore(r5, r6, r8, r9)     // Catch:{ Exception -> 0x0039 }
            java.util.Enumeration r6 = r5.aliases()     // Catch:{ Exception -> 0x0039 }
            boolean r6 = r6.hasMoreElements()     // Catch:{ Exception -> 0x0039 }
            if (r6 == 0) goto L_0x0062
            io.netty.handler.ssl.OpenSslX509KeyManagerFactory r6 = new io.netty.handler.ssl.OpenSslX509KeyManagerFactory     // Catch:{ Exception -> 0x0039 }
            r6.<init>()     // Catch:{ Exception -> 0x0039 }
            goto L_0x006f
        L_0x0062:
            io.netty.handler.ssl.OpenSslCachingX509KeyManagerFactory r6 = new io.netty.handler.ssl.OpenSslCachingX509KeyManagerFactory     // Catch:{ Exception -> 0x0039 }
            java.lang.String r15 = javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x0039 }
            javax.net.ssl.KeyManagerFactory r15 = javax.net.ssl.KeyManagerFactory.getInstance(r15)     // Catch:{ Exception -> 0x0039 }
            r6.<init>(r15)     // Catch:{ Exception -> 0x0039 }
        L_0x006f:
            r6.init(r5, r8)     // Catch:{ Exception -> 0x0039 }
            io.netty.handler.ssl.OpenSslKeyMaterialProvider r5 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.providerFor(r6, r7)     // Catch:{ Exception -> 0x0039 }
            goto L_0x007f
        L_0x0077:
            if (r8 == 0) goto L_0x007e
            io.netty.handler.ssl.OpenSslKeyMaterialProvider r5 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.providerFor(r8, r7)     // Catch:{ Exception -> 0x0039 }
            goto L_0x007f
        L_0x007e:
            r5 = r14
        L_0x007f:
            if (r5 == 0) goto L_0x0096
            io.netty.handler.ssl.OpenSslKeyMaterialManager r6 = new io.netty.handler.ssl.OpenSslKeyMaterialManager     // Catch:{ Exception -> 0x0093 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0093 }
            io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$OpenSslClientCertificateCallback r7 = new io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$OpenSslClientCertificateCallback     // Catch:{ Exception -> 0x0093 }
            r7.<init>(r2, r6)     // Catch:{ Exception -> 0x0093 }
            io.netty.internal.tcnative.SSLContext.setCertificateCallback(r0, r7)     // Catch:{ Exception -> 0x0093 }
            goto L_0x0096
        L_0x008f:
            r0 = move-exception
            r14 = r5
            goto L_0x0108
        L_0x0093:
            r0 = move-exception
            r14 = r5
            goto L_0x0100
        L_0x0096:
            r6 = 1
            r7 = 10
            io.netty.internal.tcnative.SSLContext.setVerify(r0, r6, r7)     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x00a5
            javax.net.ssl.TrustManagerFactory r3 = io.netty.handler.ssl.SslContext.buildTrustManagerFactory((java.security.cert.X509Certificate[]) r3, (javax.net.ssl.TrustManagerFactory) r4, (java.lang.String) r9)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00b4
        L_0x00a3:
            r0 = move-exception
            goto L_0x00f3
        L_0x00a5:
            if (r4 != 0) goto L_0x00b3
            java.lang.String r3 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x00a3 }
            javax.net.ssl.TrustManagerFactory r3 = javax.net.ssl.TrustManagerFactory.getInstance(r3)     // Catch:{ Exception -> 0x00a3 }
            r3.init(r14)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00b4
        L_0x00b3:
            r3 = r4
        L_0x00b4:
            javax.net.ssl.TrustManager[] r3 = r3.getTrustManagers()     // Catch:{ Exception -> 0x00a3 }
            javax.net.ssl.X509TrustManager r3 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.chooseTrustManager(r3)     // Catch:{ Exception -> 0x00a3 }
            setVerifyCallback(r0, r2, r3)     // Catch:{ Exception -> 0x00a3 }
            io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$OpenSslClientSessionContext r0 = new io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$OpenSslClientSessionContext     // Catch:{ all -> 0x008f }
            r1 = r16
            r0.<init>(r1, r5)     // Catch:{ all -> 0x008f }
            boolean r1 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_CACHE     // Catch:{ all -> 0x008f }
            r0.setSessionCacheEnabled(r1)     // Catch:{ all -> 0x008f }
            r1 = 0
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r3 <= 0) goto L_0x00dc
            long r3 = java.lang.Math.min(r10, r6)     // Catch:{ all -> 0x008f }
            int r3 = (int) r3     // Catch:{ all -> 0x008f }
            r0.setSessionCacheSize(r3)     // Catch:{ all -> 0x008f }
        L_0x00dc:
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e8
            long r1 = java.lang.Math.min(r12, r6)     // Catch:{ all -> 0x008f }
            int r1 = (int) r1     // Catch:{ all -> 0x008f }
            r0.setSessionTimeout(r1)     // Catch:{ all -> 0x008f }
        L_0x00e8:
            boolean r1 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x00f2
            r1 = 0
            io.netty.handler.ssl.OpenSslSessionTicketKey[] r1 = new io.netty.handler.ssl.OpenSslSessionTicketKey[r1]     // Catch:{ all -> 0x008f }
            r0.setTicketKeys((io.netty.handler.ssl.OpenSslSessionTicketKey[]) r1)     // Catch:{ all -> 0x008f }
        L_0x00f2:
            return r0
        L_0x00f3:
            if (r5 == 0) goto L_0x00f8
            r5.destroy()     // Catch:{ all -> 0x008f }
        L_0x00f8:
            javax.net.ssl.SSLException r1 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "unable to setup trustmanager"
            r1.<init>(r2, r0)     // Catch:{ all -> 0x008f }
            throw r1     // Catch:{ all -> 0x008f }
        L_0x0100:
            javax.net.ssl.SSLException r1 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = "failed to set certificate and key"
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0108:
            if (r14 == 0) goto L_0x010d
            r14.destroy()
        L_0x010d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslClientContext.newSessionContext(io.netty.handler.ssl.ReferenceCountedOpenSslContext, long, io.netty.handler.ssl.OpenSslEngineMap, java.security.cert.X509Certificate[], javax.net.ssl.TrustManagerFactory, java.security.cert.X509Certificate[], java.security.PrivateKey, java.lang.String, javax.net.ssl.KeyManagerFactory, java.lang.String, long, long):io.netty.handler.ssl.OpenSslSessionContext");
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static void setVerifyCallback(long j, OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
        if (ReferenceCountedOpenSslContext.useExtendedTrustManager(x509TrustManager)) {
            SSLContext.setCertVerifyCallback(j, new ExtendedTrustManagerVerifyCallback(openSslEngineMap, (X509ExtendedTrustManager) x509TrustManager));
        } else {
            SSLContext.setCertVerifyCallback(j, new TrustManagerVerifyCallback(openSslEngineMap, x509TrustManager));
        }
    }

    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }
}
