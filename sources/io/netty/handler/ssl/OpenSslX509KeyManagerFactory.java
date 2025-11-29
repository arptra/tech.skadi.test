package io.netty.handler.ssl;

import com.upuphone.runasone.relay.api.IntentKey;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509KeyManager;

public final class OpenSslX509KeyManagerFactory extends KeyManagerFactory {
    private final OpenSslKeyManagerFactorySpi spi;

    public static final class OpenSslKeyStore extends KeyStore {
        private OpenSslKeyStore(final X509Certificate[] x509CertificateArr, final boolean z) {
            super(new KeyStoreSpi() {
                private final Date creationDate = new Date();

                public Enumeration<String> engineAliases() {
                    return Collections.enumeration(Collections.singleton(IntentKey.ACTIVITY.ACTION_KEY));
                }

                public boolean engineContainsAlias(String str) {
                    return IntentKey.ACTIVITY.ACTION_KEY.equals(str);
                }

                public void engineDeleteEntry(String str) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }

                public Certificate engineGetCertificate(String str) {
                    if (engineContainsAlias(str)) {
                        return x509CertificateArr[0];
                    }
                    return null;
                }

                public String engineGetCertificateAlias(Certificate certificate) {
                    if (!(certificate instanceof X509Certificate)) {
                        return null;
                    }
                    for (X509Certificate equals : x509CertificateArr) {
                        if (equals.equals(certificate)) {
                            return IntentKey.ACTIVITY.ACTION_KEY;
                        }
                    }
                    return null;
                }

                public Certificate[] engineGetCertificateChain(String str) {
                    if (engineContainsAlias(str)) {
                        return (X509Certificate[]) x509CertificateArr.clone();
                    }
                    return null;
                }

                public Date engineGetCreationDate(String str) {
                    if (engineContainsAlias(str)) {
                        return this.creationDate;
                    }
                    return null;
                }

                public Key engineGetKey(String str, char[] cArr) throws UnrecoverableKeyException {
                    long j;
                    String str2 = null;
                    if (!engineContainsAlias(str)) {
                        return null;
                    }
                    if (z) {
                        j = 0;
                    } else {
                        if (cArr != null) {
                            try {
                                str2 = new String(cArr);
                            } catch (Exception e) {
                                UnrecoverableKeyException unrecoverableKeyException = new UnrecoverableKeyException("Unable to load key from engine");
                                unrecoverableKeyException.initCause(e);
                                throw unrecoverableKeyException;
                            }
                        }
                        j = SSL.loadPrivateKeyFromEngine(str, str2);
                    }
                    return new OpenSslPrivateKey(j);
                }

                public boolean engineIsCertificateEntry(String str) {
                    return engineContainsAlias(str);
                }

                public boolean engineIsKeyEntry(String str) {
                    return engineContainsAlias(str);
                }

                public void engineLoad(InputStream inputStream, char[] cArr) {
                    if (inputStream != null && cArr != null) {
                        throw new UnsupportedOperationException();
                    }
                }

                public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }

                public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }

                public int engineSize() {
                    return 1;
                }

                public void engineStore(OutputStream outputStream, char[] cArr) {
                    throw new UnsupportedOperationException();
                }

                public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
                    throw new KeyStoreException("Not supported");
                }
            }, (Provider) null, "native");
            OpenSsl.ensureAvailability();
        }
    }

    public OpenSslX509KeyManagerFactory() {
        this(newOpenSslKeyManagerFactorySpi((Provider) null));
    }

    public static OpenSslX509KeyManagerFactory newEngineBased(File file, String str) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        return newEngineBased(SslContext.toX509Certificates(file), str);
    }

    public static OpenSslX509KeyManagerFactory newKeyless(File file) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        return newKeyless(SslContext.toX509Certificates(file));
    }

    private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(Provider provider) {
        try {
            return newOpenSslKeyManagerFactorySpi((String) null, provider);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public OpenSslKeyMaterialProvider newProvider() {
        return this.spi.newProvider();
    }

    public OpenSslX509KeyManagerFactory(Provider provider) {
        this(newOpenSslKeyManagerFactorySpi(provider));
    }

    public static OpenSslX509KeyManagerFactory newEngineBased(X509Certificate[] x509CertificateArr, String str) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        ObjectUtil.checkNotNull(x509CertificateArr, "certificateChain");
        char[] cArr = null;
        OpenSslKeyStore openSslKeyStore = new OpenSslKeyStore((X509Certificate[]) x509CertificateArr.clone(), false);
        openSslKeyStore.load((InputStream) null, (char[]) null);
        OpenSslX509KeyManagerFactory openSslX509KeyManagerFactory = new OpenSslX509KeyManagerFactory();
        if (str != null) {
            cArr = str.toCharArray();
        }
        openSslX509KeyManagerFactory.init(openSslKeyStore, cArr);
        return openSslX509KeyManagerFactory;
    }

    public static OpenSslX509KeyManagerFactory newKeyless(InputStream inputStream) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        return newKeyless(SslContext.toX509Certificates(inputStream));
    }

    public OpenSslX509KeyManagerFactory(String str, Provider provider) throws NoSuchAlgorithmException {
        this(newOpenSslKeyManagerFactorySpi(str, provider));
    }

    public static OpenSslX509KeyManagerFactory newKeyless(X509Certificate... x509CertificateArr) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        ObjectUtil.checkNotNull(x509CertificateArr, "certificateChain");
        OpenSslKeyStore openSslKeyStore = new OpenSslKeyStore((X509Certificate[]) x509CertificateArr.clone(), true);
        openSslKeyStore.load((InputStream) null, (char[]) null);
        OpenSslX509KeyManagerFactory openSslX509KeyManagerFactory = new OpenSslX509KeyManagerFactory();
        openSslX509KeyManagerFactory.init(openSslKeyStore, (char[]) null);
        return openSslX509KeyManagerFactory;
    }

    private static OpenSslKeyManagerFactorySpi newOpenSslKeyManagerFactorySpi(String str, Provider provider) throws NoSuchAlgorithmException {
        KeyManagerFactory keyManagerFactory;
        if (str == null) {
            str = KeyManagerFactory.getDefaultAlgorithm();
        }
        if (provider == null) {
            keyManagerFactory = KeyManagerFactory.getInstance(str);
        } else {
            keyManagerFactory = KeyManagerFactory.getInstance(str, provider);
        }
        return new OpenSslKeyManagerFactorySpi(keyManagerFactory);
    }

    private OpenSslX509KeyManagerFactory(OpenSslKeyManagerFactorySpi openSslKeyManagerFactorySpi) {
        super(openSslKeyManagerFactorySpi, openSslKeyManagerFactorySpi.kmf.getProvider(), openSslKeyManagerFactorySpi.kmf.getAlgorithm());
        this.spi = openSslKeyManagerFactorySpi;
    }

    public static final class OpenSslKeyManagerFactorySpi extends KeyManagerFactorySpi {
        final KeyManagerFactory kmf;
        private volatile ProviderFactory providerFactory;

        public static final class ProviderFactory {
            private final Iterable<String> aliases;
            /* access modifiers changed from: private */
            public final X509KeyManager keyManager;
            private final String password;

            public static final class OpenSslPopulatedKeyMaterialProvider extends OpenSslKeyMaterialProvider {
                private final Map<String, Object> materialMap = new HashMap();

                public OpenSslPopulatedKeyMaterialProvider(X509KeyManager x509KeyManager, String str, Iterable<String> iterable) {
                    super(x509KeyManager, str);
                    String next;
                    try {
                        Iterator<String> it = iterable.iterator();
                        while (it.hasNext()) {
                            next = it.next();
                            if (next != null && !this.materialMap.containsKey(next)) {
                                this.materialMap.put(next, super.chooseKeyMaterial(UnpooledByteBufAllocator.DEFAULT, next));
                            }
                        }
                        ObjectUtil.checkNonEmpty(this.materialMap, "materialMap");
                    } catch (Exception e) {
                        this.materialMap.put(next, e);
                    } catch (Throwable th) {
                        destroy();
                        throw th;
                    }
                }

                public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator byteBufAllocator, String str) throws Exception {
                    Object obj = this.materialMap.get(str);
                    if (obj == null) {
                        return null;
                    }
                    if (obj instanceof OpenSslKeyMaterial) {
                        return ((OpenSslKeyMaterial) obj).retain();
                    }
                    throw ((Exception) obj);
                }

                public void destroy() {
                    for (Object release : this.materialMap.values()) {
                        ReferenceCountUtil.release(release);
                    }
                    this.materialMap.clear();
                }
            }

            public ProviderFactory(X509KeyManager x509KeyManager, String str, Iterable<String> iterable) {
                this.keyManager = x509KeyManager;
                this.password = str;
                this.aliases = iterable;
            }

            public OpenSslKeyMaterialProvider newProvider() {
                return new OpenSslPopulatedKeyMaterialProvider(this.keyManager, this.password, this.aliases);
            }
        }

        public OpenSslKeyManagerFactorySpi(KeyManagerFactory keyManagerFactory) {
            this.kmf = (KeyManagerFactory) ObjectUtil.checkNotNull(keyManagerFactory, "kmf");
        }

        private static String password(char[] cArr) {
            if (cArr == null || cArr.length == 0) {
                return null;
            }
            return new String(cArr);
        }

        public KeyManager[] engineGetKeyManagers() {
            ProviderFactory providerFactory2 = this.providerFactory;
            if (providerFactory2 != null) {
                return new KeyManager[]{providerFactory2.keyManager};
            }
            throw new IllegalStateException("engineInit(...) not called yet");
        }

        public synchronized void engineInit(KeyStore keyStore, char[] cArr) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
            if (this.providerFactory != null) {
                throw new KeyStoreException("Already initialized");
            } else if (keyStore.aliases().hasMoreElements()) {
                this.kmf.init(keyStore, cArr);
                this.providerFactory = new ProviderFactory(ReferenceCountedOpenSslContext.chooseX509KeyManager(this.kmf.getKeyManagers()), password(cArr), Collections.list(keyStore.aliases()));
            } else {
                throw new KeyStoreException("No aliases found");
            }
        }

        public OpenSslKeyMaterialProvider newProvider() {
            ProviderFactory providerFactory2 = this.providerFactory;
            if (providerFactory2 != null) {
                return providerFactory2.newProvider();
            }
            throw new IllegalStateException("engineInit(...) not called yet");
        }

        public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("Not supported");
        }
    }
}
