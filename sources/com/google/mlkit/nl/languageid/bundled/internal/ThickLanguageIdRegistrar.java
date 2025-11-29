package com.google.mlkit.nl.languageid.bundled.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_language_id_bundled.zbi;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.mlkit.nl.languageid.internal.LanguageIdentifierCreatorDelegate;
import java.util.List;

@KeepForSdk
public class ThickLanguageIdRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zba = 0;

    @NonNull
    public final List getComponents() {
        return zbi.zbg(Component.intoSetBuilder(LanguageIdentifierCreatorDelegate.class).factory(new zba()).build());
    }
}
