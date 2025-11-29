package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.mlkit.nl.languageid.LanguageIdentifier;
import java.util.Locale;

class AndroidLocaleFactory implements LocaleFactory {
    @Nullable
    public Locale getLocaleByBcp47(@NonNull String str) {
        Locale forLanguageTag = Locale.forLanguageTag(str);
        if (forLanguageTag.toLanguageTag().equals(LanguageIdentifier.UNDETERMINED_LANGUAGE_TAG)) {
            return null;
        }
        return forLanguageTag;
    }
}
