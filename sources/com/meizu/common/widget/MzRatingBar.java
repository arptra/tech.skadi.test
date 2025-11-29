package com.meizu.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.RatingBar;
import com.meizu.common.R;
import com.meizu.common.interpolator.PathInterpolatorCompat;

public class MzRatingBar extends RatingBar implements GestureDetector.OnGestureListener {
    private int currentIndex;
    private boolean hasInitialNum;
    private int lastIndex;
    private ValueAnimator mAnimaotr;
    /* access modifiers changed from: private */
    public float[] mBackScales;
    private GestureDetector mDector;
    private int mLastLayoutDirection;
    private PathInterpolatorCompat mScaleDownInt;
    private PathInterpolatorCompat mScaleUpInt;
    /* access modifiers changed from: private */
    public float[] mScales;
    private int[] mStarColors;
    private Drawable mStarDrawable;
    /* access modifiers changed from: private */
    public int scaleDownTime;
    /* access modifiers changed from: private */
    public int scaleUpTime;
    private float starWidth;
    private int sumTime;

    public MzRatingBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void backUpRange(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mBackScales[i2] = this.mScales[i2];
        }
    }

    private int calculateCureentIndex() {
        return Math.min((int) ((((float) getProgressPos()) / this.starWidth) + 0.5f), getNumStars());
    }

    private int getProgressPos() {
        return ((int) ((getScale() * ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight()))) + 0.5f)) + getPaddingLeft();
    }

    private float getScale() {
        int max = getMax();
        if (max > 0) {
            return ((float) getProgress()) / ((float) max);
        }
        return 0.0f;
    }

    private void initScales() {
        int i = 0;
        while (true) {
            float[] fArr = this.mScales;
            if (i < fArr.length) {
                fArr[i] = 0.0f;
                i++;
            } else {
                return;
            }
        }
    }

    private void resetBackUp(int i, int i2) {
        if (i != i2) {
            while (i < i2) {
                this.mBackScales[i] = 0.0f;
                i++;
            }
        }
    }

    private void setEnd(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mScales[i2] = (float) (this.scaleUpTime + this.scaleDownTime + (i2 * 16));
        }
    }

    private void startAnimation() {
        if (this.mAnimaotr == null) {
            this.sumTime = this.scaleUpTime + this.scaleDownTime + (getNumStars() * 16);
            new ValueAnimator();
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.sumTime});
            this.mAnimaotr = ofInt;
            ofInt.setDuration((long) this.sumTime);
            this.mAnimaotr.setInterpolator(new LinearInterpolator());
            this.mAnimaotr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float intValue = (float) ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    for (int i = 0; i < MzRatingBar.this.getNumStars(); i++) {
                        MzRatingBar.this.mScales[i] = Math.min(Math.max(0.0f, (MzRatingBar.this.mBackScales[i] + intValue) - (((float) i) * 16.0f)), (float) (MzRatingBar.this.scaleUpTime + MzRatingBar.this.scaleDownTime));
                    }
                    MzRatingBar.this.invalidate();
                }
            });
        }
        this.mAnimaotr.start();
    }

    public float getRating() {
        float rating = super.getRating();
        return this.hasInitialNum ? rating : (float) ((int) Math.ceil((double) rating));
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (isIndicator()) {
            return false;
        }
        if (this.hasInitialNum) {
            setEnd(Math.min(this.lastIndex, getNumStars()));
        }
        backUpRange(this.lastIndex);
        resetBackUp(Math.min(this.lastIndex, getNumStars()), getNumStars());
        int calculateCureentIndex = calculateCureentIndex();
        this.currentIndex = calculateCureentIndex;
        this.lastIndex = calculateCureentIndex;
        this.hasInitialNum = false;
        startAnimation();
        return false;
    }

    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int i = 0;
            boolean z = getLayoutDirection() == 1;
            if (!(this.mStarDrawable == null || this.mStarColors == null)) {
                canvas.save();
                if (z) {
                    canvas.clipRect(((float) getWidth()) - ((this.hasInitialNum ? getRating() : (float) this.currentIndex) * this.starWidth), 0.0f, (float) getWidth(), (float) getHeight());
                } else {
                    canvas.clipRect(0.0f, 0.0f, (this.hasInitialNum ? getRating() : (float) this.currentIndex) * this.starWidth, (float) getHeight());
                }
                int paddingLeft = !z ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mStarDrawable.getIntrinsicWidth();
                int paddingTop = getPaddingTop();
                while (i < getNumStars()) {
                    int[] iArr = this.mStarColors;
                    this.mStarDrawable.setColorFilter(i >= iArr.length ? iArr[iArr.length - 1] : iArr[i], PorterDuff.Mode.SRC_IN);
                    Rect rect = new Rect(paddingLeft, paddingTop, this.mStarDrawable.getIntrinsicWidth() + paddingLeft, this.mStarDrawable.getIntrinsicHeight() + paddingTop);
                    this.mStarDrawable.setBounds(rect);
                    paddingLeft = z ? paddingLeft - this.mStarDrawable.getIntrinsicWidth() : paddingLeft + this.mStarDrawable.getIntrinsicWidth();
                    canvas.save();
                    if (!this.hasInitialNum) {
                        float f = this.mScales[i];
                        int i2 = this.scaleUpTime;
                        float interpolation = f < ((float) i2) ? (this.mScaleUpInt.getInterpolation(f / ((float) i2)) * 0.92999995f) + 0.1f : ((1.0f - this.mScaleDownInt.getInterpolation((f - ((float) i2)) / ((float) this.scaleDownTime))) * 0.03f) + 1.0f;
                        float f2 = 1.0f - interpolation;
                        canvas.translate((((float) ((z ? (this.mScales.length - 1) - i : i) * rect.width())) * f2) + (((float) rect.width()) * f2 * 0.5f), ((float) rect.height()) * f2 * 0.5f);
                        canvas.scale(interpolation, interpolation);
                    }
                    this.mStarDrawable.draw(canvas);
                    canvas.restore();
                    i++;
                }
                canvas.restore();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int calculateCureentIndex = calculateCureentIndex();
        this.currentIndex = calculateCureentIndex;
        int i = this.lastIndex;
        if (calculateCureentIndex - i > 0) {
            backUpRange(i);
            resetBackUp(Math.min(this.currentIndex - 1, getNumStars()), getNumStars());
            initScales();
            this.mAnimaotr.cancel();
            startAnimation();
        } else {
            backUpRange(calculateCureentIndex);
            resetBackUp(Math.min(this.lastIndex, getNumStars()), getNumStars());
        }
        this.lastIndex = this.currentIndex;
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.mDector.onTouchEvent(motionEvent);
        return onTouchEvent;
    }

    public void setRating(float f) {
        super.setRating(f);
        this.hasInitialNum = true;
        int min = Math.min(getNumStars(), (int) Math.ceil((double) f));
        this.currentIndex = min;
        this.lastIndex = min;
    }

    public void setStarColors(int[] iArr) {
        if (iArr != null) {
            this.mStarColors = iArr;
        }
    }

    public MzRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_MzRatingBarStyle);
    }

    public MzRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.lastIndex = 0;
        this.hasInitialNum = false;
        this.mScaleUpInt = new PathInterpolatorCompat(0.2f, 0.04f, 0.08f, 1.0f);
        this.mScaleDownInt = new PathInterpolatorCompat(0.35f, 0.56f, 0.0f, 1.0f);
        this.sumTime = 0;
        this.scaleUpTime = 220;
        this.scaleDownTime = 280;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzRatingBar, i, 0);
        this.mStarColors = getResources().getIntArray(obtainStyledAttributes.getResourceId(R.styleable.MzRatingBar_mcStarColors, R.array.mc_rating_bar_default_colors));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.MzRatingBar_mcStarDrawable);
        this.mStarDrawable = drawable;
        if (drawable == null) {
            this.mStarDrawable = getResources().getDrawable(R.drawable.mz_btn_big_star);
        }
        this.starWidth = (float) this.mStarDrawable.getIntrinsicWidth();
        obtainStyledAttributes.recycle();
        if (0.0f != getRating()) {
            int rating = (int) getRating();
            this.currentIndex = rating;
            this.lastIndex = rating;
            this.hasInitialNum = true;
        }
        this.mDector = new GestureDetector(context, this);
        this.mScales = new float[getNumStars()];
        this.mBackScales = new float[getNumStars()];
        initScales();
        try {
            if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
                BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", new Class[]{Boolean.TYPE}).invoke(this.mStarDrawable, new Object[]{Boolean.FALSE});
            }
        } catch (Exception unused) {
            Log.e("MzRatingBar", "NightMode methods reflected failed!");
        }
    }
}
