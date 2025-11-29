package com.google.android.gms.internal.mlkit_language_id_common;

public final /* synthetic */ class zzlg implements Runnable {
    public final /* synthetic */ zzli zza;
    public final /* synthetic */ zzla zzb;
    public final /* synthetic */ zzhy zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzlg(zzli zzli, zzla zzla, zzhy zzhy, String str) {
        this.zza = zzli;
        this.zzb = zzla;
        this.zzc = zzhy;
        this.zzd = str;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
