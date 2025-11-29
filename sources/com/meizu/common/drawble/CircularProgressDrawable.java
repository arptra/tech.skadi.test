package com.meizu.common.drawble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class CircularProgressDrawable extends Drawable {
    private Drawable mCenterIcon;
    private RectF mDrawRectF;
    private Paint mIconPaint;
    private Paint mPaint;
    private RectF mRectF;
    private boolean mShouldIcon = false;
    private int mSize;
    private float mStartAngle;
    private int mStrokeColor;
    private int mStrokeWidth;
    private float mSweepAngle;
    private final PointF offset = new PointF(0.0f, 0.0f);

    public CircularProgressDrawable(int i, int i2, int i3) {
        this.mSize = i;
        this.mStrokeWidth = i2;
        this.mStrokeColor = i3;
        this.mStartAngle = 90.0f;
        this.mSweepAngle = 0.0f;
    }

    private Paint createPaint() {
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth((float) (this.mStrokeWidth + 1));
            this.mPaint.setColor(this.mStrokeColor);
            this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        }
        return this.mPaint;
    }

    private RectF getRect() {
        if (this.mRectF == null) {
            float f = ((float) this.mStrokeWidth) / 2.0f;
            this.mRectF = new RectF(f, f, ((float) getSize()) - f, ((float) getSize()) - f);
        }
        return this.mRectF;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.mDrawRectF == null) {
            this.mDrawRectF = new RectF();
        }
        this.mDrawRectF.set(getRect());
        RectF rectF = this.mDrawRectF;
        PointF pointF = this.offset;
        rectF.offset(pointF.x, pointF.y);
        canvas.drawArc(this.mDrawRectF, this.mStartAngle, this.mSweepAngle, false, createPaint());
        if (this.mCenterIcon != null) {
            canvas.save();
            Drawable drawable = this.mCenterIcon;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mCenterIcon.getIntrinsicHeight());
            canvas.translate((float) ((bounds.left + (getSize() / 2)) - (this.mCenterIcon.getIntrinsicWidth() / 2)), (float) ((bounds.top + (getSize() / 2)) - (this.mCenterIcon.getIntrinsicHeight() / 2)));
            this.mCenterIcon.draw(canvas);
            canvas.restore();
        } else if (this.mShouldIcon) {
            if (this.mIconPaint == null) {
                Paint paint = new Paint();
                this.mIconPaint = paint;
                paint.setStrokeCap(Paint.Cap.ROUND);
                this.mIconPaint.setColor(this.mStrokeColor);
                this.mIconPaint.setAntiAlias(true);
            }
            int size = getSize();
            int size2 = getSize();
            int i = this.mStrokeWidth;
            int i2 = (int) (((double) size2) * 0.12d);
            this.mIconPaint.setStrokeWidth((float) i);
            int i3 = bounds.left;
            int i4 = size2 / 2;
            int i5 = i2 / 2;
            int i6 = i / 2;
            int i7 = bounds.top;
            int i8 = size / 2;
            int i9 = ((int) (((float) size) / 3.1f)) / 2;
            Canvas canvas2 = canvas;
            canvas2.drawLine((float) (((i3 + i4) - i5) - i6), (float) (((i7 + i8) - i9) + i6), (float) (((i3 + i4) - i5) - i6), (float) (((i7 + i8) + i9) - i6), this.mIconPaint);
            int i10 = bounds.left;
            int i11 = bounds.top;
            canvas2.drawLine((float) (i10 + i4 + i5 + i6), (float) (((i11 + i8) - i9) + i6), (float) (i10 + i4 + i5 + i6), (float) (((i11 + i8) + i9) - i6), this.mIconPaint);
        }
    }

    public int getOpacity() {
        return 1;
    }

    public int getSize() {
        return this.mSize;
    }

    public void setAlpha(int i) {
    }

    public void setCenterIcon(Drawable drawable) {
        this.mCenterIcon = drawable;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setIndicatorColor(int i) {
        createPaint();
        this.mStrokeColor = i;
        this.mPaint.setColor(i);
    }

    public void setOffset(float f, float f2) {
        this.offset.set(f, f2);
    }

    public void setShowCenterIcon(boolean z) {
        this.mShouldIcon = z;
    }

    public void setStartAngle(float f) {
        this.mStartAngle = f;
    }

    public void setStrokeWidth(int i) {
        if (i > 0 && this.mStrokeWidth != i) {
            this.mStrokeWidth = i;
            RectF rectF = this.mRectF;
            if (rectF != null) {
                int i2 = i / 2;
                float f = (float) i2;
                rectF.set(f, f, (float) (getSize() - i2), (float) (getSize() - i2));
            }
            Paint paint = this.mPaint;
            if (paint != null) {
                paint.setStrokeWidth((float) this.mStrokeWidth);
            }
        }
    }

    public void setSweepAngle(float f) {
        this.mSweepAngle = f;
    }
}
