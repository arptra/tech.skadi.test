package com.meizu.net.pedometerprovider.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.meizu.net.pedometerprovider.util.Logs;

public class ProgressPainterImp implements ProgressPainter {
    private static final int HEAD_ANGLE = 4;
    private static final int SEPARATE_LINE_ANGLE = 1;
    private Bitmap circleBitmap;
    private int color = -65536;
    private Bitmap compositeBitmap;
    private Canvas compositeCanvas;
    protected float endAngle = 360.0f;
    private Bitmap headBitmap;
    private int height;
    private int internalStrokeHeight = 48;
    private RectF mGraduationRect = new RectF();
    private Rect mSrcRect;
    protected float max;
    protected float min;
    protected float plusAngle = 0.0f;
    private RectF progressCircle;
    private Paint progressPaint;
    protected float startAngle = 270.0f;
    private int width;
    private PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    public ProgressPainterImp(int i, float f, float f2, int i2) {
        this.color = i;
        this.min = f;
        this.max = f2;
        this.internalStrokeHeight = i2;
        init();
    }

    private void init() {
        initInternalCirclePainter();
    }

    private void initInternalCircle() {
        float min2 = ((float) (Math.min(this.width, this.height) / 2)) - ((float) (this.internalStrokeHeight / 2));
        float f = (float) (this.width / 2);
        float f2 = (float) (this.height / 2);
        this.mGraduationRect.set(f - min2, f2 - min2, f + min2, f2 + min2);
        this.compositeBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        this.compositeCanvas = new Canvas(this.compositeBitmap);
    }

    private void initInternalCirclePainter() {
        Paint paint = new Paint();
        this.progressPaint = paint;
        paint.setAntiAlias(true);
        this.progressPaint.setFilterBitmap(true);
        this.progressPaint.setStrokeWidth((float) this.internalStrokeHeight);
        this.progressPaint.setColor(this.color);
        this.progressPaint.setStyle(Paint.Style.STROKE);
    }

    public void draw(Canvas canvas) {
        drawMask(canvas);
    }

    public void drawMask(Canvas canvas) {
        boolean z;
        if (this.plusAngle == 0.0f) {
            this.compositeCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } else if (this.circleBitmap != null) {
            Logs.d(" plusAngle = " + this.plusAngle);
            float f = this.plusAngle;
            float f2 = this.endAngle;
            if (f > f2) {
                this.plusAngle = f % f2;
                z = true;
            } else {
                z = false;
            }
            Logs.d(" plusAngle = " + this.plusAngle);
            PaintFlagsDrawFilter paintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
            canvas.setDrawFilter(paintFlagsDrawFilter);
            this.compositeCanvas.setDrawFilter(paintFlagsDrawFilter);
            float f3 = this.plusAngle - 4.0f;
            int i = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            if (i > 0) {
                this.compositeCanvas.save();
                if (!z) {
                    this.compositeCanvas.drawArc(this.mGraduationRect, this.startAngle, f3, false, this.progressPaint);
                    this.progressPaint.setXfermode(this.xfermode);
                }
                this.compositeCanvas.rotate(1.0f + f3, ((float) this.width) * 0.5f, ((float) this.height) * 0.5f);
                this.compositeCanvas.drawBitmap(this.circleBitmap, this.mSrcRect, new Rect(0, 0, this.width, this.height), this.progressPaint);
                this.progressPaint.setXfermode((Xfermode) null);
                this.compositeCanvas.restore();
                canvas.drawBitmap(this.compositeBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (z) {
                canvas.drawBitmap(this.circleBitmap, 0.0f, 0.0f, this.progressPaint);
            }
            if (this.headBitmap != null) {
                canvas.save();
                if (i > 0) {
                    canvas.rotate(f3, ((float) this.width) * 0.5f, ((float) this.height) * 0.5f);
                }
                canvas.drawBitmap(this.headBitmap, 0.0f, 0.0f, this.progressPaint);
                canvas.restore();
            }
        }
    }

    public int getColor() {
        return this.color;
    }

    public float getMax() {
        return this.max;
    }

    public float getMin() {
        return this.min;
    }

    public void onSizeChanged(int i, int i2) {
        this.width = i2;
        this.height = i;
        initInternalCircle();
    }

    public void setCircleBitmap(Bitmap bitmap, Bitmap bitmap2) {
        this.circleBitmap = bitmap;
        this.headBitmap = bitmap2;
        if (bitmap != null) {
            this.mSrcRect = new Rect(0, 0, this.circleBitmap.getWidth(), this.circleBitmap.getHeight());
        }
    }

    public void setColor(int i) {
        this.color = i;
        this.progressPaint.setColor(i);
    }

    public void setMax(float f) {
        this.max = f;
    }

    public void setMin(float f) {
        this.min = f;
    }

    public void setValue(float f) {
        this.plusAngle = (this.endAngle * f) / this.max;
    }
}
