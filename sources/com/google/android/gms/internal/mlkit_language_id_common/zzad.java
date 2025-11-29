package com.google.android.gms.internal.mlkit_language_id_common;

import javax.annotation.CheckForNull;

final class zzad extends zzw {
    static final zzw zza = new zzad((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzad(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public static zzad zzg(int i, Object[] objArr, zzv zzv) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzn.zza(obj, obj2);
        return new zzad((Object) null, objArr, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f A[RETURN] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object[] r0 = r3.zzb
            int r3 = r3.zzc
            r1 = 0
            if (r4 != 0) goto L_0x0009
        L_0x0007:
            r3 = r1
            goto L_0x001d
        L_0x0009:
            r2 = 1
            if (r3 != r2) goto L_0x0007
            r3 = 0
            r3 = r0[r3]
            r3.getClass()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0007
            r3 = r0[r2]
            r3.getClass()
        L_0x001d:
            if (r3 != 0) goto L_0x0020
            return r1
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_language_id_common.zzad.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzc;
    }

    public final zzq zza() {
        return new zzac(this.zzb, 1, this.zzc);
    }

    public final zzx zzd() {
        return new zzaa(this, this.zzb, 0, this.zzc);
    }

    public final zzx zze() {
        return new zzab(this, new zzac(this.zzb, 0, this.zzc));
    }
}
