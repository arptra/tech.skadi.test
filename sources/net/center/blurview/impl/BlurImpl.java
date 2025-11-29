package net.center.blurview.impl;

import android.content.Context;
import android.graphics.Bitmap;

public interface BlurImpl {
    void a(Bitmap bitmap, Bitmap bitmap2);

    boolean b(Context context, Bitmap bitmap, float f);

    void release();
}
