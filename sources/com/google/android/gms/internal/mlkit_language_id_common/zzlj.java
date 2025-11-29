package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzlj implements OnFailureListener {
    public final /* synthetic */ zzlk zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzlj(zzlk zzlk, long j) {
        this.zza = zzlk;
        this.zzb = j;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzb(this.zzb, exc);
    }
}
