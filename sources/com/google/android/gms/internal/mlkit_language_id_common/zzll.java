package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

public final class zzll implements zzla {
    private final zzhz zza;
    private zzkc zzb = new zzkc();
    private final int zzc;

    private zzll(zzhz zzhz, int i) {
        this.zza = zzhz;
        zzlu.zza();
        this.zzc = i;
    }

    public static zzla zzf(zzhz zzhz) {
        return new zzll(zzhz, 0);
    }

    public static zzla zzg(zzhz zzhz, int i) {
        return new zzll(zzhz, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final zzla zzb(zzhy zzhy) {
        this.zza.zzd(zzhy);
        return this;
    }

    public final zzla zzc(zzkc zzkc) {
        this.zzb = zzkc;
        return this;
    }

    public final String zzd() {
        zzke zzd = this.zza.zzg().zzd();
        return (zzd == null || zzl.zzb(zzd.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzd.zzk());
    }

    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzf(this.zzb.zzm());
        try {
            zzlu.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzgl.zza).ignoreNullValues(true).build().encode(this.zza.zzg()).getBytes("utf-8");
            }
            zzib zzg = this.zza.zzg();
            zzaq zzaq = new zzaq();
            zzgl.zza.configure(zzaq);
            return zzaq.zza().zza(zzg);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
