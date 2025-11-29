package io.netty.handler.ssl.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

public abstract class SimpleKeyManagerFactory extends KeyManagerFactory {
    private static final FastThreadLocal<SimpleKeyManagerFactorySpi> CURRENT_SPI = new FastThreadLocal<SimpleKeyManagerFactorySpi>() {
        public SimpleKeyManagerFactorySpi initialValue() {
            return new SimpleKeyManagerFactorySpi();
        }
    };
    private static final Provider PROVIDER = new Provider("", 0.0d, "") {
        private static final long serialVersionUID = -2680540247105807895L;
    };

    public SimpleKeyManagerFactory() {
        this("");
    }

    public abstract KeyManager[] engineGetKeyManagers();

    public abstract void engineInit(KeyStore keyStore, char[] cArr) throws Exception;

    public abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SimpleKeyManagerFactory(java.lang.String r5) {
        /*
            r4 = this;
            io.netty.util.concurrent.FastThreadLocal<io.netty.handler.ssl.util.SimpleKeyManagerFactory$SimpleKeyManagerFactorySpi> r0 = CURRENT_SPI
            java.lang.Object r1 = r0.get()
            javax.net.ssl.KeyManagerFactorySpi r1 = (javax.net.ssl.KeyManagerFactorySpi) r1
            java.security.Provider r2 = PROVIDER
            java.lang.String r3 = "name"
            java.lang.Object r5 = io.netty.util.internal.ObjectUtil.checkNotNull(r5, r3)
            java.lang.String r5 = (java.lang.String) r5
            r4.<init>(r1, r2, r5)
            java.lang.Object r5 = r0.get()
            io.netty.handler.ssl.util.SimpleKeyManagerFactory$SimpleKeyManagerFactorySpi r5 = (io.netty.handler.ssl.util.SimpleKeyManagerFactory.SimpleKeyManagerFactorySpi) r5
            r5.init(r4)
            r0.remove()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.util.SimpleKeyManagerFactory.<init>(java.lang.String):void");
    }

    public static final class SimpleKeyManagerFactorySpi extends KeyManagerFactorySpi {
        private volatile KeyManager[] keyManagers;
        private SimpleKeyManagerFactory parent;

        private SimpleKeyManagerFactorySpi() {
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static void wrapIfNeeded(KeyManager[] keyManagerArr) {
            for (int i = 0; i < keyManagerArr.length; i++) {
                X509KeyManager x509KeyManager = keyManagerArr[i];
                if ((x509KeyManager instanceof X509KeyManager) && !(x509KeyManager instanceof X509ExtendedKeyManager)) {
                    keyManagerArr[i] = new X509KeyManagerWrapper(x509KeyManager);
                }
            }
        }

        public KeyManager[] engineGetKeyManagers() {
            KeyManager[] keyManagerArr = this.keyManagers;
            if (keyManagerArr == null) {
                keyManagerArr = this.parent.engineGetKeyManagers();
                if (PlatformDependent.javaVersion() >= 7) {
                    wrapIfNeeded(keyManagerArr);
                }
                this.keyManagers = keyManagerArr;
            }
            return (KeyManager[]) keyManagerArr.clone();
        }

        public void engineInit(KeyStore keyStore, char[] cArr) throws KeyStoreException {
            try {
                this.parent.engineInit(keyStore, cArr);
            } catch (KeyStoreException e) {
                throw e;
            } catch (Exception e2) {
                throw new KeyStoreException(e2);
            }
        }

        public void init(SimpleKeyManagerFactory simpleKeyManagerFactory) {
            this.parent = simpleKeyManagerFactory;
        }

        public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            try {
                this.parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e) {
                throw e;
            } catch (Exception e2) {
                throw new InvalidAlgorithmParameterException(e2);
            }
        }
    }
}
