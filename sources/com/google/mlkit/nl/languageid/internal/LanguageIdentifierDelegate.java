package com.google.mlkit.nl.languageid.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.nl.languageid.IdentifiedLanguage;
import java.util.List;

@KeepForSdk
public interface LanguageIdentifierDelegate {
    @NonNull
    @KeepForSdk
    List<IdentifiedLanguage> identifyPossibleLanguages(@NonNull String str, float f) throws MlKitException;

    @KeepForSdk
    void init() throws MlKitException;

    @KeepForSdk
    void release();
}
