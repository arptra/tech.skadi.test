package com.meizu.net.pedometerprovider.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class InternalCirclePainterImp implements InternalCirclePainter {
    private Bitmap circleBitmap;
    private int color;
    private int dashSpace = 8;
    private int dashWith = 5;
    private float finishAngle = 359.5f;
    private int height;
    private RectF internalCircle;
    private Paint internalCirclePaint;
    private float internalStrokeHeight = 48.0f;
    protected float mCenterX;
    protected float mCenterY;
    private RectF mGraduationRect = new RectF();
    private Paint mPaint = new Paint();
    protected float mRadius;
    private Rect mSrcRect;
    private float marginTop = 0.0f;
    private float progressGradurationDistance = 8.0f;
    private float startAngle = 270.0f;
    private int width;

    public InternalCirclePainterImp(int i, float f, float f2) {
        this.color = i;
        this.internalStrokeHeight = f;
        this.progressGradurationDistance = f2;
        init();
    }

    private void drawAngle(Canvas canvas) {
        canvas.translate(this.mCenterX, this.mCenterY);
        for (int i = 0; i < 360; i += 3) {
            canvas.rotate(3.0f);
            canvas.drawRoundRect(this.mGraduationRect, 10.0f, 10.0f, this.mPaint);
        }
    }

    private void drawPath(Canvas canvas) {
        canvas.drawArc(this.internalCircle, this.startAngle, this.finishAngle, false, this.internalCirclePaint);
    }

    private void init() {
        initExternalCirclePainter();
    }

    private void initExternalCircle() {
        RectF rectF = new RectF();
        this.internalCircle = rectF;
        float f = this.internalStrokeHeight / 2.0f;
        rectF.set(f, this.marginTop + f, ((float) this.width) - f, ((float) this.height) - f);
    }

    private void initExternalCirclePainter() {
        Paint paint = new Paint();
        this.internalCirclePaint = paint;
        paint.setAntiAlias(true);
        this.internalCirclePaint.setStrokeWidth(this.internalStrokeHeight);
        this.internalCirclePaint.setColor(this.color);
        this.internalCirclePaint.setStyle(Paint.Style.STROKE);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        Bitmap bitmap = this.circleBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.mSrcRect, new Rect(0, 0, this.width, this.height), (Paint) null);
        }
        canvas.restore();
    }

    public int getColor() {
        return this.color;
    }

    public void onSizeChanged(int i, int i2) {
        this.width = i2;
        this.height = i;
        initExternalCircle();
    }

    public void setCircleBitmap(Bitmap bitmap, Bitmap bitmap2) {
        this.circleBitmap = bitmap;
        if (bitmap != null) {
            this.mSrcRect = new Rect(0, 0, this.circleBitmap.getWidth(), this.circleBitmap.getHeight());
        }
    }

    public void setColor(int i) {
        this.color = i;
        this.internalCirclePaint.setColor(i);
    }
}
