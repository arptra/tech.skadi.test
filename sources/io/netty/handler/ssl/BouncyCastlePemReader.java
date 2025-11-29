package io.netty.handler.ssl;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.pkcs.PKCSException;

final class BouncyCastlePemReader {
    /* access modifiers changed from: private */
    public static Throwable UNAVAILABILITY_CAUSE;
    /* access modifiers changed from: private */
    public static Boolean attemptedLoading = Boolean.FALSE;
    /* access modifiers changed from: private */
    public static Provider bcProvider;
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) BouncyCastlePemReader.class);

    private BouncyCastlePemReader() {
    }

    public static PrivateKey getPrivateKey(InputStream inputStream, String str) {
        if (!isAvailable()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Bouncy castle provider is unavailable.", unavailabilityCause());
            }
            return null;
        }
        try {
            return getPrivateKey(newParser(inputStream), str);
        } catch (Exception e) {
            logger.debug("Unable to extract private key", (Throwable) e);
            return null;
        }
    }

    public static boolean hasAttemptedLoading() {
        return attemptedLoading.booleanValue();
    }

    public static boolean isAvailable() {
        if (!hasAttemptedLoading()) {
            tryLoading();
        }
        return UNAVAILABILITY_CAUSE == null;
    }

    private static JcaPEMKeyConverter newConverter() {
        return new JcaPEMKeyConverter().setProvider(bcProvider);
    }

    private static PEMParser newParser(File file) throws FileNotFoundException {
        return new PEMParser(new FileReader(file));
    }

    private static void tryLoading() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    Provider unused = BouncyCastlePemReader.bcProvider = (Provider) Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider", true, AnonymousClass1.class.getClassLoader()).getConstructor((Class[]) null).newInstance((Object[]) null);
                    BouncyCastlePemReader.logger.debug("Bouncy Castle provider available");
                    Boolean unused2 = BouncyCastlePemReader.attemptedLoading = Boolean.TRUE;
                    return null;
                } catch (Throwable unused3) {
                }
                return null;
            }
        });
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    private static PEMParser newParser(InputStream inputStream) {
        return new PEMParser(new InputStreamReader(inputStream, CharsetUtil.US_ASCII));
    }

    public static PrivateKey getPrivateKey(File file, String str) {
        if (!isAvailable()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Bouncy castle provider is unavailable.", unavailabilityCause());
            }
            return null;
        }
        try {
            return getPrivateKey(newParser(file), str);
        } catch (Exception e) {
            logger.debug("Unable to extract private key", (Throwable) e);
            return null;
        }
    }

    private static PrivateKey getPrivateKey(PEMParser pEMParser, String str) throws IOException, PKCSException, OperatorCreationException {
        PrivateKey privateKey;
        try {
            Object readObject = pEMParser.readObject();
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Parsed PEM object of type {} and assume key is {}encrypted", readObject.getClass().getName(), str == null ? "not " : "");
            }
            JcaPEMKeyConverter newConverter = newConverter();
            if (str == null) {
                if (readObject instanceof PrivateKeyInfo) {
                    privateKey = newConverter.getPrivateKey((PrivateKeyInfo) readObject);
                } else if (readObject instanceof PEMKeyPair) {
                    privateKey = newConverter.getKeyPair((PEMKeyPair) readObject).getPrivate();
                } else {
                    internalLogger.debug("Unable to handle PEM object of type {} as a non encrypted key", (Object) readObject.getClass());
                }
                if (privateKey == null && internalLogger.isDebugEnabled()) {
                    internalLogger.debug("No key found");
                }
                pEMParser.close();
                return privateKey;
            }
            if (readObject instanceof PEMEncryptedKeyPair) {
                privateKey = newConverter.getKeyPair(((PEMEncryptedKeyPair) readObject).decryptKeyPair(new JcePEMDecryptorProviderBuilder().setProvider(bcProvider).build(str.toCharArray()))).getPrivate();
            } else if (readObject instanceof PKCS8EncryptedPrivateKeyInfo) {
                privateKey = newConverter.getPrivateKey(((PKCS8EncryptedPrivateKeyInfo) readObject).decryptPrivateKeyInfo(new JceOpenSSLPKCS8DecryptorProviderBuilder().setProvider(bcProvider).build(str.toCharArray())));
            } else {
                internalLogger.debug("Unable to handle PEM object of type {} as a encrypted key", (Object) readObject.getClass());
            }
            internalLogger.debug("No key found");
            pEMParser.close();
            return privateKey;
            privateKey = null;
            internalLogger.debug("No key found");
            try {
                pEMParser.close();
            } catch (Exception e) {
                logger.debug("Failed closing pem parser", (Throwable) e);
            }
            return privateKey;
        } catch (Throwable th) {
            if (pEMParser != null) {
                try {
                    pEMParser.close();
                } catch (Exception e2) {
                    logger.debug("Failed closing pem parser", (Throwable) e2);
                }
            }
            throw th;
        }
    }
}
