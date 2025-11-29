package com.google.android.gms.internal.mlkit_language_id_common;

import androidx.annotation.Nullable;

public final class zzlt {
    @Nullable
    private static zzls zza;

    public static synchronized zzli zza(zzlc zzlc) {
        zzli zzli;
        synchronized (zzlt.class) {
            try {
                if (zza == null) {
                    zza = new zzls((zzlr) null);
                }
                zzli = (zzli) zza.get(zzlc);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzli;
    }

    public static synchronized zzli zzb(String str) {
        zzli zza2;
        synchronized (zzlt.class) {
            zza2 = zza(zzlc.zzd(str).zzd());
        }
        return zza2;
    }
}
