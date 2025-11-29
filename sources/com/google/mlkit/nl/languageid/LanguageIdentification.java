package com.google.mlkit.nl.languageid;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.nl.languageid.internal.LanguageIdentifierImpl;

public class LanguageIdentification {
    private LanguageIdentification() {
    }

    @NonNull
    public static LanguageIdentifier getClient() {
        return ((LanguageIdentifierImpl.Factory) MlKitContext.getInstance().get(LanguageIdentifierImpl.Factory.class)).create(LanguageIdentificationOptions.zza);
    }

    @NonNull
    public static LanguageIdentifier getClient(@NonNull LanguageIdentificationOptions languageIdentificationOptions) {
        Preconditions.checkNotNull(languageIdentificationOptions, "LanguageIdentificationOptions can not be null");
        return ((LanguageIdentifierImpl.Factory) MlKitContext.getInstance().get(LanguageIdentifierImpl.Factory.class)).create(languageIdentificationOptions);
    }
}
