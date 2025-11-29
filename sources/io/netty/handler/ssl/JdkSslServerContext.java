package io.netty.handler.ssl;

import com.here.posclient.UpdateOptions;
import java.io.File;
import java.security.KeyStore;
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
public final class JdkSslServerContext extends JdkSslContext {
    @Deprecated
    public JdkSslServerContext(File file, File file2) throws SSLException {
        this((Provider) null, file, file2, (String) null, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0, 0, (String) null);
    }

    private static SSLContext newSSLContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, long j, long j2, String str2) throws SSLException {
        TrustManagerFactory trustManagerFactory2;
        Provider provider2 = provider;
        X509Certificate[] x509CertificateArr3 = x509CertificateArr;
        long j3 = j;
        long j4 = j2;
        if (privateKey == null && keyManagerFactory == null) {
            throw new NullPointerException("key, keyManagerFactory");
        }
        if (x509CertificateArr3 != null) {
            TrustManagerFactory trustManagerFactory3 = trustManagerFactory;
            try {
                trustManagerFactory2 = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
            } catch (Exception e) {
                if (e instanceof SSLException) {
                    throw ((SSLException) e);
                }
                throw new SSLException("failed to initialize the server-side SSL context", e);
            }
        } else {
            trustManagerFactory2 = trustManagerFactory;
        }
        KeyManagerFactory buildKeyManagerFactory = privateKey != null ? SslContext.buildKeyManagerFactory(x509CertificateArr2, (String) null, privateKey, str, keyManagerFactory, (String) null) : keyManagerFactory;
        SSLContext instance = provider2 == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider);
        instance.init(buildKeyManagerFactory.getKeyManagers(), trustManagerFactory2 == null ? null : trustManagerFactory2.getTrustManagers(), (SecureRandom) null);
        SSLSessionContext serverSessionContext = instance.getServerSessionContext();
        if (j3 > 0) {
            serverSessionContext.setSessionCacheSize((int) Math.min(j3, UpdateOptions.SOURCE_ANY));
        }
        if (j4 > 0) {
            serverSessionContext.setSessionTimeout((int) Math.min(j4, UpdateOptions.SOURCE_ANY));
        }
        return instance;
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str) throws SSLException {
        this(file, file2, str, (Iterable<String>) null, (CipherSuiteFilter) IdentityCipherSuiteFilter.INSTANCE, (JdkApplicationProtocolNegotiator) JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0, 0);
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str, Iterable<String> iterable, Iterable<String> iterable2, long j, long j2) throws SSLException {
        this((Provider) null, file, file2, str, iterable, IdentityCipherSuiteFilter.INSTANCE, JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(iterable2), true), j, j2, KeyStore.getDefaultType());
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        this((Provider) null, file, file2, str, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, true), j, j2, KeyStore.getDefaultType());
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j, long j2) throws SSLException {
        this((Provider) null, file, file2, str, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, j, j2, KeyStore.getDefaultType());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JdkSslServerContext(java.security.Provider r17, java.io.File r18, java.io.File r19, java.lang.String r20, java.lang.Iterable<java.lang.String> r21, io.netty.handler.ssl.CipherSuiteFilter r22, io.netty.handler.ssl.JdkApplicationProtocolNegotiator r23, long r24, long r26, java.lang.String r28) throws javax.net.ssl.SSLException {
        /*
            r16 = this;
            java.security.cert.X509Certificate[] r3 = io.netty.handler.ssl.SslContext.toX509CertificatesInternal(r18)
            java.security.PrivateKey r4 = io.netty.handler.ssl.SslContext.toPrivateKeyInternal(r19, r20)
            r6 = 0
            r1 = 0
            r2 = 0
            r0 = r17
            r5 = r20
            r7 = r24
            r9 = r26
            r11 = r28
            javax.net.ssl.SSLContext r8 = newSSLContext(r0, r1, r2, r3, r4, r5, r6, r7, r9, r11)
            io.netty.handler.ssl.ClientAuth r13 = io.netty.handler.ssl.ClientAuth.NONE
            r14 = 0
            r15 = 0
            r9 = 0
            r7 = r16
            r10 = r21
            r11 = r22
            r12 = r23
            r7.<init>((javax.net.ssl.SSLContext) r8, (boolean) r9, (java.lang.Iterable<java.lang.String>) r10, (io.netty.handler.ssl.CipherSuiteFilter) r11, (io.netty.handler.ssl.JdkApplicationProtocolNegotiator) r12, (io.netty.handler.ssl.ClientAuth) r13, (java.lang.String[]) r14, (boolean) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.JdkSslServerContext.<init>(java.security.Provider, java.io.File, java.io.File, java.lang.String, java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.JdkApplicationProtocolNegotiator, long, long, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JdkSslServerContext(java.io.File r22, javax.net.ssl.TrustManagerFactory r23, java.io.File r24, java.io.File r25, java.lang.String r26, javax.net.ssl.KeyManagerFactory r27, java.lang.Iterable<java.lang.String> r28, io.netty.handler.ssl.CipherSuiteFilter r29, io.netty.handler.ssl.ApplicationProtocolConfig r30, long r31, long r33) throws javax.net.ssl.SSLException {
        /*
            r21 = this;
            java.security.cert.X509Certificate[] r1 = io.netty.handler.ssl.SslContext.toX509CertificatesInternal(r22)
            java.security.cert.X509Certificate[] r3 = io.netty.handler.ssl.SslContext.toX509CertificatesInternal(r24)
            java.security.PrivateKey r4 = io.netty.handler.ssl.SslContext.toPrivateKeyInternal(r25, r26)
            r11 = 0
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
            r14 = 0
            r12 = r21
            r15 = r28
            r16 = r29
            r17 = r30
            r12.<init>((javax.net.ssl.SSLContext) r13, (boolean) r14, (java.lang.Iterable<java.lang.String>) r15, (io.netty.handler.ssl.CipherSuiteFilter) r16, (io.netty.handler.ssl.ApplicationProtocolConfig) r17, (io.netty.handler.ssl.ClientAuth) r18, (java.lang.String[]) r19, (boolean) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.JdkSslServerContext.<init>(java.io.File, javax.net.ssl.TrustManagerFactory, java.io.File, java.io.File, java.lang.String, javax.net.ssl.KeyManagerFactory, java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.ApplicationProtocolConfig, long, long):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JdkSslServerContext(java.io.File r22, javax.net.ssl.TrustManagerFactory r23, java.io.File r24, java.io.File r25, java.lang.String r26, javax.net.ssl.KeyManagerFactory r27, java.lang.Iterable<java.lang.String> r28, io.netty.handler.ssl.CipherSuiteFilter r29, io.netty.handler.ssl.JdkApplicationProtocolNegotiator r30, long r31, long r33) throws javax.net.ssl.SSLException {
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
            r14 = 0
            r12 = r21
            r15 = r28
            r16 = r29
            r17 = r30
            r12.<init>((javax.net.ssl.SSLContext) r13, (boolean) r14, (java.lang.Iterable<java.lang.String>) r15, (io.netty.handler.ssl.CipherSuiteFilter) r16, (io.netty.handler.ssl.JdkApplicationProtocolNegotiator) r17, (io.netty.handler.ssl.ClientAuth) r18, (java.lang.String[]) r19, (boolean) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.JdkSslServerContext.<init>(java.io.File, javax.net.ssl.TrustManagerFactory, java.io.File, java.io.File, java.lang.String, javax.net.ssl.KeyManagerFactory, java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.JdkApplicationProtocolNegotiator, long, long):void");
    }

    public JdkSslServerContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2, ClientAuth clientAuth, String[] strArr, boolean z, String str2) throws SSLException {
        super(newSSLContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, j, j2, str2), false, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, true), clientAuth, strArr, z);
    }
}
