package com.scwang.smart.drawable;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;

public class ProgressDrawable extends PaintDrawable implements Animatable, ValueAnimator.AnimatorUpdateListener {
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public ValueAnimator e;
    public Path f = new Path();

    public ProgressDrawable() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{30, 3600});
        this.e = ofInt;
        ofInt.setDuration(10000);
        this.e.setInterpolator((TimeInterpolator) null);
        this.e.setRepeatCount(-1);
        this.e.setRepeatMode(1);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f2 = (float) width;
        float max = Math.max(1.0f, f2 / 22.0f);
        if (!(this.b == width && this.c == height)) {
            this.f.reset();
            Path path = this.f;
            float f3 = f2 - max;
            float f4 = ((float) height) / 2.0f;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(f3, f4, max, direction);
            float f5 = f2 - (5.0f * max);
            this.f.addRect(f5, f4 - max, f3, f4 + max, direction);
            this.f.addCircle(f5, f4, max, direction);
            this.b = width;
            this.c = height;
        }
        canvas.save();
        float f6 = f2 / 2.0f;
        float f7 = ((float) height) / 2.0f;
        canvas.rotate((float) this.d, f6, f7);
        for (int i = 0; i < 12; i++) {
            this.f9838a.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f, this.f9838a);
        }
        canvas.restore();
    }

    public boolean isRunning() {
        return this.e.isRunning();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    public void start() {
        if (!this.e.isRunning()) {
            this.e.addUpdateListener(this);
            this.e.start();
        }
    }

    public void stop() {
        if (this.e.isRunning()) {
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
            this.e.cancel();
        }
    }
}
