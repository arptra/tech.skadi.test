package com.google.crypto.tink.subtle;

import com.google.android.gms.security.ProviderInstaller;
import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class EngineFactory<T_WRAPPER extends EngineWrapper<T_ENGINE>, T_ENGINE> {
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> CIPHER = new EngineFactory<>(new EngineWrapper.TCipher());
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> KEY_AGREEMENT = new EngineFactory<>(new EngineWrapper.TKeyAgreement());
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> KEY_FACTORY = new EngineFactory<>(new EngineWrapper.TKeyFactory());
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR = new EngineFactory<>(new EngineWrapper.TKeyPairGenerator());
    private static final boolean LET_FALLBACK;
    public static final EngineFactory<EngineWrapper.TMac, Mac> MAC = new EngineFactory<>(new EngineWrapper.TMac());
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> MESSAGE_DIGEST = new EngineFactory<>(new EngineWrapper.TMessageDigest());
    public static final EngineFactory<EngineWrapper.TSignature, Signature> SIGNATURE = new EngineFactory<>(new EngineWrapper.TSignature());
    private static final Logger logger = Logger.getLogger(EngineFactory.class.getName());
    private static final List<Provider> policy;
    private final T_WRAPPER instanceBuilder;

    static {
        if (TinkFips.useOnlyFips()) {
            policy = toProviderList(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt");
            LET_FALLBACK = false;
        } else if (SubtleUtil.isAndroid()) {
            policy = toProviderList(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL");
            LET_FALLBACK = true;
        } else {
            policy = new ArrayList();
            LET_FALLBACK = true;
        }
    }

    public EngineFactory(T_WRAPPER t_wrapper) {
        this.instanceBuilder = t_wrapper;
    }

    public static List<Provider> toProviderList(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                logger.info(String.format("Provider %s not available", new Object[]{str}));
            }
        }
        return arrayList;
    }

    public T_ENGINE getInstance(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider instance : policy) {
            try {
                return this.instanceBuilder.getInstance(str, instance);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (LET_FALLBACK) {
            return this.instanceBuilder.getInstance(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
