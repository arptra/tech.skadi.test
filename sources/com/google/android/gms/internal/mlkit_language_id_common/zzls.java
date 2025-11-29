package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

final class zzls extends LazyInstanceMap {
    private zzls() {
    }

    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzlc zzlc = (zzlc) obj;
        MlKitContext instance = MlKitContext.getInstance();
        return new zzli(instance.getApplicationContext(), (SharedPrefManager) instance.get(SharedPrefManager.class), new zzld(MlKitContext.getInstance().getApplicationContext(), zzlc), zzlc.zzb());
    }

    public /* synthetic */ zzls(zzlr zzlr) {
    }
}
