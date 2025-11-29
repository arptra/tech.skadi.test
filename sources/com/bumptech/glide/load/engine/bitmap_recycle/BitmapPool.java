package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

public interface BitmapPool {
    void a(int i);

    void b();

    void c(Bitmap bitmap);

    Bitmap d(int i, int i2, Bitmap.Config config);

    Bitmap e(int i, int i2, Bitmap.Config config);
}
