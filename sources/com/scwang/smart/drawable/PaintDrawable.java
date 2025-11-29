package com.scwang.smart.drawable;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public abstract class PaintDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Paint f9838a;

    public PaintDrawable() {
        Paint paint = new Paint();
        this.f9838a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f9838a.setAntiAlias(true);
        this.f9838a.setColor(-5592406);
    }

    public void a(int i) {
        this.f9838a.setColor(i);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f9838a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f9838a.setColorFilter(colorFilter);
    }
}
