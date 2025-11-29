package com.google.mlkit.nl.languageid.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_language_id_common.zzu;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.nl.languageid.internal.LanguageIdentifierImpl;
import java.util.List;

@KeepForSdk
public class LanguageIdRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @NonNull
    public final List getComponents() {
        Class<zzg> cls = zzg.class;
        return zzu.zzi(Component.builder(cls).add(Dependency.required(Context.class)).add(Dependency.setOf(LanguageIdentifierCreatorDelegate.class)).factory(zza.zza).build(), Component.builder(LanguageIdentifierImpl.Factory.class).add(Dependency.required(cls)).add(Dependency.required(ExecutorSelector.class)).factory(zzb.zza).build());
    }
}
