package com.google.android.gms.internal.mlkit_language_id_common;

final class zzkz extends zzlc {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    public /* synthetic */ zzkz(String str, boolean z, int i, zzky zzky) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzlc) {
            zzlc zzlc = (zzlc) obj;
            return this.zza.equals(zzlc.zzb()) && this.zzb == zzlc.zzc() && this.zzc == zzlc.zza();
        }
    }

    public final int hashCode() {
        return this.zzc ^ ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003);
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        int i = this.zzc;
        return "MLKitLoggingOptions{libraryName=" + str + ", enableFirelog=" + z + ", firelogEventType=" + i + "}";
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
