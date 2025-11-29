package com.google.mlkit.nl.languageid.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import java.util.ArrayList;
import java.util.Collections;

public final /* synthetic */ class zza implements ComponentFactory {
    public static final /* synthetic */ zza zza = new zza();

    private /* synthetic */ zza() {
    }

    public final Object create(ComponentContainer componentContainer) {
        ArrayList arrayList = new ArrayList(componentContainer.setOf(LanguageIdentifierCreatorDelegate.class));
        Preconditions.checkState(!arrayList.isEmpty(), "No delegate creator registered.");
        Collections.sort(arrayList, zzc.zza);
        return new zzg((Context) componentContainer.get(Context.class), (LanguageIdentifierCreatorDelegate) arrayList.get(0));
    }
}
