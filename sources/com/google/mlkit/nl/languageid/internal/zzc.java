package com.google.mlkit.nl.languageid.internal;

import java.util.Comparator;

public final /* synthetic */ class zzc implements Comparator {
    public static final /* synthetic */ zzc zza = new zzc();

    private /* synthetic */ zzc() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((LanguageIdentifierCreatorDelegate) obj2).getPriority() - ((LanguageIdentifierCreatorDelegate) obj).getPriority();
    }
}
