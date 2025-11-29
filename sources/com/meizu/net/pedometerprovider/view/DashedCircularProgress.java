package com.meizu.net.pedometerprovider.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.net.pedometerprovider.R;
import com.meizu.net.pedometerprovider.util.Constants;
import com.meizu.net.pedometerprovider.util.Logs;

public class DashedCircularProgress extends RelativeLayout {
    public int Id;
    private int duration = 1000;
    private int externalColor = -1;
    private int heightNormalittation = 0;
    private int internalBaseColor = -256;
    protected InternalCirclePainter internalCirclePainter;
    private Interpolator interpolator = PathInterpolatorCompat.a(0.3f, 0.0f, 0.2f, 1.0f);
    /* access modifiers changed from: private */
    public float last = 0.0f;
    protected float max = 5000.0f;
    protected float min = 0.0f;
    private int padingTop = 0;
    protected int progressColor = -1;
    protected ProgressPainter progressPainter;
    protected int progressStrokeHeight = 48;
    private float value;
    private ValueAnimator valueAnimator;
    /* access modifiers changed from: private */
    public OnValueChangeListener valueChangeListener;

    public interface OnValueChangeListener {
        void onValueChange(float f);
    }

    public class ValueAnimatorListenerImp implements ValueAnimator.AnimatorUpdateListener {
        private ValueAnimatorListenerImp() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f = (Float) valueAnimator.getAnimatedValue();
            DashedCircularProgress.this.progressPainter.setValue(f.floatValue());
            if (DashedCircularProgress.this.valueChangeListener != null) {
                DashedCircularProgress.this.valueChangeListener.onValueChange(f.floatValue());
            }
            float unused = DashedCircularProgress.this.last = f.floatValue();
            DashedCircularProgress.this.invalidate();
        }
    }

    public DashedCircularProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void animateValue() {
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setFloatValues(new float[]{this.last, this.value});
            this.valueAnimator.setDuration((long) this.duration);
            this.valueAnimator.addUpdateListener(new ValueAnimatorListenerImp());
            this.valueAnimator.start();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DashedCircularProgress);
        initAttributes(obtainStyledAttributes);
        initPainters();
        initValueAnimator();
        obtainStyledAttributes.recycle();
    }

    private void initAttributes(TypedArray typedArray) {
        this.externalColor = typedArray.getColor(R.styleable.DashedCircularProgress_external_color, this.externalColor);
        this.internalBaseColor = typedArray.getColor(R.styleable.DashedCircularProgress_base_color, this.internalBaseColor);
        this.progressColor = typedArray.getColor(R.styleable.DashedCircularProgress_progress_color, this.progressColor);
        this.max = typedArray.getFloat(R.styleable.DashedCircularProgress_max, this.max);
        this.duration = Constants.ANIMATION_DURATION;
        this.progressStrokeHeight = typedArray.getDimensionPixelSize(R.styleable.DashedCircularProgress_progress_stroke_height, this.progressStrokeHeight);
    }

    private void initValueAnimator() {
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.valueAnimator = valueAnimator2;
        valueAnimator2.setInterpolator(this.interpolator);
        this.valueAnimator.addUpdateListener(new ValueAnimatorListenerImp());
    }

    public void clearData() {
        clearAnimation();
        if (this.valueAnimator != null) {
            Logs.d("valueAnimator.cancel()  id  = " + this.Id);
            this.valueAnimator.removeAllUpdateListeners();
            this.valueAnimator.cancel();
        }
        this.value = 0.0f;
        this.last = 0.0f;
        this.progressPainter.setValue(0.0f);
        invalidate();
    }

    public int getDuration() {
        return this.duration;
    }

    public int getExternalColor() {
        return this.externalColor;
    }

    public int getInternalBaseColor() {
        return this.internalBaseColor;
    }

    public float getMax() {
        return this.max;
    }

    public float getMin() {
        return this.min;
    }

    public int getProgressColor() {
        return this.progressColor;
    }

    public ProgressPainter getProgressPainter() {
        return new ProgressPainterImp(this.progressColor, this.min, this.max, this.progressStrokeHeight);
    }

    public void initPainters() {
        this.progressPainter = getProgressPainter();
        this.internalCirclePainter = new InternalCirclePainterImp(this.internalBaseColor, (float) this.progressStrokeHeight, 0.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Logs.d(" onDraw width =" + getWidth() + " heigth = " + getHeight());
        this.internalCirclePainter.draw(canvas);
        this.progressPainter.draw(canvas);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2 + this.heightNormalittation);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.progressPainter.onSizeChanged(i2, i);
        this.internalCirclePainter.onSizeChanged(i2, i);
    }

    public void reset() {
        this.last = this.min;
    }

    public void setCircleBitmap(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.internalCirclePainter.setCircleBitmap(bitmap, bitmap3);
        this.progressPainter.setCircleBitmap(bitmap2, bitmap3);
    }

    public void setExternalColor(int i) {
    }

    public void setIcon(int i) {
    }

    public void setInternalBaseColor(int i) {
        this.internalBaseColor = i;
        this.internalCirclePainter.setColor(this.progressColor);
    }

    public void setInterpolator(Interpolator interpolator2) {
        this.interpolator = interpolator2;
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setInterpolator(interpolator2);
        }
    }

    public void setMax(float f) {
        this.max = f;
        this.progressPainter.setMax(f);
    }

    public void setMin(float f) {
        this.min = f;
        this.progressPainter.setMin(f);
    }

    public void setOnValueChangeListener(OnValueChangeListener onValueChangeListener) {
        this.valueChangeListener = onValueChangeListener;
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
        this.progressPainter.setColor(i);
    }

    public void setValue(float f) {
        setValue(f, false);
        invalidate();
    }

    public void setValue(float f, boolean z) {
        this.value = f;
        if (!z || (f > this.max && f < this.min)) {
            ValueAnimator valueAnimator2 = this.valueAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.setFloatValues(new float[]{this.last, f});
            }
            this.progressPainter.setValue(f);
            return;
        }
        animateValue();
    }

    public DashedCircularProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
