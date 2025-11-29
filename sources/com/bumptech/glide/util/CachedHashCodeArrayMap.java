package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    public int i;

    public void clear() {
        this.i = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.i == 0) {
            this.i = super.hashCode();
        }
        return this.i;
    }

    public void k(SimpleArrayMap simpleArrayMap) {
        this.i = 0;
        super.k(simpleArrayMap);
    }

    public Object l(int i2) {
        this.i = 0;
        return super.l(i2);
    }

    public Object m(int i2, Object obj) {
        this.i = 0;
        return super.m(i2, obj);
    }

    public Object put(Object obj, Object obj2) {
        this.i = 0;
        return super.put(obj, obj2);
    }
}
