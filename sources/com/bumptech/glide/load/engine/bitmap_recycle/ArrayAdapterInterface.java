package com.bumptech.glide.load.engine.bitmap_recycle;

interface ArrayAdapterInterface<T> {
    int a(Object obj);

    int b();

    String getTag();

    Object newArray(int i);
}
