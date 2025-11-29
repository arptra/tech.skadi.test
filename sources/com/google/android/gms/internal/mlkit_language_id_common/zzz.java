package com.google.android.gms.internal.mlkit_language_id_common;

import java.util.AbstractMap;

final class zzz extends zzu {
    final /* synthetic */ zzaa zza;

    public zzz(zzaa zzaa) {
        this.zza = zzaa;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzk.zza(i, this.zza.zzc, "index");
        zzaa zzaa = this.zza;
        int i2 = i + i;
        Object obj = zzaa.zzb[i2];
        obj.getClass();
        Object obj2 = zzaa.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
