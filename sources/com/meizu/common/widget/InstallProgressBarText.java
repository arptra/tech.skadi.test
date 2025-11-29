package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.meizu.common.R;
import java.util.Locale;

public class InstallProgressBarText extends View {
    private ObjectAnimator mObjectAnimator;
    private Paint mPaint;
    private float mProgress;
    private int mRealWidth;
    private String mText = null;
    private Rect mTextBound = new Rect();
    private int mTextCenterX = 0;
    private int mTextChangeColor = -1;
    private int mTextOriginColor = -16777216;
    private int mTextSize = getResources().getDimensionPixelOffset(R.dimen.online_theme_download_install_font_size);
    private int mTextStartX = 0;
    private int mTextWidth;

    public InstallProgressBarText(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void drawChangeLeft(Canvas canvas) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i = this.mTextChangeColor;
            int i2 = this.mTextStartX;
            int i3 = this.mRealWidth;
            drawText(canvas, i, i2 + i3, (int) (((float) (i2 + i3)) - (this.mProgress * ((float) i3))));
            return;
        }
        int i4 = this.mTextChangeColor;
        int i5 = this.mTextStartX;
        drawText(canvas, i4, i5, (int) (((float) i5) + (this.mProgress * ((float) this.mRealWidth))));
    }

    private void drawOriginLeft(Canvas canvas) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i = this.mTextOriginColor;
            int i2 = this.mTextStartX;
            int i3 = this.mRealWidth;
            drawText(canvas, i, (int) (((float) (i2 + i3)) - (this.mProgress * ((float) i3))), i2);
            return;
        }
        int i4 = this.mTextOriginColor;
        int i5 = this.mTextStartX;
        float f = this.mProgress;
        int i6 = this.mRealWidth;
        drawText(canvas, i4, (int) (((float) i5) + (f * ((float) i6))), i5 + i6);
    }

    private void drawText(Canvas canvas, int i, int i2, int i3) {
        this.mPaint.setColor(i);
        canvas.save();
        canvas.clipRect(i2, 0, i3, getMeasuredHeight());
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int i4 = fontMetricsInt.top;
        canvas.drawText(this.mText, (float) this.mTextCenterX, (float) ((((getMeasuredHeight() - fontMetricsInt.bottom) + i4) / 2) - i4), this.mPaint);
        canvas.restore();
    }

    private ObjectAnimator getProgressAnimtot(float f) {
        float f2 = this.mProgress;
        if (f < f2) {
            return ObjectAnimator.ofFloat(this, "Progress", new float[]{0.0f, f}).setDuration(500);
        }
        return ObjectAnimator.ofFloat(this, "Progress", new float[]{f2, f}).setDuration(500);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mPaint = new Paint(1);
        this.mPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        initAttributes(context, attributeSet);
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = getTypedArray(context, attributeSet, R.styleable.InstallProgressBarText);
        if (typedArray != null) {
            this.mText = typedArray.getString(R.styleable.InstallProgressBarText_mcText);
            this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.InstallProgressBarText_mcProgressTextSize, this.mTextSize);
            this.mTextOriginColor = typedArray.getColor(R.styleable.InstallProgressBarText_mcTextOriginColor, this.mTextOriginColor);
            this.mTextChangeColor = typedArray.getColor(R.styleable.InstallProgressBarText_mcTextChangeColor, this.mTextChangeColor);
            this.mProgress = typedArray.getFloat(R.styleable.InstallProgressBarText_mcTextProgress, 0.0f);
            typedArray.recycle();
        }
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int height = (mode == Integer.MIN_VALUE || mode == 0) ? this.mTextBound.height() * 2 : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            height = Math.min(height, size);
        }
        return height + getPaddingTop() + getPaddingBottom();
    }

    private void measureText() {
        this.mTextWidth = (int) this.mPaint.measureText(this.mText);
        Paint paint = this.mPaint;
        String str = this.mText;
        paint.getTextBounds(str, 0, str.length(), this.mTextBound);
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i2 = (mode == Integer.MIN_VALUE || mode == 0) ? this.mTextWidth : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        return i2 + getPaddingLeft() + getPaddingRight();
    }

    private int sp2px(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void cancelProgressAnimator() {
        ObjectAnimator objectAnimator = this.mObjectAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mObjectAnimator.cancel();
        }
    }

    public float getProgress() {
        return this.mProgress;
    }

    public String getText() {
        return this.mText;
    }

    public int getTextChangeColor() {
        return this.mTextChangeColor;
    }

    public int getTextOriginColor() {
        return this.mTextOriginColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawChangeLeft(canvas);
        drawOriginLeft(canvas);
    }

    public void onMeasure(int i, int i2) {
        measureText();
        this.mPaint.setTextSize((float) this.mTextSize);
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mRealWidth = measuredWidth;
        this.mTextCenterX = (measuredWidth / 2) - (this.mTextWidth / 2);
        invalidate();
    }

    public void resetTextColor() {
        this.mProgress = 1.0f;
        invalidate();
    }

    public synchronized void setAnimProgress(float f) {
        ObjectAnimator progressAnimtot = getProgressAnimtot(f);
        this.mObjectAnimator = progressAnimtot;
        progressAnimtot.start();
    }

    public void setProgress(float f) {
        this.mProgress = f;
        invalidate();
    }

    public void setText(String str) {
        this.mText = str;
        requestLayout();
        invalidate();
    }

    public void setTextChangeColor(int i) {
        this.mTextChangeColor = i;
        invalidate();
    }

    public void setTextOriginColor(int i) {
        this.mTextOriginColor = i;
        invalidate();
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
        requestLayout();
        invalidate();
    }

    public InstallProgressBarText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public InstallProgressBarText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
