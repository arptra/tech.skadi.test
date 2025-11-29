package com.google.android.gms.internal.mlkit_language_id_common;

import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import org.apache.commons.io.FileUtils;

public abstract class zzw implements Map, Serializable {
    @CheckForNull
    private transient zzx zza;
    @CheckForNull
    private transient zzx zzb;
    @CheckForNull
    private transient zzq zzc;

    public static zzw zzc(Object obj, Object obj2) {
        zzn.zza("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
        return zzad.zzg(1, new Object[]{"optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID}, (zzv) null);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzae.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzx zzx = this.zzb;
        if (zzx != null) {
            return zzx;
        }
        zzx zze = zze();
        this.zzb = zze;
        return zze;
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, FileUtils.ONE_GB));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                z = false;
            }
            sb.append('}');
            return sb.toString();
        }
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    public abstract zzq zza();

    /* renamed from: zzb */
    public final zzq values() {
        zzq zzq = this.zzc;
        if (zzq != null) {
            return zzq;
        }
        zzq zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzx zzd();

    public abstract zzx zze();

    /* renamed from: zzf */
    public final zzx entrySet() {
        zzx zzx = this.zza;
        if (zzx != null) {
            return zzx;
        }
        zzx zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
