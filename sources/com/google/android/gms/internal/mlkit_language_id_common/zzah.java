package com.google.android.gms.internal.mlkit_language_id_common;

final class zzah implements zzam {
    private final int zza;
    private final zzal zzb;

    public zzah(int i, zzal zzal) {
        this.zza = i;
        this.zzb = zzal;
    }

    public final Class annotationType() {
        return zzam.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzam)) {
            return false;
        }
        zzam zzam = (zzam) obj;
        return this.zza == zzam.zza() && this.zzb.equals(zzam.zzb());
    }

    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf" + "(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    public final int zza() {
        return this.zza;
    }

    public final zzal zzb() {
        return this.zzb;
    }
}
