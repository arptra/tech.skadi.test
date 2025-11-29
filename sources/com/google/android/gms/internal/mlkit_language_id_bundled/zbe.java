package com.google.android.gms.internal.mlkit_language_id_bundled;

import java.util.NoSuchElementException;

abstract class zbe extends zbl {
    private final int zba;
    private int zbb;

    public zbe(int i, int i2) {
        zbc.zbb(i2, i, "index");
        this.zba = i;
        this.zbb = i2;
    }

    public final boolean hasNext() {
        return this.zbb < this.zba;
    }

    public final boolean hasPrevious() {
        return this.zbb > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i = this.zbb;
            this.zbb = i + 1;
            return zba(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zbb;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i = this.zbb - 1;
            this.zbb = i;
            return zba(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zbb - 1;
    }

    public abstract Object zba(int i);
}
