package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

public class HorizontalProgressWheelView extends View {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f8773a;
    public ScrollingListener b;
    public float c;
    public Paint d;
    public Paint e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public float j;
    public int k;

    public interface ScrollingListener {
        void a();

        void b();

        void c(float f, float f2);
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a() {
        this.k = ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.f = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.g = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.h = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth((float) this.f);
        this.d.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.d);
        this.e = paint2;
        paint2.setColor(this.k);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        this.e.setStrokeWidth((float) getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    public final void b(MotionEvent motionEvent, float f2) {
        this.j -= f2;
        postInvalidate();
        this.c = motionEvent.getX();
        ScrollingListener scrollingListener = this.b;
        if (scrollingListener != null) {
            scrollingListener.c(-f2, this.j);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f8773a);
        int width = this.f8773a.width();
        int i2 = this.f;
        int i3 = this.h;
        int i4 = width / (i2 + i3);
        float f2 = this.j % ((float) (i3 + i2));
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i4 / 4;
            if (i5 < i6) {
                this.d.setAlpha((int) ((((float) i5) / ((float) i6)) * 255.0f));
            } else if (i5 > (i4 * 3) / 4) {
                this.d.setAlpha((int) ((((float) (i4 - i5)) / ((float) i6)) * 255.0f));
            } else {
                this.d.setAlpha(255);
            }
            float f3 = -f2;
            Rect rect = this.f8773a;
            float f4 = ((float) rect.left) + f3 + ((float) ((this.f + this.h) * i5));
            float centerY = ((float) rect.centerY()) - (((float) this.g) / 4.0f);
            Rect rect2 = this.f8773a;
            canvas.drawLine(f4, centerY, f3 + ((float) rect2.left) + ((float) ((this.f + this.h) * i5)), ((float) rect2.centerY()) + (((float) this.g) / 4.0f), this.d);
        }
        float centerX = (float) this.f8773a.centerX();
        float centerY2 = ((float) this.f8773a.centerY()) - (((float) this.g) / 2.0f);
        Canvas canvas2 = canvas;
        float f5 = centerY2;
        canvas2.drawLine(centerX, f5, (float) this.f8773a.centerX(), (((float) this.g) / 2.0f) + ((float) this.f8773a.centerY()), this.e);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
        } else if (action == 1) {
            ScrollingListener scrollingListener = this.b;
            if (scrollingListener != null) {
                this.i = false;
                scrollingListener.a();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.c;
            if (x != 0.0f) {
                if (!this.i) {
                    this.i = true;
                    ScrollingListener scrollingListener2 = this.b;
                    if (scrollingListener2 != null) {
                        scrollingListener2.b();
                    }
                }
                b(motionEvent, x);
            }
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i2) {
        this.k = i2;
        this.e.setColor(i2);
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.b = scrollingListener;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8773a = new Rect();
        a();
    }
}
