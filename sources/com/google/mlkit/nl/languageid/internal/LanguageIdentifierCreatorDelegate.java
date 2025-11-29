package com.google.mlkit.nl.languageid.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.ClientPriority;
import com.google.mlkit.nl.languageid.LanguageIdentificationOptions;

@KeepForSdk
public interface LanguageIdentifierCreatorDelegate {
    @NonNull
    @KeepForSdk
    LanguageIdentifierDelegate create(@NonNull Context context, @NonNull LanguageIdentificationOptions languageIdentificationOptions);

    @KeepForSdk
    @ClientPriority
    int getPriority();
}
