package com.google.android.gms.internal.mlkit_language_id_common;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzaa extends zzx {
    private final transient zzw zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    public zzaa(zzw zzw, Object[] objArr, int i, int i2) {
        this.zza = zzw;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.zza.get(key));
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, 0);
    }

    public final zzaf zzd() {
        return zzf().listIterator(0);
    }

    public final zzu zzg() {
        return new zzz(this);
    }
}
