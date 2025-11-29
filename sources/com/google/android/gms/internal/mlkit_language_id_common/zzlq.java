package com.google.android.gms.internal.mlkit_language_id_common;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

public final class zzlq implements zzlh {
    @Nullable
    private Provider zza;
    private final Provider zzb;
    private final zzlc zzc;

    public zzlq(Context context, zzlc zzlc) {
        this.zzc = zzlc;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory((Destination) cCTDestination);
        if (cCTDestination.getSupportedEncodings().contains(Encoding.of("json"))) {
            this.zza = new Lazy(new zzln(newFactory));
        }
        this.zzb = new Lazy(new zzlo(newFactory));
    }

    @VisibleForTesting
    public static Event zzb(zzlc zzlc, zzla zzla) {
        int zza2 = zzlc.zza();
        return zzla.zza() != 0 ? Event.ofData(zzla.zze(zza2, false)) : Event.ofTelemetry(zzla.zze(zza2, false));
    }

    public final void zza(zzla zzla) {
        if (this.zzc.zza() == 0) {
            Provider provider = this.zza;
            if (provider != null) {
                ((Transport) provider.get()).send(zzb(this.zzc, zzla));
                return;
            }
            return;
        }
        ((Transport) this.zzb.get()).send(zzb(this.zzc, zzla));
    }
}
