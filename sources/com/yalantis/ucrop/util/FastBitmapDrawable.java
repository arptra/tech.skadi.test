package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class FastBitmapDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f8751a = new Paint(2);
    public Bitmap b;
    public int c = 255;
    public int d;
    public int e;

    public FastBitmapDrawable(Bitmap bitmap) {
        b(bitmap);
    }

    public Bitmap a() {
        return this.b;
    }

    public void b(Bitmap bitmap) {
        this.b = bitmap;
        if (bitmap != null) {
            this.d = bitmap.getWidth();
            this.e = this.b.getHeight();
            return;
        }
        this.e = 0;
        this.d = 0;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.b;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.b, (Rect) null, getBounds(), this.f8751a);
        }
    }

    public int getAlpha() {
        return this.c;
    }

    public int getIntrinsicHeight() {
        return this.e;
    }

    public int getIntrinsicWidth() {
        return this.d;
    }

    public int getMinimumHeight() {
        return this.e;
    }

    public int getMinimumWidth() {
        return this.d;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.c = i;
        this.f8751a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f8751a.setColorFilter(colorFilter);
    }

    public void setFilterBitmap(boolean z) {
        this.f8751a.setFilterBitmap(z);
    }
}
