package com.google.android.gms.internal.mlkit_language_id_common;

import java.util.List;
import javax.annotation.CheckForNull;

final class zzt extends zzu {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzu zzc;

    public zzt(zzu zzu, int i, int i2) {
        this.zzc = zzu;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzk.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzu zzf(int i, int i2) {
        zzk.zzc(i, i2, this.zzb);
        zzu zzu = this.zzc;
        int i3 = this.zza;
        return zzu.subList(i + i3, i2 + i3);
    }
}
