package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.util.AttributeMap;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.internal.EmptyArrays;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

public abstract class SslContext {
    static final String ALIAS = "key";
    static final CertificateFactory X509_CERT_FACTORY;
    private final AttributeMap attributes;
    private final boolean startTls;

    /* renamed from: io.netty.handler.ssl.SslContext$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.ssl.SslProvider[] r0 = io.netty.handler.ssl.SslProvider.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$ssl$SslProvider = r0
                io.netty.handler.ssl.SslProvider r1 = io.netty.handler.ssl.SslProvider.JDK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$SslProvider     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.ssl.SslProvider r1 = io.netty.handler.ssl.SslProvider.OPENSSL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$SslProvider     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.ssl.SslProvider r1 = io.netty.handler.ssl.SslProvider.OPENSSL_REFCNT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslContext.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        try {
            X509_CERT_FACTORY = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new IllegalStateException("unable to instance X.509 CertificateFactory", e);
        }
    }

    public SslContext() {
        this(false);
    }

    public static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] x509CertificateArr, String str, PrivateKey privateKey, String str2, KeyManagerFactory keyManagerFactory, String str3) throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, UnrecoverableKeyException {
        if (str == null) {
            str = KeyManagerFactory.getDefaultAlgorithm();
        }
        char[] keyStorePassword = keyStorePassword(str2);
        return buildKeyManagerFactory(buildKeyStore(x509CertificateArr, privateKey, keyStorePassword, str3), str, keyStorePassword, keyManagerFactory);
    }

    public static KeyStore buildKeyStore(X509Certificate[] x509CertificateArr, PrivateKey privateKey, char[] cArr, String str) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        if (str == null) {
            str = KeyStore.getDefaultType();
        }
        KeyStore instance = KeyStore.getInstance(str);
        instance.load((InputStream) null, (char[]) null);
        instance.setKeyEntry("key", privateKey, cArr, x509CertificateArr);
        return instance;
    }

    @Deprecated
    public static TrustManagerFactory buildTrustManagerFactory(File file, TrustManagerFactory trustManagerFactory) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {
        return buildTrustManagerFactory(file, trustManagerFactory, (String) null);
    }

    public static SslProvider defaultClientProvider() {
        return defaultProvider();
    }

    private static SslProvider defaultProvider() {
        return OpenSsl.isAvailable() ? SslProvider.OPENSSL : SslProvider.JDK;
    }

    public static SslProvider defaultServerProvider() {
        return defaultProvider();
    }

    @Deprecated
    public static PKCS8EncodedKeySpec generateKeySpec(char[] cArr, byte[] bArr) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (cArr == null) {
            return new PKCS8EncodedKeySpec(bArr);
        }
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(bArr);
        SecretKey generateSecret = SecretKeyFactory.getInstance(encryptedPrivateKeyInfo.getAlgName()).generateSecret(new PBEKeySpec(cArr));
        Cipher instance = Cipher.getInstance(encryptedPrivateKeyInfo.getAlgName());
        instance.init(2, generateSecret, encryptedPrivateKeyInfo.getAlgParameters());
        return encryptedPrivateKeyInfo.getKeySpec(instance);
    }

    private static X509Certificate[] getCertificatesFromBuffers(ByteBuf[] byteBufArr) throws CertificateException {
        ByteBufInputStream byteBufInputStream;
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        X509Certificate[] x509CertificateArr = new X509Certificate[byteBufArr.length];
        int i = 0;
        int i2 = 0;
        while (i2 < byteBufArr.length) {
            try {
                byteBufInputStream = new ByteBufInputStream(byteBufArr[i2], false);
                x509CertificateArr[i2] = (X509Certificate) instance.generateCertificate(byteBufInputStream);
                byteBufInputStream.close();
                i2++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th) {
                int length = byteBufArr.length;
                while (i < length) {
                    byteBufArr[i].release();
                    i++;
                }
                throw th;
            }
        }
        int length2 = byteBufArr.length;
        while (i < length2) {
            byteBufArr[i].release();
            i++;
        }
        return x509CertificateArr;
    }

    private static PrivateKey getPrivateKeyFromByteBuffer(ByteBuf byteBuf, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        byte[] bArr = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bArr).release();
        PKCS8EncodedKeySpec generateKeySpec = generateKeySpec(str == null ? null : str.toCharArray(), bArr);
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(generateKeySpec);
        } catch (InvalidKeySpecException unused) {
            try {
                return KeyFactory.getInstance("DSA").generatePrivate(generateKeySpec);
            } catch (InvalidKeySpecException unused2) {
                try {
                    return KeyFactory.getInstance("EC").generatePrivate(generateKeySpec);
                } catch (InvalidKeySpecException e) {
                    throw new InvalidKeySpecException("Neither RSA, DSA nor EC worked", e);
                }
            }
        }
    }

    public static char[] keyStorePassword(String str) {
        return str == null ? EmptyArrays.EMPTY_CHARS : str.toCharArray();
    }

    @Deprecated
    public static SslContext newClientContext() throws SSLException {
        return newClientContext((SslProvider) null, (File) null, (TrustManagerFactory) null);
    }

    public static SslContext newClientContextInternal(SslProvider sslProvider, Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j, long j2, boolean z, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        Provider provider2 = provider;
        SslProvider defaultClientProvider = sslProvider == null ? defaultClientProvider() : sslProvider;
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[defaultClientProvider.ordinal()];
        if (i != 1) {
            if (i == 2) {
                verifyNullSslContextProvider(defaultClientProvider, provider2);
                OpenSsl.ensureAvailability();
                return new OpenSslClientContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j, j2, z, str2, entryArr);
            } else if (i == 3) {
                verifyNullSslContextProvider(defaultClientProvider, provider2);
                OpenSsl.ensureAvailability();
                return new ReferenceCountedOpenSslClientContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j, j2, z, str2, entryArr);
            } else {
                throw new Error(defaultClientProvider.toString());
            }
        } else if (!z) {
            return new JdkSslClientContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j, j2, str2);
        } else {
            throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + defaultClientProvider);
        }
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2) throws SSLException {
        return newServerContext(file, file2, (String) null);
    }

    public static SslContext newServerContextInternal(SslProvider sslProvider, Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2, ClientAuth clientAuth, String[] strArr, boolean z, boolean z2, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        Provider provider2 = provider;
        SslProvider defaultServerProvider = sslProvider == null ? defaultServerProvider() : sslProvider;
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[defaultServerProvider.ordinal()];
        if (i != 1) {
            if (i == 2) {
                verifyNullSslContextProvider(defaultServerProvider, provider2);
                return new OpenSslServerContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2, clientAuth, strArr, z, z2, str2, entryArr);
            } else if (i == 3) {
                verifyNullSslContextProvider(defaultServerProvider, provider2);
                return new ReferenceCountedOpenSslServerContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2, clientAuth, strArr, z, z2, str2, entryArr);
            } else {
                throw new Error(defaultServerProvider.toString());
            }
        } else if (!z2) {
            return new JdkSslServerContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2, clientAuth, strArr, z, str2);
        } else {
            throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + defaultServerProvider);
        }
    }

    public static ApplicationProtocolConfig toApplicationProtocolConfig(Iterable<String> iterable) {
        return iterable == null ? ApplicationProtocolConfig.DISABLED : new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN_AND_ALPN, ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL, ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT, iterable);
    }

    public static PrivateKey toPrivateKey(File file, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        PrivateKey privateKey;
        if (file == null) {
            return null;
        }
        if (!BouncyCastlePemReader.isAvailable() || (privateKey = BouncyCastlePemReader.getPrivateKey(file, str)) == null) {
            return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(file), str);
        }
        return privateKey;
    }

    public static PrivateKey toPrivateKeyInternal(File file, String str) throws SSLException {
        try {
            return toPrivateKey(file, str);
        } catch (Exception e) {
            throw new SSLException(e);
        }
    }

    public static X509Certificate[] toX509Certificates(File file) throws CertificateException {
        if (file == null) {
            return null;
        }
        return getCertificatesFromBuffers(PemReader.readCertificates(file));
    }

    public static X509Certificate[] toX509CertificatesInternal(File file) throws SSLException {
        try {
            return toX509Certificates(file);
        } catch (CertificateException e) {
            throw new SSLException(e);
        }
    }

    private static void verifyNullSslContextProvider(SslProvider sslProvider, Provider provider) {
        if (provider != null) {
            throw new IllegalArgumentException("Java Security Provider unsupported for SslProvider: " + sslProvider);
        }
    }

    public abstract ApplicationProtocolNegotiator applicationProtocolNegotiator();

    public final AttributeMap attributes() {
        return this.attributes;
    }

    public abstract List<String> cipherSuites();

    public abstract boolean isClient();

    public final boolean isServer() {
        return !isClient();
    }

    public abstract SSLEngine newEngine(ByteBufAllocator byteBufAllocator);

    public abstract SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i);

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator) {
        return newHandler(byteBufAllocator, this.startTls);
    }

    @Deprecated
    public final List<String> nextProtocols() {
        return applicationProtocolNegotiator().protocols();
    }

    public long sessionCacheSize() {
        return (long) sessionContext().getSessionCacheSize();
    }

    public abstract SSLSessionContext sessionContext();

    public long sessionTimeout() {
        return (long) sessionContext().getSessionTimeout();
    }

    public SslContext(boolean z) {
        this.attributes = new DefaultAttributeMap();
        this.startTls = z;
    }

    public static TrustManagerFactory buildTrustManagerFactory(File file, TrustManagerFactory trustManagerFactory, String str) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {
        return buildTrustManagerFactory(toX509Certificates(file), trustManagerFactory, str);
    }

    @Deprecated
    public static SslContext newClientContext(File file) throws SSLException {
        return newClientContext((SslProvider) null, file);
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2, String str) throws SSLException {
        return newServerContext((SslProvider) null, file, file2, str);
    }

    public static X509Certificate[] toX509Certificates(InputStream inputStream) throws CertificateException {
        if (inputStream == null) {
            return null;
        }
        return getCertificatesFromBuffers(PemReader.readCertificates(inputStream));
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z) {
        return new SslHandler(newEngine(byteBufAllocator), z);
    }

    @Deprecated
    public static SslContext newClientContext(TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext((SslProvider) null, (File) null, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2, String str, Iterable<String> iterable, Iterable<String> iterable2, long j, long j2) throws SSLException {
        return newServerContext((SslProvider) null, file, file2, str, iterable, iterable2, j, j2);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, Executor executor) {
        return newHandler(byteBufAllocator, this.startTls, executor);
    }

    public static TrustManagerFactory buildTrustManagerFactory(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, String str) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException {
        if (str == null) {
            str = KeyStore.getDefaultType();
        }
        KeyStore instance = KeyStore.getInstance(str);
        instance.load((InputStream) null, (char[]) null);
        int i = 1;
        for (X509Certificate certificateEntry : x509CertificateArr) {
            instance.setCertificateEntry(Integer.toString(i), certificateEntry);
            i++;
        }
        if (trustManagerFactory == null) {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        }
        trustManagerFactory.init(instance);
        return trustManagerFactory;
    }

    @Deprecated
    public static SslContext newClientContext(File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext((SslProvider) null, file, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        return newServerContext((SslProvider) null, file, file2, str, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2);
    }

    public static PrivateKey toPrivateKey(InputStream inputStream, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, KeyException, IOException {
        PrivateKey privateKey;
        if (inputStream == null) {
            return null;
        }
        if (!BouncyCastlePemReader.isAvailable() || (privateKey = BouncyCastlePemReader.getPrivateKey(inputStream, str)) == null) {
            return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(inputStream), str);
        }
        return privateKey;
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z, Executor executor) {
        return new SslHandler(newEngine(byteBufAllocator), z, executor);
    }

    public static KeyManagerFactory buildKeyManagerFactory(KeyStore keyStore, String str, char[] cArr, KeyManagerFactory keyManagerFactory) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (keyManagerFactory == null) {
            if (str == null) {
                str = KeyManagerFactory.getDefaultAlgorithm();
            }
            keyManagerFactory = KeyManagerFactory.getInstance(str);
        }
        keyManagerFactory.init(keyStore, cArr);
        return keyManagerFactory;
    }

    @Deprecated
    public static SslContext newClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j, long j2) throws SSLException {
        return newClientContext((SslProvider) null, file, trustManagerFactory, iterable, iterable2, j, j2);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2) throws SSLException {
        return newServerContext(sslProvider, file, file2, (String) null);
    }

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i) {
        return newHandler(byteBufAllocator, str, i, this.startTls);
    }

    @Deprecated
    public static SslContext newClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        return newClientContext((SslProvider) null, file, trustManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str) throws SSLException {
        return newServerContext(sslProvider, file, file2, str, (Iterable<String>) null, (CipherSuiteFilter) IdentityCipherSuiteFilter.INSTANCE, (ApplicationProtocolConfig) null, 0, 0);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        return new SslHandler(newEngine(byteBufAllocator, str, i), z);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider) throws SSLException {
        return newClientContext(sslProvider, (File) null, (TrustManagerFactory) null);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str, Iterable<String> iterable, Iterable<String> iterable2, long j, long j2) throws SSLException {
        return newServerContext(sslProvider, file, file2, str, iterable, (CipherSuiteFilter) IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(iterable2), j, j2);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, Executor executor) {
        return newHandler(byteBufAllocator, str, i, this.startTls, executor);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file) throws SSLException {
        return newClientContext(sslProvider, file, (TrustManagerFactory) null);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z, Executor executor) {
        return new SslHandler(newEngine(byteBufAllocator, str, i), z, executor);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(sslProvider, (File) null, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(sslProvider, file, trustManagerFactory, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, (ApplicationProtocolConfig) null, 0, 0);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j, long j2) throws SSLException {
        return newServerContext(sslProvider, (File) null, trustManagerFactory, file, file2, str, (KeyManagerFactory) null, iterable, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(iterable2), j, j2);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j, long j2) throws SSLException {
        return newClientContext(sslProvider, file, trustManagerFactory, (File) null, (File) null, (String) null, (KeyManagerFactory) null, iterable, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(iterable2), j, j2);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        return newServerContext(sslProvider, (File) null, (TrustManagerFactory) null, file, file2, str, (KeyManagerFactory) null, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2, KeyStore.getDefaultType());
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        return newClientContext(sslProvider, file, trustManagerFactory, (File) null, (File) null, (String) null, (KeyManagerFactory) null, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        try {
            return newClientContextInternal(sslProvider, (Provider) null, toX509Certificates(file), trustManagerFactory, toX509Certificates(file2), toPrivateKey(file3, str), str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, (String[]) null, j, j2, false, KeyStore.getDefaultType(), new Map.Entry[0]);
        } catch (Exception e) {
            if (e instanceof SSLException) {
                throw ((SSLException) e);
            }
            throw new SSLException("failed to initialize the client-side SSL context", e);
        }
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2) throws SSLException {
        return newServerContext(sslProvider, file, trustManagerFactory, file2, file3, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2, KeyStore.getDefaultType());
    }

    public static SslContext newServerContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2, String str2) throws SSLException {
        try {
            return newServerContextInternal(sslProvider, (Provider) null, toX509Certificates(file), trustManagerFactory, toX509Certificates(file2), toPrivateKey(file3, str), str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j, j2, ClientAuth.NONE, (String[]) null, false, false, str2, new Map.Entry[0]);
        } catch (Exception e) {
            if (e instanceof SSLException) {
                throw ((SSLException) e);
            }
            throw new SSLException("failed to initialize the server-side SSL context", e);
        }
    }
}
