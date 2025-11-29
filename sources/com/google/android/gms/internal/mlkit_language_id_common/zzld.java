package com.google.android.gms.internal.mlkit_language_id_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

public final class zzld implements zzlh {
    @VisibleForTesting
    final List zza;

    public zzld(Context context, zzlc zzlc) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzlc.zzc()) {
            arrayList.add(new zzlq(context, zzlc));
        }
    }

    public final void zza(zzla zzla) {
        for (zzlh zza2 : this.zza) {
            zza2.zza(zzla);
        }
    }
}
