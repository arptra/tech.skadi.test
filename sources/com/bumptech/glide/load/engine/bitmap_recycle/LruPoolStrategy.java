package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

interface LruPoolStrategy {
    String a(int i, int i2, Bitmap.Config config);

    int b(Bitmap bitmap);

    void c(Bitmap bitmap);

    Bitmap d(int i, int i2, Bitmap.Config config);

    String e(Bitmap bitmap);

    Bitmap removeLast();
}
