package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509KeyManager;

public final class OpenSslCachingX509KeyManagerFactory extends KeyManagerFactory {
    private final int maxCachedEntries;

    public OpenSslCachingX509KeyManagerFactory(KeyManagerFactory keyManagerFactory) {
        this(keyManagerFactory, 1024);
    }

    public OpenSslKeyMaterialProvider newProvider(String str) {
        X509KeyManager chooseX509KeyManager = ReferenceCountedOpenSslContext.chooseX509KeyManager(getKeyManagers());
        return "sun.security.ssl.X509KeyManagerImpl".equals(chooseX509KeyManager.getClass().getName()) ? new OpenSslKeyMaterialProvider(chooseX509KeyManager, str) : new OpenSslCachingKeyMaterialProvider(ReferenceCountedOpenSslContext.chooseX509KeyManager(getKeyManagers()), str, this.maxCachedEntries);
    }

    public OpenSslCachingX509KeyManagerFactory(final KeyManagerFactory keyManagerFactory, int i) {
        super(new KeyManagerFactorySpi() {
            public KeyManager[] engineGetKeyManagers() {
                return keyManagerFactory.getKeyManagers();
            }

            public void engineInit(KeyStore keyStore, char[] cArr) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
                keyManagerFactory.init(keyStore, cArr);
            }

            public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
                keyManagerFactory.init(managerFactoryParameters);
            }
        }, keyManagerFactory.getProvider(), keyManagerFactory.getAlgorithm());
        this.maxCachedEntries = ObjectUtil.checkPositive(i, "maxCachedEntries");
    }
}
