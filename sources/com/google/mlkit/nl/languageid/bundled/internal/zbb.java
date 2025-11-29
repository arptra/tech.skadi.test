package com.google.mlkit.nl.languageid.bundled.internal;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.ClientPriority;
import com.google.mlkit.nl.languageid.LanguageIdentificationOptions;
import com.google.mlkit.nl.languageid.internal.LanguageIdentifierCreatorDelegate;
import com.google.mlkit.nl.languageid.internal.LanguageIdentifierDelegate;

public final class zbb implements LanguageIdentifierCreatorDelegate {
    public final LanguageIdentifierDelegate create(Context context, LanguageIdentificationOptions languageIdentificationOptions) {
        return new ThickLanguageIdentifier(context, languageIdentificationOptions);
    }

    @ClientPriority
    public final int getPriority() {
        return 100;
    }
}
