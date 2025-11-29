package com.google.crypto.tink.tinkkey;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.proto.KeyData;
import java.security.GeneralSecurityException;

public final class KeyHandle {
    private final TinkKey key;

    private KeyHandle(TinkKey tinkKey) {
        this.key = tinkKey;
    }

    private void checkAccess(KeyAccess keyAccess) throws GeneralSecurityException {
        if (hasSecret() && !keyAccess.canAccessSecret()) {
            throw new GeneralSecurityException("No access");
        }
    }

    public static KeyHandle createFromKey(TinkKey tinkKey, KeyAccess keyAccess) throws GeneralSecurityException {
        KeyHandle keyHandle = new KeyHandle(tinkKey);
        keyHandle.checkAccess(keyAccess);
        return keyHandle;
    }

    public TinkKey getKey(KeyAccess keyAccess) throws GeneralSecurityException {
        checkAccess(keyAccess);
        return this.key;
    }

    public boolean hasSecret() {
        return this.key.hasSecret();
    }

    public static KeyHandle createFromKey(KeyData keyData, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyHandle(new ProtoKey(keyData, outputPrefixType));
    }
}
