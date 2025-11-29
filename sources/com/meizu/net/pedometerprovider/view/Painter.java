package com.meizu.net.pedometerprovider.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public interface Painter {
    void draw(Canvas canvas);

    int getColor();

    void onSizeChanged(int i, int i2);

    void setCircleBitmap(Bitmap bitmap, Bitmap bitmap2);

    void setColor(int i);
}
