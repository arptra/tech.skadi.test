package com.google.android.gms.internal.mlkit_language_id_common;

import kotlin.jvm.internal.LongCompanionObject;

public final class zzhm {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zzhx zzb;
    /* access modifiers changed from: private */
    public Boolean zzc;

    public final zzhm zza(Long l) {
        this.zza = Long.valueOf(l.longValue() & LongCompanionObject.MAX_VALUE);
        return this;
    }

    public final zzhm zzb(zzhx zzhx) {
        this.zzb = zzhx;
        return this;
    }

    public final zzhm zzc(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzho zzd() {
        return new zzho(this, (zzhn) null);
    }
}
