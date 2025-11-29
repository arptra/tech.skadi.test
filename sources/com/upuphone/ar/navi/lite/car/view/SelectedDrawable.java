package com.upuphone.ar.navi.lite.car.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class SelectedDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public float f5668a;
    public Rect b;
    public Position c;
    public final Paint d;
    public final Path e;
    public final RectF f;

    public enum Position {
        FIRST,
        MIDDLE,
        LAST
    }

    public void a(int i) {
        this.d.setColor(i);
    }

    public void draw(Canvas canvas) {
        float strokeWidth = this.d.getStrokeWidth() / 2.0f;
        Rect rect = this.b;
        int i = rect.left;
        int i2 = (int) strokeWidth;
        int i3 = rect.top + i2;
        int i4 = rect.right;
        int i5 = rect.bottom - i2;
        float[] fArr = new float[8];
        Position position = this.c;
        if (position == Position.FIRST) {
            i = (int) (((float) i) + strokeWidth);
            float f2 = this.f5668a;
            fArr[0] = f2;
            fArr[1] = f2;
            fArr[6] = f2;
            fArr[7] = f2;
        } else if (position == Position.LAST) {
            i4 = (int) (((float) i4) - strokeWidth);
            float f3 = this.f5668a;
            fArr[2] = f3;
            fArr[3] = f3;
            fArr[4] = f3;
            fArr[5] = f3;
        }
        this.e.reset();
        this.f.set((float) i, (float) i3, (float) i4, (float) i5);
        this.e.addRoundRect(this.f, fArr, Path.Direction.CW);
        canvas.drawPath(this.e, this.d);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
