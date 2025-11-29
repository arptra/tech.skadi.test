package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public final class KeyTemplates {
    private KeyTemplates() {
    }

    public static KeyTemplate get(String str) throws GeneralSecurityException {
        if (Registry.keyTemplateMap().containsKey(str)) {
            return Registry.keyTemplateMap().get(str);
        }
        throw new GeneralSecurityException("cannot find key template: " + str);
    }
}
