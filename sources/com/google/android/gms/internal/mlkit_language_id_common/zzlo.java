package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class zzlo implements Provider {
    public final /* synthetic */ TransportFactory zza;

    public /* synthetic */ zzlo(TransportFactory transportFactory) {
        this.zza = transportFactory;
    }

    public final Object get() {
        return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.of("proto"), zzlm.zza);
    }
}
