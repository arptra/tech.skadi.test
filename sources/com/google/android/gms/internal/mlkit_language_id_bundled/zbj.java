package com.google.android.gms.internal.mlkit_language_id_bundled;

import java.util.Objects;

final class zbj extends zbi {
    static final zbi zba = new zbj(new Object[0], 0);
    final transient Object[] zbb;
    private final transient int zbc;

    public zbj(Object[] objArr, int i) {
        this.zbb = objArr;
        this.zbc = i;
    }

    public final Object get(int i) {
        zbc.zba(i, this.zbc, "index");
        Object obj = this.zbb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    public final int size() {
        return this.zbc;
    }

    public final int zba(Object[] objArr, int i) {
        System.arraycopy(this.zbb, 0, objArr, 0, this.zbc);
        return this.zbc;
    }

    public final int zbb() {
        return this.zbc;
    }

    public final int zbc() {
        return 0;
    }

    public final Object[] zbe() {
        return this.zbb;
    }
}
