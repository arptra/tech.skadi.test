package com.google.mlkit.nl.languageid.internal;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzd implements Callable {
    public final /* synthetic */ LanguageIdentifierImpl zza;
    public final /* synthetic */ zzg zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;

    public /* synthetic */ zzd(LanguageIdentifierImpl languageIdentifierImpl, zzg zzg, String str, boolean z) {
        this.zza = languageIdentifierImpl;
        this.zzb = zzg;
        this.zzc = str;
        this.zzd = z;
    }

    public final Object call() {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd);
    }
}
