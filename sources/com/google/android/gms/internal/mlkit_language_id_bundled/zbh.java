package com.google.android.gms.internal.mlkit_language_id_bundled;

import java.util.List;
import javax.annotation.CheckForNull;

final class zbh extends zbi {
    final transient int zba;
    final transient int zbb;
    final /* synthetic */ zbi zbc;

    public zbh(zbi zbi, int i, int i2) {
        this.zbc = zbi;
        this.zba = i;
        this.zbb = i2;
    }

    public final Object get(int i) {
        zbc.zba(i, this.zbb, "index");
        return this.zbc.get(i + this.zba);
    }

    public final int size() {
        return this.zbb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    public final int zbb() {
        return this.zbc.zbc() + this.zba + this.zbb;
    }

    public final int zbc() {
        return this.zbc.zbc() + this.zba;
    }

    @CheckForNull
    public final Object[] zbe() {
        return this.zbc.zbe();
    }

    public final zbi zbf(int i, int i2) {
        zbc.zbc(i, i2, this.zbb);
        int i3 = this.zba;
        return this.zbc.subList(i + i3, i2 + i3);
    }
}
