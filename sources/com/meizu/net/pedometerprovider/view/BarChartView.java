package com.meizu.net.pedometerprovider.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.net.pedometerprovider.R;
import com.meizu.net.pedometerprovider.util.Logs;

public class BarChartView extends View {
    public static final int BAR_LEFT_RIGHT_MARGIN = 12;
    public static final int BAR_MARGIN_bottom = 4;
    public static final int BAR_SUM = 25;
    public static final int BAR_WIDTH = 6;
    public static final int FONT_SIZE = 11;
    public static final int MIDDLE_TEXT_MARGIN_TOP = 8;
    public static final int XTEXT_MARGIN_TOP = 8;
    public static final float X_AXIS_HEIGHT = 0.6f;
    private static int mBarAreaHeight;
    private final int TRUE = 1;
    /* access modifiers changed from: private */
    public int[] aniProgress;
    private HistogramAnimation animation;
    int barBottom = 0;
    private int barBottomColor;
    int barLeftRightMargin = 0;
    int barMarginBottom = 0;
    private Paint barPaint;
    int barStep = 0;
    private int barTopColor;
    int barWidth = 0;
    private Paint.FontMetrics fm;
    int fontBaseLine = 0;
    int fontHeight = 0;
    int fontSize = 0;
    private int getMiddleTextMarginTop = 8;
    private Interpolator interpolator = PathInterpolatorCompat.a(0.3f, 0.0f, 0.2f, 1.0f);
    int leastHeight = dp2px(6.0f);
    private int maxValue = 10000;
    /* access modifiers changed from: private */
    public int[] progress = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    /* access modifiers changed from: private */
    public boolean runningAnimation = false;
    private int[] text;
    private Paint titlePaint;
    int xAxisHeight = 0;
    int xAxislineHeight = 0;
    private Paint xLinePaint;
    int xTextMarginTop;
    private String[] xTexts;
    private String[] ySteps;

    public class HistogramAnimation extends Animation {
        private HistogramAnimation() {
        }

        public void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            int i = 0;
            if (!BarChartView.this.runningAnimation || f >= 1.0f) {
                while (i < BarChartView.this.aniProgress.length) {
                    BarChartView.this.aniProgress[i] = BarChartView.this.progress[i];
                    i++;
                }
            } else {
                while (i < BarChartView.this.aniProgress.length) {
                    BarChartView.this.aniProgress[i] = (int) (((float) BarChartView.this.progress[i]) * f);
                    i++;
                }
            }
            BarChartView.this.invalidate();
        }
    }

    public BarChartView(Context context) {
        super(context);
        init(context);
    }

    private void clearAniData() {
        int i = 0;
        while (true) {
            int[] iArr = this.aniProgress;
            if (i < iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                invalidate();
                return;
            }
        }
    }

    private int dp2px(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private void init(Context context) {
        this.xTexts = new String[]{"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00"};
        this.text = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.aniProgress = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        HistogramAnimation histogramAnimation = new HistogramAnimation();
        this.animation = histogramAnimation;
        histogramAnimation.setDuration(800);
        this.animation.setInterpolator(this.interpolator);
        this.xLinePaint = new Paint();
        int dp2px = dp2px(0.6f);
        this.xAxislineHeight = dp2px;
        this.xLinePaint.setStrokeWidth((float) dp2px);
        Paint paint = this.xLinePaint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.titlePaint = new Paint();
        Paint paint2 = new Paint();
        this.barPaint = paint2;
        paint2.setAntiAlias(true);
        this.barPaint.setStyle(style);
        int color = getResources().getColor(R.color.fourty_black);
        int color2 = getResources().getColor(R.color.separate_line_color);
        this.fontSize = dp2px(11.0f);
        this.xLinePaint.setColor(color2);
        this.titlePaint.setColor(color);
        this.titlePaint.setTextSize((float) this.fontSize);
        this.titlePaint.setTextAlign(Paint.Align.CENTER);
        this.titlePaint.setAntiAlias(true);
        this.titlePaint.setStyle(style);
        this.titlePaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.fm = this.titlePaint.getFontMetrics();
        this.getMiddleTextMarginTop = dp2px(8.0f);
        this.barTopColor = getResources().getColor(R.color.bar_top_color);
        this.barBottomColor = getResources().getColor(R.color.bar_bottom_color);
    }

    private int sp2px(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    public void clearData() {
        clearAnimation();
        this.animation.cancel();
        clearAniData();
    }

    public int getFontHeight(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent));
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.drawLine((float) dp2px(30.0f), (float) (dp2px(3.0f) + height), (float) (width - dp2px(30.0f)), (float) (height + dp2px(3.0f)), this.xLinePaint);
        int i = this.xAxisHeight;
        float f = (float) width;
        canvas.drawLine(0.0f, (float) i, f, (float) i, this.xLinePaint);
        int i2 = this.barBottom;
        canvas.drawLine(0.0f, (float) (i2 / 2), f, (float) (i2 / 2), this.xLinePaint);
        int i3 = this.barStep;
        if (this.progress[1] <= this.maxValue / 3) {
            this.titlePaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(String.valueOf(this.maxValue / 2), 0.0f, (float) ((this.barBottom / 2) + this.getMiddleTextMarginTop + (this.fontHeight / 2)), this.titlePaint);
            this.titlePaint.setTextAlign(Paint.Align.CENTER);
        }
        int[] iArr = this.progress;
        int i4 = iArr[1];
        int i5 = this.maxValue;
        if (i4 <= (i5 * 4) / 5 && iArr[2] <= (i5 * 4) / 5) {
            this.titlePaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(String.valueOf(this.maxValue), 0.0f, 0.0f - this.fm.ascent, this.titlePaint);
            this.titlePaint.setTextAlign(Paint.Align.CENTER);
        }
        int[] iArr2 = this.aniProgress;
        if (iArr2 != null && iArr2.length > 0) {
            int i6 = 0;
            while (true) {
                int[] iArr3 = this.aniProgress;
                if (i6 < iArr3.length) {
                    int i7 = iArr3[i6];
                    RectF rectF = new RectF();
                    int i8 = this.barLeftRightMargin;
                    int i9 = i3 * i6;
                    float f2 = (float) (i8 + i9);
                    rectF.left = f2;
                    rectF.right = (float) (i8 + this.barWidth + i9);
                    if (i6 % 6 == 0) {
                        canvas.drawText(this.xTexts[i6], f2 + (rectF.width() / 2.0f), (float) this.fontBaseLine, this.titlePaint);
                    }
                    if (i7 != 0) {
                        int i10 = this.barBottom;
                        rectF.top = (float) (i10 - ((i7 * i10) / this.maxValue));
                        rectF.bottom = (float) i10;
                        float height2 = rectF.height();
                        int i11 = this.leastHeight;
                        if (height2 < ((float) i11)) {
                            rectF.top = (float) (this.barBottom - i11);
                        }
                        if (i6 != 0) {
                            this.barPaint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), rectF.height(), this.barTopColor, this.barBottomColor, Shader.TileMode.MIRROR));
                            canvas.drawRoundRect(rectF, 10.0f, 10.0f, this.barPaint);
                        }
                    }
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        this.barWidth = dp2px(6.0f);
        int dp2px = dp2px(12.0f);
        this.barLeftRightMargin = dp2px;
        this.barStep = ((size - (dp2px * 2)) - this.barWidth) / 24;
        this.fontHeight = getFontHeight((float) this.fontSize);
        this.xTextMarginTop = dp2px(8.0f);
        int dp2px2 = dp2px(4.0f);
        this.barMarginBottom = dp2px2;
        int i3 = mBarAreaHeight;
        int i4 = this.xAxislineHeight;
        int i5 = this.xTextMarginTop;
        int i6 = this.fontHeight;
        int i7 = i3 + i4 + i5 + i6;
        this.barBottom = (((i7 - i6) - i5) - dp2px2) - i4;
        this.xAxisHeight = (i7 - i6) - i5;
        this.fontBaseLine = i7 - ((int) this.fm.descent);
        setMeasuredDimension(size, i7);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int width = (getWidth() - dp2px(30.0f)) / 8;
        int x = (int) motionEvent.getX();
        int i = 0;
        while (i < 7) {
            int i2 = i + 1;
            int i3 = width * i2;
            if (x > (dp2px(15.0f) + i3) - dp2px(15.0f) && x < dp2px(15.0f) + i3 + dp2px(15.0f)) {
                this.text[i] = 1;
                for (int i4 = 0; i4 < 7; i4++) {
                    if (i != i4) {
                        this.text[i4] = 0;
                    }
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    invalidate();
                } else {
                    postInvalidate();
                }
            }
            i = i2;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBarAreaHeight(int i) {
        mBarAreaHeight = i;
    }

    public void setMaxValue(int i) {
        this.maxValue = i;
    }

    public void setValues(int[] iArr, boolean z) {
        int i = 1;
        if (iArr.length > this.progress.length - 1) {
            Logs.e("data.length > progress.length - 1");
            return;
        }
        int i2 = 0;
        if (!z) {
            i = 0;
            i2 = 1;
        }
        while (i < iArr.length) {
            int i3 = iArr[i];
            int i4 = this.maxValue;
            if (i3 > i4) {
                this.progress[i + i2] = i4;
            } else {
                this.progress[i + i2] = i3;
            }
            i++;
        }
    }

    public void showAnimation() {
        this.runningAnimation = true;
        startAnimation(this.animation);
    }

    public BarChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
