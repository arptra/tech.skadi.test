package io.netty.handler.ssl;

import com.here.posclient.UpdateOptions;
import java.io.File;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

@Deprecated
public final class JdkSslClientContext extends JdkSslContext {
    @Deprecated
    public JdkSslClientContext() throws SSLException {
        this((File) null, (TrustManagerFactory) null);
    }

    private static SSLContext newSSLContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, long j, long j2, String str2) throws SSLException {
        TrustManagerFactory trustManagerFactory2;
        Provider provider2 = provider;
        long j3 = j;
        long j4 = j2;
        if (x509CertificateArr != null) {
            TrustManagerFactory trustManagerFactory3 = trustManagerFactory;
            try {
                trustManagerFactory2 = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
            } catch (Exception e) {
                if (e instanceof SSLException) {
                    throw ((SSLException) e);
                }
                throw new SSLException("failed to initialize the client-side SSL context", e);
            }
        } else {
            String str3 = str2;
            trustManagerFactory2 = trustManagerFactory;
        }
        KeyManagerFactory buildKeyManagerFactory = x509CertificateArr2 != null ? SslContext.buildKeyManagerFactory(x509CertificateArr2, (String) null, privateKey, str, keyManagerFactory, str2) : keyManagerFactory;
        SSLContext instance = provider2 == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider);
        instance.init(buildKeyManagerFactory == null ? null : buildKeyManagerFactory.getKeyManagers(), trustManagerFactory2 == null ? null : trustManagerFactory2.getTrustManagers(), (SecureRandom) null);
        SSLSessionContext clientSessionContext = instance.getClientSessionContext();
        if (j3 > 0) {
            clientSessionContext.setSessionCacheSize((int) Math.min(j3, UpdateOptions.SOURCE_ANY));
        }
        if (j4 > 0) {
            clientSessionContext.setSessionTimeout((int) Math.min(j4, UpdateOptions.SOURCE_ANY));
        }
        return instance;
    }

    @Deprecated
    public JdkSslClientContext(File file) throws SSLException {
        this(file, (TrustManagerFactory) null);
    }

    @Deprecated
    public JdkSslClientContext(TrustManagerFactory trustManagerFactory) throws SSLException {
        this((File) null, trustManagerFactory);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        this(file, trustManagerFactory, (Iterable<String>) null, (CipherSuiteFilter) IdentityCipherSuiteFilter.INSTANCE, (JdkApplicationProtocolNegotiator) JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0, 0);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j, long j2) throws SSLException {
        this(file, trustManagerFactory, iterable, (CipherSuiteFilter) IdentityCipherSuiteFilter.INSTANCE, JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(iterable2), false), j, j2);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        this(file, trustManagerFactory, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), j, j2);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j, long j2) throws SSLException {
        this((Provider) null, file, trustManagerFactory, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, j, j2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JdkSslClientContext(java.security.Provider r22, java.io.File r23, javax.net.ssl.TrustManagerFactory r24, java.lang.Iterable<java.lang.String> r25, io.netty.handler.ssl.CipherSuiteFilter r26, io.netty.handler.ssl.JdkApplicationProtocolNegotiator r27, long r28, long r30) throws javax.net.ssl.SSLException {
        /*
            r21 = this;
            java.security.cert.X509Certificate[] r1 = io.netty.handler.ssl.SslContext.toX509CertificatesInternal(r23)
            r6 = 0
            java.lang.String r11 = java.security.KeyStore.getDefaultType()
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r22
            r2 = r24
            r7 = r28
            r9 = r30
            javax.net.ssl.SSLContext r13 = newSSLContext(r0, r1, r2, r3, r4, r5, r6, r7, r9, r11)
            io.netty.handler.ssl.ClientAuth r18 = io.netty.handler.ssl.ClientAuth.NONE
            r19 = 0
            r20 = 0
            r14 = 1
            r12 = r21
            r15 = r25
            r16 = r26
            r17 = r27
            r12.<init>((javax.net.ssl.SSLContext) r13, (boolean) r14, (java.lang.Iterable<java.lang.String>) r15, (io.netty.handler.ssl.CipherSuiteFilter) r16, (io.netty.handler.ssl.JdkApplicationProtocolNegotiator) r17, (io.netty.handler.ssl.ClientAuth) r18, (java.lang.String[]) r19, (boolean) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.JdkSslClientContext.<init>(java.security.Provider, java.io.File, javax.net.ssl.TrustManagerFactory, java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.JdkApplicationProtocolNegotiator, long, long):void");
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        this(file, trustManagerFactory, file2, file3, str, keyManagerFactory, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), j, j2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JdkSslClientContext(java.io.File r22, javax.net.ssl.TrustManagerFactory r23, java.io.File r24, java.io.File r25, java.lang.String r26, javax.net.ssl.KeyManagerFactory r27, java.lang.Iterable<java.lang.String> r28, io.netty.handler.ssl.CipherSuiteFilter r29, io.netty.handler.ssl.JdkApplicationProtocolNegotiator r30, long r31, long r33) throws javax.net.ssl.SSLException {
        /*
            r21 = this;
            java.security.cert.X509Certificate[] r1 = io.netty.handler.ssl.SslContext.toX509CertificatesInternal(r22)
            java.security.cert.X509Certificate[] r3 = io.netty.handler.ssl.SslContext.toX509CertificatesInternal(r24)
            java.security.PrivateKey r4 = io.netty.handler.ssl.SslContext.toPrivateKeyInternal(r25, r26)
            java.lang.String r11 = java.security.KeyStore.getDefaultType()
            r0 = 0
            r2 = r23
            r5 = r26
            r6 = r27
            r7 = r31
            r9 = r33
            javax.net.ssl.SSLContext r13 = newSSLContext(r0, r1, r2, r3, r4, r5, r6, r7, r9, r11)
            io.netty.handler.ssl.ClientAuth r18 = io.netty.handler.ssl.ClientAuth.NONE
            r19 = 0
            r20 = 0
            r14 = 1
            r12 = r21
            r15 = r28
            r16 = r29
            r17 = r30
            r12.<init>((javax.net.ssl.SSLContext) r13, (boolean) r14, (java.lang.Iterable<java.lang.String>) r15, (io.netty.handler.ssl.CipherSuiteFilter) r16, (io.netty.handler.ssl.JdkApplicationProtocolNegotiator) r17, (io.netty.handler.ssl.ClientAuth) r18, (java.lang.String[]) r19, (boolean) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.JdkSslClientContext.<init>(java.io.File, javax.net.ssl.TrustManagerFactory, java.io.File, java.io.File, java.lang.String, javax.net.ssl.KeyManagerFactory, java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.JdkApplicationProtocolNegotiator, long, long):void");
    }

    public JdkSslClientContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j, long j2, String str2) throws SSLException {
        super(newSSLContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, j, j2, str2), true, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), ClientAuth.NONE, strArr, false);
    }
}
