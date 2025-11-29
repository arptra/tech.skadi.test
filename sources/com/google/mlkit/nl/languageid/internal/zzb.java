package com.google.mlkit.nl.languageid.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.nl.languageid.internal.LanguageIdentifierImpl;

public final /* synthetic */ class zzb implements ComponentFactory {
    public static final /* synthetic */ zzb zza = new zzb();

    private /* synthetic */ zzb() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new LanguageIdentifierImpl.Factory((zzg) componentContainer.get(zzg.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class));
    }
}
