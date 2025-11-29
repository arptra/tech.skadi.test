package com.google.android.gms.internal.mlkit_language_id_common;

import java.util.Arrays;
import javax.annotation.CheckForNull;

public final class zze {
    private final String zza;
    private final zzd zzb;
    private zzd zzc;

    public /* synthetic */ zze(String str, zzb zzb2) {
        zzd zzd = new zzd((zzb) null);
        this.zzb = zzd;
        this.zzc = zzd;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzd zzd = this.zzb.zzc;
        String str = "";
        while (zzd != null) {
            Object obj = zzd.zzb;
            sb.append(str);
            String str2 = zzd.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzd = zzd.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zze zza(String str, float f) {
        String valueOf = String.valueOf(f);
        zzc zzc2 = new zzc((zzb) null);
        this.zzc.zzc = zzc2;
        this.zzc = zzc2;
        zzc2.zzb = valueOf;
        zzc2.zza = "confidence";
        return this;
    }

    public final zze zzb(String str, @CheckForNull Object obj) {
        zzd zzd = new zzd((zzb) null);
        this.zzc.zzc = zzd;
        this.zzc = zzd;
        zzd.zzb = obj;
        zzd.zza = "languageTag";
        return this;
    }
}
