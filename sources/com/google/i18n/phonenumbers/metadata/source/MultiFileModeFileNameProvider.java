package com.google.i18n.phonenumbers.metadata.source;

import com.honey.account.constant.AccountConstantKt;

public final class MultiFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private final String phoneMetadataFileNamePrefix;

    public MultiFileModeFileNameProvider(String str) {
        this.phoneMetadataFileNamePrefix = str + AccountConstantKt.DEFAULT_SEGMENT;
    }

    private boolean isAlphanumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!Character.isLetterOrDigit(codePointAt)) {
                return false;
            }
            i += Character.charCount(codePointAt);
        }
        return true;
    }

    public String getFor(Object obj) {
        String obj2 = obj.toString();
        if (isAlphanumeric(obj2)) {
            return this.phoneMetadataFileNamePrefix + obj;
        }
        throw new IllegalArgumentException("Invalid key: " + obj2);
    }
}
