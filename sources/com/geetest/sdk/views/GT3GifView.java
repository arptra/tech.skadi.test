package com.geetest.sdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

public class GT3GifView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f2990a;
    public Movie b;
    public long c;
    public int d;
    public float e;
    public float f;
    public float g;
    public int h;
    public int i;
    public volatile boolean j;
    public boolean k;

    public GT3GifView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        try {
            if (this.j) {
                this.j = false;
                this.c = SystemClock.uptimeMillis() - ((long) this.d);
                invalidate();
            }
        } catch (Exception unused) {
        }
    }

    public final void b(Context context, AttributeSet attributeSet, int i2) {
        try {
            setLayerType(1, (Paint) null);
            this.f2990a = -1;
            this.j = false;
            if (this.f2990a != -1) {
                this.b = Movie.decodeStream(getResources().openRawResource(this.f2990a));
            }
        } catch (Exception unused) {
        }
    }

    public final void c(Canvas canvas) {
        try {
            Movie movie = this.b;
            if (movie != null) {
                movie.setTime(this.d);
                canvas.save();
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                float f2 = this.g;
                canvas.scale(f2, f2);
                Movie movie2 = this.b;
                float f3 = this.e;
                float f4 = this.g;
                movie2.draw(canvas, f3 / f4, this.f / f4);
                canvas.restore();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        if (this.k) {
            postInvalidateOnAnimation();
        }
    }

    public final void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.c == 0) {
            this.c = uptimeMillis;
        }
        int duration = this.b.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.d = (int) ((uptimeMillis - this.c) % ((long) duration));
    }

    public int getGifResource() {
        return this.f2990a;
    }

    public void onDraw(Canvas canvas) {
        if (this.b == null) {
            return;
        }
        if (!this.j) {
            e();
            c(canvas);
            d();
            return;
        }
        c(canvas);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.e = ((float) (getWidth() - this.h)) / 2.0f;
        this.f = ((float) (getHeight() - this.i)) / 2.0f;
        this.k = getVisibility() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r5 = android.view.View.MeasureSpec.getSize(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            android.graphics.Movie r0 = r4.b
            if (r0 == 0) goto L_0x0047
            int r0 = r0.width()
            android.graphics.Movie r1 = r4.b
            int r1 = r1.height()
            int r2 = android.view.View.MeasureSpec.getMode(r5)
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0020
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 <= r5) goto L_0x0020
            float r2 = (float) r0
            float r5 = (float) r5
            float r2 = r2 / r5
            goto L_0x0021
        L_0x0020:
            r2 = r3
        L_0x0021:
            int r5 = android.view.View.MeasureSpec.getMode(r6)
            if (r5 == 0) goto L_0x0031
            int r5 = android.view.View.MeasureSpec.getSize(r6)
            if (r1 <= r5) goto L_0x0031
            float r6 = (float) r1
            float r5 = (float) r5
            float r6 = r6 / r5
            goto L_0x0032
        L_0x0031:
            r6 = r3
        L_0x0032:
            float r5 = java.lang.Math.max(r2, r6)
            float r3 = r3 / r5
            r4.g = r3
            float r5 = (float) r0
            float r5 = r5 * r3
            int r5 = (int) r5
            r4.h = r5
            float r6 = (float) r1
            float r6 = r6 * r3
            int r6 = (int) r6
            r4.i = r6
            r4.setMeasuredDimension(r5, r6)
            goto L_0x0052
        L_0x0047:
            int r5 = r4.getSuggestedMinimumWidth()
            int r6 = r4.getSuggestedMinimumHeight()
            r4.setMeasuredDimension(r5, r6)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.views.GT3GifView.onMeasure(int, int):void");
    }

    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        this.k = z;
        d();
    }

    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        this.k = i2 == 0;
        d();
    }

    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.k = i2 == 0;
        d();
    }

    public void setGifResource(int i2) {
        this.f2990a = i2;
        this.b = Movie.decodeStream(getResources().openRawResource(this.f2990a));
        requestLayout();
    }

    public GT3GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GT3GifView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = true;
        b(context, attributeSet, i2);
    }
}
