package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
public abstract class LazyInstanceMap<K, V> {
    @GuardedBy
    private final Map zza = new HashMap();

    @NonNull
    @KeepForSdk
    public abstract V create(@NonNull K k);

    @NonNull
    @KeepForSdk
    public V get(@NonNull K k) {
        synchronized (this.zza) {
            try {
                if (this.zza.containsKey(k)) {
                    V v = this.zza.get(k);
                    return v;
                }
                V create = create(k);
                this.zza.put(k, create);
                return create;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
