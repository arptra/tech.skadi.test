package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;

public final class PrfConfig {
    public static final String PRF_TYPE_URL = new HkdfPrfKeyManager().getKeyType();

    private PrfConfig() {
    }

    public static void register() throws GeneralSecurityException {
        AesCmacPrfKeyManager.register(true);
        HkdfPrfKeyManager.register(true);
        HmacPrfKeyManager.register(true);
        PrfSetWrapper.register();
    }
}
