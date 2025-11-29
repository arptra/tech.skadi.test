package com.bumptech.glide.load.engine.bitmap_recycle;

public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {
    public int b() {
        return 4;
    }

    /* renamed from: c */
    public int a(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: d */
    public int[] newArray(int i) {
        return new int[i];
    }

    public String getTag() {
        return "IntegerArrayPool";
    }
}
