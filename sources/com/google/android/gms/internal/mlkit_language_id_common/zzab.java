package com.google.android.gms.internal.mlkit_language_id_common;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzab extends zzx {
    private final transient zzw zza;
    private final transient zzu zzb;

    public zzab(zzw zzw, zzu zzu) {
        this.zza = zzw;
        this.zzb = zzu;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzaf zzd() {
        return this.zzb.listIterator(0);
    }
}
