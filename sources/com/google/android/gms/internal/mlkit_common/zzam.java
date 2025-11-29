package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractMap;
import java.util.Objects;

final class zzam extends zzaf {
    final /* synthetic */ zzan zza;

    public zzam(zzan zzan) {
        this.zza = zzan;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzt.zza(i, this.zza.zzc, "index");
        int i2 = i + i;
        Object obj = this.zza.zzb[i2];
        Objects.requireNonNull(obj);
        Object obj2 = this.zza.zzb[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
