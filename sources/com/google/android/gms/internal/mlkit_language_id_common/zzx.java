package com.google.android.gms.internal.mlkit_language_id_common;

import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzx extends zzq implements Set {
    @CheckForNull
    private transient zzu zza;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzae.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzaf iterator();

    public final zzu zzf() {
        zzu zzu = this.zza;
        if (zzu != null) {
            return zzu;
        }
        zzu zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    public zzu zzg() {
        return zzu.zzg(toArray());
    }
}
