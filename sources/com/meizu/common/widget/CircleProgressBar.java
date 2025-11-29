package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public class CircleProgressBar extends View {
    public static final int BAR_COLOR_DEF = -15102483;
    public static final float BAR_WIDTH_DEF_DIP = 3.0f;
    public static final int CENTER_TEXT_COLOR_DEF = -1;
    public static final int CENTER_TEXT_SIZE_DEF = 14;
    public static final int RIM_COLOR_DEF = 201326592;
    private int mBarColor;
    private Paint mBarPaint;
    private int mBarPostition;
    private float mBarWidth;
    private RectF mCircleBound;
    private boolean mIsShowProgress;
    private int mMax;
    private int mPercentage;
    private int mProgress;
    private int mRimColor;
    private Paint mRimPaint;
    private boolean mShouldUpdateBound;
    private String mText;
    private int mTextColor;
    private Paint mTextPaint;
    private int mTextSize;

    public CircleProgressBar(Context context) {
        super(context, (AttributeSet) null);
        this.mBarPostition = 0;
        this.mBarPaint = new Paint();
        this.mRimPaint = new Paint();
        this.mTextPaint = new Paint();
        this.mCircleBound = new RectF();
        this.mTextSize = 0;
        this.mText = "0%";
        this.mPercentage = 0;
        this.mShouldUpdateBound = false;
        this.mIsShowProgress = true;
    }

    private int getPosByProgress(int i, boolean z) {
        int i2 = z ? 180 : 100;
        int i3 = this.mMax;
        if (i3 <= 0) {
            return 0;
        }
        return i >= i3 ? i2 : (int) ((((float) i) / ((float) i3)) * ((float) i2));
    }

    private void init() {
        setBound();
        setPaint();
        this.mBarPostition = getPosByProgress(this.mProgress, true);
        this.mPercentage = getPosByProgress(this.mProgress, false);
        this.mText = String.valueOf(this.mPercentage) + "%";
    }

    private void setBound() {
        if (this.mCircleBound == null) {
            this.mCircleBound = new RectF();
        }
        this.mCircleBound.left = ((float) getPaddingLeft()) + this.mBarWidth;
        this.mCircleBound.top = ((float) getPaddingTop()) + this.mBarWidth;
        this.mCircleBound.right = ((float) (getWidth() - getPaddingRight())) - this.mBarWidth;
        this.mCircleBound.bottom = ((float) (getHeight() - getPaddingBottom())) - this.mBarWidth;
    }

    private void setPaint() {
        if (this.mBarPaint == null) {
            this.mBarPaint = new Paint();
        }
        this.mBarPaint.setColor(this.mBarColor);
        this.mBarPaint.setAntiAlias(true);
        Paint paint = this.mBarPaint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.mBarPaint.setStrokeWidth(this.mBarWidth);
        this.mBarPaint.setStrokeJoin(Paint.Join.ROUND);
        if (this.mRimPaint == null) {
            this.mRimPaint = new Paint();
        }
        this.mRimPaint.setColor(this.mRimColor);
        this.mRimPaint.setAntiAlias(true);
        this.mRimPaint.setStyle(style);
        this.mRimPaint.setStrokeWidth(this.mBarWidth);
        if (this.mTextPaint == null) {
            this.mTextPaint = new Paint();
        }
        this.mTextPaint.setTextSize((float) this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setAntiAlias(true);
    }

    public int getMax() {
        int i = this.mMax;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int getProgress() {
        int i = this.mProgress;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public void onDraw(Canvas canvas) {
        if (this.mShouldUpdateBound) {
            setBound();
            this.mShouldUpdateBound = false;
        }
        canvas.drawArc(this.mCircleBound, 360.0f, 360.0f, false, this.mRimPaint);
        RectF rectF = this.mCircleBound;
        int i = this.mBarPostition;
        canvas.drawArc(rectF, (float) (i + 90), (float) (i * -2), false, this.mBarPaint);
        float descent = ((this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f) - this.mTextPaint.descent();
        float measureText = this.mTextPaint.measureText(this.mText) / 2.0f;
        if (this.mIsShowProgress) {
            canvas.drawText(this.mText, ((float) (getWidth() / 2)) - measureText, ((float) (getHeight() / 2)) + descent, this.mTextPaint);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircleProgressBar.class.getName());
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mShouldUpdateBound = true;
    }

    public void setCircleBarColor(int i) {
        if (this.mBarColor != i) {
            this.mBarColor = i;
            this.mBarPaint.setColor(i);
            postInvalidate();
        }
    }

    public void setCircleBarWidth(float f) {
        if (((double) Math.abs(this.mBarWidth - f)) >= 1.0E-6d) {
            if (f < 0.0f) {
                this.mBarWidth = 0.0f;
            } else {
                this.mBarWidth = f;
            }
            this.mBarPaint.setStrokeWidth(this.mBarWidth);
            this.mRimPaint.setStrokeWidth(this.mBarWidth);
            this.mShouldUpdateBound = true;
            postInvalidate();
        }
    }

    public void setCircleRimColor(int i) {
        if (this.mRimColor != i) {
            this.mRimColor = i;
            this.mRimPaint.setColor(i);
            postInvalidate();
        }
    }

    public void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.mMax) {
            this.mMax = i;
            if (this.mProgress > i) {
                this.mProgress = i;
            }
            postInvalidate();
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        int i2 = this.mMax;
        if (i > i2) {
            i = i2;
        }
        if (i != this.mProgress) {
            this.mProgress = i;
            this.mBarPostition = getPosByProgress(i, true);
            this.mPercentage = getPosByProgress(this.mProgress, false);
            this.mText = String.valueOf(this.mPercentage) + "%";
            postInvalidate();
        }
    }

    public void setProgressStatus(boolean z) {
        this.mIsShowProgress = z;
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBarPostition = 0;
        this.mBarPaint = new Paint();
        this.mRimPaint = new Paint();
        this.mTextPaint = new Paint();
        this.mCircleBound = new RectF();
        this.mTextSize = 0;
        this.mText = "0%";
        this.mPercentage = 0;
        this.mShouldUpdateBound = false;
        this.mIsShowProgress = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar, i, 0);
        this.mBarColor = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_mcCircleBarColor, BAR_COLOR_DEF);
        this.mRimColor = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_mcCircleBarRimColor, RIM_COLOR_DEF);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mBarWidth = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_mcCircleBarWidth, (int) (displayMetrics.density * 3.0f));
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_mcCenterTextSize, (int) (displayMetrics.density * 14.0f));
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_mcCenterTextColor, -1);
        this.mIsShowProgress = obtainStyledAttributes.getBoolean(R.styleable.CircleProgressBar_mcCircleIsShowProgress, this.mIsShowProgress);
        setMax(obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_mcCircleBarMax, 0));
        setProgress(obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_mcCircleBarProgress, 0));
        obtainStyledAttributes.recycle();
        init();
    }
}
