package com.google.android.gms.internal.mlkit_language_id_common;

import androidx.annotation.Nullable;

public final class zzlu {
    @Nullable
    private static zzlu zza;

    private zzlu() {
    }

    public static synchronized zzlu zza() {
        zzlu zzlu;
        synchronized (zzlu.class) {
            try {
                if (zza == null) {
                    zza = new zzlu();
                }
                zzlu = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzlu;
    }
}
